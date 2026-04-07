public class MaiorSegundo {
    public static void main(String[] args) {

        int[] nums = {10, 5, 20, 15, 8};


        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maior) {
                segundoMaior = maior;
                maior = nums[i];
            } else if (nums[i] > segundoMaior && nums[i] != maior) {
                segundoMaior = nums[i];
            }
        }

        System.out.println("Segundo maior: " + segundoMaior);
    }
}