public class TreeNode {
    private int _value;
    private boolean isNull;

    public TreeNode(int value) {
        this._value = value;
        this.isNull = false;
    }

    public TreeNode() {
        this.isNull = true;
    }

    public boolean isNull() {
        return this.isNull;
    }

    public int value() {
        return this._value;
    }
}
