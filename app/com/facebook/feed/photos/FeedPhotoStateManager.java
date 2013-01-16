package com.facebook.feed.photos;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

public class FeedPhotoStateManager
{
  private final Map<String, FeedPhotoState> a = Maps.a();

  public FeedPhotoState a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    FeedPhotoState localFeedPhotoState = (FeedPhotoState)this.a.get(paramString);
    if (localFeedPhotoState == null)
    {
      localFeedPhotoState = new FeedPhotoState();
      this.a.put(paramString, localFeedPhotoState);
    }
    return localFeedPhotoState;
  }

  public void a(String paramString, FeedPhotoState paramFeedPhotoState)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramFeedPhotoState);
    this.a.put(paramString, paramFeedPhotoState);
  }

  public void b(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.a.remove(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.FeedPhotoStateManager
 * JD-Core Version:    0.6.0
 */