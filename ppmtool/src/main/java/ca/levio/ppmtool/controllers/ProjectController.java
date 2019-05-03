package ca.levio.ppmtool.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.levio.ppmtool.domain.Project;
import ca.levio.ppmtool.services.MapValidationService;
import ca.levio.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationService mapValidationService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationService.validateMap(result);
		if(errorMap != null) return errorMap;
		
		Project p = projectService.saveProject(project);
		return new ResponseEntity<Project>(p, HttpStatus.CREATED);
	}
	
}
