package com.facebook.pages.identity.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.graphql.model.GraphQLProfile;

class PageFriendsInfoFragment$1
  implements AdapterView.OnItemClickListener
{
  PageFriendsInfoFragment$1(PageFriendsInfoFragment paramPageFriendsInfoFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (PageFriendsInfoFragment.a(this.a).getItemViewType(paramInt) == PageFriendsInfoAdapter.RowType.FRIEND_VIEW.ordinal())
    {
      GraphQLProfile localGraphQLProfile = (GraphQLProfile)PageFriendsInfoFragment.a(this.a).getItem(paramInt);
      PageFriendsInfoFragment.a(this.a, localGraphQLProfile.b());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageFriendsInfoFragment.1
 * JD-Core Version:    0.6.2
 */