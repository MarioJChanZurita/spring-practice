package com.example.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="action")
public class Movie {

    @Id
    private String id;
    @Field
    private String name;

    public Movie(){
        this.name = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
