package algos;

public class hammingalgo {
    public static void main(String[] args) {
        double[] message = {0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        double hammingpos = 0;

        for(int i=0; i<message.length; i++){

           for (int n= 2; n < message.length-1; n++) {
                 hammingpos =  Math.pow(2, n);
                 if(hammingpos<=message.length){
                    message[(int)hammingpos] = 9;
                 }
            }
                                System.out.println(message[i]);
        }
    }
}
