public class TreeNode {
    private int value;
    private boolean isNull;

    public TreeNode(int value) {
        this.value = value;
        this.isNull = false;
    }

    public TreeNode() {
        this.value = 0;
        this.isNull = true;
    }

    public boolean isNull() {
        return this.isNull;
    }

    public int value() {
        return this.value;
    }
}
