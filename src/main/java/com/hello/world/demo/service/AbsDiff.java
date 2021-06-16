package com.hello.world.demo.service;
import java.util.Arrays;
import java.util.List;

public class AbsDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> list1 = Arrays.asList(
				Arrays.asList(1,2, 3), Arrays.asList());
		
		List<List<Integer>> list2 = Arrays.asList(
				Arrays.asList(4,5,6), Arrays.asList(1,2,3));
		
		int minMoves = minimumMoves(list1, list2);
		System.out.println(minMoves);
		

	}

	private static int minimumMoves(List<List<Integer>> list1, List<List<Integer>> list2) {
		
		int absDiff = 0;
		
		int i=0;
		while(i< list1.size()) {
			
			List<Integer> firstList = list1.get(i);
			
			List<Integer> SecondList = list2.get(i);
			
			int size = firstList.size() > SecondList.size() ? firstList.size() : SecondList.size();
			
			for(int j=0; j<size; j++) {
				
				absDiff += j>= firstList.size() ? Math.abs(SecondList.get(j) - 0)
						: j>= SecondList.size() ? Math.abs(firstList.get(j) - 0) :
						Math.abs(firstList.get(j) - SecondList.get(j));
			}
			
			i++;
		}
	
		return absDiff;
	}

}
