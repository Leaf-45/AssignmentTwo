package edu.wctc;

public class LootRoom extends Room implements Lootable
{
    private final String description;
    private final String lootMessage;
    private final String loot;
    private final int points;

    LootRoom(String name, String description, String lootMessage, String loot, int points)
    {
        super(name);
        this.description = description;
        this.lootMessage = lootMessage;
        this.loot = loot;
        this.points = points;
    }

    @Override
    public String loot(Player player)
    {
        return lootMessage;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    public String lootForInventory()
    {
        return loot;
    }

    public int getPoints()
    {
        return points;
    }
}
