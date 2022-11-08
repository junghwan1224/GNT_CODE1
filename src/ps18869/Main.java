package ps18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/18869
 * 멀티버스 Ⅱ
 * */

class Point {
	int idx;
	int val;
	
	public Point(int idx, int val) {
		this.idx = idx; // 인덱스 
		this.val = val; // 값 
	}
}

class AscendingObj implements Comparator<Point> {
	 
    @Override
    public int compare(Point p1, Point p2) {
        return p1.val - p2.val;
    }
 
}


public class Main {
	static int M;
	static int N;
	static int[][] planet;
	static ArrayList<Point>[] list;
//	static ArrayList<String> valList;
//	static ArrayList<String> indexList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		planet = new int[M][N];
		list = new ArrayList[M];
		
		for(int i = 0; i < M; i++)
			list[i] = new ArrayList<Point>();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// key: 행성 크기, value: 인덱스 
			Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
			
			for(int j = 0; j < N; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
//				list[i].add(new Point(j, planet[i][j]));
				
				if(idxMap.containsKey(planet[i][j]))
					list[i].add(new Point(idxMap.get(planet[i][j]), planet[i][j]));
				else {
					list[i].add(new Point(j, planet[i][j]));
					idxMap.put(planet[i][j], j);
				}
			}
		}
		
		// 인덱스, 값이 저장된 리스트를 값을 기준으로 오름차순 정렬 
		AscendingObj asc = new AscendingObj();
		for(int i = 0; i < M; i++)
			Collections.sort(list[i], asc);
		
//		valList = new ArrayList<String>();
		String[] valArr = new String[M];
		for(int i = 0; i < M; i++) {
			String str = "";
			for(int j = 0; j < N; j++)
				str += Integer.toString(list[i].get(j).val);
//			valList.add(str);
			valArr[i] = str;
		}
		// String[] valArr = valList.toArray(new String[valList.size()]);
		
//		indexList = new ArrayList<String>();
		String[] idxArr = new String[M];
		for(int i = 0; i < M; i++) {
			String str = "";
			for(int j = 0; j < N; j++)
				str += Integer.toString(list[i].get(j).idx);
//			indexList.add(str);
			idxArr[i] = str;
		}
		// String[] idxArr = indexList.toArray(new String[indexList.size()]);
		
		// 우주 내 같은 원소에 대해서 인덱스 변환 처리
		// 예) 1 1 1 이면 인덱스가 0, 1, 2가 아니라 0, 0, 0으로 되게끔 처리
//		for (int i = 0; i < M; i++)
//		{
//			for (int j = 0; j < N - 1; j++)
//			{
//				if (list[i].get(j).val == list[i].get(j + 1).val)
//				{
//					list[i].get(j + 1).idx = list[i].get(j).idx;
//				}
//			}
//		}

		int cnt = 0;
		for(int i = 0; i < M; i++) {
			for(int j = i + 1; j < M; j++) {
				/*
				 * 정렬하면 인덱스 순서는 똑같으니 1로 나온다.
				 * 인덱스로만 비교해서 그런듯 
				 * 2 3
				 * 1 1 1
				 * 1 2 2
				 * 1
				 * */
				
				// 비교 중인 리스트가 같으면 더 안보고 넘어감 
//				if(isSame(list[i], list[j])) {
//					continue;
//				}
				if(valArr[i].equals(valArr[j]))
					continue;
				
				// 정렬 후 인덱스 비교하여 같으면 멀티버스에 해당되므로 결과값 + 1
//				boolean flag = true;
//				for(int k = 0; k < N; k++) {
//					
//					if(list[i].get(k).idx != list[j].get(k).idx) {
//						flag = false;
//						break;
//					}
//				}
//				
//				if(flag)
//					cnt++;
				
				if(idxArr[i].equals(idxArr[j]))
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static boolean isSame(ArrayList<Point> a, ArrayList<Point> b) {
		
		for(int i = 0; i < N; i++)
			if(a.get(i).val != b.get(i).val)
				return false;
		return true;
	}
}
