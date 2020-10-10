package model.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import model.dao.ShippingOfferDAO;
import model.entity.Address;
import model.entity.Book;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Order_Row;
import model.entity.ShippingOffer;

/**
 *
 * @author zvr
 */
public class OrderValidationBean {
    
    private boolean isValidated;
    private boolean isOver;
    private Customer customer;
    private ShippingOffer shippingOffer;
    private HashMap<Long, ShippingOffer> shippingOffers;
    private List<Book> books;
    private Address deliveryAddress;
    private Address billingAddress;
    private List<Order_Row> rows;
    private Order order;

    public OrderValidationBean() {
        this.isValidated = false;
        this.isOver = false;
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

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public List<ShippingOffer> getGenericShippingOffers() throws NamingException, SQLException{
        return new ShippingOfferDAO().getByCarrierId(null);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order_Row> getRows() {
        return rows;
    }

    public void setRows(List<Order_Row> rows) {
        this.rows = rows;
    }

    public HashMap<Long, ShippingOffer> getShippingOffers() {
        return shippingOffers;
    }

    public void setShippingOffers(HashMap<Long, ShippingOffer> shippingOffers) {
        this.shippingOffers = shippingOffers;
    }
    
    public ShippingOffer getShippingOfferById(Long id){
        return shippingOffers.get(id);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isIsOver() {
        return isOver;
    }

    public void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }
    
}