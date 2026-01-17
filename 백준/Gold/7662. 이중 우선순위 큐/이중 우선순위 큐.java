import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Element {
        public long data;
        public boolean valid;

        public Element(long data) {
            this.data = data;
            this.valid = true;
        }

    }

    static class DoublePQ {
        private PriorityQueue<Element> minQ ;
        private PriorityQueue<Element> maxQ = new PriorityQueue<>((a, b)->Long.compare(b.data, a.data));

        public static final long EMPTY = Integer.MIN_VALUE - 1L;

        public DoublePQ() {
            minQ = new PriorityQueue<>((a, b)->Long.compare(a.data, b.data));
            maxQ = new PriorityQueue<>((a, b)->Long.compare(b.data, a.data));
        }

        public void offer(long data) {
            Element el = new Element(data);
            minQ.offer(el);
            maxQ.offer(el);
        }

        public long pollMin() {
            Element el = null;
            while (!minQ.isEmpty()) {
                el = minQ.poll();
                if (el.valid) break;
            }

            if (el == null || !el.valid)
                return EMPTY;

            el.valid = false;
            return el.data;
        }

        public long pollMax() {
            Element el = null;
            while (!maxQ.isEmpty()) {
                el = maxQ.poll();
                if (el.valid) break;
            }

            if (el == null || !el.valid)
                return EMPTY;

            el.valid = false;
            return el.data;
        }

    }

    public static void main(String[] args) throws IOException{
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            DoublePQ dpq = new DoublePQ();

            int k = Integer.parseInt(br.readLine());
            StringTokenizer st;

            while (k-->0) {
                st = new StringTokenizer(br.readLine());

                String op = st.nextToken();
                int arg = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    dpq.offer(arg);
                }
                else if (op.equals("D")) {
                    if (arg == -1) dpq.pollMin(); 
                    else if (arg == 1) dpq.pollMax();
                }
            }

            long leftMax = dpq.pollMax();
            long leftMin = dpq.pollMin();

            if (leftMin == DoublePQ.EMPTY)
                leftMin = leftMax;

            if (leftMax == DoublePQ.EMPTY) {
                sb.append("EMPTY\n");
                continue;
            }

            sb.append(leftMax)
              .append(" ")
              .append(leftMin)
              .append("\n");
        }

        System.out.print(sb);
    }
}