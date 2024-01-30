package nus.iss.gdipsa.team7.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Review")
public class ReviewPost extends GamePost{
	private ReviewPostType type;

}
