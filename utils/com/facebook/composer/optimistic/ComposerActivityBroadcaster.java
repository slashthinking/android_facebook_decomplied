package com.facebook.composer.optimistic;

import android.content.Context;
import android.content.Intent;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.app.ActivityBroadcaster;

public class ComposerActivityBroadcaster extends ActivityBroadcaster
{
  public ComposerActivityBroadcaster(Context paramContext)
  {
    super(paramContext);
  }

  public void a(String paramString, FeedStory paramFeedStory, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.STREAM_PUBLISH_START");
    localIntent.putExtra("extra_feed_story", paramFeedStory);
    localIntent.putExtra("extra_request_id", paramString);
    localIntent.putExtra("extra_target_id", paramLong);
    a(localIntent);
  }

  public void a(String paramString1, String paramString2, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.STREAM_PUBLISH_COMPLETE");
    localIntent.putExtra("extra_legacy_api_post_id", paramString1);
    localIntent.putExtra("extra_request_id", paramString2);
    localIntent.putExtra("extra_target_id", paramLong);
    a(localIntent);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.optimistic.ComposerActivityBroadcaster
 * JD-Core Version:    0.6.2
 */