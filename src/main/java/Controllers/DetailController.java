package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Models.BuyItemM;
import Models.History1M;
import Models.History2M;
import Models.TempPurchaseM;
import Services.AccountManagers;
import Services.DetailsManagers;
import Services.HistoryManagers;
import Services.ProductManagers;
import Services.PurchaseManagers;
import Views.Details;
import Views.Purchase;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import javax.swing.table.DefaultTableModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import java.awt.print.PrinterJob;
public class DetailController {
	private Details view;
	private Purchase viewpurchase;
	private MenuManager menuManager;
	private int eid;
	private String branch;
	private DetailsManagers serd;
	private AccountManagers sera;
	private PurchaseManagers serp;
	private HistoryManagers serh;
	private ProductManagers serproduct;
	private String[] value = new String[7];
	public DetailController(int id,Details view,Purchase viewpurchase, MenuManager menuManager) {
		this.view = view;
		this.viewpurchase = viewpurchase;
		this.eid = id;
		this.menuManager = menuManager;
		this.serd = DetailsManagers.getInstance();
		this.sera = AccountManagers.getInstance();
		this.serp = PurchaseManagers.getInstance();
		this.serh = HistoryManagers.getInstance();
		this.serproduct = ProductManagers.getInstance();
		branch = sera.getAccountbrancha(eid);
		reloadvalue();
		LoadDataB();
		LoadDataH();
		addListeners();
		
	}
	public void LoadDataB() {
		ArrayList<BuyItemM> list = serd.loadBuy();

		DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
		model.setRowCount(0);

		for (BuyItemM e : list) {
			model.addRow(new Object[] {e.getStt(), e.getName(), e.getQty(), e.getPrice(), e.getTotalprice()
			});
		}	
		view.getTable1().getColumnModel().getColumn(0).setPreferredWidth(30);
		view.getTable1().getColumnModel().getColumn(1).setPreferredWidth(353);
		view.getTable1().getColumnModel().getColumn(2).setPreferredWidth(60);
		view.getTable1().getColumnModel().getColumn(3).setPreferredWidth(150);
		
	}
	public void LoadDataH() {
		ArrayList<History1M> list = serh.loadHistory1(branch);

		DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
		model.setRowCount(0);

		for (History1M e : list) {
			model.addRow(new Object[] {e.getStt(), e.getIdhd(), e.getTotalprice(), e.getTotalqty(), e.getPhonecustomer(), e.getHour(), e.getDay()
			});
		}	
		
		view.getTable2().getColumnModel().getColumn(0).setPreferredWidth(150);
		view.getTable2().getColumnModel().getColumn(1).setPreferredWidth(200);
		view.getTable2().getColumnModel().getColumn(2).setPreferredWidth(250);
		view.getTable2().getColumnModel().getColumn(3).setPreferredWidth(100);
		view.getTable2().getColumnModel().getColumn(4).setPreferredWidth(200);
		view.getTable2().getColumnModel().getColumn(5).setPreferredWidth(240);
		view.getTable2().getColumnModel().getColumn(6).setPreferredWidth(180);
	}
	private void reloadvalue() {
		value = serd.getInfoBuyValue();
		view.getTfidhdd().setText(value[1]);
		view.getTftotalpriced().setText(value[2]);
		view.getTfqty().setText(value[3]);
		view.getTfphoned().setText(value[4]);
		view.getTftimed().setText(value[5]);
		view.getTfdayd().setText(value[6]);
	}
	private void deleteDetail() {
		int maxt = serd.getMaxrow();
		int max = serp.getCountBranchP(branch);
		for (int i = maxt; i>0;i--) {
			String idpT = serd.getIdproductBuy(i).trim();
			int qtyd =  serd.getqtyatBuy(idpT);
			for (int j = max+1; j>0 ;j--) {
				String idpB = serp.getIdproductBranch(j, branch);
				if(idpT.equalsIgnoreCase(idpB)) {
					int qtytransferproduct = serproduct.getqtyatTranferBrancha(idpB, branch);
					int newqty1 = qtytransferproduct+qtyd;
					serproduct.updateQtyAtBranch(idpB, branch, newqty1);
					break;
				}
			}
		}
		serd.Deleteallbuy();
		serd.updateInfoBuynull();
		LoadDataB();
		reloadvalue();
		viewpurchase.setTotalprice(0);
	}

	private void exportdetail() {
	    value = serd.getInfoBuyValue();
	    String address = sera.getAccountaddress(branch);

	    try {
	        // Tạo font hỗ trợ tiếng Việt
	        BaseFont bf = BaseFont.createFont("c:/windows/fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font = new Font(bf, 12); // Font Times New Roman, kích thước 12

	        // Tạo PDF trong bộ nhớ (không lưu thành file)
	        Document document = new Document();
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PdfWriter.getInstance(document, baos);
	        document.open();

	        // Thêm tiêu đề (văn bản)
	        Paragraph title = new Paragraph("Cửa hàng: BOX/CARD POKEMON TCG", font);
	        title.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(title);

	        document.add(new Paragraph("\n"));
	        Paragraph subtitle = new Paragraph("Hoá đơn bán hàng", font);
	        subtitle.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(subtitle);
	        document.add(new Paragraph("\n"));

	        // Thêm thông tin khách hàng và chi nhánh (văn bản)
	        document.add(new Paragraph("Số điện thoại khách hàng: " + (value[4] != null ? value[4] : "Không có"), font));
	        document.add(new Paragraph("Địa chỉ chi nhánh: " + (address != null ? address : "Không có"), font));
	        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------", font));
	        document.add(new Paragraph("(*) Thông tin hoá đơn:", font));
	        Paragraph idhd = new Paragraph("Mã hoá đơn: "+(value[1] != null ? value[1] : "########"), font);
	        idhd.setAlignment(Paragraph.ALIGN_RIGHT); // Căn phải
	        document.add(idhd);
	        document.add(new Paragraph("\n"));

	        // Tạo bảng sản phẩm (tương tự JTable)
	        PdfPTable table = new PdfPTable(5); // 5 cột: STT, Tên món đồ, Số lượng, Đơn Giá, Thành tiền
	        table.setWidthPercentage(100);
	        table.setWidths(new float[]{1, 4, 2, 2, 2}); // Đặt chiều rộng cột

	        // Tiêu đề bảng
	        table.addCell(new com.itextpdf.text.Phrase("STT", font));
	        table.addCell(new com.itextpdf.text.Phrase("Tên món", font));
	        table.addCell(new com.itextpdf.text.Phrase("Số lượng", font));
	        table.addCell(new com.itextpdf.text.Phrase("Đơn Giá", font));
	        table.addCell(new com.itextpdf.text.Phrase("Thành tiền", font));

	        // Dữ liệu bảng
	        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            table.addCell(new com.itextpdf.text.Phrase(model.getValueAt(i, 0).toString(), font));
	            table.addCell(new com.itextpdf.text.Phrase(model.getValueAt(i, 1).toString(), font));
	            table.addCell(new com.itextpdf.text.Phrase(model.getValueAt(i, 2).toString(), font));
	            table.addCell(new com.itextpdf.text.Phrase(model.getValueAt(i, 3).toString(), font));
	            table.addCell(new com.itextpdf.text.Phrase(model.getValueAt(i, 4).toString(), font));
	        }

	        document.add(table);

	        // Thêm tổng tiền, thời gian, ngày mua (văn bản)
	        document.add(new Paragraph("\n"));
	        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------", font));
	        
	        Paragraph total = new Paragraph("Tổng cộng: " + (value[2] != null ? value[2] : "0")+ " (VNĐ)", font);
	        total.setAlignment(Paragraph.ALIGN_RIGHT); // Căn phải
	        document.add(total);
	        
	        Paragraph purchaseTime = new Paragraph("Đã mua hàng vào lúc: " + (value[5] != null ? value[5] : "Không có") + " - Ngày: " + (value[6] != null ? value[6] : "Không có"), font);
	        purchaseTime.setAlignment(Paragraph.ALIGN_RIGHT); // Căn phải
	        document.add(purchaseTime);

	        // Thêm footer với lời cảm ơn - căn giữa
	        document.add(new Paragraph("=============================================================================", font));
	        Paragraph footer = new Paragraph("XIN CHÂN THÀNH CẢM ƠN QUÝ KHÁCH!", font);
	        footer.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(footer);
	        document.add(new Paragraph("=============================================================================", font));
	        
	        // Đóng tài liệu iText
	        document.close();

	        // Sử dụng PDFBox để in trực tiếp từ bộ nhớ
	        try (PDDocument pdfDoc = PDDocument.load(baos.toByteArray())) {
	            PrinterJob job = PrinterJob.getPrinterJob();
	            job.setPageable(new PDFPageable(pdfDoc));
	            if (job.printDialog()) { // Hiển thị hộp thoại in
	                job.print();
	            }
	        }

	    } catch (DocumentException | IOException | java.awt.print.PrinterException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(view, "Lỗi khi in hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void acceptdetail() {
	    if (view.getTable1().getRowCount() <= 0) {
	        JOptionPane.showMessageDialog(view, "Bạn chưa thể xác nhận hoá đơn được. Yêu cầu thanh toán sản phẩm trước", "Cảnh báo",
	                JOptionPane.WARNING_MESSAGE);
	    } else {
	        int id1 = serh.getMaxrow1();
	        
	        // Thêm vào History1
	        value = serd.getInfoBuyValue();
	        String idhd = value[1];
	        int totalprice = Integer.parseInt(value[2]);
	        int totalqty = Integer.parseInt(value[3]);
	        String phone = view.getTfphoned().getText();
	        String hour = value[5];
	        String day = value[6];

	        try {
	            // Kiểm tra chuỗi ngày
	            if (day == null || day.trim().isEmpty() || !day.matches("\\d{4}-\\d{2}-\\d{2}")) {
	                // Nếu ngày không hợp lệ, sử dụng ngày hiện tại
	                day = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
	                JOptionPane.showMessageDialog(view, "Ngày không hợp lệ, sử dụng ngày hiện tại: " + day, "Cảnh báo",
	                        JOptionPane.WARNING_MESSAGE);
	            }

	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date parsedDate = sdf.parse(day);
	            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

	            // Tạo và lưu History1M
	            History1M his1 = new History1M(id1, idhd, totalprice, totalqty, phone, sqlDate, hour, branch);
	            serh.insertHistory1(his1);

	            // Tạo và lưu History2M
            	int id2 = serh.getMaxrow2();
	            for (int i = 0; i < view.getTable1().getRowCount(); i++) {
	                String name = view.getTable1().getValueAt(i, 1).toString();
	                String idproduct = serh.getIdproductBuy(name);
	                int qty = Integer.parseInt(view.getTable1().getValueAt(i, 2).toString());
	                int price = Integer.parseInt(view.getTable1().getValueAt(i, 3).toString());
	                int totalpricee = Integer.parseInt(view.getTable1().getValueAt(i, 4).toString());
	                History2M his2 = new History2M(id2, idhd, idproduct, name, qty, price, totalpricee, sqlDate, branch);
	                serh.insertHistory2(his2);
	            }

	            // Xóa dữ liệu và cập nhật giao diện
	            serd.Deleteallbuy();
	            serd.updateInfoBuynull();
	            LoadDataB();
	            LoadDataH();
	            reloadvalue();
	            viewpurchase.setTotalprice(0);
	        } catch (Exception e) {
	            e.printStackTrace(); // In stack trace để debug
	            JOptionPane.showMessageDialog(view, "Lỗi định dạng ngày: " + e.getMessage(), "Lỗi",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	
	public void addListeners() {
		this.view.getBtnbackd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuManager.navigateToPanel("2");
            }
        });
		this.view.getBtndeleled().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deleteDetail();
            }
        });
		this.view.getBtnexportd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	exportdetail();
            }
        });
		view.getTfsearchd().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearchd().getText(); 
		        serh.getHistory1inDetail(view.getTable2(), branch, search); 
		    }
		});
		this.view.getBtnacceptd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	acceptdetail();
            }
        });
	}
}
