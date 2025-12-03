package fr.btsciel;


import clavier.In;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Saisir une adresse Ip au format IPV4: ");
        String address = In.readString().replaceAll(" ","");
        String [] tableau = address.split("\\.");
        if(tableau.length == 4){
            try{
                for (String s : tableau) {
                    if (s.length() > 3 ) {
                        System.out.println("Adresse non conforme");
                        break;
                    }else{
                        System.out.println("Adresse conforme");
                    }
                    ClasseIpV4 classeIpV4 = new ClasseIpV4(address);
                }
            }catch (Exception e){
                System.out.println(e.getMessage() + " Adresse non conforme");
            }
        }else{
            System.out.println("Adresse non conforme");
        }
    }
}
