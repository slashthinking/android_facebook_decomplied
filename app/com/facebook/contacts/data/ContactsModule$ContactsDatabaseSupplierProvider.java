package com.facebook.contacts.data;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactsDatabaseSupplierProvider extends AbstractProvider<ContactsDatabaseSupplier>
{
  private ContactsModule$ContactsDatabaseSupplierProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactsDatabaseSupplier a()
  {
    return new ContactsDatabaseSupplier((Context)b(Context.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (ContactsDbSchemaPart)b(ContactsDbSchemaPart.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */