package leetcode;

public class MedianOfTwoSortedArrays {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length , n2 = nums2.length , n = n1+n2;
            if(n1>n2) return findMedianSortedArrays(nums2,nums1);
            int left = (n+1)/2 , low = 0 , high = n1;
            while(low <= high){
                int mid1 = (low+high)/2;
                int mid2 = left-mid1;

                int l1 = Integer.MIN_VALUE , l2 = Integer.MIN_VALUE , r1 = Integer.MAX_VALUE , r2 = Integer.MAX_VALUE;
                if(mid1-1>=0){
                    l1 = nums1[mid1-1];
                }
                if(mid2-1>=0){
                    l2 = nums2[mid2-1];
                }
                if(mid1<n1){
                    r1 = nums1[mid1];
                }
                if(mid2<n2){
                    r2 = nums2[mid2];
                }

                //now time to check the condition validity
                if(l1<=r2 && l2<=r1){
                    //odd
                    if(n%2==1) return Math.max(l1,l2);
                    else return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else if(l1>r2){
                    high = mid1-1;
                }
                else{
                    low = mid1+1;
                }

            }
            return 0;
        }
    }

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
//        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
//        System.out.println(findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,2,4,4}));
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{6,7,8,9,10,11,12,13,14,15,16,17}));
//        System.out.println(findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,2,4,4}));
//        System.out.println(findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,2,4,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedNums =  mergeSortedArrays(nums1, nums2);

        double result;

        if(totalLength % 2 == 0) {
            int index1 = totalLength / 2;
            int index2 = totalLength / 2 - 1;
            result = (double) (mergedNums[index1] + mergedNums[index2]) / 2;
        } else {
            result = mergedNums[totalLength / 2];
        }

        return result;
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // one position ahead of their current position.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n) {
            result[k++] = arr1[i++];
        }

        while (j < m) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}

//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
