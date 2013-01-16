package com.facebook.feed.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.GraphQLProfile;

class ProfileListFragment$2
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GraphQLProfile localGraphQLProfile = (GraphQLProfile)ProfileListFragment.d(this.a).getItem(paramInt);
    String str = ProfileListFragment.e(this.a).a(localGraphQLProfile.objectType, localGraphQLProfile.id);
    ProfileListFragment.f(this.a).a(this.a.n(), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ProfileListFragment.2
 * JD-Core Version:    0.6.0
 */