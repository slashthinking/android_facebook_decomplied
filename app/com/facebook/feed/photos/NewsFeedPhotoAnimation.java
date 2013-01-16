package com.facebook.feed.photos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.NewsFeedImageAdapter;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.List;

public class NewsFeedPhotoAnimation
{
  private int a = 100;
  private boolean b = true;
  private final AnalyticsLogger c;
  private final NewsFeedAnalyticsEventBuilder d;
  private final ImageCache e;
  private final FeedEventBus f;

  public NewsFeedPhotoAnimation(AnalyticsLogger paramAnalyticsLogger, NewsFeedAnalyticsEventBuilder paramNewsFeedAnalyticsEventBuilder, ImageCache paramImageCache, FeedEventBus paramFeedEventBus)
  {
    this.c = paramAnalyticsLogger;
    this.d = paramNewsFeedAnalyticsEventBuilder;
    this.e = paramImageCache;
    this.f = paramFeedEventBus;
  }

  private Bitmap a(UrlImage paramUrlImage, ExpandablePhoto paramExpandablePhoto)
  {
    Bitmap localBitmap = paramUrlImage.getOriginalImageBitmap();
    if (localBitmap != null);
    while (true)
    {
      return localBitmap;
      localBitmap = paramExpandablePhoto.getPlaceholderBitmap();
    }
  }

  private Rect a(UrlImage paramUrlImage, Context paramContext)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramUrlImage.getLocationInWindow(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramUrlImage.getWidth(), arrayOfInt[1] + paramUrlImage.getHeight());
    localRect.offset(0, -SizeUtil.a(paramContext));
    return localRect;
  }

  private void a(Context paramContext, String paramString)
  {
    PerformanceLogger localPerformanceLogger = (PerformanceLogger)FbInjector.a(paramContext).a(PerformanceLogger.class);
    long l = SystemClock.b().a();
    localPerformanceLogger.a("NNFPhotoViewCached", paramString, l);
    localPerformanceLogger.a("NNFPhotoViewUncached", paramString, l);
  }

  private void a(FeedPhotoState paramFeedPhotoState)
  {
    paramFeedPhotoState.b(null);
    paramFeedPhotoState.a(null);
    paramFeedPhotoState.a(null);
    paramFeedPhotoState.b(null);
  }

  private void a(UrlImage paramUrlImage, ExpandablePhoto paramExpandablePhoto, FeedPhotoState paramFeedPhotoState)
  {
    a(paramUrlImage, paramExpandablePhoto, NewsFeedPhotoAnimation.VisibilityStates.ON_ANIMATION_FAILED);
    a(paramFeedPhotoState);
  }

  private void a(UrlImage paramUrlImage, ExpandablePhoto paramExpandablePhoto, NewsFeedPhotoAnimation.VisibilityStates paramVisibilityStates)
  {
    switch (NewsFeedPhotoAnimation.5.a[paramVisibilityStates.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      paramUrlImage.setVisibility(4);
      paramExpandablePhoto.setVisibility(0);
      continue;
      paramUrlImage.setVisibility(0);
      paramExpandablePhoto.setVisibility(4);
    }
  }

  public void a(ExpandablePhoto paramExpandablePhoto, NewsFeedPhotoGallery paramNewsFeedPhotoGallery, List<FeedStoryAttachment> paramList, Context paramContext, String paramString, JsonNode paramJsonNode)
  {
    String[] arrayOfString1 = new String[paramList.size()];
    long[] arrayOfLong = new long[paramList.size()];
    String[] arrayOfString2 = new String[paramList.size()];
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
      arrayOfString1[i] = localFeedStoryAttachment.media.image.uri;
      arrayOfLong[i] = Long.parseLong(localFeedStoryAttachment.media.id);
      arrayOfString2[i] = localFeedStoryAttachment.media.S().d();
    }
    paramNewsFeedPhotoGallery.setOnItemClickListener(new NewsFeedPhotoAnimation.2(this, paramContext, paramExpandablePhoto, arrayOfString1, arrayOfLong, arrayOfString2, paramString, paramList, paramJsonNode));
  }

  public void a(ExpandablePhoto paramExpandablePhoto, UrlImage paramUrlImage, Context paramContext, FeedPhotoState paramFeedPhotoState)
  {
    ((Activity)paramContext).overridePendingTransition(0, 0);
    ImageCacheKey localImageCacheKey = paramFeedPhotoState.b();
    NewsFeedImageAdapter localNewsFeedImageAdapter = paramFeedPhotoState.a();
    Long localLong1 = paramFeedPhotoState.f();
    Long localLong2 = paramFeedPhotoState.g();
    if ((localLong2 != null) && (!localLong1.equals(localLong2)))
      this.b = false;
    Bitmap localBitmap;
    if (this.b)
      if (localImageCacheKey != null)
      {
        localBitmap = (Bitmap)this.e.e(localImageCacheKey);
        paramExpandablePhoto.setBitmap(localBitmap);
        if (localNewsFeedImageAdapter != null)
          localNewsFeedImageAdapter.a(localImageCacheKey);
        paramExpandablePhoto.setAnimationDurationMs(this.a);
        if (localBitmap == null)
          break label202;
        Rect localRect = a(paramUrlImage, paramContext);
        new Handler().postDelayed(new NewsFeedPhotoAnimation.3(this, paramExpandablePhoto, localBitmap, localRect), 0L);
        paramExpandablePhoto.setOnPhotoAnimationEndListener(new NewsFeedPhotoAnimation.4(this, paramFeedPhotoState, paramUrlImage, paramExpandablePhoto));
      }
    while (true)
    {
      return;
      Uri localUri = paramFeedPhotoState.e();
      localBitmap = null;
      if (localUri == null)
        break;
      new ImageCacheKey(paramFeedPhotoState.e(), ImageCacheKey.c);
      localBitmap = null;
      break;
      label202: a(paramUrlImage, paramExpandablePhoto, paramFeedPhotoState);
      continue;
      a(paramUrlImage, paramExpandablePhoto, paramFeedPhotoState);
    }
  }

  public void a(ExpandablePhoto paramExpandablePhoto, UrlImage paramUrlImage, FeedStoryAttachment paramFeedStoryAttachment, HoneyClientEvent paramHoneyClientEvent, Context paramContext)
  {
    paramUrlImage.setOnClickListener(new NewsFeedPhotoAnimation.1(this, paramContext, paramFeedStoryAttachment, paramUrlImage, paramExpandablePhoto, paramHoneyClientEvent));
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation
 * JD-Core Version:    0.6.0
 */