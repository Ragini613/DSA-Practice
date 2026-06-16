class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character, Integer> count = new HashMap<>();
       for (char task : tasks) count.put(task, count.getOrDefault(task, 0) + 1);
       PriorityQueue<Integer> maxHeap = new PriorityQueue<> (Collections.reverseOrder());
       maxHeap.addAll(count.values());
       int time = 0;
       Queue<int[]> cooldown = new LinkedList<>();
       while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
        time++;
        if(!maxHeap.isEmpty()){
            int curr = maxHeap.poll() -1;
            if(curr>0) cooldown.offer(new int[] {curr, time + n});

        }
        if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
            maxHeap.offer(cooldown.poll()[0]);
        }
       }
       return time;
    }
}