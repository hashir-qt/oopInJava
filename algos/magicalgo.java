package algos;
public class magicalgo {
    public static void main(String[] args) {
          
        int[][] magicSquare = new int[5][5];

        int r = 0, c = 2, num;

        for (num = 1; num <= 5 * 5; ) {
            magicSquare[r][c] = num++;
            r--;
            c++;

            if (num % 5 == 1) {
                r += 2;
                c--;
            } else {
                if (c == 5) {
                    c -= 5;
                } else if (r < 0) {
                    r += 5;
                }
            }
        }

        System.out.println("Magic Square of size " + "5x5" + ":");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 5; c++) {
                System.out.printf("%2d ", magicSquare[r][c]);
            }
            System.out.println();
        }
    }
}
