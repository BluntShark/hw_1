package com.thewhite.study;

public class ResourceInfo {
    private int id;
    private String name;
    private String description;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nmae) {
        this.name = nmae;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public ResourceInfo(int id, String name, String description, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
    }
    public ResourceInfo(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }
    @Override
    public String toString() {
        return "id: " + id
                + " name: " + name
                + " description: " + description
                + " link: " + link;
    }

}
