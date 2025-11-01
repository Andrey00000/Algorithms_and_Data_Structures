package pr5.task1;

import java.awt.*;
import javax.swing.*;
public class FirstGui {
    private static int time = 30;
    private static JLabel timeLabel;
    private static boolean active = true;
    private static Timer timer;
    private static String last_team = "N/A";
    private static String winner_team = "N/A";

    public static void main(String[] args){

        JFrame frame = new JFrame("My Second GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3));
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(540, 380));

        final int[] count = {0, 0};

        JButton button1 = new JButton("AC Milan");
        JButton button2 = new JButton("Real Madrid");
        JLabel result = new JLabel("Result: "+ count[0] +"X "+ count[1]);
        JLabel last_scorer = new JLabel("Last Scorer: N/A");
        JLabel winner = new JLabel("Winner: N/A");
        timeLabel = new JLabel("Осталось: " + time, JLabel.CENTER);

        Runnable updateWinner = () -> {
            if (count[0] > count[1]){
                winner_team = "AC Milan";
            } else if (count[0]<count[1]) {
                winner_team = "Real Madrid";
            }
            else{
                winner_team = "Draw";
            }
            winner.setText("Winner: " + winner_team);
        };

        button1.addActionListener(e -> {
            if (active){
                count[0]++;
                last_team = "AC Milan";
                result.setText("Result: "+ count[0] +"X "+ count[1]);
                last_scorer.setText("Last Scorer: " + last_team);
            }
        });

        button2.addActionListener(e -> {
            if (active){
                count[1]++;
                last_team = "Real Madrid";
                result.setText("Result: "+ count[0] +"X "+ count[1]);
                last_scorer.setText("Last Scorer: " + last_team);

            }
        });

        timer = new Timer(1000,e -> {
            time--;
            timeLabel.setText("Время: "+ time);

            if (time<=0){
                active= false;
                timer.stop();
                timeLabel.setText("Время вышло!");
                updateWinner.run();
                button1.setEnabled(false);
                button2.setEnabled(false);
            }
        });




        panel.add(button1);
        panel.add(result);
        panel.add(button2);
        panel.add(timeLabel);
        panel.add(last_scorer);
        panel.add(winner);

        timer.start();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
