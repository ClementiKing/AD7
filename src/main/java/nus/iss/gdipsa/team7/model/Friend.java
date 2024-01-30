package nus.iss.gdipsa.team7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private FriendActivityStatus status;
	
	@ManyToOne
	private User user;

	
}
