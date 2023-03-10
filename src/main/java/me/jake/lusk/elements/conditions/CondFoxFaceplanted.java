package me.jake.lusk.elements.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.conditions.base.PropertyCondition;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fox;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

@Name("Fox Is Faceplanted")
@Description("Checks if the fox is faceplanted.")
@Examples({"on damage of fox:\n\tif victim is faceplanted:\n\t\tcancel event"})
@Since("1.0.0")
public class CondFoxFaceplanted extends PropertyCondition<LivingEntity> {

    static {
        register(CondFoxFaceplanted.class, "faceplanted", "livingentities");
    }

    @Override
    public boolean check(LivingEntity entity) {
        if (entity != null) {
            if (entity.getType() == EntityType.FOX) {
                return ((Fox) entity).isFaceplanted();
            } else {
                Skript.error("You can only use this condition with Foxes!");
            }
        }
        return false;
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "faceplanted";
    }
}