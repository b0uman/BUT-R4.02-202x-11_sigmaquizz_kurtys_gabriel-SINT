package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions;

public class pasDeJoueurException extends generalException{
    public pasDeJoueurException() {
        super("Aucun joueur n'est disponible");
    }
}
