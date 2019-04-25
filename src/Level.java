import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> rooms;

    public Level() {
        rooms = new HashMap<String, Room>();
    }

    public Room getRandomRoom() {
        ArrayList<Room> allRooms = new ArrayList<>(rooms.values());
        return allRooms.get((int) (Math.random() * rooms.size()));
    }

    public void addRoom(String name, String description) {
        rooms.put(name, new Room(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = rooms.get(name1);
        Room n2 = rooms.get(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }


    public class Room {
        private String name;
        private HashMap<String, Room> neighbors;
        private String description;
        private ArrayList<Item> items;
        private ArrayList<Creature> creatures;

        private Room(String name, String description) {
            this.name = name;
            this.description = description;
            neighbors = new HashMap<String, Room>();
            items = new ArrayList<>();
            creatures = new ArrayList<>();
        }

        public boolean hasNeighbor(String roomName) {
            for (Room r : neighbors.values()) {
                if (r.getName().equals(roomName)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasNeighbor(Room r) {
            for (Room room : neighbors.values()) {
                if (r == room) return true;
            }
            return false;
        }

        public Item getItem(String itemName) {
            for (Item item : items) {
                if (item.getName().equals(itemName)) {
                    return item;
                }
            }
            return null;
        }

        public boolean contains(String itemName) {
            return this.contains(getItem(itemName));
        }

        public boolean contains(Item item) {
            return items.contains(item);
        }

        public ArrayList getCreatures() {
            return creatures;
        }

        private void removeCreature(Creature c) {
            creatures.remove(c);
        }

        public void addCreature(Creature c) {
            creatures.add(c);
        }

        private boolean destroyItem(String name) {
            for (Item item : items) {
                if (item.getName().equals(name)) {
                    items.remove(item);
                    return true;
                }
            }
            return false;
        }

        public Item removeItem(String name) {
            for (Item item : items) {
                if (item.getName().equals(name)) {
                    items.remove(item);
                    return item;
                }
            }
            return null;
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public String displayItems() {
            String output = "";
            for (Item i : items) {
                output += i.getName() + " ";
            }
            return output;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Room getNeighbor(String name) {
            return neighbors.get(name);
        }

        public String getNeighborNames() {
            String output = "";
            for (String name : neighbors.keySet()) {
                output += name + " ";
            }
            return output;
        }

        private void addNeighbor(Room room) {
            neighbors.put(room.getName(), room);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, Room> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(HashMap<String, Room> neighbors) {
            this.neighbors = neighbors;
        }

        public ArrayList<Room> getNeighborsList() {
            return new ArrayList<Room>(neighbors.values());
        }

        public String getCreatureNames() {
            String output = "";
            for (Creature c : creatures) {
                if (c instanceof Chicken) {
                    output += "Chicken ";
                } else if (c instanceof Wumpus) {
                    output += "Wumpus ";
                } else if (c instanceof Popstar) {
                    output += "Popstar ";
                }
            }
            return output;
        }

        public Room getRandomNeighbor() {
            ArrayList<Room> rooms = new ArrayList<Room>(neighbors.values());
            return rooms.get((int) (Math.random() * rooms.size()));
        }

        public void moveCreature(Room newRoom, Creature creature) {
            this.removeCreature(creature);
            newRoom.addCreature(creature);
        }
    }
}
