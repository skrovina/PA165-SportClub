package Entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Jan Cech
 * @update Kristián Katanik 445403 created equals and hashcode
 */

@Entity
public class RosterEntry extends Entities.Entity{

    @ManyToOne
    @NotNull
    private Team team;

    @ManyToOne
    @NotNull
    private Player player;

    @Min(1)
    @Max(99)
    @NotNull
    private int jerseyNumber;

    public RosterEntry(Team team, Player player, int jerseyNumber) {
        this.team = team;
        this.player = player;
        this.jerseyNumber = jerseyNumber;
    }

    public RosterEntry() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof RosterEntry)) {
            return false;
        }

        RosterEntry other = (RosterEntry) obj;

        if (!Objects.equals(this.getPlayer(), other.getPlayer()))
            return false;
        if (!Objects.equals(this.getTeam(), other.getTeam()))
            return false;
        if(this.getJerseyNumber() != other.getJerseyNumber())
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = 11;
        result = 54 * result + Objects.hashCode(this.getPlayer());
        result = 54 * result + Objects.hashCode(this.getTeam());
        result = 54 * result + Objects.hashCode(this.getJerseyNumber());
        return result;
    }
}
