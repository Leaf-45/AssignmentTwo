package edu.wctc;

public class ExitRoom extends Room implements Exitable
{
    private final String description;
    private final String exit;
    ExitRoom(String name, String description, String exit)
    {
        super(name);
        this.description = description;
        this.exit = exit;
    }

    @Override
    public String exit(Player player)
    {
        return exit;
    }

    @Override
    public String getDescription()
    {
        return description;
    }
}
