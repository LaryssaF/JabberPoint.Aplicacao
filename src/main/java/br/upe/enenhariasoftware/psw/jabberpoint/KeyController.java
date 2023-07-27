/**
 * UPE - Campus Garanhuns Curso de Bacharelado em Engenharia de Software
 * Disciplina de Projeto de Software - 2023.1
 * 
 * Licensed under the Apache License, Version 2.0
 * https://www.apache.org/licenses/LICENSE-2.0
 * 
 * @author Ian F. Darwin, Helaine Lins
 */
package br.upe.enenhariasoftware.psw.jabberpoint;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

    private Presentation presentation;

    public KeyController(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                moveNextSlide();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                movePreviousSlide();
                break;
            case KeyEvent.VK_Q:
            case KeyEvent.VK_ESCAPE:
                exitApplication();
                break;
            default:
                break;
        }
    }
    private void moveNextSlide() {
        presentation.nextSlide();
    }

    private void movePreviousSlide() {
        presentation.prevSlide();
    }

    private void exitApplication() {
        System.exit(0);
    }
}





