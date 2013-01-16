package com.facebook.feed.ui;

import com.facebook.feed.renderer.recycle.IRecyclableViewFactory;
import com.facebook.feed.ui.location.StoryLocationViewProfile;

class NewsFeedIncrementalPrefillTask$2
  implements IRecyclableViewFactory<StoryLocationViewProfile>
{
  public StoryLocationViewProfile b()
  {
    return new StoryLocationViewProfile(NewsFeedIncrementalPrefillTask.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedIncrementalPrefillTask.2
 * JD-Core Version:    0.6.0
 */