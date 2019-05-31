public class MediaFinderV2 {
    /*
    Find Median is to find find number(s) that separate nums1 and nums2 as total into two parts
    left part is always small then right part, and left part's length == right part's length
    nums1: length n; left part for nums1: [0,i-1], length i
    nums2: length m; index j, left part for nums2: [0,j-1], length j
    median number's index must satisfy
    i+j = m+n-i-j even or i+j = m+n-i-j+1 odd => i = (m+n+1)/2-j or (m+n)/2-j
    nums1[i-1] <= nums2[j]
    nums2[j-1] <= nums1[i]


     */
    public Double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.1;
    }


}
