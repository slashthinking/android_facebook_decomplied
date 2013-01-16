package com.facebook.contacts.contactslist;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.facebook.common.util.Log;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.BetterListView;

public class ContactsListActivity extends FbFragmentActivity
{
  private ContactsListAdapter n;
  private BetterListView o;

  private void a(ContactsListLoader.Result paramResult)
  {
    Log.e("loaded contacts: ", paramResult.toString());
    this.n.a(paramResult.a());
  }

  private void c(int paramInt)
  {
  }

  private void i()
  {
    h().a(1, null, new ContactsListActivity.2(this));
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = ((ContactsListAdapter)C().a(ContactsListAdapter.class));
    setContentView(2130903118);
    this.o = ((BetterListView)f(2131296600));
    this.o.setAdapter(this.n);
    this.o.setDividerHeight(0);
    this.o.setOnItemClickListener(new ContactsListActivity.1(this));
    i();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactsListActivity
 * JD-Core Version:    0.6.0
 */