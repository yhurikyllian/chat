/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eyesore.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Sora
 */
public class ChatCommunication implements Runnable, CommonSettings {
    
    private Thread thread;
    private Socket socket;
    private DataInputStream inputstream;
    private String RFC;
    private ChatServer parent;
    
    /********Initialize the Socket to the Client***********/
    ChatCommunication(ChatServer chatserver,Socket clientsocket) {				
        parent = chatserver;
        socket = clientsocket;	
        try {	
            inputstream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));		
        } catch(IOException IOExc) { }
        
        thread = new Thread(this);
        thread.start();	
    }

    @Override
    public void run() {
        while(thread != null) {
            try {				
                RFC = inputstream.readLine();											
                /*******RFC Checking**************/
                if(RFC.startsWith("HELO")) {					
                        parent.addUser(socket,RFC.substring(5));														
                }

                if(RFC.startsWith("QUIT")) {                
                        parent.removeUser(RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1),REMOVE_USER);
                        quitConnection();	
                }

                if(RFC.startsWith("KICK")) {
                        parent.removeUser(RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1),KICK_USER);
                        quitConnection();
                }

                if(RFC.startsWith("CHRO")) {
                        parent.changeRoom(socket,RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("MESS")) {
                        parent.sendGeneralMessage(socket,RFC.substring(RFC.indexOf(":")+1),RFC.substring(RFC.indexOf("~")+1,RFC.indexOf(":")),RFC.substring(5,RFC.indexOf("~")));	
                }

                if(RFC.startsWith("PRIV")) {
                        parent.sendPrivateMessage(RFC.substring(RFC.indexOf("~")+1),RFC.substring(5,RFC.indexOf("~")));	
                }

                if(RFC.startsWith("ROCO")) {
                        parent.getUserCount(socket,RFC.substring(5));	
                }	
                
                if(RFC.startsWith("CALL")) {
                        parent.requestForVoiceChat(socket,RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("ACCE")) {
                        parent.sendUserIP(socket,RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("CANC")) {
                        parent.rejectCall(RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("QVCT")) {
                        parent.quitVoiceChat(RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("REIP")) {
                        parent.getRemoteUserAddress(socket,RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }

                if(RFC.startsWith("AEIP")) {
                        parent.sendRemoteUserAddress(socket,RFC.substring(5,RFC.indexOf("~")),RFC.substring(RFC.indexOf("~")+1));	
                }	
                if(RFC.startsWith("QUVC")) {
                        parent.quitVideoChat(RFC.substring(5));	
                }	


            }catch(Exception _Exc) {
                parent.removeUserWhenException(socket);
                quitConnection();}	
            }
    }

    private void quitConnection() {
        thread.stop();
        thread = null;
        
        try {
            socket.close();
            socket = null;
        }catch(IOException _IOExc) { }   
    }
    
}
