class Solution {
    boolean isHarshad(int num, int[] arr){

        int n = num;
        int sum = 0;
        while(n > 0) {
            int rem = n%10;
            sum += rem;
            n /= 10;
        }

        arr[0] = sum;

        return num % sum == 0;
    }
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        
        int[] arr = new int[1];
        return isHarshad(x, arr) ? arr[0] : -1;

    }
}
