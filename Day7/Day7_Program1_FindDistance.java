package Day7;


/*Bubloo is working with computer networks, where servers are connected 
in a hierarchical structure, represented as a Binary Tree. Each server (node) 
is uniquely identified by an integer value.

Bubloo has been assigned an important task: find the shortest communication 
path (in terms of network hops) between two specific servers in the network.

Network Structure:
------------------
The network of servers follows a binary tree topology.
Each server (node) has a unique identifier (integer).
If a server does not exist at a certain position, it is represented as '-1' (NULL).

Given the root of the network tree, and two specific server IDs (E1 & E2), 
determine the minimum number of network hops (edges) required to 
communicate between these two servers.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
4 8

Sample Output-1:
----------------
4

Explanation:
------------
The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]


Sample Input-2:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
6 6

Sample Output-2:
----------------
0

Explanation:
------------
No edegs between 6 and 6.
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
 
 class Day7_Program1_FindDistance{
 
     
     
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
     
     
     
 
     public static boolean find_path(TreeNode root , List<String> ans, String target){
         if(root == null){
             return false;
         }
         ans.add(root.data);
         // System.out.println(root.data + " -> " + ans);
         if((root.data).equals(target)){
            
             return true;
         }
         if(find_path(root.left , ans , target) || find_path(root.right , ans , target)){
             
             return true;    
         }
         
         ans.remove(ans.size() - 1);
         return false;
     }
     
     
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         String[]nodes = sc.nextLine().split(" ");
         String[]target = sc.nextLine().split(" ");
         
         
         
         TreeNode root = Build(nodes);
         
         List<String> p1 = new ArrayList<>();
         List<String> p2 = new ArrayList<>();
         
         
         
         find_path(root , p1 , target[0]);
         find_path(root , p2 , target[1]);
         
         List<String> common = new ArrayList<>(p1);
         common.retainAll(p2);
         
         p1.removeAll(common);
         p2.removeAll(common);
         
         
         
         
         // System.out.println(p1+ " "+p2);
 
         System.out.println(p1.size()+p2.size());
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

// class Day7_Program1_FindDistance{

    
    
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
    
    
    

//     public static boolean find_path(TreeNode root , List<String> ans, String target){
//         if(root == null){
//             return false;
//         }
//         ans.add(root.data);
//         // System.out.println(root.data + " -> " + ans);
//         if((root.data).equals(target)){
           
//             return true;
//         }
//         if(find_path(root.left , ans , target) || find_path(root.right , ans , target)){
            
//             return true;    
//         }
        
//         ans.remove(ans.size() - 1);
//         return false;
//     }
    
    
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
        
//         String[]nodes = sc.nextLine().split(" ");
//         String[]target = sc.nextLine().split(" ");
        
        
        
//         TreeNode root = Build(nodes);
        
//         List<String> p1 = new ArrayList<>();
//         List<String> p2 = new ArrayList<>();
        
        
        
//         find_path(root , p1 , target[0]);
//         find_path(root , p2 , target[1]);
        
//         List<String> common = new ArrayList<>(p1);
//         common.retainAll(p2);
        
//         p1.removeAll(common);
//         p2.removeAll(common);
        
        
        
        
//         // System.out.println(p1+ " "+p2);

//         System.out.println(p1.size()+p2.size());
//     }

// }