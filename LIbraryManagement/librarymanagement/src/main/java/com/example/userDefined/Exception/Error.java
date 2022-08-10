package com.example.userDefined.Exception;


import java.util.Date;

public class Error {
    private String message;
    private Date date;
    private String status;
    public Error(Date date, String message, String status){
        super();
        this.date=date;
        this.message=message;
        this.status=status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
