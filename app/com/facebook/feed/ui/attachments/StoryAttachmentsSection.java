package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentType.KnownAttachmentType;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import java.util.Iterator;
import java.util.List;

public class StoryAttachmentsSection extends CustomLinearLayout
{
  private final Context a;
  private final FeedRecyclableViewPoolManager b;
  private final StoryAttachmentViewFactory c;

  public StoryAttachmentsSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentsSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    FbInjector localFbInjector = getInjector();
    this.b = ((FeedRecyclableViewPoolManager)localFbInjector.a(FeedRecyclableViewPoolManager.class));
    this.c = ((StoryAttachmentViewFactory)localFbInjector.a(StoryAttachmentViewFactory.class));
  }

  private StoryAttachmentView a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    FeedStoryAttachmentType.KnownAttachmentType localKnownAttachmentType = paramFeedStoryAttachment.j();
    Object localObject;
    StoryAttachmentView localStoryAttachmentView;
    switch (StoryAttachmentsSection.1.a[localKnownAttachmentType.ordinal()])
    {
    default:
      localObject = StoryAttachmentView.StoryAttachmentViewType.BASE;
      localStoryAttachmentView = (StoryAttachmentView)this.b.a(StoryAttachmentViewFactory.a((StoryAttachmentView.StoryAttachmentViewType)localObject));
      if (localStoryAttachmentView == null)
        break;
      attachRecyclableViewToParent(localStoryAttachmentView, getChildCount(), localStoryAttachmentView.getLayoutParams());
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (true)
    {
      return localStoryAttachmentView;
      if (StoryAttachmentViewVideo.a(paramFeedStoryAttachment))
      {
        localObject = StoryAttachmentView.StoryAttachmentViewType.VIDEO;
        break;
      }
      if (StoryAttachmentViewAddFriend.a(paramFeedStoryAttachment))
      {
        localObject = StoryAttachmentView.StoryAttachmentViewType.ADD_FRIEND;
        break;
      }
      localObject = StoryAttachmentView.StoryAttachmentViewType.SHARE;
      break;
      localObject = StoryAttachmentView.StoryAttachmentViewType.PHOTO;
      break;
      localObject = StoryAttachmentView.StoryAttachmentViewType.ALBUM;
      break;
      localStoryAttachmentView = null;
      continue;
      localObject = StoryAttachmentView.StoryAttachmentViewType.LIST;
      break;
      if (StoryAttachmentViewCoupon.a(paramFeedStoryAttachment));
      for (StoryAttachmentView.StoryAttachmentViewType localStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.COUPON; ; localStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.SHARE)
      {
        localObject = localStoryAttachmentViewType;
        break;
      }
      localObject = StoryAttachmentView.StoryAttachmentViewType.SHARE;
      break;
      localStoryAttachmentView = this.c.a(this.a, (StoryAttachmentView.StoryAttachmentViewType)localObject);
      addView(localStoryAttachmentView);
    }
  }

  private void a()
  {
    while (true)
    {
      int i = getChildCount();
      if (i <= 0)
        break;
      StoryAttachmentView localStoryAttachmentView = (StoryAttachmentView)getChildAt(i - 1);
      if ((localStoryAttachmentView instanceof StoryAttachmentViewList))
        ((StoryAttachmentViewList)localStoryAttachmentView).d();
      this.b.a(localStoryAttachmentView.getClass(), localStoryAttachmentView, this);
    }
  }

  public void a(FeedStory paramFeedStory)
  {
    a();
    if (!paramFeedStory.d())
      setVisibility(8);
    while (true)
    {
      return;
      setVisibility(0);
      Iterator localIterator = paramFeedStory.attachments.iterator();
      while (localIterator.hasNext())
      {
        FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
        if (paramFeedStory.a(localFeedStoryAttachment))
          continue;
        paramFeedStory.b(localFeedStoryAttachment);
        StoryAttachmentView localStoryAttachmentView = a(localFeedStoryAttachment);
        if (localStoryAttachmentView == null)
          continue;
        if ((localStoryAttachmentView instanceof DepthAwareView))
          ((DepthAwareView)localStoryAttachmentView).a(1 + paramFeedStory.t());
        localStoryAttachmentView.a(localFeedStoryAttachment, paramFeedStory);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentsSection
 * JD-Core Version:    0.6.0
 */