
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
        int a[]= {3,2,1};
        //System.out.println(maks(a));
        //System.out.println(ombyttinger(a));
        System.out.println(antallUlikeSortert(a));
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
    /*
    Sporsmaal 1: Naar blir det flest ombyttinger?
    Svar: Det blir flest ombyttinger når den storste verdien er i posisjon 0 i arrayen.
    
    Sporsmaal 2: Naar blir det ferrest ombytninger?
    Svar: Det blir ferrest ombyttinger naar arrayen allerede er sortert i stigende rekkefolge. 
    
    */
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
}
