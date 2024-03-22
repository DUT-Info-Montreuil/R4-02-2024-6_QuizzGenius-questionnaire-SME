package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerUneQuestionEqual;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerUneQuestExp;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Enum.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

import static org.junit.jupiter.api.Assertions.*;

class chargerUneQuestionTest {

    //IQuestionnaire iQuestionnaire;
    @Test
    void questionCorrecte() throws NumTropGrandException {
        IServiceQuestionnaireChargerUneQuestionEqual iQuestionnaire = new IServiceQuestionnaireChargerUneQuestionEqual();
        QuestionDTO laQuestion = iQuestionnaire.chargerUneQuestion(1);
        QuestionDTO leTest = new QuestionDTO(1, 1, Langue.FRANÇAIS, "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", 1, "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf", "null");
        assertEquals(laQuestion, leTest);
    }

    @Test
    void testException () throws NumTropGrandException {
        IServiceQuestionnaireChargerUneQuestExp iQuestionnaire = new IServiceQuestionnaireChargerUneQuestExp();

        try {
            iQuestionnaire.chargerUneQuestion(31);
            assertTrue(false);
        } catch (NumTropGrandException e){
            assertTrue(true);
        }
    }

}