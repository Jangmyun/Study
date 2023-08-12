public class ArrayEx5 {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 65, 67, 8};
        int sum = 0;
        float average = 0f;

        for(int i=0; i<arr1.length; i++){
            sum += arr1[i];
        } 
        average = sum / (float)arr1.length;
        System.out.println(sum);
        System.out.println(average);

    }
}
