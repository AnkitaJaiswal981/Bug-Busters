package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Team;
import com.hsbc.bugreportapp.beans.User;

public interface TeamService {
    Team getTeamByProjectAndUser(int projectId, User user) throws SQLException;

    List<User> getDevelopersByProject(int projectId) throws SQLException;

    List<User> getTestersByProject(int projectId) throws SQLException;

    int createTeam(Team team) throws SQLException;
}
