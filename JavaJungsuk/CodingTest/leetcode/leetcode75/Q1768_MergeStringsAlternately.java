package leetcode.leetcode75;

public class Q1768_MergeStringsAlternately {
    public static void main(String[] args) {
        mergeAlternately("ABCDEF", "GHI");
    }
    static String mergeAlternately(String word1, String word2){
        char[] mergedCharArr = new char[word1.length()+word2.length()];
        if( word1.length() == word2.length()){
            int j=0;
            for( int i=0; i< word1.length(); i++){
                mergedCharArr[j]= word1.charAt(i);
                j++;
                mergedCharArr[j]= word2.charAt(i);
                j++;
            }
        } else if ( word1.length() < word2.length()){
            int j=0;
            int currentIndex=0;
            for( int i=0; i<word1.length(); i++) {
                mergedCharArr[j] = word1.charAt(i);
                j++;
                mergedCharArr[j] = word2.charAt(i);
                currentIndex++;
                j++;
            }
            for( int i= currentIndex; i<word2.length(); i++){
                mergedCharArr[j] = word2.charAt(i);
                j++;
            }
        } else if ( word1.length() > word2.length()){
            int j=0;
            int currentIndex=0;
            for( int i=0; i<word2.length(); i++) {
                mergedCharArr[j] = word1.charAt(i);
                j++;
                mergedCharArr[j] = word2.charAt(i);
                currentIndex++;
                j++;
            }
            for( int i= currentIndex; i<word1.length(); i++){
                mergedCharArr[j] = word1.charAt(i);
                j++;
            }
        }

        String mergedString = String.valueOf(mergedCharArr);
        System.out.println(mergedString);

        return mergedString;
    }
    
}
