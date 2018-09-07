
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
    }
    
    //Oppgave 1
    public static int maks(int[] a){
        if(a.length == 0){
            throw new NoSuchElementException("Arrayet er tomt, og har derfor ingen storste element");
        }
        int maksT = 0;
        System.out.println(Arrays.toString(a));
        for (int i=1; i<a.length; i++) {
            if (a[i-1]> a[i]) {
                int tmp = a[i-1];
                a[i-1] = a[i];
                a[i] = tmp;
                maksT = tmp;
                System.out.println(Arrays.toString(a));
            }
        }
        System.out.println("Største verdi er:");
        return maksT;
    }
    
    public  static int ombyttinger(int[] a) {
        int ombyttinger = 0;
        System.out.println(Arrays.toString(a));
        for (int i=1; i<a.length; i++) {
            if (a[i-1]> a[i]) {
                int tmp = a[i-1];
                a[i-1] = a[i];
                a[i] = tmp;
                System.out.println(Arrays.toString(a));
                ombyttinger++;
            }
        }
        System.out.println("Antall ombyttinger:");
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
        for(int k = 0; k < a.length; k++){
            for(int i = 1; i <a.length; i++){
                if(a[i]%2 != 0){
                    if(a[i]>a[i-1]){
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
            }
        }
        for(int k = 0; k < a.length; k++){
            for(int i = 0; i < a.length; i++){
                if(a[i]%2 != 0){
                    if(a[i] > a[i+1] && a[i+1]%2 != 0){
                        hjelp = a[i+1];
                        a[i+1] = a[i];
                        a[i] = hjelp;
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
    public static String flett(String c, String d, String e, String f, String g, String h, String l, String j) {
        String[] hjelp = {c, d, e, f, g, h, l, j};
        int lengde = 0;
        String hele = "";
        for (String hjelp1 : hjelp) {
            if (hjelp1.length() > lengde) {
                lengde = hjelp1.length();
            }
        }
        for (int k=0; k<lengde; k++) {
            for (String hjelp1 : hjelp) {
                if (k < hjelp1.length()) {
                    hele += hjelp1.charAt(k);
                }
            }
        }
        return hele;
    }
    
    //Oppgave 8
    public static int[] indekssortering(int[] a){
        int[] indeks = new int[a.length];
        int minVerdi = a[0];
        int m = 0;
        for(int k = 0; k < a.length; k++){
            for(int i = 0; i < a.length; i++){
                if(a[i] < minVerdi){
                    minVerdi = a[i];
                    m = i;
                }
                for(int j = 0; j < indeks.length; j++){
                    if(m == indeks[j]){
                        
                    }else{
                        if(a[i] < minVerdi){
                            minVerdi = a[i];
                            m = i;
                        }
                        indeks[k] = m;
                    }
                }
            }
        }
        return indeks;
    }
}
