import java.util.*;

class Solution {
    class Process {
        public int pid, priority;
        public boolean exited;
    }
    
    public int solution(int[] priorities, int location) {
        
        Process[] processes = new Process[priorities.length];
        Deque<Process> q = new ArrayDeque<Process>();
        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process();
            p.pid = i;
            p.priority = priorities[i];
            p.exited = false;
            processes[i] = p;
            q.offerLast(p);
        }
        
        Arrays.sort(
            processes, 
            (a, b)->Integer.compare(b.priority, a.priority)
        );
        
        int ptr = 0;
        int answer = 0;
        while (!q.isEmpty()) {
            Process p = q.pollFirst();
            // 실행 조건이 아닌 경우
            if (p.priority < processes[ptr].priority) {
                q.offerLast(p);
                continue;
            }
            
            // 실행 조건인 경우
            p.exited = true;
            answer++;
            if (p.pid == location) {
                return answer;
            }
            
            while (ptr < processes.length && processes[ptr].exited) {
                ptr++;
            }
        }
        
        return -1;
    }
}