package com.grillo.edx.artapi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 09/07/16.
 */
public class Painting {

    @SerializedName("id")
    private int idServer;

    private String url;
    private String name;
    private String author;

    public int getIdServer() {
        return idServer;
    }

    public void setIdServer(int idServer) {
        this.idServer = idServer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
