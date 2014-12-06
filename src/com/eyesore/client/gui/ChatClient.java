/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eyesore.client.gui;

import com.eyesore.client.engine.MessageImpl;
import com.eyesore.client.engine.TabPanelImpl;
import com.eyesore.client.network.SocksSocket;
import com.eyesore.client.network.SocksSocketImplFactory;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sora
 */
public class ChatClient extends javax.swing.JFrame implements com.eyesore.client.engine.CommonSettings, Runnable{
    private Socket socket;
    private InformationDialog dialog;
    private String serverName, userRoom, serverData, roomList, bannerName, chatLogo, proxyHost, splitString;
    public String userName;
    public String[] roomArray, userArray;
    private int serverPort, totalUserCount, proxyPort;
    public int iconCount, tokenCount;
    private boolean isProxy;
    private MessageImpl messageImpl;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private boolean startFlag;
    private Thread thread;
    private StringTokenizer tokenizer;
    private StringBuffer stringBuffer;
    private Toolkit toolkit;
    private Dimension dimension;
    private MediaTracker tracker;
    private Image imgLogo, imgBanner;
    public Image[] iconArray;
//    protected PrivateChat[] privateWindow;
    protected int privateWindowCount;
//    protected MessageCanvas messageCanvas;
    public Font textFont;
    private TabPanelImpl tapPanel;
    
    
    /**
     * Creates new form ChatClient
     */
    public ChatClient() {
//        toolkit = Toolkit.getDefaultToolkit();
//        if(toolkit.getScreenSize().getWidth() > 628)
//            setSize(628, 512);
//        else
//            setSize((int)toolkit.getScreenSize().getWidth(),(int)toolkit.getScreenSize().getHeight() - 20);
//        
//        setResizable(false);
//        dimension = getSize();
        
        
        
//        tracker = new MediaTracker(this);
//        int imageCount = 0;
//        imgLogo = toolkit.getImage(chatLogo);
//        tracker.addImage(imgLogo,imageCount);
//        imageCount++;
//        imgBanner = toolkit.getImage(bannerName);		
//        tracker.addImage(imgBanner,imageCount);
//        imageCount++;
        
//        iconArray = new Image[iconCount];
//        for(int i=0; i<iconCount; i++){
//            iconArray[i] = toolkit.getImage("icons/photo" + i + ".gif");
//            tracker.addImage(iconArray[i], imageCount);
//            imageCount++;
//        }
        
        //privateWindow = new PrivateChat[MAX_PRIVATE_WINDOW];
//        privateWindowCount = 0;
        
//        try {
////            setAppletStatus("Loading images and icons ...");
//            tracker.waitForAll();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        setIconImage(toolkit.getImage("images/logo.gif"));
//        setAppletStatus("");
        
//        intializeAppletComponents();
        
        
        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCanvas = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInformation = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList();
        btnIgnore = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstRooms = new javax.swing.JList();
        btnChangeRoom = new javax.swing.JButton();
        txtUserCount = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemLogin = new javax.swing.JMenuItem();
        itemDisconnect = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setViewportView(txtCanvas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AUJU Technologies");

        lblInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformation.setText("User Name :");

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Name");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Room Name :");

        lblRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRoom.setText("Room");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("User Amount :");

        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmount.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAmount)
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInformation)
                    .addComponent(lblName)
                    .addComponent(jLabel4)
                    .addComponent(lblRoom)
                    .addComponent(jLabel6)
                    .addComponent(lblAmount))
                .addContainerGap())
        );

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

        jButton2.setText("Exit");

        lstUsers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstUsers);

        btnIgnore.setText("Ignore User");

        jButton4.setText("Send Private Message");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(btnIgnore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(0, 0, 0)
                .addComponent(btnIgnore))
        );

        tabPanel.addTab("<html><body leftmargin=0 topmargin=8 marginwidth=18 marginheight=5>Users</body></html>", jPanel2);

        lstRooms.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstRooms);

        btnChangeRoom.setText("Change Room");
        btnChangeRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeRoomActionPerformed(evt);
            }
        });

        txtUserCount.setText("Total User :");
        txtUserCount.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(btnChangeRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .addComponent(txtUserCount)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnChangeRoom))
        );

        tabPanel.addTab("<html><body leftmargin=0 topmargin=8 marginwidth=18 marginheight=5>Rooms</body></html>", jPanel3);

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        tabPanel.addTab("<html><body leftmargin=0 topmargin=8 marginwidth=20 marginheight=5>Emoticons</body></html>", jPanel4);

        jMenu1.setText("Login");

        itemLogin.setText("Login");
        itemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLoginActionPerformed(evt);
            }
        });
        jMenu1.add(itemLogin);

        itemDisconnect.setText("Disconnect");
        jMenu1.add(itemDisconnect);
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem4.setText("About");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSend)
                        .addComponent(jButton2))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        disconnectChat();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void itemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemLoginActionPerformed

    private void btnChangeRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeRoomActionPerformed
        // TODO add your handling code here:
//        changeRoom();
    }//GEN-LAST:event_btnChangeRoomActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if(!(txtMessage.getText().trim().equals(""))){
            sendMessage();
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessageKeyPressed
        // TODO add your handling code here:
        if(!(txtMessage.getText().trim().equals(""))){
            sendMessage();
        }
    }//GEN-LAST:event_txtMessageKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeRoom;
    protected javax.swing.JButton btnIgnore;
    private javax.swing.JButton btnSend;
    private javax.swing.JMenuItem itemDisconnect;
    private javax.swing.JMenuItem itemLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JList lstRooms;
    private javax.swing.JList lstUsers;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextPane txtCanvas;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtUserCount;
    // End of variables declaration//GEN-END:variables

    private void initData(){
        userName = "";
        userRoom = "";
        roomList = "";
        iconCount = 21;
        bannerName = "alamat";
        chatLogo = "logo chat";
        isProxy = false;
        messageImpl = new MessageImpl(this);
        tapPanel = new TabPanelImpl(this);
        
        updateInformationLabel();
        disableAll();
        loginToChat();
    }
    
    /**
     * Open the dialog. 
     * get the information if already login.
     * show information dialog if no instead.
     */
    private void loginToChat() {
        /********* Open the Dialog *********/
        dialog = new InformationDialog(this, true);
        dialog.setVisible(true);
        if (dialog.isConnect == true){
            userName = dialog.txtUserName.getText();
            serverName 	= dialog.txtServerName.getText();
            serverPort 	= Integer.parseInt(dialog.txtServerPort.getText());
            if(dialog.chkProxy.isSelected() == true){
                isProxy = true;
                proxyHost = dialog.txtProxyHost.getText();
                proxyPort = Integer.parseInt(dialog.txtProxyPort.getText());
            }
            else{
                isProxy = false;	
            }
            //System.out.println("" + userName + serverName + serverPort);
            connectToServer();				
        }		
    }
    
    private void sendMessage(){
        System.out.println("user room : " + userRoom);
        sendMessageToServer("MESS " + userRoom+ "~" + userName + ": " + txtMessage.getText());
        messageImpl.addMessageToMessageObject(userName + ": " + txtMessage.getText(), MESSAGE_TYPE_DEFAULT, txtCanvas);
        txtMessage.setText("");
        txtMessage.requestFocus();
    }
    
    private void connectToServer() {
        try {
            messageImpl.clearAll();
            messageImpl.addMessageToMessageObject("Connecting To Server... Please Wait...",MESSAGE_TYPE_ADMIN, txtCanvas);
            
            if(isProxy){
                SocksSocketImplFactory factory = new SocksSocketImplFactory(proxyHost, proxyPort);
                SocksSocket.setSocketImplFactory(factory);
                socket = new SocksSocket(serverName, serverPort);
                socket.setSoTimeout(0);
            } else{
                socket = new Socket(serverName, serverPort);
            }
                        
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            sendMessageToServer("HELO "+ userName);			
            dataInputStream  = new DataInputStream(socket.getInputStream());
            
            /***********Send HELO To Server **********/
            startFlag = true;			
            thread = new Thread(this);
            thread.start();				
            enableAll();
        } catch (IOException ex) {
            quitConnection(QUIT_TYPE_NULL);
        }
        
    }

    /**
     * Send anything message to server.
     * 
     * @param message 
     */
    private void sendMessageToServer(String message) {
        try {
            dataOutputStream.writeBytes(message+"\r\n");            
        }catch(IOException _IoExc) { quitConnection(QUIT_TYPE_DEFAULT);}
    }

    /**
     * Enable all button and text pane.
     */
    private void enableAll() {
        txtMessage.setEnabled(true);
        btnSend.setEnabled(true);
        tabPanel.enable(true);	
        itemDisconnect.setEnabled(true);
        itemLogin.setEnabled(false);
    }

    /**
     * Stop connection. Stop all thread and clear data list for user
     * and room. 
     * <br> <br>     * 
     * NOTE : CHECK JEEVA. Shall be edited.
     * 
     * @param quitType 
     */
    private void quitConnection(int quitType) {
        if(socket != null){
            try {
                if (quitType == QUIT_TYPE_DEFAULT)
                        sendMessageToServer("QUIT "+userName+"~"+userRoom);
                if (quitType == QUIT_TYPE_KICK)
                        sendMessageToServer("KICK "+userName+"~"+userRoom);
                socket.close();	
                socket = null;
                String[] a = new String[1];
                a[0] = "";    a[1] = "";
                lstUsers.setListData(a);
                lstRooms.setListData(a);
            }catch(IOException _IoExc) { }			
        }
        if(thread != null)
        {
                thread.stop();
                thread = null;
        }		
        disableAll();
        startFlag = false;
        setAppletStatus("ADMIN: CONNECTION TO THE SERVER CLOSED.");
    }

    /**
     * Disable few button, text pane and item menu.
     */
    private void disableAll() {
        txtMessage.setEnabled(false);
        btnSend.setEnabled(false);
        tabPanel.enable(false);	
        itemDisconnect.setEnabled(false);
        itemLogin.setEnabled(true);
        
        userName = "";
	userRoom = "";
	totalUserCount = 0;
    }

    /**
     * Give a message with admin type.
     * 
     * @param message 
     */
    private void setAppletStatus(String message) {
        if (messageImpl != null)
            messageImpl.addMessageToMessageObject(message,MESSAGE_TYPE_ADMIN, txtCanvas);
    }


//    private void changeRoom() {
//        if(lstRooms.equals("")){
//            messageCanvas.addMessageToMessageObject("Invalid room", MESSAGE_TYPE_ADMIN);
//            return;
//        }
//    }

    @Override
    public void run() {
        while(thread != null){
            try {
                serverData = dataInputStream.readLine();
                String b ="";
                b+= serverData;
                System.out.println("server data : " + b);
                if (serverData.startsWith("KICK")) {
                    messageImpl.addMessageToMessageObject("You are Kicked Out From Chat for flooding the message!",MESSAGE_TYPE_ADMIN, txtCanvas);
                    thread = null;
                    quitConnection(QUIT_TYPE_KICK);	
                }
                
                if(serverData.startsWith("EXIS")){
                    messageImpl.addMessageToMessageObject("User name already exists. Try again with some other name!", MESSAGE_TYPE_ADMIN, txtCanvas);
                    thread = null;
                    quitConnection(QUIT_TYPE_NULL);
                }
                
                if(serverData.startsWith("ROOM")){
                    tokenizer = new StringTokenizer(serverData.substring(5), ";");        
                    userRoom = getRoomList()[0];                    
                    
                    updateInformationLabel();
                    
                    tapPanel.clearAll();
                    tapPanel.addListItemToMessageObject(userRoom, lstRooms, ROOM_CANVAS);
                    while(tokenizer.hasMoreTokens()){
                        tapPanel.addListItemToMessageObject(tokenizer.nextToken(), lstRooms, ROOM_CANVAS);
                    }
                }
                
                if(serverData.startsWith("ADD")){
                    totalUserCount++;
                    updateInformationLabel();
                    
                    splitString = serverData.substring(5);
                    enablePrivateWindow(splitString);
                   
                    tapPanel.addListItemToMessageObject(splitString, lstRooms, USER_CANVAS);
                    messageImpl.addMessageToMessageObject(splitString + " joins chat.", MESSAGE_TYPE_JOIN, txtCanvas);
                    
                    userArray[totalUserCount - 1] = splitString;
                    tapPanel.addListItemToMessageObject(splitString, lstUsers, USER_CANVAS);
                }
                
                if(serverData.startsWith("LIST")){
                    tokenizer = new StringTokenizer(serverData.substring(5), ";");
                    totalUserCount = tokenizer.countTokens();
                    updateInformationLabel();
                    tapPanel.clearAll();
                    userArray = new String[totalUserCount + 1];
                    System.out.println("total user count : " + totalUserCount);
                    int i=0;
                    
                    while(tokenizer.hasMoreTokens()){ 
                        
                        userArray[i] = tokenizer.nextToken();
                        tapPanel.addListItemToMessageObject(userArray[i], lstUsers, USER_CANVAS);
                        i++;
                    }
                    
                    messageImpl.clearAll();
                    messageImpl.addMessageToMessageObject("Welcome to the " + userRoom + " room!", MESSAGE_TYPE_JOIN, txtCanvas);
                }
                
                if(serverData.startsWith("MESS")){                                       
                    if(!(tapPanel.isIgnoreUser(serverData.substring(5, serverData.indexOf(":"))))){
                        messageImpl.addMessageToMessageObject(serverData.substring(5), MESSAGE_TYPE_DEFAULT, txtCanvas);
                    }                    
                }
                
                if(serverData.startsWith("ROCO")){
                    splitString = serverData.substring(5, serverData.indexOf("~"));
                    txtUserCount.setText("Total users in " + splitString + " : " + serverData.substring(serverData.indexOf("~") + 1));
                }
            } catch (IOException ex) {
                messageImpl.addMessageToMessageObject(ex.getMessage(),MESSAGE_TYPE_ADMIN, txtCanvas);
                quitConnection(QUIT_TYPE_DEFAULT);
            }
            
            
        }
    }

    private void updateInformationLabel() {
        lblName.setText(userName);
        lblRoom.setText(userRoom);
        lblAmount.setText("" +totalUserCount);
    }

    private void enablePrivateWindow(String splitString) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String[] getRoomList(){
        int i=0;
        roomArray = new String[tokenizer.countTokens()];
        tokenCount = tokenizer.countTokens() - 1;
        //System.out.println("count : " + tokenizer.countTokens());
        
        while(tokenizer.hasMoreTokens()){
            
            roomArray[i] = tokenizer.nextToken();
            i++;
        }
        return roomArray;
    }
    
    public String[] getUserList(){
        return userArray;
    }
    
    public void setUserArray(String[] userArray){
        this.userArray = userArray;
    }
}