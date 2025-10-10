package algos;

public class level1 {
    public static void main(String[] args) {
         int[] bits = {0, 1, 1, 0, 1, 1, 1, 0, 0};
                int c1 = 0;
                int h1 = 0;
                int temp = 0;
                double hammingpos = 0;

            for(int n=0; i<bits.length; i++){
                 hammingpos =  Math.pow(2, n);

                for(int j = n; j<= i; j++){
                    temp = bits[j];
                    h1 = h1 + temp;
                    c1 = j;
                }
                 i = c1 + 1;
            }
   
    }
}
