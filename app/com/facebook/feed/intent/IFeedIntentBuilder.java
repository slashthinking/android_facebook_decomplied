package com.facebook.feed.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLProfile;
import java.util.List;

public abstract interface IFeedIntentBuilder
{
  public abstract Intent a();

  public abstract Intent a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract Intent a(long paramLong, boolean paramBoolean, String paramString, Bundle paramBundle);

  public abstract Intent a(long paramLong, String[] paramArrayOfString1, long[] paramArrayOfLong, String[] paramArrayOfString2, String paramString1, String paramString2);

  public abstract Intent a(Uri paramUri, Bundle paramBundle, long paramLong);

  public abstract Intent a(FeedStory paramFeedStory);

  public abstract Intent a(String paramString);

  public abstract Intent a(List<GraphQLProfile> paramList);

  public abstract boolean a(Context paramContext, String paramString);

  public abstract boolean a(Context paramContext, String paramString, Bundle paramBundle);

  public abstract Intent b(Context paramContext, String paramString);

  public abstract Intent b(Uri paramUri, Bundle paramBundle, long paramLong);

  public abstract Intent b(FeedStory paramFeedStory);

  public abstract Intent b(String paramString);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.intent.IFeedIntentBuilder
 * JD-Core Version:    0.6.0
 */