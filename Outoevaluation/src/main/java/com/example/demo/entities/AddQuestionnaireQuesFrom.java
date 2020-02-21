package com.example.demo.entities;

public class AddQuestionnaireQuesFrom {
private int QuestionnaireId;
private int OuestionsId;
private Iterable<Questions> Questions;
private Questionnaire Questionnaire;
public AddQuestionnaireQuesFrom(Iterable<com.example.demo.entities.Questions> questions,
		com.example.demo.entities.Questionnaire questionnaire) {
	
	
	Questions = questions;
	Questionnaire = questionnaire;
}
public AddQuestionnaireQuesFrom() {

}
public int getQuestionnaireId() {
	return QuestionnaireId;
}
public void setQuestionnaireId(int questionnaireId) {
	QuestionnaireId = questionnaireId;
}
public int getOuestionsId() {
	return OuestionsId;
}
public void setOuestionsId(int ouestionsId) {
	OuestionsId = ouestionsId;
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
}

}
