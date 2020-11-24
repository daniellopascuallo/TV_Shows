package com.pinback.beltexamdaniel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinback.beltexamdaniel.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	@Query(value="SELECT * FROM reviews WHERE user_id = ?1 AND show_id = ?2", nativeQuery=true)
	List<Review> matchingReviews(Long user_id, Long show_id);
}
