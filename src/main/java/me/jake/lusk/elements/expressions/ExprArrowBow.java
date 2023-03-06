package me.jake.lusk.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Name("Arrow/Bow")
@Description("Arrow/Bow expression for the Arrow Ready event.")
@Examples({"on arrow ready:\n\tbroadcast the arrow and the bow"})
@Since("1.0.0")
public class ExprArrowBow extends SimpleExpression<ItemStack> {
    static {
        Skript.registerExpression(ExprArrowBow.class, ItemStack.class, ExpressionType.SIMPLE,
                "[the] (:arrow|bow)");
    }

    private boolean arrow;

    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull ParseResult parseResult) {
        if (!getParser().isCurrentEvent(PlayerReadyArrowEvent.class)) {
            Skript.error("This expression can only be used in the Arrow Ready Event!");
            return false;
        }
        arrow = parseResult.hasTag("arrow");
        return true;
    }
    @Override
    protected ItemStack @NotNull [] get(@NotNull Event e) {
        ItemStack item;
        if (arrow) {
            item = ((PlayerReadyArrowEvent) e).getArrow();
        } else {
            item = ((PlayerReadyArrowEvent) e).getBow();
        }
        return new ItemStack[]{item};
    }

    @Nullable
    @Override
    public Class<?>[] acceptChange(Changer.@NotNull ChangeMode mode) {
        return null;
    }
    @Override
    public void change(@NotNull Event e, Object @NotNull [] delta, Changer.@NotNull ChangeMode mode) {
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public @NotNull Class<? extends ItemStack> getReturnType() {
        return ItemStack.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "the Bow/Arrow";
    }
}