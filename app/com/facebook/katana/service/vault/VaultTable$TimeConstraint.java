package com.facebook.katana.service.vault;

 enum VaultTable$TimeConstraint
{
  static
  {
    NONE = new TimeConstraint("NONE", 2);
    TimeConstraint[] arrayOfTimeConstraint = new TimeConstraint[3];
    arrayOfTimeConstraint[0] = NEW_PHOTOS;
    arrayOfTimeConstraint[1] = OLD_PHOTOS;
    arrayOfTimeConstraint[2] = NONE;
    $VALUES = arrayOfTimeConstraint;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultTable.TimeConstraint
 * JD-Core Version:    0.6.0
 */