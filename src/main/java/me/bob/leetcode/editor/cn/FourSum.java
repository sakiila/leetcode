//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 741 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18 四数之和
 * 2021-02-15 09:25:50
 * 思路：排序 + 双指针
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = j + 1, p = n - 1;
                    while (k < p) {
                        while (k > j + 1 && k < n && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        if (k >= p) {
                            break;
                        }

                        int sum = nums[i] + nums[j] + nums[k] + nums[p];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                            k++;
                        } else if (sum < target) {
                            k++;
                        } else if (sum > target) {
                            p--;
                        }
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}