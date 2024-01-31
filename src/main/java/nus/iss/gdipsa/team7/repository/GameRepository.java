package nus.iss.gdipsa.team7.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.gdipsa.team7.model.Game;

public interface GameRepository extends JpaRepository<Game,Integer>{
	

	    @Query("SELECT g FROM Game g ORDER BY g.rating DESC")
	    List<Game> findTop10Games(Pageable pageable);
	    
	    @Query("SELECT g FROM Game g WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :title, '%'))")
	    List<Game> findByTitle(String title);

	    @Query("SELECT g FROM Game g WHERE g.isApproved = false")
	    List<Game> findGamesPendingApproval();

	    @Transactional
	    @Modifying
	    @Query("UPDATE Game g SET g.isApproved = true WHERE g.id = :gameId")
	    void approveGame(@Param("gameId") Integer gameId);

	    @Transactional
	    @Modifying
	    @Query("UPDATE Game g SET g.isApproved = false WHERE g.id = :gameId")
	    void rejectGame(@Param("gameId") Integer gameId);
}
