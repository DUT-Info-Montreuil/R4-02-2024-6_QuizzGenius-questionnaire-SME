package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto;

import java.util.List;
import java.util.Objects;

public class QuestionnaireDTO {
    private int idQuestionnaire;
    private List<QuestionDTO> questions ;

    public QuestionnaireDTO(List<QuestionDTO> questions,int idQuestionnaire) {
        this.questions = questions;
        this.idQuestionnaire= idQuestionnaire;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return idQuestionnaire == that.idQuestionnaire;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire);
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", questions=" + questions +
                '}';
    }
}
