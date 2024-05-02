package org.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.ClientDAO;
import org.example.demo.entites.Client;
import org.example.demo.forms.Fomulaire;
import org.example.demo.forms.LoginForm;

import java.io.IOException;

@WebServlet(name = "FormulaireServlet", value = "/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
    public static final String VUE ="/WEB-INF/JSP/formulaire.jsp";
    public static final String ATT_CLIENT = "client";
    public static final String ATT_FORM = "form";

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        request.getRequestDispatcher("formulaire.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        Fomulaire form = new Fomulaire();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Client client = form.inscrireClient(request);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_CLIENT, client);

        if(form.getErreurs().isEmpty()){
            try {
                ClientDAO.create(client);
                //Redirection vers une page de succès
                response.sendRedirect("");
            } catch (Exception e) {
                request.setAttribute("erreur", "Erreur lors de l'enregistrement du client.");
                //Redirection vers une page d'erreur
                request.getRequestDispatcher("").forward(request, response);
            }
        } else {
            // Si le formulaire n'est pas valide, affichage du formulaire avec les erreurs
            request.getRequestDispatcher(VUE).forward(request, response);
        }

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public void destroy() {

    }
}