import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMultiSet extends MultiSet {
    private final ArrayList<Integer> list = new ArrayList<>();

    public void add(Integer item) {
        list.add(item);
    }

    public void remove(Integer item) {
        // From ArrayList.remove documentation:
        // Removes the first occurrence of the specified element from this list,
        // if it is present. If the list does not contain the element,
        // it is unchanged.
        list.remove(item);
    }

    public boolean contains(Integer item) {
        return list.contains(item);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int count(Integer item) {
        return Collections.frequency(list, item);
    }

    public int size() {
        return list.size();
    }
}
