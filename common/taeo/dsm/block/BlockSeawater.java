package taeo.dsm.block;

import taeo.dsm.DeepSea;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class BlockSeawater extends BlockFluidFinite {

    protected Icon[] theIcon;
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        if ( side <= 1 ) {
            return this.theIcon[0];
        } else {
            return this.theIcon[1];
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister){
        this.theIcon = new Icon[]{iconRegister.registerIcon("deepseamod:water_still"), iconRegister.registerIcon("deepseamod:water_flow")};
    }
    
    public BlockSeawater(int id, Fluid fluid, Material material) {
        super(id, fluid, Material.water);
        this.setCreativeTab(DeepSea.dsmTab);
        fluid.setBlockID(this);
        LanguageRegistry.addName(this, "Seawater");
        try {
            fluid.setIcons(this.theIcon[0], this.theIcon[1]);
        } catch (Exception e) {}
    }
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
    	par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 1);
    }

}
