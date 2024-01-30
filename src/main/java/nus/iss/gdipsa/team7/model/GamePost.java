package nus.iss.gdipsa.team7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public abstract class GamePost extends Post{
	@ManyToOne
	private Game game;
}
