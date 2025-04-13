package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entites.dto.ListesObtenu;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.fetchQuestionnaireException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.pasDeJoueurException;

public interface ILancementQuizz {


    public ListesObtenu chargerPartie(IQuestionniareServices questionniareServices,JoueurServicesImpl joueurServices) throws pasDeJoueurException, fetchQuestionnaireException;
}
