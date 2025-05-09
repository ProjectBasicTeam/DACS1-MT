package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Models.BuyItemM;
import Models.History1M;
import Models.History2M;
import Services.HistoryManagers;
import Views.History;

public class HistoryController {
    private History view;
    private HistoryManagers ser;

    public HistoryController(History view) {
        this.view = view;
        this.ser = HistoryManagers.getInstance();
        addListeners();
        setTime();
        LoadDataH1();
        LoadDataH2();
    }

    public void LoadDataH1() {
        ArrayList<History1M> list = ser.loadTableHistory1();
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        model.setRowCount(0);
        for (History1M e : list) {
            model.addRow(new Object[] { e.getStt(), e.getIdhd(), e.getTotalprice(), e.getTotalqty(),
                    e.getPhonecustomer(), e.getDay(), e.getHour(), e.getBrancha() });
        }
        view.getTable1().getColumnModel().getColumn(0).setPreferredWidth(50);
        view.getTable1().getColumnModel().getColumn(1).setPreferredWidth(200);
        view.getTable1().getColumnModel().getColumn(2).setPreferredWidth(300);
        view.getTable1().getColumnModel().getColumn(3).setPreferredWidth(100);
        view.getTable1().getColumnModel().getColumn(4).setPreferredWidth(180);
        view.getTable1().getColumnModel().getColumn(5).setPreferredWidth(200);
        view.getTable1().getColumnModel().getColumn(6).setPreferredWidth(300);
        view.getTable1().getColumnModel().getColumn(7).setPreferredWidth(300);
    }

    public void LoadDataH2() {
        ArrayList<History2M> list = ser.loadTableHistory2();
        DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
        model.setRowCount(0);
        for (History2M e : list) {
            model.addRow(new Object[] { e.getStt(), e.getIdhd(), e.getIdproduct(), e.getNameproduct(),
                    e.getQuantityproduct(), e.getPriceproduct(), e.getTotalprice(), e.getDay(), e.getBrancha() });
        }
        view.getTable2().getColumnModel().getColumn(0).setPreferredWidth(60);
        view.getTable2().getColumnModel().getColumn(1).setPreferredWidth(120);
        view.getTable2().getColumnModel().getColumn(2).setPreferredWidth(200);
        view.getTable2().getColumnModel().getColumn(3).setPreferredWidth(400);
        view.getTable2().getColumnModel().getColumn(4).setPreferredWidth(60);
        view.getTable2().getColumnModel().getColumn(5).setPreferredWidth(300);
        view.getTable2().getColumnModel().getColumn(6).setPreferredWidth(300);
        view.getTable2().getColumnModel().getColumn(7).setPreferredWidth(180);
        view.getTable2().getColumnModel().getColumn(8).setPreferredWidth(400);
    }

    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String time = tf.format(date);
                    view.getLbtime().setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    view.getLbday().setText(df.format(date));
                }
            }
        }).start();
    }

    private void exportTable2ToExcel() {
        // Tạo một workbook mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Chi Tiết Hoá Đơn");

        // Lấy dữ liệu từ table2
        DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int j = 0; j < columnCount; j++) {
            Cell cell = headerRow.createCell(j);
            cell.setCellValue(model.getColumnName(j));
        }

        // Đổ dữ liệu từ bảng vào sheet
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.createCell(j);
                Object value = model.getValueAt(i, j);
                if (value != null) {
                    cell.setCellValue(value.toString());
                } else {
                    cell.setCellValue("");
                }
            }
        }

        // Tự động điều chỉnh kích thước cột
        for (int j = 0; j < columnCount; j++) {
            sheet.autoSizeColumn(j);
        }

        // Sử dụng FileDialog để chọn nơi lưu file
        java.awt.FileDialog fileDialog = new java.awt.FileDialog((java.awt.Frame) null, "Chọn nơi lưu file Excel", java.awt.FileDialog.SAVE);
        fileDialog.setFile("ChiTietHoaDon.xlsx"); // Tên file mặc định đã có đuôi .xlsx
        fileDialog.setVisible(true);

        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();
        
        if (fileName != null) { // Kiểm tra xem người dùng có chọn file hay không
            // Đảm bảo file có đuôi .xlsx
            if (!fileName.toLowerCase().endsWith(".xlsx")) {
                fileName += ".xlsx";
            }
            String filePath = directory + fileName;

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(view, "Xuất file Excel thành công tại: " + filePath, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Lỗi khi xuất file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Hủy xuất file Excel.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        // Đóng workbook
        try {
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Thêm phương thức mới để xuất table1
    private void exportTable1ToExcel() {
        // Tạo một workbook mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thông Tin Hoá Đơn");

        // Lấy dữ liệu từ table1
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int j = 0; j < columnCount; j++) {
            Cell cell = headerRow.createCell(j);
            cell.setCellValue(model.getColumnName(j));
        }

        // Đổ dữ liệu từ bảng vào sheet
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.createCell(j);
                Object value = model.getValueAt(i, j);
                if (value != null) {
                    cell.setCellValue(value.toString());
                } else {
                    cell.setCellValue("");
                }
            }
        }

        // Tự động điều chỉnh kích thước cột
        for (int j = 0; j < columnCount; j++) {
            sheet.autoSizeColumn(j);
        }

        // Sử dụng FileDialog để chọn nơi lưu file
        java.awt.FileDialog fileDialog = new java.awt.FileDialog((java.awt.Frame) null, "Chọn nơi lưu file Excel", java.awt.FileDialog.SAVE);
        fileDialog.setFile("ThongTinHoaDon.xlsx"); // Tên file mặc định đã có đuôi .xlsx
        fileDialog.setVisible(true);

        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();
        
        if (fileName != null) { // Kiểm tra xem người dùng có chọn file hay không
            // Đảm bảo file có đuôi .xlsx
            if (!fileName.toLowerCase().endsWith(".xlsx")) {
                fileName += ".xlsx";
            }
            String filePath = directory + fileName;

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(view, "Xuất file Excel thành công tại: " + filePath, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Lỗi khi xuất file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Hủy xuất file Excel.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        // Đóng workbook
        try {
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addListeners() {
        view.getTfsearch().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String search = view.getTfsearch().getText();
                ser.getHistory1(view.getTable1(), search);
                ser.getHistory2(view.getTable2(), search);
            }
        });

        view.getBtnreload().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTfsearch().setText("");
                LoadDataH1();
                LoadDataH2();
            }
        });

        // Sự kiện cho nút Xuất Excel bảng 2
        view.getBtnexportExcel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportTable2ToExcel();
            }
        });

        // Sự kiện cho nút Xuất Excel bảng 1
        view.getBtnexportexcel2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportTable1ToExcel();
            }
        });
    }
}