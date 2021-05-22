import java.util.Scanner;
import java.awt.*;
import java.net.URI;

public class ConsoleApplication{
	private static boolean decide;
	private static String clubId;
	private static String clubName;
	private static String location;
	private static boolean idCheck;
	private static boolean clubNameCheck;
	private static boolean locationCheck;
	private static String homeTeam;
	private static String awayTeam;
	private static int homeTeamScore;
	private static int awayTeamScore;
	private static String date;
	private static boolean homeTeamCheck;
	private static boolean awayTeamCheck;
	private static boolean homeTeamScoreCheck;
	private static boolean awayTeamScoreCheck;
	private static boolean dateCheck;
	static LeagueManager manager = new PremierLeagueManager();
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		//manager.loadData();  // Call the function for load the file
		menu:
		do {
			try {
				userInput = new Scanner(System.in);
				displayMenu();
				System.out.print("\nEnter the option here : ");
				int option = userInput.nextInt();

				switch (option) {
					case 1:
						addFootballClub();
						userDecision();
						break;
					case 2:
						deleteClub();
						userDecision();
						break;

					case 3:
						DisplayClubDetails();
						userDecision();
						break;

					case 4:
						manager.displayPremierLeagueTable();
						userDecision();
						break;
					case 5:
						addPlayMatch();
						userDecision();
						break;
					case 6:
						Desktop.getDesktop().browse(new URI("http://localhost:4200/points_table")); // open Gui From Cli
						userDecision();
						break;
					case 7:
						manager.saveData();
						userDecision();
						break;

					case 8:
						System.out.println("\n:::::::::::Thank You For Use the Premier League Console Application::::::::");
						decide = false;
						break menu;
					default:
						System.out.println("\nYou Selected an Invalid Option. Please Try Again! ");
						userDecision();
				}
			} catch (Exception e) {

				System.out.println("\nPlease Enter Valid input");
				decide = true;
			}
		} while (decide);
	}

	private static void displayMenu() {
		System.out.println("\n:::::::::::::::::::::::::::Welcome to Premier League Football::::::::::::::::::::::::::");
		System.out.println("\n1: Create a New Football Club ");
		System.out.println("\n2: Delete The existing club from the Premier league");
		System.out.println("\n3: Display the Information about Selected Club ");
		System.out.println("\n4: Display the Premier League Table");
		System.out.println("\n5: Add a played match with its score and its date ");
		System.out.println("\n6: Open the GUI Application ");
		System.out.println("\n7: Save the Entered Data ");
		System.out.println("\n8: Quit the Application\n");
		System.out.println("\n::::::::::::::::::::::::::::Choose the option You want:::::::::::::::::::::::::::::::::");
	}

	private static void addFootballClub() {
		SportsClub sportsClub;
		System.out.println("\n****************** Add the FootballClub ********************");
		do {
			System.out.print("\nEnter the Club Id: ");
			clubId = userInput.next();
			idCheck = clubId.matches("^[a-zA-Z0-9]+$");

			if (idCheck) {
				break;
			} else {
				System.out.println("Please Enter the valid id");
			}
		} while (!idCheck);


		do {
			System.out.print("\nEnter the Club Name: ");
			clubName = userInput.next();
			clubNameCheck = clubName.matches("^[a-zA-Z0-9_ ]*$");

			if (clubNameCheck) {
				break;
			} else {
				System.out.println("Please enter the valid Foot club name");
			}
		} while (!clubNameCheck);

		do {
			userInput = new Scanner(System.in);
			System.out.print("\nEnter the Location of Club: ");
			location = userInput.next();
			locationCheck = location.matches("^[a-zA-Z0-9_ ]*$");

			if (locationCheck) {
				break;
			} else {
				System.out.println("Please valid the valid location name");
			}
		} while (!locationCheck);

		sportsClub = new FootballClub(clubId, clubName, location, 0, 0, 0, 0, 0, 0, 0, 0, "", 0);
		manager.addFootballClub(sportsClub);


	}

	private static void addPlayMatch() {
		SportsClub sportsClub;
		System.out.println("\n******************** Add the Match Between two Clubs *************************");
		do {
			System.out.print("\nEnter the Home Club name : ");
			homeTeam = userInput.next();
			homeTeamCheck = homeTeam.matches("^[a-zA-Z]*$"); // Check the String using regex

			if (homeTeamCheck) {
				break;
			} else {
				System.out.println("Please enter valid Club Name");
			}
		} while (!homeTeamCheck);


		do {
			System.out.print("\nEnter the Away Club Name : ");
			awayTeam = userInput.next();
			awayTeamCheck = awayTeam.matches("^[a-zA-Z]*$");

			if (awayTeamCheck) {
				break;
			} else {
				System.out.println("Please enter Valid Club Name");
			}
		} while (!awayTeamCheck);


		do {
			try {
				userInput = new Scanner(System.in);
				System.out.print("\nEnter the Home Club Score : ");
				homeTeamScore = userInput.nextInt();
				homeTeamScoreCheck = false;
			} catch (Exception e) {
				System.out.println("Please enter the valid input");
				homeTeamScoreCheck = true;
			}
		} while (homeTeamScoreCheck);

		do {
			try {
				userInput = new Scanner(System.in);
				System.out.print("\nEnter the Away Club Score : ");
				awayTeamScore = userInput.nextInt();
				awayTeamScoreCheck = false;
			} catch (Exception e) {
				System.out.println("Please enter the valid input");
				awayTeamScoreCheck = true;
			}
		} while (awayTeamScoreCheck);


		do {
			System.out.print("\nEnter the Date: ");
			date = userInput.next();
			dateCheck = date.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([12][0-9]{3})$"); // check the Date Format

			if (dateCheck) {
				break;
			} else {
				System.out.println("Please Enter Valid Date Format Like this (dd-mm-yyyy) ");
			}
		} while (!dateCheck);

		sportsClub = new FootballClub("", "", "", homeTeam, awayTeam, homeTeamScore, awayTeamScore, date);
		manager.addPlayMatch(homeTeam, awayTeam, homeTeamScore, awayTeamScore, date);
		PremierLeagueManager.listOfMatches.add(sportsClub); // Add the match into listOfMatches ArrayList

	}

	private static void deleteClub() {

		System.out.print("\nEnter the Existing Club Id : ");
		clubId = userInput.next();
		manager.deleteExistFootballClub(clubId);
	}


	private static void DisplayClubDetails() {

		System.out.print("\nEnter the Club Id: ");
		clubId = userInput.next();
		manager.displayClubDetails(clubId);

	}

	private static void userDecision() {
		while (true) {
			System.out.println("\nExit the Program Enter :: E  \nContinue the Program Enter :: C");
			System.out.println("\n:::::::::::::::::::::::::::::::Choose the Option You Want :::::::::::::::::::::::::::");
			System.out.print("\nEnter the Option here : ");
			userInput = new Scanner(System.in);
			String decision = userInput.next();

			if (decision.equalsIgnoreCase("e")) {
				System.out.println("::::::::::::::::::::::::::::::: Exit the Program ::::::::::::::::::::::::::::::::");
				decide = false;
				break;
			} else if (decision.equalsIgnoreCase("c")) {
				decide = true;
				break;
			} else {
				System.out.println("\nPlease type valid command");
			}

		}
	}


}
