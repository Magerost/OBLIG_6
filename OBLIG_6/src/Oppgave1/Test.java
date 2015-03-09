package Oppgave1;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Test {

    public static void main(String[] args) {
        
        ArrayList<Kort> reg = new ArrayList<Kort>();
        
        Kort k1 = new Ansatt("Pers", "Pullar", 1234, new GregorianCalendar(2010, 4, 2), 634.64);
        Kort k2 = new Gjest("Per", "Pål");
        reg.add(k1);
        reg.add(k2);

        for (int i=0; i<reg.size(); i++) {
            Kort kort = (Kort)reg.get(i);
            System.out.print(kort);
            System.out.println("\nTest av kort: med kode 1234 er" + (kort.sjekkPin(1234) ?  " gyldig" :  " ugyldig" ) );
            System.out.println("\nTest av kort: med kode 9999 er" + (kort.sjekkPin(9999) ?  " gyldig" :  " ugyldig" ) );
        }
        
        Ansatt a = (Ansatt) k1.clone();
        
        System.out.println("Er referansen den samme? " + (a == k1));
        System.out.println("Er de like? " + a.compareTo(k1));
        
        a.setNavn("Petter Dass");
        System.out.println(a);
        System.out.println(k1);
    }
}