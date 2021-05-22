import java.io.Serializable;

public abstract class SportsClub implements Serializable {
	private String sportsClubId;
	private String nameOfClub;
	private String locationOfClub;

	public SportsClub(String sportsClubId,String nameOfClub, String locationOfClub) {
		this.sportsClubId = sportsClubId;
		this.nameOfClub = nameOfClub;
		this.locationOfClub = locationOfClub;
	}

	public String getSportsClubId() {
		return sportsClubId;
	}

	public void setSportsClubId(String sportsClubId) {
		this.sportsClubId = sportsClubId;
	}

	public String getNameOfClub() {
		return nameOfClub;
	}

	public void setNameOfClub(String nameOfClub) {
		this.nameOfClub = nameOfClub;
	}

	public String getLocationOfClub() {
		return locationOfClub;
	}

	public void setLocationOfClub(String locationOfClub) {
		this.locationOfClub = this.locationOfClub;
	}

	@Override
	public String toString() {
		return "SportsClub{" +
				"nameOfClub='" + nameOfClub + '\'' +
				", locationOfClub='" + locationOfClub + '\'' +
				'}';
	}
}
