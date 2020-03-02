package com.example.demo.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.AddQuestionnaireQuesFrom;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Type;

@Controller
@RequestMapping(value="Questionnaire")
public class QuestionnaireControlleur {
	@Autowired
	private QuestionsRespository  questionsRespository;
	@Autowired
	private QuestionnaireRespository QuestionnaireRespository;
	// User
				// Questionnaire Controller
					 @RequestMapping(value="")
					 public String index(Model model) { 

					 model.addAttribute("Questionnaire",QuestionnaireRespository.findAll());
				
					 return "Questionnaire/index";
					 }
					 
					
					 
					 
					 @RequestMapping(value="add"  ,  method = RequestMethod.GET)
					 public String add(Model model) {
						
						 model.addAttribute("Questionnaire",new Questionnaire() );
						
						 return "Questionnaire/add";
						 }
			
	
					 @RequestMapping(value="save", method=RequestMethod.POST)
					 public String add(@Valid @ModelAttribute Questionnaire Questionnaire, BindingResult bindingResult) {
						if (bindingResult.hasErrors()) {
							 
						 return "Questionnaire/add";
						 }
						QuestionnaireRespository.save(Questionnaire);
						
						return "redirect:view/" + Questionnaire.getId_questionnaire();
					 
					 }
					 
					 
					
					 
					 
					 @RequestMapping(value= "view/{QuestionnaireId}" ,  method = RequestMethod.GET)
					 public String viewQuestionnaire(Model model,@PathVariable int QuestionnaireId) {
					 Questionnaire Questionnaire=QuestionnaireRespository.findById(QuestionnaireId).get();

					 model.addAttribute("Questionnaire",QuestionnaireRespository.findAll());
					 model.addAttribute("Questions",Questionnaire.getQuestions());
					 model.addAttribute("QuestionnaireId",Questionnaire.getId_questionnaire());
					 ArrayList<Questions>Question= (ArrayList<Questions>) questionsRespository.findAll();
					  model.addAttribute("Q", Question );
						
							AddQuestionnaireQuesFrom from = new AddQuestionnaireQuesFrom(
									questionsRespository.findAll(),Questionnaire);
							
							model.addAttribute("from", from);
							
					 return"Questionnaire/view";
					 }
					 
					 
					 
					 
					 
					 
					 @RequestMapping(value ="/add-Ques/{QuestionnaireId}" ,  method = RequestMethod.GET)
					 
					 public String addQues(Model model,@PathVariable int QuestionnaireId) {
						
						 ArrayList<Questions>Questions= (ArrayList<Questions>) questionsRespository.findAll();
						  model.addAttribute("Q", Questions );
						 
						 Questionnaire Questionnaire=QuestionnaireRespository.findById(QuestionnaireId).get();
					AddQuestionnaireQuesFrom from = new AddQuestionnaireQuesFrom(
							questionsRespository.findAll(),Questionnaire);
					
					model.addAttribute("from", from);
					
						 return"Questionnaire/add-Ques";
						 
						 
						 }
					 
					 @RequestMapping(value ="/from/save" ,  method = RequestMethod.POST)
					 
					 public String AddQuestionnaireQuesFrom(Model model,@Valid @ModelAttribute AddQuestionnaireQuesFrom AddQuestionnaireQuesFrom, BindingResult bindingResult) {
						 if (bindingResult.hasErrors()) {
								model.addAttribute("AddQuestionnaireQuesFrom",AddQuestionnaireQuesFrom); 
							 return "Questionnaire/view";
							 }
							Questions theQuestion= questionsRespository.findById(AddQuestionnaireQuesFrom.getQuestionsId()).get();
							Questionnaire theQuestionnaire=QuestionnaireRespository.findById(AddQuestionnaireQuesFrom.getQuestionnaireId()).get();
							 theQuestionnaire.addQues(theQuestion);
							QuestionnaireRespository.save(theQuestionnaire);
							
							 return"redirect:/Questionnaire/view"+theQuestionnaire.getId_questionnaire();
						 }
					 
	/* @RequestMapping(value ="/from/save" ,  method = RequestMethod.POST)
					 
	 
	 public String addQues(Model model,@Valid @ModelAttribute AddQuestionnaireQuesFrom from, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("form",from);
			
		 return "Questionnaire/add-Ques";
		 
		}
	
		 Questions theQuestion= questionsRespository.findById(from.getOuestionsId()).get();
		 Questionnaire theQuestionnaire=QuestionnaireRespository.findById(from.getQuestionnaireId()).get();
		 theQuestionnaire.addQues(theQuestion);
		 QuestionnaireRespository.save(theQuestionnaire);
		 return"redirect:/Questionnaire/view"+theQuestionnaire.getId_questionnaire();
	 }
*/
					 /*
	
	 @RequestMapping(value="addQQ", method=RequestMethod.POST)
	 public String addQQ(Model model,@Valid @ModelAttribute AddQuestionnaireQuesFrom from, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("from",from); 
		 return "Questionnaire/view";
		 }
		Questions theQuestion= questionsRespository.findById(from.getQuestionsId()).get();
		Questionnaire theQuestionnaire=QuestionnaireRespository.findById(from.getQuestionnaireId()).get();
		 theQuestionnaire.addQues(theQuestion);
		QuestionnaireRespository.save(theQuestionnaire);
		
		 return"redirect:/Questionnaire/view"+theQuestionnaire.getId_questionnaire();
	 */
	
	 /* @RequestMapping(value="addQQ"  ,  method = RequestMethod.GET)
	 public String add(Model model) {
		
		 model.addAttribute("Questionnaire",new Questionnaire() );
		
		 return "Questionnaire/add";
		 }*/
	 
	 
	 
}
