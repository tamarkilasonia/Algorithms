package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {

    public static void activitySelection(Activity[] activities) {
        // Sort activities by finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        // The first activity always gets selected
        System.out.println("Selected activities: ");
        int lastSelected = 0;
        System.out.println("Activity " + (lastSelected + 1) + " (" + activities[lastSelected].start + ", " + activities[lastSelected].finish + ")");

        // Consider the rest of the activities
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= activities[lastSelected].finish) {
                System.out.println("Activity " + (i + 1) + " (" + activities[i].start + ", " + activities[i].finish + ")");
                lastSelected = i;
            }
        }
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(4, 6),
                new Activity(7, 8),
                new Activity(5, 7)
        };

        activitySelection(activities);
    }
}
