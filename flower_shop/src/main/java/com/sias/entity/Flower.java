package com.sias.entity;

/**
 * 鲜花实体类
 * id：鲜花编号，name：鲜花名称，material：鲜花材料，image：鲜花图片
 * language：花语，price：原价，myprice：优惠价，sale：销量，categoryId：类别id
 */
public class Flower {
    private String id;
    private String name;
    private String material;
    private String image;
    private String language;
    private Double price;
    private Double myprice;
    private Integer sale;
    private String categoryId;
    private Category category;
    /**
     *关系属性 每个鲜花都有属于自己的的类别
     */
    @Override
    public String toString() {
        return "Flower{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", image='" + image + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", myprice=" + myprice +
                ", sale=" + sale +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMyprice() {
        return myprice;
    }

    public void setMyprice(Double myprice) {
        this.myprice = myprice;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Flower(String id, String name, String material, String image, String language, Double price, Double myprice, Integer sale, String categoryId, Category category) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.image = image;
        this.language = language;
        this.price = price;
        this.myprice = myprice;
        this.sale = sale;
        this.categoryId = categoryId;
        this.category = category;
    }

    public Flower() {
    }
}
