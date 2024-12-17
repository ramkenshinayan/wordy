/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.gui;

import javax.swing.*;
import static src.WordyClientMain.wordyImpl;
import static src.gui.Login.username;

public class Menu extends JFrame {

    TopWins topWins = new TopWins();
    TopWords topWords = new TopWords();

    public Menu() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        playerName = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        leaderboardsButton = new javax.swing.JLabel();
        joinButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN MENU");
        setResizable(false);

        jPanel1.setLayout(null);

        playerName.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        playerName.setForeground(new java.awt.Color(255, 255, 255));
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerName.setText(username);
        jPanel1.add(playerName);
        playerName.setBounds(50, 210, 570, 120);

        logoutButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\menu\\logout.png")); // NOI18N
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        jPanel1.add(logoutButton);
        logoutButton.setBounds(550, 510, 460, 190);

        leaderboardsButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\menu\\leaderboards.png")); // NOI18N
        leaderboardsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leaderboardsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaderboardsButtonMouseClicked(evt);
            }
        });
        jPanel1.add(leaderboardsButton);
        leaderboardsButton.setBounds(570, 330, 490, 140);

        joinButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\menu\\join.png")); // NOI18N
        joinButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        joinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                joinButtonMouseClicked(evt);
            }
        });
        jPanel1.add(joinButton);
        joinButton.setBounds(590, 60, 470, 250);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\menu.jpg")); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, -180, 1920, 1080);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );

        pack();
    }

    private void joinButtonMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        Lobby rgf = new Lobby();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(this);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void leaderboardsButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String[] options = { "Winners", "Longest Words"};
        int selection = JOptionPane.showOptionDialog(null, "Top 5...", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (selection == 0) {
            dispose();
            topWins.pack();
            topWins.setLocationRelativeTo(this);
            topWins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            topWins.setVisible(true);
        }
        if (selection == 1) {
            dispose();
            topWords.pack();
            topWords.setLocationRelativeTo(this);
            topWords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            topWords.setVisible(true);
        }
    }

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String[] options = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(this,
                "Are you sure?", "Logout",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (choice == 0) {
            wordyImpl.logout(username);
        }
        if (choice == 1) {
            return;
        }
        Login rgf = new Login();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(this);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel joinButton;
    private javax.swing.JLabel leaderboardsButton;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel playerName;

}
