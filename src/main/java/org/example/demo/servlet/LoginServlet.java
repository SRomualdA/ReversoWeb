package org.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.entites.User;
import org.example.demo.forms.LoginForm;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String VUE = "/WEB-INF/JSP/login.jsp";
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUser";

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        LoginForm form = new LoginForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connectUser( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErrors().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, user );
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, user );
            //this.getServletContext().getRequestDispatcher(RESTRICT).forward( request, response );
        } else {
            // je renvoie vers l'index
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        }
    }

    @Override
    public void destroy() {

    }
}