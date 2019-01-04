import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class MediaFinderTest {


    @Test
    public void testEmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(2.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void testNonDuplicatedArray() {
        int[] nums1 = {4, 5, 6, 7};
        int[] nums2 = {1, 2, 3};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(4.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void testDuplicatedArray() {
        int[] nums1 = {3,4, 5, 6};
        int[] nums2 = {1, 2, 3, 4};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.5, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void testEdgeFailingArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2,};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.5, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void testEdgeFailingTwoArray() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2, 3};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(2.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }


}
