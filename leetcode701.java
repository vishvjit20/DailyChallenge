
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

class leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // find the correct postion - compare with current node value
        // if (root == null) return new TreeNode(val);
        // if (val > root.left) root.right = insertIntoBST(root.right, val);
        // else root.left = insertIntoBST(root.left, val);
        // return root;
        // T.C. O(n)
        // S.C. O(1)

        // Iterative Approach
        TreeNode curr = root;
        TreeNode new_node = new TreeNode(val);
        if (curr == null)
            return new_node;
        while (curr != null) {
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = new_node;
                    break;
                } else
                    curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new_node;
                    break;
                } else
                    curr = curr.left;
            }
        }
        return root;
    }
}
