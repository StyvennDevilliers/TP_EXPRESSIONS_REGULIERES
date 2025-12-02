package fr.btsciel;

import clavier.In;

public class ClasseIpV4 {

    public ClasseIpV4() {
        System.out.println("Saisir une adresse Ip au format IPV4: ");
        String address = In.readString().replaceAll(" ","");
        if(classeA(address)){
            if(adressesPrivees(address)){
                System.out.println("Adresse Ip de Classe A Privee ");
            }else if(routeParDefaut(address)){
                System.out.println("Adresse Ip de Classe A Route Par Defaut ");
            }else if(loopback(address)){
                System.out.println("Adresse Ip de Classe A Loopback ");
            }else {
                System.out.println("Adresse Ip de Classe A Publique ");
            }
        }
        if(classeB(address)){
            if(adressesPrivees(address)){
                System.out.println("Adresse Ip de Classe B Privee ");
            }else if(adressesApipa(address)){
                System.out.println("Adresse Ip de Classe B Apipa ");
            }else {
                System.out.println("Adresse Ip de Classe B Publique ");
            }
        }
        if(classeC(address)){
            if(adressesPrivees(address)){
                System.out.println("Adresse Ip de Classe C Privee ");
            }else {
                System.out.println("Adresse Ip de Classe C Publique ");
            }
        }
    }

    private final String _192_a_223 = "(19[2-9]|2[01][0-9]|22[0-3])";
    private final String adressesPrivees = "((10)((\\.)([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3})|((172)(\\.)(1[6-9]|2[0-9]|3[01])((\\.)([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){2})|((192)(\\.)(168)((\\.)([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){2})";
    private final String _0_a_255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private final String apipa = "(169)(\\.)(254)((\\.)([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){2}";
    private final String _0_a_127 =  "([0-9]|[1-9][0-9]|1[01][0-9]|12[0-7])";
    private final String _128_a_191 = "(12[8-9]|1[3-8][0-9]|19[01])";

    public boolean classeA(String adress){
        return  adress.matches(_0_a_127 + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean classeB(String adress){
        return  adress.matches(_128_a_191 + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean classeC(String adress){
        return  adress.matches(_192_a_223 + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean adressesPrivees(String adress){
        return adress.matches(adressesPrivees);
    }
    public boolean adressesApipa(String adress){
        return adress.matches(apipa);
    }
    public boolean loopback(String adress){
        return adress.matches("127" + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean routeParDefaut(String adress){
        return adress.matches("0" + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
}
