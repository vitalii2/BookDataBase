package org.example;

public class Book implements Comparable<Book>{
    private int id;
    private String name;
    private String autor;
    private int year;
    private boolean staus;

    public Book() {
    }

    public Book(int id, String name, String autor, int year, boolean staus) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.year = year;
        this.staus = staus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isStaus() {
        return staus;
    }

    public void setStaus(boolean staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                ", staus=" + staus +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if (this.year > o.year){
            return -1;
        } else if (this.year < o.year) {
            return 1;
        }
        else
            return 0;
    }
}
