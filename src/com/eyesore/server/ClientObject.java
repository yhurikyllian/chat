/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eyesore.server;

import java.net.Socket;

/**
 *
 * @author Sora
 */
public class ClientObject {
    private Socket clientSocket;
    private String clientUserName, clientRoomName;

    public ClientObject(Socket clientSocket, String clientUserName, String clientRoomName) {
        this.clientSocket = clientSocket;
        this.clientUserName = clientUserName;
        this.clientRoomName = clientRoomName;
    }
    
    public void setSocket(Socket socket){
        clientSocket = socket;
    }
    
    public void setUserName(String userName){
        clientUserName = userName;
    }
    
    public void setRoomName(String roomName){
        clientRoomName = roomName;
    }
    
    public Socket getSocket(){
        return clientSocket;
    }
    
    public String getUserName(){
        return clientUserName;
    }
    
    public String getRoomName(){
        return clientRoomName;
    }
    
}
