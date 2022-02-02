package edu.wctc;

public class Maze
{
    private Room currentRoom;
    private final Player player;
    private boolean isFinished = false;
    Maze()
    {
        player = new Player();

        IneractRoom startRoom = new IneractRoom("CEO office", "The CEO's office",
                "After investigating a rat ran by!", -5);

        LootRoom secretStash = new LootRoom("Secret stash", "The CEO's secret stash",
                "What a lame secret stash you only got a penny","Penny",1);

        IneractRoom theOffice = new IneractRoom("The office", "There are papers scattered all over",
                "Not being able to stand the mess you spend a good amount of time cleaning everything up\n" +
                        "Only for all the papers to topple over and bring you back to where you started", -10);

        IneractRoom loungeRoom = new IneractRoom("Lounge room", "A place to take a breather before " +
                "getting back to work", "You were comforted by having your usual cup of coffee", 10);

        ExitRoom exitRoom = new ExitRoom("Emergency exit", "You found a door you believe " +
                "leads outside", "You found an exit!");

        //starting room exits
        startRoom.setUp(secretStash);
        startRoom.setDown(theOffice);
        // secret stash exits
        secretStash.setDown(startRoom);
        //the office exits
        theOffice.setUp(startRoom);
        theOffice.setEast(loungeRoom);
        theOffice.setWest(exitRoom);
        //lounge room exits
        loungeRoom.setWest(theOffice);
        //exit room exits
        exitRoom.setEast(theOffice);
        this.currentRoom = startRoom;
    }

    public String exitCurrentRoom()
    {
        if (currentRoom instanceof ExitRoom)
        {
            isFinished = true;
            return ((ExitRoom) currentRoom).exit(player);
        }
        return "You search high and low but there's no exit here";
    }

    public String interactWithCurrentRoom()
    {
        if (currentRoom instanceof IneractRoom)
        {
            player.addToScore(((IneractRoom) currentRoom).getPoints());
            return ((IneractRoom) currentRoom).interact(player);
        }
        return "There's nothing that can be interacted within this room";
    }

    public String lootCurrentRoom()
    {
        if (currentRoom instanceof LootRoom)
        {
            player.addToInventory(((LootRoom) currentRoom).lootForInventory());
            player.addToScore(((LootRoom) currentRoom).getPoints());
            return ((LootRoom) currentRoom).loot(player);
        }
        return "There's nothing that's worth taking here";
    }

    public boolean move (char direction)
    {
        if (currentRoom.getAdjoiningRoom(direction) != null)
        {
            this.currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }
        return false;
    }

    public int getPlayerScore()
    {
        return player.getScore();
    }

    public String getPlayerInventory()
    {
        return player.getInventory();
    }

    public String getCurrentRoomName()
    {
        return currentRoom.getName();
    }

    public String getCurrentRoomDescription()
    {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits()
    {
        return currentRoom.getExits();
    }

    public boolean isFinished()
    {
        return isFinished;
    }
}
