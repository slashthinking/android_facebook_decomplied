package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.List;

public class StoryAttachmentViewShare extends StoryAttachmentView
  implements DepthAwareView
{
  private final UrlImage e;
  private final TextView f;
  private final TextView g;
  private final ImageView h;
  private final FeedRendererOptions i;
  private final FeedImageLoader j;

  public StoryAttachmentViewShare(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewShare(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StoryAttachmentViewShare(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 2130903165);
  }

  public StoryAttachmentViewShare(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet);
    setContentView(paramInt2);
    this.e = ((UrlImage)b(2131296738));
    this.e.setPlaceHolderDrawable(null);
    this.e.setPlaceholderBackgroundResourceId(2131165264);
    this.f = ((TextView)b(2131296748));
    this.g = ((TextView)b(2131296749));
    this.h = ((ImageView)b(2131296747));
    FbInjector localFbInjector = getInjector();
    this.j = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.i = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.e.setLoadResolutionDuringScroll(this.i.d);
  }

  private String b(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    String str;
    if (paramFeedStoryAttachment.title != null)
      str = paramFeedStoryAttachment.title;
    while (true)
    {
      return str;
      if ((paramFeedStoryAttachment.e()) && (paramFeedStory.message != null) && (paramFeedStory.message.text != null))
      {
        str = paramFeedStory.message.text;
        continue;
      }
      str = "";
    }
  }

  private String c(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if (paramFeedStoryAttachment.b() != null);
    for (String str = paramFeedStoryAttachment.b().text; ; str = null)
    {
      if ((str == null) && (paramFeedStoryAttachment.e()) && (paramFeedStoryAttachment.h()))
        str = ((FeedStoryAttachment)paramFeedStoryAttachment.subattachments.get(0)).title;
      return str;
    }
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.image != null))
    {
      this.e.setVisibility(0);
      this.e.setImageParams(this.j.a(paramFeedStoryAttachment.media.image, FeedImageLoader.FeedImageType.Share));
      if (!paramFeedStoryAttachment.media.isPlayable)
        break label331;
      this.h.setVisibility(0);
      this.h.bringToFront();
      bool2 = bool1;
    }
    while (true)
    {
      String str1 = b(paramFeedStoryAttachment, paramFeedStory);
      String str2 = c(paramFeedStoryAttachment, paramFeedStory);
      this.f.setText(str1);
      setSubTitleText(str2);
      String str3;
      label152: HoneyClientEvent localHoneyClientEvent2;
      String str4;
      HoneyClientEvent localHoneyClientEvent1;
      if (paramFeedStoryAttachment.url != null)
      {
        str3 = paramFeedStoryAttachment.url;
        if (paramFeedStoryAttachment.l())
        {
          NewsFeedAnalyticsEventBuilder localNewsFeedAnalyticsEventBuilder = this.d;
          String str5 = paramFeedStoryAttachment.target.id;
          if (paramFeedStory.sponsoredData != null)
          {
            localHoneyClientEvent2 = localNewsFeedAnalyticsEventBuilder.a(str5, "open_graph", bool1, paramFeedStory.k());
            if ((paramFeedStoryAttachment.target.androidUrls == null) || (paramFeedStoryAttachment.target.androidUrls.size() <= 0))
              break label320;
            str4 = (String)paramFeedStoryAttachment.target.androidUrls.get(0);
            localHoneyClientEvent1 = localHoneyClientEvent2;
          }
        }
      }
      while (true)
      {
        label215: a(str4, paramFeedStory, localHoneyClientEvent1);
        label224: if ((!bool2) && (StringUtil.a(str1)) && (StringUtil.a(str2)))
          setVisibility(8);
        while (true)
        {
          return;
          this.e.setVisibility(8);
          this.h.setVisibility(8);
          bool2 = false;
          break;
          bool1 = false;
          break label152;
          localHoneyClientEvent1 = this.d.a(paramFeedStoryAttachment.url, paramFeedStory.k());
          str4 = str3;
          break label215;
          c();
          break label224;
          setVisibility(0);
        }
        label320: str4 = str3;
        localHoneyClientEvent1 = localHoneyClientEvent2;
      }
      label331: bool2 = bool1;
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.SHARE;
  }

  protected void setSubTitleText(String paramString)
  {
    if (StringUtil.a(paramString))
      this.g.setVisibility(8);
    while (true)
    {
      return;
      this.g.setText(paramString);
      this.g.setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewShare
 * JD-Core Version:    0.6.0
 */