public interface LeagueManager {
	void addFootballClub(SportsClub sportsClub);
	void deleteExistFootballClub(String clubId);
	void displayClubDetails(String clubId);
	void displayPremierLeagueTable();
	void addPlayMatch(String homeTeam,String awayTeam, int homeTeamScore,int awayTeamScore, String date);
	void saveData() ;
	void loadData() ;

}
