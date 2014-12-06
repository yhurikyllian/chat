/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyesore.client.engine;

/**
 *
 * @author sora
 */
public class MessageObject {
    String message;
    boolean isImage;
    boolean selected;
    boolean isIgnored;
    int messageType;
    
    public MessageObject(){
        message = null;
        isImage = false;
        isIgnored = false;
        selected = false;
    }
}
