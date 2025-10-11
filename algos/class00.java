package algos;

public class class00 {
 public static void main(String[] args) {
    int[][] arr = {
        {11, 12, 13, 14, 15},
        {21, 22, 23, 24, 25},
        {31, 32, 33, 34, 35},
        {41, 42, 43, 44, 45},
        {51, 52, 53, 54, 55}
    };
    int c = 0;
        int sum = 0;
        System.out.println(arr.length);
        int i = 0;
    for(int j = arr.length - 1; j >= 0; j--){
        
        sum = sum + arr[i][j];   
        i++;
        
    }
            System.out.println("Sum of diagonal = " + sum);

 }
    
}
