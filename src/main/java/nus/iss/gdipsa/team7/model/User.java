package nus.iss.gdipsa.team7.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalDate dateCreated;
	
	private String bio;
	
	private boolean publicity;

//	@OneToOne(mappedBy="user")
//	private Account account;
	
	@OneToMany(mappedBy="user")
	private List<Genre> prefers;
	
	@ManyToMany
	@JoinTable(
		name = "user_favourites",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "game_id")
	)
	private List<Game> favourites;
	
	
	@ManyToMany
	@JoinTable(
	    name = "user_wishlist",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "game_id")
    )
	private List<Game> wishlist;
	
	@ManyToMany
	@JoinTable(
	    name = "user_followGames",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )
	private List<Game> followGames;
	
	@OneToMany(mappedBy="user")
	private List<Friend> friends;
	
	@OneToMany(mappedBy="user")
	private List<UserActivity> userActivities;
	
	@OneToMany(mappedBy="user")
	private List<Notification> notifications;
	
	@OneToMany(mappedBy="user")
	private List<BanRequest> banRequests;
	
	@OneToMany(mappedBy="user")
	private List<GameList> gamelists;
	
	@ManyToOne
	private User owner;

	@OneToMany(mappedBy="owner")
	private List<User> followers;


	public User(String bio, boolean publicity) {
		this.dateCreated = LocalDate.now();
		this.bio = bio;
		this.publicity = publicity;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", bio='" + bio + '\'' +
                ", publicity=" + publicity +
                ", followersIds=" + (followers != null ? followers.stream().map(User::getId).collect(Collectors.toList()) : null) +
                ", notificationsIds=" + (notifications != null ? notifications.stream().map(Notification::getId).collect(Collectors.toList()) : null) +
                '}';
    }
}
