package com.example.middle.bean;

public class Student implements Comparable<Student> {
    private int number;
    private String name;
    private int chinese;
    private int math;
    private int english;

    private int ranks;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanking(int ranks) {
        this.ranks = ranks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", ranks=" + ranks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return (this.chinese + this.math + this.english) - (o.chinese + o.math + o.english);
    }

}
