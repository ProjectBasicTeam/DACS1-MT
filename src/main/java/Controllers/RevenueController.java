package Controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import Services.StatisticManagers;
import Views.Revenue;

public class RevenueController {
    private Revenue view;
    private StatisticManagers ser;

    public RevenueController(Revenue view) {
        this.view = view;
        this.ser = StatisticManagers.getInstance();
        loadData();

        // Gán hành động cho các nút
        view.getBtnweek().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWeeklyChart();
            }
        });

        view.getBtnmonth().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMonthlyChart();
            }
        });

        view.getBtnyear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateYearlyChart();
            }
        });

        // Hiển thị biểu đồ mặc định (tuần) khi khởi động
        updateWeeklyChart();
    }

    private void loadData() {
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> {
                    // Tổng doanh thu tất cả
                    long totalRevenue = ser.gettotalprice();
                    if (totalRevenue < 0) {
                        view.getLball().setText(String.format("%,d", totalRevenue) + " (VNĐ)");
                        view.getLball().setForeground(new Color(255, 8, 8));
                    } else {
                        view.getLball().setText("+ " + String.format("%,d", totalRevenue) + " (VNĐ)");
                        view.getLball().setForeground(new Color(15, 169, 96));
                    }

                    // Tổng doanh thu tuần này
                    long revenueThisWeek = ser.getRevenueThisWeek();
                    if (revenueThisWeek < 0) {
                        view.getLblweek().setText(String.format("%,d", revenueThisWeek) + " (VNĐ)");
                        view.getLblweek().setForeground(new Color(255, 8, 8));
                    } else {
                        view.getLblweek().setText("+ " + String.format("%,d", revenueThisWeek) + " (VNĐ)");
                        view.getLblweek().setForeground(new Color(15, 169, 96));
                    }

                    // Tổng doanh thu tháng này
                    long revenueThisMonth = ser.getRevenueThisMonth();
                    if (revenueThisMonth < 0) {
                        view.getLbmonth().setText(String.format("%,d", revenueThisMonth) + " (VNĐ)");
                        view.getLbmonth().setForeground(new Color(255, 8, 8));
                    } else {
                        view.getLbmonth().setText("+ " + String.format("%,d", revenueThisMonth) + " (VNĐ)");
                        view.getLbmonth().setForeground(new Color(15, 169, 96));
                    }

                    // Tổng doanh thu năm nay
                    long revenueThisYear = ser.getRevenueThisYear();
                    if (revenueThisYear < 0) {
                        view.getLbyear().setText(String.format("%,d", revenueThisYear) + " (VNĐ)");
                        view.getLbyear().setForeground(new Color(255, 8, 8));
                    } else {
                        view.getLbyear().setText("+ " + String.format("%,d", revenueThisYear) + " (VNĐ)");
                        view.getLbyear().setForeground(new Color(15, 169, 96));
                    }
                });

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Hiển thị biểu đồ cột doanh thu theo ngày trong tuần hiện tại
    private void updateWeeklyChart() {
        Map<String, Double> dailyRevenue = ser.getDailyRevenueThisWeek();

        // Tạo tập dữ liệu cho biểu đồ cột
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : daysOfWeek) {
            dataset.addValue(dailyRevenue.getOrDefault(day, 0.0), "Doanh thu", day);
        }

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo ngày trong tuần", // Tiêu đề biểu đồ
            "Ngày",                          // Nhãn trục X
            "Doanh thu (VNĐ)",               // Nhãn trục Y
            dataset                          // Tập dữ liệu
        );

        // Tùy chỉnh biểu đồ
        chart.setBackgroundPaint(new Color(255, 255, 255));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // Tùy chỉnh cột
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(15, 169, 96)); // Màu xanh lá cây
        renderer.setDrawBarOutline(false);
        renderer.setBarPainter(new StandardBarPainter());

        // Thêm nhãn giá trị trên mỗi cột
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(
            "{2}", new DecimalFormat("#,##0")
        ));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultPositiveItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER
        ));
        renderer.setDefaultNegativeItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER
        ));

        // Đảm bảo trục Y bao gồm 0
        try {
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.getClass().getMethod("setAutoRangeIncludesZero", boolean.class)
                    .invoke(rangeAxis, true);
        } catch (Exception e) {
            double minRevenue = dailyRevenue.values().stream().min(Double::compare).orElse(0.0);
            double maxRevenue = dailyRevenue.values().stream().max(Double::compare).orElse(0.0);
            double lowerBound = Math.min(minRevenue, 0);
            double upperBound = Math.max(maxRevenue, 0);
            double padding = (upperBound - lowerBound) * 0.1;
            plot.getRangeAxis().setRange(lowerBound - padding, upperBound + padding);
        }

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1255, 629));
        chartPanel.setBackground(new Color(255, 255, 255));

        // Cập nhật panel pnchartdt
        view.getPnchartdt().removeAll();
        view.getPnchartdt().setLayout(new java.awt.BorderLayout());
        view.getPnchartdt().add(chartPanel, java.awt.BorderLayout.CENTER);
        view.getPnchartdt().setBackground(new Color(255, 255, 255));
        view.getPnchartdt().revalidate();
        view.getPnchartdt().repaint();
    }

    // Hiển thị biểu đồ cột doanh thu theo ngày trong tháng hiện tại
    private void updateMonthlyChart() {
        Map<Integer, Double> dailyRevenue = ser.getDailyRevenueThisMonth();

        // Tạo tập dữ liệu cho biểu đồ cột
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Double> entry : dailyRevenue.entrySet()) {
            dataset.addValue(entry.getValue(), "Doanh thu", String.valueOf(entry.getKey()));
        }

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo ngày trong tháng", // Tiêu đề biểu đồ
            "Ngày",                           // Nhãn trục X
            "Doanh thu (VNĐ)",                // Nhãn trục Y
            dataset                           // Tập dữ liệu
        );

        // Tùy chỉnh biểu đồ
        chart.setBackgroundPaint(new Color(255, 255, 255));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // Tùy chỉnh cột
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(15, 169, 96));
        renderer.setDrawBarOutline(false);
        renderer.setBarPainter(new StandardBarPainter());

        // Thêm nhãn giá trị trên mỗi cột
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(
            "{2}", new DecimalFormat("#,##0")
        ));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultPositiveItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER
        ));
        renderer.setDefaultNegativeItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER
        ));

        // Đảm bảo trục Y bao gồm 0
        try {
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.getClass().getMethod("setAutoRangeIncludesZero", boolean.class)
                    .invoke(rangeAxis, true);
        } catch (Exception e) {
            double minRevenue = dailyRevenue.values().stream().min(Double::compare).orElse(0.0);
            double maxRevenue = dailyRevenue.values().stream().max(Double::compare).orElse(0.0);
            double lowerBound = Math.min(minRevenue, 0);
            double upperBound = Math.max(maxRevenue, 0);
            double padding = (upperBound - lowerBound) * 0.1;
            plot.getRangeAxis().setRange(lowerBound - padding, upperBound + padding);
        }

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1255, 629));
        chartPanel.setBackground(new Color(255, 255, 255));

        // Cập nhật panel pnchartdt
        view.getPnchartdt().removeAll();
        view.getPnchartdt().setLayout(new java.awt.BorderLayout());
        view.getPnchartdt().add(chartPanel, java.awt.BorderLayout.CENTER);
        view.getPnchartdt().setBackground(new Color(255, 255, 255));
        view.getPnchartdt().revalidate();
        view.getPnchartdt().repaint();
    }

    // Hiển thị biểu đồ cột doanh thu theo tháng trong năm hiện tại
    private void updateYearlyChart() {
        Map<Integer, Double> monthlyRevenue = ser.getMonthlyRevenueThisYear();

        // Tạo tập dữ liệu cho biểu đồ cột
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Double> entry : monthlyRevenue.entrySet()) {
            dataset.addValue(entry.getValue(), "Doanh thu", String.valueOf(entry.getKey()));
        }

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo tháng trong năm", // Tiêu đề biểu đồ
            "Tháng",                         // Nhãn trục X
            "Doanh thu (VNĐ)",               // Nhãn trục Y
            dataset                          // Tập dữ liệu
        );

        // Tùy chỉnh biểu đồ
        chart.setBackgroundPaint(new Color(255, 255, 255));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // Tùy chỉnh cột
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(15, 169, 96));
        renderer.setDrawBarOutline(false);
        renderer.setBarPainter(new StandardBarPainter());

        // Thêm nhãn giá trị trên mỗi cột
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(
            "{2}", new DecimalFormat("#,##0")
        ));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultPositiveItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER
        ));
        renderer.setDefaultNegativeItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER
        ));

        // Đảm bảo trục Y bao gồm 0
        try {
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.getClass().getMethod("setAutoRangeIncludesZero", boolean.class)
                    .invoke(rangeAxis, true);
        } catch (Exception e) {
            double minRevenue = monthlyRevenue.values().stream().min(Double::compare).orElse(0.0);
            double maxRevenue = monthlyRevenue.values().stream().max(Double::compare).orElse(0.0);
            double lowerBound = Math.min(minRevenue, 0);
            double upperBound = Math.max(maxRevenue, 0);
            double padding = (upperBound - lowerBound) * 0.1;
            plot.getRangeAxis().setRange(lowerBound - padding, upperBound + padding);
        }

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1255, 629));
        chartPanel.setBackground(new Color(255, 255, 255));

        // Cập nhật panel pnchartdt
        view.getPnchartdt().removeAll();
        view.getPnchartdt().setLayout(new java.awt.BorderLayout());
        view.getPnchartdt().add(chartPanel, java.awt.BorderLayout.CENTER);
        view.getPnchartdt().setBackground(new Color(255, 255, 255));
        view.getPnchartdt().revalidate();
        view.getPnchartdt().repaint();
    }
}