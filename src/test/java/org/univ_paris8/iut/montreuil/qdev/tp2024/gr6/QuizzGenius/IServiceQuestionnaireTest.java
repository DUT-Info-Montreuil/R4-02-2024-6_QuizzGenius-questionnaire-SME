package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius;

import junit.framework.TestCase;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock1;

import java.util.ArrayList;
import java.util.List;

public class IServiceQuestionnaireTest extends TestCase {

    IServiceQuestionnaire servQuest = new IServiceQuestionnaireChargerListeQuestMock1();
    public void testChargerListeQuest() throws LienException {


        QuestionnaireDTO questions =  servQuest.chargerListeQuest("src/main/ressources/questionsQuizz_V1.1.csv");

        assertTrue(questions.getQuestions() != null);
        assertTrue(!questions.getQuestions().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testChargerListeQuestException() throws LienException {
        QuestionnaireDTO questions =  servQuest.chargerListeQuest("src/main/ressources/questionsQuizz_V1.2.csv");

    }

    public void testChargerUneQuestion() {
    }

    public void testMajStatQuestion() {
    }

    public void testFournirStatsQuestion() {
    }
}