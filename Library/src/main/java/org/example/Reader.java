package org.example;

public class Reader implements Comparable<Reader>{
    private int id;
    private String name;
    private String birthDate;
    private String phone;

    public Reader() {
    }

    public Reader(int id, String name, String birthDate, String phone) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int compareTo(Reader o) {
        if(this.name.length() > o.name.length()){
            return -1;
        } else if (this.name.length() < o.name.length()) {
            return 1;
        }else
         return 0;
    }
}
