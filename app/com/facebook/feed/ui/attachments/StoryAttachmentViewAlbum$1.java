package com.facebook.feed.ui.attachments;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.photos.AlbumIndexCache;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import java.util.List;

class StoryAttachmentViewAlbum$1
  implements AdapterView.OnItemSelectedListener
{
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FeedStoryAttachmentTarget localFeedStoryAttachmentTarget2;
    String str1;
    if (paramInt != StoryAttachmentViewAlbum.a(this.a))
    {
      FeedStoryAttachmentTarget localFeedStoryAttachmentTarget1 = ((FeedStoryAttachment)StoryAttachmentViewAlbum.b(this.a).get(StoryAttachmentViewAlbum.a(this.a))).target;
      FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)StoryAttachmentViewAlbum.b(this.a).get(paramInt);
      localFeedStoryAttachmentTarget2 = localFeedStoryAttachment.target;
      if ((localFeedStoryAttachment.media != null) && (localFeedStoryAttachment.media.image != null) && (localFeedStoryAttachment.media.image.uri != null))
        StoryAttachmentViewAlbum.d(this.a).a(StoryAttachmentViewAlbum.c(this.a), Uri.parse(localFeedStoryAttachment.media.image.uri));
      if (localFeedStoryAttachmentTarget1 == null)
        break label196;
      str1 = localFeedStoryAttachmentTarget1.id;
      if (localFeedStoryAttachmentTarget2 == null)
        break label238;
    }
    for (String str2 = localFeedStoryAttachmentTarget2.id; ; str2 = null)
    {
      HoneyClientEvent localHoneyClientEvent = this.a.d.a(str1, str2, StoryAttachmentViewAlbum.e(this.a));
      StoryAttachmentViewAlbum.f(this.a).b(localHoneyClientEvent);
      StoryAttachmentViewAlbum.a(this.a, paramInt);
      return;
      label196: Log.e("Bad GraphQL data", "Story subattachment " + StoryAttachmentViewAlbum.a(this.a) + " has no target");
      str1 = null;
      break;
      label238: Log.e("Bad GraphQL data", "Story subattachment " + paramInt + " has no target");
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewAlbum.1
 * JD-Core Version:    0.6.0
 */