class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            totalDrunk += newBottles;
            empty = empty % numExchange + newBottles;
        }

        return totalDrunk;
    }
}
