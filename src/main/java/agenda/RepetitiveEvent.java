package agenda;

import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class RepetitiveEvent extends Event {

    protected ChronoUnit frequency;
    protected HashSet<LocalDate> lesRepEvents;



    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
        this.lesRepEvents = new HashSet<LocalDate>();
    }

    public void addException(LocalDate date) {
        lesRepEvents.add(date);
    }

    public HashSet<LocalDate> getException() {
        return this.lesRepEvents;
    }
    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency () {
        return frequency;
    }
    public boolean isInDay(LocalDate aDay) {
        if(this.lesRepEvents.contains(aDay)){
            return false;
        }

        LocalDate test = LocalDate.from(getStart());
        while (test.isBefore(ChronoLocalDate.from(aDay.atStartOfDay())) || test.equals(aDay)) {
            if (test.plus(1, frequency).equals(aDay)) {
                return true;
            }
            test=test.plus(1, frequency);
        }
        return super.isInDay(aDay);
    }

}