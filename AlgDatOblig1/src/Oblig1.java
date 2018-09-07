
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
        int a[]= {65,93,95,17,80,8};
        System.out.println(maks(a));
        System.out.println(ombyttinger(a));
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
}
