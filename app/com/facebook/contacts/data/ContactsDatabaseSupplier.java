package com.facebook.contacts.data;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class ContactsDatabaseSupplier extends AbstractDatabaseSupplier
{
  private final ContactsDbSchemaPart a;

  public ContactsDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, ContactsDbSchemaPart paramContactsDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramContactsDbSchemaPart), "contacts_db2", ImmutableList.d());
    this.a = paramContactsDbSchemaPart;
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.a.b(b());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsDatabaseSupplier
 * JD-Core Version:    0.6.0
 */