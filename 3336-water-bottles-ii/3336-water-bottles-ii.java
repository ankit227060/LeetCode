class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = numBottles;  // Start by drinking all full bottles
        int empty = numBottles;

        while (empty >= numExchange) {
            // Exchange numExchange empty bottles for 1 full bottle
            empty -= numExchange;
            totalDrunk++;     // Drink the new bottle
            empty++;          // The new bottle becomes an empty one
            numExchange++;    // Increase the exchange requirement
        }

        return totalDrunk;
    }
}
