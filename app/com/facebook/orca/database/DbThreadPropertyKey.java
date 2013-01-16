package com.facebook.orca.database;

import com.facebook.orca.common.util.TypedKey;

public class DbThreadPropertyKey extends TypedKey<DbThreadPropertyKey>
{
  public DbThreadPropertyKey(String paramString)
  {
    super(paramString);
  }

  protected DbThreadPropertyKey a(String paramString)
  {
    return new DbThreadPropertyKey(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbThreadPropertyKey
 * JD-Core Version:    0.6.0
 */