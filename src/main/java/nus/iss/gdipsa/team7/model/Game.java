package nus.iss.gdipsa.team7.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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

	public Game(String title, String description, Account developer, List<Genre> genre) {
		super();
		this.title = title;
		this.description = description;
		this.developer=developer;
		this.genres=genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Account getDeveloper() {
		return developer;
	}

	public void setDeveloper(Account developer) {
		this.developer = developer;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public List<User> getUsersFavourite() {
		return usersFavourite;
	}

	public void setUsersFavourite(List<User> usersFavourite) {
		this.usersFavourite = usersFavourite;
	}

	public List<User> getUsersWish() {
		return usersWish;
	}

	public void setUsersWish(List<User> usersWish) {
		this.usersWish = usersWish;
	}

	public List<User> getUsersFollow() {
		return usersFollow;
	}

	public void setUsersFollow(List<User> usersFollow) {
		this.usersFollow = usersFollow;
	}

	public List<GamePost> getPosts() {
		return posts;
	}

	public void setPosts(List<GamePost> posts) {
		this.posts = posts;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public GameList getGamelist() {
		return gamelist;
	}

	public void setGamelist(GameList gamelist) {
		this.gamelist = gamelist;
	}

	
}
