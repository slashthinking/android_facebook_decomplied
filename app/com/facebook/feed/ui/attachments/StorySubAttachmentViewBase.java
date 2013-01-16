package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.common.util.StringUtil;

public class StorySubAttachmentViewBase extends StoryAttachmentViewShare
{
  protected final View e = b(2131296820);
  protected final TextView f = (TextView)b(2131296750);
  protected final View g = b(2131296819);

  public StorySubAttachmentViewBase(Context paramContext)
  {
    this(paramContext, null);
  }

  public StorySubAttachmentViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StorySubAttachmentViewBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 2130903185);
  }

  public void a(int paramInt)
  {
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    super.a(paramFeedStoryAttachment, paramFeedStory);
    if (paramFeedStoryAttachment.d())
    {
      this.e.setVisibility(0);
      if (paramFeedStoryAttachment.c())
        if (paramFeedStoryAttachment.target.socialUsageSentence == null)
          break label81;
    }
    label81: for (GraphQLTextWithEntities localGraphQLTextWithEntities = paramFeedStoryAttachment.target.socialUsageSentence; ; localGraphQLTextWithEntities = paramFeedStoryAttachment.target.globalUsageSentence)
    {
      if ((localGraphQLTextWithEntities != null) && (!StringUtil.a(localGraphQLTextWithEntities.text)))
        setSubTitleText(localGraphQLTextWithEntities.text);
      return;
      this.e.setVisibility(8);
      break;
    }
  }

  public void d()
  {
    this.g.setVisibility(0);
  }

  public void e()
  {
    this.g.setVisibility(8);
  }

  public void f()
  {
    Context localContext = getContext();
    this.f.setText(localContext.getString(2131362085));
    this.f.setVisibility(0);
  }

  public void g()
  {
    this.f.setVisibility(8);
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.SUBATTACHMENT;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StorySubAttachmentViewBase
 * JD-Core Version:    0.6.0
 */