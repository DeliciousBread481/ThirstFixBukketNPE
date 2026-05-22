package deliciousbread481.thirstfixbukketsnpe.mixin;  
  
import net.minecraft.world.Container;  
import net.minecraft.world.item.ItemStack;  
import net.minecraft.world.item.crafting.AbstractCookingRecipe;  
import net.minecraft.world.level.Level;  
import org.spongepowered.asm.mixin.Mixin;  
import org.spongepowered.asm.mixin.injection.At;  
import org.spongepowered.asm.mixin.injection.Inject;  
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;  
  
@Mixin(value = AbstractCookingRecipe.class, priority = 1100)  
public class AbstractCookingRecipeMixin {  
      
    @Inject(method = "matches", at = @At("HEAD"), cancellable = true, require = 0)  
    private void fixNPE(Container container, Level level, CallbackInfoReturnable<Boolean> cir) {  
        ItemStack itemStack = container.getItem(0);  
        if (itemStack != null && !itemStack.hasTag()) {  
            itemStack.getOrCreateTag();  
        }  
    }  
}