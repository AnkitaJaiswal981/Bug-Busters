package com.hsbc.bugreportapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.bugreportapp.beans.Bug;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.connection.DBConnection;
import com.hsbc.bugreportapp.connection.DBConnectionImpl;
import com.hsbc.bugreportapp.enums.SeverityLevel;

public class BugServiceDAOImpl implements BugServiceDAO {
	private static DBConnection db= new DBConnectionImpl();
	private static Connection con=null;
	private static PreparedStatement stmt=null;
	private static ResultSet rs=null;
	private static List<Bug> bugs= new ArrayList<>();
	private static Bug bug= new Bug();
	
	
	@Override
	public Bug getBugsById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query="SELECT * FROM bugs WHERE uid=?";
		con= db.connect();
		stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		while(rs.next()) {
			bug.setId(rs.getInt("uid"));
			bug.setTitle(rs.getString("title"));
			bug.setDescription(rs.getString("description"));
			bug.setProjectId(rs.getInt("project_id"));
			bug.setCreatedBy(rs.getString("created_by"));
			bug.setOpenDate(rs.getDate("open_date").toLocalDate());
			bug.setAssignedTo(rs.getString("assigned_to"));
			bug.setIsMarkedForClosing(rs.getBoolean("is_marked_for_closing"));
			bug.setMarkedForClosing(rs.getString("marked_for_closing"));
			bug.setClosedBy(rs.getString("closed_by"));
			bug.setClosedOn(rs.getDate("closed_on").toLocalDate());
			bug.setStatus(rs.getBoolean("status"));
			bug.setSeverityLevel(SeverityLevel.valueOf(rs.getString("severity_level")));
		}
		return bug;
	}

	@Override
	public List<Bug> getBugsReportedByTester(User tester) throws SQLException {
		// TODO Auto-generated method stub
		String query="SELECT * FROM bugs WHERE created_by=?";
		con= db.connect();
		stmt=con.prepareStatement(query);
		stmt.setString(1, tester.getUserId());
		rs=stmt.executeQuery();
		while(rs.next()) {
			bug.setId(rs.getInt("uid"));
			bug.setTitle(rs.getString("title"));
			bug.setDescription(rs.getString("description"));
			bug.setProjectId(rs.getInt("project_id"));
			bug.setCreatedBy(rs.getString("created_by"));
			bug.setOpenDate(rs.getDate("open_date").toLocalDate());
			bug.setAssignedTo(rs.getString("assigned_to"));
			bug.setIsMarkedForClosing(rs.getBoolean("is_marked_for_closing"));
			bug.setMarkedForClosing(rs.getString("marked_for_closing"));
			bug.setClosedBy(rs.getString("closed_by"));
			bug.setClosedOn(rs.getDate("closed_on").toLocalDate());
			bug.setStatus(rs.getBoolean("status"));
			bug.setSeverityLevel(SeverityLevel.valueOf(rs.getString("severity_level")));
			bugs.add(bug);
		}
		return bugs;
	}

	@Override
	public List<Bug> getBugsAssignedToDeveloper(User developer) throws SQLException {
		// TODO Auto-generated method stub
		String query="SELECT * FROM bugs WHERE assigned_to=?";
		con= db.connect();
		stmt=con.prepareStatement(query);
		stmt.setString(1, developer.getUserId());
		rs=stmt.executeQuery();
		while(rs.next()) {
			bug.setId(rs.getInt("uid"));
			bug.setTitle(rs.getString("title"));
			bug.setDescription(rs.getString("description"));
			bug.setProjectId(rs.getInt("project_id"));
			bug.setCreatedBy(rs.getString("created_by"));
			bug.setOpenDate(rs.getDate("open_date").toLocalDate());
			bug.setAssignedTo(rs.getString("assigned_to"));
			bug.setIsMarkedForClosing(rs.getBoolean("is_marked_for_closing"));
			bug.setMarkedForClosing(rs.getString("marked_for_closing"));
			bug.setClosedBy(rs.getString("closed_by"));
			bug.setClosedOn(rs.getDate("closed_on").toLocalDate());
			bug.setStatus(rs.getBoolean("status"));
			bug.setSeverityLevel(SeverityLevel.valueOf(rs.getString("severity_level")));
			bugs.add(bug);
		}
		return bugs;
	}

	@Override
	public int saveBug(Bug bug, User tester) throws SQLException {
		// TODO Auto-generated method stub
		int bugID=0;
		String query= "INSERT INTO bugs (title, description, project_id,severity_level,status)"
					+ "VALUES (?,?,?,?,?)";
		con=db.connect();
		stmt= con.prepareStatement(query);
		stmt.setString(1, bug.getTitle());
		stmt.setString(2, bug.getDescription());
		stmt.setInt(3, bug.getProjectId());
		stmt.setString(4, bug.getSeverityLevel().toString());
		stmt.setBoolean(5, true);
		stmt.executeUpdate();
		PreparedStatement pstmt1 = con.prepareStatement(query);
        
	    rs = pstmt1.executeQuery("select last_insert_id()");
	    while(rs.next()){
	    	bugID = rs.getInt(1);
	    }
		
		return bugID;
	}

	@Override
	public boolean updateBugsForDeveloper(Bug bug, User developer) throws SQLException {
		// TODO Auto-generated method stub
		String query= "UPDATE bugs SET assigned_to=? WHERE uid=?";
			con=db.connect();
			stmt= con.prepareStatement(query);
			stmt.setString(1, developer.getUserId());
			stmt.setInt(2, bug.getId());
			
			return stmt.executeUpdate() >0;
			
			
	}

	@Override
	public boolean updateBugForClosing(Bug bug, User developer) throws SQLException {
		// TODO Auto-generated method stub
		String query= "UPDATE bugs SET is_marked_for_closing=?,marked_for_closing=? where uid=?";
		con=db.connect();
		stmt= con.prepareStatement(query);
		stmt.setBoolean(1, true);							// Updates status of mark_of_closing as true
		stmt.setString(2, developer.getUserId());			// Updates mark_for_closing with developer ID
		stmt.setInt(3, bug.getId());						
		stmt.executeUpdate();				
		return true;
	}

	@Override
	public boolean updateBugAsClosed(Bug bug, User projectManager) throws SQLException {
		// TODO Auto-generated method stub
		String query= "UPDATE bugs SET closed_by=?,closed_on=?, status=?";
		con=db.connect();
		stmt= con.prepareStatement(query);
		stmt.setString(1, projectManager.getUserId());
		stmt.setDate(2, Date.valueOf(LocalDate.now()));
		stmt.setBoolean(3, false);
		stmt.executeUpdate();
		return false;
	}

	
}
