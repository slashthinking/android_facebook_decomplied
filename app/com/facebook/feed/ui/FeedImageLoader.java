package com.facebook.feed.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.attachments.StoryAttachmentViewAddFriend;
import com.facebook.feed.ui.attachments.StoryAttachmentViewVideo;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentType.KnownAttachmentType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import java.util.List;

public class FeedImageLoader
{
  private final Activity a;
  private final FeedRendererOptions b;
  private final ImageCache c;
  private final FetchImageExecutor d;
  private int e;
  private int f;
  private int g;

  public FeedImageLoader(Activity paramActivity, FeedRendererOptions paramFeedRendererOptions, ImageCache paramImageCache, FetchImageExecutor paramFetchImageExecutor)
  {
    this.a = paramActivity;
    this.b = paramFeedRendererOptions;
    this.c = paramImageCache;
    this.d = paramFetchImageExecutor;
    a();
  }

  private void a(FeedStoryAttachment paramFeedStoryAttachment, FeedImageLoader.FeedImageOperationType paramFeedImageOperationType)
  {
    FeedStoryAttachmentType.KnownAttachmentType localKnownAttachmentType = paramFeedStoryAttachment.j();
    FeedImageLoader.FeedImageType localFeedImageType;
    switch (FeedImageLoader.1.b[localKnownAttachmentType.ordinal()])
    {
    default:
      return;
    case 1:
      if (!StoryAttachmentViewVideo.a(paramFeedStoryAttachment))
        break;
      localFeedImageType = FeedImageLoader.FeedImageType.Video;
    case 2:
    case 3:
    case 4:
    }
    while ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.image != null))
    {
      a(a(paramFeedStoryAttachment.media.image, localFeedImageType), paramFeedImageOperationType);
      break;
      if (StoryAttachmentViewAddFriend.a(paramFeedStoryAttachment))
      {
        localFeedImageType = FeedImageLoader.FeedImageType.AddFriend;
        continue;
      }
      localFeedImageType = FeedImageLoader.FeedImageType.Share;
      continue;
      localFeedImageType = FeedImageLoader.FeedImageType.Photo;
      continue;
      if (!paramFeedStoryAttachment.h())
        break;
      int i = Math.min(paramFeedStoryAttachment.subattachments.size(), 2);
      for (int j = 0; j < i; j++)
      {
        FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)paramFeedStoryAttachment.subattachments.get(j);
        if ((localFeedStoryAttachment.media == null) || (localFeedStoryAttachment.media.image == null))
          continue;
        a(a(localFeedStoryAttachment.media.image, FeedImageLoader.FeedImageType.Album), paramFeedImageOperationType);
      }
      localFeedImageType = FeedImageLoader.FeedImageType.AvatarList;
    }
  }

  private void a(FeedUnit paramFeedUnit, FeedImageLoader.FeedImageOperationType paramFeedImageOperationType)
  {
    if ((paramFeedUnit instanceof FeedStory))
    {
      FeedStory localFeedStory = (FeedStory)paramFeedUnit;
      GraphQLProfile localGraphQLProfile = localFeedStory.a();
      if ((localGraphQLProfile != null) && (localGraphQLProfile.profilePicture != null))
        a(new FetchImageParams(Uri.parse(localGraphQLProfile.profilePicture.uri)), paramFeedImageOperationType);
      if (localFeedStory.d())
        for (int k = 0; k < localFeedStory.attachments.size(); k++)
          a((FeedStoryAttachment)localFeedStory.attachments.get(k), paramFeedImageOperationType);
      if ((localFeedStory.attachedStory != null) && (localFeedStory.attachedStory.s() < 2))
        a(localFeedStory.attachedStory, paramFeedImageOperationType);
      if (localFeedStory.F())
      {
        int i = localFeedStory.s();
        int j = 0;
        if (i < 2)
          while (j < localFeedStory.substories.size())
          {
            a((FeedUnit)localFeedStory.substories.get(j), paramFeedImageOperationType);
            j++;
          }
      }
    }
  }

  private void a(FetchImageParams paramFetchImageParams, FeedImageLoader.FeedImageOperationType paramFeedImageOperationType)
  {
    if (paramFetchImageParams != null)
      switch (FeedImageLoader.1.c[paramFeedImageOperationType.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
    while (true)
    {
      return;
      this.d.b(paramFetchImageParams);
      continue;
      Bitmap localBitmap = (Bitmap)this.c.b(paramFetchImageParams.d());
      if (localBitmap == null)
        continue;
      localBitmap.getPixel(0, 0);
    }
  }

  public int a(FeedImageLoader.FeedImageType paramFeedImageType)
  {
    int i;
    switch (FeedImageLoader.1.a[paramFeedImageType.ordinal()])
    {
    default:
      i = 0;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return i;
      i = this.g;
      continue;
      i = this.f;
      continue;
      i = this.e;
    }
  }

  public FetchImageParams a(GraphQLImage paramGraphQLImage, FeedImageLoader.FeedImageType paramFeedImageType)
  {
    int i;
    int j;
    int k;
    label105: ImageCacheKey.Options localOptions;
    if ((paramGraphQLImage != null) && (this.b.a))
    {
      i = a(paramFeedImageType);
      if ((paramFeedImageType == FeedImageLoader.FeedImageType.Photo) || (paramFeedImageType == FeedImageLoader.FeedImageType.Video))
      {
        j = 1;
        if (j == 0)
          break label173;
        if (paramGraphQLImage.height >= paramGraphQLImage.width)
          break label166;
        float f1 = i / paramGraphQLImage.width;
        if ((f1 == 0.0F) || (Float.isNaN(f1)))
          f1 = 1.0F;
        k = (int)(f1 * paramGraphQLImage.width);
        i = (int)(f1 * paramGraphQLImage.height);
        ImageCacheKey.OptionsBuilder localOptionsBuilder = ImageCacheKey.Options.newBuilder();
        localOptionsBuilder.a(k, i);
        localOptionsBuilder.a(ImageCacheKey.Options.DownscalingMethod.MaxScaleNonPowerOfTwo);
        localOptions = new ImageCacheKey.Options(localOptionsBuilder);
      }
    }
    for (FetchImageParams localFetchImageParams = new FetchImageParams(Uri.parse(paramGraphQLImage.uri), null, localOptions); ; localFetchImageParams = null)
    {
      return localFetchImageParams;
      j = 0;
      break;
      label166: k = i;
      break label105;
      label173: k = i;
      break label105;
    }
  }

  public void a()
  {
    this.e = this.a.getResources().getDimensionPixelSize(2131230776);
    Display localDisplay = this.a.getWindowManager().getDefaultDisplay();
    this.f = localDisplay.getWidth();
    this.g = (int)(0.888889F * localDisplay.getWidth());
  }

  public void a(FeedUnit paramFeedUnit)
  {
    a(paramFeedUnit, FeedImageLoader.FeedImageOperationType.Prefetch);
  }

  public int b(FeedImageLoader.FeedImageType paramFeedImageType)
  {
    return a(paramFeedImageType);
  }

  public void b(FeedUnit paramFeedUnit)
  {
    a(paramFeedUnit, FeedImageLoader.FeedImageOperationType.Warm);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedImageLoader
 * JD-Core Version:    0.6.0
 */