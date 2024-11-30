package 哈希表;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //a的去重操作
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //剪枝操作
            // if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
            //     break;
            // }
            // if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
            //     continue;
            // }

            for (int j = i + 1; j < length - 2; j++) {
                //去重b
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //剪枝操作
                // if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                //     break;
                // }
                // if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                //     continue;
                // }

                //开始双指针
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        //对c去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        left++;

                        //对d去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        right--;

                        //如果不相等
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}

//和三数之和方法类似，只是再多套一个循环，多加一次剪枝操作
