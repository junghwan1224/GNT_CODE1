package ps2608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.acmicpc.net/problem/2608
 * 로마 숫자
 * */
public class Main {
	static char[] a;
	static char[] b;
	static Map<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		
		map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int conA = convertToArabic(a);
		int conB = convertToArabic(b);
		
		//System.out.println(convertToRoman(conA + conB));
		//System.out.println(convertToRoman(130));
		
		for(int i =1; i <= 2000; i++) {
			String s = convertToRoman(i);
			if(i != convertToArabic(s.toCharArray()))
				System.out.println(i + ": " + convertToArabic(s.toCharArray()));
		}
	}

	// 로마 숫자를 아라비아 숫자로 변환 
	public static int convertToArabic(char[] chr) {
		int result = 0;
		for(int i = 0; i < chr.length; i++) {
			// 문자에 해당하는 수를 더함 
			result += map.get(chr[i]);
			// 이전 문자(왼쪽)가 현재 문자(오른쪽) 보다 작으면 두 번 빼준다 
			if(i > 0 && map.get(chr[i - 1]) < map.get(chr[i])) {
				result -= (map.get(chr[i - 1]) * 2);
			}
		}
		return result;
	} 
	
	// 아라비아 숫자를 로마 숫자로 변환 
	public static String convertToRoman(int num) {
		String result = "";
		
		// 천의 자릿수 로마 숫자 변환 
		// 결과값은 4천보다 작으므로 천의 자릿수는 별다른 예외가 없으므로 자릿수 값 만큼 M(1000) 붙여준다  
		int d4 = num / 1000;
		for(int i = 0; i < d4; i++)
			result += "M";
		num %= 1000;
		
//		/* 백의 자리 */
//	    int d3 = num / 100; /* 백의 자리수 */
//	    num %= 100;
//	    if (d3 == 4 || d3 == 9) { /* CD, CM 예외 처리 */
//	        result += "C";
//	        if (d3 == 4) { result += "D"; }
//	        if (d3 == 9) { result += "M"; }
//	    } else {
//	        if (d3 >= 5) { result += "D"; d3 -= 5; } /* D 처리 */
//	        for (int i=0; i<d3; i++) { /* 남은 d3 만큼 'C' 추가 */
//	            result += "C";
//	        }
//	    }
//
//	    /* 십의 자리 */
//	    int d2 = num / 10; /* 십의 자리수 */
//	    num %= 10;
//	    if (d2 == 4 || d2 == 9) { /* XL, XC 예외 처리 */
//	        result += "X";
//	        if (d2 == 4) { result += "L"; }
//	        if (d2 == 9) { result += "C"; }
//	    } else {
//	        if (d2 >= 5) { result += "L"; d2 -= 5; } /* L 처리 */
//	        for (int i=0; i<d2; i++) { /* 남은 d2 만큼 'X' 추가 */
//	            result += "X";
//	        }
//	    }
//
//	    /* 일의 자리 */
//	    int d1 = num; /* 일의 자리수 */
//	    if (d1 == 4 || d1 == 9) { /* IV, IX 예외 처리 */
//	        result += "I";
//	        if (d1 == 4) { result += "V"; }
//	        if (d1 == 9) { result += "X"; }
//	    } else {
//	        if (d1 >= 5) { result += "V"; d1 -= 5; } /* V 처리 */
//	        for (int i=0; i<d1; i++) { /* 남은 d1 만큼 'I' 추가 */
//	            result += "I";
//	        }
//	    }

		
		// 백의 자릿수 로마 숫자 변환 
		int d3 = num / 100;
		// 4일 때는 예외 케이스(CD) 적용 
		if(d3 == 4)
			result += "CD";
		// 9일 때도 예외 적용 
		else if(d3 == 9)
			result += "CM";
		// 백의 자릿수가 5 이상일 땐, D(500)을 더한 후, 부족한만큼 C(100)을 붙여준다  
		else if(d3 >= 5) {
			result += "D";
			for(int i = 0; i < d3 - 5; i++)
				result += "C";
		}
		// 나머지 경우에는 C(100) 붙여준다 
		else {
			for(int i = 0; i < d3; i++)
				result += "C";
		}
		num %= 100;
		
		// 10의 자릿수 로마 숫자 변환 
		int d2 = num / 10;
		// 4일 때 예외 적용 
		if(d2 == 4)
			result += "XL";
		// 9일 때 예외 적용 
		else if(d2 == 9)
			result += "XC";
		// 5 이상일 땐, L(50)을 더한 후, 부족한만큼 X(10)을 붙여준다 
		else if(d2 >= 5) {
			result += "L";
			for(int i = 0; i < d2 - 5; i++)
				result += "X";
		}
		// 나머지 경우엔 X(10) 붙여준다 
		else {
			for(int i = 0; i < d2; i++)
				result += "X";
		}
		
		int d1 = num % 10;
		if(d1 == 4)
			result += "IV";
		else if(d1 == 9)
			result += "IX";
		else if(d1 >= 5) {
			result += "V";
			for(int i = 0; i < d1 - 5; i++)
				result += "I";
		}
		else {
			for(int i = 0; i < d1; i++)
				result += "I";
		}
		
		return result;
	}
}
