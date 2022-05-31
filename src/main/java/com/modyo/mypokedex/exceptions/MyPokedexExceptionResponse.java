package com.modyo.mypokedex.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MyPokedexExceptionResponse {

    @JsonPropertyOrder({ "status", "timestamp", "message", "causa" })
    private String message = null;
    private String status = null;
    private String timestamp = null;
    private String causa = null;
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getCausa() {
        return causa;
    }
    public void setCausa(String causa) {
        this.causa = causa;
    }

   /*
    public MyPokedexExceptionResponse generateResponse (String message){
        this.message = message;
        return this;
    }
    */
  

    
}
