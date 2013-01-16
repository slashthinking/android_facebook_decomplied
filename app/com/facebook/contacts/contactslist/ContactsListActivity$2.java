package com.facebook.contacts.contactslist;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.orca.inject.FbInjector;

class ContactsListActivity$2
  implements LoaderManager.LoaderCallbacks<ContactsListLoader.Result>
{
  public Loader<ContactsListLoader.Result> a(int paramInt, Bundle paramBundle)
  {
    return (Loader)FbInjector.a(this.a).a(ContactsListLoader.class);
  }

  public void a(Loader<ContactsListLoader.Result> paramLoader)
  {
  }

  public void a(Loader<ContactsListLoader.Result> paramLoader, ContactsListLoader.Result paramResult)
  {
    ContactsListActivity.a(this.a, paramResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactsListActivity.2
 * JD-Core Version:    0.6.0
 */