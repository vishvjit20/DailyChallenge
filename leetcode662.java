import java.util.*;

class Solution {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int max = 0;
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry(root, 1));
        while (!q.isEmpty()) {
            int l = q.peek().getValue();
            int r = l;
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = q.peek().getKey();
                r = q.poll().getValue();
                if (node.left != null)
                    q.offer(new AbstractMap.SimpleEntry(node.left, r * 2));
                if (node.right != null)
                    q.offer(new AbstractMap.SimpleEntry(node.right, r * 2 + 1));
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
