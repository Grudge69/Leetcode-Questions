// Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

// Solution: Array Sorting

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierNum = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }
            // we have added i because in case of same no. of soldiers the lower value of i
            // will be considered weaker
            soldierNum[i] = soldiers * 100 + i;
            // to separate index i from this value we make the no. of soldiers into groups
            // of 100 or any number and then just modulo by that to remove the soldiers
            // value as it is in groups of 100
        }

        Arrays.sort(soldierNum);// sort to get weakest -> strongest soldiers

        int[] ans = new int[k];// stores our ans

        for (int i = 0; i < k; i++) {
            ans[i] = soldierNum[i] % 100;// removing soldiers num and getting i from it
        }

        return ans;
    }
}

// Array Sorting with Binary Search

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierNum = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = binarySearch(mat[i]);
            // we have added i because in case of same no. of soldiers the lower value of i
            // will be considered weaker
            soldierNum[i] = soldiers * 100 + i;
            // to separate index i from this value we make the no. of soldiers into groups
            // of 100 or any number and then just modulo by that to remove the soldiers
            // value as it is in groups of 100
        }

        Arrays.sort(soldierNum);// sort to get weakest -> strongest soldiers

        int[] ans = new int[k];// stores our ans

        for (int i = 0; i < k; i++) {
            ans[i] = soldierNum[i] % 100;// removing soldiers num and getting i from it
        }

        return ans;
    }

    private int binarySearch(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}

// USING PRIORITY QUEUE (with & without binary search)

/*
 * 
 * PQ -> int[] --> 0 -> numOfSoldier, 1 -> indexOfRow
 * maxHeap --> eliminate the maxValues
 * a,b ---> a[0], b[0] in desc
 * //if both the number of soldiers are equal then we check based on their
 * indices, smaller index is weaker
 * a[0] == b[0] --> a[1] b[1] in desc
 */

// using Priority Queue
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] res = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }
            pq.offer(new int[] { soldiers, i });
        }

        while (pq.size() > k) {
            pq.poll();
        }

        while (k > 0)
            res[--k] = pq.poll()[1];

        return res;
    }
}

// Using Binary Seearch
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { numOnes(mat[i]), i });
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}