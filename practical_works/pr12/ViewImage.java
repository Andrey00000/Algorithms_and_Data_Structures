package pr12;

import javax.swing.*;
import java.awt.*;

public class ViewImage {
    private static JLabel imageLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon(args[0]);
        Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);


        imageLabel = new JLabel(new ImageIcon(scaled), JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

}

//java pr12.ViewImage "C:\Users\andre\JavaProjects\Algorithms and Data Structures for Real-Time Systems\practical_works\pr5\task4\image-men 02.png"
