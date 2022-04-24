package com.boot.bookingrestaurantapi.dtos;

public class Tweet {
    private String message;
    private String user;

    public Tweet() {
    }

    public Tweet(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String toString() {
        return "Tweet{" + "message=" + message + ", user=" + user + '}';
    }
}

