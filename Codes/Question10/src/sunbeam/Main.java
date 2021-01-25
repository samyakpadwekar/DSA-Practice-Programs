package sunbeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

class HashTable{
	static class Pair{
		private int key;
		private Movie value;
		public Pair() {
			key = 0;
			value = null;
		}
		public Pair(int key, Movie movie) {
			this.key = key;
			this.value = movie;
		}
		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value.getMovieName() + "]";
		} 
	}
	private final int SLOTS = 100;
	 private LinkedList<Pair>[] table;
	 
	 public int has( int key) {
		 return key % SLOTS;
	 }
	 public HashTable() {
		 table = new LinkedList[SLOTS];
		 for(int i = 0; i < SLOTS; i++)
			 table[i] = new LinkedList<HashTable.Pair>();
	 }
	 
	 public void put(int key, Movie movie) {
		 int slot = has(key);
		 LinkedList<Pair> buffer = table[slot];
		 for (Pair pair : buffer) {
			if(key == pair.key) {
				pair.value = movie;
				return;
			}
		}
		 Pair pair = new Pair(key, movie);
		 buffer.add(pair);
	 }
	 public Movie get(int key) {
		 int slot = has(key);
		 LinkedList<Pair> buffer = table[slot];
		 for (Pair pair : buffer) {
			if(key == pair.key)
				return pair.value;
		}
		 return null;
	 }
}

public class Main {

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		Scanner sc = new Scanner(System.in);
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("movies.csv")))){
		String line = null;
		String splitBy = "\\^";
		reader.readLine();
		while((line = reader.readLine()) != null) {
			String[] str = line.split(splitBy);
			int movieId = Integer.parseInt(str[0]);
			String movieName = str[1];
			String movieGenre = str[2];
			ht.put(movieId, new Movie(movieId, movieName, movieGenre));
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Enter Movie Id to search movie : ");
		int movieId = sc.nextInt();
		System.out.println(ht.get(movieId).toString());

	}

}
