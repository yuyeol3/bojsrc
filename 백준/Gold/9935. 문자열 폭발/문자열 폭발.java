import java.io.*;
import java.util.*;

import javax.swing.plaf.nimbus.State;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static class State {
        int idx;
        int cnt;
        Stack<Integer> st;

        public State(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
            this.st = new Stack<>();
        }

        public String toString() {
            return "<" + idx + "," + cnt + "," + st + ">";
        }
    }

    public static void main(String[] args) throws IOException {


        String s = br.readLine().stripTrailing();
        String k = br.readLine().stripTrailing();

        boolean[] broken = new boolean[s.length() + 1];
        
        State[] states = new State[s.length()];
        int statesSize = 0;

        states[statesSize++] = new State(0, 0);
        while (statesSize > 0) {
          
            // System.out.println("states: " + Arrays.toString(states) + ", top: " + statesSize);
            // System.out.println("stk: " + Arrays.toString(stk) + ", top: " + stkSize);


            State state = states[statesSize-1];
            if (state.idx >= s.length()) {
                statesSize = 0;
                break;
            }

            // if (state.cnt == k.length()) {
            //     while (!state.st.isEmpty()) {
            //         broken[state.st.pop()] = true;
            //     }

            //     statesSize--;
            //     if (statesSize >= 1)
            //         states[statesSize-1].idx = state.idx + 1;

            //     if (statesSize == 0 && state.idx + 1 < s.length()) {
            //         states[statesSize++] = new State(state.idx + 1, 0);
            //     }
            // }
            if (s.charAt(state.idx) == k.charAt(state.cnt)) {
               
                state.st.push(state.idx);
                state.idx++;
                state.cnt++;
                    // states[statesSize++] = new State(state.idx + 1, state.cnt + 1);
                
                if (state.cnt == k.length()) {
                    while (!state.st.isEmpty()) {
                        broken[state.st.pop()] = true;
                    }

                    statesSize--;
                    if (statesSize >= 1)
                        states[statesSize-1].idx = state.idx;

                    if (statesSize == 0 && state.idx < s.length()) {
                        states[statesSize++] = new State(state.idx, 0);
                    }
                }
            }
            else {
                // statesSize = 0;
                if (state.cnt == 0) {
                    statesSize = 0; //????
                    states[statesSize++] = new State(state.idx + 1, 0);
                    // statesSize--;
                }
                else states[statesSize++] = new State(state.idx, 0);
            }
        }
        // System.out.println(Arrays.toString(states));

    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!broken[i]) 
                sb.append(s.charAt(i));
        }
        String result = sb.toString();
        System.out.println(result.equals("") ? "FRULA" : result);
    }



}