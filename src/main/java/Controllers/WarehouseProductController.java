package Controllers;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Models.EmployeesM;
import Models.ProductM;
import Models.SupplierM;
import Services.ProductManagers;
import Views.WarehouseProduct;

public class WarehouseProductController {
	private WarehouseProduct view;
	private ProductManagers ser;
	private File file;
	private String imagePath;

	public WarehouseProductController(WarehouseProduct view) {
		this.view = view;
		this.ser = ProductManagers.getInstance();
		LoadDataWP();
		addListeners();

	}

	private boolean isEmpty() {
		if (view.getTfnamepd().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (view.getTfpricepd().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập giá của sản phẩm", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (view.getTfidpd().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập id riêng của sản phẩm", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void LoadDataWP() {
		ArrayList<ProductM> list = ser.loadProduct();

		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0);

		for (ProductM e : list) {
			byte[] imgData = e.getImage();
			ImageIcon icon = null;
			if (imgData != null) {
				Image img = Toolkit.getDefaultToolkit().createImage(imgData);
				Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				icon = new ImageIcon(scaledImg);
			}
			model.addRow(new Object[] { e.getStt(), e.getIdproduct(), e.getNameproduct(), e.getPriceproduct(),
					e.getQtyproduct(), icon,

			});
		}
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(100);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(180);
		view.getTable().getColumnModel().getColumn(2).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(3).setPreferredWidth(200);
		view.getTable().getColumnModel().getColumn(4).setPreferredWidth(100);
		view.getTable().getColumnModel().getColumn(5).setPreferredWidth(200);

		view.getTable().setRowHeight(200);

		view.getTable().getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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
	}

	private void deleteProduct() {

		try {
			int id = Integer.parseInt(view.getTfstt().getText());
			int qtyt = ser.getqtyatBranchfromidproduct(view.getTfidpd().getText());
			if (qtyt >= 0) {
				JOptionPane.showMessageDialog(view, "Lỗi không xoá được! Yêu cầu hãy xoá tất cả các món đồ ở chính nhánh trước", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
			} else {
				ser.deleteProduct(id);
			}
			LoadDataWP();
			resetProduct();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "ID phải là số!");
		}

	}

	private void resetProduct() {
		view.getTfsearch().setText("");
		view.getTfstt().setText("");
		view.getTfidpd().setText("");
		view.getTfnamepd().setText("");
		view.getTfpricepd().setText("");
		view.getTfqtypd().setText("");

		file = null;
		imagePath = null;
		view.getLbname().setText("name.png");

		view.getImagePanel().setImage(null);
		view.getImagePanel().repaint();
		LoadDataWP();
	}

	public void updateProduct() throws IOException {
		try {
			int stt = Integer.parseInt(view.getTfstt().getText().trim());
			String id = String.valueOf(view.getTfidpd().getText().trim());
			String name = view.getTfnamepd().getText().trim();
			int price = Integer.parseInt(view.getTfpricepd().getText().trim());
			int qty = Integer.parseInt(view.getTfqtypd().getText().trim());

			byte[] imageBytes = (file != null) ? java.nio.file.Files.readAllBytes(file.toPath())
					: ser.getImageById(stt);

			ProductM product = new ProductM(stt, id, name, price, qty, imageBytes);
			ser.updateProduct(product);

			JOptionPane.showMessageDialog(view, "Cập nhật thành công nhà cung cấp!");
			LoadDataWP();
			resetProduct();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "ID phải là số!");
		}
	}

	private void addListeners() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = view.getTable().getSelectedRow();
					if (selectedRow != -1) {
						view.getTfstt().setText(view.getTable().getValueAt(selectedRow, 0).toString());
						view.getTfnamepd().setText(view.getTable().getValueAt(selectedRow, 2).toString());
						view.getTfpricepd().setText(view.getTable().getValueAt(selectedRow, 3).toString());
						view.getTfqtypd().setText(view.getTable().getValueAt(selectedRow, 4).toString());
						Object idObj = view.getTable().getValueAt(selectedRow, 1);
						view.getTfidpd().setText(idObj != null ? idObj.toString() : "");

						Object imageObj = view.getTable().getValueAt(selectedRow, 5);
						if (imageObj instanceof ImageIcon) {
							ImageIcon icon = (ImageIcon) imageObj;
							Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
							view.getImagePanel().setImage(img);
							view.getImagePanel().repaint();
							view.getLbname().setText("Đã được chọn từ bảng");
							file = null;
						}

					}
				}
			}

		});
		view.getBtnedit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					try {
						updateProduct();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		view.getBtnbrowseimg().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setDialogTitle("Chọn ảnh nhà cung cấp");
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					try {
						BufferedImage img = ImageIO.read(file);
						Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
						view.getLbname().setText(file.getName());
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
				resetProduct();
			}
		});
		view.getBtndelete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					deleteProduct();
				
			}
		});
		view.getTfsearch().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search = view.getTfsearch().getText();
				ser.getproductValue(view.getTable(), search);
			}
		});
	}
}
