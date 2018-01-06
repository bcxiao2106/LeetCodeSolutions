import java.util.Arrays;

public class Heapsort {
	private static int compcount = 0;

	public static int[] heapSort(int[] array) {
		int n = array.length - 1;
		buildMaxHeap(array, 0, n);
		for (int i = n; i > 0; i--) {
			swap(array, 0, i);
			pushDown(array, 0, i - 1);
		}
		return array;
	}

	public static int[] buildMaxHeap(int[] array, int r, int n) {
		if (2 * r + 1 > n) {
			return array;
		} // is return array right?
		buildMaxHeap(array, 2 * r + 1, n);
		buildMaxHeap(array, 2 * r + 2, n);
		pushDown(array, r, n);
		return array;
	}

	private static void pushDown(int[] array, int r, int n) {
		int s;
		if (2 * r + 1 > n) {
			return;
		}
		if (2 * r + 1 == n ||compare(array[2 * r + 1],array[2 * r + 2])) {
			s = 2 * r + 1;
		} else {
			s = 2 * r + 2;
		}
		if (!compare(array[r],array[s])) {//TODO so actually here the compare is used in two different places
			swap(array, r, s);
			pushDown(array, s, n);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static boolean compare(int a, int b) {
		compcount++;
		if (a >= b) {
			return true;
		} else {
			return false;
		}

	}

	public static int getcount() {
		return compcount;
	}

	public static void clearcount() {
		compcount = 0;
	}

	public static void main(String args[]) {
		int[] array = new int[] { 2, 10, 9, 5, 5, 2, 3, 6, 4, 5, 3 };
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}
}
