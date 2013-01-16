package com.facebook.katana.service.vault;

 enum VaultTable$UpgradeStatus
{
  static
  {
    ALL = new UpgradeStatus("ALL", 2);
    UpgradeStatus[] arrayOfUpgradeStatus = new UpgradeStatus[3];
    arrayOfUpgradeStatus[0] = NO_UPGRADES;
    arrayOfUpgradeStatus[1] = UPGRADE_ONLY;
    arrayOfUpgradeStatus[2] = ALL;
    $VALUES = arrayOfUpgradeStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultTable.UpgradeStatus
 * JD-Core Version:    0.6.0
 */