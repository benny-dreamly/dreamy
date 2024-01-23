package name.modid;

import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ToolMaterial;

public class DreamyToolMaterial implements ToolMaterial {

    public static final DreamyToolMaterial INSTANCE = new DreamyToolMaterial();


    public int getDurability(){
        return 450;
    }


    public float getMiningSpeedMultiplier(){
        return 3.0F;
    }


    public float getAttackDamage(){
        return 3.0F;
    }


    public int getMiningLevel(){
        return 2;
    }


    public int getEnchantability(){
        return 25;
    }


    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(Dreamy.DREAMSTONE);
    }


}
