import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        current.add(root.val);

        List<List<Integer>> leftLeaves = findLeaves(root.left);
        List<List<Integer>> righttLeaves = findLeaves(root.right);

        return merge(leftLeaves, righttLeaves, current);
    }

    private List<List<Integer>> merge(List<List<Integer>> left,
            List<List<Integer>> right,
            List<Integer> current) {
        List<List<Integer>> ans = new ArrayList<>();

        while (left.size() > 0 && right.size() > 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(left.remove(0));
            list.addAll(right.remove(0));
            ans.add(list);
        }

        ans.addAll(left);
        ans.addAll(right);
        ans.add(current);

        return ans;
    }
}