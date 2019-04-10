import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {

    public Chicken(Player p, Level.Room r) {
        super(p, r);
    }

    public void move() {
        moveTo(findNextRoom());
    }

    protected Level.Room findNextRoom() {
        Level.Room newRoom;
        if (currentRoom.getNeighbors().size() == 0) {
            newRoom = currentRoom;
        } else {
            newRoom = moveRandom();
        }
        return newRoom;
    }
}
