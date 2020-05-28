package com.coderzoe.entity;

/**
 * @author yhs
 * @date 2020/5/28 21:02
 * @description
 */
public class NewStudent {
    private int id;
    private String name;
    private int tid;

    public NewStudent() {
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
