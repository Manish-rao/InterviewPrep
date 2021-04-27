package com.RSA;

public class Book {
    private int id;
    private String bookName;
    private String author;

    public Book(String bookName, String author) {
       // this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

   /*@Override
    public int hashCode() {
        return super.hashCode();
    }*/

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!(obj instanceof Book))
            return false;
        //return false;
        return this.bookName.equals(((Book)obj).bookName) && this.author.equals(((Book)obj).author);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/
}
