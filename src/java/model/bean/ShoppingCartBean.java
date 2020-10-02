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

    public ShoppingCartBean(){
        books = new HashMap<>();
    }
    
    public Book getBook(String isbn){
        return books.get(isbn);
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
        books.remove(isbn);
    }
    
    public void clear(){
        books.clear();
    }
    
    // Returns all books in cart
    public Collection<Book> getBooks(){
        return books.values();
    }
    
    // Returns book's quantity for a given book
    public int getQuantity(String isbn){
        
        if(books.containsKey(isbn)){
            return getBook(isbn).getQuantity();
        }
        return 0;
    }
    
    // Returns true if the shopping cart is empty
    public boolean isEmpty(){
        return books.isEmpty();
    }
}
