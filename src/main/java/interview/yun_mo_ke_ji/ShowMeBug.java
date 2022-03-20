package interview.yun_mo_ke_ji;

import java.util.*;

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class ShowMeBug {
    // 111111

    Map<Character, Character> leftVsRight;

    {
        leftVsRight = new HashMap<>();
        leftVsRight.put('(', ')');
        leftVsRight.put('[', ']');
        leftVsRight.put('{', '}');
    }

    public boolean solution(String input) {
        char[] cs = input.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : cs) {
            if (stack.isEmpty()) {
                if (leftVsRight.containsKey(c)) {
                    stack.push(c);
                    continue;
                } else {
                    return false;
                }
            }

            if (leftVsRight.containsKey(c)) {
                stack.push(c);
            } else {
                if (leftVsRight.get(stack.peek()).equals(c)) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main1(String[] args) {
        boolean res0 = new ShowMeBug().solution("()[]{}{()[]}");
        boolean res1 = new ShowMeBug().solution(")[]{}{()[]}");
        boolean res2 = new ShowMeBug().solution("()[]{}{()[]");
//        boolean res3 = new ShowMeBug().solution("a");
        System.out.println(res0);
        System.out.println(res1);
        System.out.println(res2);
//        System.out.println(res3);
    }


    public void sort(int[] nums) {
        if (nums == null) {
            return;
        }
        heapSort(nums, 0, nums.length - 1);
    }

    private void heapSort(int[] nums, int begin, int end) {
        // 1、自底向上建堆
        // 0、1、2、3、4、5、6、7、8、9
        for (int i = (end - 1) / 2; i >= 0; i--) {
            sink(nums, i, end);
        }


        // 2、不断地将堆顶和末尾交换，然后自顶向下恢复堆
        for (int i = 0; i < end; i++) {
            swap(nums, 0, end - i);
            sink(nums, 0, end - i - 1);
        }
    }

    private void sink(int[] nums, int i, int end) {
        while (true) {
            // 得到要比较的子节点对应的数组下标
            // 0、1、2、3、4、5、6、7、8、9
            int j = i * 2 + 1;
            if (j > end) {
                return;
            }
            if (j + 1 <= end) {
                if (nums[j] <= nums[j + 1]) {
                    j++;
                }
            }

            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                i = j;
            } else {
                return;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {1, 23, 4, 7, 8};
        new ShowMeBug().sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}