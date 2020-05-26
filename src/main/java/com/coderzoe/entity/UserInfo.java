package com.coderzoe.entity;

/**
 * @author yhs
 * @date 2020/5/22 20:57
 * @description
 */
public class UserInfo {
    private int id;
    private String familyName;
    private String firstName;

    public UserInfo() {
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
