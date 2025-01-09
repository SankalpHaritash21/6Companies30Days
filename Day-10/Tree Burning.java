/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap;
    public int amountOfTime(TreeNode root, int start) {
        // First, get the starting node. This will act as a level 0 node
        TreeNode firstNode = linkParentNode(root, start);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int time = 0;

        queue.add(firstNode);
        visited.add(firstNode);

        while(!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for(int i=0; i < size; i++) {
                TreeNode current = queue.poll();

                // Infect left child
                if(current.left != null && !visited.contains(current.left)){
                    flag = true;
                    visited.add(current.left);
                    queue.add(current.left);
                }

                // Infect right child
                if(current.right != null && !visited.contains(current.right)){
                    flag = true;
                    visited.add(current.right);
                    queue.add(current.right);
                }

                TreeNode parentNode = parentMap.get(current);
                // Infect the parent node
                if(parentNode != null && !visited.contains(parentNode)){
                    flag = true;
                    visited.add(parentNode);
                    queue.add(parentNode);
                }
            }
            // If either left, right or parent was infected, that will be counted as the next minute
            if(flag) time++;
        }
        return time;
    }

    /**
     * This function will map each node to its parent node.
     * @param root
     * @param start
     * @return
     */
    private TreeNode linkParentNode(TreeNode root, int start) {
        parentMap = new HashMap<>();
        // Dummy node
        TreeNode res = new TreeNode(-1);

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {
            TreeNode current = treeNodeQueue.poll();
            if(current.val == start)
                res = current;

            if(current.left != null){
                parentMap.put(current.left, current);
                treeNodeQueue.add(current.left);
            }

            if(current.right != null){
                parentMap.put(current.right, current);
                treeNodeQueue.add(current.right);
            }
        }
        return res;
    }
}