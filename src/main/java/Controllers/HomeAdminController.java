package Controllers;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Models.ProfitM;
import Services.StatisticManagers;
import Views.HomeAdmin;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomeAdminController {
    private HomeAdmin view;
    private StatisticManagers ser;
    private long profit;

    public HomeAdminController(HomeAdmin view) {
        this.view = view;
        this.ser = StatisticManagers.getInstance();
        Loaddata();
        addListeners();
    }

    public void Loadprofitdata() {
        ArrayList<ProfitM> list = ser.loadProfit();

        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); 

        for (ProfitM e : list) {
            model.addRow(new Object[]{
                e.getTotalprice(),
                e.getDay()
            });
        }
    }
    
    private void updatePieChart() {
        // Tạo tập dữ liệu cho biểu đồ tròn
        DefaultPieDataset dataset = new DefaultPieDataset();
        long totalPrice = ser.gettotalprice(); // Lấy tổng doanh thu từ StatisticManagers
        long totalFund = ser.gettotalfund();   // Lấy tổng chi phí từ StatisticManagers
        
        // Thêm dữ liệu vào tập dữ liệu: doanh thu và chi phí
        dataset.setValue("Doanh thu (VNĐ)", totalPrice);
        dataset.setValue("Chi phí (VNĐ)", totalFund);

        // Tạo biểu đồ tròn với tiêu đề và các tùy chọn
        JFreeChart chart = ChartFactory.createPieChart(
            "Biểu đồ doanh thu và chi phí", // Tiêu đề của biểu đồ
            dataset,                       // Tập dữ liệu
            true,                          // Hiển thị chú thích (legend)
            true,                          // Hiển thị tooltip
            false                          // Không sử dụng URL
        );

        // Đặt màu nền của biểu đồ thành trắng (RGB: 255, 255, 255)
        chart.setBackgroundPaint(new Color(255, 255, 255)); 

        // Lấy đối tượng PiePlot để tùy chỉnh biểu đồ tròn
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));     // Đặt màu nền của biểu đồ thành trắng
        plot.setLabelBackgroundPaint(new Color(255, 255, 255)); // Đặt màu nền của nhãn thành trắng
        plot.setLabelOutlinePaint(null);                       // Xóa đường viền của nhãn
        plot.setLabelShadowPaint(null);                        // Xóa bóng của nhãn

        // Đặt màu cho các phần của biểu đồ
        plot.setSectionPaint("Doanh thu (VNĐ)", new Color(15, 169, 96)); // Màu xanh lá cho doanh thu
        plot.setSectionPaint("Chi phí (VNĐ)", new Color(255, 8, 8));     // Màu đỏ cho chi phí

        // Hiển thị phần trăm trên các phần của biểu đồ
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
            "{0}: {2}",                    // Định dạng nhãn: Tên: Phần trăm (ví dụ: "Doanh thu (VNĐ): 75.0%")
            new DecimalFormat("#,##0"),    // Định dạng giá trị số
            new DecimalFormat("0.0%")      // Định dạng phần trăm
        ));

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(737, 333)); // Đặt kích thước panel phù hợp với pnchartcycle
        chartPanel.setBackground(new Color(255, 255, 255));           // Đặt màu nền của panel chứa biểu đồ thành trắng

        // Xóa toàn bộ nội dung cũ trong panel pnchartcycle và thêm biểu đồ mới
        view.getPnchartcycle().removeAll();
        view.getPnchartcycle().setLayout(new java.awt.BorderLayout()); // Đặt layout cho panel
        view.getPnchartcycle().add(chartPanel, java.awt.BorderLayout.CENTER); // Thêm biểu đồ vào panel
        view.getPnchartcycle().setBackground(new Color(255, 255, 255)); // Đặt màu nền của panel thành trắng
        view.getPnchartcycle().revalidate(); // Cập nhật lại giao diện
        view.getPnchartcycle().repaint();    // Vẽ lại panel
    }

    
    private void updateColumnChart() {
        // Lấy dữ liệu lợi nhuận hàng tháng từ StatisticManagers
        double[] monthlyProfits = ser.getMonthlyProfits();

        // Tạo tập dữ liệu cho biểu đồ cột
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int month = 0; month < 12; month++) {
            dataset.addValue(monthlyProfits[month], "Lợi nhuận", String.valueOf(month + 1)); // Tháng 1-12
        }

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ lợi nhuận qua các tháng", // Tiêu đề biểu đồ
            "Tháng",                          // Nhãn trục X
            "Lợi nhuận (VNĐ)",                // Nhãn trục Y
            dataset                           // Tập dữ liệu
        );

        // Tùy chỉnh biểu đồ
        chart.setBackgroundPaint(new Color(255, 255, 255)); // Nền trắng

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255)); // Nền biểu đồ trắng
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);     // Đường lưới trục X màu xám nhạt
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);      // Đường lưới trục Y màu xám nhạt

        // Tùy chỉnh cột
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(15, 169, 96)); // Cột màu xanh lá cây
        renderer.setDrawBarOutline(false);                 // Không vẽ viền cột

        // Loại bỏ hiệu ứng bóng (gradient) để cột chỉ có màu xanh lá cây đồng nhất
        renderer.setBarPainter(new StandardBarPainter());

        // Thêm nhãn giá trị trên mỗi cột
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(
            "{2}", // Hiển thị giá trị của cột (y-value)
            new DecimalFormat("#,##0") // Định dạng số với dấu phẩy ngăn cách hàng nghìn
        ));
        renderer.setDefaultItemLabelsVisible(true); // Hiển thị nhãn

        // Tùy chỉnh vị trí nhãn
        renderer.setDefaultPositiveItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12, // Nhãn nằm phía trên cột
            TextAnchor.BOTTOM_CENTER // Căn giữa phía dưới
        ));
        renderer.setDefaultNegativeItemLabelPosition(new org.jfree.chart.labels.ItemLabelPosition(
            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE6, // Nhãn nằm phía dưới cột
            TextAnchor.TOP_CENTER // Căn giữa phía trên
        ));

        // Đảm bảo trục Y bao gồm 0 làm đường cơ sở
        try {
            ValueAxis rangeAxis = plot.getRangeAxis();
            // Thử sử dụng setAutoRangeIncludesZero nếu có
            rangeAxis.getClass().getMethod("setAutoRangeIncludesZero", boolean.class)
                    .invoke(rangeAxis, true);
        } catch (Exception e) {
            // Phương án dự phòng: Tự đặt phạm vi để bao gồm 0
            double minProfit = Double.MAX_VALUE;
            double maxProfit = Double.MIN_VALUE;
            for (double profit : monthlyProfits) {
                minProfit = Math.min(minProfit, profit);
                maxProfit = Math.max(maxProfit, profit);
            }
            // Bao gồm 0 trong phạm vi
            double lowerBound = Math.min(minProfit, 0);
            double upperBound = Math.max(maxProfit, 0);
            // Thêm một chút khoảng trống cho đẹp
            double padding = (upperBound - lowerBound) * 0.1;
            plot.getRangeAxis().setRange(lowerBound - padding, upperBound + padding);
        }

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1260, 535)); // Phù hợp với kích thước pnchart
        chartPanel.setBackground(new Color(255, 255, 255)); // Nền trắng

        // Xóa panel pnchart và thêm biểu đồ mới
        view.getPnchart().removeAll();
        view.getPnchart().setLayout(new java.awt.BorderLayout());
        view.getPnchart().add(chartPanel, java.awt.BorderLayout.CENTER);
        view.getPnchart().setBackground(new Color(255, 255, 255));
        view.getPnchart().revalidate();
        view.getPnchart().repaint();
    }
    private void Loaddata() {
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> {
                    view.getLbtotalemployees().setText(String.format("%,d", ser.gettotalEmployees()));
                    view.getLbtotalalldt().setText(String.format("%,d", ser.gettotalprice()));
                    view.getLballbox().setText(String.format("%,d", ser.gettotalboxinwarehouse()));
                    view.getLbtotalfunds().setText(String.format("%,d", ser.gettotalfund()));

                    profit = ser.gettotalprice() - ser.gettotalfund();
                    if (profit < 0) {
                        view.getLbtotalprofit().setText(String.format("%,d", profit) + " (VNĐ)");
                        view.getLbtotalprofit().setForeground(new Color(255, 8, 8));
                    } else {
                        view.getLbtotalprofit().setText("+ " + String.format("%,d", profit) + " (VNĐ)");
                        view.getLbtotalprofit().setForeground(new Color(15, 169, 96));
                    }
                    view.getLbtotaldetail().setText("+ "+ String.format("%,d", ser.gettotaldetail())+ " (Hoá đơn)");
                    Loadprofitdata();
                    updatePieChart();
                    updateColumnChart();
                });

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void exportRevenueToExcel(String type) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Doanh Thu " + type);

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        String[] headers = {"STT", "Thời gian", "Tiền Doanh Thu (VNĐ)"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Lấy dữ liệu doanh thu dựa trên loại (tuần, tháng, năm)
        int rowIndex = 1;
        if (type.equals("week")) {
            Map<String, Double> dailyRevenue = ser.getDailyRevenueThisWeek();
            String[] daysOfWeek = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
            for (int i = 0; i < daysOfWeek.length; i++) {
                String day = daysOfWeek[i];
                Double revenue = dailyRevenue.get(day);
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rowIndex - 1); // STT
                row.createCell(1).setCellValue(day); // Ngày
                row.createCell(2).setCellValue(revenue); // Tiền doanh thu
            }
        } else if (type.equals("month")) {
            Map<Integer, Double> dailyRevenue = ser.getDailyRevenueThisMonth();
            for (Map.Entry<Integer, Double> entry : dailyRevenue.entrySet()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rowIndex - 1); // STT
                row.createCell(1).setCellValue("Ngày " + entry.getKey()); // Ngày
                row.createCell(2).setCellValue(entry.getValue()); // Tiền doanh thu
            }
        } else if (type.equals("year")) {
            Map<Integer, Double> monthlyRevenue = ser.getMonthlyRevenueThisYear();
            for (Map.Entry<Integer, Double> entry : monthlyRevenue.entrySet()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rowIndex - 1); // STT
                row.createCell(1).setCellValue("Tháng " + entry.getKey()); // Tháng
                row.createCell(2).setCellValue(entry.getValue()); // Tiền doanh thu
            }
        }

        // Tự động điều chỉnh kích thước cột
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Sử dụng FileDialog để chọn nơi lưu file
        java.awt.FileDialog fileDialog = new java.awt.FileDialog((java.awt.Frame) null, "Chọn nơi lưu file Excel", java.awt.FileDialog.SAVE);
        fileDialog.setFile("DoanhThu_" + type + ".xlsx");
        fileDialog.setVisible(true);

        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (fileName != null) {
            if (!fileName.toLowerCase().endsWith(".xlsx")) {
                fileName += ".xlsx";
            }
            String filePath = directory + fileName;

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Xuất file Excel thành công tại: " + filePath, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hủy xuất file Excel.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        try {
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void addListeners() {
    	view.getBtnexportweek().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportRevenueToExcel("week");
            }
        });

        view.getBtnexportmonth().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportRevenueToExcel("month");
            }
        });

        view.getBtnexportyear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportRevenueToExcel("year");
            }
        });
    }
}