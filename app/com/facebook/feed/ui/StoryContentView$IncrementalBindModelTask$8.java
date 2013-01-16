package com.facebook.feed.ui;

import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.footer.StoryFooterSection;
import com.facebook.graphql.model.FeedStory;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$8 extends IncrementalSingleTask
{
  protected void a()
  {
    if (StoryContentView.h(this.b.e).j)
    {
      if ((this.b.a.w()) && (!this.b.a.n()))
        break label84;
      StoryContentView.o(this.b.e).a(this.b.a, this.b.b);
      StoryContentView.o(this.b.e).setVisibility(0);
    }
    while (true)
    {
      return;
      label84: StoryContentView.o(this.b.e).setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.8
 * JD-Core Version:    0.6.0
 */