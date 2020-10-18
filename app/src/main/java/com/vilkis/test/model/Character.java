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
}
