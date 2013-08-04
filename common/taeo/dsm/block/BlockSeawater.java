package taeo.dsm.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;

public class BlockSeawater extends Block {

    public BlockSeawater(int par1, Material par2Material) {
        super(par1, Material.water);
        this.setTickRandomly(true);
    }
}
