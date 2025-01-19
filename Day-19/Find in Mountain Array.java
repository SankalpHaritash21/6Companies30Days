/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeak(mountainArr, length);

        int result = findTarget(mountainArr, 0, peakIndex, target, true);
        if (result != -1) {
            return result;
        }

        return findTarget(mountainArr, peakIndex + 1, length - 1, target, false);
    }

    private int findTarget(MountainArray mountainArr, int left, int right, int target, boolean isUpside) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (isUpside) {
                if (target > midVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    private int findPeak(MountainArray mountainArr, int length) {
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }    
}