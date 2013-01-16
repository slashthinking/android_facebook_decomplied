package com.facebook.katana.service.vault.methods;

import java.util.Collection;
import java.util.Set;

public class VaultGetSyncedImageStatusParams
{
  private final long a;
  private final Set<String> b;
  private long c;

  public VaultGetSyncedImageStatusParams(long paramLong1, Set<String> paramSet, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramSet;
    this.c = paramLong2;
  }

  public String a()
  {
    return Long.toString(this.a);
  }

  public Collection<String> b()
  {
    return this.b;
  }

  public String c()
  {
    return Long.toString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusParams
 * JD-Core Version:    0.6.0
 */