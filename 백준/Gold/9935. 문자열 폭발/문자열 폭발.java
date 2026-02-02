import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class State {
        int idx;
        int cnt;

        public State(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String k = br.readLine();

        boolean[] broken = new boolean[s.length() + 1];
        
        int[] stateIdx = new int[s.length()];
        int[] stateCnt = new int[s.length()];
        int stateTop = 0;

        int[] st = new int[s.length()];
        int stTop = 0;

        stateIdx[stateTop] = stateCnt[stateTop] = 0;
        stateTop++;
        while (stateTop > 0) {
          
            int sIdx = stateIdx[stateTop-1];
            int sCnt = stateCnt[stateTop-1];
            if (sIdx >= s.length()) {
                stateTop = 0;
                break;
            }

            if (s.charAt(sIdx) == k.charAt(sCnt)) {
               
                st[stTop++] = sIdx;
                sIdx = ++(stateIdx[stateTop-1]);
                sCnt = ++(stateCnt[stateTop-1]);
                
                if (sCnt == k.length()) {
                    for (int i = 0; i < k.length(); i++)
                        broken[st[--stTop]] = true;

                    stateTop--;
                    if (stateTop >= 1)
                        stateIdx[stateTop-1] = sIdx;

                    if (stateTop == 0 && sIdx < s.length()) {
                        stateIdx[stateTop] = sIdx;
                        stateCnt[stateTop] = 0;
                        stateTop++;
                    }
                }
            }
            else {
                if (sCnt == 0) {
                    stateTop = 0;
                    stTop = 0;
                    stateIdx[stateTop] = sIdx + 1;
                    stateCnt[stateTop] = 0;
                    stateTop++;
                    // states[statesSize++] = new State(state.idx + 1, 0);
                }
                else {
                    stateIdx[stateTop] = sIdx;
                    stateCnt[stateTop] = 0;
                    stateTop++;
                    // states[statesSize++] = new State(state.idx, 0);
                }
            }
        }

    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!broken[i]) 
                sb.append(s.charAt(i));
        }
        String result = sb.toString();
        System.out.println(result.equals("") ? "FRULA" : result);
    }



}