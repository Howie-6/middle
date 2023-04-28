package com.example.middle.bean;

public class Subject {
    private String type;
    private int number;
    private String question;
    private int score;
    private int keyx;
    private String xx1;
    private String xx2;
    private String xx3;
    private String xx4;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKeyx() {
        return keyx;
    }

    public void setKeyx(int keyx) {
        this.keyx = keyx;
    }

    public String getXx1() {
        return xx1;
    }

    public void setXx1(String xx1) {
        this.xx1 = xx1;
    }

    public String getXx2() {
        return xx2;
    }

    public void setXx2(String xx2) {
        this.xx2 = xx2;
    }

    public String getXx3() {
        return xx3;
    }

    public void setXx3(String xx3) {
        this.xx3 = xx3;
    }

    public String getXx4() {
        return xx4;
    }

    public void setXx4(String xx4) {
        this.xx4 = xx4;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", question='" + question + '\'' +
                ", score=" + score +
                ", keyx=" + keyx +
                ", xx1='" + xx1 + '\'' +
                ", xx2='" + xx2 + '\'' +
                ", xx3='" + xx3 + '\'' +
                ", xx4='" + xx4 + '\'' +
                '}';
    }
}
