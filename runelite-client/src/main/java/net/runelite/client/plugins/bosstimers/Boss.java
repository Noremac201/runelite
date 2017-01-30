package net.runelite.client.plugins.bosstimers;

/**
 * Created by bold on 1/29/17.
 */
public class Boss
{
    int id;
    int spawnTime;
    String bossName;
    int lastHealth;

    /**
     * @param id        Index of boss in cachedNPCs array.
     * @param spawnTime Spawn time of boss in seconds.
     */
    public Boss(int id, int spawnTime, String bossName)
    {
        this.id = id;
        this.spawnTime = spawnTime;
        this.bossName = bossName;
    }

    public int getId()
    {
        return id;
    }

    public int getSpawnTime()
    {
        return spawnTime;
    }

    public String getBossName()
    {
        return bossName;
    }

    public void setLastHealth(int lastHealth)
    {
        this.lastHealth = lastHealth;
    }

    public int getLastHealth()
    {
        return this.lastHealth;
    }
}
