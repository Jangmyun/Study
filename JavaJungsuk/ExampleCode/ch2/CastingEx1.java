package ExampleCode.ch2;

public class CastingEx1 {
    public static void main(String[] args) {
        String str = "3";

        System.out.println(str.charAt(0));            //문자열을 char 타입으로 변환
        System.out.println('3' - '0' +1);                   //문자를 숫자로 변환 후 1더하기
        System.out.println(Integer.parseInt(str) + 1);      //문자열을 숫자로 변환 후 1더하기
        System.out.println("3" + "1");                      //문자열끼리 더하기
        System.out.println(3 + '0');                        //숫자에 '0' 더하기 => char타입으로
    }
}
