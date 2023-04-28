package com.example.middle.DAO;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class TestDAOTest {

    @Test
    void getConn() {
        TestDAO testDAO=new TestDAO();
        testDAO.getConn();
    }

    @Test
    void keyChinese() {
        getConn();
        TestDAO testDAO=new TestDAO();
        ArrayList<Integer> arrayList=new ArrayList<>();
        try {
            arrayList= (ArrayList<Integer>) testDAO.keyChinese();
            System.out.println(arrayList);
            System.out.println(arrayList.get(4));
        } catch (Exception e) {
            System.out.println("有问题！");
        }
    }
    @Test
    void twoArraysCompareTo(){
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        a.add(3);
        b.add(3);
        a.add(1);
        b.add(1);
        a.add(1);
        b.add(1);
        a.add(1);
        b.add(1);
        a.add(4);
        b.add(1);
        a.add(2);
        b.add(1);
        a.add(3);
        b.add(3);
        System.out.println("a = "+a);
        System.out.println("b = "+b);

        TestDAO testDAO=new TestDAO();
        int result=testDAO.twoArraysCompareTo(a,b,7,14);
        System.out.println(result);
    }
}