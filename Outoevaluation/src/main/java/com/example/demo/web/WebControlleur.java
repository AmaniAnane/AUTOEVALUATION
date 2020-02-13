package com.example.demo.web;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.PersonnelsRespository;

import com.example.demo.dao.TypeRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.Categorie;

import com.example.demo.entities.Personnels;
import com.example.demo.entities.Type;
import com.example.demo.entities.Questions;

@Controller
public class WebControlleur {

@Autowired
private PersonnelsRespository PersonnelsRespository;
@Autowired
private CategorieRespository CategorieRespository;
@Autowired
private TypeRespository TypeRespository;
@Autowired
private QuestionsRespository  questionsRespository;

@RequestMapping("Personnels/add")
 public String AddPersonnels(Model model) {
	 model.addAttribute("Personnels",new Personnels() );
	 
	 return "AddPersonnels";
	 }
	 

	 @RequestMapping(value="Personnels/save", method=RequestMethod.POST)
	 public String savePersonnels(@Valid @ModelAttribute Personnels p, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		 return "AddPersonnels";
		 }
		PersonnelsRespository.save(p);
		
		return "redirect:/Personnels/lister";
	 
	 }
	 
	 @RequestMapping("/Personnels/lister")
	 public String listPersonnels(Model model)
	 {
		 model.addAttribute("Personnels", PersonnelsRespository.findAll());
		 return "Personnels";
	 }
	 
	 
	 @RequestMapping("Personnels/update")
	 public String modifPersonnels(Model model,int num) {
		 Personnels p=PersonnelsRespository.findById(num).get();
		 model.addAttribute("Personnels",p);
		 return "modifPersonnels";
	 }
	 @RequestMapping(value="/Personnels/modifier",method=RequestMethod.POST)
	 public String updatePersonnels(@Valid @ModelAttribute Personnels p,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
			 return "modifPersonnels";
		 }
		 PersonnelsRespository.saveAndFlush(p);
		 return "redirect:/Personnels/lister";
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/Personnels/delete",method=RequestMethod.GET)
		public String deletePersonnels(Personnels p, int num) {
		 PersonnelsRespository.deleteById(num);
			
			return "redirect:/Personnels/lister";
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
