package org.example;

import java.util.Date;

public class Loan implements Comparable<Loan>{
    private  int giveID;
    private  int readerID;
    private  int bookID;
    private String giveDate;
    private  String returneDate;

    public Loan() {
    }

    public Loan(int giveID, int readerID, int bookID, String giveDate, String returneDate) {
        this.giveID = giveID;
        this.readerID = readerID;
        this.bookID = bookID;
        this.giveDate = giveDate;
        this.returneDate = returneDate;
    }

    public int getGiveID() {
        return giveID;
    }

    public void setGiveID(int giveID) {
        this.giveID = giveID;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(String giveDate) {
        this.giveDate = giveDate;
    }

    public String getReturneDate() {
        return returneDate;
    }

    public void setReturneDate(String returneDate) {
        this.returneDate = returneDate;
    }

    @Override
    public String toString() {
        return "Loan { id= " + giveID + ", id reader= " + readerID + ", id book= " + bookID + ", issue date " + giveDate + ", returne date " + returneDate + " }";
    }




    @Override
    public int compareTo(Loan o) {
        if(this.getGiveID() > o.getGiveID()){
            return 1;
        } else if (this.getGiveID() < o.getGiveID()) {
            return -1;
        }else
            return 0;
    }
}
