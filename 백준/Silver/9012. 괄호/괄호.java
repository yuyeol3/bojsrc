import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String pString = br.readLine();

            int vp = 0;

            for (int i = 0; i < pString.length(); i++) {
                if (vp < 0) break;

                if (pString.charAt(i) == '(') vp++;
                else vp--;
            }

            bw.write((vp == 0 ? "YES" : "NO") + "\n");
        }
        bw.flush();
    }
}