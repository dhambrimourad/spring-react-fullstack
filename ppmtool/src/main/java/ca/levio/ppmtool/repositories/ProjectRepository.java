package ca.levio.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.levio.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
