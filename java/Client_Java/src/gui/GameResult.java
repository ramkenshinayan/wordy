package src.gui;

import clientInt.WordyModule.Player_;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.Arrays;

import static src.WordyClientMain.wordyImpl;
import static src.gui.Login.username;

public class GameResult extends JFrame {

    int time;
    public GameResult() {
        initComponents();
        timer();
        updateGameResultTable();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        countDown = new javax.swing.JLabel();
        gameResult = new javax.swing.JTable();
        playerWinner = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RESULTS");
        setResizable(false);

        jPanel1.setLayout(null);

        countDown.setFont(new java.awt.Font("Eras Bold ITC", 0, 45)); // NOI18N
        countDown.setForeground(new java.awt.Color(233, 0, 3));
        countDown.setText("10");
        jPanel1.add(countDown);
        countDown.setBounds(980, 650, 40, 60);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        gameResult.setDefaultRenderer(Object.class, centerRenderer);

        gameResult.setBackground(new java.awt.Color(0, 0, 0));
        gameResult.setFont(new java.awt.Font("Eras Bold ITC", 0, 20)); // NOI18N
        gameResult.setForeground(new java.awt.Color(255, 255, 255));
        gameResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "Wins"
            }
        ));
        gameResult.setTableHeader(null);
        jScrollPane.setViewportView(gameResult);
        jPanel1.add(jScrollPane);
        jScrollPane.setBounds(310, 340, 460, 150);

        playerWinner.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        playerWinner.setForeground(new java.awt.Color(255, 255, 255));
        playerWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(playerWinner);
        playerWinner.setBounds(190, 430, 710, 190);

        playerWinner.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        playerWinner.setForeground(new java.awt.Color(255, 255, 255));
        playerWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerWinner.setText("");
        jPanel1.add(playerWinner);
        playerWinner.setBounds(190, 300, 710, 190);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\gameResult.jpg")); // NOI18N
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

    private void updateGameResultTable() {
        Player_[] players = wordyImpl.getAllPlayers(username);
        DefaultTableModel model = (DefaultTableModel) gameResult.getModel();
        Arrays.sort(players, (p1, p2) -> p2.roundWins - p1.roundWins);
        for (int i = 0; i < players.length; i++) {
            Player_ player = players[i];
            if (i >= model.getRowCount()) {
                model.addRow(new Object[]{player.username, player.roundWins});
            } else {
                model.setValueAt(player.username, i, 0);
                model.setValueAt(player.roundWins, i, 1);
            }
        }
    }

    private void timer() {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                time = 10;
                while (time > 0) {
                    countDown.setText(String.valueOf(time));
                    time--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                wordyImpl.disposeGame(username);
                showMenu();
            }
        });
        timer.start();
    }

    private void showMenu() {
        Menu rgf = new Menu();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(this);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel countDown;
    private javax.swing.JLabel playerWinner;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable gameResult;

}
