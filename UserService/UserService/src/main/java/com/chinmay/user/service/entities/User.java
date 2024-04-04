package com.chinmay.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_users")
public class User {

	@Id
	@Column(name ="ID")
	private String userId;

	@Column(name ="NAME" , length=20)
	private String name;

	@Column(name ="EMAIL")
	private String email;

	@Column(name ="ABOUT")
	private String about;

	@Transient          // this is for that this ratings should not be saved in database , so JPA will ignore it
	private List<Rating> ratings = new ArrayList<>();

}
