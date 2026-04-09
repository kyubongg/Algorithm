import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean[] isKnown;
    static boolean[] partyVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 진실을 아는사람 저장 배열
        isKnown = new boolean[N+1];
        partyVisited = new boolean[M+1];
        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < trueNum; i++) {
            isKnown[Integer.parseInt(st.nextToken())] = true;
        }

        // 참가자가 참석하는 파티 번호
        List<Integer>[] parties = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            parties[i] = new ArrayList<>();
        }

        // 파티에 참석한 참가자 번호
        List<Integer>[] partyInParticipants = new ArrayList[M+1];
        for (int i = 1; i <= M; i++) {
            partyInParticipants[i] = new ArrayList<>();
        }


        // 파티에 참여하는 사람들 저장
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int participantCnt = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= participantCnt; j++) {
                int participant = Integer.parseInt(st.nextToken());

                parties[participant].add(i);
                partyInParticipants[i].add(participant);
            }

        }

        for (int i = 1; i <= N; i++) {
            if (isKnown[i]) {
                dfs(parties, partyInParticipants, i);
            }
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            boolean canLie = true;
            for (int person : partyInParticipants[i]) {
                if (isKnown[person]) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) result++;
        }

        System.out.println(result);

    }

    static void dfs (List<Integer>[] parties, List<Integer>[] partyInParticipants, int person) {


        // 진실을 아는 사람이 참가한 파티에 접근
        for (int partyIdx : parties[person]) {
            if (!partyVisited[partyIdx]) {
                partyVisited[partyIdx] = true;

                for (int nextPerson : partyInParticipants[partyIdx]) {
                    if (!isKnown[nextPerson]) {
                        isKnown[nextPerson] = true;
                        dfs(parties, partyInParticipants, nextPerson);
                    }
                }
            }
        }
    }

}
