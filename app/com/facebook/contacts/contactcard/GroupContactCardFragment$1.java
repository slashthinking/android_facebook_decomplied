package com.facebook.contacts.contactcard;

import android.content.Intent;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.threadview.AddMembersActivity;
import com.facebook.orca.users.UserKey;

class GroupContactCardFragment$1
  implements GroupMembersSectionView.GroupMembersSectionListener
{
  public void a()
  {
    GroupContactCardFragment.a(this.a, new HoneyClientEvent("click").e("button").f("add_person"));
    Intent localIntent = new Intent(this.a.p(), AddMembersActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("thread_id", GroupContactCardFragment.b(this.a));
    this.a.a(localIntent);
  }

  public void a(UserKey paramUserKey)
  {
    if (GroupContactCardFragment.a(this.a) != null)
      GroupContactCardFragment.a(this.a).a(paramUserKey);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.GroupContactCardFragment.1
 * JD-Core Version:    0.6.0
 */