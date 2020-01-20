package bankAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TTGIntAccountQuest3 {

	private static final int VALUE = 0;

	public List<Map<String, Integer>> girisDegerleri(List<String> satirSira) {
		List<Map<String, Integer>> islemSonucMap = new ArrayList<>();
		String ilkSatir = satirSira.remove(0).trim();
		int sayac = Integer.parseInt(ilkSatir);

		int i = 0;
		while (i < sayac) {
			Map<String, Integer> testislemSonuctMap = new TreeMap<>();
			int girisDegeri = Integer.parseInt(satirSira.remove(0).trim());
			for (int j = 0; j < girisDegeri; j++) {
				String key = satirSira.remove(0);
				Integer temp = testislemSonuctMap.getOrDefault(key, VALUE);
				testislemSonuctMap.put(key, temp + 1);
			}
			if (!satirSira.isEmpty() && satirSira.get(0).equals("")) {
				satirSira.remove(0);
			}
			islemSonucMap.add(testislemSonuctMap);
			i++;
		}

		return islemSonucMap;
	}

	public void sonuc(List<Map<String, Integer>> sonucMap) {
		int i = 0;
		while (i < sonucMap.size()) {
			Map<String, Integer> tempMap = sonucMap.get(i);
			Set<Map.Entry<String, Integer>> girisDegerler = tempMap.entrySet();

			girisDegerler.forEach(girisDeger -> {
				System.out.print(girisDeger.getKey());
				System.out.print(" ");
				System.out.println(girisDeger.getValue());

			});
			if (i != sonucMap.size() - 1) {
				System.out.print("\n");
			}
			i++;
		}
	}

	public List<String> dosyaOku() {
		String fileName = "inputtext.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}
