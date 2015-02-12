/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyesore.client.engine;

import com.eyesore.client.gui.ChatClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author sora
 */
public class MessageImpl implements com.eyesore.client.engine.CommonSettings {
    private ArrayList messageArray;
    private String tokenString;
    private StringTokenizer tokenizer;
    private int messageCount;
    private MessageObject messageObject;
    private ChatClient chatClient;
    
    public MessageImpl(ChatClient chatClient){
        this.chatClient = chatClient;
        messageCount = 0;
        messageArray = new ArrayList();
    }
    
    /**
     * Clear message array and message count.
     */
    public void clearAll(){
        messageArray.clear();
        messageCount = 0;
    }
    
    public void addMessageToMessageObject(String message, int messageType, JTextPane jtp){
        String mMessage="";
        tokenizer = new StringTokenizer(message, " ");        
        
        while(tokenizer.hasMoreTokens()){
            tokenString = tokenizer.nextToken();            
            mMessage = mMessage + tokenString + " ";            
        }
        
        addMessage(mMessage + "\n", messageType, jtp);        
    }
    
    private void addMessage(String message, int messageType, JTextPane jtp) {

        if(messageArray.size() > 0){
            messageObject = (MessageObject) messageArray.get(messageArray.size()-1);
        }
        
        messageObject = new MessageObject();
        messageObject.message = message;
        messageObject.messageType = messageType;
        
        if(message.indexOf("~~") >= 0){
            messageObject.isImage = true;
        } else {
            messageObject.isImage = false;            
        }
        
        messageArray.add(messageObject);
        messageCount++;
        
        paintFrame(jtp);
        
    }
    
    private void paintFrame(JTextPane pane){
        if(messageCount < 1) return;
        
        int mListArraySize = messageArray.size();
        int cache = 0;
        
        for(int i=0; i<messageCount; i++){
            if(mListArraySize < i) return;
            messageObject = (MessageObject) messageArray.get(i);
            paintMessageIntoCanvas(pane, messageObject);
            cache = i;
        }        
    }

    private void paintMessageIntoCanvas(JTextPane pane, MessageObject messageObject) {
        String message = messageObject.message;
        String fMessage;
        
        if(message.indexOf(":") >= 0){
            String mUserName = message.substring(0, message.indexOf(":") + 1);
            insertContent(true, mUserName, pane);
            message = message.substring(message.indexOf(":") + 1);
        }
        
        if(messageObject.isImage == true){
            tokenizer = new StringTokenizer(message, " ");
            while(tokenizer.hasMoreTokens()){
                tokenString = tokenizer.nextToken();
                if(tokenString.indexOf("~~") >= 0){
                    int mImageIndex = Integer.parseInt(tokenString.substring(2));
                    if((mImageIndex >= 0) && (mImageIndex < chatClient.iconCount)){
                        fMessage = "<img src="+ chatClient.iconArray[mImageIndex] + ">";
                        insertContent(false, fMessage, pane);
                    }
                } else{
                    insertContent(true, tokenString, pane);
                }
            }
        } else{
            insertContent(true, message, pane);                           
        }
        
        messageObject.message = "";
    }
    
    protected void insertContent(boolean text, String message, JTextPane pane){
        pane.setContentType("text/html");
        
        //HTMLEditorKit hek = new HTMLEditorKit();
        //pane.setEditorKit(hek);
        HTMLDocument doc = (HTMLDocument) pane.getDocument();
        //Document doc = pane.getDocument();
        Element body = null;
        Element[] roots = doc.getRootElements();
        
        
        for(int i=0; i<roots[0].getElementCount(); i++){
            Element element = roots[0].getElement(i);
            if(element.getAttributes().getAttribute(StyleConstants.NameAttribute) == HTML.Tag.BODY){
                body = element;
                break;
            }
        }
        
        if(text){
            try {
                //System.out.println("length : " + doc.getLength());
                //System.out.println("message insert content : " + message);
                doc.insertString(doc.getLength(), message, null);
                
                //System.out.println("message ;" + message);
            } catch (BadLocationException ex) {
                Logger.getLogger(MessageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            try {                 
                doc.insertBeforeStart(body, message);                
            } catch (BadLocationException ex) {
                Logger.getLogger(MessageImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MessageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
