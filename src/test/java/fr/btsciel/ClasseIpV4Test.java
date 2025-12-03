package fr.btsciel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClasseIpV4Test {
    ClasseIpV4 classeIpV4 = new ClasseIpV4();

    @Test
    void classeA() {
        assertTrue(classeIpV4.classeA("0.0.0.255") == true, "test 1");
        assertTrue(classeIpV4.classeA("10.10.56.0") == true, "test 2");
        assertTrue(classeIpV4.classeA("127.255.255.255") == false, "test 3");
        assertTrue(classeIpV4.classeA("126.255.255.256") == false, "test 4");
        assertTrue(classeIpV4.classeA("128.0.0.0") == false, "test 5");
        assertTrue(classeIpV4.classeA("120.-5.52.63") == false, "test 6");
        assertTrue(classeIpV4.classeA("255.255.255") == false, "test 7");
        assertTrue(classeIpV4.classeA("0.0") == false, "test 8");
    }

    @Test
    void loopback() {
        assertTrue(classeIpV4.loopback("128.255.255.255") == false, "test 9");
        assertTrue(classeIpV4.loopback("126.255.255.255") == false, "test 10");
        assertTrue(classeIpV4.loopback("127.0") == false, "test 11");
        assertTrue(classeIpV4.loopback("127.0.0.0") == true, "test 12");
        assertTrue(classeIpV4.loopback("127.255.255.0") == true, "test 13");
        assertTrue(classeIpV4.loopback("127.255.255.255") == true, "test 14");
    }

    @Test
    void routeParDefaut() {
        assertTrue(classeIpV4.routeParDefaut("1.255.255.255") == false, "test 15");
        assertTrue(classeIpV4.routeParDefaut("0.255.255.256") == false, "test 16");
        assertTrue(classeIpV4.routeParDefaut("0.0.0") == false, "test 17");
        assertTrue(classeIpV4.routeParDefaut("0.0.0.0") == true, "test 18");
        assertTrue(classeIpV4.routeParDefaut("0.255.255.255") == true, "test 19");
        assertTrue(classeIpV4.routeParDefaut("0.255.0.126") == true, "test 20");
    }

    @Test
    void classeB() {
        assertTrue(classeIpV4.classeB("128.255.255.255") == true, "test 21");
        assertTrue(classeIpV4.classeB("191.0.0.0") == true, "test 22");
        assertTrue(classeIpV4.classeB("0.0.0.128") == false, "test 23");
        assertTrue(classeIpV4.classeB("191.255.255.255") == true, "test 24");
        assertTrue(classeIpV4.classeB("192.255.255.255") == false, "test 25");
        assertTrue(classeIpV4.classeB("127.255.255.255") == false, "test 26");
        assertTrue(classeIpV4.classeC(".255.255.255") == false, "test 27");
        assertTrue(classeIpV4.classeC("...") == false, "test 28");
    }

    @Test
    void classeC() {
        assertTrue(classeIpV4.classeC("192.255.255.255") == true, "test 29");
        assertTrue(classeIpV4.classeC("192.0.0.0") == true, "test 30");
        assertTrue(classeIpV4.classeC("0.0.0.128") == false, "test 31");
        assertTrue(classeIpV4.classeC("223.255.255.255") == true, "test 32");
        assertTrue(classeIpV4.classeC("224.255.255.255") == false, "test 33");
        assertTrue(classeIpV4.classeC("191.255.255.255") == false, "test 34");
        assertTrue(classeIpV4.classeC(".255.255.255") == false, "test 35");
        assertTrue(classeIpV4.classeC("...") == false, "test 36");
    }

    @Test
    void adressesPrivees() {
        assertTrue(classeIpV4.adressesPrivees("192.167.255.255") == false, "test 37");
        assertTrue(classeIpV4.adressesPrivees("192.168.0.0") == true, "test 38");
        assertTrue(classeIpV4.adressesPrivees("0.0.0.128") == false, "test 39");
        assertTrue(classeIpV4.adressesPrivees("10.255.255.255") == true, "test 40");
        assertTrue(classeIpV4.adressesPrivees("172.31.255.255") == true, "test 41");
        assertTrue(classeIpV4.adressesPrivees("172.255.255.255") == false, "test 42");
    }

    @Test
    void apipa() {
        assertTrue(classeIpV4.apipa("169.254.0.0") == true, "test 43");
        assertTrue(classeIpV4.apipa("169.254.255.255") == true, "test 44");
        assertTrue(classeIpV4.apipa("169.255.0.128") == false, "test 45");
        assertTrue(classeIpV4.apipa("169.254..255") == false, "test 46");
        assertTrue(classeIpV4.apipa("169.254.255") == false, "test 47");
        assertTrue(classeIpV4.apipa("169.254.20.168") == true, "test 48");
    }

}