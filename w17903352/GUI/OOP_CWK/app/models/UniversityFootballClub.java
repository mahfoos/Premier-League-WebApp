package models;

public class UniversityFootballClub extends FootballClub{
	private String nameOfUniversity;

	public UniversityFootballClub(String sportsClubId,String nameOfClub, String locationOfCLub, int numOfWin,
								  int numOfDraw, int numOfDefeat, int numOfScoredGoals, int numOfReceivedGoals, int goalDifference, int numOfPoints,
								  int numOfPlayedMatches, String date,int position, String nameOfUniversity) {
		super(sportsClubId,nameOfClub, locationOfCLub, numOfWin, numOfDraw, numOfDefeat, numOfScoredGoals, numOfPoints,numOfReceivedGoals,goalDifference, numOfPlayedMatches,date,position);
		this.nameOfUniversity = nameOfUniversity;
	}
}
