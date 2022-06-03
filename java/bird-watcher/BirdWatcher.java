/**
 * BirdWatcher
 * https://exercism.org/tracks/java/exercises/bird-watcher
 */
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int lastDayIdx;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.lastDayIdx = birdsPerDay.length - 1;
    }

    public int[] getLastWeek() {
        return birdsPerDay.clone();
    }

    public int getToday() {
        if (lastDayIdx < 0) {
            return 0;
        }
    
        return birdsPerDay[lastDayIdx];
    }

    public void incrementTodaysCount() {
        birdsPerDay[lastDayIdx]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int currentDay = 0; currentDay < birdsPerDay.length; currentDay++) {
            if (birdsPerDay[currentDay] == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int birdCount = 0;
        int firstDaysCount = Math.min(numberOfDays, birdsPerDay.length);
        for (int currentDay = 0; currentDay < firstDaysCount; currentDay++) {
            birdCount += birdsPerDay[currentDay];
        }

        return birdCount;
    }

    public int getBusyDays() {
        int busyDaysCount = 0;
        for (int currentDay = 0; currentDay < birdsPerDay.length; currentDay++) {
            if (birdsPerDay[currentDay] > 4) {
                busyDaysCount++;
            }
        }

        return busyDaysCount;
    }
}
