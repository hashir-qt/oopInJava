package algos;

public class hammingalgo {
    public static void main(String[] args) {
        double[] message = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        double hammingpos = 0;

        for(int i=0; i<message.length; i++){

           for (int n= 0; n < message.length-1; n++) {
                 hammingpos =  Math.pow(2, n);
                 if(hammingpos<=message.length){
                    message[(int)hammingpos] = 9;
                 }
            }
                                System.out.println(message[i]);
        }
    }
}
