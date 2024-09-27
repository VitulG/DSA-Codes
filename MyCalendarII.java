import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class MyCalendarTwo {
    static class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private final List<Event> events;
    private final List<Event> doubleBookings;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // check for double bookings
        for(Event event : doubleBookings) {
            if(Math.max(event.start, start) < Math.min(event.end, end)) {
                return false;
            }
        }

        for(Event event : events) {
            if(Math.max(event.start, start) < Math.min(event.end, end)) {
                doubleBookings.add(new Event(Math.max(event.start, start), Math.min(event.end, end)));
            }
        }

        events.add(new Event(start, end));
        return true;
    }
}

public class MyCalendarII {

}
