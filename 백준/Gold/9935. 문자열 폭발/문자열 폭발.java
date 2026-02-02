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
        
        State[] states = new State[s.length()];
        int statesSize = 0;

        int[] st = new int[s.length()];
        int stSize = 0;

        states[statesSize++] = new State(0, 0);
        while (statesSize > 0) {
          
            State state = states[statesSize-1];
            if (state.idx >= s.length()) {
                statesSize = 0;
                break;
            }

            if (s.charAt(state.idx) == k.charAt(state.cnt)) {
               
                st[stSize++] = state.idx;
                // state.st.push(state.idx);
                state.idx++;
                state.cnt++;
                
                if (state.cnt == k.length()) {
                    for (int i = 0; i < k.length(); i++)
                        broken[st[--stSize]] = true;

                    statesSize--;
                    if (statesSize >= 1)
                        states[statesSize-1].idx = state.idx;

                    if (statesSize == 0 && state.idx < s.length()) {
                        states[statesSize++] = new State(state.idx, 0);
                    }
                }
            }
            else {
                if (state.cnt == 0) {
                    statesSize = 0;
                    stSize = 0;
                    states[statesSize++] = new State(state.idx + 1, 0);
                }
                else states[statesSize++] = new State(state.idx, 0);
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