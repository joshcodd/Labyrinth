package models;


import java.util.ArrayList;

/**
 * Tile bag is used to store tiles for which the player can draw from
 * @author Andreas Eleftheriades    @StudentID 1906277
 */
public class TileBag {
    // list of the tiles needed in the game
    private ArrayList<Tile> tileBag;

    /**
     * Creates TileBag
     */
    public TileBag(){
        tileBag = new ArrayList<>();

    }

    /**
     * Randomly removes and returns a tile from the tile bag
     * @return Random tile from TileBag
     */
    public Tile drawTile(){
        int randomIndex = (int)(Math.random() * tileBag.size());
        return tileBag.remove(randomIndex);
    }

    /**
     * Adds tile to tile bag
     * @param tile - passed tile to be added
     */
    public void addTile(Tile tile){
        tileBag.add(tile);
    }

    /**
     * @return length of list of tiles
     */
    public int getSize(){
        return tileBag.size();
    }

}
