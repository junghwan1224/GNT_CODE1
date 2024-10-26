package ps18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://www.acmicpc.net/problem/18428
 * 감시 피하기
 * */
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int N;
    static char[][] arr;
    static int cnt;
    static ArrayList<Node> teachers;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        // 선생님 위치 저장
        teachers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 'T')
                    teachers.add(new Node(i, j));
            }
        }

        // true: 모든 감시로부터 피할 수 있음
        // false: 피할 수 없음
        flag = false;
        dfs();

        System.out.println(flag ? "YES" : "NO");
    }

    // 장애물 3개 배치
    public static void dfs() {
        if(cnt == 3) {
            // 모든 감시로부터 피할 수 있는 경우를 이미 찾았다면 더 확인할 필요가 없으므로, 그렇지 않은 경우만 확인한다.
            if(! flag) {
                // 학생이 보이는 교사의 수
                int isMonitoringPossible = 0;

                for (Node node : teachers) {
                    if (isExistStudent(node.y, node.x)) {
                        // 학생이 보이는 교사가 있으면 카운트 + 1
                        isMonitoringPossible++;
                    }
                }

                // 학생이 보이는 교사가 아예 없다면, 모든 감시로부터 피할 수 있으므로 flag 값 변경
                if (isMonitoringPossible == 0) {
                    flag = true;
                    return;
                }
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    cnt++;
                    dfs();
                    cnt--;
                    arr[i][j] = 'X';
                }
            }
        }
    }

    public static boolean isExistStudent(int y, int x) {
        // 아래쪽 확인
        for (int i = y; i < N; i++) {
            if(arr[i][x] == 'S')
                return true;
            else if(arr[i][x] == 'O')
                break;
        }

        // 위쪽 확인
        for (int i = y - 1; i >= 0; i--) {
            if(arr[i][x] == 'S')
                return true;
            else if(arr[i][x] == 'O')
                break;
        }

        // 오른쪽 확인
        for (int i = x; i < N; i++) {
            if(arr[y][i] == 'S')
                return true;
            else if(arr[y][i] == 'O')
                break;
        }

        // 왼쪽 확인
        for (int i = x - 1; i >= 0; i--) {
            if(arr[y][i] == 'S')
                return true;
            else if(arr[y][i] == 'O')
                break;
        }

        return false;
    }
}
