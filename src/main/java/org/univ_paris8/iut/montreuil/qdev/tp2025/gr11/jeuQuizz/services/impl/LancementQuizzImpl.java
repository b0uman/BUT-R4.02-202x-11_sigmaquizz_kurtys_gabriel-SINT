package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entites.dto.ListesObtenu;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.ILancementQuizz;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.FichierCorompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.fetchQuestionnaireException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.pasDeJoueurException;

import java.util.ArrayList;
import java.util.List;

public class LancementQuizzImpl implements ILancementQuizz {


    @Override
    public ListesObtenu chargerPartie(IQuestionniareServices questionniareServices, JoueurServicesImpl joueurServices) throws pasDeJoueurException, fetchQuestionnaireException {
        List<JoueurDTO> listeJoueurs =  joueurServices.getJoueurExistant();
        if (listeJoueurs.isEmpty()){
            throw new pasDeJoueurException();
        }
        List<QuestionnaireDto> listeQuestionnaire = null;
        try {
            listeQuestionnaire = questionniareServices.fournirListeQuestionnaire("rien");
        } catch (LiensNonValideException e) {
            throw new fetchQuestionnaireException("lien non valide");
        } catch (FichierCorompuException e) {
            throw new fetchQuestionnaireException("fichier corompu");
        }
        if (listeQuestionnaire.isEmpty()){
            throw new fetchQuestionnaireException("Pas de questinnaire disponible");
        }
        return new ListesObtenu(new ArrayList<QuestionnaireDto>(listeQuestionnaire),new ArrayList<JoueurDTO>(listeJoueurs));
    }
}
