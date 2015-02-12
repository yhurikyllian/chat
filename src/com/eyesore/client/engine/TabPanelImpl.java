/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyesore.client.engine;

import com.eyesore.client.gui.ChatClient;
import com.eyesore.client.gui.PrivateChat;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author sora
 */
public class TabPanelImpl implements CommonSettings{
    private ChatClient chatClient;
    private ArrayList listArray;
    private MessageObject messageObject;
    private int canvasType;
    public String selectedUser;
    private String[] displayArray;
    
    public TabPanelImpl(ChatClient chatClient){
        this.chatClient = chatClient;
        listArray = new ArrayList();
        selectedUser = "";
        //image canvas should be here
           
    }
    
    public void clearAll(){
        listArray.clear();
    }
    
    public void addListItemToMessageObject(String listItem, JList list, int canvas){
        if(listArray.size() > 0){
            messageObject = (MessageObject) listArray.get(listArray.size() -1);
        }
        
        messageObject = new MessageObject();
        messageObject.message = listItem;
        messageObject.selected = false;
        listArray.add(messageObject);
        display(list, canvas);
    }

    private void display(JList list, int canvas) {
        int listArraySize = listArray.size();
        //displayArray = new String[list.getModel().getSize()];
        displayArray = new String[listArraySize];
        for(int i=0; i<listArraySize; i++){
            messageObject = (MessageObject) listArray.get(i);
            //System.out.println("message Object : " + messageObject.message);
            displayListItem(list, canvas, i);
        }
    }

    private void displayListItem(JList list, int canvas, int counter) {
        int imageIndex = ROOM_CANVAS_ICON;
        
        switch(canvas){
            case USER_CANVAS:
                if(messageObject.isIgnored == true){
                    imageIndex = USER_CANVAS_IGNORE_ICON;
                } else{
                    imageIndex = USER_CANVAS_NORMAL_ICON;
                }
                
                //array = chatClient.userArray;                
                displayArray[counter] = messageObject.message;
            break;
            case ROOM_CANVAS:                
                displayArray = chatClient.roomArray;
             break;
        }
        
        
        list.setListData(displayArray);
        
    }
    
    public void setCanvasType(int type){
        if(type == ROOM_CANVAS){
            this.canvasType = ROOM_CANVAS;
        } else {
            this.canvasType = USER_CANVAS;
        }
    }
    
    public boolean isIgnoreUser(String userName){
        int listIndex = getIndexOf(userName);
        
        if(listIndex >= 0){
            messageObject = (MessageObject) listArray.get(listIndex);
            return messageObject.isIgnored;
        }
        
        return false;
    }

    private int getIndexOf(String message) {
        int listSize = listArray.size();
        for(int i=0; i<listSize; i++){
            messageObject = (MessageObject) listArray.get(i);
            if(messageObject.message.equals(message)){
                return i;
            }
        }
        return -1;
    }
    
    public void ignoreUser(boolean isIgnore, String ignoreUserName){
        int listIndex = getIndexOf(ignoreUserName);
        if(listIndex >= 0){
            messageObject = (MessageObject) listArray.get(listIndex);
            messageObject.isIgnored = isIgnore;
            listArray.set(listIndex, messageObject);
            
            if(isIgnore){
                chatClient.btnIgnore.setText("Allow User");
                chatClient.messageImpl.addMessageToMessageObject(ignoreUserName + " has been ignored!", MESSAGE_TYPE_LEAVE, chatClient.txtCanvas);
            } else{
                chatClient.btnIgnore.setText("Ignore User");
                chatClient.messageImpl.addMessageToMessageObject(ignoreUserName + " has been removed from ignored list!", MESSAGE_TYPE_JOIN, chatClient.txtCanvas);
            }
        }
    }
    
    public void ignoreUser(boolean isIgnore){
        if(selectedUser.equals("")){            
            chatClient.messageImpl.addMessageToMessageObject("Invalid user selection!", MESSAGE_TYPE_ADMIN, chatClient.txtCanvas);
            return;
        }
        
        if(selectedUser.equals(chatClient.userName)){            
            chatClient.messageImpl.addMessageToMessageObject("You can't ignored yourself!", MESSAGE_TYPE_ADMIN, chatClient.txtCanvas);
            return;
        }
        
        ignoreUser(isIgnore, selectedUser);
    }
    
    public void fillSelectedUser(JList list){
        int listArraySize = listArray.size();
        boolean selectedFlag = false;
        chatClient.btnIgnore.setText("Ignore User");
        chatClient.txtUserCount.setText("");
        
        for(int i=0; i<listArraySize; i++){
            messageObject = (MessageObject) listArray.get(i);
            
            if(!(list.getSelectedValue().equals(messageObject.message))){
                messageObject.selected = false;
            } else {
                messageObject.selected = true;
                selectedUser = messageObject.message;
                selectedFlag = true;

                if(canvasType == USER_CANVAS){
                    if(isIgnoreUser(selectedUser)){
                        chatClient.btnIgnore.setText("Allow User");                    
                    } else{
                        chatClient.btnIgnore.setText("Ignore User");
                    }
                }
            }            
        }
        display(list, USER_CANVAS);
        if(!(selectedFlag)){
            selectedUser = "";
        }
    }
    
    public void sendDirectMessage(){
        if(selectedUser.equals("")){
            chatClient.messageImpl.addMessageToMessageObject("Invalid user selection!", MESSAGE_TYPE_ADMIN, chatClient.txtCanvas);
            return;
        }
        
        if(selectedUser.equals(chatClient.userName)){
            chatClient.messageImpl.addMessageToMessageObject("You can't chat with yourself!", MESSAGE_TYPE_ADMIN, chatClient.txtCanvas);
            return;
        }
        
        chatClient.createPrivateWindow();
    }
    
    public void removeListItem(String listItem, JList list){
        int listIndex = getIndexOf(listItem);
        System.out.println("list index : " + listIndex);
        if(listIndex>=0){
            messageObject = (MessageObject) listArray.get(listIndex);
            //System.out.println("MessageObject : " + messageObject.message);
            listArray.remove(listIndex);
            int listSize = listArray.size();
            System.out.println("List size : " + listSize);
            for(int i= listIndex; i<listSize; i++){
                messageObject = (MessageObject) listArray.get(i);
                //displayListItem(list, USER_CANVAS, i);
            }
        }
        display(list, USER_CANVAS);
    }

    /*private void createPrivateWindow() {
        if(!(isIgnoreUser(selectedUser))){
            boolean privateFlag = false;
            
            for(int i=0; i<chatClient.privateWindowCount; i++){
                if(chatClient.privateWindow[i].userName.equals(selectedUser)){
                    chatClient.privateWindow[i].setVisible(true);
                    chatClient.privateWindow[i].requestFocus();
                    privateFlag = true;
                    break;
                }
            }
            
            if(!(privateFlag)){
                if(chatClient.privateWindowCount >= MAX_PRIVATE_WINDOW){
                    chatClient.messageImpl.addMessageToMessageObject("You are exceeding private window limit! So you may lose some old messages", MESSAGE_TYPE_ADMIN, chatClient.txtCanvas);
                } else{
                    chatClient.privateWindow[chatClient.privateWindowCount++] = new PrivateChat(chatClient, selectedUser);
                    chatClient.privateWindow[chatClient.privateWindowCount-1].setVisible(true);
                    chatClient.privateWindow[chatClient.privateWindowCount-1].requestFocus();
                }
            }
        }
    }*/
}
