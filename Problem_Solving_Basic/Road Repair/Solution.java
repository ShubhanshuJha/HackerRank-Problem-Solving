class Result {
    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
        if (crew_id.size() != job_id.size()) return -1;
        long sum = 0L;
        PriorityQueue<Integer> q1 = new PriorityQueue<>(crew_id);
        PriorityQueue<Integer> q2 = new PriorityQueue<>(job_id);
        
        while (!q1.isEmpty()) {
            sum += Math.abs(q1.poll() - q2.poll());
        }   
        return sum;
    }
}
