package noobanidus.mods.mysticalpowers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FabricatorConfig {
  private String name;
  private int maxFE;
  private int maxTransfer;
  private int operationCost;
  private int frequency;

  private ForgeConfigSpec.IntValue configMaxFE;
  private ForgeConfigSpec.IntValue configMaxTransfer;
  private ForgeConfigSpec.IntValue configOperationCost;
  private ForgeConfigSpec.IntValue configFrequency;

  private int curMaxFE = -1;
  private int curMaxTransfer = -1;
  private int curOperationCost = -1;
  private int curFrequency = -1;

  public FabricatorConfig(String name, int maxFE, int maxTransfer, int operationCost, int frequency) {
    this.name = name;
    this.maxFE = maxFE;
    this.maxTransfer = maxTransfer;
    this.operationCost = operationCost;
    this.frequency = frequency;
  }

  public String getName() {
    return name;
  }

  public int getMaxFE() {
    if (curMaxFE == -1) {
      curMaxFE = configMaxFE.get();
    }
    return curMaxFE;
  }

  public int getMaxTransfer() {
    if (curMaxTransfer == -1) {
      curMaxTransfer = configMaxTransfer.get();
    }
    return curMaxTransfer;
  }

  public int getOperationCost() {
    if (curOperationCost == -1) {
      curOperationCost = configOperationCost.get();
    }
    return curOperationCost;
  }

  public int getFrequency() {
    if (curFrequency == -1) {
      curFrequency = configFrequency.get();
    }
    return curFrequency;
  }

  private int[] curValues = null;

  public int[] values () {
    if (curValues == null) {
      curValues = new int[]{getMaxFE(), getMaxTransfer(), getOperationCost(), getFrequency()};
    }
    return curValues;
  }

  public void apply(ForgeConfigSpec.Builder builder) {
    builder.comment(name + " fabricator").push(name + "_fabricator");
    configMaxFE = builder.comment("Maximum amount of FE that can be stored in the block").defineInRange("maxFE", maxFE, 0, Integer.MAX_VALUE);
    configMaxTransfer = builder.comment("Maximum amount of FE that can be transferred into the block per tick").defineInRange("maxTransfer", maxTransfer, 0, Integer.MAX_VALUE);
    configOperationCost = builder.comment("Cost to create one " + name + " per operation").defineInRange("operationCost", operationCost, 0, Integer.MAX_VALUE);
    configFrequency = builder.comment("Frequency (in ticks) that " + name + " is produced").defineInRange("frequency", frequency, 0, Integer.MAX_VALUE);
    builder.pop();
  }
}
