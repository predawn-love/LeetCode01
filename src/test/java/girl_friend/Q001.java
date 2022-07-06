package girl_friend;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Q001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.printf("请输入第%d个同学成绩\n", i + 1);
            int a = sc.nextInt();
            arr[i] = a;
        }

        for (int i = 0; i < 5; i++) {
            sum += arr[i];
        }
        int adv = sum / 5;
        System.out.printf("总成绩为%d\n", sum);
        System.out.printf("平均数为%d\n", adv);

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < 5; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
        }

        System.out.printf("最大值为%d\n", max);
        System.out.printf("最小值为%d\n", min);

    }

    @Test
    public void fun00() {
        char c = 'a';
        char[] chars = new char[8];
        String s = "langjiexin";
        String[] ss = new String[9];

        int i0 = 0;
        int i1 = 1;
        int i2 = 2;

        int[] arrayName = new int[3]; // 3 , 4 , 5
        for (int k = 0; k < 3; k++) {
            arrayName[k] = k + 3;
        }

        int first = arrayName[0];
        int first2 = arrayName[1];

    }

    // 链表每个节点的内容
    {
        // 1,当前节点值
        // 2,后继节点所在地址
    }

    class ListNode {
        int myValue;    // 自己
        ListNode nextNode;  // 下一个

        public ListNode() {
        }

        public ListNode(int myValut, ListNode nextNode) {
            this.myValue = myValut;
            this.nextNode = nextNode;
        }

        public ListNode(int myValut) {
            this.myValue = myValut;
        }

        public int getMyValue() {
            return myValue;
        }

        public void setMyValue(int myValue) {
            this.myValue = myValue;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    @Test
    public void fun01() {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node0.nextNode = node1;
        node1.nextNode = node2;

        xxx(node0);
    }

    // 传入一个变量名，这个变量里面有 N 个元素。
    public void xxx(ListNode listNode) {
        //......
    }

    // 传入一个变量名，这个变量里面有 100 个元素。
//    public void xxx3(int i0, int i1, int i2, int i3, int i4,...) {
        //......
//    }

    @Test
    public void bubbleSortTest() {
        int[] nums = new int[]{2,6,7,1,3,0};

        // 对 nums 数组排序，让他成为一个升序数组（从小到大的顺序）


        // 0,1,2,3,4,5,6...
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void insertSortTest2() {
        int[] nums = new int[]{2,6,0,1,7,0};

        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            int max = nums[index];
            for (int w = 0; w < nums.length - i; w++) {
                if (nums[w] > max) {
                    max = nums[w];
                    index = w;
                }
            }
            int x = nums.length - 1 - i;
            nums[index] = nums[x];
            nums[x] = max;
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void insertSortTest() {
        int[] nums = new int[]{2,6,7,1,3,0};
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = 0;
            int maxValue = nums[maxIndex];
            for (int k = 0; k <= nums.length - i - 1; k++) {
                if (nums[k] > maxValue) {
                    maxValue = nums[k];
                    maxIndex = k;
                }
            }
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - i] = maxValue;
            nums[maxIndex] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void insertSortTest3() {
        int[] nums = new int[]{2,6,7,1,3,0};

        // 2,6,7,1,3,0 、、 2,6,7,1,3 、、 2,6,7,1 、、 2,6,7 、、 2,6、、 2
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums.length - i - 1; j++) {
                System.out.print(nums[j] + ",");
            }
            System.out.print("------");
            System.out.println("每一次，我要的范围的最后一个元素 :" + nums[nums.length - i - 1]);
        }
    }
}
