package com.hsbc.bugreportapp.beans;

public class Team {
    private int teamId;					// Team ID 
    private String manager;				// Manager of the team who assigns bugs to developer
    private String developer1;			// Developer 1
    private String developer2;			// Developer 2
    private String tester;				// Tester who reports new bugs in a project

    public Team() {}

    public Team(int teamId, String manager, String developer1, String developer2, String tester) {
        this.teamId = teamId;
        this.manager = manager;
        this.developer1 = developer1;
        this.developer2 = developer2;
        this.tester = tester;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDeveloper1() {
        return developer1;
    }

    public void setDeveloper1(String developer1) {
        this.developer1 = developer1;
    }

    public String getDeveloper2() {
        return developer2;
    }

    public void setDeveloper2(String developer2) {
        this.developer2 = developer2;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", manager='" + manager + '\'' +
                ", developer1='" + developer1 + '\'' +
                ", developer2='" + developer2 + '\'' +
                ", tester='" + tester + '\'' +
                '}';
    }
}
