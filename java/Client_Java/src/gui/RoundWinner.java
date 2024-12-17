// TODO longestWord label alignment

package src.gui;

import clientInt.WordyModule.RoundWinner_;

public class RoundWinner extends javax.swing.JFrame {

    int time;
    RoundWinner_ roundWinner;

    public RoundWinner(RoundWinner_ roundWinner) {
        this.roundWinner = roundWinner;
        initComponents();
        timerDisplay();
    }

    private void timerDisplay() {
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
            }
        });
        timer.start();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        countDown = new javax.swing.JLabel();
        roundWinnerName = new javax.swing.JLabel();
        winningWord = new javax.swing.JLabel();
        wins = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setLayout(null);

        countDown.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        countDown.setForeground(new java.awt.Color(235, 234, 101));
        countDown.setText("5");
        jPanel1.add(countDown);
        countDown.setBounds(1010, 660, 40, 60);

        roundWinnerName.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        roundWinnerName.setForeground(new java.awt.Color(235, 234, 101));
        roundWinnerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundWinnerName.setText("<longest word>");
        jPanel1.add(roundWinnerName);
        roundWinnerName.setBounds(30, 360, 1030, 60);

        winningWord.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        winningWord.setForeground(new java.awt.Color(255, 255, 255));
        winningWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(winningWord);
        winningWord.setBounds(50, 570, 340, 50);

        wins.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 48)); // NOI18N
        wins.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(wins);
        wins.setBounds(880, 560, 40, 60);

        if (roundWinner.roundWins == 3) {
            background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\roundWinnerEnd.jpg"));
        } else {
            background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\roundWinner.jpg")); // NOI18N
        }
        jPanel1.add(background);
        background.setBounds(0, 0, 1080, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();

        System.out.println("Round over. Winner: " + roundWinner.name + " Wins: " + roundWinner.roundWins);
        winningWord.setText(roundWinner.winningWord);
        wins.setText(String.valueOf(roundWinner.roundWins));
        roundWinnerName.setText(roundWinner.name);
    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel countDown;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel roundWinnerName;
    private javax.swing.JLabel winningWord;
    private javax.swing.JLabel wins;

}
