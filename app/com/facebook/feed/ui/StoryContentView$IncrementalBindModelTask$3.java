package com.facebook.feed.ui;

import android.widget.TextView;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedStory;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$3 extends IncrementalSingleTask
{
  protected void a()
  {
    if ((StoryContentView.h(this.b.e).e) && (this.b.a.message != null))
    {
      StoryContentView.j(this.b.e).a(StoryContentView.i(this.b.e), this.b.a.message, this.b.a, this.b.b.allowTruncation);
      this.b.e.a(this.b.a.t());
      StoryContentView.i(this.b.e).setVisibility(0);
    }
    while (true)
    {
      return;
      StoryContentView.i(this.b.e).setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.3
 * JD-Core Version:    0.6.0
 */