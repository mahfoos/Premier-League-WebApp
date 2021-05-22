import java.util.Comparator;

public class FootballClub extends SportsClub implements Comparable<FootballClub> {
	private int numOfWin;
	private int numOfDraw;
	private int numOfDefeat;
	private int numOfScoredGoals;
	private int numOfReceivedGoals;
	private int goalDifference;
	private int numOfPoints;
	private int numOfPlayedMatches;
	private String date;
	private int position;
	private String homeTeam;
	private String awayTeam;

	public FootballClub(String sportsClubId,String nameOfClub, String locationOfCLub, int numOfWin, int numOfDraw, int numOfDefeat, int numOfScoredGoals, int numOfReceivedGoals, int goalDifference, int numOfPoints, int numOfPlayedMatches, String date,int position) {
		super(sportsClubId,nameOfClub, locationOfCLub);
		this.numOfWin = numOfWin;
		this.numOfDraw = numOfDraw;
		this.numOfDefeat = numOfDefeat;
		this.numOfScoredGoals = numOfScoredGoals;
		this.numOfReceivedGoals = numOfReceivedGoals;
		this.goalDifference = goalDifference;
		this.numOfPoints = numOfPoints;
		this.numOfPlayedMatches = numOfPlayedMatches;
		this.date = date;
		this.position = position;


	}

	public FootballClub(String sportsClubId,String nameOfClub, String locationOfClub, String homeTeam, String awayTeam, int numOfScoredGoals, int numOfReceivedGoals, String date) {
		super(sportsClubId,nameOfClub, locationOfClub);
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.numOfScoredGoals = numOfScoredGoals;
		this.numOfReceivedGoals = numOfReceivedGoals;
		this.date = date;

	}

	public int getNumOfWin() {
		return numOfWin;
	}

	public void setNumOfWin(int numOfWin) {
		this.numOfWin = numOfWin;
	}

	public int getNumOfDraw() {
		return numOfDraw;
	}

	public void setNumOfDraw(int numOfDraw) {
		this.numOfDraw = numOfDraw;
	}

	public int getNumOfDefeat() {
		return numOfDefeat;
	}

	public void setNumOfDefeat(int numOfDefeat) {
		this.numOfDefeat = numOfDefeat;
	}

	public int getNumOfScoredGoals() {
		return numOfScoredGoals;
	}

	public void setNumOfScoredGoals(int numOfScoredGoals) {
		this.numOfScoredGoals = numOfScoredGoals;
	}

	public int getNumOfReceivedGoals() {
		return numOfReceivedGoals;
	}

	public void setNumOfReceivedGoals(int numOfReceivedGoals) {
		this.numOfReceivedGoals = numOfReceivedGoals;
	}

	public int getGoalDifference() {
		return goalDifference;
	}

	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}

	public int getNumOfPoints() {
		return numOfPoints;
	}

	public void setNumOfPoints(int numOfPoints) {
		this.numOfPoints = numOfPoints;
	}

	public int getNumOfPlayedMatches() {
		return numOfPlayedMatches;
	}

	public void setNumOfPlayedMatches(int numOfPlayedMatches) {
		this.numOfPlayedMatches = numOfPlayedMatches;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	@Override
	public int compareTo(FootballClub football) {
		return Comparator.comparing(FootballClub::getNumOfPoints)
				.thenComparing(FootballClub::getGoalDifference)
				.compare(this, football);
	}

	@Override
	public String toString() {
		return "FootballClub{" +
				"numOfWin=" + numOfWin +
				", numOfDraw=" + numOfDraw +
				", numOfDefeat=" + numOfDefeat +
				", numOfScoredGoals=" + numOfScoredGoals +
				", numOfReceivedGoals=" + numOfReceivedGoals +
				", goalDifference=" + goalDifference +
				", numOfPoints=" + numOfPoints +
				", numOfPlayedMatches=" + numOfPlayedMatches +
				", date='" + date + '\'' +
				", position=" + position +
				", homeTeam='" + homeTeam + '\'' +
				", awayTeam='" + awayTeam + '\'' +
				'}';
	}

}
