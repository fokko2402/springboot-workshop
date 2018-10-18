package nl.rechtspraak.springboot.filmapi.model;

public class FilmlijstItem {
    private String titel;
    private int jaar;
    private String id;

    public FilmlijstItem(Film film) {
        this.titel = film.getTitel();
        this.jaar = film.getReleaseJaar();
        this.id = film.getId();
    }

    public String getTitel() {
        return titel;
    }

    public int getJaar() {
        return jaar;
    }

    public String getId() {
        return id;
    }
}
