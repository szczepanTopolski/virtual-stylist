package com.codecool.virtualstylist.wardrobe;

import javax.persistence.*;

import com.codecool.virtualstylist.stylization.Stylization;
import com.codecool.virtualstylist.user.User;

import java.util.List;
import java.util.Objects;

@Entity
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    @Convert(converter = Converters.BodyPartConverter.class)
    private ClothesProperties.BodyPart bodyPart;

    @Column(nullable = false)
    @Convert(converter = Converters.ClothTypeConverter.class)
    private ClothesProperties.ClothType clothType;

    @Column(nullable = false)
    @Convert(converter = Converters.ColorConverter.class)
    private ClothesProperties.Color color;

    private String code;

    private String brand;

    @Column(nullable = false)
    @Convert(converter = Converters.StyleConverter.class)
    private ClothesProperties.Style style;

    private String tag;

    @Convert(converter = Converters.SizeConverter.class)
    private ClothesProperties.Size size;

    @Column(nullable = false)
    private boolean hasPattern;

    private String shopLink;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "clothes",
            cascade = CascadeType.ALL)
    private List<Stylization> stylizations;

    public Cloth() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imagePath) {
        this.imageName = imagePath;
    }

    public ClothesProperties.BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(ClothesProperties.BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public ClothesProperties.ClothType getClothType() {
        return clothType;
    }

    public void setClothType(ClothesProperties.ClothType clothType) {
        this.clothType = clothType;
    }

    public ClothesProperties.Color getColor() {
        return color;
    }

    public void setColor(ClothesProperties.Color color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ClothesProperties.Style getStyle() {
        return style;
    }

    public void setStyle(ClothesProperties.Style style) {
        this.style = style;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ClothesProperties.Size getSize() {
        return size;
    }

    public void setSize(ClothesProperties.Size size) {
        this.size = size;
    }

    public boolean isHasPattern() {
        return hasPattern;
    }

    public void setHasPattern(boolean hasPattern) {
        this.hasPattern = hasPattern;
    }

    public String getShopLink() {
        return shopLink;
    }

    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Stylization> getStylizations() {
        return stylizations;
    }

    public void setStylizations(List<Stylization> stylizations) {
        this.stylizations = stylizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cloth cloth = (Cloth) o;
        return Objects.equals(id, cloth.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


