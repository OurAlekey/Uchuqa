package uchuca.exeptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String message;
    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(Date timestamp, String message, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    public ErrorMessage() {

    }
}
