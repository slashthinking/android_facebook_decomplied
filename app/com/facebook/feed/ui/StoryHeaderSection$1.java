package com.facebook.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLProfile;

class StoryHeaderSection$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (StoryHeaderSection.a(this.a) == null)
      return;
    FeedStoryMutator.Result localResult = StoryHeaderSection.c(this.a).a(StoryHeaderSection.b(this.a), StoryHeaderSection.a(this.a));
    if (FeedStory.PageStoryType.GROUPER_ATTACHED_STORY.equals(StoryHeaderSection.b(this.a).A()))
      StoryHeaderSection.a(this.a, localResult.b().attachedStory);
    while (true)
    {
      StoryHeaderSection.a(this.a, localResult.b().f());
      StoryHeaderSection.d(this.a).a(new UfiEvents.PageLikeClickedEvent(localResult.b().getCacheId(), StoryHeaderSection.a(this.a).page.id));
      StoryHeaderSection.a(this.a, true);
      break;
      if (!FeedStory.PageStoryType.NCPP.equals(StoryHeaderSection.b(this.a).A()))
        continue;
      StoryHeaderSection.a(this.a, localResult.b());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryHeaderSection.1
 * JD-Core Version:    0.6.0
 */