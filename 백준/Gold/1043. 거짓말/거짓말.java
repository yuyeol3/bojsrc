import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Integer>[] partyParticipant = new List[M+1];

        @SuppressWarnings("unchecked")
        List<Integer>[] participantParty = new List[N+1];

        // O(M)
        for (int i = 0; i < M+1; i++) 
            partyParticipant[i] = new ArrayList<>();

        // O(N)
        for (int i = 0; i < N+1; i++)
            participantParty[i] = new ArrayList<>();
        
        int liable = M;
        boolean[] liableParty = new boolean[M+5];

        Arrays.fill(liableParty, true);

        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] knowsTruth = new boolean[N+5];
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        // O(K)
        for (int i = 0; i < K; i++) {
            int pNum = Integer.parseInt(st.nextToken());
            knowsTruth[pNum] = true;
            dq.addLast(pNum);
        }
        
        // O(M)
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int participantNum = Integer.parseInt(st.nextToken());
                partyParticipant[i].add(participantNum);
                participantParty[participantNum].add(i);
            }
        }

        /*
        거짓말쟁이로 알려지지 않기 위한 조건
        1. 진실을 아는 사람이 있는 파티에서 거짓말하지 않는다.
        2. 진실을 아는 사람이 있는 파티에도 참석하는 사람이 있는 파티에서 거짓말하지 않는다.

        진실을 아는 사람을 큐에 먼저 넣고, 진실을 아는 사람과 같은 파티에 참석하는 참가자를 인접 노드로 본다.

        */
        
        // O(N + NK?)
        while (!dq.isEmpty()) {
            int p = dq.poll(); // 진실을 아는 사람

            for (int party : participantParty[p]) {
                if (!liableParty[party]) continue;
                liable--;
                liableParty[party] = false;
                for (int participant : partyParticipant[party]) {
                    if (knowsTruth[participant]) continue;
                    knowsTruth[participant] = true;
                    dq.addLast(participant);
                }
            }
        }

        // for (List<Integer> l : partyParticipant) {
        //     bw.write(l + "\n");
        // }
        // bw.write("\n");
        // // bw.write(participantParty + "\n\n");
        // for (int i = 1; i <= M; i++) {
        //     bw.write(liableParty[i] + " ");
        // }
        // bw.write("\n");
        
        bw.write(liable + "\n");
        bw.flush();
    }    
}