package algos;

public class level1 {
    public static void main(String[] args) {
         int[] bits = { 0, 1, 1, 0, 1, 1, 1, 0, 0};
         
                int c1 = 0;
                int h1 = 0;
                int temp = 0;
                double hammingpos = 0;

            for(int i=0; i<bits.length; i++){
                //  hammingpos =  Math.pow(2, n);
                  int n = 1;

                 hammingpos =  Math.pow(2,n );
                //  if(n > 0)
                for(int j = n; j<= bits.length - 1; j++){
                    temp = bits[j];
                    h1 = h1 + temp;
                    c1 = j;
                    System.out.println("h2 = " + h1);

                }
                 i = c1 + (int)hammingpos;
            }
    }
}
