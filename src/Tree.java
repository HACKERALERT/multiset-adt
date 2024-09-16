import java.util.ArrayList;

public class Tree {
    private TreeNode _root;
    private ArrayList<Tree> _subtrees;

    public Tree(int root, ArrayList<Tree> subtrees) {
        this._root = new TreeNode(root);
        this._subtrees = subtrees;
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
        
    }
}