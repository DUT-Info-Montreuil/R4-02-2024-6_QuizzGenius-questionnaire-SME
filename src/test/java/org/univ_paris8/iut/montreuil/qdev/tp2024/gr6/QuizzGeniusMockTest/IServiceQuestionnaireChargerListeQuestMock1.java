package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Enum.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IServiceQuestionnaireChargerListeQuestMock1 implements IServiceQuestionnaire {
    @Override
    public QuestionnaireDTO chargerListeQuest(String path) throws LienException {
        //new QuestionDTO(1,1,Langue.ANGLAIS, " ", " ", 1, " ", " " , " ")
        List<QuestionDTO> questions = new ArrayList<>();

        // Add sample questions
        questions.add(new QuestionDTO(1, 1, Langue.FRANÇAIS  , "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", 1, "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf", ""));

        return new QuestionnaireDTO(questions, 1);
    }

    @Override
    public QuestionDTO chargerUneQuestion(int idQuestion) throws NumTropGrandException {
        return new QuestionDTO(1, 1, Langue.FRANÇAIS  , "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", 1, "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf", "");
    }

    @Override
    public String majStatQuestion() throws NoStat {
        return null;
    }

    @Override
    public String fournirStatsQuestion() throws NoStat {
        return null;
    }
}
