package sunbeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		int count = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("File.txt")));){
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				for (String token : tokens) {
					if(hm.get(token) != null) {
					count = hm.get(token) + 1;
					hm.put(token, count);
					}
					else
						hm.put(token, 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Word   No. of repetition");
		for(String string : hm.keySet()) {
			String key = string;
			int value = hm.get(key);
			System.out.println(key+"   = "+value);
		}

	}

}
