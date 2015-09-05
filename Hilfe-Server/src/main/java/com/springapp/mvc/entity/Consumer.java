/**
 * 
 */
package com.springapp.mvc.entity;

import java.io.Serializable;

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
@Table(name = "consumer")
public class Consumer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "rating")
	private Float rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
