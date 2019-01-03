public class MedianFinder {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return findMedian(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length+nums2.length) %2 == 1?(nums1.length+nums2.length)/2:(nums1.length+nums2.length)/2-1, (nums1.length+nums2.length) %2 == 1);
    }

/*
    nums1 and nums2 can't be both empty

 */
    private double findMedian(int[] nums1, int[] nums2, int left1, int right1, int left2, int right2, int numRemain, Boolean isOdd) {
        //if either one of the list is empty, meidan is the median of unempty list
        if(left1 > right1) {
            return isOdd?nums2[left2+numRemain]:(nums2[left2+numRemain]+nums2[left2+numRemain+1])/2.0;
        }
        if(left2 > right2) {
            return isOdd?nums1[left1+numRemain]:(nums1[left1+numRemain]+nums1[left1+numRemain+1])/2.0;
        }
        if(numRemain == 0) {
            if(isOdd) {
                if( left1 <= right1 && left2 <= right2) {
                    return nums1[left1] < nums2[left2]?nums1[left1]:nums2[left2];
                }
                else if(left1 <= right1) {
                    return nums1[left1];
                }
                else if(left2 <= right2) {
                    return nums2[left2];
                }
            }
            else {
                if( left1 <= right1 && left2 <= right2) {
                    return (nums1[left1]+nums2[left2])/2.0;
                }
                else if(left1 <= right1) {
                    return (nums1[left1]+nums1[left1+1])/2.0;
                }
                else if(left2 <= right2) {
                    return (nums2[left2]+nums2[left2+1])/2.0;
                }
            }
        }

        if(nums1[(left1+right1)/2] < nums2[(left2+right2)/2]) {
            if(left1 == right1) {
                return findMedian(nums1, nums2, left1+1, right1, left2, right2, numRemain-1, isOdd);
            }
            else {
                return findMedian(nums1, nums2, (left1+right1)/2, right1, left2, right2, numRemain-(right1-left1)/2, isOdd);
            }
        }
        else {
            if(left2 == right2) {
                return findMedian(nums1, nums2, left1, right1, left2+1, right2, numRemain-1, isOdd);
            }
            else {
                return findMedian(nums1, nums2, left1, right1, (left2+right2)/2, right2, numRemain-(right2-left2)/2, isOdd);
            }
        }
    }

}
