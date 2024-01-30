package nus.iss.gdipsa.team7.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserActivity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Activity type;
	
	private String message;
	
	private LocalDate date;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="useractivity")
	private List<UserPost> userPosts;


}
