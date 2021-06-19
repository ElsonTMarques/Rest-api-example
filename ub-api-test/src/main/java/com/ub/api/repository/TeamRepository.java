package com.ub.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ub.api.model.Team;

/**
 * The Interface CategoryRepository.
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

	/**
	 * Find By Name Ignore Case.
	 *
	 * @return the optional
	 */
	Optional<Team> findByNameIgnoreCase(String name);
	
	/**
	 * Find all by query.
	 *
	 * @return the optional
	 */
	@Query("select t from Team t")
	Optional<List<Team>> findAllByQuery();
}
