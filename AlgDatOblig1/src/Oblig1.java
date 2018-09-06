
import java.util.Arrays;

 /*
Gruppemedlemmer:
Joachim Tveita
Gustav Wahl
Gustav Wehn
*/
public class Oblig1 {
    
    public static void main(String [] args) {
        int a[]= {6,5,4,3,2,1};
        System.out.println(maks(a));
    }
    
    //Oppgave 1
    public static int maks(int[] a) {
        int tmp = 0;
        int b[] = new int[0];
        for (int i=1; i<a.length; i++) {
            if (a[i-1]> a[i]) {
                tmp = a[i-1];
                a[i-1] = a[i];
                a[i] = tmp;
                b[] = tmp;
            }
        }
        return b[];
    }
}
