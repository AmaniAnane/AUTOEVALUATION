package com.example.demo.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AddQuestionnaireQuesFrom {
	public int QuestionnaireId;
public int QuestionsId;

public Iterable<Questions> Questions;
public Questionnaire Questionnaire;
public AddQuestionnaireQuesFrom(Iterable<com.example.demo.entities.Questions> questions,
		com.example.demo.entities.Questionnaire questionnaire) {
	


}
public int getQuestionnaireId() {
	return QuestionnaireId;
}
public void setQuestionnaireId(int questionnaireId) {
	QuestionnaireId = questionnaireId;
}
public int getQuestionsId() {
	return QuestionsId;
}
public void setQuestionsId(int questionsId) {
	QuestionsId = questionsId;
}
public Iterable<Questions> getQuestions() {
	return Questions;
}
public void setQuestions(Iterable<Questions> questions) {
	Questions = questions;
}
public Questionnaire getQuestionnaire() {
	return Questionnaire;
}
public void setQuestionnaire(Questionnaire questionnaire) {
	Questionnaire = questionnaire;
}}
