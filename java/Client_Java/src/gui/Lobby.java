package src.gui;

import clientInt.WordyModule.*;
import static src.WordyClientMain.wordyImpl;
import static src.gui.Login.username;

import javax.swing.*;

public class Lobby extends javax.swing.JFrame {

    public Lobby() {
        initComponents();
        initiate();
        timer();
        updatePlayerLabels(); // Call the method to populate the player labels initially
    }

    private void updatePlayerLabels() {
        Thread updateLabelsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Player_[] players = wordyImpl.getAllPlayers(username); // Retrieve the players from the server
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            updateLabels(players); // Update the player labels in the GUI
                        }
                    });
                    try {
                        Thread.sleep(1000); // Wait for 1 second before updating again
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        updateLabelsThread.start();
    }

    private void updateLabels(Player_[] players) {
        // Update the player labels with the usernames
        for (int i = 0; i < players.length; i++) {
            Player_ player = players[i];
            JLabel label;
            switch (i) {
                case 0:
                    label = player1;
                    break;
                case 1:
                    label = player2;
                    break;
                case 2:
                    label = player3;
                    break;
                case 3:
                    label = player4;
                    break;
                default:
                    continue;
            }
            label.setText(player.username);
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        player2 = new javax.swing.JLabel();
        player3 = new javax.swing.JLabel();
        player4 = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        countDown = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOBBY | " + username);

        jPanel1.setLayout(null);

        player1.setFont(new java.awt.Font("Eras Bold ITC", 0, 25)); // NOI18N
        player1.setForeground(new java.awt.Color(255, 255, 255));
        player1.setText("");
        jPanel1.add(player1);
        player1.setBounds(120, 110, 130, 32);

        player2.setFont(new java.awt.Font("Eras Bold ITC", 0, 25)); // NOI18N
        player2.setForeground(new java.awt.Color(255, 255, 255));
        player2.setText("");
        jPanel1.add(player2);
        player2.setBounds(110, 210, 150, 32);

        player3.setFont(new java.awt.Font("Eras Bold ITC", 0, 25)); // NOI18N
        player3.setForeground(new java.awt.Color(255, 255, 255));
        player3.setText("");
        jPanel1.add(player3);
        player3.setBounds(110, 320, 130, 32);

        player4.setFont(new java.awt.Font("Eras Bold ITC", 0, 25)); // NOI18N
        player4.setForeground(new java.awt.Color(255, 255, 255));
        player4.setText("");
        jPanel1.add(player4);
        player4.setBounds(110, 430, 140, 32);


        countDown.setFont(new java.awt.Font("Eras Bold ITC", 0, 72)); // NOI18N
        jPanel1.add(countDown);
        countDown.setBounds(970, 620, 100, 90);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\lobby.jpg")); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, -180, 1920, 1080);

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

    public void initiate() {
        Thread join = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wordyImpl.initiateGame(username);
                    startGame();
                } catch (NotEnoughPlayers e) {
                    wordyImpl.disposeGame(username);
                    backToMenu(e);
                }
            }
        });
        join.start();
    }

    private void startGame() {
        dispose();
        Game game = new Game();
        game.setVisible(true);
        game.pack();
        game.setLocationRelativeTo(this);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void backToMenu(NotEnoughPlayers e) {
        dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(this);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(null, e.reason, "", JOptionPane.ERROR_MESSAGE);
    }

    private void timer() {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int time = wordyImpl.getTime(username);
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

    private javax.swing.JLabel background;
    private javax.swing.JLabel countDown;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player3;
    private javax.swing.JLabel player4;
    private javax.swing.JLabel player1;

}
