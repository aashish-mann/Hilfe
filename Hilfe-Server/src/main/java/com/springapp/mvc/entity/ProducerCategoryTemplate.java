/**
 * 
 */
package com.springapp.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rahul
 *
 */
@Entity
@Table(name = "Producer_category_template")
public class ProducerCategoryTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "producer_id")
	private Long producerId;

	@Column(name = "category_template_id")
	private Long categoryTemplateId;

	@Column(name = "value")
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProducerId() {
		return producerId;
	}

	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}

	public Long getCategoryTemplateId() {
		return categoryTemplateId;
	}

	public void setCategoryTemplateId(Long categoryTemplateId) {
		this.categoryTemplateId = categoryTemplateId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
