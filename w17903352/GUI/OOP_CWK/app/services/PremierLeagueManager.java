package services;


import models.FootballClub;
import models.LeagueManager;
import models.SportsClub;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager {
	private static int pointsForWin;
	private static int finalPoints;
	private static int pointsForDrawn;
	private static int pointsForLost;
	private static boolean isFound;

	public static List<SportsClub> listOfSportsClubs = new ArrayList<>(); // Array list For Sports CLub
	public static List<SportsClub> listOfMatches = new ArrayList<>();  // Arraylist for Matches


	@Override
	public void addFootballClub(SportsClub sportsClub) {
		isFound = false;
		for (SportsClub sportsClub1 : listOfSportsClubs) {
			if (sportsClub1.getNameOfClub().equalsIgnoreCase(sportsClub.getNameOfClub())) { // Check Whether Club is  exist
				isFound = true;
				System.out.println("\nThis Club Already added in Premier League");
				break;
			}

		}
		if (!isFound) {
			listOfSportsClubs.add(sportsClub); // add the Football Club into ListOF Sports Club
			System.out.println("\nSuccessfully added the Football Club");
		}

	}

	@Override
	public void deleteExistFootballClub(String clubId) {
		isFound = false;
		for (SportsClub sportsClub : listOfSportsClubs) {
			if (sportsClub.getSportsClubId().equalsIgnoreCase(clubId)) {
				isFound = true;
				listOfSportsClubs.remove(sportsClub);
				System.out.println("\nSportsClub with the " + clubId + " Successfully removed ");
				break;
			}
		}
		if (!isFound) {
			System.out.println("\nNot found the Entered Id");

		}
	}


	@Override
	public void displayClubDetails(String clubId) {
		isFound = false;
		if (listOfSportsClubs.isEmpty()) { // Check Whether ListOfSportsClub is Empty
			System.out.println("No Clubs are Added in Premier League ");
		} else {
			for (SportsClub sportsClub : listOfSportsClubs) {
				if (sportsClub.getSportsClubId().equalsIgnoreCase(clubId)) {  // check the football club in the added list
					System.out.println("\n:::::::::::::::::::::: Created Football Clubs ::::::::::::::::::::::::::::::");
					System.out.println("\n1: Id  Of the Club : " + sportsClub.getSportsClubId());
					System.out.println("\n1: Name Of the Club : " + sportsClub.getNameOfClub());
					System.out.println("\n2: Location of the Club : " + sportsClub.getLocationOfClub());
					System.out.println("\n3: Number of Played Matches : " + ((FootballClub) sportsClub).getNumOfPlayedMatches());
					System.out.println("\n4: Number of Won Matches : " + ((FootballClub) sportsClub).getNumOfWin());
					System.out.println("\n5: Number of Defeat Matches : " + ((FootballClub) sportsClub).getNumOfDefeat());
					System.out.println("\n6: Number of Drawn Matches : " + ((FootballClub) sportsClub).getNumOfDraw());
					System.out.println("\n7: Total Score of the Club :  " + ((FootballClub) sportsClub).getNumOfScoredGoals());
					System.out.println("\n8: Total Received Goal : " + ((FootballClub) sportsClub).getNumOfReceivedGoals());
					System.out.println("\n9: Goal Difference : " + ((FootballClub) sportsClub).getGoalDifference());
					System.out.println("\n8: Total Points of the Club : " + ((FootballClub) sportsClub).getNumOfPoints());

				}
			}
			if (!isFound) {
				System.out.println("\nNot found the Entered Id");

			}

		}

	}


	@Override
	public void displayPremierLeagueTable() {

		listOfSportsClubs.sort(Collections.reverseOrder()); // Sort
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t:::::::::::::::::::::::::::::::::::::Ranking Table::::::::::::::::::::::::::::::::::::::\n");
		String tableAlignment = "| %-15s | %-7s | %-20s | %-15s | %-8s | %-8s | %-8s | %-8s | %-12s | %-15s | %-15s | %-7s | %n";
		System.out.format("+-----------------+---------+----------------------+-----------------+----------+----------+----------+----------+--------------+-----------------+-----------------+---------+%n");
		System.out.format("| Position        | Club Id | Club Name            | Club Location   | Played   | Won      | Drawn    | Lost     | Goals For    | Goal Against    | Goal Difference | Points  |%n");
		System.out.format("+-----------------+---------+----------------------+-----------------+----------+----------+----------+----------+--------------+-----------------+-----------------+---------+%n");
		for (SportsClub sportsClub : listOfSportsClubs) {
			System.out.format(tableAlignment, ((FootballClub) sportsClub).getPosition(), sportsClub.getSportsClubId(), sportsClub.getNameOfClub(), sportsClub.getLocationOfClub(), ((FootballClub) sportsClub).getNumOfPlayedMatches(), ((FootballClub) sportsClub).getNumOfWin()
					, ((FootballClub) sportsClub).getNumOfDraw(), ((FootballClub) sportsClub).getNumOfDefeat(), ((FootballClub) sportsClub).getNumOfScoredGoals(), ((FootballClub) sportsClub).getNumOfReceivedGoals(),
					((FootballClub) sportsClub).getGoalDifference(), ((FootballClub) sportsClub).getNumOfPoints());

		}
		System.out.format("+-----------------+---------+----------------------+-----------------+----------+----------+----------+----------+--------------+-----------------+-----------------+---------+%n");


	}

	@Override
	public void addPlayMatch(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore, String date) {
		int count = 0;
		for (SportsClub sportsClub : listOfSportsClubs) {
			int difference1 = homeTeamScore + ((FootballClub) sportsClub).getNumOfScoredGoals() - awayTeamScore + ((FootballClub) sportsClub).getNumOfReceivedGoals();
			int difference2 = awayTeamScore + ((FootballClub) sportsClub).getNumOfScoredGoals() - homeTeamScore + ((FootballClub) sportsClub).getNumOfReceivedGoals();
			if (sportsClub.getNameOfClub().equals(homeTeam)) {
				checkPoints(homeTeam, homeTeamScore, awayTeamScore, date, count, sportsClub, difference1);
			} else if (sportsClub.getNameOfClub().equals(awayTeam)) {
				checkPoints(awayTeam, awayTeamScore, homeTeamScore, date, count, sportsClub, difference2);
			}
			count++;
		}

		int position = 0;
		listOfSportsClubs.sort(Collections.reverseOrder());
		for (SportsClub sportsClub2 : listOfSportsClubs) {
			SportsClub sportsClub3 = new FootballClub(sportsClub2.getSportsClubId(), sportsClub2.getNameOfClub(), sportsClub2.getLocationOfClub(), ((FootballClub) sportsClub2).getNumOfWin(), ((FootballClub) sportsClub2).getNumOfDraw(), ((FootballClub) sportsClub2).getNumOfDefeat(), ((FootballClub) sportsClub2).getNumOfScoredGoals(), ((FootballClub) sportsClub2).getNumOfReceivedGoals(),
					((FootballClub) sportsClub2).getGoalDifference(), ((FootballClub) sportsClub2).getNumOfPoints(), ((FootballClub) sportsClub2).getNumOfPlayedMatches(), ((FootballClub) sportsClub2).getDate(), position + 1);
			listOfSportsClubs.set(position, sportsClub3);
			position++;
		}

	}

	private void checkPoints(String homeTeam, int homeTeamScore, int awayTeamScore, String date, int count, SportsClub sportsClub, int difference1) {
		score(homeTeamScore, awayTeamScore, ((FootballClub) sportsClub));
		SportsClub sportsClub1 = new FootballClub(sportsClub.getSportsClubId(), homeTeam, sportsClub.getLocationOfClub(), pointsForWin, pointsForDrawn, pointsForLost, homeTeamScore + ((FootballClub) sportsClub).getNumOfScoredGoals(), awayTeamScore + ((FootballClub) sportsClub).getNumOfReceivedGoals(),
				difference1, finalPoints, ((FootballClub) sportsClub).getNumOfPlayedMatches() + 1, date, ((FootballClub) sportsClub).getPosition());


		listOfSportsClubs.set(count, sportsClub1);
	}


	private void score(int homeTeamScore, int awayTeamScore, FootballClub footballClub) {
		pointsForWin = 0;
		finalPoints = 0;
		pointsForDrawn = 0;
		pointsForLost = 0;
		if (homeTeamScore > awayTeamScore) {
			pointsForWin = footballClub.getNumOfWin() + 1;
			finalPoints = footballClub.getNumOfPoints() + 3;
		} else if (homeTeamScore == awayTeamScore) {
			pointsForDrawn = footballClub.getNumOfDraw() + 1;
			finalPoints = footballClub.getNumOfPoints() + 1;
		} else {
			pointsForLost = footballClub.getNumOfDefeat() + 1;
			finalPoints = footballClub.getNumOfPoints();
		}


	}


}

/*
	Reference

	# Printing the Table in Console
		* https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

 */

