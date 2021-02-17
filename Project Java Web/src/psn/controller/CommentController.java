package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Comment;
import psn.model.service.CommentService;

@Controller
//@RequestMapping(value = "/commentController")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/adminGetAllComment.htm")
	private ModelAndView getAllComment() {
		ModelAndView mav = new ModelAndView("listAllComment");
		List<Comment> listComment = commentService.listComment();
		mav.addObject("listComment", listComment);
		return mav;
	}
	
	@RequestMapping(value = "/removeComment.htm")
	private String remove(int commentId) {
		boolean check = commentService.remove(commentId);
		if(check) {
			return "redirect:adminGetAllComment.htm";
		}
		return "error";
	}
	
	@RequestMapping(value = "/updateStatusComment.htm", method = RequestMethod.GET)
	private String updateStatusComment(int commentId) {
		Comment updateComment = commentService.findById(commentId);
		boolean check = commentService.updateStatus(updateComment);
		if(check == true) {
			return "redirect:adminGetAllComment.htm";
		}
		return "error";
	}
}
