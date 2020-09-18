package com.nyongconnect.leaderboard.pojo;

public class TopSkill {
    String name;
    String score;
    String country;
    String badgeUrl;


    public TopSkill() {
    }

    public TopSkill(String name,String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
