class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int states=n*(k+1);
        int[] dist = new int[states];
        Arrays.fill(dist, Integer.MAX_VALUE);
        MinHeap pq = new MinHeap();
        int startState = 1;
        dist[startState] = 0;
        pq.add(encode(0, startState));
        while(!pq.isEmpty()){
            long entry = pq.poll();
            int cost=(int) (entry >>> 32);
            int state=(int) entry;
            if(cost!=dist[state]) continue;
            int node=state / (k + 1);
            int count=state % (k + 1);
            if (node == n - 1) return cost;
            char currentChar = labels.charAt(node);
            for(int[] edge : graph[node]){
                int nextNode = edge[0];
                int weight = edge[1];
                char nextChar = labels.charAt(nextNode);
                int nextCount;
                if(currentChar==nextChar) nextCount = count + 1;
                else nextCount = 1;
                if(nextCount>k) continue;
                int nextState = nextNode * (k + 1) + nextCount;
                int newCost = cost + weight;
                if(newCost < dist[nextState]){
                    dist[nextState] = newCost;
                    pq.add(encode(newCost, nextState));
                }
            }
        }

        return -1;
    }

    // Encode cost and state into a single long
    private long encode(int cost, int state) {
        return ((long) cost << 32) | (state & 0xffffffffL);
    }

    // Custom primitive min heap
    static class MinHeap {

        private long[] heap = new long[1024];
        private int size = 0;

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(long value) {

            if (size == heap.length) {
                heap = Arrays.copyOf(heap, heap.length * 2);
            }

            int index = size++;

            while (index > 0) {

                int parent = (index - 1) / 2;

                if (heap[parent] <= value) {
                    break;
                }

                heap[index] = heap[parent];
                index = parent;
            }

            heap[index] = value;
        }

        public long poll() {

            long result = heap[0];

            long last = heap[--size];

            if (size == 0) {
                return result;
            }

            int index = 0;

            while (true) {

                int left = index * 2 + 1;
                int right = left + 1;

                if (left >= size) {
                    break;
                }

                int smallest = left;

                if (right < size && heap[right] < heap[left]) {
                    smallest = right;
                }

                if (heap[smallest] >= last) {
                    break;
                }

                heap[index] = heap[smallest];
                index = smallest;
            }

            heap[index] = last;

            return result;
        }
    }
}