package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String dimensions;

    @ManyToOne
    @JoinColumn
    Blog blog;

    public Image(){}


    public Image(int id,String description,String dimensions){
        this.id = id;
        this.description = description;
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDimensions(){
        return dimensions;
    }

    public void setDimensions(String dimensions){
        this.dimensions = dimensions;
    }
}