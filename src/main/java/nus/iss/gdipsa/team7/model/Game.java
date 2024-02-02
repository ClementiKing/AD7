package nus.iss.gdipsa.team7.model;

import java.util.List;

import jakarta.persistence.*;
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

	@ManyToOne
	private Account developer;
	
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

	public Game(String title, String description,Account developer) {
		super();
		this.title = title;
		this.description = description;
		this.developer=developer;
	}
	
	
}
