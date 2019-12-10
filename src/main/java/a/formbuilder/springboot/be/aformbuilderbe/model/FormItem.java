package a.formbuilder.springboot.be.aformbuilderbe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "form_item")
public class FormItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String json;
	
	public FormItem() {
		super();
	}

	public FormItem(String name, String json) {
		super();
//		this.id = id;
		this.name = name;
		this.json = json;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@JsonIgnore
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
		
}