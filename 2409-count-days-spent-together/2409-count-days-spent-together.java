class Solution {
    private int[] days;
    private int[] daysCount;

    public Solution() {
        days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysCount = new int[13];

        int sum = 0;
        for (int i = 1; i <= 12; i++) {
            sum += days[i];
            daysCount[i] = sum;
        }
    }

    private int getDaysCount(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        return daysCount[month - 1] + day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int meetStart = Math.max(getDaysCount(arriveAlice), getDaysCount(arriveBob));
        int meetEnd = Math.min(getDaysCount(leaveAlice), getDaysCount(leaveBob));

        int days = meetEnd - meetStart + 1;

        return days > 0 ? days : 0;
    }
}