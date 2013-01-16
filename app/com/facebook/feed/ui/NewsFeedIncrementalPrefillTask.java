package com.facebook.feed.ui;

import android.app.Activity;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.attachments.StoryAttachmentView;
import com.facebook.feed.ui.attachments.StoryAttachmentView.StoryAttachmentViewType;
import com.facebook.feed.ui.attachments.StoryAttachmentViewFactory;
import com.facebook.feed.ui.location.StoryLocationViewMore;
import com.facebook.feed.ui.location.StoryLocationViewPlace;
import com.facebook.feed.ui.location.StoryLocationViewProfile;
import com.facebook.orca.activity.FbFragment;

public class NewsFeedIncrementalPrefillTask
{
  private final Activity a;
  private final FeedRecyclableViewPoolManager b;
  private final StoryAttachmentViewFactory c;

  public NewsFeedIncrementalPrefillTask(FbFragment paramFbFragment, FeedRecyclableViewPoolManager paramFeedRecyclableViewPoolManager, StoryAttachmentViewFactory paramStoryAttachmentViewFactory)
  {
    this.b = paramFeedRecyclableViewPoolManager;
    this.c = paramStoryAttachmentViewFactory;
    this.a = paramFbFragment.n();
  }

  public void a()
  {
    if (this.a == null)
      return;
    this.b.a(SubStoryView.class, new NewsFeedIncrementalPrefillTask.1(this), this.a);
    this.b.a(StoryLocationViewProfile.class, new NewsFeedIncrementalPrefillTask.2(this), this.a);
    this.b.a(StoryLocationViewPlace.class, new NewsFeedIncrementalPrefillTask.3(this), this.a);
    this.b.a(StoryLocationViewMore.class, new NewsFeedIncrementalPrefillTask.4(this), this.a);
    StoryAttachmentView.StoryAttachmentViewType[] arrayOfStoryAttachmentViewType = StoryAttachmentView.StoryAttachmentViewType.values();
    int i = arrayOfStoryAttachmentViewType.length;
    int j = 0;
    label101: StoryAttachmentView localStoryAttachmentView;
    if (j < i)
    {
      StoryAttachmentView.StoryAttachmentViewType localStoryAttachmentViewType = arrayOfStoryAttachmentViewType[j];
      localStoryAttachmentView = this.c.a(this.a, localStoryAttachmentViewType);
      if (localStoryAttachmentView != null)
        break label137;
    }
    while (true)
    {
      j++;
      break label101;
      break;
      label137: this.b.a(localStoryAttachmentView.getClass(), new NewsFeedIncrementalPrefillTask.5(this, localStoryAttachmentView), this.a);
    }
  }

  public void b()
  {
    this.b.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedIncrementalPrefillTask
 * JD-Core Version:    0.6.0
 */