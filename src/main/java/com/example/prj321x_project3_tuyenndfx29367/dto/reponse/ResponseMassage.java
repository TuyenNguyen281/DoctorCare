package com.example.prj321x_project3_tuyenndfx29367.dto.reponse;

public class ResponseMassage {
    private int status;
    private String message;
    private long timeStamp;
    public ResponseMassage() {
    }

    public ResponseMassage(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
