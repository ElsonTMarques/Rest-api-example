package com.ub.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ub.api.model.Team;
import com.ub.api.service.TeamService;

/**
 * The Class TeamResource.
 */
@RestController
@RequestMapping("/team")
public class TeamResource {

	/** The team service. */
	@Autowired
	private TeamService teamService;
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@GetMapping("/find-all")
	public List<Team> findAll() {
		return teamService.findAll();
	}
	
	/**
	 * Find all by query.
	 *
	 * @return the response entity
	 */
	@GetMapping("/find-all-query")
	public ResponseEntity<List<Team>> findAllByQuery() {
		List<Team> listTeam = teamService.findAllByQuery();
		return ResponseEntity.status(HttpStatus.OK).body(listTeam);
	}
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the response entity
	 */
	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<Team> findByName(final @PathVariable String name) {
		Team team = teamService.findByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(team);
	}
	
	/**
	 * Creates the new team.
	 *
	 * @param team the team
	 * @return the team
	 */
	@PostMapping("/insert-team")
	public Team createNewTeam(@Validated @RequestBody Team team) {
		return teamService.createNewTeam(team);
	}
	
	/**
	 * Update team.
	 *
	 * @param id the id
	 * @param team the team
	 * @return the team
	 */
	@PutMapping("/update/{id}/")
	public Team updateTeam(@PathVariable Long id, @Validated @RequestBody Team team) {
		return teamService.updateTeam(id, team);
	}
	
	/**
	 * Delete team.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/detele/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
		return teamService.removeTeam(id);
	}
}
