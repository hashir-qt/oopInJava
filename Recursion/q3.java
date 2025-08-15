public class q3 {
    public static int maxNum(int[] arr, int len){
      
    if(len == 1) {
        return arr[0];
       }
       int findMax = maxNum(arr, len - 1);
       if (findMax > arr[len -1]){
        return findMax;
       }
       else{
        return arr[len - 1];
       }
    }
    public static void main(String[] args) {
        int[] array = {32, 68, 100, 42, 51, 33};
        int len = array.length;
       
        System.out.println(maxNum(array, len));
    }
}
