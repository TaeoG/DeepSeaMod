package taeo.dsm.lib;

import net.minecraft.world.World;

public class Helper {

    public int getAdjBlockId(World world, int x, int y, int z, Direction dir)
    {
        switch (dir) {
            case NORTH:
                return world.getBlockId(x, y, z+1);
            case SOUTH:
                return world.getBlockId(x,y,z-1);
            case EAST:
                return world.getBlockId(x-1, y, z);
            default:
                return world.getBlockId(x+1, y, z);
        }
    }
    public int getEastBlockId(World world, int x, int y, int z){
        return world.getBlockId(x-1, y, z);
    }
    public int getWestBlockId(World world, int x, int y, int z){
        return world.getBlockId(x+1, y, z);
    }
    public int getNorthBlockId(World world, int x, int y, int z){
        return world.getBlockId(x, y, z+1);
    }
    public int getSouthBlockId(World world, int x, int y, int z){
        return world.getBlockId(x, y, z-1);
    }

}
