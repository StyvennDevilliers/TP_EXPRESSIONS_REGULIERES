package fr.btsciel;


import clavier.In;

import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        ArrayList<Integer> valeur = new ArrayList<>();
        System.out.println("Saisir une adresse Ip au format IPV4: ");
        String address = In.readString().replaceAll(" ","");
        String [] tableau = address.split("\\.");
        if(tableau.length == 4){
            try{
                for (String s : tableau) {
                     valeur.add(Integer.parseInt(s));
                }
                ClasseIpV4 classeIpV4 = new ClasseIpV4(address);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Adresse non conforme");
        }
    }
}
