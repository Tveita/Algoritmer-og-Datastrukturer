

import java.util.Arrays;

import java.util.NoSuchElementException;
 /*
Gruppemedlemmer:
Joachim Tveita, s326150
Gustav Wahl, s326164
Gustav Wehn, s326171
*/
public class Oblig1 {
    
    public static void main(String [] args) {
        int a[]= {9,6,7,9,7,4,7,8,3};
        char b[] = {'a','b','c','d','e','f','g','h','i','j'};
        //System.out.println(maks(a));
        //System.out.println(ombyttinger(a));
        //System.out.println(antallUlikeSortert(a));
        //System.out.println(antallUlikeUsortert(a));
        //System.out.println(Arrays.toString(a));
        //delsortering(a);
        //System.out.println(Arrays.toString(a));
        //String b = flett("123","456");
        //System.out.println(b);
        //String b = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        //System.out.println(b);
        a = indekssortering(a);
        System.out.println(Arrays.toString(a));
        //rotasjon(b, 4);
        //System.out.println(Arrays.toString(b));
         // String b = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        //System.out.println(b);
        //boolean b = inneholdt("AB","ABbIJDSab");
    }


    
    //Oppgave 1
    public static int maks(int[] a){
        if(a.length == 0){
            throw new java.util.NoSuchElementException("Arrayet er tomt, og har derfor ingen storste element");
        }
        int maksT = a[0];
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                int tmp = a[i+1];
                a[i+1] = a[i];
                a[i] = tmp;
                maksT = a[i+1];
            }else if(a[i] < a[i+1]){
                maksT = a[i+1];
            }
        }
        return maksT;
    }
    
    public  static int ombyttinger(int[] a) {
        int ombyttinger = 0;
        for (int i=1; i<a.length; i++) {
            if (a[i-1]> a[i]) {
                int tmp = a[i-1];
                a[i-1] = a[i];
                a[i] = tmp;
                ombyttinger++;
            }
        }
        return ombyttinger;
    }
    
    //NB!
    //MÅ SVARE PÅ PUNKT TRE FRA OPPGAVE 1
    
    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i - 1]){
                throw new IllegalStateException("Arrayen er ikke sortert i stigende rekkefølge");
            }
        }
        int ant = 0;
        if(a.length > 0){
            ant = 1;
        }
        for(int i = 1; i < a.length; i++){
            if(a[i] != a[i - 1]){
                ant++;
            }
        }
        return ant;
    }
    
    //Oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        int ant = 0;
        
        for (int i=0; i<a.length; i++) {
            int lik = 0;
            for (int k=i; k<a.length; k++) {
                if(a[i] == a[k] && i != k) {
                    lik++;
                }
            }
            if (lik == 0) {
                ant++;
            }
        }
        return ant;
    }
    
    //Oppgave 4
    public static void delsortering(int[] a){
        int hjelp = 0;
        if(a.length > 1){
            for(int k = 0; k < a.length; k++){
                for(int i = 1; i <a.length; i++){
                    if(a[i]%2 != 0){
                        if(a[i]>a[i-1] && a[i-1]%2 == 0){
                            hjelp = a[i-1];
                            a[i-1] = a[i];
                            a[i] = hjelp; 
                        }
                    }else{
                        if(i+1 < a.length && a[i]>a[i+1]){
                            hjelp = a[i+1];
                            a[i+1] = a[i];
                            a[i] = hjelp;
                        }
                    }
                    //System.out.println(Arrays.toString(a));
                }
            }
            for(int k = 0; k < a.length; k++){
                for(int i = 0; i < a.length-1; i++){
                    if(a[i]%2 == 0){
                        if(a[i] > a[i+1] && a[i+1]%2 == 0){
                            hjelp = a[i+1];
                            a[i+1] = a[i];
                            a[i] = hjelp;
                        }
                    }
                }
            }
        }
        
    }

    //oppgave 5
    public static void rotasjon(char[] a){

        for (int i = a.length -1; i >0; i--) {
            char temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }



    //oppgave 6
    public  static  void rotasjon(char[] a, int k) {
        if (k < 0) {
            for (int j = k; j < 0; j++) {
                for (int i = 0; i < a.length - 1; i++) {
                    char temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }else {
            for (int j = 0; j < k; j++) {
                for (int i = a.length - 1; i > 0; i--) {

                    char temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                }
            }
        }
    }
    

    
    //Oppgave 7a)
    public static String flett(String s, String t) {
        String alt = "";
        int lengde = 0;
        if (s.length() >= t.length()) {
            lengde = s.length();
        }
        else {
            lengde = t.length();
        }
        for (int i=0; i<lengde; i++) {
            if (i<s.length()) {
                alt += s.charAt(i);
            }
            if (i<t.length()) {
                alt += t.charAt(i);
            }
        }
        return alt;
    }
    //Oppgave 7b)
    public static String flett(String... s) {
        int lengde = 0;
        String hele = "";
        for (String tab1 : s) {
            if (tab1.length() > lengde) {
                lengde = tab1.length();
            }
        }
        for (int k=0; k<lengde; k++) {
            for (String tab1 : s) {
                if (k < tab1.length()) {
                    hele += tab1.charAt(k);
                }
            }
        }
        return hele;
    }

    
    //Oppgave 8
    public static int[] indekssortering(int[] a){
        int[] indeks = new int[a.length];
        int[] hjelp = new int[a.length];
        for(int i = 0; i < a.length; i++){
            hjelp[i] = a[i];
        }
        int pos = 0;
        int minVerdi = Integer.MAX_VALUE;
        for(int k = 0; k < a.length; k++){
            for(int i = 0; i < a.length; i++){
                if(hjelp[i] < minVerdi){
                    minVerdi = a[i];
                    pos = i;
                    indeks[k] = pos;
                }
                if(i == a.length - 1){
                    hjelp[pos] = Integer.MAX_VALUE;
                }
            }
            minVerdi = Integer.MAX_VALUE;
            pos = 0;
        }
        return indeks;
    }
    
    //Oppgave 9
    public static int[] tredjeMin(int[]  a){
        if(a.length < 3){
            throw new java.util.NoSuchElementException();
        }
        
        int[] hjelp = {a[0], a[1], a[2]};
        hjelp = indekssortering(hjelp);
        int m = hjelp[0];
        int nm = hjelp[1];
        int tm = hjelp[2];
        int mVerdi = a[m];
        int nmVerdi = a[nm];
        int tmVerdi = a[tm];
        
        for(int i = 3; i < a.length; i++){
            if(a[i] < tmVerdi){
                if(a[i] < nmVerdi){
                    if(a[i] < mVerdi){
                        tmVerdi = nmVerdi;
                        tm = nm;
                        nmVerdi = mVerdi;
                        nm = m;
                        mVerdi = a[i];
                        m = i;
                    }else{
                        tmVerdi = nmVerdi;
                        tm = nm;
                        nmVerdi = a[i];
                        nm = i;
                    }
                }else{
                    tmVerdi = a[i];
                    tm = i;
                }
            }
        }
        return new int[] {m, nm, tm};
    }

    //oppgave 10

    public static boolean inneholdt(String a, String b){
        String[] delerA = a.split("");
        String[] delerB = b.split("");
        int lengde = delerA.length;

        for (int j = 0; j < delerA.length; j++) {
            for (int i = 0; i < delerB.length; i++) {

                if (delerA[j].toUpperCase().equals(delerB[i].toUpperCase())) {
                    lengde = lengde - 1;
                }
            }
        }
        if (lengde <= 0) {
            return true;
        }else {
            return false;
        }

    }
}
