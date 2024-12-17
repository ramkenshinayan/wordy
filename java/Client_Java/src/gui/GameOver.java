package src.gui;

import javax.swing.JFrame;

import static src.WordyClientMain.wordyImpl;
import static src.gui.Login.username;

public class GameOver extends JFrame {

    int time;
    public GameOver() {
        initComponents();
        timer();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        countDown = new javax.swing.JLabel();
        playerWinner = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        countDown.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        countDown.setForeground(new java.awt.Color(235, 235, 235));
        countDown.setText("5");
        jPanel1.add(countDown);
        countDown.setBounds(980, 640, 40, 60);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME OVER");

        jPanel1.setLayout(null);

        playerWinner.setFont(new java.awt.Font("Eras fBold ITC", 0, 48)); // NOI18N
        playerWinner.setForeground(new java.awt.Color(255, 255, 255));
        playerWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerWinner.setText(wordyImpl.getGameWinner(username));
        jPanel1.add(playerWinner);
        playerWinner.setBounds(610, 396, 400, 60);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\gameOver.jpg")); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1080, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void timer() {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                time = 5;
                while (time > 0) {
                    countDown.setText(String.valueOf(time));
                    time--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                showNext();
            }
        });
        timer.start();
    }

    private void showNext() {
        GameResult gameResult = new GameResult();
        gameResult.setLocationRelativeTo(null);
        gameResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameResult.setVisible(true);
        this.dispose();
    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel countDown;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel playerWinner;

}
