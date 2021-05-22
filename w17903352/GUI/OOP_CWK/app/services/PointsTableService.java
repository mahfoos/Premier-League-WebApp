package services;

import models.FootballClub;
import models.SportsClub;
import utils.FileHandleUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class PointsTableService {

	public static ArrayList <SportsClub> listOfServiceSportsClubs = new ArrayList();
	public static ArrayList <SportsClub> listOfServiceMatches = new ArrayList();
	private static int point;
	private static int win;
	private static int drawn;
	private static int lost;
	private static int firstPositionOfIndex;
	private static int secondPositionOfIndex;

	public static void loadTheData() {
		try {

			FileInputStream fileOfInput = new FileInputStream("premierLeagueData.txt");
			ObjectInputStream objectOfOutput = new ObjectInputStream(fileOfInput);

			listOfServiceSportsClubs = (ArrayList) objectOfOutput.readObject(); // get the the data from file and assign the listOfServiceSportsClubs List
			listOfServiceMatches = (ArrayList) objectOfOutput.readObject(); // get the the data from file and assign the listOfServiceMatches List

			objectOfOutput.close();
			fileOfInput.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException classNotFound) {
			System.out.println("Class not found");
			classNotFound.printStackTrace();
		}


	}

	public static void saveTheData() {

		try {
			FileOutputStream fileOfInput = new FileOutputStream("premierLeagueData.txt");
			ObjectOutputStream objectOfOutput = new ObjectOutputStream(fileOfInput);

			objectOfOutput.writeObject(listOfServiceSportsClubs);
			objectOfOutput.writeObject(listOfServiceMatches);

			System.out.println("Data Saved Successfully");

			objectOfOutput.flush();
			objectOfOutput.close();
			fileOfInput.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void get(){
		loadTheData();
		randomMatch();
		saveTheData();
	}

	public static void randomMatch() {
		java.text.SimpleDateFormat formatOfDate = new java.text.SimpleDateFormat("dd-MM-yyyy");

		while (true) {
			firstPositionOfIndex = new Random().nextInt(listOfServiceSportsClubs.size());
			secondPositionOfIndex = new Random().nextInt(listOfServiceSportsClubs.size());

			if (firstPositionOfIndex != secondPositionOfIndex) {
				break;
			}
		}

		String homeTeam = listOfServiceSportsClubs.get(firstPositionOfIndex).getNameOfClub(); // Pick the one club randomly and assign to home team
		String awayTeam = listOfServiceSportsClubs.get(secondPositionOfIndex).getNameOfClub(); // Pick the one club randomly and assign to away team

		int homeTeamGoal = new Random().nextInt(15);  // Randomly pick one number and assign to Home team goal
		int awayTeamGoal = new Random().nextInt(15); // Randomly pick one number and assign to away team goal

		// Randomly generate the date
		Random randomDate = new Random();
		java.util.Calendar calenderClass = java.util.Calendar.getInstance();
		calenderClass.set(java.util.Calendar.MONTH, Math.abs(randomDate.nextInt()) % 12);
		calenderClass.set(java.util.Calendar.DAY_OF_MONTH, Math.abs(randomDate.nextInt()) % 30);
		calenderClass.setLenient(true);
		String date = formatOfDate.format(calenderClass.getTime());


		addPlayMatch(homeTeam, awayTeam, homeTeamGoal, awayTeamGoal, date);
		FileHandleUtil.saveData();
		SportsClub sportsClub = new FootballClub("","", "", homeTeam, awayTeam, homeTeamGoal, awayTeamGoal, date);
		listOfServiceMatches.add(sportsClub);

	}

	public static void addPlayMatch(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore, String date) {
		int count = 0;
		for (SportsClub sportsClub : listOfServiceSportsClubs) {
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
		listOfServiceSportsClubs.sort(Collections.reverseOrder());
		for(SportsClub sportsClub2 : listOfServiceSportsClubs) {
			SportsClub sportsClub3 = new FootballClub(sportsClub2.getSportsClubId(),sportsClub2.getNameOfClub(), sportsClub2.getLocationOfClub(), ((FootballClub) sportsClub2).getNumOfWin(), ((FootballClub) sportsClub2).getNumOfDraw(), ((FootballClub) sportsClub2).getNumOfDefeat(), ((FootballClub) sportsClub2).getNumOfScoredGoals(), ((FootballClub) sportsClub2).getNumOfReceivedGoals(),
					((FootballClub) sportsClub2).getGoalDifference(), ((FootballClub) sportsClub2).getNumOfPoints(), ((FootballClub) sportsClub2).getNumOfPlayedMatches(), ((FootballClub) sportsClub2).getDate(), position + 1);
			listOfServiceSportsClubs.set(position, sportsClub3);
			position++;
		}

	}

	private static void checkPoints(String homeTeam, int homeTeamScore, int awayTeamScore, String date, int count, SportsClub sportsClub, int difference1) {
		score(homeTeamScore, awayTeamScore, ((FootballClub) sportsClub));
		SportsClub sportsClub1 = new FootballClub(sportsClub.getSportsClubId(),homeTeam, sportsClub.getLocationOfClub(), win, drawn, lost, homeTeamScore + ((FootballClub) sportsClub).getNumOfScoredGoals(), awayTeamScore + ((FootballClub) sportsClub).getNumOfReceivedGoals(),
				difference1, point, ((FootballClub) sportsClub).getNumOfPlayedMatches() + 1, date, ((FootballClub) sportsClub).getPosition());


		listOfServiceSportsClubs.set(count, sportsClub1);
	}




	private static void score(int homeTeamScore, int awayTeamScore, FootballClub footballClub) {
		win = 0;
		point = 0;
		drawn = 0;
		lost = 0;
		if (homeTeamScore > awayTeamScore) {
			win = footballClub.getNumOfWin() + 1;
			point = footballClub.getNumOfPoints() + 3;
		} else if (homeTeamScore == awayTeamScore) {
			drawn = footballClub.getNumOfDraw() + 1;
			point = footballClub.getNumOfPoints() + 1;
		} else {
			lost = footballClub.getNumOfDefeat() + 1;
			point = footballClub.getNumOfPoints();
		}


	}
}
