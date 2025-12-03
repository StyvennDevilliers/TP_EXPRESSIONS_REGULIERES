package fr.btsciel;

public class ClasseIpV4 {

    public ClasseIpV4(String address) {
        StringBuilder string = new StringBuilder();

        if (classeA(address)) {
            string.append("Adresse Ip de Classe A ");
            if (adressesPrivees(address)) {
                string.append("Privee ");
            } else if (loopback(address)) {
                string.append("Loopback ");
            }else if (routeParDefaut(address)) {
                string.append("Route Par Defaut ");
            }else{
                string.append("Publique ");;
            }
        }

        if(classeB(address)){
            string.append("Adresse Ip de Classe B ");
            if(adressesPrivees(address)){
                string.append("Privee ");;
            }else if(apipa(address)){
                string.append("Apipa ");
            }else{
                string.append("Publique ");;
            }
        }

        if(classeC(address)){
            string.append("Adresse Ip de Classe C ");
            if(adressesPrivees(address)){
                string.append("Privee ");;
            }else {
                string.append("Publique ");;
            }
        }
        System.out.println(string.toString());
    }
    public ClasseIpV4() {
    }

    private final String _192_a_223 = "(19[2-9]|2[01][0-9]|22[0-3])";
    private final String _0_a_255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private final String adressesPrivees = "(((10)((\\.)" + _0_a_255 + "){3})|((172)(\\.)(1[6-9]|2[0-9]|3[01])((\\.)" + _0_a_255 + "){2})|((192)(\\.)(168)((\\.)" + _0_a_255 + "){2}))";
    private final String apipa = "((169)(\\.)(254)((\\.)" + _0_a_255 + "){2})";
    private final String _0_a_127 =  "([0-9]|[1-9][0-9]|1[01][0-9]|12[0-7])";
    private final String _128_a_191 = "(12[8-9]|1[3-8][0-9]|19[01])";

    public boolean classeA(String adress){
        return  adress.matches(_0_a_127 + "\\." + _0_a_255 + "\\." + _0_a_255 + "\\." + _0_a_255);
    }
    public boolean classeB(String adress){
        return  adress.matches(_128_a_191 + "\\." + _0_a_255 + "\\." + _0_a_255 + "\\." + _0_a_255);
    }
    public boolean classeC(String adress){
        return  adress.matches(_192_a_223 + "\\." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean adressesPrivees(String adress){
        return adress.matches(adressesPrivees);
    }
    public boolean apipa(String adress){
        return adress.matches(apipa);
    }
    public boolean loopback(String adress){
        return adress.matches("127" + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
    public boolean routeParDefaut(String adress){
        return adress.matches("0" + "." + _0_a_255 + "." + _0_a_255 + "." + _0_a_255);
    }
}
