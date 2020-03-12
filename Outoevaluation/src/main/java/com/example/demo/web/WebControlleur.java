package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.From;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.ChoixRespositor;
import com.example.demo.dao.FonctionRespository;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.UserRespository;

import com.example.demo.dao.TypeRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.User;



import com.example.demo.entities.Type;
import com.example.demo.entities.Questions;

@Controller
public class WebControlleur {

@Autowired
	private ChoixRespositor choixRespositor;
	
	

@Autowired
private UserRespository UserRespository;

@Autowired
private FonctionRespository FonctionRespository;
@Autowired

private CategorieRespository CategorieRespository;
@Autowired
private TypeRespository TypeRespository;
@Autowired
private QuestionsRespository  questionsRespository;
@Autowired
private QuestionnaireRespository QuestionnaireRespository;




// User


@RequestMapping(value = { "/User/add" }, method = RequestMethod.GET)

 public String AddUser(Model model) {
	 model.addAttribute("User",new User() );
	
  ArrayList<Fonction> Fonction = (ArrayList<Fonction>) FonctionRespository.findAll();
  model.addAttribute("Fonction", Fonction);
 
  
	 return "AddUser";
	 }
	 

	 @RequestMapping(value="User/save", method=RequestMethod.POST)
	 public String saveUser(@Valid @ModelAttribute User p, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		 return "AddUser";
		 }
		UserRespository.save(p);
		
		return "redirect:/User/lister";
	 
	 }
	 
	 @RequestMapping("/User/lister")
	 public String listUser(Model model)
	 {
		 model.addAttribute("User", UserRespository.findAll());
		 
		 return "User";
	 }

	 
	 
	 @RequestMapping("User/update")
	 public String modifUser(Model model,int num) {
		 User p=UserRespository.findById(num).get();
		 model.addAttribute("User",p);
		 return "modifUser";
	 }
	 @RequestMapping(value="/User/modifier",method=RequestMethod.POST)
	 public String updateUser(@Valid @ModelAttribute User p,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
			 return "modifUser";
		 }
		 UserRespository.saveAndFlush(p);
		 return "redirect:/User/lister";
	 }
	 
	 
	 
	 @RequestMapping(value="/User/delete",method=RequestMethod.GET)
		public String deleteUser(User p, int num) {
		 UserRespository.deleteById(num);
			
			return "redirect:/User/lister";
		}
	 
	 
	 
	 
	 
	 
	 // Fonction 
	 
	
	 @RequestMapping("Fonction/add")
	 public String AddFonction(Model model) {
		 model.addAttribute("Fonction",new Fonction() );
		 
		 return "AddFonction";
		 }
		 

		 @RequestMapping(value="Fonction/save", method=RequestMethod.POST)
		 public String saveFonction(@Valid @ModelAttribute Fonction p, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "AddFonction";
			 }
			FonctionRespository.save(p);
			
			return "redirect:/Fonction/lister";
		 
		 }
		 
		 @RequestMapping("/Fonction/lister")
		 public String listFonction(Model model)
		 {
			 model.addAttribute("Fonction", FonctionRespository.findAll());
			 return "Fonction";
		 }
		 
		 
		 @RequestMapping("Fonction/update")
		 public String modifFonction(Model model,int num) {
			 Fonction p=FonctionRespository.findById(num).get();
			 model.addAttribute("Fonction",p);
			 return "modifFonction";
		 }
		 @RequestMapping(value="/Fonction/modifier",method=RequestMethod.POST)
		 public String updateFonction(@Valid @ModelAttribute Fonction p,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifFonction";
			 }
			 FonctionRespository.saveAndFlush(p);
			 return "redirect:/Fonction/lister";
		 }
		 
		 @RequestMapping(value="/Fonction/delete",method=RequestMethod.GET)
			public String deleteFonction(Fonction p, int num) {
			 FonctionRespository.deleteById(num);
				
				return "redirect:/Fonction/lister";
			}
		 
	 
	 
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
		 
		 }
		 
		 
		 
		 
		 @RequestMapping("/Categorie/lister")
		 public String listCategorie(Model model)
		 {
			 model.addAttribute("Categorie", CategorieRespository.findAll());
			 return "Categorie";
		 }
		 
		 
		
		 @RequestMapping("Categorie/update")
		 public String modifCategorie(Model model,int num) {
			 Categorie a=CategorieRespository.findById(num).get();
			 model.addAttribute("Categorie",a);
			 return "modifCategorie";
		 }
		 
		 
		 
		 @RequestMapping(value="/Categorie/modifier",method=RequestMethod.POST)
		 public String updateCategorie(@Valid @ModelAttribute Categorie a,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifCategorie";
			 }
			 CategorieRespository.saveAndFlush(a);
			 return "redirect:/Categorie/lister";
		 }
		 

		 
		 
		 
		 @RequestMapping(value="/Categorie/delete",method=RequestMethod.GET)
			public String deleteCategorie(Categorie a, int num) {
			 CategorieRespository.deleteById(num);
				
				return "redirect:/Categorie/lister";
			}
		 
		 
		 
		 
		 //Reponse
		 
	/*
		 @RequestMapping("Choixreponse/add")
		 public String crationChoixReponce(Model model) {
			 model.addAttribute("Choixreponse",new Choixreponse() );
			 
			 return "crationChoixReponce";
			 
			 }
			 

		 @RequestMapping(value="/Choixreponse/save", method=RequestMethod.POST)
		 public String saveReponsee(@Valid @ModelAttribute Choixreponse R, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "crationChoixReponce";
			 }
			choixRespositor.save(R);
			
			return "redirect:/Choixreponse/add";
		 
		 }
		*/
		 
		 
		 //Type
		 @RequestMapping("Type/add")
		 public String AddType(Model model) {
			 model.addAttribute("Type",new Type() );
			 
			 return "addType";
			 }
			 

			 @RequestMapping(value="Type/save", method=RequestMethod.POST)
			 public String saveType(@Valid @ModelAttribute Type p, BindingResult bindingResult) {
				if (bindingResult.hasErrors()) {
				 return "addType";
				 }
				 TypeRespository.save(p);
				
				return "redirect:/Type/lister";
			 
			 }
			 
			 @RequestMapping("/Type/lister")
			 public String listTypes(Model model)
			 {
				 model.addAttribute("Type", TypeRespository.findAll());
				 return "Types";
			 }
			 
			
			 @RequestMapping("Type/update")
			 public String modifType(Model model,int num) {
				 Type p=TypeRespository.findById(num).get();
				 model.addAttribute("Type",p);
				 return "modifType";
			 }
			 @RequestMapping(value="/Type/modifier",method=RequestMethod.POST)
			 public String updateType(@Valid @ModelAttribute Type p,BindingResult bindingResult) {
				 if(bindingResult.hasErrors()) {
					 return "modifType";
				 }
				 TypeRespository.saveAndFlush(p);
				 return "redirect:/Type/lister";
			 }
			 
			 
			 
			
					 
			 //Questions
			 
				
			 @RequestMapping(value= {"Questions/add"} ,  method = RequestMethod.GET)
			 public String addQuestions(Model model) {
				 model.addAttribute("Questions",new Questions() );
				 
				 
				 ArrayList<Type> Type = (ArrayList<Type>) TypeRespository.findAll();
				  model.addAttribute("Type", Type);
				 
				  
				  ArrayList<Categorie> Categorie = (ArrayList<Categorie>) CategorieRespository.findAll();
				  model.addAttribute("Categorie", Categorie);
				 
				 return "addQuestions";
				 }
				 

				 @RequestMapping(value="Questions/save", method=RequestMethod.POST)
				 public String saveQuestions(@Valid @ModelAttribute Questions q, BindingResult bindingResult) {
					if (bindingResult.hasErrors()) {
					 return "addQuestions";
					 }
					questionsRespository.save(q);
					
					return "redirect:/Questions/lister";
				 
				 }
				 
				 @RequestMapping("/Questions/lister")
				 public String listQuestions(Model model)
				 {
					 model.addAttribute("Questions", questionsRespository.findAll());
					 return "Questions";
				 }
				 
				
				 @RequestMapping("Questions/update")
				 public String modifQuestions(Model model,int num) {
					 Questions q=questionsRespository.findById(num).get();
					 model.addAttribute("Questions",q);
					 return "modifQuestions";
				 }
				 @RequestMapping(value="/Questions/modifier",method=RequestMethod.POST)
				 public String updateQuestions(@Valid @ModelAttribute Questions q,BindingResult bindingResult) {
					 if(bindingResult.hasErrors()) {
						 return "modifQuestions";
					 }
					 questionsRespository.saveAndFlush(q);
					 return "redirect:/Questions/lister";
				 }
				 
				 @RequestMapping(value="/Questions/delete",method=RequestMethod.GET)
					public String deleteQuestions(Questions q, int num) {
					 questionsRespository.deleteById(num);
						
						return "redirect:/Questions/lister";
					}
			 
		
				 
				 
				
				 @RequestMapping(value="/ChoixReponseQuestion/", method = RequestMethod.GET)
				 public String crationChoixReponce(Model model, int num) {
					
					 Questions q=questionsRespository.findById(num).get();
					 model.addAttribute("Questions",q);
					  
					 model.addAttribute("Choixreponse",new Choixreponse() );
					 return "crationChoixReponce";
				 }
				 
				 

				 @RequestMapping(value="Choixreponse/save/{num}", method=RequestMethod.POST)
				 public String saveReponse(@PathVariable("num") int questionsId,@Valid @ModelAttribute Choixreponse R, BindingResult bindingResult) {
					if (bindingResult.hasErrors()) {
					 return "crationChoixReponce";
					 }
					 Questions q=questionsRespository.findById(questionsId).get();
					R.setCh(q);
					choixRespositor.save(R);
					
					return "redirect:/Questions/lister";
				 
				 }

				 
				 
				 
				 
				 
				 
				 //QuestionnaireQuestions
				 
				 @RequestMapping("/Questionnaire")
					public String index(Model model) {
						List<Questionnaire> Questionnaire = (List<Questionnaire>) QuestionnaireRespository.findAll();
						model.addAttribute("Questionnaire", Questionnaire);
				    	return "Questionnaires";
				    }

				    @RequestMapping(value = "add")
				    public String addStudent(Model model){
				    	model.addAttribute("Questionnaire", new Questionnaire());
				        return "addQuestionnaire";
				    }	
					
				    @RequestMapping(value = "save", method = RequestMethod.POST)
				    public String save(Questionnaire Questionnaire){
				    	QuestionnaireRespository.save(Questionnaire);
				    	return "redirect:/Questionnaire";
				    }
				    
				    @RequestMapping(value = "/delete/{id_questionnaire}", method = RequestMethod.GET)
				    public String editRemoveEmployee(@PathVariable("id_questionnaire") int questionnaireId, Model model) {
				    	QuestionnaireRespository.deleteById(questionnaireId);
				        return "redirect:/Questionnaire";
				    }    
				 
				 
				 
				 @RequestMapping(value = "addQuestionnaireQuestions/{id}", method = RequestMethod.GET)
				    public String addQuestions(@PathVariable("id") int questionnaireId, Model model){
				    	model.addAttribute("Questionss", questionsRespository.findAll());
				    	
						model.addAttribute("Questionnaire", QuestionnaireRespository.findById(questionnaireId).get());
						model.addAttribute("Categorie",CategorieRespository.findAll());
						return "addQuestionnaireQuestions";
				    }
				    
				    
				    @RequestMapping(value="/Questionnaire/{id}/Questionss", method=RequestMethod.GET)
					public String QuestionnairesAddQuestions(@PathVariable int id, @RequestParam int QuestionsId, Model model) {
				    	Questions Questions = questionsRespository.findById(QuestionsId).get();
						Questionnaire Questionnaire = QuestionnaireRespository.findById(id).get();

						if (Questionnaire != null) {
							if (!Questionnaire.hasQuestions(Questions)) {
								Questionnaire.getQuestionss().add(Questions);
							}
							QuestionnaireRespository.save(Questionnaire);
							model.addAttribute("Questionnaire", QuestionnaireRespository.findById(id));
							model.addAttribute("Questionss", questionsRespository.findAll());
							return "redirect:/Questionnaire";
						}

						return "redirect:/Questionnaire";
					}    
				    
				    @RequestMapping(value = "getQuestionnaire", method = RequestMethod.GET)
				    public @ResponseBody List<Questionnaire> getQuestionnaire() {
				            return (List<Questionnaire>)QuestionnaireRespository.findAll();
				    }      
				 
				 
				 
		//UserQuestionnaire
				 
				 
				    @RequestMapping("/affUser")
					public String affUser(Model model) {
						List<User> User = (List<User>) UserRespository.findAll();
						model.addAttribute("User", User);
				    	return "affUser";
				    }

				
				 
				 @RequestMapping(value = "addUserQuestionnaire/{id}", method = RequestMethod.GET)
				    public String addQuestionnaire(@PathVariable("id") int UserId, Model model){
				    	model.addAttribute("Questionnaires", QuestionnaireRespository.findAll());
				    
						model.addAttribute("User", UserRespository.findById(UserId).get());
				    	return "addUserQuestionnaire";
				    }
				    
				
				
				 
				    @RequestMapping(value="/User/{id}/Questionnaires", method=RequestMethod.GET)
					public String UsersAddQuestionnaire(@PathVariable int id, @RequestParam int QuestionnaireId, Model model) {
				    	Questionnaire Questionnaire = QuestionnaireRespository.findById(QuestionnaireId).get();
				    	User User = UserRespository.findById(id).get();

						if (User != null) {
							if (!User.hasQuestionnaire(Questionnaire)) {
								User.getQuestionnaires().add(Questionnaire);
							}
							UserRespository.save(User);
							model.addAttribute("User", UserRespository.findById(id));
							model.addAttribute("Questionnaires", QuestionnaireRespository.findAll());
							return "redirect:/User/lister";
						}

						return "redirect:/User/lister";
					}    
				    
				    @RequestMapping(value = "getUser", method = RequestMethod.GET)
				    public @ResponseBody List<User> getUser() {
				            return (List<User>)UserRespository.findAll();
				    }      
				    
				    
				    
					 @RequestMapping(value = "UserQuestionnaire/{id}", method = RequestMethod.GET)
					    public String UserQuestionnaire(@PathVariable("id") int UserId, Model model){
					    	
						 model.addAttribute("Questionnaires", QuestionnaireRespository.findAll());
						 model.addAttribute("Questions", questionsRespository.findAll());
							model.addAttribute("Choixreponse", choixRespositor.findAll());
					
							model.addAttribute("User", UserRespository.findById(UserId).get());
							
					    	return "UserQuestionnaire";
					    }
					    @RequestMapping(value="/User/{id}/Reponses", method=RequestMethod.GET)
						public String UserReponses(@PathVariable int id, @RequestParam ArrayList <Integer> ReponseId, Model model) {
					    	List<Choixreponse> Choixreponse = choixRespositor.findAllById(ReponseId);
					    	User User = UserRespository.findById(id).get();

							if (User != null) {
								
								User.getReponses().addAll(Choixreponse);
								
								UserRespository.save(User);
								model.addAttribute("User", UserRespository.findById(id));
								model.addAttribute("Choixreponse", choixRespositor.findAll());
								return "redirect:/User/{id}/done";
							}

							return "redirect:/User/{id}/done";
						}  
						 @RequestMapping(value="/User/{id}/done",method=RequestMethod.GET)
						 public String doneUser(@PathVariable("id") int UserId, Model model) {
							 
							 User u=UserRespository.findById(UserId).get();
							 
							 model.addAttribute("User", u);
							 return "done";
						 }
				    
						 @RequestMapping(value = "UserReponses/{id}", method = RequestMethod.GET)
						    public String UserReponses(@PathVariable("id") int UserId, Model model){
						    	
							 model.addAttribute("Questionnaires", QuestionnaireRespository.findAll());
							 model.addAttribute("Questions", questionsRespository.findAll());
								model.addAttribute("Choixreponse", choixRespositor.findAll());
						
								model.addAttribute("User", UserRespository.findById(UserId).get());
								
						    	return "UserRepenses";
						    }
				    
				    
				 
				 
				 
}		 
				
				 
				 

