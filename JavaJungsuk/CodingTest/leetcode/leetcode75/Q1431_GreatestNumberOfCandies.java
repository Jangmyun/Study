package leetcode.leetcode75;
import java.util.ArrayList;
import java.util.List;

public class Q1431_GreatestNumberOfCandies {
    public static void main(String[] args) {
        
    }
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> isGreatestList = new ArrayList<Boolean>();
        int maxCandies =1;
        for(int i=0; i< candies.length; i++){
            if( candies[i]> maxCandies){
                maxCandies = candies[i];
            }
        }
        for(int i=0; i<candies.length; i++){
            if( candies[i]+extraCandies>= maxCandies){
                isGreatestList.add(i, true);
            }else {
                isGreatestList.add(i, false);
            }
        }
        return isGreatestList;
    }
}
