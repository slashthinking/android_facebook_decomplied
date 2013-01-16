package com.facebook.feed.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.NewsFeedImageAdapter;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEvent;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

class NewsFeedPhotoAnimation$2
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GraphQLMedia localGraphQLMedia = ((FeedStoryAttachment)paramAdapterView.getAdapter().getItem(paramInt)).media;
    UrlImage localUrlImage = ((NewsFeedImageAdapter)paramAdapterView.getAdapter()).a(paramView);
    NewsFeedPhotoAnimation.a(this.i, this.a, localGraphQLMedia.id);
    NewsFeedPhotoAnimation.a(this.i).a(new PhotoEvents.GalleryPhotoClickedEvent(localUrlImage, (NewsFeedImageAdapter)paramAdapterView.getAdapter()));
    if (this.b != null)
    {
      this.b.setAnimationDurationMs(NewsFeedPhotoAnimation.b(this.i));
      Bitmap localBitmap = NewsFeedPhotoAnimation.a(this.i, localUrlImage, this.b);
      if (localBitmap != null)
      {
        NewsFeedPhotoAnimation.a(this.i, localUrlImage, this.b, NewsFeedPhotoAnimation.VisibilityStates.PREP_BEFORE_AND_AFTER_ANIMATION);
        this.b.a(localBitmap, NewsFeedPhotoAnimation.a(this.i, localUrlImage, this.a));
      }
      this.b.setOnPhotoAnimationEndListener(new NewsFeedPhotoAnimation.2.1(this, localGraphQLMedia, localUrlImage));
      FeedStoryAttachmentTarget localFeedStoryAttachmentTarget = ((FeedStoryAttachment)this.g.get(paramInt)).target;
      if (localFeedStoryAttachmentTarget != null)
      {
        HoneyClientEvent localHoneyClientEvent = NewsFeedPhotoAnimation.d(this.i).b(localFeedStoryAttachmentTarget.id, this.h);
        NewsFeedPhotoAnimation.c(this.i).b(localHoneyClientEvent);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation.2
 * JD-Core Version:    0.6.0
 */