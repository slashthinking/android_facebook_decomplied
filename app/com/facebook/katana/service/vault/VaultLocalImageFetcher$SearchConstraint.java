package com.facebook.katana.service.vault;

public enum VaultLocalImageFetcher$SearchConstraint
{
  static
  {
    AFTER = new SearchConstraint("AFTER", 1);
    SearchConstraint[] arrayOfSearchConstraint = new SearchConstraint[2];
    arrayOfSearchConstraint[0] = BEFORE;
    arrayOfSearchConstraint[1] = AFTER;
    $VALUES = arrayOfSearchConstraint;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultLocalImageFetcher.SearchConstraint
 * JD-Core Version:    0.6.0
 */