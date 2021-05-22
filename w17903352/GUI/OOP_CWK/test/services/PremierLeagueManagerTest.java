package services;

import models.FootballClub;
import models.SportsClub;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


class PremierLeagueManagerTest {

	@Test
	void addFootballClub() {
		List <SportsClub> sportsClubList = new ArrayList<>();

		SportsClub newFootballClub = new FootballClub("C001","Barcelona","Sapin","","",0,0,"");

		sportsClubList.add(newFootballClub); // adding new Football Club into sportClubList

		assertTrue("Successfully added into SportsClub List",sportsClubList.add(newFootballClub));

		assertEquals(true,sportsClubList.contains(newFootballClub));



	}

	@Test
	void delFootballClub() {


	}

	@Test
	void displayClubDetails() {


	}

	@Test
	void displayPremierLeagueTable() {
	}

	@Test
	void addPlayMatch() {
	}
}
