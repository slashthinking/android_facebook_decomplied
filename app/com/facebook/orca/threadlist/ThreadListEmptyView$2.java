package com.facebook.orca.threadlist;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;

class ThreadListEmptyView$2
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    UserWithIdentifier localUserWithIdentifier = new UserWithIdentifier((User)ThreadListEmptyView.a(this.a).get(paramInt), ((User)ThreadListEmptyView.a(this.a).get(paramInt)).h());
    Intent localIntent = new Intent(this.a.getContext(), CreateThreadActivity.class);
    localIntent.putExtra("to", localUserWithIdentifier);
    localIntent.putExtra("focus_compose", true);
    localIntent.setFlags(67108864);
    ThreadListEmptyView.b(this.a).a(localIntent, this.a.getContext());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListEmptyView.2
 * JD-Core Version:    0.6.0
 */