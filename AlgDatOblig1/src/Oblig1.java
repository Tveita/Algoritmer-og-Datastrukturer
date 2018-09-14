

import java.util.Arrays;

 /*
Gruppemedlemmer:
Joachim Tveita, s326150
Gustav Wahl, s326164
Gustav Wehn, s326171
*/
public class Oblig1{
    
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
    
    public static int ombyttinger(int[] a){
        if(a.length == 0){
            throw new java.util.NoSuchElementException("Arrayet er tomt, og har derfor ingen storste element");
        }
        int ombyttinger = 0;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                int tmp = a[i+1];
                a[i+1] = a[i];
                a[i] = tmp;
                ombyttinger++;
            }
        }
        return ombyttinger;
    }
    
    //Punkt 1: Det blir flest byttinger naar tabellen er sortert med det storste tallet forst;
    //Punkt 2: Det blir ferrest byttinger naar tabellen er sortert i stigende rekkefolge;
    //Punkt 3: 
    //MAA SVARE PAA PUNKT TRE FRA OPPGAVE 1
    
    
    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i - 1]){
                throw new IllegalStateException("Arrayen er ikke sortert i stigende rekkefolge");
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
    public static void delsortering(int a[]) {
        if(a.length < 1)
            return;
        //teller antall oddetall
        int oTall = 0;
        for(int i = 0; i < a.length; i++) {
            if (!(a[i] % 2 == 0)) {
                oTall++;
            }
        }
        if(oTall == 0 | oTall == a.length) { //Hvis det er kun partal eller oddetall
            quickSort(a, 0, a.length - 1);
            return;
        }else{
            int index = 0;
            int tmp;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 != 0) {
                    tmp = a[i];
                    a[i] = a[index];
                    a[index] = tmp;
                    index++;
                }
            }
            quickSort(a, 0, oTall - 1);
            quickSort(a, oTall, a.length - 1);
        }
    }
    
    public static void quickSort(int[] a, int start, int end) {
        int i = start;
        int k = end;
        int pivot = a[start + (end - start) / 2];

        int temp;
        while(i <= k) {
            while(a[i] < pivot) {
                i++;
            }
            while(a[k] > pivot) {
                k--;
            }
            if(i <= k) {
                temp = a[i];
                a[i] = a[k];
                a[k] = temp;
                i++;
                k--;
            }
        }
        //Kaller quicksort rekursivt
        if(start < k)
            quickSort(a, start, k);
        if(i < end)
            quickSort(a, i, end);
    }

    
    //oppgave 5
    public static void rotasjon(char[] a){

        for (int i = a.length -1; i >0; i--) {
            char temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }


    //Oppgave 6
    public static void rotasjon(char[] a, int k)    // 3. versjon
    {
        int lengde = a.length;
        if (lengde < 2) {
            return;
        }

        k = k % lengde;
        if (k < 0) {
            k += lengde;
        }

        int s = euklids(lengde, k);

        for (int i = 0; i < s; i++)
        {
            char verdi = a[i];
            int n = i;
            for (int j = i - k; j != i; j -= k)
            {
                if (j < 0) j += lengde;
                a[n] = a[j];
                n = j;
            }
            a[i + k] = verdi;
        }
    }

    public static int euklids(int a, int k) ///Finner storste felles divisor
    {
        if (k == 0) {
            return a;
        }
        else {
            return euklids(k, a % k);
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
    
    
    //Oppgave 10
    public static boolean inneholdt(String a, String b) {
        String[] delerB = b.split("");
        String[] delerA = a.split("");
        Arrays.sort(delerA);
        Arrays.sort(delerB);
        
        if (a.length() == 0){
            return true;
        }
        if(b.length() == 0){
            return false;
        }
        int j = 0;
        for (int i = 0; i < delerB.length; ++i) {
            if (delerA[j].equals(delerB[i])) {
                j++;
                if (j == delerA.length) {
                    return true;
                }
            }
        }
        return false;
    }
}


