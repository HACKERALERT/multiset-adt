import java.util.ArrayList;

public class Tree {
    private TreeNode _root;
    private ArrayList<Tree> _subtrees;

    public Tree(int root, ArrayList<Tree> subtrees) {
        this._root = new TreeNode(root);
        this._subtrees = subtrees;
    }

    public Tree() {
        this._root = new TreeNode();
        this._subtrees = new ArrayList<Tree>();
    }

    public boolean isEmpty() {
        return this._root.isNull(); 
    }

    public int length() {
        if (this.isEmpty())
            return 0;
        int size = 1;
        for(Tree subtree: this._subtrees)
            size += subtree.length();
        return size;
    }

    public int count(int item) {
        if (this.isEmpty())
            return 0;
        int num = 0;
        if (!this._root.isNull() && this._root.value() == item)
            num++;
        for (Tree subtree: this._subtrees)
            num += subtree.count(item);
        return num;
    }

    public String toString() {
        return this.toStringIndented();
    }

    public String toStringIndented(int depth) {
        if (this.isEmpty())
            return "";
        String s = Utils.strRepeat("  ", depth) + Integer.toString(this._root.value()) + "\n";
        for (Tree subtree: this._subtrees)
            s += subtree.toStringIndented(depth + 1);
        return s;
    }
    public String toStringIndented() {
        return this.toStringIndented(0);
    }

    public float average() {
        if (this.isEmpty())
            return 0;
        ArrayList<Integer> tuple = this.averageHelper();
        return (float) tuple.get(0) / tuple.get(1);
    }

    private ArrayList<Integer> averageHelper() {
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        if (this.isEmpty()) {
            tuple.add(0);
            tuple.add(0);
            return tuple;
        }
        int total = this._root.value();
        int size = 1;
        for (Tree subtree: this._subtrees) {
            ArrayList<Integer> subTuple = subtree.averageHelper();
            total += subTuple.get(0);
            size += subTuple.get(1);
        }
        tuple.add(total);
        tuple.add(size);
        return tuple;
    }

    public boolean equals(Tree other) {
        if (this.isEmpty() && other.isEmpty())
            return true;
        if (this.isEmpty() || other.isEmpty())
            return false;
        if (this._root.value() != other._root.value())
            return false;
        if (this._subtrees.size() != other._subtrees.size())
            return false;
        return this._subtrees.equals(other._subtrees);
    }

    public boolean contains(int item) {
        if (this.isEmpty())
            return false;
        if (this._root.value() == item)
            return true;
        for (Tree subtree: this._subtrees)
            if (subtree.contains(item))
                return true;
        return false;
    }

    public ArrayList<Integer> leaves() {
        ArrayList<Integer> lis = new ArrayList<Integer>();
        if (this.isEmpty())
            return lis;
        if (this._subtrees.isEmpty()) {
            lis.add(this._root.value());
            return lis;
        }
        for (Tree subtree: this._subtrees)
            lis.addAll(subtree.leaves());
        return lis;
    }
}