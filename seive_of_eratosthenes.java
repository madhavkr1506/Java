public class seive_of_eratosthenes {
    public static void main(String[] args) {
        int num = 10;
        int count_prime = countprime(num);
        System.out.println("Prime number up to " + num + " is " + count_prime);

    }

    public static int countprime(int num){
        boolean[] isprime = new boolean[num];
        for(int i=2;i<num;i++){
            isprime[i] = true;
        }

        for(int i=2;i*i<num;i++){
            if(isprime[i]){
                for(int j=i*i;j<num;j+=i){
                    isprime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i=2;i<num;i++){
            if(isprime[i]){
                count++;
            }
        }

        return count;
    }
}
