import java.util.ArrayList;
import java.util.List;

public class TTGInternational {

	public static void main(String[] args) {

		findMissing();

		rotate(new int[] { 1, 2, 3, 4, 5, 6 }, 1);
	}

	public static void findMissing() {

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

	public static void rotate(int[] list1, int index) {

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
