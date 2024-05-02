package org.example.demo.forms;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.entites.Client;
import org.example.demo.exception.ReException;
import org.example.demo.utilitaire.Utility;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Fomulaire {
    private static final String CHAMP_RAISONS = "raisonS";
    private static final String CHAMP_NUMRUE = "numRue";
    private static final  String CHAMP_NOMRUE = "nomRue";
    private static final String CHAMP_CP = "cp";
    private static final String CHAMP_VILLE = "ville";
    private static final String CHAMP_TEL = "tel";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_NBEMPL = "nbEmpl";
    private static final String CHAMP_CHIFFRE = "chiffre";
    private static final String CHAMP_COMMENTAIRE = "commentaire";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat(){
        return resultat;
    }
    public Map<String, String> getErreurs(){
        return erreurs;
    }

    public Client inscrireClient(HttpServletRequest request){
        String raisonS = Utility.getValueField(request, CHAMP_RAISONS);
        String numRue = Utility.getValueField(request, CHAMP_NUMRUE);
        String nomRue = Utility.getValueField(request, CHAMP_NOMRUE);
        String cp = Utility.getValueField(request, CHAMP_CP);
        String ville = Utility.getValueField(request, CHAMP_VILLE);
        String tel = Utility.getValueField(request, CHAMP_TEL);
        String email = Utility.getValueField(request, CHAMP_EMAIL);
        String nbEmpl = Utility.getValueField(request, CHAMP_NBEMPL);
        String chiffre = Utility.getValueField(request, CHAMP_CHIFFRE);
        String commentaire = Utility.getValueField(request, CHAMP_COMMENTAIRE);

        Client client = new Client();

        try {
            client.setRaisonSocial(raisonS);
        } catch (ReException re){
            JOptionPane.showMessageDialog(null, re.getMessage());
        }

        return client;
    }
}
