package utils;

import services.PremierLeagueManager;

import java.io.*;
import java.util.ArrayList;

public class FileHandleUtil {

	public static void saveData() {

		try {
			FileOutputStream fileOut = new FileOutputStream("premierLeagueData.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

			objOut.writeObject(PremierLeagueManager.listOfSportsClubs);
			objOut.writeObject(PremierLeagueManager.listOfMatches);

			System.out.println("Data Saved Successfully");

			objOut.flush();
			objOut.close();
			fileOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void loadData() {
		try {

			FileInputStream fileInput = new FileInputStream("premierLeagueData.txt");
			ObjectInputStream objOutput = new ObjectInputStream(fileInput);

			PremierLeagueManager.listOfSportsClubs = (ArrayList) objOutput.readObject();
			PremierLeagueManager.listOfMatches = (ArrayList) objOutput.readObject();

			objOutput.close();
			fileInput.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException classNotFound) {
			System.out.println("Class not found");
			classNotFound.printStackTrace();
		}
	}

}
