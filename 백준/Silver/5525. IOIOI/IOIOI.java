import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // String str = br.readLine();
        char[] str = br.readLine().toCharArray();
        
        int state, pNum, count;
        state = pNum = count = 0;
        for (int i = 0; i < M; i++) {
            char c = str[i];
            int nextState = state;
            int nextPnum = pNum;
            switch (state) {
                case 0 : 
                    nextState = (c == 'I') ? 1 : 0;
                    break;
                case 1 :
                    nextState = (c == 'O') ? 2 : 0;
                    nextState = (c == 'I') ? 1 : nextState;
                    break;
                case 2 :
                    nextState = (c == 'I') ? 3 : 0;
                    break;
                case 3 : 
                    nextState = (c == 'I') ? 1 : 0;
                    nextState = (c == 'O') ? 2 : nextState;
                    break;
            }

            if (state == 2) nextPnum = nextState == 3 ? pNum + 1 : 0;
            if (state == 3) nextPnum = nextState == 2 ? pNum : 0;
            

            if (pNum > 0 && nextPnum == 0) 
                count += (pNum >= N) ? pNum - N + 1 : 0;
            
            state = nextState;
            pNum = nextPnum;
        }
        count += (pNum >= N) ? pNum - N + 1 : 0;
        System.out.println(count);
    }
}