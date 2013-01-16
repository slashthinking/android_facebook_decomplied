package com.facebook.contacts.contactcard;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.EntrySection;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.BetterListView;

public class HiddenEntryPickerActivity extends FbFragmentActivity
{
  private ContactsCache n;
  private FbTitleBar o;
  private BetterListView p;
  private ContactDetails q;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = ((ContactsCache)C().a(ContactsCache.class));
    String str = getIntent().getStringExtra("contact_id");
    UserKey localUserKey = new UserKey(User.Type.FACEBOOK_CONTACT, str);
    this.q = this.n.b(localUserKey);
    if (this.q == null)
      finish();
    while (true)
    {
      return;
      EntrySection localEntrySection = this.q.getContactInfoSection();
      setContentView(2130903117);
      FbTitleBarUtil.a(this);
      this.o = ((FbTitleBar)f(2131296299));
      this.p = ((BetterListView)f(2131296599));
      this.o.setTitle(2131362451);
      HiddenEntryPickerActivity.HiddenEntryAdapter localHiddenEntryAdapter = new HiddenEntryPickerActivity.HiddenEntryAdapter(this, this, localEntrySection.getHiddenEntries());
      this.p.setAdapter(localHiddenEntryAdapter);
      this.p.setOnItemClickListener(new HiddenEntryPickerActivity.1(this));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.HiddenEntryPickerActivity
 * JD-Core Version:    0.6.0
 */