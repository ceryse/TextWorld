import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature {

    public Wumpus(Player player, Level.Room room) {
        super(player, room);
    }

    public void move() {
        Level.Room newRoom = currentRoom;
        if (currentRoom.hasNeighbor(player.getCurrentRoom())) {
            HashMap<String, Level.Room> map = currentRoom.getNeighbors();
            ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());
            if (rooms.size() > 1) {
                while (newRoom != player.getCurrentRoom()) {
                    newRoom = moveRandom();
                }
            }
        }
        moveTo(findNextRoom());
    }

    protected Level.Room findNextRoom() {
        Level.Room newRoom = currentRoom;
        if (currentRoom.hasNeighbor(player.getCurrentRoom())) {
            if (currentRoom.getNeighborsList().size() > 1) {
                getRandomRoom(currentRoom, newRoom);
            }
        } else {
            for (Level.Room r : this.currentRoom.getNeighborsList()) {
                for (Level.Room r2 : r.getNeighborsList()) {
                    if (player.getCurrentRoom() == r2) {
                        getRandomRoom(r, newRoom);
                    }
                }
            }
        }

        return newRoom;
    }

    private void getRandomRoom(Level.Room not, Level.Room newRoom) {
        while (newRoom != not) {
            newRoom = moveRandom();
        }
    }
}
