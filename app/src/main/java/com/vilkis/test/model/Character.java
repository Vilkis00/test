package com.vilkis.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Character extends RealmObject {

    @PrimaryKey
    @SerializedName("char_id")
    private int id;

    private String name;

    private String birthday;

    private RealmList<String> occupation;

    @SerializedName("img")
    private String image;

    private String status;

    private String nickname;

    private String portrayed;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public RealmList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(RealmList<String> occupation) {
        this.occupation = occupation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }
}
