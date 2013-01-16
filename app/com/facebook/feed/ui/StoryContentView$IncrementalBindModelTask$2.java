package com.facebook.feed.ui;

import android.view.View;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$2 extends IncrementalSingleTask
{
  protected void a()
  {
    if ((this.b.a.a != null) && (this.b.a.a.w()))
    {
      FeedUtils.a(StoryContentView.b(this.b.e), StoryContentView.c(this.b.e), StoryContentView.d(this.b.e).t(), 0);
      StoryContentView.c(this.b.e).setVisibility(0);
      StoryContentView.e(this.b.e).setVisibility(8);
      StoryContentView.f(this.b.e).setVisibility(8);
    }
    while (true)
    {
      StoryHeaderSection localStoryHeaderSection = StoryContentView.g(this.b.e);
      FeedStory localFeedStory = this.b.a;
      boolean bool1 = this.b.c;
      boolean bool2 = false;
      if (bool1)
      {
        boolean bool3 = FeedStory.PageStoryType.NCPP.equals(this.b.a.A());
        bool2 = false;
        if (!bool3)
          bool2 = true;
      }
      localStoryHeaderSection.a(localFeedStory, bool2);
      return;
      StoryContentView.c(this.b.e).setVisibility(8);
      StoryContentView.f(this.b.e).setVisibility(0);
      if (this.b.b.equals(FeedUnitViewStyle.SUBSTORY))
      {
        StoryContentView.e(this.b.e).setVisibility(8);
        continue;
      }
      StoryContentView.e(this.b.e).setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.2
 * JD-Core Version:    0.6.0
 */