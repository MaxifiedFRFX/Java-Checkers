// Samuel Rivera and David Perez

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.runner.manipulation.Filter;

/**
 * A class containing various methods for processing integer arrays
 */
public class ArrayUtils {
    /**
     * Returns the largest value in array {@code a}.
     * 
     * @param a the array to examine
     * @return the largest value in array {@code a}
     * @throws IllegalArgumentException if the array is empty or {@code null}
     */
    public static int maximum(int[] a) {
    	int largestValue = a[0];
    	
    	if (a == null || a.length == 0) {
			throw new IllegalArgumentException();
		} else {
		for (int i = 0; i < a.length; i++) {  
			if (a[i] > largestValue) {
				largestValue = a[i];
			}
		}
		return largestValue;
		}
    }

    /**
     * Returns true if the elements of array {@code a} are arranged in ascending
     * order. If any element appears after an element greater than itself, the
     * method returns false. An empty array by default is considered to be in
     * ascending order.
     * 
     * The method returns false if the array is {@code null}.
     * 
     * This method does not disturb the contents of either array.
     * 
     * The method uses no extra space except for a few local scalar variables.
     * 
     * @param a the array to examine
     * @return true if the array is sorted; otherwise, false
     */
    public static boolean isAscending(int[] a) {
    	boolean check = true;
    	if (a == null) {
			check = false;
        } else {
        	for (int i = 0; i < a.length - 1; i++) {
        		if (a[i] > a[i + 1]) {
        			check = false;
        		}	
        	}
        }
        if (check == false) {
        	return false;
        } else {
        	return true;
        }
    }

    /**
     * Returns a new array that contains the elements of {@code a}, in exactly the
     * same order, except any element that also appears in array {@code delList}
     * will be excluded from the result. For example, if {@code list1} contains 1,
     * 2, 3, 4, 5, 6 and {@code list2} contains 2, 4, 7, the call
     * {@code ArrayUtils.filter(list1, list2)} would produce a new array containing
     * 1, 3, 5, 6.
     * 
     * Duplicate elements in {@code delList} do not affect the outcome of the
     * filter.
     * 
     * @param a       the array to filter
     * @param delList the containing the elements to exclude from the resulting
     *                array
     * @return a new array containing all the elements of {@code a}, in exactly the
     *         same order, excluding any element found in {@code delLists}; returns
     *         {@code null} if either or both arrays are {@code null}
     */
    public static int[] filter(int[] a, int[] delList) {
    	ArrayList<Integer> listCopy = new ArrayList<Integer>();
    	if (a == null || delList == null) {
    		return null;
		} else {
			for (int i = 0; i < a.length; ++i) {
				listCopy.add(a[i]);
			}
			for (int p = 0; p < listCopy.size(); ++p) {
				boolean check = true;
				for (int j = 0; j < delList.length; ++j) {
					if (check == true) {
						if (listCopy.get(p) == delList[j]) {
						listCopy.remove(p);
						p = p - 1;
						check = false;
						}
					}
				}
			}
			int[] copy = new int[listCopy.size()];
			for (int k = 0; k < listCopy.size(); k++) {
				copy[k] = listCopy.get(k).intValue();
			}

			return copy;
		}
    }

    /**
     * Physically rearranges the elements of {@code a} so that all the elements are
     * shifted towards the back by a distance of {@code distance}. As an element
     * "falls off" the rear, it is placed at the front in the space vacated when the
     * first element was shifted backwards. For example, if {@code list} contains
     * the elements 1, 2, 3, 4, 5, and 6, the call
     * {@code ArrayUtils.rotate(list, 2)} rearranges {@code list} to contain 5, 6,
     * 1, 2, 3, and 4. Notice that if {@code distance} is equal to the size of the
     * array, after the rotation all the elements rotate to their original
     * locations. If {@code distance} is negative, the elements are shifted forward
     * {@code n} spots instead of backwards. As an element "falls off" the front it
     * is placed on the rear in the space vacated when the last element was shifted
     * forwards.
     * 
     * The method uses no extra space except for a few local scalar variables.
     * 
     * @param a        the array to rotate
     * @param distance the number of positions to rotate toward the back of the
     *                 array
     * @throws IllegalArgumentException if the array is {@code null}
     */
    public static void rotateRight(int[] a, int distance) {
    	
        if (a == null) {
        	throw new IllegalArgumentException();
        } else if (a.length == 0) {
        } else if (distance > 0) {
        	distance = distance % a.length;
			for (int j = 0; j < distance; j++) {
				int temp2 = a[a.length - 1];
				int temp1 = a[0];
				for (int i = 0; i < a.length; i++) {
					if (i == a.length - 1) {
						if (i % 2 == 0) {
							a[i] = temp2;
						} else if (i % 2 == 1) {
							a[i] = temp1;
						}
					} else {
						if (i % 2 == 0) {
							a[i] = temp2;
							temp2 = a[i + 1];
						} else if (i % 2 == 1) {
							a[i] = temp1;
							temp1 = a[i + 1];

						}
					}
				}
			}
        } else if (distance < 0) {
        	distance = distance % a.length;
        	for (int j = -distance; j > 0; j--) {
        		int temp1;
        		int temp2;
        		if (a.length - 1 % 2 == 0) {
        			temp2 = a[0];
        			temp1 = a[a.length - 1];
				} else {
					temp2 = a[a.length - 1];
					temp1 = a[0];
				}
				for (int i = a.length - 1; i >= 0; i--) {
					if (i == 0) {
						if (i % 2 == 0) {
							a[i] = temp2;
						} else if (i % 2 == 1) {
							a[i] = temp1;
						}
					} else {
						if (i % 2 == 0) {
							a[i] = temp2;
							temp2 = a[i - 1];
						} else if (i % 2 == 1) {
							a[i] = temp1;
							temp1 = a[i - 1];

						}
					}
				}
        	} 
        } else {
        }
    }

    /**
     * Computes the rolling average of an array of integers based on a given
     * interval. The client specifies the range of values to average. The resulting
     * array is a double-precision floating-point array of the rolling averages. For
     * example, given array {@code arr} = {3, 2, 4, 6, 20, 1, 3}, the call
     * {@code rollingAverage(arr, 3)} would produce the array { 3.0, 4.0, 10.0, 9.0,
     * 8.0 }.
     * 
     * @param a        the original array of integer values. If {@code a} is empty
     *                 or {@code null}, the method throws an
     *                 {@code IllegalArgumentException}.
     * @param interval the range of elements in the original array to average when
     *                 computing the rolling average. If {@code interval} is greater
     *                 than the number of elements in {@code a} or is less than one,
     *                 the method throws an {@code IllegalArgumentException}.
     * @return a double-precision floating-point array containing the rolling
     *         average of the original array.
     * @throws IllegalArgumentException if the array is empty or {@code null} or if
     *                                  {@code interval} is less than 1 or greater
     *                                  than the number of elements in the array.
     */
    public static double[] rollingAverage(int[] a, int interval) {
    	ArrayList<Double> RollingAverageList = new ArrayList<Double>();
    	double numbersSum = 0;
    	if (a == null || a.length == 0 || interval > a.length || interval < 1) {
    		throw new IllegalArgumentException();
		} else {
			for (int i = 0; i <= a.length - interval; i++) {
				numbersSum = 0;
				for (int j = 0; j < interval; j++) {
					numbersSum += a[i + j];
				}
				RollingAverageList.add((double) (numbersSum / interval));
			}
			double[] RollingAverageArray = new double[RollingAverageList.size()];
			for (int i = 0; i < RollingAverageList.size(); i++) {
				RollingAverageArray[i] = RollingAverageList.get(i);
			}
			return RollingAverageArray;
		}
    }

}