package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.feed.ui.ProfileListFragment;
import com.facebook.fragment.IFragmentFactory;

class NewsFeedFragmentFactoryInitializer$ProfileListFragmentFactory
  implements IFragmentFactory
{
  public int a()
  {
    return 6;
  }

  public Fragment a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("profile_list_is_feedback", false));
    for (ProfileListFragment localProfileListFragment = ProfileListFragment.a(paramIntent.getStringExtra("gql_feedback_id")); ; localProfileListFragment = ProfileListFragment.a(paramIntent.getParcelableArrayListExtra("gql_profile_list")))
      return localProfileListFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer.ProfileListFragmentFactory
 * JD-Core Version:    0.6.0
 */