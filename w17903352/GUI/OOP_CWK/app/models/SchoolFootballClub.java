package models;

public class SchoolFootballClub extends FootballClub{
	private String nameOfSchool;

	public SchoolFootballClub(String sportsClubId,String nameOfClub, String locationOfCLub, int numOfWin, int numOfDraw,
							  int numOfDefeat, int numOfScoredGoals, int numOfReceivedGoals, int goalDifference, int numOfPoints, int numOfPlayedMatches, String date,
							  int position,String nameOfSchool) {
		super(sportsClubId,nameOfClub, locationOfCLub, numOfWin, numOfDraw, numOfDefeat, numOfScoredGoals,numOfReceivedGoals,goalDifference, numOfPoints, numOfPlayedMatches,date,position);
		this.nameOfSchool = nameOfSchool;
	}


}
