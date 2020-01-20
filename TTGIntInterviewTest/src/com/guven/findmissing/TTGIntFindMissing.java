package com.guven.findmissing;

import java.util.ArrayList;
import java.util.List;

public class TTGIntFindMissing {

	public void findMissing() {

		List<Integer> list1 = new ArrayList<>();
		list1.add(4);
		list1.add(12);
		list1.add(9);
		list1.add(5);
		list1.add(6);
		list1.add(1);

		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(9);
		list2.add(12);
		list2.add(6);

		List<Integer> listTemp = new ArrayList<>();

		for (int temp : list1) {
			if (!list2.contains(temp)) {
				listTemp.add(temp);

			}

		}

		System.out.println("Result=" + listTemp);
	}

}
