package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock1;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerUneQuestionEqual;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerUneQuestExp;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Enum.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

import static org.junit.jupiter.api.Assertions.*;

class chargerUneQuestionTest {
    IServiceQuestionnaire servQuest = new IServiceQuestionnaireChargerListeQuestMock1();
    QuestionnaireDTO questions2 =  servQuest.chargerListeQuest("src/main/ressources/questionsQuizz_V1.1.csv");

    chargerUneQuestionTest() throws LienException {
    }


    //IQuestionnaire iQuestionnaire;
    @Test
    void questionCorrecte() throws NumTropGrandException {
        IServiceQuestionnaireChargerUneQuestionEqual iQuestionnaire = new IServiceQuestionnaireChargerUneQuestionEqual();
        QuestionDTO laQuestion = iQuestionnaire.chargerUneQuestion(1,1,questions2);
        QuestionDTO leTest = new QuestionDTO(1, 1, Langue.fr, "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", 1, "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf");
        assertEquals(laQuestion, leTest);
    }

    @Test
    void testException () throws NumTropGrandException {
        IServiceQuestionnaireChargerUneQuestExp iQuestionnaire = new IServiceQuestionnaireChargerUneQuestExp();
        assertThrows(NumTropGrandException.class, () -> {
            iQuestionnaire.chargerUneQuestion(31,1,questions2);
        });
    }

}