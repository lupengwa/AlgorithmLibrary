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

    @Test
    public void testEdgeEqualFailingTwoArray() {
        int[] nums1 = {3, 3, 3, 3};
        int[] nums2 = {3, 3, 3, 3};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void testStackOverFlowFailingTwoArray() {
        int[] nums1 = {2};
        int[] nums2 = {1, 3, 4, 5, 6};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.5, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void IndexOutOfBoundaryForNumRemainLessThanHalf() {
        int[] nums1 = {7};
        int[] nums2 = {1,2, 3, 4, 5, 6, 8, 9};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(5.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void WrongAnswer() {
        int[] nums1 = {1,2,4,5};
        int[] nums2 = {3};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.0, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void WrongAnswerTwo() {
        int[] nums1 = {3,4};
        int[] nums2 = {1,2,5,6};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(3.5, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }

    @Test
    public void WrongAnswerThree() {
        int[] nums1 = {2,5};
        int[] nums2 = {1,3,4,6,7,8};
        MedianFinder medianFinder = new MedianFinder();
        assertEquals(4.5, medianFinder.findMedianSortedArrays(nums1,nums2),0.001);
    }


}
