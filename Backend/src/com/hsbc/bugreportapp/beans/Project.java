package com.hsbc.bugreportapp.beans;

import java.time.LocalDate;

public class Project {
    private int projectId;						// Project ID
    private String projectName;					// Name of the project
    private String description;					// Project description
    private LocalDate startDate;				// Start date of the project
    private boolean status;						// Project status (made true when it is created)
    private int teamId;							// Team id mapped with 'teams' table

    
    public Project() {
        
    }

    public Project(int projectId, String projectName, String description, LocalDate startDate, boolean status, int teamId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.status = status;
        this.teamId = teamId;
    }

    
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", status='" + status + '\'' +
                ", teamId=" + teamId +
                '}';
    }
}
