package Chap3_검색;

//중복이 없는 리스트를 merge하는 버젼

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test_중복없는리스트합병 {
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장

	static ArrayList<String> removeDuplicate(ArrayList<String> al) {
		//구현할 부분 : 리스트에서 중복을 제거한다, 정렬후 호출하는 것을 전제로 구현

		Set<String> set = new HashSet<>(al);
		return new ArrayList<String>(set);
	}
	
	static void trimSpace(String[]arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].trim();
		}
	}
	static void makeList(String[] sarray1, List<String>list1) {
		for(String sa : sarray1) {
			list1.add(sa);
		}
	}
	
	static List<String> mergeList(List<String> list1, List<String> list2) {
		ArrayList<String> list3 = new ArrayList<>();
		
		list3.addAll(list1);
		list3.addAll(list2);
		
		return list3;
	}
	static void showData(String title, String[] srr) {
		
		System.out.println("[" + title + "]");
		System.out.println();
		for (String s : srr) System.out.print(s + "\t");
		System.out.println();
		System.out.println();
	}
	static void showList(String title, List<String> srr) {
		
		System.out.println("[" + title + "]");
		System.out.println();
		for (String s : srr) System.out.print(s + "\t");
		System.out.println();
		System.out.println();
	}
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("a1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);

			Path input2 = Paths.get("a2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);
			
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);
			System.out.println("입력 스트링: s1 = \n\n" + s1 + "\n");
			System.out.println("입력 스트링: s2 = \n\n" + s2 + "\n");
			String[] sarray1 = s1.split("[,\\s]+\r\n");// 자바 regex \n으로 검색
			String[] sarray2 = s2.split("[,\\s]+\r\n");//file에서 enter키는 \r\n으로 해야 분리됨
			showData("스트링 배열 sarray1", sarray1);
			showData("스트링 배열 sarray2", sarray2);

			trimSpace(sarray1);
			trimSpace(sarray2);

			showData("trimSpace() 실행후 :스트링 배열 sarray1", sarray1);
			showData("trimSpace() 실행후 :스트링 배열 sarray2", sarray2);
			System.out.println("+++++++\n");
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:
			ArrayList<String> list1 = new ArrayList<>();
			makeList(sarray1, list1);
			showList("리스트1: ", list1);
			// 방법2
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));
			showList("리스트2: ", list2);
			
			System.out.println("+++++++ collection.sort()::");
			Collections.sort(list1);
			showList("정렬후 리스트1: ", list1);

			//Arrays.sort(list2, null);//에러 발생 확인하고 이유는?
			Collections.sort(list2);
			showList("정렬후 리스트2: ", list2);	
	
			//정렬된 list에서 중복 제거 코드
			list1 = removeDuplicate(list1);
			list2 = removeDuplicate(list2);
			showList("중복 제거후 리스트1: ", list1);	
			showList("중복 제거후 리스트2: ", list2);	
	
	
			List<String> list3 = new ArrayList<>();
			
			// 방법3:
			list3 = mergeList(list1, list2);
			showList("merge후 합병리스트: ", list3);	

			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			System.out.println("\n" + "file에 출력:");
			int bufferSize = 10240;
			
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			writeFile(list3, buffer);
			
			FileOutputStream file = new FileOutputStream("c.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void writeFile(List<String> list3, ByteBuffer buffer) {
		String b = " ";
		for (String sx : list3) {
			System.out.println(" " + sx);
			buffer.put(sx.getBytes());
			buffer.put(b.getBytes());
		}
		buffer.flip();
	}
}
