package ps17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/17413
 * 단어 뒤집기 2
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String result = "";
		int n = str.length();
		Stack<String> stack = new Stack<String>();
		
		int idx = 0;
		int tagLength = 0; // 태그 길이 
		boolean isTag = false; // 현재 탐색중인 문자열이 태그인지 체크 
		while(idx < n) {
			// 태그 시작 
			if(str.charAt(idx) == '<') {
				isTag = true; // 태그 시작 문자열이므로 true 체크 
				tagLength++; // 태그 길이 1 증가 
				
				// 태그가 시작되면 이전에 스택에 쌓인 문자열들은 거꾸로 바꿔서 출력해야 하므로 스택 비우는 작업 시작 
				while(! stack.empty()) {
					result += stack.peek();
					stack.pop();
				}
			}
			
			// 태그 끝 
			else if(str.charAt(idx) == '>') {
				// 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열.
				// 태그가 맞으면 결과값에 태그 내용 그대로 추가 
				if(++tagLength >= 3) {
					result += str.substring(idx - tagLength + 1, idx + 1);
				}
				// 이제 태그가 끝났으므로 false로 바꿈 
				isTag = false;
				// 태그 길이 초기화 
				tagLength = 0;
			}
			
			// 공백 문자일 경우 
			else if(str.charAt(idx) == ' ') {
				// 현재 탐색중인 문자열이 태그가 아니면, 이전까지 스택에 쌓인 문자열을 결과값에 추가
				if(! isTag) {
					while(! stack.empty()) {
						result += stack.peek();
						stack.pop();
					}
					// 스택 비운 후에 공백 문자도 결과값에 추가 
					result += str.substring(idx, idx + 1);
				}
				// 현재 탐색중인 문자열이 태그이면, 태그 길이만 1 더해줌 
				else
					tagLength++;
			}
			
			// 일반 문자열일 때 
			else {
				// 태그이면 태그 길이만 1 더해줌 
				if(isTag)
					tagLength++;
				// 태그가 아니면 스택에 저장 
				else {
					stack.add(str.substring(idx, idx + 1));
				}
			}
			
			idx++;
		}
		
		// 루프가 끝난 후 스택에 남은 문자열이 있으면 결과값에 추가 
		while(! stack.empty()) {
			result += stack.peek();
			stack.pop();
		}
		
		System.out.println(result);
	}

}
