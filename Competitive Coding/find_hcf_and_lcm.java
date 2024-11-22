public class find_hcf_and_lcm {

    public static int findHcf(int num1, int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int findLcm(int num1,int num2){
        return (num1 * num2) / findHcf(num1, num2);
    }
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 55;
        int num3 = 65;

        int HCF = findHcf(num1, findHcf(num2, num3));
        int LCM = findLcm(num1, findLcm(num2, num3));

        System.out.println("HCF: " + HCF + "\nLCM: " + LCM);

    }
}