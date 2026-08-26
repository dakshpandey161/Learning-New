import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int ml=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        for(int i:set)
        {
            if(!set.contains(i-1))
            {
                int j=i; // i-1 not exist so i is the first in sequence 
                int l=1;
            while(set.contains(j+1) ) 
            {
                j++;
                l++;  
            }
            ml=Math.max(ml,l);
            }
        }
        return ml;
        
    }
}