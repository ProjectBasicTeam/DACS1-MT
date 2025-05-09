package Controllers;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Models.BuyItemM;
import Models.EmployeesM;
import Models.InfoBuyM;
import Models.ProductM;
import Models.PurchaseM;
import Models.TempPurchaseM;
import Services.AccountManagers;
import Services.DetailsManagers;
import Services.ProductManagers;
import Services.PurchaseManagers;
import Views.Details;
import Views.Purchase;

public class PurchaseController {
	private Purchase view;
	private Details viewdetail;
	private MenuManager menuManager;
	private AccountManagers sera;
	private PurchaseManagers serp;
	private ProductManagers serproduct;
	private DetailsManagers serd;
	private int eid;
	private String branch;
	private int totalprice;
	public PurchaseController(int id, Purchase view,Details viewdetail,  MenuManager menuManager) {
		this.view = view;
		this.viewdetail = viewdetail;
		this.eid = id;
		this.menuManager = menuManager;
		this.sera = AccountManagers.getInstance();
		this.serp = PurchaseManagers.getInstance();
		this.serproduct = ProductManagers.getInstance();
		this.serd = DetailsManagers.getInstance();
		this.totalprice = view.getTotalprice();
		branch = sera.getAccountbrancha(eid);
		String IDHD = (serp.getIdhd()!=null) ? serp.getIdhd(): "########";
		view.getTfidhdp().setText(IDHD);
		view.getTftotalprice().setText(String.valueOf(totalprice));
		loadDataP(branch);
		LoadDataTB();
		addListeners();
		setTime();
	}
	private void generateIDHDIfNeeded() {
	    String currentIDHD = serp.getIdhd();
	    if ((currentIDHD == null || currentIDHD.isEmpty()) && view.getTable2().getRowCount() > 0) {
	        Random rand = new Random();
	        int number = rand.nextInt(100000000);
	        String numberStr = String.format("%08d", number);
	        serp.insertIdhd(numberStr);
	        view.getTfidhdp().setText(numberStr);
	    } else if (view.getTable2().getRowCount() == 0 && currentIDHD != null) {
	        serp.deleteIdhd(currentIDHD);
	        view.getTfidhdp().setText("########");
	    } else {
	        view.getTfidhdp().setText(currentIDHD != null ? currentIDHD : "########");
	    }
	}
	private void loadDataP(String branch) {
		ArrayList<PurchaseM> list = serp.loadPurchase(branch);

		DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
		model.setRowCount(0);

		for (PurchaseM e : list) {
			byte[] imgData = e.getImage();
			ImageIcon icon = null;
			if (imgData != null) {
				Image img = Toolkit.getDefaultToolkit().createImage(imgData);
				Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				icon = new ImageIcon(scaledImg);
			}
			model.addRow(new Object[] { e.getId(), e.getName(), e.getPrice(), icon, e.getQty(), });
		}
		view.getTable1().getColumnModel().getColumn(0).setPreferredWidth(160);
		view.getTable1().getColumnModel().getColumn(1).setPreferredWidth(400);
		view.getTable1().getColumnModel().getColumn(2).setPreferredWidth(300);
		view.getTable1().getColumnModel().getColumn(4).setPreferredWidth(130);

		view.getTable1().setRowHeight(200);
		view.getTable1().getColumnModel().getColumn(3).setPreferredWidth(200);
		view.getTable1().getColumnModel().getColumn(3)
				.setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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
	
	public void LoadDataTB() {
		ArrayList<TempPurchaseM> list = serp.loadTempBuy();

		DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
		model.setRowCount(0);

		for (TempPurchaseM e : list) {
			model.addRow(new Object[] { e.getName(), e.getQty(), e.getPrice()

			});
		}
		view.getTable2().getColumnModel().getColumn(0).setPreferredWidth(400);
		view.getTable2().getColumnModel().getColumn(1).setPreferredWidth(60);
		view.getTable2().getColumnModel().getColumn(2).setPreferredWidth(200);

		
	}
	
	private void resetdatatemp() {
		view.getTfid().setText("");
		view.getTfname().setText("");
		view.getTfprice().setText("");
		view.getTfqty().setText("");
		view.getTfqtyp().setText("0");
		view.getTfphonep().setText("");
		view.setTotalprice(0);
		view.getTftotalprice().setText("0");
		int maxt = serp.getMaxrow();
		int max = serp.getCountBranchP(branch);
		for (int i = maxt; i>0;i--) {
			String idpT = serp.getIdproductTB(i).trim();
			int qtytemp =  serp.getqtyatTemp(idpT);
			for (int j = max+1; j>0 ;j--) {
				String idpB = serp.getIdproductBranch(j, branch);
				if(idpT.equalsIgnoreCase(idpB)) {
					int qtytransferproduct = serproduct.getqtyatTranferBrancha(idpB, branch);
					int newqty1 = qtytransferproduct+qtytemp;
					serproduct.updateQtyAtBranch(idpB, branch, newqty1);
					break;
				}
			}
		}
		serp.Deletealltempbuy();
		loadDataP(branch);
		LoadDataTB();
		generateIDHDIfNeeded();
	}
	
	private void AddItem() {
		if (view.getTfname().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Hãy lựa chọn sản phẩm để thanh toán", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
		} else {
			String idproduct = view.getTfid().getText();
			int qtytrade = Integer.parseInt(view.getTfqtyp().getText());
			int qtytransferproduct = serproduct.getqtyatTranferBrancha(idproduct, branch);
			int qtytemp =  serp.getqtyatTemp(idproduct);
			if (qtytrade == 0) {
				JOptionPane.showMessageDialog(view, "Hãy lựa chọn số lượng sản phẩm để thanh toán", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
			} else if (qtytrade > qtytransferproduct) {
				JOptionPane.showMessageDialog(view,
						"Số lượng bạn chọn đã lớn hơn số lượng còn trong kho. Yêu cầu chọn số lượng bé hơn", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String name = view.getTfname().getText();
				int price = Integer.parseInt(view.getTfprice().getText());
				TempPurchaseM temp = new TempPurchaseM(idproduct, name, qtytrade, price);
				int newqty1 = qtytransferproduct-qtytrade;
				int newqty2 = qtytemp+qtytrade;
				serproduct.updateQtyAtBranch(idproduct, branch, newqty1);
				if(qtytemp>0) {
					serp.updateQtyAtTemp(idproduct, newqty2);
				} else {
				serp.insertTemp(temp);
				}
				totalprice += qtytrade * price;
				view.setTotalprice(totalprice);
				view.getTftotalprice().setText(String.valueOf(view.getTotalprice()));
				loadDataP(branch);
				LoadDataTB();
				generateIDHDIfNeeded();
			}
		}
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
					view.getLbtimep().setText(time.split(" ")[0]+" "+time.split(" ")[1]);
					view.getLbdayp().setText(df.format(date));
				}
			}
		}).start();;
    }
	private void deleteItem() {
		if(view.getTable2().getRowCount() < 0) {
			JOptionPane.showMessageDialog(view,"Không có lựa chọn món đồ nào cần xoá. Yêu cầu thêm lựa chọn sản phẩm để xoá", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
		} else {
			String check = view.getLbcheck().getText();
			if(check.equals("temp")) {
				String idproduct = view.getTfid().getText();
				int qtytransferproduct = serproduct.getqtyatTranferBrancha(idproduct, branch);
				int qtytemp =  serp.getqtyatTemp(idproduct);
				int qtychoose = Integer.parseInt(view.getTfqty().getText());
				int price = Integer.parseInt(view.getTfprice().getText());
				serproduct.updateQtyAtBranch(idproduct, branch, qtytemp+qtytransferproduct);
				serp.delete1Item(idproduct);
				
				totalprice -= qtychoose * price;
				view.setTotalprice(totalprice);
				view.getTftotalprice().setText(String.valueOf(view.getTotalprice()));
				loadDataP(branch);
				LoadDataTB();
				generateIDHDIfNeeded();
			} else {
				JOptionPane.showMessageDialog(view,"Không thể xoá sản phẩm .Yêu cầu chọn sản phẩm từ danh sách lựa chọn thánh toán để xoá", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private void buyItem() {
		int stt = serd.getMaxrow(); 
		if (viewdetail.getTable1().getRowCount() > 0 && stt > 0) {
	        JOptionPane.showMessageDialog(view, "Bạn chưa thể thanh toán được. Yêu cầu xác nhận hoá đơn hoặc huỷ hoá đơn trước", "Cảnh báo",
	                JOptionPane.WARNING_MESSAGE);
	    }
		else if (view.getTable2().getRowCount() <= 0) {
	        JOptionPane.showMessageDialog(view, "Bạn chưa thể thanh toán được. Yêu cầu thêm lựa chọn sản phẩm để thanh toán", "Cảnh báo",
	                JOptionPane.WARNING_MESSAGE);
	    } else {
	        if (view.getTfphonep().getText().isEmpty()) {
	            JOptionPane.showMessageDialog(view, "Bạn chưa thể thanh toán được. Yêu cầu nhập số điện thoại của khách hàng", "Cảnh báo",
	                    JOptionPane.WARNING_MESSAGE);
	        } else {
	            int max = serp.getCountBranchP(branch);
	            String idhd = view.getTfidhdp().getText();
	            String phone = view.getTfphonep().getText();
	            int totalprice = Integer.parseInt(view.getTftotalprice().getText());
	            int totalqty = serp.getTotalqtyTemp();
	            String hour = view.getLbtimep().getText();
	            String dayStr = view.getLbdayp().getText(); // Lấy ngày dạng dd-MM-yyyy

	            try {
	                
	                SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
	                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	                java.util.Date parsedDate = inputFormat.parse(dayStr);
	                String formattedDate = outputFormat.format(parsedDate);
	                java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

	                for (int i = 0; i < view.getTable2().getRowCount(); i++) {
	                    String name = view.getTable2().getValueAt(i, 0).toString();
	                    String idproduct = serp.getIdproductTB2(name);
	                    int qty = Integer.parseInt(view.getTable2().getValueAt(i, 1).toString());
	                    int price = Integer.parseInt(view.getTable2().getValueAt(i, 2).toString());
	                    int totalpricep = qty * price;
	                    BuyItemM item = new BuyItemM(i + 1, idproduct, name, qty, price,totalpricep, branch, idhd);
	                    serd.insertBuyItem(item);
	                }

	                InfoBuyM info = new InfoBuyM(1, idhd, totalprice, totalqty, phone, hour, sqlDate);
	                serd.updateInfoBuy(info);

	                // Xóa dữ liệu
	                serp.Deletealltempbuy();
	                view.getTfid().setText("");
	        		view.getTfname().setText("");
	        		view.getTfprice().setText("");
	        		view.getTfqty().setText("");
	        		view.getTfqtyp().setText("0");
	        		view.getTfphonep().setText("");
	        		view.setTotalprice(0);
	        		view.getTftotalprice().setText("0");
	        		LoadDataTB();
	        		generateIDHDIfNeeded();
	        		menuManager.navigateToPanel("3");
	        		viewdetail.LoadDataB();
	        		viewdetail.reloadvalue();
	                JOptionPane.showMessageDialog(view, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            } catch (Exception e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(view, "Lỗi khi thanh toán: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }
	}
 	
		public void addListeners() {
		    view.getTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		        @Override
		        public void valueChanged(ListSelectionEvent e) {
		            if (!e.getValueIsAdjusting()) {
		                int selectedRow = view.getTable1().getSelectedRow();
		                if (selectedRow != -1) {
		                    view.getTable2().clearSelection();

		                    Object idObj = view.getTable1().getValueAt(selectedRow, 0);
		                    view.getTfid().setText(idObj != null ? idObj.toString() : "");
		                    Object nameObj = view.getTable1().getValueAt(selectedRow, 1);
		                    view.getTfname().setText(nameObj != null ? nameObj.toString() : "");
		                    Object qtyObj = view.getTable1().getValueAt(selectedRow, 4);
		                    view.getTfqty().setText(qtyObj != null ? qtyObj.toString() : "");
		                    Object priceObj = view.getTable1().getValueAt(selectedRow, 2);
		                    view.getTfprice().setText(priceObj != null ? priceObj.toString() : "");
		                    view.getLbcheck().setText("");
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
		                    view.getTable1().clearSelection();

		                    Object nameObj = view.getTable2().getValueAt(selectedRow, 0);
		                    view.getTfname().setText(nameObj != null ? nameObj.toString() : "");
		                    view.getTfid().setText(serp.getIdproductTB2((String)nameObj.toString()));
		                    Object qtyObj = view.getTable2().getValueAt(selectedRow, 1);
		                    view.getTfqty().setText(qtyObj != null ? qtyObj.toString() : "");
		                    Object priceObj = view.getTable2().getValueAt(selectedRow, 2);
		                    view.getTfprice().setText(priceObj != null ? priceObj.toString() : "");
		                    view.getLbcheck().setText("temp");
		                }
		            }
		        }
		    });
		this.view.getBtnbuyp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				buyItem();
			}
		});
		this.view.getBtnaddintemp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddItem();
			}
		});
		this.view.getBtndeleteitemp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteItem();
			}
		});
		this.view.getBtnresetp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetdatatemp();
			}
		});
		view.getTfsearchp().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearchp().getText(); 
		        serp.getPurchaseValue(view.getTable1(), branch, search); 
		    }
		});
		view.getLbadd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int current = Integer.parseInt(view.getTfqtyp().getText());
					if (current < 999) {
						current++;
					}
					view.getTfqtyp().setText(String.valueOf(current));
				} catch (NumberFormatException ex) {
					view.getTfqtyp().setText("0");
				}
			}
		});
		
		view.getLbsubtract().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int current = Integer.parseInt(view.getTfqtyp().getText());
				if (current > 0) {
					current--;
				}
				view.getTfqtyp().setText(String.valueOf(current));
			}
		});
	}
}
