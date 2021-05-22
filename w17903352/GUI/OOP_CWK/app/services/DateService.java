package services;

import models.FootballClub;
import models.SportsClub;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class DateService implements Comparator<SportsClub> {

	public static void getDate() {
		PointsTableService.loadTheData(); // load the data from Points Table Service
		PointsTableService.listOfServiceMatches.sort(new DateService());  // Sort the data
	}


	DateTimeFormatter formatOfDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");  // Formatting the Date


	@Override
	public int compare(SportsClub firstSportsClub, SportsClub secondSportsClub) {
		LocalDate firstDate = LocalDate.parse(((FootballClub) firstSportsClub).getDate(), formatOfDate);  // get the date and assign to firstDate
		LocalDate secondDate = LocalDate.parse(((FootballClub) secondSportsClub).getDate(), formatOfDate); // get the date and assign to secondDate
		try {
			return firstDate.compareTo(secondDate);  // Comparing the first and second date
		} catch (Exception exception) {
			throw new IllegalArgumentException(exception);
		}
	}


}
