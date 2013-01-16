package com.facebook.feed.ui;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.graphql.model.FeedStory;
import com.facebook.task.IncrementalSingleTask;

class StoryContentView$IncrementalBindModelTask$9 extends IncrementalSingleTask
{
  protected void a()
  {
    int i;
    if ((StoryContentView.h(this.b.e).k) && (this.b.a.a == null))
      switch (StoryContentView.1.a[this.b.a.L().ordinal()])
      {
      default:
        i = 2131165243;
      case 1:
      case 2:
      }
    while (true)
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)this.b.e.getResources().getDrawable(2130838235);
      ((GradientDrawable)localLayerDrawable.findDrawableByLayerId(2131298005)).setColor(this.b.e.getResources().getColor(i));
      this.b.e.setBackgroundDrawable(localLayerDrawable);
      this.b.a = null;
      this.b.b = null;
      return;
      i = 2131165286;
      continue;
      i = 2131165287;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView.IncrementalBindModelTask.9
 * JD-Core Version:    0.6.0
 */