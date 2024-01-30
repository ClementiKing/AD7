package nus.iss.gdipsa.team7.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("User")
public class UserPost extends Post{
	
	@ManyToOne
	private UserActivity useractivity;
}
