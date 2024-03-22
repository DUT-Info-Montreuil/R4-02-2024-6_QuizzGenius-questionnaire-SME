package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

public class IServiceQuestionnaireChargerUneQuestExp implements IServiceQuestionnaire {
    @Override
    public QuestionnaireDTO chargerListeQuest(String path) throws LienException {
        return null;
    }

    @Override
    public QuestionDTO chargerUneQuestion(int idQuestion) throws NumTropGrandException {
        throw  new NumTropGrandException("Test");
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
