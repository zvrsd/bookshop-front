package model.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import model.entity.Book;
/**
 *
 * @author zvr
 */
public class ShoppingCartBean implements Serializable{
    
    private HashMap<String,Book> books;
    private HashMap<String,Integer> quantity;

    
    public Book getBook(){
        return null;
    }
    
    public ShoppingCartBean(){
        books = new HashMap<>();
        quantity = new HashMap<>();
    }
    
    // Add a new book into the cart
    public void add(Book book){
        // If the book isnt in the map - add it
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(), book);
            setQuantity(book.getIsbn(), 1);
        }
        else{
            increment(book.getIsbn());
        }
    }
    
    // Set book's quantity manually
    public void setQuantity(String isbn, int quantity) {

        // Sets the book quantity to the specified value
        books.get(isbn).setQuantity(quantity);
        
        // If the quantity reaches 0
        if(getQuantity(isbn) <= 0){
        }
    }
    // Increases book's quantity by 1
    public void increment(String isbn){
        setQuantity(isbn, getQuantity(isbn) + 1);
    }
    
    // Decreases book's quantity by 1
    public void decrement(String isbn){
        setQuantity(isbn, getQuantity(isbn) - 1);
    }
    
    // Removes a book from the shopping cart
    public void remove(String isbn){
        quantity.remove(isbn);
        books.remove(isbn);
    }
    
    public void clear(){
        books.clear();
        quantity.clear();
    }
    // Returns all book but not their quantity in cart
    public Collection<Book> getBooks(){
        /*Collection<Book> booksC = books.values();
        for(Book book : booksC){
            book.setQuantity(quantity.get(book.getIsbn()));
        }*/
        return books.values();
    }
    
    // Returns quantities
    public Collection<Integer> getQuantities(){
        return quantity.values();
    }
    
    // Returns book's quantity for a given book
    public int getQuantity(String isbn){
        
        if(quantity.containsKey(isbn)){
            return quantity.get(isbn);
        }
        return 0;
    }
    
    // Returns true if the shopping cart is empty
    public boolean isEmpty(){
        return books.isEmpty();
    }
}
