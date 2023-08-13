package ExampleCode.ch5;

public class CharArrayStringEx1 {
    public static void main(String[] args) {
        String str = "ABCDE";
        char ch = str.charAt(2);
        String str2 = str.substring(3, str.length());
        String str3 = str.substring(0, 3);

        System.out.println(ch);
        System.out.println(str2);
        System.out.println(str3);
    }
}
