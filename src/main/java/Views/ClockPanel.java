package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ClockPanel extends JPanel {

    private final int width = 160;
    private final int height = 160;

    public ClockPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(136, 190, 240));

        // Timer cập nhật mỗi giây
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 2 - 10;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Vẽ hình tròn trắng với viền màu #4da1a9
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Vẽ các mốc giờ (12 gạch nhỏ)
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30); // 360/12 = 30 độ mỗi giờ
            int outerX = centerX + (int) (radius * Math.sin(angle));
            int outerY = centerY - (int) (radius * Math.cos(angle));
            int innerX = centerX + (int) ((radius - 10) * Math.sin(angle));
            int innerY = centerY - (int) ((radius - 10) * Math.cos(angle));
            g2d.drawLine(innerX, innerY, outerX, outerY);
        }

        // Lấy thời gian hiện tại
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);

        // Tính toán góc
        double minuteAngle = Math.toRadians(minute * 6); // mỗi phút = 6 độ
        double hourAngle = Math.toRadians((hour % 12 + minute / 60.0) * 30); // mỗi giờ = 30 độ

        // Tính toạ độ kim phút
        int minuteLength = radius - 15;
        int xMinute = centerX + (int) (minuteLength * Math.sin(minuteAngle));
        int yMinute = centerY - (int) (minuteLength * Math.cos(minuteAngle));

        // Tính toạ độ kim giờ
        int hourLength = radius - 30;
        int xHour = centerX + (int) (hourLength * Math.sin(hourAngle));
        int yHour = centerY - (int) (hourLength * Math.cos(hourAngle));

        // Vẽ kim phút
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        g2d.drawLine(centerX, centerY, xMinute, yMinute);

        // Vẽ kim giờ
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.RED);
        g2d.drawLine(centerX, centerY, xHour, yHour);

        // Vẽ chấm ở tâm
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - 3, centerY - 3, 6, 6);
    }

    // Main để chạy thử
    public static void main(String[] args) {
        JFrame frame = new JFrame("Đồng hồ tròn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClockPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
