package algos;

import java.util.Scanner;

public class newalgo {
    

    public static void main(String[] args) {

   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the start and end range: ");
   int start = sc.nextInt();
   int end = sc.nextInt();
   System.out.println("Enter the hamming position (i.e for h1 use 1):");
    int hammingpos = sc.nextInt();
    System.out.println("---------------------");
   switch (hammingpos) {
    case 1:
        h1(start, end);
        break;
    case 2:
        h2(start, end);
        break;
    case 3:
        h3(start, end);  
        break;
    case 4:
        h4(start, end);
        break;
    default:
        break;
   }
    sc.close();
    }
   public  static void h1(int start, int end){
      int c1 = 0;
        for(int i =start; i<=end; i++){
        for(int j = i; j<= i; j++){
            System.out.println(j);
            c1 = j;
        }
        i = c1 + 1;
    }
   }
    public  static void h2(int start, int end){
     int c2 = 0;
    for(int i = start; i<=end; i++){
        if(i % 2 == 0){
        
            for(int j = i; j<= i +1; j++){
            System.out.println(j);;
            c2 = j;
        }
         i = c2 + 2;
        }   
    }
    }
    public  static void h3(int start, int end){
    int c3 = 0;
    for(int i = start; i<=end; i++){
         if(i % 4 == 0){
        for(int j = i; j<= i +3; j++){
            System.out.println(j);;
            c3 = j;
        }
        i = c3 + 4;
    }
    }
}
    public  static void h4(int start, int end){
     int c4 = 0;
    for(int i =start; i<=end; i++){
         if(i % 8 == 0){
        for(int j = i; j<= i +7; j++){
            System.out.println(j);;
            c4 = j;
        }
        i = c4 + 8;
    }
    }
}
    public  static void h5(int start, int end){
     int c5 = 0;
    for(int i =start; i<=end; i++){
         if(i % 8 == 0){
        for(int j = i; j<= i +7; j++){
            System.out.println(j);;
            c5 = j;
        }
        i = c5 + 8;
    }
    }
}
}