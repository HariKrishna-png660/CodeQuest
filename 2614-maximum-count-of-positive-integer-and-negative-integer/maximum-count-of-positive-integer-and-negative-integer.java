class Solution {
    // TIME COMPLEXITY IS O(N)
    // public int maximumCount(int[] nums) {
    //     int n=nums.length;
    //     int neg=0;
    //     int zero=0;
    //     for(int i=0;i<n;i++) {
    //         if(nums[i]<0) {
    //             neg++;
    //         }
    //         else if(nums[i]==0) {
    //             zero++;
    //         }
    //         else {
    //             break;
    //         }
    //     }
    //     return Math.max(neg,n-zero-neg);
    // }
    // TIME COMPLEXITY IS O(LOG N)
//  public int maximumCount(int[] nums) {
//     int n = nums.length;
//     int si = 0, ei = n - 1, firstPos = n;
//     while (si <= ei) {
//         int mid = (si + ei) / 2;
//         if (nums[mid] > 0) {
//             firstPos = mid;
//             ei = mid - 1;
//         } else {
//             si = mid + 1;
//         }
//     }

   
//     si = 0; ei = n - 1;
//     int firstZero = n;
//     while (si <= ei) {
//         int mid = (si + ei) / 2;
//         if (nums[mid] >= 0) {
//             firstZero = mid;
//             ei = mid - 1;
//         } else {
//             si = mid + 1;
//         }
//     }

//     int negCount = firstZero;             
//     int posCount = n - firstPos;         
//     return Math.max(negCount, posCount);
//       }
    public int maximumCount(int[] nums) {
        // find the first position of the positive integer
        // find the first position of the zero
        // number of postive numbers will be n-firstPos
        // number of negative numbers will be firstZero
        int n=nums.length;
        // finding the firstPosition of the positive number
        int si=0;
        int ei=n-1;
        int firstPos=n;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(nums[mid]>0) {
                firstPos=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }

        // finding the firstPosition of the zero
        si=0;
        ei=n-1;
        int firstZero=n;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(nums[mid]>=0) {
                firstZero=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        int pos=n-firstPos;
        int neg=firstZero;
        return Math.max(pos,neg);
    }
   }
