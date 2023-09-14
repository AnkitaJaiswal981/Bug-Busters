package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Team;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.dao.TeamServiceDAO;
import com.hsbc.bugreportapp.dao.TeamServiceDAOImpl;

public class TeamServiceImpl implements TeamService {

    private TeamServiceDAO teamServiceDAO = new TeamServiceDAOImpl();

    public Team getTeamByProjectAndUser(int projectId, User user) throws SQLException {
        return teamServiceDAO.getTeamByProjectAndUser(projectId, user);
    }

    public List<User> getDevelopersByProject(int projectId) throws SQLException {
        return teamServiceDAO.getDevelopersByProject(projectId);
    }

    public List<User> getTestersByProject(int projectId) throws SQLException {
        return teamServiceDAO.getTestersByProject(projectId);
    }

    public int createTeam(Team team) throws SQLException {
        return teamServiceDAO.createTeam(team);
    }
}