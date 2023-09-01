/*
준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
배낭에 넣을 수 있는 물건들의 가치의 최댓값? 
*/
package CodingTest;

import java.util.Scanner;       //입력을 위한 Scanner 클래스 import

class Thing {       //물건 클래스
    int weight;     //무게와 가치 정수
    int value;

    Thing(int weight, int value){   //멤버변수 생성자
        this.weight = weight;
        this.value = value;
    }
}

public class BackPack12865 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        
        int n = scanner.nextInt();  // scanner 인스턴스로 최대 물품의 수와 최대무게 입력받기
        int k = scanner.nextInt();
        
        Thing[] things = new Thing[n];  // 최대 물품의 수만큼 물건 객체 배열 생성

        for (int i=0; i<n; i++){        // 최대 물품의 수만큼 반복문으로 물건 각각의 무게와 가치 입력받고 저장
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            things[i] = new Thing(weight, value);
        }

        int backpackWeight = 0;   

        
        for (int i=0; i<things.length; i++) {
            while(backpackWeight <= k) {    //backpackWieght (배낭의 총 무게) 가 처음에 입력받은 최대 무게보다 커지기 전까지 반복
                
            }
        }






        scanner.close();
    }
}
