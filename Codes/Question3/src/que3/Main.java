package que3;

import java.util.Comparator;
class intSort<T extends Comparable<T>> implements Comparator<T>{
	@Override
	public int compare(T o1, T o2) {
		return o1.compareTo(o2);
	}
}
public class Main {
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		boolean needNextPass = true;
		for (int k = 1; k < list.length && needNextPass; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0) {
					// Swap list[i] with list[i + 1]
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true; 
				}
			}
		}
	}

	public static <E> void insertionSort(E[] list, Comparator<? super E> comparator)
	{
		for(int i=1;i<list.length;i++)
		{
			int j;
			E temp=list[i];
			for(j=i-1;j>=0 && comparator.compare(list[j],temp) > 0;j--)
			{
				list[j+1]=list[j];
			}
			list[j+1]=temp;
		}
	}

	
	public static void main(String[] args) {
		Integer[] listArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};
		Character[] charArray = {'p', 'j', 'r'};
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		bubbleSort(listArray,new intSort<>());
		bubbleSort(doubleArray,new intSort<>());
		insertionSort(charArray,new intSort<>());
		insertionSort(stringArray,new intSort<>());
		
		printList(listArray);
		printList(charArray);
		printList(stringArray);
		printList(doubleArray);
		
	}

	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}


}
