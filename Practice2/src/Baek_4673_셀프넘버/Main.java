package Baek_4673_셀프넘버;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<Integer> list;
	static boolean[] isTrue;
	public static void main(String[] args) {
		list = new ArrayList<>();
		isTrue = new boolean[100001];
		
		d(2);
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
//		
//		for (int i = 1; i <= 10000; i++) {
//			if(!isTrue[i]) System.out.println(i);
//		}
	}
	public static void d(int sum) {
		if(sum < 10000) return;
		
		isTrue[sum] = true;
		
		String n = String.valueOf(sum);
			
		for (int i = 0; i < n.length(); i++) {
			sum += Integer.parseInt(n.substring(i,i+1));
		}
		System.out.println(sum);
		list.add(sum);
		d(sum);
	}
}
