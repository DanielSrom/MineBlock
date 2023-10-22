package me.tallonscze.mineblock.data;

public class PlayerData {
    private int block_brake;
    private int block_brake_complete;
    private int last_value;
    private int top_value;
    private int played;
    private boolean active;
    private long timeStart;
    private long timeEnd;
    private double copper;
    private double iron;
    private double gold;
    private double diamond;
    private double emerald;
    private double money = 2;

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getDiamond() {
        return diamond;
    }

    public void setDiamond(double diamond) {
        this.diamond = diamond;
    }

    public double getEmerald() {
        return emerald;
    }

    public void setEmerald(double emerald) {
        this.emerald = emerald;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public int getBlock_brake() {
        return block_brake;
    }

    public void setBlock_brake(int block_brake) {
        this.block_brake = block_brake;
    }

    public int getBlock_brake_complete() {
        return block_brake_complete;
    }

    public void setBlock_brake_complete(int block_brake_complete) {
        this.block_brake_complete = block_brake_complete;
    }

    public int getLast_value() {
        return last_value;
    }

    public void setLast_value(int last_value) {
        this.last_value = last_value;
    }

    public int getTop_value() {
        return top_value;
    }

    public void setTop_value(int top_value) {
        this.top_value = top_value;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }





}
