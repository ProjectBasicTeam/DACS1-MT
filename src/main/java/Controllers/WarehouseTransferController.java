package Controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Models.EmployeesM;
import Models.ProductM2;
import Models.ProductTransferM;
import Services.AccountManagers;
import Services.ProductManagers;
import Views.Warehouse;

public class WarehouseTransferController {
	private Warehouse view;
	private AccountManagers sera;
	private ProductManagers serp;
	private String[] valuea = new String[6];
	public WarehouseTransferController(Warehouse view) {
		this.view = view;
		this.sera= AccountManagers.getInstance();
		this.serp= ProductManagers.getInstance();
		sera.loadBranchToComboBox(view.getCblocationpd());
		addListeners();
		LoadDataP();
		LoadDataTP();
	}
	private void resetWP() {
		view.getTfid().setText("");
		view.getLbwhere().setText("########");
    	view.getLbwhere().setForeground(new Color(255,255,255));
    	sera.loadBranchToComboBox(view.getCblocationpd());
    	view.getCblocationpd().setSelectedIndex(0);
    	view.getTfqty().setText("0");
		LoadDataP();
		LoadDataTP();
	}
	public void LoadDataP() {
		ArrayList<ProductM2> list = serp.loadProduct2();

		DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
		model.setRowCount(0); 
		
		for (ProductM2 e : list) {
			model.addRow(new Object[]{
				e.getId(),
				e.getName(),
				e.getQty()
			});
		}
		view.getTable1().getColumnModel().getColumn(0).setPreferredWidth(180);
		view.getTable1().getColumnModel().getColumn(1).setPreferredWidth(500);
		view.getTable1().getColumnModel().getColumn(2).setPreferredWidth(100);
		
	}
	public void LoadDataTP() {
		ArrayList<ProductTransferM> list = serp.loadTransferProduct();

		DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
		model.setRowCount(0); 
		
		for (ProductTransferM e : list) {
			model.addRow(new Object[]{
				e.getStt(),
				e.getBrancha(),
				e.getAddress(),
				e.getIdproduct(),
				e.getQty()
			});
		}
		
		view.getTable2().getColumnModel().getColumn(0).setPreferredWidth(100);
		view.getTable2().getColumnModel().getColumn(1).setPreferredWidth(200);
		view.getTable2().getColumnModel().getColumn(2).setPreferredWidth(550);
		view.getTable2().getColumnModel().getColumn(3).setPreferredWidth(300);
		view.getTable2().getColumnModel().getColumn(4).setPreferredWidth(100);
	}
	public void transferProductforBranch() {
		String address = sera.getAccountaddress((String)view.getCblocationpd().getSelectedItem());
		String lb = view.getLbwhere().getText();
		if(view.getTfid().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể chuyển sản phẩm cho chi nhánh. Yêu cầu phải đặt tên cho mã sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else if(lb.equals("Chi nhánh")) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể chuyển sản phẩm cho chi nhánh. Yêu cầu phải chọn sản phẩm từ kho chính", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else {
			String brancha = (String)view.getCblocationpd().getSelectedItem();
			String idproduct = view.getTfid().getText();
			int qtytrade = Integer.parseInt(view.getTfqty().getText());
			int qtywarehouseproduct = serp.getqtyatWarehouse(idproduct);
			if (brancha.equals("Admin (Không cấp thiết)")) {
				JOptionPane.showMessageDialog(view, "Bạn không thể chuyển sản phẩm vào Admin. Yêu cầu chọn chi nhánh khác", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else {
				if(qtytrade > qtywarehouseproduct) {
					JOptionPane.showMessageDialog(view, "Bạn không thể chuyển vào chi nhánh Vì số lượng chuyển vào chi nhánh lớn hơn số lượng từ kho", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
				} else if(qtytrade == 0) {
					JOptionPane.showMessageDialog(view, "Bạn không thể chuyển vào chi nhánh Vì số lượng chuyển vào chi nhánh phải lớn hơn 0", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
				} else {
					int stt =  0;
					ProductTransferM product = new ProductTransferM(stt, brancha, address,idproduct ,qtytrade);
					int qtytransferproduct = serp.getqtyatTranferBrancha(idproduct, brancha);
					if(qtytransferproduct > 0) {
						int newqty = qtytransferproduct+qtytrade;
						serp.updateQtyAtBranch(idproduct,brancha, newqty);
					} else {
						serp.insertProductTransferBrancha(product);
					}
					JOptionPane.showMessageDialog(view, "Chuyển sản phẩm vào chi nhánh "+ brancha+" thành công!");
					serp.updateProduct2(idproduct, qtywarehouseproduct-qtytrade);
					resetWP();
				}
			}
		}	
	}
	public void deleteTranferProduct() {
		String lb = view.getLbwhere().getText();
		if (view.getTfid().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể xoá sản phẩm cho chi nhánh. Yêu cầu phải đặt tên cho mã sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else if (lb.equals("Kho chính")) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể xoá sản phẩm. Yêu cầu phải chọn sản phẩm từ chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else {
			String brancha = (String) view.getCblocationpd().getSelectedItem();
			String idproduct = view.getTfid().getText();
			int qtytransferproduct = serp.getqtyatTranferBrancha(idproduct, brancha);
			if (qtytransferproduct > 0) {
				JOptionPane.showMessageDialog(view, "Bạn chưa thể xoá sản phẩm. Yêu cầu phải đưa hết sản phẩm về kho chính", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else {
				serp.deleteTransferProduct(idproduct, brancha);
				JOptionPane.showMessageDialog(view, "Xoá sản phẩm thành công!");
				resetWP();
			}
		}
	}
	
	public void transferProductforWarehouse() {
		String address = sera.getAccountaddress((String) view.getCblocationpd().getSelectedItem());
		String lb = view.getLbwhere().getText();

		if (view.getTfid().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể chuyển sản phẩm cho chi nhánh. Yêu cầu phải đặt tên cho mã sản phẩm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else if (lb.equals("Kho chính")) {
			JOptionPane.showMessageDialog(view, "Bạn chưa thể chuyển sản phẩm về kho chính. Yêu cầu phải chọn sản phẩm từ chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		} else {
			String brancha = (String) view.getCblocationpd().getSelectedItem();
			String idproduct = view.getTfid().getText();
			int qtytrade = Integer.parseInt(view.getTfqty().getText());
			int qtywarehouseproduct = serp.getqtyatWarehouse(idproduct);
			int qtytransferproduct = serp.getqtyatTranferBrancha(idproduct, brancha);

			if (qtytrade > qtytransferproduct) {
				JOptionPane.showMessageDialog(view, "Bạn không thể chuyển sản phẩm vào kho chính. Vì số lượng chuyển vào lớn hơn số lượng từ chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else if (qtytrade == 0) {
				JOptionPane.showMessageDialog(view, "Bạn không thể chuyển sản phẩm vào kho chính. Vì số lượng chuyển vào kho chính phải lớn hơn 0", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else {
				int newqty = qtytransferproduct - qtytrade;

				if (newqty == 0) {
					serp.deleteTransferProduct(idproduct, brancha);
				} else {
					serp.updateQtyAtBranch(idproduct, brancha, newqty);
				}

				serp.updateProduct2(idproduct, qtywarehouseproduct + qtytrade);

				JOptionPane.showMessageDialog(view, "Chuyển sản phẩm vào kho chính thành công!");
				resetWP();
			}
		}
	}

	private void addListeners() {
		view.getTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable1().getSelectedRow();
                    if (selectedRow != -1) {
                    	Object idObj = view.getTable1().getValueAt(selectedRow, 0);
                    	view.getTfid().setText(idObj != null ? idObj.toString() : "Hãy đặt mã sản phẩm cho sản phẩm");
                    	view.getLbwhere().setText("Kho chính");
//                    	view.getLbwhere().setForeground(new Color(59,219,4));
                    }
                }
            }
        });
		view.getTable2().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable2().getSelectedRow();
                    if (selectedRow != -1) {
                    	Object idObj = view.getTable2().getValueAt(selectedRow, 3);
                    	view.getTfid().setText(idObj != null ? idObj.toString() : "Hãy đặt mã sản phẩm cho sản phẩm");
                    	view.getLbwhere().setText("Chi nhánh");
//                    	view.getLbwhere().setForeground(new Color(255, 128, 0));
                    	Object branchaObj = view.getTable2().getValueAt(selectedRow, 1);
                    	if (branchaObj != null) view.getCblocationpd().setSelectedItem(branchaObj.toString());
                    }
                }
            }
        });
		view.getLbadd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
	                int current = Integer.parseInt(view.getTfqty().getText());
	                if (current < 999) {
	                    current++;
	                }
	                view.getTfqty().setText(String.valueOf(current));
	            } catch (NumberFormatException ex) {
	                view.getTfqty().setText("0");
	            }
			}
		});
	
	
		view.getLbsubtract().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int current = Integer.parseInt(view.getTfqty().getText());
                if (current > 0) {
                    current--;
                }
                view.getTfqty().setText(String.valueOf(current));
			}
		});
		view.getBtnaccept().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transferProductforBranch();
			}
		});
		view.getBtntransderwarehousep().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transferProductforWarehouse();
			}
		});
		view.getBtnreset().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetWP();
			}
		});
		view.getBtndelletet().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteTranferProduct();
			}
		});
		view.getTfsearch1().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearch1().getText(); 
		        serp.getProductWarehouseValue(view.getTable1(), search); 
		    }
		});
		view.getTfsearch2().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearch2().getText(); 
		        serp.getBranchProductValue(view.getTable2(), search); 
		    }
		});
	}
}
