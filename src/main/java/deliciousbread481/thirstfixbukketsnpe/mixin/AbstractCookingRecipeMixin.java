package deliciousbread481.thirstfixbukketsnpe.mixin;  
  
import net.minecraft.world.item.ItemStack;  
import net.minecraft.world.item.crafting.AbstractCookingRecipe;  
import org.spongepowered.asm.mixin.Mixin;  
import org.spongepowered.asm.mixin.injection.At;  
import org.spongepowered.asm.mixin.injection.ModifyArg;  
  
@Mixin(value = AbstractCookingRecipe.class, priority = 1100) // 设置更高的优先级  
public class AbstractCookingRecipeMixin {  
      
    @ModifyArg(  
        method = "matches",   
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/Ingredient;test(Lnet/minecraft/world/item/ItemStack;)Z"),  
        index = 0,  
        require = 0  
    )  
    public ItemStack fixNPE(ItemStack itemStack) {  
        if (itemStack != null && !itemStack.hasTag()) {  
            ItemStack copy = itemStack.copy();  
            copy.getOrCreateTag();
            return copy;  
        }  
        return itemStack;  
    }  
}