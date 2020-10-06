package model.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.naming.NamingException;
import model.dao.ShippingOfferDAO;
import model.entity.Book;
import model.entity.ShippingOffer;

/**
 *
 * @author zvr
 */
public class OrderValidationBean {
    
    private boolean isValidated;
    private ShippingOffer shippingOffer;
    private List<Book> books;

    public OrderValidationBean() {
        this.isValidated = false;
        this.books = new ArrayList<>();
    }

    public ShippingOffer getShippingOffer() {
        return shippingOffer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isValidated() {
        return isValidated;
    }

   
    public void setShippingOffer(ShippingOffer shippingOffer) {
        this.shippingOffer = shippingOffer;
    }

    public void setBooks(Collection<Book> books) {
        this.books.clear();
        this.books.addAll(books);
    }

    public void setValidated(boolean isValidated) {
        this.isValidated = isValidated;
    }
    
    public List<ShippingOffer> getGenericShippingOffers() throws NamingException, SQLException{
        return new ShippingOfferDAO().getByCarrierId(null);
    }
}