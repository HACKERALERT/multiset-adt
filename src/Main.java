import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // TODO complete this psvm main method to replicate the timing experiment from adts.py.
        //      Note: this will be client code of the various other classes needing to be written.

    }
    public static void profileMultiset(MultiSet datatype, Integer n) {
        
        Random random = new Random();
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            Integer r = random.nextInt(100);
            lst.add(r);
            datatype.add(r);
            
        }
        System.out.println(datatype.size() == n);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            datatype.remove(i);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        System.out.println(datatype.isEmpty());
    }
}


