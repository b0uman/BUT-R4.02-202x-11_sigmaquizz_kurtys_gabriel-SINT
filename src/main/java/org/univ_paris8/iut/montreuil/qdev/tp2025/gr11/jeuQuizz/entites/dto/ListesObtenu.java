package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entites.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;

import java.util.ArrayList;
import java.util.List;

public class ListesObtenu {

    List<QuestionnaireDto> listeQuestionnaire;
    List<JoueurDTO> listeJoueur;
    public ListesObtenu(List<QuestionnaireDto> listeQuestionnaire, List<JoueurDTO> listeJoueur){
        this.listeQuestionnaire=listeQuestionnaire;
        this.listeJoueur=listeJoueur;
    }

}
