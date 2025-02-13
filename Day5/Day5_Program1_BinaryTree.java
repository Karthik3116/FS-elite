
/*Given the in-order and post-order traversals of a binary tree, construct 
the original binary tree. For the given Q number of queries, 
each query consists of a lower level and an upper level. 
The output should list the nodes in the order they appear in a level-wise.

Input Format:
-------------
An integer N representing the number nodes.
A space-separated list of N integers representing the similar to in-order traversal.
A space-separated list of N integers representing the similar to post-order traversal.
An integer Q representing the number of queries.
Q pairs of integers, each representing a query in the form:
Lower level (L)
Upper level (U)

Output Format:
For each query, print the nodes in order within the given depth range

Example
Input:
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
2
1 2
2 3
Output:
[1, 2, 3]
[2, 3, 4, 5, 6, 7]

Explanation:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
Query 1 (Levels 1 to 2): 1 2 3
Query 2 (Levels 2 to 3): 2 3 4 5 6 7
 */


 

import java.util.*;

class TreeNode{
    int data;
    TreeNode left ; 
    TreeNode right ;
    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
    
}



class Solution{
    static int curr = 0;
    public static TreeNode Build(int[]inorder , int[]postorder, int start , int end, Map<Integer,Integer> map){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[curr--]);
        int rootidx = map.get(root.data);
        
        root.right = Build(inorder , postorder , rootidx+1, end, map);
        root.left = Build(inorder , postorder , start , rootidx-1, map);
        
        
        return root;
        
    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root==null) return res;
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                sub.add(curr.data);
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
            res.add(sub);
        }
        return res;
    }
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]inord = new int[n];
        int[]postord = new int[n];
        curr = n-1;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            inord[i] = sc.nextInt();
            map.put(inord[i] , i);
        }
        for(int i = 0 ; i < n ; i++){
            postord[i] = sc.nextInt();
        }
        
        
        
        int q = sc.nextInt();
        int[][]queries = new int[q][2];
        
        for(int i = 0 ; i < queries.length ; i++){
            
            queries[i] = new int[]{sc.nextInt(),sc.nextInt()};
        }
        
        TreeNode root = Build(inord , postord , 0 , n-1 , map);
        
        
        
        
        List<List<Integer>> ansl = levelOrder(root);
        for(int i=0;i<queries.length;i++){
            ArrayList<Integer> al = new ArrayList<>();
            int st = queries[i][0];
            int end = queries[i][1];
            // System.out.println(st+" "+end);
            for(int j=st;j<=end;j++){
               al.addAll(ansl.get(j-1));
            }
            System.out.println(al);
        
        }
    }


}