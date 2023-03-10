package me.jake.lusk.elements.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Name("is Bed Respawn")
@Description("This Condition requires Paper.\n\nChecks whether or not the player in the Post Respawn event has respawned at they bed.")
@Examples({"""
        on post respawn:
          if player has respawned at their bed:
            broadcast "bed"
          else:
            broadcast "no bed"
        """})
@Since("1.0.0")
public class CondBedRespawn extends Condition {

    static {
        if (Skript.classExists("com.destroystokyo.paper.event.player.PlayerPostRespawnEvent")) {
            Skript.registerCondition(CondBedRespawn.class, "[the] player (has respawned|will respawn|respawns) at their bed",
                                                                       "[the] player (has( not|n't) respawned|w(on't|ill not) respawn) at their bed");
        }
    }

    @Override
    public boolean init(Expression<?> @NotNull [] expressions, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull ParseResult parser) {
        if (!(getParser().isCurrentEvent(PlayerPostRespawnEvent.class))) {
            Skript.error("This condition can only be used in the Post Respawn event!");
            return false;
        }
        setNegated(matchedPattern == 1);

        return true;
    }

    @Override
    public @NotNull String toString(@Nullable Event event, boolean debug) {
        return "the player will " + (isNegated() ? "not " : "") + "respawn at their bed";
    }

    @Override
    public boolean check(@NotNull Event event) {
        return (isNegated()) ^ ((PlayerPostRespawnEvent) event).isBedSpawn();
    }
}