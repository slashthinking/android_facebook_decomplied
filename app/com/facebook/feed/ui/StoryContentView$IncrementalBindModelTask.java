package com.facebook.feed.ui;

import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.graphql.model.FeedStory;
import com.facebook.task.IncrementalCompositeTask;
import com.facebook.task.IncrementalSingleTask;
import com.google.common.collect.ImmutableList;

public class StoryContentView$IncrementalBindModelTask extends IncrementalSingleTask
{
  protected FeedStory a;
  protected FeedUnitViewStyle b;
  protected boolean c;
  protected final IncrementalCompositeTask<IncrementalSingleTask> d;

  public StoryContentView$IncrementalBindModelTask(StoryContentView paramStoryContentView)
  {
    this.d = new IncrementalCompositeTask(ImmutableList.a(new StoryContentView.IncrementalBindModelTask.1(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.2(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.3(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.4(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.5(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.6(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.7(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.8(this, paramStoryContentView), new StoryContentView.IncrementalBindModelTask.9(this, paramStoryContentView)));
  }

  protected void a()
  {
    this.d.b();
    b(this.d);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    b();
    this.a = paramFeedStory;
    this.b = paramFeedUnitViewStyle;
    this.c = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask
 * JD-Core Version:    0.6.0
 */