package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CategorieRespository;

import com.example.demo.dao.FonctionRespository;
import com.example.demo.dao.UserRespository;

import com.example.demo.dao.TypeRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.User;
import com.example.demo.entities.Type;
import com.example.demo.entities.Questions;

@Controller
public class WebControlleur {

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
			 
				
			 @RequestMapping("Questions/add")
			 public String addQuestions(Model model) {
				 model.addAttribute("Questions",new Questions() );
				 
				 return "addQuestions";
				 }
				 

				 @RequestMapping(value="Questions/save", method=RequestMethod.POST)
				 public String saveQuestions(@Valid @ModelAttribute Questions pk, BindingResult bindingResult) {
					if (bindingResult.hasErrors()) {
					 return "addQuestions";
					 }
					questionsRespository.save(pk);
					
					return "redirect:/Questions/lister";
				 
				 }
				 
				 @RequestMapping("/Questions/lister")
				 public String listQuestion(Model model)
				 {
					 model.addAttribute("Questions", questionsRespository.findAll());
					 return "Questions";
				 }
				 
				
				 @RequestMapping("Questions/update")
				 public String modifQuestions(Model model,int num) {
					 Questions pk=questionsRespository.findById(num).get();
					 model.addAttribute("Questions",pk);
					 return "modifQuestions";
				 }
				 @RequestMapping(value="/Questions/modifier",method=RequestMethod.POST)
				 public String updateQuestions(@Valid @ModelAttribute Questions pk,BindingResult bindingResult) {
					 if(bindingResult.hasErrors()) {
						 return "modifQuestions";
					 }
					 questionsRespository.saveAndFlush(pk);
					 return "redirect:/Questions/lister";
				 }
				 
				 @RequestMapping(value="/Questions/delete",method=RequestMethod.GET)
					public String deleteQuestions(Questions pk, int num) {
					 questionsRespository.deleteById(num);
						
						return "redirect:/Questions/lister";
					}
			 
			 
		
				 

}
