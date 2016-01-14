package com.example.dongja94.samplecustomlist;

import android.graphics.drawable.Drawable;

/**
 * Created by dongja94 on 2016-01-14.
 */
public class Person {
    private Drawable icon;
    private String name;
    private int age;
    private String description;

    public Person(Drawable icon, String name, int age, String description) {
        this.icon = icon;
        this.name = name;
        this.age = age;
        this.description = description;
    }

    private String nameAndAge;
    public String getNameAndAge() {
        if (nameAndAge == null) {
            nameAndAge = name + "(" + age + ")";
        }
        return nameAndAge;
    }

    public void setName(String name) {
        this.name = name;
        nameAndAge = null;
    }

    public String getName() {
        return name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setAge(int age) {
        this.age = age;
        nameAndAge = null;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }
}
