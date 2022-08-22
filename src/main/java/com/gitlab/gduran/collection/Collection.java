package com.gitlab.gduran.collection;

import java.util.*;

public class Collection {

    public static void main( String[] args){
        /*List<String> lista = new ArrayList<>();
        lista.add("hola");
        lista.add("mundo");
        lista.add("estoy triunfando");

        Iterator<String> iterador = lista.iterator();
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }

        LinkedList lista2 = new LinkedList();

        HashMap diccionary = new HashMap();*/

        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }

}
