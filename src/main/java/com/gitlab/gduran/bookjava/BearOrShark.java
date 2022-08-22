package com.gitlab.gduran.bookjava;

public class BearOrShark {
    public static void main(String[] args){
        int luck=10;
        if((luck>10 ? luck++: --luck)<10){
            System.out.println("Bear");
        } if (luck<10) System.out.println("Shark");
    }
}
