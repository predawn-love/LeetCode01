package myleetcode.prefixSum;

import java.util.*;

public class Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR {

    /**
     * 自己写的，debug了半天。
     * 思路： x ^ y == y ^ z 说明  x == z
     */
    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        Map<Integer, List<Integer>> valVsIndexList = new HashMap<>();

        // 原因在没有初始化 0->{0}，生效场景：若有 0 ~ k 这一段总异或后为 0。
        valVsIndexList.put(0, new ArrayList<Integer>(){{add(0);}});
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
            List<Integer> list = valVsIndexList.getOrDefault(prefixXOR[i + 1], new ArrayList<>());
            list.add(i + 1);
            valVsIndexList.put(prefixXOR[i + 1], list);
        }

        int ans = 0;
//        List<String> l = new ArrayList<>();
        for (int k = 2; k <= n; k++) {
            int val = prefixXOR[k];
            for (int j = k; j > 1; j--) {
                if (!valVsIndexList.containsKey(val)) {
                    continue;
                }
                List<Integer> list = valVsIndexList.get(val);
                for (int idx : list) {
                    // [i, j - 1] 和 [j, k] 这一段 表示为 prefixXOR[j - 1] ^ prefixXOR[i - 1] 和 prefixXOR[k] ^ prefixXOR[j - 1]
                    // 即： 从 i 开始的话，要舍弃掉的是 0 ~ i - 1 也就是 prefixXOR[k] == prefixXOR[i - 1];
                    // 在这里 idx 就是 i - 1，而条件为 i < j，所以 if 判断应为 idx + 1 < j
                    if (idx + 1 < j) {
                        ans++;
//                        l.add(new StringBuilder().append(i + 1).append(",").append(j).append(",").append(k).toString());
                    } else {
                        break;
                    }
                }
            }
        }
//        System.out.println(l);
        return ans;
    }

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        int ans = 0;
        ArrayList<String> l = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            for (int j = k; j >= 1; j--) {
                for (int i = 1; i < j; i++) {
                    int a = prefixXOR[k] ^ prefixXOR[j];
                    int b = prefixXOR[i - 1] ^ prefixXOR[j];
                    if (a == b) {
                        l.add(new StringBuilder().append(i).append(",").append(j).append(",").append(k).toString());
                        ans++;
                    }
                }
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                for (int k = j; k <= n; k++) {
//                    int a = prefixXOR[j - 1] ^ prefixXOR[i - 1];
//                    int b = prefixXOR[k] ^ prefixXOR[j - 1];
//                    if (a == b) ans++;
//                }
//            }
//        }
        System.out.println(l);
        return ans;
    }

    /**
     * 宫水三叶的哈希表代码，比上面我自己的更加简洁：
     */
    public int countTriplets1(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        Map<Integer, List<Integer>> valVsIndexList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        // 从零开始的原因是，方便把 0->{0} 初始化进入 Map
        for (int k = 0; k <= n; k++) {
            int val = prefixXOR[k];
            List<Integer> list = valVsIndexList.getOrDefault(val, new ArrayList<>());
            for (int idx : list) {
                // 疑问：为什么要对 i 进行 i = idx + 1; 呢？
                // 比如 (0,1,2),(0,2,2) 这两个三元组，可以看到 i 为 0，k 为 2 时，j 可以取 1 或者 2 有两个选择
                // 此时  2 - 0 = 2; 这样看起来才对。 (批注：大错特错)
                // 答： 这里 idx + 1 是指坐标偏移。偏移成坐标 i (prefixXOR 内的坐标)，否则的话实际上 idx 是 i - 1.
                int i = idx + 1;
                ans += k - i;
            }
            list.add(k);
            valVsIndexList.put(val, list);
        }
        return ans;
    }

    /**
     * 宫水三叶的删去前缀和数组的哈希表代码，比上面我自己的更加简洁：
     */
    public int countTriplets3(int[] arr) {
        int ans = 0;
        int n = arr.length;

        // 事实上，甚至可以不预处理「前缀异或数组」，使用一个变量 xor 边遍历边计算即可
        int xor = 0;
        Map<Integer, List<Integer>> valVsIndexList = new HashMap<>();
        valVsIndexList.put(0, new ArrayList<Integer>(){{add(0);}});

        for (int k = 1; k <= n; k++) {
            xor ^=  arr[k - 1];
            List<Integer> list = valVsIndexList.getOrDefault(xor, new ArrayList<>());
            for (int idx : list) {
                int i = idx + 1;
                ans += k - i;
            }
            list.add(k);
            valVsIndexList.put(xor, list);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int i = new Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets2(new int[]{2, 3, 1, 6, 7});
//        int[] arr = {1, 1, 1, 1};
        int[] arr = {2, 3, 1, 6, 7};
        int i = new Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets2(arr);
        int i2 = new Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets(arr);
        System.out.println(i);
        System.out.println(i2);
    }
}
