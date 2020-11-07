package com.javalearn.study;

import java.util.Iterator;

class Film {
    private String title;
    private String country;
    private int year;
    private int rating;

    public Film() {
    }

    public Film(String title, String country, int year, int rating) {
        this.title = title;
        this.country = country;
        this.year = year;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

public class FilmCollection implements Iterable<Film>{

    private Film[] elements;

    public FilmCollection() {
    }

    public FilmCollection(Film[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Film> iterator() {
        return new FilmIterator();
    }

    private class FilmIterator implements Iterator<Film> {

        private int idx;

        @Override
        public boolean hasNext() {
            return idx<elements.length;
        }

        @Override
        public Film next() {
            return elements[idx++];
        }
    }
}
