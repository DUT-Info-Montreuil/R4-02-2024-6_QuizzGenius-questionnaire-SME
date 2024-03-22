package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGeniusMockTest;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

public class IServiceQuestionnaireChargerListeQuestMock2 implements IServiceQuestionnaire {
    @Override
    public QuestionnaireDTO chargerListeQuest(String path) throws LienException {
        throw new LienException("");

    }

    @Override
    public QuestionDTO chargerUneQuestion(int idQuestion, int idQuestionnaire, QuestionnaireDTO q) throws NumTropGrandException {
        return null;
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
