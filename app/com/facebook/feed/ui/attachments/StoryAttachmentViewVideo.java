package com.facebook.feed.ui.attachments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;

public class StoryAttachmentViewVideo extends StoryAttachmentView
{
  private static int e;
  private final UrlImage f;
  private FeedStoryAttachment g;
  private final IFeedIntentBuilder h;
  private Display i = ((Activity)this.c).getWindowManager().getDefaultDisplay();
  private ImageCacheKey.OptionsBuilder j;
  private ImageView k;
  private final FeedRendererOptions l;
  private final FeedImageLoader m;

  public StoryAttachmentViewVideo(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903168);
    this.f = ((UrlImage)b(2131296763));
    this.f.setPlaceHolderDrawable(null);
    this.f.setPlaceholderBackgroundResourceId(2131165264);
    this.k = ((ImageView)b(2131296465));
    this.k.bringToFront();
    FbInjector localFbInjector = getInjector();
    this.m = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.l = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.f.setLoadResolutionDuringScroll(this.l.d);
    this.h = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.j = ImageCacheKey.Options.newBuilder();
  }

  public static boolean a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    if ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.playableUrl != null) && (paramFeedStoryAttachment.media.isPlayable) && (paramFeedStoryAttachment.media.image != null) && (GraphQLObjectType.ObjectType.Video.equals(paramFeedStoryAttachment.media.objectType.a())));
    for (int n = 1; ; n = 0)
      return n;
  }

  private void d()
  {
    e = this.i.getWidth();
    GraphQLImage localGraphQLImage = this.g.media.image;
    FetchImageParams localFetchImageParams = null;
    int i1;
    int n;
    if (localGraphQLImage != null)
    {
      localFetchImageParams = this.m.a(this.g.media.image, FeedImageLoader.FeedImageType.Video);
      if (localFetchImageParams != null)
      {
        i1 = localFetchImageParams.c().b;
        n = localFetchImageParams.c().c;
      }
    }
    while (true)
    {
      this.f.setImageParams(localFetchImageParams);
      ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = i1;
        localLayoutParams.height = n;
        this.f.setLayoutParams(localLayoutParams);
      }
      return;
      n = 0;
      i1 = 0;
    }
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if (a(paramFeedStoryAttachment))
    {
      this.g = paramFeedStoryAttachment;
      d();
      setVisibility(0);
      Intent localIntent = this.h.a(this.g.media.playableUrl);
      FeedStoryAttachmentTarget localFeedStoryAttachmentTarget = this.g.target;
      HoneyClientEvent localHoneyClientEvent = null;
      if (localFeedStoryAttachmentTarget != null)
      {
        FeedStory localFeedStory = this.g.a;
        localHoneyClientEvent = null;
        if (localFeedStory != null)
          localHoneyClientEvent = this.d.c(this.g.target.id, this.g.a.k());
      }
      if (localIntent != null)
        a(localIntent, localHoneyClientEvent);
    }
    while (true)
    {
      return;
      c();
      continue;
      setVisibility(8);
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.VIDEO;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewVideo
 * JD-Core Version:    0.6.0
 */