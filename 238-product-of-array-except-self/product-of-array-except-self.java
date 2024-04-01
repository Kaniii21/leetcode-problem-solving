class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix=1;
        int result[]=new int [nums.length];

        for(int i=0;i<nums.length;i++){
        result[i]=prefix;
        prefix*=nums[i];
        }
        int postfix=1;
        for(int i=nums.length-1;i>=0;i--){
        result[i]*=postfix;
        postfix*=nums[i];
        }
        return result;
    }
}
// the program above can give a runtime error as theres no fixed limit to it
//approach 2:
/*final int MOD =1000000007;
int n = arr.length;
        int[] product = new int[n];

        // Calculate product of elements to the left of each element
        long leftProduct = 1;
        for (int i = 0; i < n; i++) {
            product[i] = (int) (leftProduct % MOD);
            leftProduct = (leftProduct * arr[i]) % MOD;
        }

        // Calculate product of elements to the right of each element and multiply with the left product
        long rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] = (int) ((product[i] * rightProduct) % MOD);
            rightProduct = (rightProduct * arr[i]) % MOD;
        }

        return product;
    }*/
