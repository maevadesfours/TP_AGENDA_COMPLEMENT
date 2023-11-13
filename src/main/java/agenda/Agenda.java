package agenda;

import java.time.LocalDate;
import java.util.*;


public class Agenda {
    protected ArrayList<Event> lesEvenements;
    private ArrayList<Event> CesEvenements;

    public Agenda(){
        this.lesEvenements= new ArrayList<Event>();
    }


    public void addEvent(Event e) {
        lesEvenements.add(e);
    }
    public void removeEvent(Event e) {
        lesEvenements.remove(e);
    }

    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> newListEvent = new ArrayList<Event>();
        for (Event e : lesEvenements) {
            if (e.isInDay(day)) {
                newListEvent.add(e);
            }
        }
        return newListEvent;
    }

    public List<Event> findByTitle(String title) {
        ArrayList<Event> listeTitre = new ArrayList<Event>();
        for (Event e : CesEvenements){
            if(e.getTitle().equals(title)){
                listeTitre.add(e);
            }
        }
        return listeTitre;
    }

    public boolean isFreeFor(Event e) {
        Boolean bool =true;
        for (Event ev : CesEvenements){
            if (ev.getStart().isBefore(e.getStart())){
                if (ev.getStart().plus(ev.getDuration()).isAfter(e.getStart()) ){
                    bool=false;
                }
            } else if (ev.getStart().equals(e.getStart())){
                bool=false;
            }
            if (ev.getStart().isAfter(e.getStart())){
                if (e.getStart().plus(e.getDuration()).isAfter(ev.getStart()) ){
                    bool=false;
                }}
        }
        return bool;
    }
}