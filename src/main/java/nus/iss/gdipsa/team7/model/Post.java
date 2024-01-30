package nus.iss.gdipsa.team7.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance
@DiscriminatorColumn(name="Post_Type")
public abstract class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String message;
	
	private LocalDate dateCreated;
}
