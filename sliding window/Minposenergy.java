import java.util.*;
class Minposenergy{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[]nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        int left = 0, right = 0;
        
        int prod = 1;
        long ans = Long.MAX_VALUE;
        
        while(right < nums.length) {
            
            // 4 2 3
            // 2 -1 3 4
            
            // -6 
            
            // 2
            // 2 -1
            // 2 -1 3
            
            // -1 3
            // -1 3 4
            
            // 3 4
            
            prod *= nums[right];
            
            int len = right - left + 1;
            System.out.printf("left=%d, right=%d, len=%d, prod=%d\n", left, right, len, prod);
            
            right++;
            
            
            if(len >= l && len <= r) {
                if(prod > 0) {
                    ans = Math.min(ans, prod);
                }
            }
            
            if(len > l) {
                prod /= nums[left];
                left++;
                // prod /= nums[right];
                // right--;
                if(prod > 0) {
                    ans = Math.min(ans, prod);
                }
            }
            
        }
        
        System.out.println(ans);


        
    }
}