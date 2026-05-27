package com.example.resume_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product", schema = "portfolio")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_logo_img_url")
    private String logo;

    @Column(name = "product_img_url")
    private String img;

    @Column(name = "product_link")
    private String link;

    @Column(name = "product_nda")
    private Boolean nda;

    @Column(name = "product_screenshot_1_url")
    @JsonIgnore
    private String screenshot1Url;

    @Column(name = "product_screenshot_2_url")
    @JsonIgnore
    private String screenshot2Url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getNda() {
        return nda;
    }

    public void setNda(Boolean nda) {
        this.nda = nda;
    }

    @JsonProperty("screenshots")
    @Transient
    public List<String> getScreenshots() {
        ArrayList<String> list = new ArrayList<>();
        if (screenshot1Url != null && !screenshot1Url.isBlank()) list.add(screenshot1Url);
        if (screenshot2Url != null && !screenshot2Url.isBlank()) list.add(screenshot2Url);
        return list;
    }

    public String getScreenshot1Url() {
        return screenshot1Url;
    }

    public void setScreenshot1Url(String screenshot1Url) {
        this.screenshot1Url = screenshot1Url;
    }

    public String getScreenshot2Url() {
        return screenshot2Url;
    }

    public void setScreenshot2Url(String screenshot2Url) {
        this.screenshot2Url = screenshot2Url;
    }
}
