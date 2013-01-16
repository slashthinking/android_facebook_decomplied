package com.facebook.feed.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoClickedEvent;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage;

class NewsFeedPhotoAnimation$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    NewsFeedPhotoAnimation.a(this.f, this.a, this.b.media.id);
    NewsFeedPhotoAnimation.a(this.f).a(new PhotoEvents.SinglePhotoClickedEvent(this.c));
    if (this.d != null)
    {
      this.d.setAnimationDurationMs(NewsFeedPhotoAnimation.b(this.f));
      Bitmap localBitmap = NewsFeedPhotoAnimation.a(this.f, this.c, this.d);
      if (localBitmap != null)
      {
        NewsFeedPhotoAnimation.a(this.f, this.c, this.d, NewsFeedPhotoAnimation.VisibilityStates.PREP_BEFORE_AND_AFTER_ANIMATION);
        this.d.a(localBitmap, NewsFeedPhotoAnimation.a(this.f, this.c, this.a));
      }
      this.d.setOnPhotoAnimationEndListener(new NewsFeedPhotoAnimation.1.1(this));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation.1
 * JD-Core Version:    0.6.0
 */