

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest {
    @Test
    void test() {
        int[] arr = {1, 2};
        int maximum = 2;
        assertEquals(maximum, ArrayUtils.maximum(arr));
    }

    @Test
    void testmax1() {
        int[] arr = {94832, 793279, 2};
        int maximum = 793279;
        assertEquals(maximum, ArrayUtils.maximum(arr));
    }
    @Test
    void testnegative() {
        int[] arr = {-100, -100, 100, 100, 200, 200, 100, 100};
        int maximum = 200;
        assertEquals(maximum, ArrayUtils.maximum(arr));
    }
    @Test
    void testempty() {
        int[] arr = null;
        int maximum = 0;
        assertEquals(maximum, ArrayUtils.maximum(arr));
    }
    @Test
    void testAscending() {
        int[] arr = {0, 1, 2, 3, 3, 3, 3, 3};
        boolean Answer = true;
        assertEquals(Answer, ArrayUtils.isAscending(arr));
    }
    @Test
    void testDescending() {
        int[] arr = {0, 1, 2, 3, 3, 0, 3, 1};
        boolean Answer = false;
        assertEquals(Answer, ArrayUtils.isAscending(arr));
    }
    @Test
    void testEmpty() {
        int[] arr = {};
        boolean Answer = true;
        assertEquals(Answer, ArrayUtils.isAscending(arr));
    }
    @Test
    void testNull() {
        int[] arr = {0, 1, 2, 3, 3, 0, 3, 1};
        boolean Answer = false;
        assertEquals(Answer, ArrayUtils.isAscending(null));
    }
	@Test
	void testFilterRemove0() {
        int[] arr = {0, 1, 2, 3, 3, 0, 3, 1};
        int[] arr2 = {0};
        int[] Answer = {1, 2, 3, 3, 3, 1};
        assertArrayEquals(Answer, ArrayUtils.filter(arr, arr2));
    }
	@Test
	void testFilterRemoveNothing() {
        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {0};
        int[] Answer = {1, 2, 3, 1};
        assertArrayEquals(Answer, ArrayUtils.filter(arr, arr2));
    }
	@Test
	void testFilterRemove3and5and7() {
        int[] arr = {3, 5, 5, 10, 7, 7, 3, 9, 5, 10};
        int[] arr2 = {3, 5, 7};
        int[] Answer = {10, 9, 10};
        assertArrayEquals(Answer, ArrayUtils.filter(arr, arr2));
	}
	@Test
	void testFilterEmpty() {
        int[] arr = {};
        int[] arr2 = {3};
        int[] Answer = {};
        assertArrayEquals(Answer, ArrayUtils.filter(arr, arr2));
	}
	@Test
	void testFilterNull() {
        int[] arr = {3, 324, 234, 23432};
        int[] arr2 = null;
        int[] Answer = null;
        assertArrayEquals(Answer, ArrayUtils.filter(arr, arr2));
	}
	@Test
	void testRotateRight() {
		int[] arr = {20, 30, 100};
		int dist = 2;
		int[] Answer = {30, 100, 20};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	} 
	@Test
	void testRotateLeft() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int dist = -2;
		int[] Answer = {3, 4, 5, 6, 1, 2};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	}
	@Test
	void testRotateLeft242() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int dist = -243;
		int[] Answer = {4, 5, 6, 1, 2, 3};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	} 
	@Test
	void testRotate0() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9 , 10};
		int dist = 10;
		int[] Answer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	}
	@Test
	void testRotateRight243() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int dist = 243;
		int[] Answer = {4, 5, 6, 1, 2, 3};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	}
	@Test
	void testRotateNull() {
		int[] arr = null;
		int dist = 39;
		int[] Answer = null;
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	}
	@Test
	void testRotateEmpty() {
		int[] arr = {};
		int dist = 29;
		int[] Answer = {};
		
		ArrayUtils.rotateRight(arr, dist);
		assertArrayEquals(Answer, arr);
	}
	@Test
	void testRollingAverageInt3() {
		int[] arr = {3, 2, 4, 6, 20, 1, 3};
		int Interval = 3;
		double[] Answer = {3.0, 4.0, 10.0, 9.0, 8.0};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval));
	}
	@Test
	void testRollingAverageInt1() {
		int[] arr = {3, 2, 4, 6, 20, 1, 3};
		int Interval = 1;
		double[] Answer = {3.0, 2.0, 4.0, 6.0, 20.0, 1.0, 3.0};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval));
	}
	@Test
	void testRollingAverageInt7() {
		int[] arr = {3, 2, 4, 6, 20, 1, 3};
		int Interval = 7;
		double[] Answer = {5.57142857142857};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval), 0.00000001);
	}
	@Test
	void testRollingAverageNull() {
		int[] arr = null;
		int Interval = 7;
		double[] Answer = null;
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval));
	}
	@Test
	void testRollingAverageEmpty() {
		int[] arr = {};
		int Interval = 10;
		double[] Answer = {};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval));
	}
	@Test
	void testRollingAverageTooBig() {
		int[] arr = {10, 20, 30};
		int Interval = 10;
		double[] Answer = {};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval));
	}
	@Test
	void testRollingAverageInt2() {
		int[] arr = {20, 30, 40, 50, 10, 1, 58};
		int Interval = 2;
		double[] Answer = {25,35,45,30,5.5,29.5};
		assertArrayEquals(Answer, ArrayUtils.rollingAverage(arr, Interval), 0.1);
	}
}
