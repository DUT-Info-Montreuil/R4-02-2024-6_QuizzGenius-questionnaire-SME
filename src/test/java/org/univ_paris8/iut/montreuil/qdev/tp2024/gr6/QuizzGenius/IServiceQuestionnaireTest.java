package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius;

import junit.framework.TestCase;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock1;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock2;


import java.util.ArrayList;
import java.util.List;

public class IServiceQuestionnaireTest extends TestCase {

    IServiceQuestionnaire servQuest = new IServiceQuestionnaireChargerListeQuestMock1();
    public void testChargerListeQuest() throws LienException {


        QuestionnaireDTO questions =  servQuest.chargerListeQuest("src/main/ressources/questionsQuizz_V1.1.csv");

        //test non vide
        assertTrue(questions.getQuestions() != null);
        assertTrue(!questions.getQuestions().isEmpty());

        //test premiere question correspond au premierdu csv
        List<QuestionDTO> questionList = questions.getQuestions();

        assertEquals("De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", questionList.get(0).getLibelleQuestion());
        assertEquals("Tee", questionList.get(0).getReponse());

    }

    @Test(expected = LienException.class)
    public void testChargerListeQuestException() throws LienException {
        IServiceQuestionnaire servQuest2 = new IServiceQuestionnaireChargerListeQuestMock1();
        QuestionnaireDTO questions =  servQuest2.chargerListeQuest("src/main/java/ressources/non.1.csv");

    }

    public void testChargerUneQuestion() throws NumTropGrandException {

        assertEquals("De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", servQuest.chargerUneQuestion(1));

    }

    @Test(expected = NumTropGrandException.class)

    public void testChargerUneQuestionException() throws NumTropGrandException {
        IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireChargerListeQuestMock2();
        QuestionDTO quest = servQuest3.chargerUneQuestion(1);

    }

    @Test(expected = NoStat.class)
    public void testMajStatQuestion() throws NoStat {
        IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireChargerListeQuestMock2();
        String maj =  servQuest3.majStatQuestion();

    }

    @Test(expected = NoStat.class)
    public void testFournirStatsQuestionException() throws NoStat {
        IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireChargerListeQuestMock1();
        String stat =  servQuest3.fournirStatsQuestion();

    }
}