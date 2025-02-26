package Day7;


/*Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend 
Anil to check whether the BT is a self-mirror tree or not.

Can you help Rakesh determine whether the given BT is a self-mirror tree?
Return true if it is a self-mirror tree; otherwise, return false.

Note:
------
In the tree, '-1' indicates an empty (null) node.

Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
 */


 


import java.util.*;


class TreeNode{
    String data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(String data){
        this.data = data;
        this.left = this.right = null;
    }
}

class Day7_Program3_Symmetric{
    public static boolean check(TreeNode lr ,TreeNode rr  ){
        
        if(lr == null && rr == null){
            return true;
        }
        if(lr == null || rr == null){
            return false;
        }
        
        
        if(!(lr.data).equals(rr.data)){
            return false;
        }
        
        return check(lr.left , rr.right) && check(lr.right , rr.left);
        
        
    }
    
    public static TreeNode Build(String[] nodes){
        Queue<TreeNode> q = new LinkedList<>();
        int curr = 0;
        TreeNode root = new TreeNode(nodes[curr]);
        q.add(root);
        
        while(!q.isEmpty()){
            curr++;
            TreeNode temp = q.poll();
            if(curr < nodes.length && !nodes[curr].equals("-1")){
                temp.left = new TreeNode(nodes[curr]);
                q.add(temp.left);
            }
            curr++;
            
            if(curr < nodes.length && !nodes[curr].equals("-1")){
                temp.right = new TreeNode(nodes[curr]);
                q.add(temp.right);
            }
        }
        
        return root;
        
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        String[]nodes = sc.nextLine().split(" ");
        
        TreeNode root = Build(nodes);
        
        
        System.out.println(check(root.left , root.right));
        
        
            
        
    }

}











// import java.util.*;


// class TreeNode{
//     String data;
//     TreeNode left;
//     TreeNode right;
    
//     TreeNode(String data){
//         this.data = data;
//         this.left = this.right = null;
//     }
// }

// class Day7_Program3_Symmetric{
//     public static boolean check(TreeNode lr ,TreeNode rr  ){
        
//         if(lr == null && rr == null){
//             return true;
//         }
//         if(lr == null || rr == null){
//             return false;
//         }
        
        
//         if(!(lr.data).equals(rr.data)){
//             return false;
//         }
        
//         return check(lr.left , rr.right) && check(lr.right , rr.left);
        
        
//     }
    
//     public static TreeNode Build(String[] nodes){
//         Queue<TreeNode> q = new LinkedList<>();
//         int curr = 0;
//         TreeNode root = new TreeNode(nodes[curr]);
//         q.add(root);
        
//         while(!q.isEmpty()){
//             curr++;
//             TreeNode temp = q.poll();
//             if(curr < nodes.length && !nodes[curr].equals("-1")){
//                 temp.left = new TreeNode(nodes[curr]);
//                 q.add(temp.left);
//             }
//             curr++;
            
//             if(curr < nodes.length && !nodes[curr].equals("-1")){
//                 temp.right = new TreeNode(nodes[curr]);
//                 q.add(temp.right);
//             }
//         }
        
//         return root;
        
//     }
//     public static void main(String[] args){

//         Scanner sc = new Scanner(System.in);
        
//         String[]nodes = sc.nextLine().split(" ");
        
//         TreeNode root = Build(nodes);
        
        
//         System.out.println(check(root.left , root.right));
        
        
            
        
//     }

// }