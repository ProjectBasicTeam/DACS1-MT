package Controllers;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Models.ProductM;
import Models.SupplierM;
import Services.ProductManagers;
import Services.SupplierMangagers;
import Views.Supplier;

public class SupplierController {
    private Supplier view;
    private SupplierMangagers ser;
    private ProductManagers serp;
    private String imagePath;
    private java.io.File file;

    public SupplierController(Supplier view) {
        this.view = view;
        ser = SupplierMangagers.getInstance();
        serp = ProductManagers.getInstance();
        view.getTfidcc().setText(String.valueOf(ser.getMaxrow()));
        LoadDataS();
        addListeners();
    }

    public void LoadDataS() {
        ArrayList<SupplierM> list = ser.loadEmployees();

        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);

        for (SupplierM e : list) {
            byte[] imgData = e.getImage();
            ImageIcon icon = null;
            if (imgData != null) {
                Image img = Toolkit.getDefaultToolkit().createImage(imgData);
                Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            }
            model.addRow(new Object[] { e.getIds(), e.getNames(), e.getPhones(), e.getAddresss(), e.getNameproduct(),
                    e.getQtyproduct(), e.getPriceoneproduct(), e.getTotalcapital(), icon, e.getDay() });
        }
        view.getTable().getColumnModel().getColumn(0).setPreferredWidth(180);
        view.getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
        view.getTable().getColumnModel().getColumn(2).setPreferredWidth(180);
        view.getTable().getColumnModel().getColumn(3).setPreferredWidth(400);
        view.getTable().getColumnModel().getColumn(4).setPreferredWidth(500);
        view.getTable().getColumnModel().getColumn(5).setPreferredWidth(100);
        view.getTable().getColumnModel().getColumn(6).setPreferredWidth(280);
        view.getTable().getColumnModel().getColumn(7).setPreferredWidth(200);
        view.getTable().getColumnModel().getColumn(8).setPreferredWidth(200);

        view.getTable().setRowHeight(200);

        view.getTable().getColumnModel().getColumn(8).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                if (value instanceof ImageIcon) {
                    setIcon((ImageIcon) value);
                    setText("");
                } else {
                    super.setValue(value);
                }
            }
        });
        view.getTable().getColumnModel().getColumn(9).setPreferredWidth(300);
    }

    private boolean isEmpty1() {
        if (view.getTfnamecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên nhà cung cấp", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfaddresscc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập địa chỉ nhà cung cấp", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfnamesp().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfqtycc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số lượng sản phẩm", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfpricecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số vốn đã chi cho 1 sản phẩm", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (file == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập chọn hình ảnh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfdate().getDate() == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập ngày tháng năm nhập hàng", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().length() > 15) {
            JOptionPane.showMessageDialog(view, "Số điện thoại quá dài", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().length() < 10) {
            JOptionPane.showMessageDialog(view, "Số điện thoại quá ngắn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isEmpty2() {
        if (view.getTfnamecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên nhà cung cấp", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfaddresscc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập địa chỉ nhà cung cấp", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfnamesp().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfqtycc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số lượng sản phẩm", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfpricecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số vốn đã chi cho 1 sản phẩm", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().length() > 15) {
            JOptionPane.showMessageDialog(view, "Số điện thoại quá dài", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getTfphonecc().getText().length() < 10) {
            JOptionPane.showMessageDialog(view, "Số điện thoại quá ngắn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void resetSupplier() {
        view.getTfsearch().setText("");
        view.getTfidcc().setText(String.valueOf(ser.getMaxrow()));
        view.getTfnamecc().setText("");
        view.getTfaddresscc().setText("");
        view.getTfphonecc().setText("");
        view.getTfnamesp().setText("");
        view.getTfdate().setDate(null);
        view.getTfqtycc().setText("");
        view.getTfpricecc().setText("");
        view.getTftotalcc().setText("");
        LoadDataS();
        file = null;
        imagePath = null;
        view.getLbnameimg().setText("name.png");

        view.getImagePanel().setImage(null);
        view.getImagePanel().repaint();
    }

    public void addSupplier() throws IOException {
        try {
            int stt = serp.getMaxrow();
            int id = Integer.parseInt(view.getTfidcc().getText().trim());
            String name = view.getTfnamecc().getText().trim();
            String phone = view.getTfphonecc().getText().trim();
            String address = view.getTfaddresscc().getText().trim();
            String productName = view.getTfnamesp().getText().trim();
            int qty = Integer.parseInt(view.getTfqtycc().getText().trim());
            int price = Integer.parseInt(view.getTfpricecc().getText().trim());
            int total = qty * price;
            java.util.Date utilBirthDate = view.getTfdate().getDate();
            Date day = new Date(utilBirthDate.getTime());
            byte[] imageBytes = java.nio.file.Files.readAllBytes(file.toPath());
            String idp = "";
            SupplierM supplier = new SupplierM(id, name, phone, address, productName, qty, price, total, imageBytes,
                    day);

            ser.insertSupplier(supplier);
            ProductM p = new ProductM(stt, idp, productName, price, qty, imageBytes);
            boolean exists = false;
            for (int i = stt - 1; i > 0; i--) {
                String namep = serp.getNameatWarehouse(i);

                if (productName.equals(namep)) {
                    int qtycur = serp.getqtyatWarehousefromstt(i);
                    serp.updateQtyProduct(i, qty + qtycur);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                serp.insertProductInWareHouse(p);
            }
            JOptionPane.showMessageDialog(view, "Thêm sản phẩm nhà cung cấp thành công thành công!");

            LoadDataS();

            resetSupplier();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "ID phải là số!");
        }
    }

    public void updateSupplier() throws IOException {
        try {
            int id = Integer.parseInt(view.getTfidcc().getText().trim());
            String name = view.getTfnamecc().getText().trim();
            String phone = view.getTfphonecc().getText().trim();
            String address = view.getTfaddresscc().getText().trim();
            String productName = view.getTfnamesp().getText().trim();
            int qty = Integer.parseInt(view.getTfqtycc().getText().trim());
            int price = Integer.parseInt(view.getTfpricecc().getText().trim());
            int total = qty * price;
            java.util.Date utilBirthDate = view.getTfdate().getDate();
            Date day = new Date(utilBirthDate.getTime());
            byte[] imageBytes = (file != null) ? java.nio.file.Files.readAllBytes(file.toPath()) : ser.getImageById(id);

            SupplierM supplier = new SupplierM(id, name, phone, address, productName, qty, price, total, imageBytes,
                    day);
            ser.updateSupplier(supplier);

            JOptionPane.showMessageDialog(view, "Cập nhật thành công nhà cung cấp!");
            LoadDataS();
            resetSupplier();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "ID phải là số!");
        }
    }

    private void deleteSupplier() {
        try {
            int id = Integer.parseInt(view.getTfidcc().getText());

            ser.deleteSupplier(id);

            LoadDataS();
            resetSupplier();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "ID phải là số!");
        }
    }

    // Thêm phương thức xuất bảng ra Excel
    private void exportTableToExcel() {
        // Tạo một workbook mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Danh Sách Nhà Cung Cấp");

        // Lấy dữ liệu từ table
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
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
                if (j == 8) { // Cột "Hình ảnh" (cột thứ 9, index 8)
                    cell.setCellValue("Hình ảnh"); // Thay hình ảnh bằng văn bản "Hình ảnh"
                } else if (value != null) {
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
        fileDialog.setFile("DanhSachNhaCungCap.xlsx"); // Tên file mặc định đã có đuôi .xlsx
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
        view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow != -1) {
                        view.getTfidcc().setText(view.getTable().getValueAt(selectedRow, 0).toString());
                        view.getTfnamecc().setText(view.getTable().getValueAt(selectedRow, 1).toString());
                        view.getTfphonecc().setText(view.getTable().getValueAt(selectedRow, 2).toString());
                        view.getTfaddresscc().setText(view.getTable().getValueAt(selectedRow, 3).toString());
                        view.getTfnamesp().setText(view.getTable().getValueAt(selectedRow, 4).toString());
                        view.getTfqtycc().setText(view.getTable().getValueAt(selectedRow, 5).toString());
                        view.getTfpricecc().setText(view.getTable().getValueAt(selectedRow, 6).toString());
                        Object totalObj = view.getTable().getValueAt(selectedRow, 7);
                        view.getTftotalcc().setText(totalObj != null ? totalObj.toString() : "");

                        Object imageObj = view.getTable().getValueAt(selectedRow, 8);
                        if (imageObj instanceof ImageIcon) {
                            ImageIcon icon = (ImageIcon) imageObj;
                            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                            view.getImagePanel().setImage(img);
                            view.getImagePanel().repaint();
                            view.getLbnameimg().setText("Đã được chọn từ bảng");
                            file = null;
                        }

                        Object dayObj = view.getTable().getValueAt(selectedRow, 9);
                        if (dayObj instanceof java.sql.Date) {
                            view.getTfdate().setDate((java.sql.Date) dayObj);
                        } else {
                            view.getTfdate().setDate(null);
                        }
                    }
                }
            }
        });

        view.getBtnimage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setDialogTitle("Chọn ảnh nhà cung cấp");
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    try {
                        java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(file);
                        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        view.getLbnameimg().setText(file.getName());
                        view.getImagePanel().setImage(scaledImg); // Đặt ảnh vào panel
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi khi tải ảnh", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        view.getBtnreset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSupplier();
            }
        });

        view.getBtnadd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty1()) {
                    try {
                        addSupplier();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        view.getBtnedit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty2()) {
                    try {
                        updateSupplier();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        view.getBtndelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty2()) {
                    deleteSupplier();
                }
            }
        });

        view.getTfsearch().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String search = view.getTfsearch().getText();
                view.getTable()
                        .setModel(new DefaultTableModel(null,
                                new Object[] { "Mã cung cấp", "Nhà cung cấp", "Số điện thoại", "Địa chỉ lấy hàng",
                                        "Tên sản phẩm", "Số lượng đã nhập", "Giá của một sản phẩm",
                                        "Tổng số vốn đã chi", "Hình ảnh", "Thời gian nhập hàng" }));
                ser.getSupplierValue(view.getTable(), search);
            }
        });

        // Thêm sự kiện cho nút Xuất Excel
        view.getBtnexportexcel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportTableToExcel();
            }
        });
    }
}