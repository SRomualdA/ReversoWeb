package org.example.demo.utilitaire;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {
    public static String getValueField(HttpServletRequest request, String paramField) {
        String value = request.getParameter(paramField);
        if (value == null || value.trim().isEmpty()) {
            return null;
        } else {
            return value;
        }
    }
}
