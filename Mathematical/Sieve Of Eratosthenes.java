//SC - O(n+1) == O(n)
//TC - O(n * (1/2 + 1/3 + 1/5 + 1/7 + 1/11 + ....))
//    = O(n * (harmonic series over prime ->  very slowly grows)
//    = O(n * log(log(n)) )

private boolean[] sieveHelper(int n){

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <= n; i++){
            if(isPrime[i] == true){

                for(int j = 2; i*j <= n; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        return isPrime;
    }
