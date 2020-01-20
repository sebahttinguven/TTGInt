package com.guven.rotate;

import java.util.ArrayList;
import java.util.List;

public class TTGIntRotate {

	
	public void rotate(int[] list1, int index) {

		for (int i = 0; i < index; i++) {
			int j, first;

			first = list1[0];
			for (j = 0; j < list1.length - 1; j++) {

				list1[j] = list1[j + 1];
			}
			list1[j] = first;
		}

		System.out.print("Result=");
		for (int i = 0; i < list1.length; i++) {
			System.out.print(+list1[i] + " ");
		}
	}
}
