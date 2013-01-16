package com.facebook.feed.cache;

import com.facebook.graphql.model.FeedStory;
import com.google.common.primitives.Longs;
import java.util.Comparator;

class StoryUpdate$StoryUpdateComparator
  implements Comparator<StoryUpdate>
{
  public int a(StoryUpdate paramStoryUpdate1, StoryUpdate paramStoryUpdate2)
  {
    return Longs.a(StoryUpdate.a(paramStoryUpdate2).getFetchTimeMs(), StoryUpdate.a(paramStoryUpdate1).getFetchTimeMs());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.StoryUpdate.StoryUpdateComparator
 * JD-Core Version:    0.6.0
 */