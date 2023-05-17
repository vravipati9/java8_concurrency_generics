package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class TimeSlot {
    static Random random = new Random(System.nanoTime());
    public String schedule() {
        return "booking details..."+random.hashCode();
    }
    public boolean isAvailable() {
        return random.nextBoolean();
    }
}
public class ImperitiveVsDeclarative {
    public static List<TimeSlot> createTimeSlots() {
        return Arrays.asList(new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot());
    }

    public static void main(String... args) {
        List<TimeSlot> timeSlots = createTimeSlots();
/*
        // Imperative style
        String bookingDetails = null;
        for (TimeSlot timeslot: timeSlots) {
            if (timeslot.isAvailable()) {
                bookingDetails = timeslot.schedule();
                break;
            }
        }
        if (bookingDetails != null) {
            System.out.println(bookingDetails);
        } else {
            System.out.println("No timeslot was available");
        }
*/
        // Declarative
        System.out.println(timeSlots.stream().filter(TimeSlot::isAvailable).findFirst().map(timeSlot -> timeSlot.schedule()).orElse("No timeslot was available"));

    }
}
