package ca.levio.ppmtool.services;

import org.springframework.stereotype.Service;

import ca.levio.ppmtool.domain.Project;

@Service
public interface ProjectService {

	public Project saveProject(Project project);
	public Project findProjectByIdentifier(String projectId);
	
}
