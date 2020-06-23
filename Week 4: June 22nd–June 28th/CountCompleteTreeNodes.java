class Solution {
    public int countNodes(TreeNode root) {
        //Time : O(logn * logn)
        if(root == null){
            return 0;
        }
        int leftHeight = leftHeight(root) + 1;
        int rightHeight = rightHeight(root) + 1;
        if(leftHeight == rightHeight){
            return (2 << (leftHeight - 1)) - 1;  //same as Math.pow(2,leftHeight)-1
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    public int leftHeight(TreeNode node){
        int height = 0;
        if(node == null){
            return 0;
        }
        while(node.left != null){
            height++;
            node = node.left;
        }
        return height;
    }
    public int rightHeight(TreeNode node){
        int height = 0;
        if(node == null){
            return 0;
        }
        while(node.right != null){
            height++;
            node = node.right;
        }
        return height;
    }
}

//BFS
/*class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res += list.size();
        }
        return res;
    }
}*/

//DFS
/*
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
*/
