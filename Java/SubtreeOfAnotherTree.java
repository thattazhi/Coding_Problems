class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (isIdentical(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        return (s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right));
    }
}