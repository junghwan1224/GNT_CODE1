package ps2590;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2590
 * 색종이
 * */
public class Main {
	static int[] arr;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[6];
		
		for(int i = 0; i < 6; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		// 크기가 6인 색종이를 붙이면 꽉 차므로, 해당 색종이 수 만큼 판이 필요하다 
		result += arr[5];
		
		while(arr[4] > 0) {
			int size = 36;
			size -= 25;
			arr[4]--;
			
			// 크기가 5인 색종이를 붙이면 남은 공간에는 크기가 1인 색종이만 붙일 수 있다 
			// 크기가 1인 색종이가 남은 공간보다 적게 있다면 모두 붙일 수 있으므로 색종이 갯수는 0으로 초기화 
			if(arr[0] <= size)
				arr[0] = 0;
			// 남은 공간보다 많이 남았다면, 공간의 칸 수 만큼 빼준다 
			else
				arr[0] -= size;
			result++;
		}
		
		while(arr[3] > 0) {
			int size = 36;
			size -= 16;
			arr[3]--;
			
			// 크기가 4인 색종이를 붙이면, 우선 크기가 2인 색종이를 최대 5개까지 붙일 수 있다 
			if(arr[1] <= 5) {
				size -= (4 * arr[1]);
				arr[1] = 0;
			}
			else {
				size -= 20;
				arr[1] -= 5;
			}
			
			// 크기가 2인 색종이를 붙이고나서 공간이 남으면, 크기가 1인 색종이를 붙인다. 
			if(arr[0] <= size)
				arr[0] = 0;
			else
				arr[0] -= size;
			
			result++;
		}
		
		while(arr[2] > 0) {
			int size = 36;
			
			// 크기가 3인 색종이는 최대 4장까지 붙일 수 있으므로, 4장을 넘어가면 판의 갯수를 하나 늘려주고 색종이 갯수는 4만큼 빼준다 
			if(arr[2] >= 4) {
				size = 0;
				arr[2] -= 4;
			}
			else {
				size -= (9 * arr[2]);
				arr[2] = 0;
			}
			
			// 판에 남은 칸이 27개 => 크기가 3인 색종이를 1개만 붙였을 때, 크기가 2인 색종이는 최대 5개 까지 붙일 수 있다. 
			if (size == 27 && arr[1]>5) {
                arr[1] -= 5;
                size -= 20;
            }
            else if (size == 27 && arr[1] <= 5){
                size -= 4 * arr[1];
                arr[1] = 0;
            }
			
			// 크기가 3인 색종이를 2개 붙였을 때, 크기가 2인 색종이는 최대 3개까지 붙일 수 있다. 
            if (size == 18 && arr[1]>3) {
                arr[1] -= 3;
                size -= 12;
            }
            else if (size == 18 && arr[1] <= 3) {
                size -= 4 * arr[1];
                arr[1] = 0;
            }
            
            // 크기가 3인 색종이를 3개 붙였을 때, 크기가 2인 색종이는 최대 1개까지 붙일 수 있다. 
            if (size == 9 && arr[1] >= 1) {
                size -= 4 * arr[1];
                arr[1] = 0;
            }
            
            if (arr[0] <= size)
                arr[0] = 0;
            else
                arr[0] -= size;
			
			result++;
		}
		
		while (arr[1]>0) {
            int size = 36;
            if (arr[1]>9) {
                arr[1] -= 9;
                size = 0;
            }
            else {
                size -= 4 * arr[1];
                arr[1] = 0;
            }
            
            if (arr[0] <= size)
                arr[0] = 0;
            else
                arr[0] -= size;
            
            result++;
        }
		
        while (arr[0]>0) {
            if (arr[0]>36)
                arr[0] -= 36;
            else
                arr[0] = 0;
            
            result++;
        }
        
        System.out.println(result);
	}

}
