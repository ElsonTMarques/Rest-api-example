package com.ub.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ub.api.model.Team;
import com.ub.api.repository.TeamRepository;

/**
 * The Class TeamService.
 */
@Service
public class TeamService {

	/** The team repository. */
	private final TeamRepository teamRepository;

	/**
	 * Instantiates a new team service.
	 *
	 * @param teamRepository the team repository
	 */
	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Team> findAll() {
		return teamRepository.findAll();
	}
	
	/**
	 * Find all by query.
	 *
	 * @return the list
	 */
	public List<Team> findAllByQuery() {
		Optional<List<Team>> listTeam = teamRepository.findAllByQuery();
		return listTeam.isPresent() ? listTeam.get() : new ArrayList<>();
	}
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the team
	 */
	public Team findByName(String name) {
		Optional<Team> team = teamRepository.findByNameIgnoreCase(name);
		//return Optional.ofNullable(team);
		return team.isPresent() ? team.get() : new Team();
	}
	
	/**
	 * Creates the new team.
	 *
	 * @param team the team
	 * @return the team
	 */
	public Team createNewTeam(Team team) {
		return teamRepository.save(team);
	}
	
	/**
	 * Update team.
	 * @param id
	 * @param team
	 * @return
	 */
	public Team updateTeam(Long id, Team team) {
		Team savedTeam = teamRepository.getById(id);
		BeanUtils.copyProperties(team, savedTeam, "id");
		return teamRepository.save(savedTeam);
	}
	
	/**
	 * Removes the team.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	public ResponseEntity<String> removeTeam(Long id) {
		Optional<Team> team = Optional.of(teamRepository.getById(id));
		if (team.isPresent()) {
			teamRepository.delete(team.get());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Team: "+ team.get().getName() + 
					" id: "+ team.get().getId() + " deleted.");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unfound team");
		}
	}
	
}
