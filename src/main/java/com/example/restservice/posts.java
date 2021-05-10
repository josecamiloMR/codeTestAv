package com.example.restservice;

//Object of the JSON response
//used to manipulate and convert the response to a list of posts
public class posts {
    
    String userId;
    int id ;
    String title;
    String body;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public posts() {
    }
    public posts(String userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    @Override
    public String toString() {
        return "[ id=" + id + ",  userId=" + userId + ", title=" + title + ", body=" + body + "]";
    }
    
}
