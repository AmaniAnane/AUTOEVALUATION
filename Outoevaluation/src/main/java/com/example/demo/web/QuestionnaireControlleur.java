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
					 /*
					 
					 @RequestMapping("Categorie/add")
					 public String AddCategorie(Model model) {
						 model.addAttribute("Categorie",new Categorie() );
						 
						 return "AddCategorie";
						 }
						 
				  
					 
						 @RequestMapping(value="Categorie/save", method=RequestMethod.POST)
						 public String saveCategorie(@Valid @ModelAttribute Categorie a, BindingResult bindingResult) {
							if (bindingResult.hasErrors()) {
							 return "AddCategorie";
							 }
							CategorieRespository.save(a);
							
							return "redirect:/Categorie/lister";
						 
						 }*/
	
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
					 
					 return"Questionnaire/view";
					 }
					 
					 
					 
					 
					 
					 
					 
					 @RequestMapping(value ="add-Ques/{QuestionnaireId}" ,  method = RequestMethod.GET)
					 
					 public String addQues(Model model,@PathVariable int QuestionnaireId) {
						 Questionnaire Questionnaire=QuestionnaireRespository.findById(QuestionnaireId).get();
					AddQuestionnaireQuesFrom from = new AddQuestionnaireQuesFrom(
							questionsRespository.findAll(),Questionnaire);
					
					model.addAttribute("Questionnaire",QuestionnaireRespository.findAll());
					model.addAttribute("form", from);
					
						 return"Questionnaire/add-Ques";
						 }
	 @RequestMapping(value ="add-Ques" ,  method = RequestMethod.POST)
					 
	 
	 public String addQues(@Valid @ModelAttribute AddQuestionnaireQuesFrom from, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		 return "Questionnaire/add-Ques";
		 
		}
	
		 Questions theQuestion= questionsRespository.findById(from.getOuestionsId()).get();
		 Questionnaire theQuestionnaire=QuestionnaireRespository.findById(from.getQuestionnaireId()).get();
		 theQuestionnaire.addQues(theQuestion);
		 QuestionnaireRespository.save(theQuestionnaire);
		 return"redirect:/Questionnaire/view"+theQuestionnaire.getId_questionnaire();
	 }

	
	
}
