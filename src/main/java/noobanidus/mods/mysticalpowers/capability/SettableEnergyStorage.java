package noobanidus.mods.mysticalpowers.capability;

import net.minecraftforge.energy.EnergyStorage;

public class SettableEnergyStorage extends EnergyStorage {
    public SettableEnergyStorage(int capacity, int maxTransfer) {
      super(capacity, maxTransfer);
    }

    public void setEnergy(int amount) {
      this.energy = amount;
    }
}
