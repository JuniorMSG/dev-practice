package leetcode;

import java.util.*;

public class TwoSum {

    public int[] solution(int[] nums, int target) {

      HashMap<Integer, Integer> hashInt = new HashMap<>();

      for(int i=0; i<nums.length; i++){

        int complement = target - nums[i];
        if(hashInt.containsKey(complement)) {
          return new int[]{hashInt.get(complement), i};
        }

        hashInt.put(nums[i], i);

        // 7 - 2 = 5

      }



        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        // TC 1: 기본 케이스
        int[] result1 = sol.solution(new int[]{2, 7, 11, 15}, 9);
        System.out.println("TC1: " + Arrays.toString(result1)); // 예상: [0, 1]

        // TC 2: 다른 위치
        int[] result2 = sol.solution(new int[]{3, 2, 4}, 6);
        System.out.println("TC2: " + Arrays.toString(result2)); // 예상: [1, 2]

        // TC 3: 같은 숫자
        int[] result3 = sol.solution(new int[]{3, 3}, 6);
        System.out.println("TC3: " + Arrays.toString(result3)); // 예상: [0, 1]
    }
}
