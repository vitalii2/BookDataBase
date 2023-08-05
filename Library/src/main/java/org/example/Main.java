package org.example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//     Book book = new Book();
//     Reader reader = new Reader();
        List<Book> books = DataBaseHeandler.getBooksData("SELECT * FROM book");
        Collections.sort(books);
        System.out.println(books);
        List<Reader> readers = DataBaseHeandler.getReaderData("SELECT * FROM reader");

//        Book book = new Book();
//        book.setId(3);
//        book.setName("Iliada");
//        book.setAutor("Homer");
//        book.setYear(1128);
//        book.setStaus(true);
//        System.out.println(DataBaseHeandler.createNewBook(book));
        Collections.sort(readers);
        System.out.println(readers);
        List<Loan> loans = DataBaseHeandler.getLoanData("SELECT * FROM loan");
        Collections.sort(loans);
        System.out.println(loans);
//        Reader reader = new Reader();
//        reader.setId(3);
//        reader.setName("Bob");
//        reader.setBirthDate("22.11.1989");
//        reader.setPhone("+972531224330");
//        System.out.println(DataBaseHeandler.createNewReader(reader));
//        System.out.println(DataBaseHeandler.updateBook(2,false));
//        System.out.println(DataBaseHeandler.updateReader(1,"+973542211475"));
//          System.out.println(DataBaseHeandler.deleteBook(2));
//        System.out.println(DataBaseHeandler.deleteReader(3));
//          Loan loan = new Loan();
//          loan.setGiveID(1);
//          loan.setReaderID(readers.get(1).getId());
//          loan.setBookID(books.get(1).getId());
//          loan.setGiveDate("5.08.2023");
//          loan.setReturneDate("14.09.2023");
//        System.out.println(DataBaseHeandler.giveBook(loan,loan.getReaderID(),loan.getBookID()));
//        System.out.println(DataBaseHeandler.returnBook(loan.getGiveID(),loan.getReturneDate()));
//        loan.setGiveID(2);
//        loan.setReaderID(readers.get(1).getId());
//        loan.setBookID(books.get(0).getId());
//        loan.setGiveDate("5.08.2023");
////        System.out.println(DataBaseHeandler.giveBook(loan,loan.getReaderID(),loan.getBookID()));
//        Loan loan1 = new Loan();
//        loan1.setGiveID(3);
//        loan1.setReaderID(readers.get(0).getId());
//        loan1.setBookID(books.get(1).getId());
//        loan1.setGiveDate("4.08.2023");
//        loan1.setReturneDate("12.08.2023");
//        System.out.println(DataBaseHeandler.giveBook(loan1,loan1.getReaderID(),loan1.getBookID()));
//        System.out.println(DataBaseHeandler.returnBook(loan1.getGiveID(),loan1.getReturneDate()));
//        System.out.println(DataBaseHeandler.returnBook(loan.getGiveID(),loan.getReturneDate()));
//        Loan loan3 = new Loan();
//        loan3.setGiveID(5);
//        loan3.setReaderID(readers.get(1).getId());
//        loan3.setBookID(books.get(0).getId());
//        loan3.setGiveDate("1.08.2023");
//        loan3.setReturneDate("11.09.2023");
//        System.out.println(DataBaseHeandler.giveBook(loan3,loan3.getReaderID(),loan3.getBookID()));
//        System.out.println(DataBaseHeandler.returnBook(loan3.getGiveID(),loan3.getReturneDate()));

    }
}