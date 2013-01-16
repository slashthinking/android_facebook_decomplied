package com.facebook.feed.module;

import android.app.ActivityManager;
import com.facebook.android.os.DeferredHandler;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;

class NewsFeedModule$FbListItemViewPoolManagerProvider extends AbstractProvider<FbListItemViewPoolManager>
{
  public FbListItemViewPoolManager a()
  {
    ActivityManager localActivityManager = (ActivityManager)b(ActivityManager.class, FromApplication.class);
    return new FbListItemViewPoolManager((DeferredHandler)b(DeferredHandler.class), localActivityManager.getMemoryClass());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FbListItemViewPoolManagerProvider
 * JD-Core Version:    0.6.0
 */