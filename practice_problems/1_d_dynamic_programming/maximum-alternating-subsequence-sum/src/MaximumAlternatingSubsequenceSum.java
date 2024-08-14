public class MaximumAlternatingSubsequenceSum {

    // Этот метод вычисляет максимальную чередующуюся сумму
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0; // Если массив пустой, возвращаем 0

        long even_sum = nums[0]; // Начинаем с первого числа
        long odd_sum = 0;        // Еще ничего не вычитали

        for (int i = 1; i < n; i++) {
            long new_even_sum = Math.max(even_sum, odd_sum + nums[i]);
            long new_odd_sum = Math.max(odd_sum, even_sum - nums[i]);
            even_sum = new_even_sum;
            odd_sum = new_odd_sum;
        }

        return even_sum; // Возвращаем максимальную чередующуюся сумму
    }

    // Основной метод для тестирования функции
    public static void main(String[] args) {
        int[] nums1 = {4, 2, 5, 3};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums1)); // Ожидаемый вывод: 7

        int[] nums2 = {4};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums2)); // Ожидаемый вывод: 4

        int[] nums3 = {4, 2};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums3)); // Ожидаемый вывод: 4

        int[] nums4 = {4, 2, 5};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums4)); // Ожидаемый вывод: 7

        int[] nums5 = {};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums5)); // Ожидаемый вывод: 0

        int[] nums6 = {4, 2, 3};
        System.out.println("Максимальная чередующаяся сумма: " + maxAlternatingSum(nums6)); // Ожидаемый вывод: 5
    }

}
