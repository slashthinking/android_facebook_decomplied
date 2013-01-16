package com.facebook.feed.photos;

import android.app.Activity;
import android.content.Context;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage;

public class NewsFeedPhotoAnimator
{
  private final NewsFeedPhotoAnimation a;

  public NewsFeedPhotoAnimator(NewsFeedPhotoAnimation paramNewsFeedPhotoAnimation)
  {
    this.a = paramNewsFeedPhotoAnimation;
  }

  public static ExpandablePhoto a(Activity paramActivity)
  {
    return (ExpandablePhoto)paramActivity.findViewById(2131296268);
  }

  public void a(ExpandablePhoto paramExpandablePhoto, Context paramContext, FeedPhotoState paramFeedPhotoState)
  {
    UrlImage localUrlImage1 = paramFeedPhotoState.d();
    if (localUrlImage1 != null)
      this.a.a(paramExpandablePhoto, localUrlImage1, paramContext, paramFeedPhotoState);
    UrlImage localUrlImage2 = paramFeedPhotoState.c();
    if (localUrlImage2 != null)
      this.a.a(paramExpandablePhoto, localUrlImage2, paramContext, paramFeedPhotoState);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimator
 * JD-Core Version:    0.6.0
 */