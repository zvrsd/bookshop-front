<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="k_box_page_content">

    <!-- page title container -->
    <div class="k_box_page_title">
        Ma commande
    </div>

    <!-- page content container -->
    <div id="k_box_shopping_cart_content">

        <jsp:useBean id="bean_shopping_cart" scope="session" class="model.bean.ShoppingCartBean" />
        
        <!-- displayed when unexpected stuffs happen -->
        <label class="k_label_error">${error_msg}</label>

        <!-- Informative message -->
        <label class="k_label_info">${message}</label>

        <div id="k_box_order_validation_total">
            
            Selectionnez un mode de livraison : 
            
            <select id="cars" name="cars">
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="fiat">Fiat</option>
                <option value="audi">Audi</option>
            </select>

        </div> 
        

        <!-- Contains products -->
        <table class="k_table_form" id="k_table_form_shopping_cart">
            <form action="ordervalidation" method="post">
                <tr>
                    <th>Titre</th>
                    <th>Prix HT</th>
                    <th>&nbsp;&nbsp;TVA&nbsp;&nbsp;</th>
                    <th>Prix TTC</th>
                    <th>Remise</th>
                    <th>Quantité</th>
                    <th>Prix Total HT</th>
                    <th>Prix Total TTC</th>
                </tr>
                
                <jsp:useBean id="bookBean" scope="request" class="model.bean.BookBean" />
                
                <c:forEach var="book" items="${bean_shopping_cart.books}">
                    
                    <jsp:setProperty name="bookBean" property="book" value="${book}" />
                    <!-- This whole tr contains product's info -->
                    <tr>
                        <input type="hidden" name="ref" value="15684" />
                        <td><a href="book?isbn=${book.isbn}">${book.title}</a></td>
                        <td>${bookBean.priceText} &euro;</td>
                        <td>${bookBean.book.vat.rate} %</td>
                        <td>${bookBean.fullPriceText} &euro;</td>
                        <td>?</td>
                        <td>${bookBean.book.quantity}</td>
                        <td>${bookBean.priceTotalText} &euro;</td>
                        <td>${bookBean.fullPriceTotalText} &euro;</td>
                    </tr>
                </c:forEach>
                
            </form>
        </table>
        <br/>

        <div id="k_box_order_validation_total">
            <!-- Contains products -->
            <table class="k_table_form" id="k_table_form_shopping_cart">

                <form>
                    <tr>
                        <th>Prix Total HT</th>
                        <th>Prix Total TTC</th>
                    </tr>

                    <tr>
                        <td>${bean_shopping_cart.totalPriceText} &euro;</td>
                        <td>${bean_shopping_cart.totalFullPriceText} &euro;</td>
                    </tr>
                </form>
                
            </table>
        </div>


        <!-- This has to be displayed only if the cart contains products -->
        <form action="ordervalidation" method="post">
            <div id="k_box_shopping_cart_actions">

                <div id="k_box_shopping_cart_clear">
                    <button class="k_button" type="submit" name="action" value="cart">Revenir au panier</button>
                </div>

                <div id="k_box_shopping_cart_order">
                    <button class="k_button" type="submit" name="action" value="">Valider cette commande</button>
                </div>

            </div>
        </form>
    </div>
</div>