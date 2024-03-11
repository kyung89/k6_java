package Chap3_검색;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;
public class Test_스트링배열합병 {
    static void showList(String topic, String [] list) {
    	System.out.println(topic);
    	System.out.println();
    	for (String l :list) System.out.print(l + "\t");
    	System.out.println();
    	System.out.println();
    }
    static String[] mergeList(String[]s1, String[] s2) {
    	int i = 0, j = 0,k =0;
    	String[] s3 = new String[10];
    	
    	for (k = 0; k < 10; k++) {
    		
    		if(i == 5) break;
    		if(j == 5) break;
    		
    		if(s1[i].compareTo(s2[j]) < 0) s3[k] = s1[i++];
    		else s3[k] = s2[j++];
    	}
    	
    	if(i < 5)
    		for(int remain = k, i_remain = i; remain < 10; remain++, i_remain++) s3[remain] = s1[i_remain]; 
    	if(j < 5)
    		for(int remain = k, j_remain = j; remain < 10; remain++, j_remain++) s3[remain] = s2[j_remain];
    	
    	return s3;
    }
    public static void main(String[] args) {
		String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
		String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		showList("s1배열 = ", s1);
		showList("s2배열 = ", s2);
	
		String[] s3 = mergeList(s1,s2);
		showList("스트링 배열 s3 = s1 + s2:: ", s3);
	}
	}
