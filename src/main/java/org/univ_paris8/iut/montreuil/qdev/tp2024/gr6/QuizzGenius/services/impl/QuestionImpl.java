package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.services.interfaces.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Enum.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.LienException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NoStat;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions.NumTropGrandException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class QuestionImpl implements IServiceQuestionnaire {
    @Override
    public QuestionnaireDTO chargerListeQuest(String path) throws LienException {
        QuestionnaireDTO questionnaire;
        List<QuestionDTO> listeQuestion=new ArrayList<>();
         try (BufferedReader br = new BufferedReader(new FileReader(path))){
             String line;
             while((line=br.readLine())!=null){
                 QuestionDTO  q ;
                 String[] values = line.split(";");
                 q= new QuestionDTO(1,parseInt(values[1]), Langue.valueOf(values[2]),values[3],values[4],parseInt(values[5]),values[6],values[7]);
                 listeQuestion.add(q);
             }
         }
         catch (LienException e) {
             throw new LienException("lien non trouvé");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         questionnaire = new QuestionnaireDTO(listeQuestion,1);
        return null;

    }

    public static void main(String[] args) throws LienException {
        QuestionImpl q = new QuestionImpl();
        q.chargerListeQuest("src/main/java/org/univ_paris8/iut/montreuil/qdev/tp2024/gr6/QuizzGenius/ressources/questionsQuizz_V1.1.csv");
    }



    @Override
    public QuestionDTO chargerUneQuestion(int idQuestion, int idQuestionnaire,QuestionnaireDTO q) throws NumTropGrandException {
        for (QuestionDTO question : q.getQuestions()) {
            if (question.getIdQuestion() == idQuestion && question.getIdQuestionnaire() == idQuestionnaire) {
                return question;
            }
        }
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
