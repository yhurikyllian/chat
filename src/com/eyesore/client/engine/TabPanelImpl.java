/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyesore.client.engine;

import com.eyesore.client.gui.ChatClient;
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
    
    public TabPanelImpl(ChatClient chatClient){
        this.chatClient = chatClient;
        listArray = new ArrayList();
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
        for(int i=0; i<listArraySize; i++){
            messageObject = (MessageObject) listArray.get(i);
            displayListItem(list, canvas);
        }
    }

    private void displayListItem(JList list, int canvas) {
        int imageIndex = ROOM_CANVAS_ICON;
        String[] array;
        array = new String[list.getModel().getSize()];
        
        
        
        switch(canvas){
            case USER_CANVAS:
                if(messageObject.isIgnored == true){
                    imageIndex = USER_CANVAS_IGNORE_ICON;
                } else{
                    imageIndex = USER_CANVAS_NORMAL_ICON;
                }
                
                for(int i=0; i< chatClient.userArray.length; i++){
                    array[i] = chatClient.userArray[i];
                    System.out.println("user = " + i + " " + array[i]);
                }
            break;
            case ROOM_CANVAS:
                for(int i=chatClient.roomArray.length -1; i>-1; i--){
                    array[i] = chatClient.roomArray[i];
                    System.out.println("room = " + i + " " + array[i]);
                }
             break;
        }
        
        
        list.setListData(array);
        
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
}
