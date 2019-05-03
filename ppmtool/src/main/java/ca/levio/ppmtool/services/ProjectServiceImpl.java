package ca.levio.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.levio.ppmtool.domain.Project;
import ca.levio.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	
	
}
