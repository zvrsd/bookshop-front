package model.bean;

import java.io.Serializable;
import java.util.HashMap;
import model.entity.Book;
/**
 *
 * @author zvr
 */
public class ShoppingCartBean implements Serializable{
    
    private HashMap<String,Book> books;
    private HashMap<String,Integer> quantity;

    
    public ShoppingCartBean(){
        books = new HashMap<>();
        quantity = new HashMap<>();
    }
    
    // Add a new book into the cart
    public void add(Book book){
        setQuantity(book, 1);
    }
    
    // Set book's quantity manually
    public void setQuantity(Book book, int quantity) {
        
        // If the book isnt in the map - add it
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(), book);
        }
        
        // Sets the book quantity to the specified value
        books.get(book.getIsbn()).setQuantity(quantity);
        
        // If the quantity reaches 0
        if(getQuantity(book) <= 0){
        }
    }
    // Increases book's quantity by 1
    public void increment(Book book){
        setQuantity(book, getQuantity(book) + 1);
    }
    
    // Decreases book's quantity by 1
    public void decrement(Book book){
        setQuantity(book, getQuantity(book) - 1);
    }
    
    // Removes a book from the shopping cart
    public void remove(Book book){
        quantity.remove(book.getIsbn());
        books.remove(book.getIsbn());
    }
    
    // Returns all book but not their quantity in cart
    public HashMap<String, Book> getBooks() {
        return books;
    }
    
    // Returns book's quantity for a given book
    public int getQuantity(Book book){
        if(quantity.containsKey(book.getIsbn())){
            return quantity.get(book.getIsbn());
        }
        return 0;
    }
}
