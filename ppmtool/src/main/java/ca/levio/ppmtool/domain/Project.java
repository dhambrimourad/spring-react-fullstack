package ca.levio.ppmtool.domain;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Project name is required")
	private String projectName;
	
	@NotBlank(message = "Project identifier is required")
	@Size(min=4, max=5, message="Please use 4 to 5 characters")
	@Column(unique = true, updatable = false)
	private String projectIdentifier;
	
	@NotBlank(message = "Project description is required")
	private String description;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated;
	
	public Project() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@PrePersist
	protected void onCreate() {
		this.created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updated = new Date();
	}
	
}
