import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature {

    public Wumpus(Player player, Level.Room room) {
        super(player, room);
    }

    public void move() {
        Level.Room newRoom = currentRoom;
        if (currentRoom.getNeighbors().containsValue(player.getCurrentRoom())) {
            HashMap<String, Level.Room> map = currentRoom.getNeighbors();
            ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());
            if (rooms.size() > 1) {
                while (newRoom != player.getCurrentRoom()) {
                    newRoom = moveRandom();
                }
            }
        }
        moveTo(newRoom);
    }
}
