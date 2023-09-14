package com.hsbc.bugreportapp.beans;

import java.time.LocalDate;
import java.util.Objects;

import com.hsbc.bugreportapp.enums.SeverityLevel;

public class Bug {
	
	private int id;								// Unique ID of the bug
	private String title;						// Bug title
	private String description;					// Bug description
	private int projectId;						// Project name (ID)
	private String createdBy;					// Tester name who reported the bug
	private LocalDate openDate;					// Reported time of the bug
	private String assignedTo;					// Developer to whom bug is assigned to
	private boolean isMarkedForClosing;			// boolean value of bug closure
	private String markedForClosing;			// Developer name who marked it for closing
	private String closedBy;					// Project manager who closed the bug
	private LocalDate closedOn;					// Bug closing date
	private boolean status;						// Bug status
	private SeverityLevel severityLevel;		// severity level of the bug
	
	public Bug() {
		// TODO Auto-generated constructor stub
	}
	
	public Bug(String title, String description, int projectId, SeverityLevel severityLevel) {
		super();
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.severityLevel = severityLevel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public boolean isMarkedForClosing() {
		return isMarkedForClosing;
	}
	public void setIsMarkedForClosing(boolean isMarkedForClosing) {
		this.isMarkedForClosing = isMarkedForClosing;
	}
	public String getMarkedForClosing() {
		return markedForClosing;
	}
	public void setMarkedForClosing(String markedForClosing) {
		this.markedForClosing = markedForClosing;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public LocalDate getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(LocalDate closedOn) {
		this.closedOn = closedOn;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public SeverityLevel getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(SeverityLevel severityLevel) {
		this.severityLevel = severityLevel;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bug other = (Bug) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", isMarkedForClosing=" + isMarkedForClosing + ", markedForClosing=" + markedForClosing
				+ ", closedBy=" + closedBy + ", closedOn=" + closedOn + ", status=" + status + ", severityLevel="
				+ severityLevel + "]";
	}
	
	
	
	
	
	
	
}
