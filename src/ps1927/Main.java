package ps1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1927
 * 최소 힙
 * */
public class Main {
	static int n;
	static int[] heap; // 힙 자료구조 구현에 사용할 배열.
	static int size; // 데이터가 삽입된 힙의 크기.
	static int MAX_SIZE = 400000; // 입력이 최대 10만개까지 가능하므로, 배열의 사이즈를 여유있게 잡음.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		heap = new int[MAX_SIZE];
		
		while(n > 0) {
			int val = Integer.parseInt(br.readLine());
			
			if(val > 0) {
				insertHeap(val);
			}
			
			else {
				if(size <= 0)
					System.out.println(0);
				else
					System.out.println(deleteHeap());
			}
			
			n--;
		}
		
	}
	
	// 힙에 데이터 삽입.
	public static void insertHeap(int v) {
		// 힙의 가장 끝 노드의 자식 노드 생성 및 새로운 값 삽입.
		heap[++size] = v;
		// 현재 힙의 크기.
		int curHeapSize = size;
		
		// 새로 추가된 값이 부모 노드의 값보다 작을 경우.
		while(heap[curHeapSize] < heap[curHeapSize / 2]) {
			// 부모 노드의 위치와 바꿔준다.
			int tmp = heap[curHeapSize];
			heap[curHeapSize] = heap[curHeapSize / 2];
			heap[curHeapSize / 2] = tmp;
			
			// 바꾼 후 비교 대상을 현재 노드 위치(바꾼 뒤 위치)로 변경.
			curHeapSize /= 2;
			
		}
	}
	
	// 힙 데이터 삭제.
	public static int deleteHeap() {
		// 힙에 데이터가 존재하지 않으면 0 반환 
		if(size == 0)
			return 0;
		
		// 삭제할 데이터(루트에 있는 데이터)
		int root = heap[1];
		// 가장 마지막에 있는 값을 루트로 가져온다 
		heap[1] = heap[size];
		// 가장 끝에 있던 값은 0으로 초기화 및 힙 사이즈 1 감소 
		heap[size--] = 0;
		
		// 현재 탐색중인 노드의 위치 
		int curNode = 1;
		
		// 현재 탐색중인 노드의 자식 노드(왼쪽)이 힙의 크기보다 작을 경우 
		while(curNode * 2 <= size) {
			// 왼쪽 자식 노드 
			int left = heap[curNode * 2];
			// 오른쪽 자식 노드 
			int right = heap[curNode * 2 + 1];
			
			// 자식 노드 중 최솟값, 초기값으로 왼쪽 자식 노드 값 세팅 
			int min = left;
			// 자식 노드 중 최솟값의 위치, 초기값으로 왼쪽 자식 노드의 위치 세팅 
			int minPos = curNode * 2;
			
			// 오른쪽 자식 노드가 존재하고, 왼쪽 자식 노드 값보다 작다면
			// min, minPos 값을 오른쪽 자식 노드의 값으로 갱신 
			if(right != 0 && left > right) {
				min = right;
				minPos = curNode * 2 + 1;
			}
			
			// 현재 탐색 중인 노드 값이, 자식 노드 중 최솟값보다 작다면 
			// 더이상 위치 조정을 할 필요가 없으므로 반복문 종료 
			if(min > heap[curNode]) {
				break;
			}
			
			// 현재 탐색 중인 노드 값이, 자식 노드 중 최솟값보다 크다면 
			// 현재 위치의 노드 값과 자식 노드 중 최솟값을 바꿔준다.
			int tmp = heap[curNode];
			heap[curNode] = heap[minPos];
			heap[minPos] = tmp;
			
			// 현재 노드의 위치를 자식 노드의 최솟값 위치로 변경하여 위치 조정 작업 다시 수행 
			curNode = minPos;
		}
		
		// 삭제 작업 수행 전 초기 루트 값 반환 
		return root;
	}
}
