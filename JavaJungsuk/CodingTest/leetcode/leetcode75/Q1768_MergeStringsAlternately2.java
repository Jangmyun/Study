package leetcode.leetcode75;

public class Q1768_MergeStringsAlternately2 {
    public static void main(String[] args) {
        
    }
    static String mergeAlternately2(String word1, String word2){
        char[] mergedCharArr = new char[word1.length()+ word2.length()];
        int i=0;
        int charArrIndex =0;
        while (i<word1.length()|| i<word2.length()){
            if(i< word1.length()){
                mergedCharArr[charArrIndex] = word1.charAt(i);
                charArrIndex++;
            }
            if(i<word2.length()){
                mergedCharArr[charArrIndex] = word2.charAt(i);
                charArrIndex++;
            }
            i++;
        }
        return String.valueOf(charArrIndex);
    }
}
