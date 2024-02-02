package nus.iss.gdipsa.team7.model;

import java.time.LocalDate;

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
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	private String title;
	
	private String message;
	
	private NotificationType type;
	
	private LocalDate date;
	
	@ManyToOne
	private User user;

	public Notification(String title, String message, NotificationType type, User user) {
		this.title = title;
		this.message = message;
		this.type = type;
		this.date = LocalDate.now();
		this.user = user;
	}
}
