package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHeandler {
    private static String INSERT_BOOK = "INSERT INTO book(id,name,autor,year,status) VALUES(?,?,?,?,?);";
    private static String INSERT_READER = "INSERT INTO reader(id,name,dateofBirth,phone) VALUES(?,?,?,?);";
    private static String UPDATE_BOOK = "UPDATE book SET status = ? WHERE id = ?";
    private static String UPDATE_READER = "UPDATE reader SET phone = ? WHERE id = ?";
    private static  String DELETE_BOOK = "DELETE FROM book where id = ?";
    private static String DELETE_READER = "DELETE FROM reader where id = ?";
    private static String GIVE = "INSERT INTO loan(giveID,readerID,bookID,giveDate,returneDate) VALUES(?,?,?,?,?);";
    private static String RETURNE = "UPDATE loan SET returneDate = ? WHERE giveID = ?;";
    public static List<Book> getBooksData(String query){
        List<Book> books = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);)
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String autor = rs.getString("autor");
                int year = rs.getInt("year");
                boolean status = rs.getBoolean("status");

                books.add(new Book(id,name,autor,year,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public static List<Reader> getReaderData(String query){
        List<Reader> readers = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthDate = rs.getString("dateofBirth");
                String phone = rs.getString("phone");

                readers.add(new Reader(id,name,birthDate,phone));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return readers;
    }
    public static List<Loan> getLoanData(String query){
        List<Loan> loans = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int giveID = rs.getInt("giveID");
                int readerID = rs.getInt("readerID");
                int bookID = rs.getInt("bookID");
                String giveDate = rs.getString("giveDate");
                String returneDate = rs.getString("returneDate");
                loans.add(new Loan(giveID,readerID,bookID,giveDate,returneDate));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return loans;
    }
    public static List<Book> createNewBook(Book book){
        List<Book> books = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);) {
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3,book.getAutor());
        preparedStatement.setInt(4,book.getYear());
        preparedStatement.setBoolean(5,book.isStaus());
        preparedStatement.executeUpdate();
        PreparedStatement allBooks = connection.prepareStatement("SELECT * FROM book");
        ResultSet rs = allBooks.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String autor = rs.getString("autor");
            int year = rs.getInt("year");
            boolean status = rs.getBoolean("status");

            books.add(new Book(id,name,autor,year,status));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public static List<Reader> createNewReader(Reader reader){
        List<Reader> readers = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_READER)){
        preparedStatement.setInt(1,reader.getId());
        preparedStatement.setString(2,reader.getName());
        preparedStatement.setString(3,reader.getBirthDate());
        preparedStatement.setString(4,reader.getPhone());
        preparedStatement.executeUpdate();
        PreparedStatement allReaders = connection.prepareStatement("SELECT * FROM reader");
        ResultSet rs = allReaders.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dateofBirth = rs.getString("dateofBirth");
            String phone = rs.getString("phone");
            readers.add(new Reader(id,name,dateofBirth,phone));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  readers;
    }
    public static List<Book> updateBook(int idBook, boolean statusBook){
        List<Book> books = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setBoolean(1, statusBook);
            preparedStatement.setInt(2, idBook);
            preparedStatement.executeUpdate();
            PreparedStatement allBooks = connection.prepareStatement("SELECT * FROM book");
            ResultSet rs = allBooks.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String autor = rs.getString("autor");
                int year = rs.getInt("year");
                boolean status = rs.getBoolean("status");
                books.add(new Book(id,name,autor,year,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public static List<Reader> updateReader(int idReader, String phoneReader){
        List<Reader> readers = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_READER);){
            preparedStatement.setString(1,phoneReader);
            preparedStatement.setInt(2,idReader);
            preparedStatement.executeUpdate();
            PreparedStatement allReaders = connection.prepareStatement("SELECT * FROM reader");
            ResultSet rs = allReaders.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateofBirth = rs.getString("dateofBirth");
                String phone = rs.getString("phone");
                readers.add(new Reader(id,name,dateofBirth,phone));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return readers;
    }
    public static List<Book> deleteBook(int idBook){
        List<Book> books = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);) {
            preparedStatement.setInt(1,idBook);
            preparedStatement.executeUpdate();
            PreparedStatement allbooks = connection.prepareStatement("SELECT * FROM book");
            ResultSet res = allbooks.executeQuery();
            while (res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String autor = res.getString("autor");
                int year = res.getInt("year");
                boolean status = res.getBoolean("status");
                books.add(new Book(id,name,autor,year,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public static List<Reader> deleteReader(int idReader){
        List<Reader> readers = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_READER);){
        preparedStatement.setInt(1,idReader);
        preparedStatement.executeUpdate();
        PreparedStatement allReaders = connection.prepareStatement("SELECT * FROM reader");
        ResultSet rs = allReaders.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String date = rs.getString("dateofBirth");
            String phone = rs.getString("phone");
            readers.add(new Reader(id,name,date,phone));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return readers;
    }
    public static List<Loan> giveBook(Loan loan, int idReader, int idBook){
        List<Loan> loans = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GIVE);){
        preparedStatement.setInt(1,loan.getGiveID());
        preparedStatement.setInt(2, idReader);
        preparedStatement.setInt(3,idBook);
        preparedStatement.setString(4, loan.getGiveDate());
        preparedStatement.setString(5, loan.getReturneDate());
        preparedStatement.executeUpdate();
        PreparedStatement allLoans = connection.prepareStatement("SELECT * FROM loan");
        ResultSet rs = allLoans.executeQuery();
        while (rs.next()){
            int giveID = rs.getInt("giveID");
            int readerID = rs.getInt("readerID");
            int bookID = rs.getInt("bookID");
            String giveDate = rs.getString("giveDate");
            String returneDate = rs.getString("returneDate");
            loans.add(new Loan(giveID,readerID,bookID,giveDate,returneDate));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return loans;
    }
    public static List<Loan> returnBook(int idLoan, String rDateBook){
        List<Loan> loans = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(RETURNE);) {
            preparedStatement.setString(1,rDateBook);
            preparedStatement.setInt(2,idLoan);
            preparedStatement.executeUpdate();
            PreparedStatement allLoan = connection.prepareStatement("SELECT * FROM loan");
            ResultSet rs = allLoan.executeQuery();
            while (rs.next()){
                int giveID = rs.getInt("giveID");
                int readerID = rs.getInt("readerID");
                int bookID = rs.getInt("bookID");
                String giveDate = rs.getString("giveDate");
                String returneDate = rs.getString("returneDate");
                loans.add(new Loan(giveID,readerID,bookID,giveDate,returneDate));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return loans;
    }
}
