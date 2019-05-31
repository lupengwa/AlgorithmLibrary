public class MedianFinder {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {       //if either one of the list is empty, meidan is the median of unempty list
            Integer median1 = null;
            if(nums1.length > 0) {
                median1 = nums1[nums1.length/2];
            }
            Integer median2 = null;
            if(nums2.length > 0) {
                median2 = nums2[nums2.length/2];
            }
            Boolean isOdd = (nums1.length+nums2.length) %2 == 1;
            int numRemain = (nums1.length+nums2.length) %2 == 1?(nums1.length+nums2.length)/2:(nums1.length+nums2.length)/2-1;
            if(median1 != null && median2 != null && median1 < median2) {
                return findMedian(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, numRemain, isOdd);
            }
            else {
                return findMedian(nums2, nums1, 0, nums2.length-1, 0, nums1.length-1, numRemain, isOdd);
            }
        }
        private double findMedian(int[] nums1, int[] nums2, int left1, int right1, int left2, int right2, int numRemain, Boolean isOdd) {
            if(left1 > right1) {
                return isOdd?nums2[left2+numRemain]:(nums2[left2+numRemain]+nums2[left2+numRemain+1])/2.0;
            }
            if(left2 > right2) {
                return isOdd?nums1[left1+numRemain]:(nums1[left1+numRemain]+nums1[left1+numRemain+1])/2.0;
            }

            // this handles the situation that we found all the numbers on left side of medians
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
                        double min = (nums1[left1]+nums2[left2])/2.0;
                        if(left1+1 < nums1.length ) {
                            min = Math.min(min, (nums1[left1]+nums1[left1+1])/2.0);
                        }
                        if(left2+1 < nums2.length) {
                            min = Math.min(min, (nums2[left2]+nums2[left2+1])/2.0);
                        }
                        return min;
                    }
                    else if(left1 <= right1) {
                        return (nums1[left1]+nums1[left1+1])/2.0;
                    }
                    else if(left2 <= right2) {
                        return (nums2[left2]+nums2[left2+1])/2.0;
                    }
                }
            }

            //task here is to reduce numRemain to 0


            //if the smaller half has nothing to cut
            if((left1 + right1)/2 == left1) {
                int index = findIndexOfLastElementSmallerThanTarget(nums2, left2, right2, nums1[left1]);
                //if right side has nothing to cut too
                if(index == -1) {
                    if(left1+1 <= right1 && nums1[left1+1] < nums2[(left2+right2)/2]) {
                        return findMedian(nums1, nums2, left1+1, right1, left2, right2, numRemain-1, isOdd);
                    }
                    return findMedian(nums2, nums1,left2, right2, left1+1, right1, numRemain-1, isOdd);
                }
                else {
                    if(numRemain >= (index-left2+1)) {
                        if(nums1[(left1+right1)/2] < nums2[(index+1+right2)/2]) {
                            return findMedian(nums1,nums2, left1, right1, index+1, right2,numRemain-(index-left2+1),  isOdd);
                        }
                        return findMedian(nums2,nums1, index+1, right2, left1, right1,numRemain-(index-left2+1),  isOdd);
                    }
                    return findMedian(nums1, nums2, left1, right1, left2+numRemain, right2, 0, isOdd);
                }
            }
            else {

                if(numRemain < (right1-left1)/2 + (right2-left2)/2) {
                    if(nums1[left1] < nums2[left2]) {
                        if(left1+1 <= right1 && nums1[(left1+1+right1)/2] < nums2[(left2+right2)/2]) {
                            return findMedian(nums1, nums2, left1 + 1, right1, left2, right2, numRemain-1, isOdd);
                        }
                        else {
                            return findMedian(nums2, nums1, left2, right2, left1+1, right1, numRemain-1, isOdd);
                        }
                    }
                    else {
                        return findMedian(nums2, nums1, left2+1, right2, left1, right1, numRemain-1, isOdd);
                    }
                }
                if(nums1[((left1+right1)/2 + right1)/2] < nums2[(left2+right2)/2]) {
                  return findMedian(nums1, nums2, (left1+right1)/2,right1, left2, right2, numRemain-(right1-left1)/2, isOdd);
                }
                return findMedian(nums2, nums1, left2, right2, (left1+right1)/2, right1, numRemain-(right1-left1)/2, isOdd);
            }
        }
        public int findIndexOfLastElementSmallerThanTarget(int[] nums, int left, int right, int target) {
            if(left > right) {
                return -1;
            }
            if(left == right) {
                return nums[left] < target?left:-1;
            }
            if(left == right-1) {
                if(nums[right] < target) {
                    return right;
                }
                if(nums[left] < target) {
                    return left;
                }
                return -1;
            }
            if(nums[(left+right)/2] < target) {
                return findIndexOfLastElementSmallerThanTarget(nums, (left+right)/2, right, target);
            }
            return findIndexOfLastElementSmallerThanTarget(nums, left, (left+right)/2-1, target);
        }


}
