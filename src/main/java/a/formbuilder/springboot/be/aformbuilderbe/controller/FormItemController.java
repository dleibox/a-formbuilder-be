package a.formbuilder.springboot.be.aformbuilderbe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.formbuilder.springboot.be.aformbuilderbe.exception.FormItemNotFoundException;
import a.formbuilder.springboot.be.aformbuilderbe.model.FormItem;
import a.formbuilder.springboot.be.aformbuilderbe.model.FormItemRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FormItemController {

	@Autowired
	private FormItemRepository formItemRepository;

	@GetMapping("/formitems")
	public List<FormItem> retrieveAllFormItems() {
		return formItemRepository.findAll();
	}

//	Solution 1:
//	@GetMapping("/formitems/{id}")
//	public FormItem retrieveFormitem(@PathVariable(value="id") Long iid) throws FormItemNotFoundException  {
//		Optional<FormItem> item = formItemRepository.findById(iid);
//
//		if (!item.isPresent())
//			throw new FormItemNotFoundException("id-" + iid);
//
//		return item.get();
//	}
//	
//	@DeleteMapping("/formitems/{id}")
//	public void deleteFormitem(@PathVariable long id) {
//		formItemRepository.deleteById(id);
//	}
//
//	@PostMapping("/formitems")
//	public ResponseEntity<Object> createFormitem(@RequestBody FormItem item) {
//		FormItem savedFormitem = formItemRepository.save(item);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedFormitem.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
//	
//	@PutMapping("/formitems/{id}")
//	public ResponseEntity<Object> updateFormitem(@RequestBody FormItem student, @PathVariable long id) {
//
//		Optional<FormItem> studentOptional = formItemRepository.findById(id);
//
//		if (!studentOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		student.setId(id);
//		
//		formItemRepository.save(student);
//
//		return ResponseEntity.noContent().build();
//	}
	
	
//	Solution 2:	https://github.com/RameshMF/spring-boot2-jpa-crud-example
	@GetMapping("/formitems/{id}")
	public ResponseEntity<FormItem> getEmployeeById(@PathVariable(value = "id") Long iid)
			throws FormItemNotFoundException {
		FormItem item = formItemRepository.findById(iid)
				.orElseThrow(() -> new FormItemNotFoundException("Item not found for this id :: " + iid));
		return ResponseEntity.ok().body(item);
	}
	
	@PostMapping("/formitems")
	public FormItem createEmployee(@Valid @RequestBody FormItem employee) {
		return formItemRepository.save(employee);
	}

	@PutMapping("/formitems/{id}")
	public ResponseEntity<FormItem> updateEmployee(@PathVariable(value = "id") Long iid,
			@Valid @RequestBody FormItem details) throws FormItemNotFoundException {
		FormItem item = formItemRepository.findById(iid)
				.orElseThrow(() -> new FormItemNotFoundException("Item not found for this id :: " + iid));

		item.setName(details.getName());
		item.setJson(details.getJson());
		final FormItem updatedItem = formItemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}

	@DeleteMapping("/formitems/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long iid)
			throws FormItemNotFoundException {
		FormItem employee = formItemRepository.findById(iid)
				.orElseThrow(() -> new FormItemNotFoundException("Item not found for this id :: " + iid));

		formItemRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}