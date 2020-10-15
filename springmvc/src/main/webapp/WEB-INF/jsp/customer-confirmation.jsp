<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-language" content="ja">
        <meta charset="UTF-8">
        <title>Customer Confirmation</title>
    </head>

    <body>
        <!-- calls student.getFirstname(), -->
        The customer is confirmed: ${customer.firstName} ${customer.lastName}

        <br><br>

        Free Passes: ${customer.freePasses}

        <br><br>

        Postal Code: ${customer.postalCode}
    </body>
</html>