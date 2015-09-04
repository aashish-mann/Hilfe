/**
 * 
 */
package com.springapp.mvc.sro;

import java.util.List;

/**
 * @author rahul
 *
 */
public class CategoryFilterSRO {

	private String name;

	List<Integer> values;

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
