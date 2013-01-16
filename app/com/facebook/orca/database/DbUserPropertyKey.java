package com.facebook.orca.database;

import com.facebook.orca.common.util.TypedKey;

public class DbUserPropertyKey extends TypedKey<DbUserPropertyKey>
{
  public DbUserPropertyKey(String paramString)
  {
    super(paramString);
  }

  protected DbUserPropertyKey a(String paramString)
  {
    return new DbUserPropertyKey(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbUserPropertyKey
 * JD-Core Version:    0.6.0
 */