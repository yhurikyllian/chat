/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyesore.client.engine;

import com.eyesore.client.gui.ChatClient;
import java.util.ArrayList;

/**
 *
 * @author sora
 */
public class IconImpl implements CommonSettings{
    private ChatClient chatClient;
    private ArrayList iconArray;
    private MessageObject messageObject;   
    private MessageImpl messageImpl;
    private String selectedImage;

    public IconImpl(ChatClient chatClient, MessageImpl messageImpl) {
        this.chatClient = chatClient;
        iconArray = new ArrayList();     
        this.messageImpl = messageImpl;
    }
    
    public void addIconsToMessageObject(){
        int startX = IMAGE_CANVAS_START_POSITION;
        int startY = IMAGE_CANVAS_START_POSITION;
        for(int i=1; i<=chatClient.iconCount; i++){
            messageObject = new MessageObject();
            
            messageObject.message = "<img src='" + ClassLoader.getSystemResource("resources/Emoji"+i+"-100.png").toString() + "'></img>";           
            messageObject.isImage = true;
            messageObject.startX = startX;
            messageObject.startY = startY;
            messageObject.width = DEFAULT_ICON_WIDTH;
            messageObject.height = DEFAULT_ICON_HEIGHT;
            
            iconArray.add(messageObject);            
        }
        display();
    }

    private void display() {
        int iconListSize = iconArray.size();
        String message = "";       
        for(int i=0; i<iconListSize; i++){
            messageObject = (MessageObject) iconArray.get(i);
                      
            if(i%2 != 0){
                messageObject.message += "<br>";
            }  
            message += messageObject.message;            
        }
        messageObject.message = message;
        paintImagesIntoCanvas(messageObject);        
    }

    private void paintImagesIntoCanvas(MessageObject messageObject) {       
        messageImpl.insertContent(false, messageObject.message, this.chatClient.txtEmot);        
    }
    
    public boolean isMouseMove(int x, int y){        
        int iconListSize = iconArray.size();
        
        for(int i=0; i<iconListSize; i++){
            messageObject = (MessageObject) iconArray.get(i);
            if((y <= messageObject.startY+messageObject.height) && (x <= messageObject.startX+messageObject.width)){
                selectedImage = messageObject.message;
                System.out.println("icon : " + messageObject.message);
                break;
            }
            selectedImage = null;
        }
        return true;
    }
}
