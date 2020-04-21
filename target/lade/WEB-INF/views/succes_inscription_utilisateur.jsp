<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>

    <html>

    <head>
        <title>Succès inscription</title>
    </head>

    <body>

        The customer is confirmed: ${utilisateur.prenomUtilisateur} ${utilisateur.nomUtilisateur}

        <br><br> Email: ${utilisateur.emailUtilisateur}

        <br><br> Mot-de-passe : ${utilisateur.motDePasseUtilisateur}

        <br><br> Postal Code: ${utilisateur.confirmationMotDePasseUtilisateur}

    </body>

    </html>