package com.facebook.feed.util.composer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.debug.BLog;

public class ComposerActivityReceiver extends SafeLocalBroadcastReceiver
{
  private static final Class<?> d = ComposerActivityReceiver.class;
  ComposerActivityReceiver.Listener a;
  PendingStoryCache b;
  PendingStoryCache c;
  private final boolean e;

  public ComposerActivityReceiver(ComposerActivityReceiver.Listener paramListener, PendingStoryCache paramPendingStoryCache1, PendingStoryCache paramPendingStoryCache2, boolean paramBoolean, Activity paramActivity)
  {
    super(paramActivity, d());
    this.a = paramListener;
    this.b = paramPendingStoryCache1;
    this.c = paramPendingStoryCache2;
    this.e = paramBoolean;
    a();
  }

  private boolean a(String paramString1, String paramString2, Intent paramIntent)
  {
    int i;
    if ("com.facebook.STREAM_PUBLISH_START".equals(paramString1))
    {
      FeedStory localFeedStory = (FeedStory)paramIntent.getParcelableExtra("extra_feed_story");
      if (this.b.b(paramString2))
        BLog.e(d, "Pending story to insert already exists with request id " + paramString2);
      for (i = 0; ; i = 0)
      {
        return i;
        if (localFeedStory != null)
          break;
        BLog.e(d, "Pending story is null with request id " + paramString2);
      }
      this.b.a(paramString2, localFeedStory);
      if (this.e)
        this.c.a(paramString2, localFeedStory);
    }
    while (true)
    {
      i = 1;
      break;
      String str = paramIntent.getStringExtra("extra_legacy_api_post_id");
      if (!this.b.b(paramString2))
      {
        BLog.e(d, "Pending story to insert already exists with request id " + paramString2);
        i = 0;
        break;
      }
      if (str == null)
      {
        this.b.a(paramString2);
        if (this.e)
          this.c.a(paramString2);
        BLog.e(d, "Could not fetch story with request id " + paramString2);
        i = 0;
        break;
      }
      this.b.a(paramString2, str);
      if (!this.e)
        continue;
      this.c.a(paramString2, str);
    }
  }

  private static IntentFilter d()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.STREAM_PUBLISH_COMPLETE");
    localIntentFilter.addAction("com.facebook.STREAM_PUBLISH_START");
    return localIntentFilter;
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (!this.a.a(paramIntent));
    while (true)
    {
      return;
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.getStringExtra("extra_request_id");
      if (str2 == null)
      {
        BLog.e(d, "Story published does not have a request id");
        continue;
      }
      boolean bool1 = "com.facebook.STREAM_PUBLISH_COMPLETE".equals(str1);
      if (a(str1, str2, paramIntent))
      {
        ComposerActivityReceiver.Listener localListener = this.a;
        if (!bool1);
        for (boolean bool2 = true; ; bool2 = false)
        {
          localListener.a(bool2);
          break;
        }
      }
      if (!bool1)
        continue;
      this.a.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.composer.ComposerActivityReceiver
 * JD-Core Version:    0.6.0
 */