package com.pinback.beltexamdaniel.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pinback.beltexamdaniel.models.Review;
import com.pinback.beltexamdaniel.models.Show;
import com.pinback.beltexamdaniel.models.User;
import com.pinback.beltexamdaniel.services.ShowService;

@Controller
public class ShowController {

	private final ShowService showServ;

	public ShowController(ShowService showServ) {
		this.showServ = showServ;
	}

	@GetMapping("/shows")
	public String shows(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("allShows", showServ.getShows());
		return "shows.jsp";
	}

	@GetMapping("/shows/new")
	public String newShow(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("newShow", new Show());
		return "create.jsp";
	}

	@PostMapping("/shows/new")
	public String createShow(@Valid @ModelAttribute("newShow") Show newShow, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			User loggedInUser = (User) session.getAttribute("user");
			newShow.setUser(loggedInUser);
			showServ.create(newShow);
			return "redirect:/shows";
		}
	}

	@GetMapping("/shows/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("show", showServ.getShow(id));
		model.addAttribute("newReview", new Review());
		return "show.jsp";
	}

	@PostMapping("/shows/{id}")
	public String reviewShow(@Valid @ModelAttribute("newReview") Review newReview, BindingResult result,
			@PathVariable("id") Long id, HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("show", showServ.getShow(id));
			return "show.jsp";
		} else {
			newReview.setShow(showServ.getShow(id));
			newReview.setUser(loggedInUser);
			Review r = showServ.create(newReview);
			if (r == null) {
				result.rejectValue("rating", "Unique", "You have already rated this show");
				model.addAttribute("show", showServ.getShow(id));
				return "show.jsp";
			}
			showServ.create(newReview);
			return "redirect:/shows";
		}
	}

	@GetMapping("/shows/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("show", showServ.getShow(id));
		model.addAttribute("editShow", showServ.getShow(id));
		return "edit.jsp";
	}

	@PostMapping("/shows/{id}/update")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editShow") Show editShow,
			BindingResult result, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("show", showServ.getShow(id));
			return "edit.jsp";
		} else {
			editShow.setUser(loggedInUser);
			showServ.updateShow(editShow, id);
			return "redirect:/shows";
		}
	}

	@GetMapping("/shows/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		showServ.deleteShow(id);
		return "redirect:/shows";
	}

}
