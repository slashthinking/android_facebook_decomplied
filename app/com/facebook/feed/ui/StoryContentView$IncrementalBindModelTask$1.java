package com.facebook.feed.ui;

import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$1 extends IncrementalSingleTask
{
  protected void a()
  {
    if (this.b.a.A() == FeedStory.PageStoryType.NCPP)
    {
      StoryContentView.a(this.b.e).a(this.b.a.t());
      StoryContentView.a(this.b.e).setVisibility(0);
      StoryContentView.a(this.b.e).setMenuButtonVisibility(this.b.c);
    }
    while (true)
    {
      return;
      StoryContentView.a(this.b.e).setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.1
 * JD-Core Version:    0.6.0
 */