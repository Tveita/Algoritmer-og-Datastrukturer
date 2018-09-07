
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
        int a[]= {-9,6,3,5,7,2,-7,-8,3};
        //System.out.println(maks(a));
        //System.out.println(ombyttinger(a));
        //System.out.println(antallUlikeSortert(a));
        //System.out.println(antallUlikeUsortert(a));
        System.out.println(Arrays.toString(a));
        delsortering(a);
        System.out.println(Arrays.toString(a));
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
        for(int k = 0; k < a.length; k++){
            for(int i = 1; i <a.length; i++){
                if(a[i]%2 != 0){
                    if(a[i]>a[i-1]){
                        int hjelp = a[i-1];
                        a[i-1] = a[i];
                        a[i] = hjelp; 
                    }
                }else{
                    if(i+1 < a.length && a[i]>a[i+1]){
                        int hjelp2 = a[i+1];
                        a[i+1] = a[i];
                        a[i] = hjelp2;
                    }
                }
            }
        }
        for(int k = 0; k < a.length; k++){
            for(int i = 0; i < a.length; i++){
                if(a[i]%2 != 0){
                    if(a[i] > a[i+1] && a[i+1]%2 != 0){
                        int hjelp3 = a[i+1];
                        a[i+1] = a[i];
                        a[i] = hjelp3;
                    }
                }
            }
        }
    }
}
