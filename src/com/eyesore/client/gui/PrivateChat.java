/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eyesore.client.gui;

import com.eyesore.client.*;
import com.eyesore.client.engine.CommonSettings;
import com.eyesore.client.engine.MessageImpl;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Sora
 */
public class PrivateChat extends javax.swing.JFrame implements CommonSettings {
    
    private ChatClient chatClient;
    public String userName;
    MessageImpl messageImpl;
//    TextField TxtMessage;
//    Button CmdSend,CmdClose,CmdIgnore,CmdClear,CmdEmoticons;
//    EmotionCanvas emotioncanvas;
//    ScrollView EmotionScrollView;
    boolean emotionFlag;
//    Panel EmotionPanel;

    /**
     * Creates new form PrivateChat
     */
    public PrivateChat(ChatClient chatClient, String toUserName) { 
        this.chatClient = chatClient;
        userName = toUserName;
        
        messageImpl = new MessageImpl(chatClient);
        setTitle("Private chat with " + userName);
        //Icon function here
        initComponents();   
        txtMessage.setText("");
    }
    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnIgnore = new javax.swing.JButton();
        btnEmot = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChatList = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Conversation with ");

        txtMessage.setText("jTextField1");
        txtMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMessageKeyPressed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnIgnore.setText("Ignore User");
        btnIgnore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgnoreActionPerformed(evt);
            }
        });

        btnEmot.setText("Emoticons");
        btnEmot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmotActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtChatList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnIgnore)
                        .addGap(18, 18, 18)
                        .addComponent(btnEmot)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnIgnore)
                    .addComponent(btnEmot)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if (!(txtMessage.getText().trim().equals("")))
            sendMessage();
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        exitPrivateWindow();	
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        messageImpl.clearAll();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnIgnoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgnoreActionPerformed
        // TODO add your handling code here:
        if(evt.getActionCommand().equals("Ignore User")) {
                chatClient.tapPanel.ignoreUser(true,userName);
                messageImpl.addMessageToMessageObject(userName + " has been ignored!", MESSAGE_TYPE_ADMIN, txtChatList);
                btnIgnore.setText("Allow User");				
        }
        else
        {
                messageImpl.addMessageToMessageObject(userName +" has been removed from ignored list!",MESSAGE_TYPE_ADMIN, txtChatList);
                chatClient.tapPanel.ignoreUser(false,userName);
                btnIgnore.setText("Ignore User");					
        }
    }//GEN-LAST:event_btnIgnoreActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        exitPrivateWindow();
    }//GEN-LAST:event_formWindowClosing

    private void btnEmotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmotActionPerformed
        // TODO add your handling code here:
        if(emotionFlag){
            emotionFlag = false;
        }
    }//GEN-LAST:event_btnEmotActionPerformed

    private void txtMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessageKeyPressed
        // TODO add your handling code here:
        if((evt.getKeyCode() == 10) && (!(txtMessage.getText().trim().equals("")))){
            sendMessage();
        }
    }//GEN-LAST:event_txtMessageKeyPressed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PrivateChat().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEmot;
    private javax.swing.JButton btnIgnore;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JTextPane txtChatList;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    
    private void sendMessage() {        
        messageImpl.addMessageToMessageObject(chatClient.userName + ": " + txtMessage.getText(), MESSAGE_TYPE_DEFAULT, txtChatList);
        chatClient.sendPrivateMessageToServer(txtMessage.getText(),userName);			
        txtMessage.setText("");
        txtMessage.requestFocus();
    }
    
    protected void addMessageToMessageCanvas(String message){
        messageImpl.addMessageToMessageObject(message, MESSAGE_TYPE_DEFAULT, txtChatList);
    }

    private void exitPrivateWindow() {
        chatClient.removePrivateWindow(userName);        
        setVisible(false);  
    }
    
    protected void disableAll(){
        txtMessage.setEnabled(false);
        btnSend.setEnabled(false);
    }
    
    protected void enableAll(){
        txtMessage.setEnabled(true);
        btnSend.setEnabled(true);
    }
}