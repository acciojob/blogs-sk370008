package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @CreationTimestamp
    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();


    public Blog(String title, String content, Date pubDate, User user) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
    }

    public Blog(){}

    public Blog(int id,String title,String content,Date pubDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Date getPubDate(){
        return pubDate;
    }

    public void setPubDate(Date date){
        this.pubDate = pubDate;
    }

    public List<Image> getImageList(){
        return imageList;
    }

    public void setImageList(List<Image> images){
        this.imageList = images;
    }


    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}