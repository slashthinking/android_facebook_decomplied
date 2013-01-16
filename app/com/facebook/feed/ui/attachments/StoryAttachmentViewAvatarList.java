package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.Iterator;
import java.util.List;

public class StoryAttachmentViewAvatarList extends StoryAttachmentView
{
  private final LinearLayout e;
  private final FeedRendererOptions f;
  private final FeedImageLoader g;

  public StoryAttachmentViewAvatarList(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewAvatarList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    FbInjector localFbInjector = getInjector();
    setContentView(2130903164);
    this.e = ((LinearLayout)b(2131296745));
    this.f = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.g = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    this.e.removeAllViews();
    Iterator localIterator = paramFeedStoryAttachment.subattachments.iterator();
    while (true)
    {
      FeedStoryAttachment localFeedStoryAttachment;
      if (localIterator.hasNext())
      {
        localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
        if (this.e.getChildCount() < 4);
      }
      else
      {
        return;
      }
      if ((localFeedStoryAttachment.media == null) || (localFeedStoryAttachment.media.image == null))
        continue;
      UrlImage localUrlImage = new UrlImage(this.c);
      localUrlImage.setPadding(2, 0, 2, 0);
      localUrlImage.setLayoutParams(new LinearLayout.LayoutParams(this.g.a(FeedImageLoader.FeedImageType.AvatarList), this.g.b(FeedImageLoader.FeedImageType.AvatarList)));
      localUrlImage.setImageParams(this.g.a(localFeedStoryAttachment.media.image, FeedImageLoader.FeedImageType.AvatarList));
      this.e.addView(localUrlImage);
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.AVATAR_LIST;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewAvatarList
 * JD-Core Version:    0.6.0
 */