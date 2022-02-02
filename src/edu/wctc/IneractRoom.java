package edu.wctc;

public class IneractRoom extends Room implements Interactable
{
    private final String description;
    private final String interaction;
    private final int points;
    IneractRoom(String name, String description, String interaction, int points)
    {
        super(name);
        this.description = description;
        this.interaction = interaction;
        this.points = points;
    }

    @Override
    public String interact(Player player)
    {
        return interaction;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    public int getPoints()
    {
        return points;
    }
}
