package nus.iss.gdipsa.team7.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;

public interface GameRepository extends JpaRepository<Game,Integer>{
	

	    @Query("SELECT g FROM Game g ORDER BY g.rating DESC")
	    List<Game> findTop10Games(Pageable pageable);
	    
	    @Query("SELECT g FROM Game g WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :title, '%'))")
	    List<Game> findByTitle(String title);

	    @Query("SELECT g FROM Game g WHERE g.gameStatus = :status")
	    List<Game> findByGameStatus(@Param("status") GameStatus gameStatus);

	    @Transactional
	    @Modifying
	    @Query("UPDATE Game g SET g.gameStatus = :status WHERE g.id = :gameId")
	    void updateGameStatus(@Param("gameId") Integer gameId, @Param("status") GameStatus gameStatus);

	    @Query("SELECT COUNT(g) FROM Game g WHERE g.gameStatus = :status")
		long countByPendingGames(@Param("status")GameStatus status);
	    
	    @Query("SELECT g FROM Game g WHERE g.title LIKE %:searchTerm% OR g.developer.username LIKE %:searchTerm%")
	    List<Game> searchByGameNameOrDeveloperName(@Param("searchTerm") String searchTerm);


}
