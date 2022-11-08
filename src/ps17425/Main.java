package ps17425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * https://www.acmicpc.net/problem/17425
 * 약수의 합
 * */
public class Main {
	static int T;
	static Set<Integer> set;
	static int MAX = 1000001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			
			for(int i = 1; i <= n; i++) {
				set = new HashSet<Integer>();
				long s = getYaksuSum(i);
				result += s;
				//System.out.println(i + " result => " + s);
			}
			
			//result = getYaksuSum(n);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	public static long getYaksuSum(int num) {
		long sum = 0;
		
		int sqrtNum = (int)Math.sqrt(num);
		//System.out.println("sqrtNum => " + sqrtNum);
		for(int i = 1; i <= sqrtNum; i++) {
			//System.out.println(i + " " + num % i);
			if(num % i != 0)
				continue;
			sum += (long)i;
			set.add(i);
		}
		
		for(Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			//System.out.println("i => " + i);
			int i = iter.next();
			//System.out.println("i => " + i);
			if(! set.contains(num / i))
				sum += (long)(num / i);
		}
		
		return sum;
	}
}
