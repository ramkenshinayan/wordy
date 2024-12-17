/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.gui;

import clientInt.WordyModule.InvalidLoginException;
import static src.WordyClientMain.wordyImpl;

import javax.swing.*;

public class Login extends JFrame {

    public static String username;

    public Login() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        enterButton = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setLayout(null);

        enterButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\login\\enter.jpg")); // NOI18N
        enterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterButtonClicked();
            }
        });
        jPanel1.add(enterButton);
        enterButton.setBounds(420, 520, 320, 100);

        usernameField.setBackground(new java.awt.Color(0, 0, 0));
        usernameField.setFont(new java.awt.Font("Eras Demi ITC", 0, 48)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setBorder(null);
        jPanel1.add(usernameField);
        usernameField.setBounds(420, 310, 390, 40);

        passwordField.setBackground(new java.awt.Color(0, 0, 0));
        passwordField.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(null);
        passwordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(passwordField);
        passwordField.setBounds(420, 430, 380, 30);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\login.jpg")); // NOI18N
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

    private void enterButtonClicked() {
        try {
            if (usernameField == null || passwordField == null) {
                JOptionPane.showMessageDialog(this, "Username/Password cannot be empty", "Login Error", JOptionPane.ERROR_MESSAGE);
            } else {
                wordyImpl.login(usernameField.getText(), passwordField.getText());
                username = usernameField.getText();
                Menu menu = new Menu();
                menu.setVisible(true);
                menu.setLocationRelativeTo(this);
                dispose();
            }
        } catch (InvalidLoginException e) {
            JOptionPane.showMessageDialog(this, e.reason, "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel enterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;

}
