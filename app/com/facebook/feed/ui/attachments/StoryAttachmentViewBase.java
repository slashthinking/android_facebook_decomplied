package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.base.BuildConstants;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.widget.UrlImage;

public class StoryAttachmentViewBase extends StoryAttachmentView
  implements DepthAwareView
{
  private final UrlImage e;
  private final TextView f;
  private final TextView g;

  public StoryAttachmentViewBase(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903165);
    this.e = ((UrlImage)b(2131296738));
    this.f = ((TextView)b(2131296748));
    this.g = ((TextView)b(2131296749));
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.image != null))
    {
      this.e.setVisibility(0);
      this.e.setImageParams(Uri.parse(paramFeedStoryAttachment.media.image.uri));
      this.f.setText(paramFeedStoryAttachment.title);
      if (paramFeedStoryAttachment.source != null)
        this.g.setText(paramFeedStoryAttachment.source.text);
      if (paramFeedStoryAttachment.url == null)
        break label174;
      a(paramFeedStoryAttachment.url, paramFeedStory, null);
      label94: if (!BuildConstants.a())
        break label181;
      View localView = b(2131296746);
      localView.setBackgroundResource(2130838231);
      localView.setPadding(2, 2, 2, 2);
      this.g.setText("RageShake me! " + paramFeedStoryAttachment.styleList.toString());
      this.g.setSingleLine(false);
    }
    while (true)
    {
      return;
      this.e.setVisibility(8);
      break;
      label174: c();
      break label94;
      label181: this.g.setSingleLine(true);
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    if (BuildConstants.a());
    for (StoryAttachmentView.StoryAttachmentViewType localStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.BASE; ; localStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.SHARE)
      return localStoryAttachmentViewType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewBase
 * JD-Core Version:    0.6.0
 */