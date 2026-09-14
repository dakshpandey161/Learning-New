class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int prefix=i+1;
            int suffix=nums.length-1;
            while(prefix<suffix)
            {
                ArrayList<Integer> arr=new ArrayList<>();
                if(nums[prefix]+nums[suffix]>(nums[i]*-1))
                {
                    suffix--;
                }
                 else if(nums[prefix]+nums[suffix]<(nums[i]*-1))
                 {
                    prefix++;
                 }
                 else
                 {
                    arr.add(nums[prefix]);
                    arr.add(nums[i]);
                    arr.add(nums[suffix]);
                    result.add(arr);
                    prefix++;
                    suffix--;
                    while(prefix<suffix && nums[prefix]==nums[prefix-1]) prefix++;
                    while(prefix<suffix && nums[suffix]==nums[suffix+1]) suffix--;
                 }

            }
           
        }
        return result;
        
    }
}