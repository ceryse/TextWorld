import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {

    public Chicken(Player p, Level.Room r) {
        super(p, r);
    }

    public void move() {
        HashMap<String, Level.Room> map = currentRoom.getNeighbors();
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());
        Level.Room newRoom;
        if (currentRoom.getNeighbors().size() == 0) {
            newRoom = currentRoom;
        } else {
            newRoom = moveRandom();
        }
        moveTo(newRoom);
    }
}
