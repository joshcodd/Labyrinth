package models;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Player {
	Coord currentPosition;
	Coord[] previousPositions;
	int playerNumber;
	ArrayList<ActionTile> actionTiles;
	PlayerProfile profile;
	String colour = "Auto-Assign";
	boolean startFirst = false;
	boolean canBackTrack = true;



	/**
	 * @param playerNumber
	 * @param playerProfile
	 */
	public Player(int playerNumber, PlayerProfile playerProfile) {
		this.playerNumber = playerNumber;
		this.profile = playerProfile;
		actionTiles = new ArrayList<>();
		this.previousPositions = new Coord[]{new Coord(-1, -1), new Coord(-1, -1)};
	}

	/**
	 * @return
	 */
	public Coord getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPosition(Coord xy) {
		this.currentPosition = xy;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @param destination
	 */
	public void movePlayer (Coord destination) {
		previousPositions[1] = previousPositions[0];
		previousPositions[0] = currentPosition;
		currentPosition = destination;
	}

	public void addActionTile (ActionTile tile) {
		actionTiles.add(tile);
	}

	/**
	 * @param tile
	 */
	public void removeActionTile (ActionTile tile) {
		actionTiles.removeIf(x -> x.getClass() == tile.getClass());
	}

	public ArrayList<ActionTile> getActionTiles () {
		return actionTiles;
	}

	public Coord getPrevPosition (int index) {
		return previousPositions[index];
	}
	
	public void setPrevPosition(int index, Coord xy) {
		previousPositions[index] = xy;
	}

	public boolean hasProfileSet(){
		return profile!=null;
	}
	
	public PlayerProfile getProfile() {
		return profile;
	}

	public String getProfileName(){
		return this.profile.getPlayerName();
	}

	public String getColour(){
		return this.colour;
	}

	/**
	 * @return Whether the player can have backtrack actions used on them.
	 */
	public boolean canBackTrack() {
		return this.canBackTrack;
	}

	public void setColour(String newColour){
		this.colour = newColour;
	}

	public boolean isStartingFirst(){
		return this.startFirst;
	}

	public void setFirst(boolean Starting){
		this.startFirst = Starting;
	}

	public void setProfile(PlayerProfile profile) {
		this.profile = profile;
	}

	/**
	 * @param canBackTrack The value to be assigned to canBackTrack.
	 */
	public void setCanBackTrack(boolean canBackTrack) {
		this.canBackTrack = canBackTrack;
	}

	public String getColourImage(){
		String imageName;

		switch(colour) {
			case "Green":
				imageName = "1";
				break;
			case "Red":
				imageName = "2";
				break;
			case "Desert Camo":
				imageName = "3";
				break;
			case "Blue":
				imageName = "4";
				break;
			default:
				imageName = "5";
		}
		return imageName;
	}

	@Override
	public String toString() {
		return getProfileName() + " " + getColour();
	}
}
	

	
	

	
