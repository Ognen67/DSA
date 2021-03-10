package com.github.ognen67.exercises.lists;

public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[n + m];

        int j = 0;
        int k = 0;

        for (int i = 0; i < merged.length; i++) {

            if(j<m && k<n) {
                if(nums1[j] < nums2[k]) {
                    merged[i] = nums1[j++];
                }
                else {
                    merged[i] = nums2[k++];
                }
            }
            else {
                if(j<m) {
                    merged[i] = nums1[j++];
                }
                else if (k<n) {
                    merged[i] = nums2[k++];
                }
            }
        }

        if(merged.length %2 == 0) {
            return (double)(merged[(merged.length/2)-1] + merged[(merged.length/2+1)-1])/2;
        }

        else {
            return (double)merged[(merged.length/2+1)-1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 4, 5};
        int[] nums2 = new int[]{2, 3, 7, 8};

        MedianSortedArrays m = new MedianSortedArrays();

        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
