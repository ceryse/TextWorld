import java.util.ArrayList;

public class Player {
    private String name, description;
    private ArrayList<Item> items;
    private Level.Room currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public boolean moveRoom(Level.Room room) {
        if (currentRoom.getNeighbor(room.getName()) != null) {
            setCurrentRoom(room);
            return true;
        } else {
            return false;
        }
    }

    public Item getItem(String itemName){
        for (Item item:items){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    public boolean addItem(Item item) {
        if (currentRoom.contains(item)) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean addItem(String itemName) {
        if (currentRoom.contains(itemName)) {
            items.add(currentRoom.getItem(itemName));
            return true;
        }
        return false;
    }

    public String getInventory() {
        String output = "";
        for (Item i : items) {
            output += i.getName() + " ";
        }
        return output;
    }

    public Item removeItem(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    public void destroyItem(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                items.remove(i);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room room) {
        this.currentRoom = room;
    }
}
