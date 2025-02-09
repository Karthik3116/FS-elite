package Day2;

import java.util.*;


/*
 * Write a program to construct a binary tree from level-order input, while treating -1 
as a placeholder for missing nodes. The program reads input, constructs the tree, 
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indiactes null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7

 */

class TreeNode{
    TreeNode left;
    TreeNode right;
    String data;
    
    TreeNode(String data){
        
        this.data = data;
    }
    
}

class BuildTree2{
    public static void inorder(TreeNode root){
        if(root == null ) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
        
    }
    public static TreeNode Build(String[] nodes){
        Queue<TreeNode> q = new LinkedList<>();
        int curr_idx = 0;
        TreeNode root = new TreeNode(nodes[curr_idx]);
        q.add(root);
        curr_idx = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr_idx < nodes.length && !nodes[curr_idx].equals("-1")){
                curr.left = new TreeNode(nodes[curr_idx]);
                q.add(curr.left);
            }
            curr_idx += 1;
            if(curr_idx < nodes.length && !nodes[curr_idx].equals("-1")){
                curr.right = new TreeNode(nodes[curr_idx]);
                q.add(curr.right);
            }
            curr_idx += 1;
            
        }
        
        return root;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        String[]nodes = s.split(" ");
        
        
        TreeNode root = Build(nodes);
        inorder(root);
    }
}