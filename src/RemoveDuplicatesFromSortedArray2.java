public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {
        int count = 1, atmost = 0, j = 1;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (atmost < 1) {
                    count++;
                    atmost++;
                    nums[j]=nums[i];
                    j++;
                } else
                    atmost++;
            } else {
                atmost = 0;
                count++;
                nums[j]=nums[i];
                j++;
            }
        }
        return count;
    }
}

class RemoveDuplicatesFromSortedArray2Driver{
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3};
        int k = RemoveDuplicatesFromSortedArray2.removeDuplicates(arr);
        System.out.println(k);
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}