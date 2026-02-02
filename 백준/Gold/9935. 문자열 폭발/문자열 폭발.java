import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String k = br.readLine();

        char[] stk = new char[s.length()+1];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            stk[top++] = s.charAt(i);

            // 0 1 2 | 3
            if (stk[top-1] == k.charAt(k.length()-1)) {
                int base = top - k.length();
                int isBomb = 1;

                if (base < 0) isBomb = 0;
                for (int j = 0; isBomb == 1 && j < k.length(); j++) {
                    if (stk[base+j] != k.charAt(j)) isBomb = 0;
                }

                top -= (isBomb) * k.length();
            }
        }
        
    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append(stk[i]);
        }
        String result = sb.toString();
        System.out.println(result.equals("") ? "FRULA" : result);
    }

}