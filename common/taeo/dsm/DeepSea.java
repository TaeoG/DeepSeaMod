package taeo.dsm;

import taeo.dsm.block.BlockDeepSea;
import taeo.dsm.block.BlockSeawater;
import taeo.dsm.item.ItemBathysphere;
import taeo.dsm.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired=false)
public class DeepSea {
    @Instance(Reference.MOD_ID)
    public static DeepSea instance;
    @SidedProxy (clientSide="taeo.dsm.client.ClientProxy", serverSide="taeo.dsm.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs dsmTab = new CreativeTabs("dsmTab"){
        public ItemStack getIconItemStack(){
            return new ItemStack(itemBathysphere, 1, 0);
        }
    };
    
    public final static Item itemBathysphere = new ItemBathysphere(5000).setUnlocalizedName("itemBathysphere");
    public final static Fluid fluidSeawater = new Fluid("fluidSeawater");
    public final static Fluid fluidDeepSea = new Fluid("fluidDeepSea");
    public final static Block blockSeawater= new BlockSeawater(500, fluidSeawater, Material.water).setUnlocalizedName("blockSeawater");
    public final static Block blockDeepSea = new BlockDeepSea(501, fluidDeepSea, Material.water).setUnlocalizedName("blockDeepSea");
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        registerEverything();
        registerNames();
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.registerRenderers();
        LanguageRegistry.instance().addStringLocalization("itemGroup.dsmTab", Reference.MOD_NAME);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){}
    
    private void registerEverything(){
        //Register Items
        GameRegistry.registerItem(itemBathysphere, "itemBathysphere");
        
        //Register Blocks
        GameRegistry.registerBlock(blockSeawater, "blockSeawater");
        GameRegistry.registerBlock(blockDeepSea, "blockDeepSea");

        
        //Register Fluids
        FluidRegistry.registerFluid(fluidSeawater);
        
    }
    private void registerNames(){
        LanguageRegistry.addName(itemBathysphere, "Bathysphere");
        LanguageRegistry.addName(blockSeawater, "Seawater");
        LanguageRegistry.addName(blockDeepSea, "Infinite Water");
    }
}
