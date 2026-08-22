class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;                        // total number of refills
        int alice = capacityA, bob = capacityB; // current water for Alice and Bob
        int i = 0;                            // pointer for Alice (left side)
        int j = plants.length - 1;            // pointer for Bob (right side)

        // Process until both pointers meet
        while (i <= j) {
            // Case when Alice and Bob meet at the same plant
            if (i == j) {
                int max = Math.max(alice, bob); // whichever has more water
                if (max < plants[i]) {          // if neither can water it
                    count++;                    // one refill is needed
                }
                i++; // move pointer forward to end loop
            } else {
                // Alice waters from the left
                if (plants[i] <= alice) {
                    alice -= plants[i];         // enough water, just reduce
                } else {
                    count++;                    // refill needed
                    alice = capacityA;          // refill Alice's can
                    alice -= plants[i];         // water the plant
                }
                i++; // move Alice forward

                // Bob waters from the right
                if (plants[j] <= bob) {
                    bob -= plants[j];           // enough water, just reduce
                } else {
                    count++;                    // refill needed
                    bob = capacityB;            // refill Bob's can
                    bob -= plants[j];           // water the plant
                }
                j--; // move Bob backward
            }
        }
        return count; // total refills
    }
}