
import java.util.Arrays;
 /*
Gruppemedlemmer:
Joachim Tveita, s326150
Gustav Wahl, s326164
Gustav Wehn, s326171
*/
public class Oblig1 {
    
    public static void main(String [] args) {
        int a[]= {6,5,4,3,2,1};
        System.out.println(maks(a));
    }
    
    //Oppgave 1
    public static int maks(int[] a) {
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
            System.out.println("Største verdi er:");
        }
        return maksT;
        
    }
}
