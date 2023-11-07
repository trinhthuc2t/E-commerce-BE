package ecommerce.controller;

public class Test {

    public static int search(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;
        while ( left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == x){
                return mid;
            }else if (x > arr[mid]){
                left = mid +1;
            }else {
                right = mid -1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,8,9};
        int x = 8;
       int a = search(arr,x);
        System.out.println(a);
    }

}
