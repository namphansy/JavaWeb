package psn.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private ModelAndView checkError2(ResourceNotFoundException ex) {
		
		ModelAndView mavError = new ModelAndView("error");
		mavError.addObject("message", ex.getMessage());
		return mavError;
	}
}
