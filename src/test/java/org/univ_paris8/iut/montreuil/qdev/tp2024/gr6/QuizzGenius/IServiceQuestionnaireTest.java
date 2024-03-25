package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius;

import junit.framework.TestCase;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.impl.QuestionImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Enum.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock1;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerListeQuestMock2;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireChargerUneQuestExp;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest.IServiceQuestionnaireMAJStatsQuetionsMock4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IServiceQuestionnaireTest extends TestCase {

   // IServiceQuestionnaire servQuest = new IServiceQuestionnaireChargerListeQuestMock1();
   QuestionImpl servQuest= new QuestionImpl();
    QuestionnaireDTO questions2 =  servQuest.chargerListeQuest("/Users/gazzi/IdeaProjects/R4-02-2024-6_QuizzGenius-questionnaire-SME/src/main/resources/questionsQuizz_V1.1.csv");

    //QuestionDTO question1 = new QuestionDTO(1, 1, Langue.fr  , "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", 1, "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf");
   QuestionDTO question1 = servQuest.chargerUneQuestion(1,1,questions2);
    public IServiceQuestionnaireTest() throws LienException, NumTropGrandException {
    }

    public void testChargerListeQuest() throws LienException {


        QuestionnaireDTO questions =  servQuest.chargerListeQuest("/Users/gazzi/IdeaProjects/R4-02-2024-6_QuizzGenius-questionnaire-SME/src/main/resources/questionsQuizz_V1.1.csv");

        //test non vide
        assertTrue(questions.getQuestions() != null);
        assertTrue(!questions.getQuestions().isEmpty());

        //test premiere question correspond au premierdu csv
        List<QuestionDTO> questionList = questions.getQuestions();

        assertEquals("De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", questionList.get(0).getLibelleQuestion());
        assertEquals("Tee", questionList.get(0).getReponse());

    }

    public void testChargerListeQuestException() throws LienException {
        assertThrows(LienException.class, () -> {
            IServiceQuestionnaire servQuest2 = new IServiceQuestionnaireChargerListeQuestMock2();
            QuestionnaireDTO questions =  servQuest2.chargerListeQuest("src/main/java/ressources/nom.csv");

        });

    }

    public void testChargerUneQuestion() throws NumTropGrandException {

        assertEquals(question1, servQuest.chargerUneQuestion(1,1,questions2));

    }

    public void testChargerUneQuestionException() throws NumTropGrandException {
        assertThrows(NumTropGrandException.class, () -> {
            IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireChargerUneQuestExp();
            QuestionDTO quest = servQuest3.chargerUneQuestion(1,1,questions2);

        });

    }

    public void testMajStatQuestion() throws NoStat {

        assertThrows(NoStat.class, () -> {
            IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireMAJStatsQuetionsMock4();
            String maj =  servQuest3.majStatQuestion();
        });

    }

    @Test(expected = NoStat.class)
    public void testFournirStatsQuestionException() throws NoStat {
        assertThrows(NoStat.class, () -> {
            IServiceQuestionnaire servQuest3 = new IServiceQuestionnaireMAJStatsQuetionsMock4();
            String stat =  servQuest3.fournirStatsQuestion();
        });

    }
}