package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

public interface IQuestionnaire {

    public QuestionnaireDTO chargerListeQuest(String path) throws LienException;
    public QuestionDTO chargerUneQuestion(int idQuestion, int idQuestionnaire,QuestionnaireDTO q) throws NumTropGrandException;
    public String majStatQuestion() throws NoStat;

    public String fournirStatsQuestion()throws NoStat;
}
