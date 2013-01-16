package com.facebook.contacts.data;

import com.facebook.orca.common.util.TypedKey;

public class DbContactsPropertyKey extends TypedKey<DbContactsPropertyKey>
{
  public DbContactsPropertyKey(String paramString)
  {
    super(paramString);
  }

  protected DbContactsPropertyKey a(String paramString)
  {
    return new DbContactsPropertyKey(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbContactsPropertyKey
 * JD-Core Version:    0.6.0
 */