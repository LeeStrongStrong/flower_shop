package com.sias.entity;

/**
 * 鲜花类别实体类
 * id：鲜花类别编号
 * name：鲜花类别名称
 */
public class Category {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }
}
