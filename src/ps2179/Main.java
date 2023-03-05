package ps2179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2179
 * */
class Node implements Comparable<Node> {
    String word;
    int idx;

    public Node(String word, int idx) {
        this.word = word;
        this.idx = idx;
    }

    public int compareTo(Node node1) {
        return this.word.compareTo(node1.word);
    }
}

public class Main {
    static int n;
    static String[] words;
    static Node[] sortedWords;
    static int maxLen;
    static String[] result;
    static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        words = new String[n];
        sortedWords = new Node[n];
        result = new String[2];
        length = new int[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            sortedWords[i] = new Node(words[i], i);
        }

        // 단어순으로 정렬
        Arrays.sort(sortedWords);

        for (int i = 0; i < n - 1; i++) {
            // 정렬했을 때 인접한 두 단어가 같으면 넘어간다
            if(sortedWords[i].word == sortedWords[i + 1].word)
                continue;
            // 두 문자의 접두사 길이 구하기
            int l = getSameCnt(sortedWords[i].word, sortedWords[i + 1].word);
            // 접두사 길이 최댓값 갱신
            maxLen = Math.max(maxLen, l);
            // 정렬 전 입력받은 단어의 위치에 접두가 길이값 갱신 및 저장
            length[sortedWords[i].idx] = Math.max(length[sortedWords[i].idx], l);
            length[sortedWords[i + 1].idx] = Math.max(length[sortedWords[i + 1].idx], l);
        }

        result[0] = null;
        result[1] = null;
        for (int i = 0; i < n; i++) {
            // 단어 순서대로 탐색하면서, 해당 단어의 길이가 접두사의 최대 길이값이면 첫 번째 단어 저장
            if(length[i] == maxLen && result[0] == null) {
                result[0] = words[i];
            }

            // 첫 번째 단어가 저장되어있고, 접두사 길이가 최댓값과 같으면,
            else if(result[0] != null && length[i] == maxLen) {
                // 저장된 첫 번째 단어의 접두사와 현재 탐색중인 단어의 접두사가 같으면 두 번째 단어 저장 후 반복문 종료
                if(result[0].substring(0, maxLen).equals(words[i].substring(0, maxLen))) {
                    result[1] = words[i];
                    break;
                }
            }
        }

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // 접두사 길이 구하기
    public static int getSameCnt(String s1, String s2) {
        int cnt = 0;
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if(s1.charAt(i) == s2.charAt(i))
                cnt++;
            else
                break;
        }
        return cnt;
    }
}
