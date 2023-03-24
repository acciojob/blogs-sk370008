package com.driver.models;

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

    @CreatedDate
    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> images = new ArrayList<>();

    public Blog(){}

    public Blog(int id,String title,String content,Date pubDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
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

    public List<Image> getImages(){
        return images;
    }
}