package a.formbuilder.springboot.be.aformbuilderbe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FormItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public FormItemNotFoundException(String message) {
		super(message);
	}

}
