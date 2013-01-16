package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import java.util.Iterator;
import java.util.List;

public class StoryAttachmentViewList extends StoryAttachmentView
  implements DepthAwareView
{
  private final int e = 3;
  private final CustomLinearLayout f;
  private final Context g;
  private final StoryAttachmentViewFactory h;
  private final FeedRecyclableViewPoolManager i;

  public StoryAttachmentViewList(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
    setContentView(2130903186);
    this.f = ((CustomLinearLayout)b(2131296821));
    FbInjector localFbInjector = getInjector();
    this.i = ((FeedRecyclableViewPoolManager)localFbInjector.a(FeedRecyclableViewPoolManager.class));
    this.h = ((StoryAttachmentViewFactory)localFbInjector.a(StoryAttachmentViewFactory.class));
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if ((paramFeedStoryAttachment.subattachments == null) || (paramFeedStoryAttachment.subattachments.isEmpty()))
      setVisibility(8);
    int j;
    label48: StorySubAttachmentViewBase localStorySubAttachmentViewBase;
    while (true)
    {
      return;
      setVisibility(0);
      d();
      Iterator localIterator = paramFeedStoryAttachment.subattachments.iterator();
      j = 0;
      if (!localIterator.hasNext())
        break;
      FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
      if (j >= 3)
        continue;
      StoryAttachmentView.StoryAttachmentViewType localStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.SUBATTACHMENT;
      FeedRecyclableViewPoolManager localFeedRecyclableViewPoolManager = this.i;
      localStorySubAttachmentViewBase = (StorySubAttachmentViewBase)localFeedRecyclableViewPoolManager.a(StoryAttachmentViewFactory.a(localStoryAttachmentViewType));
      if (localStorySubAttachmentViewBase != null)
        break label178;
      localStorySubAttachmentViewBase = (StorySubAttachmentViewBase)this.h.a(this.g, localStoryAttachmentViewType);
      if (localStorySubAttachmentViewBase != null)
        this.f.addView(localStorySubAttachmentViewBase);
      label142: localStorySubAttachmentViewBase.a(localFeedStoryAttachment, paramFeedStory);
      if (j != 0)
        break label210;
      localStorySubAttachmentViewBase.e();
      if (paramFeedStory.sponsoredData == null)
        break label202;
      localStorySubAttachmentViewBase.f();
    }
    while (true)
    {
      j++;
      break label48;
      break;
      label178: this.f.attachRecyclableViewToParent(localStorySubAttachmentViewBase, this.f.getChildCount(), localStorySubAttachmentViewBase.getLayoutParams());
      break label142;
      label202: localStorySubAttachmentViewBase.g();
      continue;
      label210: localStorySubAttachmentViewBase.d();
      localStorySubAttachmentViewBase.g();
    }
  }

  public void d()
  {
    while (this.f.getChildCount() > 0)
    {
      StoryAttachmentView localStoryAttachmentView = (StoryAttachmentView)this.f.getChildAt(0);
      this.i.a(localStoryAttachmentView.getClass(), localStoryAttachmentView, this.f);
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.LIST;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewList
 * JD-Core Version:    0.6.0
 */