package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Blog;
import psn.model.service.BlogService;

@Controller
//@RequestMapping(value = "/blogController")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	/*-------- Lấy toàn bộ Blog ----------------*/
	@RequestMapping(value = "/adminGetAllBlog.htm")
	private ModelAndView listAllBlog() {
		ModelAndView mav = new ModelAndView("listAllBlog");
		List<Blog> listBlog = blogService.listBlog();
		mav.addObject("listBlog", listBlog);
		return mav;
	}
	
	/*------- Thêm Blog ----------------------*/
	@RequestMapping(value = "/adminInitSaveBlog.htm")
	private ModelAndView initSaveBlog() {
		ModelAndView mav = new ModelAndView("saveNewBlog");
		Blog newBlog = new Blog();
		mav.addObject("newBlog", newBlog);
		return mav;	
	}
	
	@RequestMapping(value = "/saveBlog.htm", method = RequestMethod.POST)
	private String saveBlog(Blog blog) {
		boolean check = blogService.save(blog);
		if(check) {
			return "redirect:adminGetAllBlog.htm";
		} else return "error";
	}
	
	/*---------- Cập nhật Blog ----------------*/
	@RequestMapping(value = "/adminInitUpdateBlog.htm")
	private ModelAndView initUpdateBlog(int blogId) {
		ModelAndView mav = new ModelAndView("updateBlog");
		Blog updateBlog = blogService.findById(blogId);
		mav.addObject("updateBlog", updateBlog);
		return mav;
	}
	
	@RequestMapping(value = "/updateBlog.htm", method = RequestMethod.POST)
	private String updateBlog(Blog blog) {
		boolean check = blogService.merge(blog);
		if(check) {
			return "redirect:adminGetAllBlog.htm";
		}
		return "error";
	}
	
	/*--------- Xóa Blog ----------------------*/
	@RequestMapping(value = "/removeBlog.htm")
	private String remove(int blogId) {
		boolean check = blogService.remove(blogId);
		if(check) {
			return "redirect:adminGetAllBlog.htm";
		}
		return "error";
	}
}
