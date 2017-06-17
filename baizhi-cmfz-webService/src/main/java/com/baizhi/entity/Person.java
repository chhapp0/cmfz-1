package com.baizhi.entity;

/**
 * Created by Lenovo on 2017/6/15.
 */
public class Person {

    private String uid;
    private String gender;
    private String photo;
    private String location;
    private String decription;
    private String nickname;
    private String province;
    private String city;
    private String password;

    public Person() {
        super();
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid='" + uid + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", location='" + location + '\'' +
                ", decription='" + decription + '\'' +
                ", nickname='" + nickname + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(String uid, String gender, String photo, String location, String decription, String nickname, String province, String city, String password) {

        this.uid = uid;
        this.gender = gender;
        this.photo = photo;
        this.location = location;
        this.decription = decription;
        this.nickname = nickname;
        this.province = province;
        this.city = city;
        this.password = password;
    }
}
