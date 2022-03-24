// Link: https://leetcode.com/problems/boats-to-save-people/

// Solution: Sort arr and 2 ptrs

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // pair heaviest person with lightest person
        // if we can carry both then we will, and we will check for second heaviest and
        // second lightest
        // otherwise, we take the heaviest person first and now we check for second
        // heaviest and lightest
        // each time we will take 1 boat so a counter for that is incremented on every
        // iteration

        // sorting the arr will arrange the people in terms of their weight
        // By this we can access the heaviest and lightest person faster and wouldn't
        // have to iterate everytime
        Arrays.sort(people); // O(nlogn), Here we can use COUNT SORT also to make O(n)
                             // but it takes Extra Space O(n)

        int i = 0, j = people.length - 1; // pointers pointing to lightest and heaviest person

        int numOfBoats = 0;// counter for no. of boats used

        // i<=j because we don't want to forget the person in the last
        while (i <= j) {
            // if both people can be carried in the board
            if (people[i] + people[j] <= limit) {
                // take them and now check for next lighest and next heaviest
                i++;
                j--;
            } else {
                // take only heavy person and check for next heaviest NOT LEAVING THE LIGHTER
                // PERSON
                j--;
            }

            numOfBoats++;// each time we use a board be it for 1 or 2 people so incrementation is done at
                         // each iteration
        }

        return numOfBoats;// return the num of boats calculated
    }
}
