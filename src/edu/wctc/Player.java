package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int score = 0;
    private final List<String> inventory = new ArrayList<>();

    public void addToInventory(String item)
    {
        inventory.add(item);
    }

    public void addToScore(int score)
    {
        this.score += score;
    }

    public String getInventory()
    {
        int newLine = 1;
        if (inventory.isEmpty())
        {
            return "You didn't loot anything";
        }
        StringBuilder allItems = new StringBuilder();
        for (String item : inventory)
        {
            allItems.append(item);
            allItems.append(" ");
            if (newLine % 5 == 0)
            {
                allItems.append("\n");
            }
            newLine++;
        }
        return allItems.toString();
    }

    public int getScore()
    {
        return this.score;
    }
}
