public class Main {
    import java.util.Arrays;

        public static void main(String[] args) {
            Solution solution = new Solution();

            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] resultado1 = solution.twoSum(nums1, target1);
            System.out.println("Teste 1: " + Arrays.toString(resultado1));

            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            int[] resultado2 = solution.twoSum(nums2, target2);
            System.out.println("Teste 2: " + Arrays.toString(resultado2));

            int[] nums3 = {3, 3};
            int target3 = 6;
            int[] resultado3 = solution.twoSum(nums3, target3);
            System.out.println("Teste 3: " + Arrays.toString(resultado3));

        }
    }

