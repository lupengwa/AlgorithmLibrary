public class MediaFinderV2 {
    public Double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex = (nums1.length + nums2.length)/2;
        boolean isOdd = (nums1.length + nums2.length)%2 == 1;
        int medianCandidate1 = 0;
        int medianCandidate2 = 0;
        int left1 = 0;
        int right1 = nums1.length - 1;
        int median1 = (left1 + right1)/2;
        int left2 = 0;
        int right2 = nums2.length - 1;
        int median2 = (left2 + right2)/2;
        int currentIndex = 0;
        while(currentIndex < medianIndex) {
            if (nums1[median1] < nums2[median2]) {
                //eliminate the unnecessary half
                if(median1-1+currentIndex <= medianIndex) {
                    left1 = median1;
                    currentIndex += median1-1;
                    if(median1-1+currentIndex == medianIndex) {
                        medianCandidate1 = nums1[median1];
                        if(isOdd) {
                            medianCandidate2 = medianCandidate1;
                        }
                        else {

                        }
                    }
                }
                else {

                }
            }
            else if (nums1[median1] == nums2[median2]) {

            }
            else {

            }
        }
        return 0.1;
    }


}
