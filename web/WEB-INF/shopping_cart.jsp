<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/default.css" />
    </head>

    <body>

        <div class="k_box_page_content">

            <!-- page title container -->
            <div class="k_box_page_title">
                Mon Panier
            </div>

            <!-- page content container -->
            <div id="k_box_shopping_cart_content">

                <label class="k_label_error">${error_message}</label>

                <label class="k_label_info">${message}</label>

                <!-- This has to be displayed only if the cart contains products -->
                <table class="k_table_form" id="k_table_form_shopping_cart">
                    <form action="ServletShoppingCart" method="post">
                        <tr>
                            <th>Titre</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            <th>Ajouter</th>
                            <th>Retirer</th>
                            <th>Supprimer</th>
                        </tr>

                        <!-- This whole tr contains product's info -->
                        <tr>
                        <input type="hidden" name="book" value="${book}" />
                        <td><a href="book?isbn=${book.isbn}">${book.title}</a></td>
                        <td>14.56</td>
                        <td>8</td>
                        <td><button class="k_button" type="submit" name="action" value="inc">+1</button></td>
                        <td><button class="k_button" type="submit" name="action" value="dec">-1</button></td>
                        <td><button class="k_button" type="submit" name="action" value="del">X</button></td>
                        </tr>

                    </form>
                </table>

                <!-- This has to be displayed only if the cart contains products -->
                <form action="shopping_cart.html" method="get">
                    <div id="k_box_shopping_cart_actions">

                        <div id="k_box_shopping_cart_clear">
                            <button class="k_button" type="submit" name="action" value="clear">Vider le panier</button>
                        </div>

                        <div id="k_box_shopping_cart_order">
                            <button class="k_button" type="submit" name="action" value="order">Commander</button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </body>
</html>