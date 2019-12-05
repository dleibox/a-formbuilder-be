package a.formbuilder.springboot.be.aformbuilderbe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import a.formbuilder.springboot.be.aformbuilderbe.exception.FormItemNotFoundException;
import a.formbuilder.springboot.be.aformbuilderbe.model.FormItem;
import a.formbuilder.springboot.be.aformbuilderbe.model.FormItemRepository;

@CrossOrigin
@RestController
public class FormItemController {

	@Autowired
	private FormItemRepository formItemRepository;

	@GetMapping("/formitems")
	public List<FormItem> retrieveAllFormItems() {
		return formItemRepository.findAll();
	}

	@GetMapping("/formitems/{id}")
	public FormItem retrieveFormitem(@PathVariable long id) throws Exception  {
		Optional<FormItem> student = formItemRepository.findById(id);

		if (!student.isPresent())
			throw new FormItemNotFoundException("id-" + id);

		return student.get();
	}

	@DeleteMapping("/formitems/{id}")
	public void deleteFormitem(@PathVariable long id) {
		formItemRepository.deleteById(id);
	}

	@PostMapping("/formitems")
	public ResponseEntity<Object> createFormitem(@RequestBody FormItem item) {
		FormItem savedFormitem = formItemRepository.save(item);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedFormitem.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/formitems/{id}")
	public ResponseEntity<Object> updateFormitem(@RequestBody FormItem student, @PathVariable long id) {

		Optional<FormItem> studentOptional = formItemRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		formItemRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}