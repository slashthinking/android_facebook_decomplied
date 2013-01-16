package com.facebook.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.inject.FbInjector;

class FindFriendsFeedUnitView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = ((IFeedIntentBuilder)FindFriendsFeedUnitView.a(this.a).a(IFeedIntentBuilder.class)).a();
    FindFriendsFeedUnitView.b(this.a).startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FindFriendsFeedUnitView.1
 * JD-Core Version:    0.6.0
 */