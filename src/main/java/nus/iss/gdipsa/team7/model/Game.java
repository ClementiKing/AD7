package nus.iss.gdipsa.team7.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	private int rating;
	
//	private boolean isApproved;
	
	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus = GameStatus.Pending;
	
	@ManyToMany(mappedBy="favourites")
	private List<User> usersFavourite;
	
	@ManyToMany(mappedBy="wishlist")
	private List<User> usersWish;
	
	@ManyToMany(mappedBy="followGames")
	private List<User> usersFollow;
	
	@OneToMany(mappedBy="game")
	private List<GamePost> posts;
	
	@OneToMany(mappedBy="game")
	private List<Genre> genres;
	
	@ManyToOne
	private GameList gamelist;

	public Game(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	
}
