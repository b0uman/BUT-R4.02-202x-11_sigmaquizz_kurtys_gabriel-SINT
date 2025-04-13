package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.impl.LancementQuizzImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.impl.QuestionnaireServiceImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    static LancementQuizzImpl lancementQuizz;
    @Mock
    static IQuestionniareServices questionniareServicesMockito;
    @Mock
    static JoueurServicesImpl joueurServicesMockito;
    @BeforeAll
    public static void init(){
        questionniareServicesMockito = new QuestionnaireServiceImpl();
        joueurServicesMockito = new JoueurServicesImpl();
    }
    @Test
    public void testErreurQuestionnaire() throws FichierCorompuException, LiensNonValideException {
        assertNotNull(questionniareServicesMockito);
        JoueurDTO joueur = new JoueurDTO("lili","lili",1111,"sport",1);
        List joueurs = new ArrayList();
        joueurs.add(joueur);
        when(joueurServicesMockito.getJoueurExistant()).thenReturn(joueurs);
        when(questionniareServicesMockito.fournirListeQuestionnaire("rien")).thenThrow(new LiensNonValideException());



        lancementQuizz = new LancementQuizzImpl();
        assertThrows(fetchQuestionnaireException.class, () -> lancementQuizz.chargerPartie(questionniareServicesMockito,joueurServicesMockito));
        verify(questionniareServicesMockito).fournirListeQuestionnaire("rien");
    }
    @Test
    public void testPasdejoueur(){
        assertNotNull(joueurServicesMockito);
        when(joueurServicesMockito.getJoueurExistant()).thenReturn(new ArrayList());
        lancementQuizz = new LancementQuizzImpl();
        assertThrows(pasDeJoueurException.class, () -> lancementQuizz.chargerPartie(questionniareServicesMockito,joueurServicesMockito));
        verify(joueurServicesMockito).getJoueurExistant();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
