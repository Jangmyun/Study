package Java의정석.ch4;
import java.util.Scanner;
public class FlowEx34 {
    public static void main(String[] args) {
        int menu=0, num=0;
        Scanner scanner = new Scanner(System.in);

        outer:
        while(true) {
            System.out.println("1: squre");
            System.out.println("2: squre root");
            System.out.println("3: log");
            System.out.print("(Quit:0) Choose the menu (1~3) >");

            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            if (menu == 0){
                break;
            }else if (!(1<=menu && menu<=3)){
                System.out.println("Wrong choice. Plz Enter again");
                continue;
            }
            while (true) {
                System.out.print("(Quit:0 , Escape:99) Enter number for calculating >");
                tmp = scanner.nextLine();
                num = Integer.parseInt(tmp);

                if (num==0) {
                    break;
                }else if (num == 99) {
                    break outer;                        //outer 반복문 탈출
                }

                switch(menu) {
                    case 1:
                        System.out.println("result = " + num*num);
                        break;
                    case 2:
                        System.out.println("result = " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result = " + Math.log(num));
                        break;
                }   
            }

            
        }
    }
}
