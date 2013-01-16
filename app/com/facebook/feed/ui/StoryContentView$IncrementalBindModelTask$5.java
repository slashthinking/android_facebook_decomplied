package com.facebook.feed.ui;

import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.graphql.model.FeedStory;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$5 extends IncrementalSingleTask
{
  protected void a()
  {
    if (StoryContentView.h(this.b.e).h)
    {
      if ((this.b.a.attachedStory != null) && (this.b.a.attachedStory.s() < 2))
        break label75;
      if (StoryContentView.l(this.b.e) != null)
        StoryContentView.l(this.b.e).setVisibility(8);
    }
    while (true)
    {
      return;
      label75: this.b.e.a();
      StoryContentView.l(this.b.e).setVisibility(0);
      StoryContentView.l(this.b.e).a(this.b.a.attachedStory, this.b.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.5
 * JD-Core Version:    0.6.0
 */