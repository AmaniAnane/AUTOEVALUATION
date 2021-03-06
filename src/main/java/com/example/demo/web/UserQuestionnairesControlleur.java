package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ChoixRespositor;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.dao.UserRespository;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.User;

public class UserQuestionnairesControlleur {


@Autowired
	private ChoixRespositor choixRespositor;
	
	

@Autowired
private UserRespository UserRespository;

@Autowired
private QuestionsRespository  questionsRespository;
@Autowired
private QuestionnaireRespository QuestionnaireRespository;
	
	 
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
 @RequestMapping(value ="ReponduUser/{id}", method = RequestMethod.GET)
 public String Repondu(@PathVariable("id") int UserId, Model model) {
	 model.addAttribute("User", UserRespository.findById(UserId).get());
	 
	
	 return "UserRepenses";
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
}
