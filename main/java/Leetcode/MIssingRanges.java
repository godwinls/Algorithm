package Leetcode;
import java.util.*;

/**
 * Created by Yunzhuo on 10/18/2016.
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<String>();
        int next = lower;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<lower)
                continue;
            if(nums[i]==next){
                next++;
                continue;
            }
            res.add(getRange(next, nums[i]-1));
            next = nums[i]+1;
        }
        if(next<=upper)
            res.add(getRange(next, upper));
        return res;
    }

    private String getRange(int i, int j){
        if(i==j)
            return String.valueOf(i);
        else
            return String.valueOf(i)+"->"+String.valueOf(j);
    }
}
