package multimedia.project;

import javax.swing.*;
import java.awt.*;

public class VideoPlayerView extends JFrame {
    public JLabel statusLabel = new JLabel("جاري عرض الدرس التعليمي...");
    public JProgressBar videoProgress = new JProgressBar(0, 100);
    public JButton playButton = new JButton("تشغيل الفيديو");
    public JLabel timerLabel = new JLabel("00:00");

    public VideoPlayerView() {
        setTitle("مشروع دينا المزين - الوسائط المتعددة");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JPanel videoScreen = new JPanel(new GridBagLayout());
        videoScreen.setBackground(Color.BLACK);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        videoScreen.add(statusLabel);

        JPanel controls = new JPanel(new BorderLayout(10, 10));
        controls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        videoProgress.setStringPainted(true);
        controls.add(videoProgress, BorderLayout.CENTER);
        controls.add(playButton, BorderLayout.WEST);
        controls.add(timerLabel, BorderLayout.EAST);

        add(videoScreen, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }
}