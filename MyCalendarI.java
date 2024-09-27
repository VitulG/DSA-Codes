import java.util.*;

class MyCalendar {

    static class Event {
        int start;
        int end;
        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private final TreeSet<Event> events;
    public MyCalendar() {
        events = new TreeSet<>((a,b) -> a.start - b.start);
    }

    public boolean book(int start, int end) {
        Event newEvent = new Event(start, end);

        // find floor and ceiling to detect if there is no overlapping
        Event floor = events.floor(newEvent);
        Event ceiling = events.ceiling(newEvent);

        if(floor != null && floor.end > start) {
            return false;
        }

        if(ceiling != null && ceiling.start < end) {
            return false;
        }
        events.add(newEvent);
        return true;
    }
}

public class MyCalendarI {
    public static void main(String[] args) {

    }
}
