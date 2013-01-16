package com.facebook.contacts.data;

import com.facebook.orca.database.DbPropertyUtil;

public class DbContactsPropertyUtil extends DbPropertyUtil<DbContactsPropertyKey>
{
  public DbContactsPropertyUtil(ContactsDatabaseSupplier paramContactsDatabaseSupplier)
  {
    super(paramContactsDatabaseSupplier, "contacts_db_properties");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbContactsPropertyUtil
 * JD-Core Version:    0.6.0
 */