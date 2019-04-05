public class Popstar extends Creature {

    public Popstar(Player p, Level.Room r) {
        super(p, r);
    }

    public void move() {
        Level.Room newRoom;
        if (currentRoom.getNeighbors().containsValue(player.getCurrentRoom())) {
            newRoom = player.getCurrentRoom();
        } else if (currentRoom == player.getCurrentRoom()) {
            newRoom = currentRoom;
        } else {
            newRoom = moveRandom();
        }
        moveTo(newRoom);
    }
}
