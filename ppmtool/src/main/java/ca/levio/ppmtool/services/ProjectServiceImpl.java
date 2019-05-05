package ca.levio.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.levio.ppmtool.domain.Project;
import ca.levio.ppmtool.exceptions.ProjectIdException;
import ca.levio.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch(Exception ex) {
			throw new ProjectIdException("Project ID: '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
		}
	}
	
	@Override
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if (project == null) {
			throw new ProjectIdException("Project ID: '"+projectId.toUpperCase()+"' does not exist");
		}
		
		return project;
	}
	
	@Override
	public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

	@Override
    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw  new  ProjectIdException("Project with ID '"+projectId+"' does not exist");
        }

        projectRepository.delete(project);
    }
    
}
