package me.tallonscze.mineblock.data;

public class PlayerData {
    private int block_brake;
    private int block_brake_complete;
    private int last_value;
    private int top_value;
    private int played;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
