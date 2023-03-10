package me.jake.lusk.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.entity.EntityData;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import io.papermc.paper.event.entity.EntityDyeEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class EvtDye extends SkriptEvent {

    static {
        if (Skript.classExists("io.papermc.paper.event.entity.EntityDyeEvent")) {
            Skript.registerEvent("Dye Event", EvtDye.class, EntityDyeEvent.class, "dye [of %-entitydatas%]")
                    .description("This Event requires Paper.\n\nCalled when a player dyes an entity (Wolf, Cat or sheep).")
                    .examples("on dye of sheep:\n\tbroadcast the dye color")
                    .since("1.0.0");
        }
    }

    @Nullable
    private EntityData<?>[] types = new EntityData<?>[0];


    @Override
    public boolean init(Literal @NotNull [] args, int matchedPattern, @NotNull ParseResult parseResult) {
        if (args.length > 0) {
            types = args[0] == null ? null : (EntityData<?>[]) (args[0]).getAll();
        }
        return true;
    }

    @Override
    public boolean check(@NotNull Event e) {
        if (types == null) {
            return true;
        }
        final @NotNull EntityType entity = ((EntityDyeEvent) e).getEntityType();
        for (final EntityData<?> type : types) {
            if (type != null) {
                if (String.valueOf(type).toUpperCase().equals(entity.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "dye" + (types == null ? "" : " " + Arrays.toString(types));
    }

}
