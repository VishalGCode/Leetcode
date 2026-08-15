import java.util.*;

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        if (Arrays.equals(nums1, nums2)) return 0;
        List<Integer> start = toList(nums1);
        List<Integer> target = toList(nums2);
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int operations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                List<Integer> current = queue.poll();
                if (current.equals(target)) return operations;
                int n = current.size();
                for (int L = 0; L < n; L++) {
                    for (int R = L; R < n; R++) {
                        List<Integer> sub = current.subList(L, R + 1);
                        List<Integer> remaining = new ArrayList<>();
                        for (int i = 0; i < n; i++) {
                            if (i < L || i > R) remaining.add(current.get(i));
                        }
                        for (int insertPos = 0; insertPos <= remaining.size(); insertPos++) {
                            List<Integer> nextState = new ArrayList<>(remaining);
                            nextState.addAll(insertPos, sub);
                            if (visited.add(nextState)) queue.offer(nextState);
                        }
                    }
                }
            }
            operations++;
        }
        return -1;
    }

    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int val : arr) list.add(val);
        return list;
    }
}