package models;

import java.util.ArrayList;

public class Pet {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;

    @Override
    public String toString() {
        return "Pet{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }

    public Pet(Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public Category getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }
    public ArrayList<Tag> getTags() {
        return tags;
    }
    public String getStatus() {
        return status;
    }
}
