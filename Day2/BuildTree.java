// TO RUN
// PS E:\Desktop\FS\Day2> javac -d . BuildTree.java
// PS E:\Desktop\FS\Day2> java Day2.BuildTree

////////////////////////////////////////////////////////////////

package Day2;

import java.util.*;

/*
 * You are developing an application for a garden management system where each tree 
in the garden is represented as a binary tree structure. The system needs to 
allow users to plant new trees in a systematic way, ensuring that each tree is 
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps 
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7

 */

class TreeNode{
    TreeNode left ;
    TreeNode right ;
    int data;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        
    }
    
}
class BuildTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[]nodes = new int[n];

        for(int i = 0 ; i < n ; i++){
            nodes[i] = sc.nextInt();
        }

        TreeNode root  = Build(nodes);
        inorder(root);

        sc.close();
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static TreeNode Build (int[]nodes){
        
        Queue<TreeNode> q = new LinkedList<>();
        int curr = 0; 
        TreeNode root = new TreeNode(nodes[curr]);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr_node = q.poll();
            curr++;
            if(curr < nodes.length){
                TreeNode curr_left = new TreeNode(nodes[curr]);
                curr_node.left = curr_left;
                q.add(curr_left);
            }
            curr++;
            if(curr < nodes.length){
                TreeNode curr_right = new TreeNode(nodes[curr]);
                curr_node.right = curr_right;
                q.add(curr_right);
            }
        }
        return root;

        
    }
    
}
