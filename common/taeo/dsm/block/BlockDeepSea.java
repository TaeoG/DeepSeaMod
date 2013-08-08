package taeo.dsm.block;

import taeo.dsm.DeepSea;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockDeepSea extends BlockFluidBase {

	public BlockDeepSea(int id, Fluid fluid, Material material) {
		super(id, fluid, Material.ground);
		this.setCreativeTab(DeepSea.dsmTab);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		int seawaterId = DeepSea.blockSeawater.blockID;
		int checkBlockId = world.getBlockId(x-1, y, z);
		
		if(checkBlockId == 0){world.setBlock(x-1, y, z, seawaterId);}
		else if (checkBlockId == seawaterId){
			world.setBlock(x-1, y, z, seawaterId, 7 , 3);
		}
		world.scheduleBlockUpdate(x, y, z, this.blockID, tickRate);
		
	}
	public void onTick(World world, int x, int y, int z){
		int seawaterId = DeepSea.blockSeawater.blockID;
		int checkBlockId = world.getBlockId(x-1, y, z);
		
		if(checkBlockId == 0){world.setBlock(x-1, y, z, seawaterId);}
		else if (checkBlockId == seawaterId){
			world.setBlock(x-1, y, z, seawaterId, 7 , 3);
		}
		world.scheduleBlockUpdate(x, y, z, this.blockID, tickRate);
	}
	@Override
	public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDrain(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canCollideCheck(int meta, boolean fullHit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxRenderHeightMeta() {
		// TODO Auto-generated method stub
		return 0;
	}

}
