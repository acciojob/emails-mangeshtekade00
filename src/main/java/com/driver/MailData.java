package com.driver;

import java.util.Date;

public class MailData {
    Date date;
    String sender;
    String message;

    public MailData() {
    }

    public MailData(Date date , String sender , String massage) {
        this.date = date;
        this.sender = sender;
        this.message  = massage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}