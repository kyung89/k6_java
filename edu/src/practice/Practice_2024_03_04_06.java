package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// p.56
// 큰 정수 더하기 연산
// • 20자리 이상의 큰 정수는 long형 데이터를 넘어서기 때문에 바로 연산을 할 수 없다. 한
//   가지 방법으로 모든 자리 수의 데이터를 byte형 배열로 분리해서 더하는 방법을 사용할
//   수 있다. 아래 예와 같은 방법으로 두수(12345, 6789)를 텍스트 파일(input.txt)로 부터 읽
//   어서 결과를 텍스트 파일(output.txt)에 출력하는 메서드를 작성하세요
// • 연산예
// • 12345 + 6789 ➔ { 5, 4, 3, 2, 1 } + { 9, 8, 7, 6 }
// • ➔{ 14, 12, 10, 8, 1} ➔ 4, 3, 1, 9, 1 ➔ 19134

// 로직 업그레이드 할 것 

public class Practice_2024_03_04_06 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		
		char[] num1 = new StringBuffer(reader.readLine()).reverse().toString().toCharArray();
		char[] num2 = new StringBuffer(reader.readLine()).reverse().toString().toCharArray();

		reader.close();
		
		// 입력한 숫자 출력
//		for(char n : num1) System.out.print(n + "\t"); 
//		System.out.println();
//		for(char n : num2) System.out.print(n + "\t");
//		System.out.println();
		
		int maxLength = num1.length > num2.length ? num1.length : num2.length;
		int[] result = new int[maxLength];
		
		for(int i = 0; i < maxLength; i++) {
			int sum = 0;
			if(i > num1.length - 1) sum = Character.getNumericValue(num2[i]);
			else if(i > num2.length - 1) sum = Character.getNumericValue(num1[i]);
			else sum = Character.getNumericValue(num1[i]) + Character.getNumericValue(num2[i]);
			
			result[maxLength - 1 - i] = sum;
		}
		
//		for(int n : result) System.out.print(n + "\t");
		
//		1 8
//		  1 0
//		     1 2
//		       1 4
//		1 9 1 3 4
//
//
//		1 0 0 0 0
//		  8 0 0 0
//		  1 0 0 0
//		     1 2 0
//		        1 4
		
		int result_sum = 0;
		for(int i = 0; i < result.length; i++) {
			result_sum += result[i] * Math.pow(10, result.length - i - 1);
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		writer.write(result_sum+"");   
		writer.flush();   
		writer.close();
	}
}
