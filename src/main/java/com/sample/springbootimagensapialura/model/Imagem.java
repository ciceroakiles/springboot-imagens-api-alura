package com.sample.springbootimagensapialura.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="imagensCollection")
public class Imagem {
    
    @Id
    private String id;

    private String title;
    private String image;

    public Imagem() {
    }

    public Imagem(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
