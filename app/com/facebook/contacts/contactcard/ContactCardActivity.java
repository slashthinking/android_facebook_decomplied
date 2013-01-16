package com.facebook.contacts.contactcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.UserKey;

public class ContactCardActivity extends FbFragmentActivity
{
  private ContactCardFragment n;
  private FragmentManager o;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903108);
    this.o = ((FragmentManager)C().a(FragmentManager.class));
    this.n = ((ContactCardFragment)this.o.a(2131296564));
    try
    {
      UserKey localUserKey = UserKey.a(getIntent().getStringExtra("userKey"));
      this.n.a(localUserKey, false);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ContactCardActivity
 * JD-Core Version:    0.6.0
 */