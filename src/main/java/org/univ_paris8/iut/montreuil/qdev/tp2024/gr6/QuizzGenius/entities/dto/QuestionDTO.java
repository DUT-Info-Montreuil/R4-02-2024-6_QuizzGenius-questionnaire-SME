package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.entities.dto;

import java.util.Objects;

public class QuestionDTO {
    private int idQuestion;
    private int idQuestionnaire ;
    private Enum<Langue> langue;
    private String libelleQuestion;
    private String reponse;
    private int difficulte;
    private String explication;
    private String lienSource;

    public QuestionDTO(int idQuestion, int idQuestionnaire, Enum<Langue> langue, String libelleQuestion, String reponse, int difficulte, String explication, String lienSource) {
        this.idQuestion = idQuestion;
        this.idQuestionnaire = idQuestionnaire;
        this.langue = langue;
        this.libelleQuestion = libelleQuestion;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.lienSource = lienSource;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public Enum<Langue> getLangue() {
        return langue;
    }

    public String getLibelleQuestion() {
        return libelleQuestion;
    }

    public String getReponse() {
        return reponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getExplication() {
        return explication;
    }

    public String getLienSource() {
        return lienSource;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public void setLangue(Enum<Langue> langue) {
        this.langue = langue;
    }

    public void setLibelleQuestion(String libelleQuestion) {
        this.libelleQuestion = libelleQuestion;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public void setLienSource(String lienSource) {
        this.lienSource = lienSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return idQuestion == that.idQuestion && idQuestionnaire == that.idQuestionnaire;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, idQuestionnaire);
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "idQuestion=" + idQuestion +
                ", idQuestionnaire=" + idQuestionnaire +
                ", langue=" + langue +
                ", libelleQuestion='" + libelleQuestion + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                ", explication='" + explication + '\'' +
                ", lienSource='" + lienSource + '\'' +
                '}';
    }
}
