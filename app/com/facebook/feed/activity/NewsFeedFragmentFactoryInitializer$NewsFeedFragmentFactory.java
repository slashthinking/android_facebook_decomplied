package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.feed.model.FeedType;
import com.facebook.feed.ui.NewsFeedFragment;
import com.facebook.fragment.IFragmentFactory;

class NewsFeedFragmentFactoryInitializer$NewsFeedFragmentFactory
  implements IFragmentFactory
{
  public int a()
  {
    return 1;
  }

  public Fragment a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("friend_list_feed_id");
    if (str != null);
    for (NewsFeedFragment localNewsFeedFragment = NewsFeedFragment.a(new FeedType(str), "fetchFriendListFeedParams"); ; localNewsFeedFragment = NewsFeedFragment.a(new FeedType(paramIntent.getStringExtra("feed_type")), "fetchNewsFeedParams"))
      return localNewsFeedFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer.NewsFeedFragmentFactory
 * JD-Core Version:    0.6.0
 */