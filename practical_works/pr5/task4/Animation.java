package pr5.task4;

import javax.swing.*;
import java.awt.*;

public class Animation {
    private static ImageIcon[] frames; // ⭐ Теперь массив вместо ArrayList
    private static int currentFrame = 0;
    private static Timer animationTimer;
    private static JLabel animationLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Анимация из кадров");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new BorderLayout());

        loadAnimationFrames();

        animationLabel = new JLabel(frames[0], JLabel.CENTER);
        panel.add(animationLabel, BorderLayout.CENTER);


        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Старт");
        JButton stopButton = new JButton("Стоп");


        animationTimer = new Timer(100, e -> {
            currentFrame = (currentFrame + 1) % frames.length;
            animationLabel.setIcon(frames[currentFrame]);
        });

        startButton.addActionListener(e -> animationTimer.start());
        stopButton.addActionListener(e -> animationTimer.stop());

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        panel.add(controlPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void loadAnimationFrames() {
        int frameCount = 6;
        frames = new ImageIcon[frameCount];
        String start_path = "C:\\Users\\andre\\JavaProjects\\Algorithms and Data Structures for Real-Time Systems\\practical_works\\pr5\\task4\\";
        for (int i = 0; i < frameCount; i++) {
            String filename = start_path + String.format("image-men %02d.png", i + 1);
            ImageIcon icon = new ImageIcon(filename);
            Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            frames[i] = new ImageIcon(scaled);
        }
    }
}