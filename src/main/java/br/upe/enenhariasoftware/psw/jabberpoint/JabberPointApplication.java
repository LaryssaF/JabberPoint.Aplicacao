/**
 * UPE - Campus Garanhuns Curso de Bacharelado em Engenharia de Software
 * Disciplina de Projeto de Software - 2023.1
 *
 * Licensed under the Apache License, Version 2.0
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * @author Ian F. Darwin
 *         Helaine Lins
 */
package br.upe.enenhariasoftware.psw.jabberpoint;

import java.io.IOException;

import javax.swing.JOptionPane;

public class JabberPointApplication {
    public static void main(String[] args) {
        initializeStyles();

        Presentation presentation = new Presentation();

        showSlideViewer(presentation);

        try {
            if (args.length == 0) {
                loadDemoPresentation(presentation);
            } else {
                loadXMLPresentation(presentation, args[0]);
            }

            presentation.setSlideNumber(0);

        } catch (IOException ex) {
            showErrorMessage("IO Error: " + ex);
        }
    }
    
    private static void initializeStyles() {
        Style.createStyles();
    }

    private static void showSlideViewer(Presentation presentation) {
        new SlideViewerFrame("Jabberpoint 1.6 -", presentation);
    }

    private static void loadDemoPresentation(Presentation presentation) throws IOException {
        Accessor.getDemoAccessor().loadFile(presentation, "");
    }
    private static void loadXMLPresentation(Presentation presentation, String filename) throws IOException {
        new XMLAccessor().loadFile(presentation, filename);
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Jabberpoint Error", JOptionPane.ERROR_MESSAGE);
    }
}