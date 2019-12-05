package a.formbuilder.springboot.be.aformbuilderbe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FormItem {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String json;
	
	public FormItem() {
		super();
	}

	public FormItem(Long id, String name, String json) {
		super();
		this.id = id;
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
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
		
}