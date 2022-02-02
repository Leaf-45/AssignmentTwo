package edu.wctc;

public abstract class Room
{
    private final String name;
    private Room North;
    private Room South;
    private Room East;
    private Room West;
    private Room Up;
    private Room Down;

    Room(String name)
    {
        this.name = name;
    }

    public abstract String getDescription();

    /* accepts a char argument for the direction. If this Room is connected to another Room in the given direction,
    that Room is returned. Otherwise, return null. */
    public Room getAdjoiningRoom(char direction)
    {
        return switch (direction)
                {
                    case 'n' -> North;
                    case 's' -> South;
                    case 'e' -> East;
                    case 'w' -> West;
                    case 'u' -> Up;
                    case 'd' -> Down;
                    default -> null;
                };
    }

    /*
     returns a String.
     The String should be a list of all of the directions the Player could exit from this Room to another Room.
     */
    public String getExits()
    {
        String[] directions = {"north", "south", "east", "west", "up", "down"};
        StringBuilder exits = new StringBuilder();
        for(String direction : directions)
        {
            if (isValidDirection(direction.charAt(0)))
            {
                exits.append(direction).append(" ");
            }
        }
        return exits.toString();
    }

    public String getName()
    {
        return name;
    }

    /*
    accepts a char argument for the direction. If this Room is connected to another Room in the given direction,
     return true. Otherwise, return false.
     */
    public boolean isValidDirection(char direction)
    {
        return switch (direction) {
            case 'n', 's', 'e', 'w', 'u', 'd' -> getAdjoiningRoom(direction) != null;
            default -> false;
        };
    }

    public void setNorth(Room north)
    {
        this.North = north;
    }

    public void setSouth(Room south)
    {
        this.South = south;
    }

    public void setEast(Room east)
    {
        this.East = east;
    }

    public void setWest(Room west)
    {
        this.West = west;
    }

    public void setUp(Room up)
    {
        this.Up = up;
    }

    public void setDown(Room down)
    {
        this.Down = down;
    }
}
