<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Bookshop - Modification de votre compte</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>


    <body>



        <header>
            <jsp:include page="headerJsp.jsp" />
        </header>


        <!-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        CODE POUR LE HAUT DE PAGE
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->


        <!-- Customer customer = (Customer) session.getAttribute(Values.PARAM_CUSTOMER);     -->                                                              



        <section>
            <h2>Modification des informations</h2>

            <div>
                Tous les champs marqués d'un astérisque * doivent impérativement être renseignés afin de valider les modifications.
            </div>

            <br />

            <form action="/idModif" method="post">
                <table>
                    <tr>
                    <label>
                        <td>Nom</td>
                        <td><input type="text" name="lName" value="${customer.customerLName}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Prénom</td>
                        <td><input type="text" name="fName" value="${customer.customerFName}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Pseudonyme</td>
                        <td><input type="text" name="pseudo" value="${customer.customerUsername}">*</td>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Nouveau mot de passe</td>
                        <td><input type="password" name="newPassword">*<td/>
                    </label>
                    </tr>

                    <tr>
                    <label>
                        <td>Confirmer le mot de passe</td>
                        <td><input type="password" name="newPasswordConf">*</td>
                    </label>
                    </tr>

                </table>

                <br>

                <section>

                    <button type="submit">Confirmer</button>

                    <button type="button"><a href="myAccount.jsp">Annuler</a></button>
                </section>
            </form>    
        </section>




        <!-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        CODE POUR LE PIED DE PAGE
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->




    </div>

    <footer>
        <jsp:include page="footerJsp.jsp" />
    </footer>

</body>

<!-- Site web créé par la fine équipe -->


</html>
