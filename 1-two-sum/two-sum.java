class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int comp=0;
        for(int i=0;i<nums.length;i++)
        {
           comp= target-nums[i];
            
            if(map.containsKey(comp))
            {
                return new int[]{map.get(comp),i};
            }
            map.put(nums[i],i);
        }
        return null;
        
    }
}