package ps14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14891
 * */
class Node {
    char[] gear;

    public Node(char[] gear) {
        this.gear = gear;
    }
}

public class Main {
    public static Node[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new Node[4];
        for (int i = 0; i < 4; i++) {
            list[i] = new Node(br.readLine().toCharArray());
        }

        int k = Integer.parseInt(br.readLine());
        while(k > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int rvDir = (dir == 1) ? -1 : 1;
            if(num == 0) {
                if(list[1].gear[6] != list[num].gear[2]) {
                    if(list[2].gear[6] != list[1].gear[2]) {
                        if(list[3].gear[6] != list[2].gear[2]) {
                            turn(num, dir);
                            turn(1, rvDir);
                            turn(2, dir);
                            turn(3, rvDir);
                        }
                        else {
                            turn(num, dir);
                            turn(1, rvDir);
                            turn(2, dir);
                        }
                    }
                    else {
                        turn(num, dir);
                        turn(1, rvDir);
                    }
                }
                else {
                    turn(num, dir);
                }
            }
            else if(num == 1) {
                if(list[0].gear[2] != list[1].gear[6]) {
                    turn(0, rvDir);
                }

                if(list[2].gear[6] != list[1].gear[2]) {
                    if(list[3].gear[6] != list[2].gear[2]) {
                        turn(num, dir);
                        turn(2, rvDir);
                        turn(3, dir);
                    }
                    else {
                        turn(num, dir);
                        turn(2, rvDir);
                    }
                }
                else {
                    turn(num, dir);
                }
            }
            else if(num == 2) {
                if(list[3].gear[6] != list[2].gear[2]) {
                    turn(3, rvDir);
                }

                if(list[2].gear[6] != list[1].gear[2]) {
                    if(list[1].gear[6] != list[0].gear[2]) {
                        turn(2, dir);
                        turn(1, rvDir);
                        turn(0, dir);
                    }
                    else {
                        turn(2, dir);
                        turn(1, rvDir);
                    }
                }
                else {
                    turn(2, dir);
                }
            }
            else if(num == 3) {
                if(list[3].gear[6] != list[2].gear[2]) {
                    if(list[2].gear[6] != list[1].gear[2]) {
                        if(list[1].gear[6] != list[0].gear[2]) {
                            turn(3, dir);
                            turn(2, rvDir);
                            turn(1, dir);
                            turn(0, rvDir);
                        }
                        else {
                            turn(3, dir);
                            turn(2, rvDir);
                            turn(1, dir);
                        }
                    }
                    else {
                        turn(3, dir);
                        turn(2, rvDir);
                    }
                }
                else {
                    turn(3, dir);
                }
            }

            k--;
        }

        int result = 0;
        result += (list[0].gear[0] == '1' ? 1 : 0);
        result += (list[1].gear[0] == '1' ? 2 : 0);
        result += (list[2].gear[0] == '1' ? 4 : 0);
        result += (list[3].gear[0] == '1' ? 8 : 0);

        System.out.println(result);
    }

    public static void turn(int num, int dir) {
        if(dir == 1) {
            char tmp = list[num].gear[7];
            for (int i = 7; i > 0; i--) {
                list[num].gear[i] = list[num].gear[i - 1];
            }
            list[num].gear[0] = tmp;
        }
        else {
            char tmp = list[num].gear[0];
            for (int i = 1; i < 8; i++) {
                list[num].gear[i - 1] = list[num].gear[i];
            }
            list[num].gear[7] = tmp;
        }
    }
}
