package org.example.demo.forms;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.entites.User;
import org.example.demo.utilitaire.Utility;

import java.util.HashMap;
import java.util.Map;

public class LoginForm {
    private static final String FIELD_LOGIN = "login";
    private static final String FIELD_EMAIL = "email";
    private static final String FIELD_PASS = "password";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public User connectUser(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String login = Utility.getValueField(request, FIELD_LOGIN);
        String email = Utility.getValueField(request, FIELD_EMAIL);
        String password = Utility.getValueField(request, FIELD_PASS);

        User user = new User();
        // DAO
        user.setLogin(login);

        /* Validation du champ email. */
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErrors(FIELD_EMAIL, e.getMessage());
        }
        user.setEmail(email);

        /* Validation du champ mot de passe. */
        try {
            validPass(password);
        } catch (Exception e) {
            setErrors(FIELD_PASS, e.getMessage());
        }
        user.setPassword(password);

        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail(String email) throws Exception {
        if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception("Merci de saisir une adresse mail valide.");
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validPass(String password) throws Exception {
        if (password != null) {
            if (password.length() < 3) {
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErrors(String champ, String message) {
        errors.put(champ, message);
    }
}
