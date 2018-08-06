package xyz.blueberrypancake.srp;

import java.nio.ByteBuffer;

import org.bukkit.Location;

public class Reinforcement {

    public static final int STRUCT_SIZE = 16;

    private int x;
    private int y;
    private int z;
    private short strength;
    private short group_id;

    Reinforcement(Location loc, short strength, short group_id) {
        this((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), strength, group_id);
    }

    Reinforcement(int x, int y, int z, short strength, short group_id) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.strength = strength;
        this.group_id = group_id;
    }

    public void decreaseStrength() {
        this.strength -= 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public short getStrength() {
        return this.strength;
    }

    public short getGroupID() {
        return this.group_id;
    }

    public String toString() {
        return "(x:" + this.x + ",y:" + this.y + ",z:" + this.z + ",group_id:" + this.group_id + "strength:"
                + this.strength + ")";
    }

    public byte[] toBytes() {
        ByteBuffer bytes = ByteBuffer.allocate(Reinforcement.STRUCT_SIZE);
        bytes.putInt(this.x);
        bytes.putInt(this.y);
        bytes.putInt(this.z);
        bytes.putShort(this.strength);
        bytes.putShort(this.group_id);
        return bytes.array();
    }
}