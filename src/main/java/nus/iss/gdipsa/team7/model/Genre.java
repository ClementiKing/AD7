package nus.iss.gdipsa.team7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Genre {
	@Id
	private String name;
	
	@ManyToOne
	private Game game;
	
	@ManyToOne
	private User user;

	public Genre(String name) {
		super();
		this.name = name;
	}
	
}
