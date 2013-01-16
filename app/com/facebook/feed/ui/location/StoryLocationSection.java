package com.facebook.feed.ui.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.MapImage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Iterator;
import java.util.List;

public class StoryLocationSection extends CustomRelativeLayout
  implements DepthAwareView
{
  private final Context a;
  private final MapImage b;
  private final CustomLinearLayout c;
  private ArrayNode d;
  private final NewsFeedAnalyticsEventBuilder e;
  private final StoryLocationViewFactory f;
  private final FeedRecyclableViewPoolManager g;
  private final FeedRendererOptions h;
  private final int i;

  public StoryLocationSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryLocationSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StoryLocationSection(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    FbInjector localFbInjector = getInjector();
    this.e = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.f = ((StoryLocationViewFactory)localFbInjector.a(StoryLocationViewFactory.class));
    this.g = ((FeedRecyclableViewPoolManager)localFbInjector.a(FeedRecyclableViewPoolManager.class));
    setContentView(2130903181);
    this.b = ((MapImage)b(2131296813));
    this.c = ((CustomLinearLayout)b(2131296815));
    this.h = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.i = FeedUtils.a(paramContext);
  }

  private void a()
  {
    while (true)
    {
      int j = this.c.getChildCount();
      if (j <= 0)
        break;
      StoryLocationView localStoryLocationView = (StoryLocationView)this.c.getChildAt(j - 1);
      this.g.a(localStoryLocationView.getClass(), localStoryLocationView, this.c);
    }
  }

  private StoryLocationViewProfile c(int paramInt)
  {
    View localView1 = this.c.getChildAt(paramInt);
    StoryLocationViewProfile localStoryLocationViewProfile;
    if ((localView1 != null) && ((localView1 instanceof StoryLocationViewProfile)))
      localStoryLocationViewProfile = (StoryLocationViewProfile)localView1;
    while (true)
    {
      return localStoryLocationViewProfile;
      View localView2 = this.g.a(StoryLocationViewProfile.class);
      if (localView2 != null)
      {
        this.c.attachRecyclableViewToParent(localView2, this.c.getChildCount(), localView2.getLayoutParams());
        localStoryLocationViewProfile = (StoryLocationViewProfile)localView2;
        continue;
      }
      localStoryLocationViewProfile = (StoryLocationViewProfile)this.f.a(this.a, StoryLocationView.StoryLocationViewType.PROFILE);
      this.c.addView(localStoryLocationViewProfile);
    }
  }

  private StoryLocationViewMore getStoryLocationViewMore()
  {
    int j = -1 + this.i;
    View localView1 = this.c.getChildAt(j);
    StoryLocationViewMore localStoryLocationViewMore;
    if ((localView1 != null) && ((localView1 instanceof StoryLocationViewMore)))
      localStoryLocationViewMore = (StoryLocationViewMore)localView1;
    while (true)
    {
      return localStoryLocationViewMore;
      View localView2 = this.g.a(StoryLocationViewMore.class);
      if (localView2 != null)
      {
        this.c.attachRecyclableViewToParent(localView2, this.c.getChildCount(), localView2.getLayoutParams());
        localStoryLocationViewMore = (StoryLocationViewMore)localView2;
        continue;
      }
      localStoryLocationViewMore = (StoryLocationViewMore)this.f.a(this.a, StoryLocationView.StoryLocationViewType.MORE);
      this.c.addView(localStoryLocationViewMore);
    }
  }

  private StoryLocationViewPlace getStoryLocationViewPlace()
  {
    View localView1 = this.c.getChildAt(0);
    StoryLocationViewPlace localStoryLocationViewPlace;
    if (localView1 != null)
      localStoryLocationViewPlace = (StoryLocationViewPlace)localView1;
    while (true)
    {
      return localStoryLocationViewPlace;
      View localView2 = this.g.a(StoryLocationViewPlace.class);
      if (localView2 != null)
      {
        this.c.attachRecyclableViewToParent(localView2, this.c.getChildCount(), localView2.getLayoutParams());
        localStoryLocationViewPlace = (StoryLocationViewPlace)localView2;
        continue;
      }
      localStoryLocationViewPlace = (StoryLocationViewPlace)this.f.a(this.a, StoryLocationView.StoryLocationViewType.PLACE);
      this.c.addView(localStoryLocationViewPlace);
    }
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.a, this, paramInt, 0);
  }

  public void a(FeedStory paramFeedStory)
  {
    if ((!paramFeedStory.q()) || (paramFeedStory.d()) || (!this.h.a))
    {
      setVisibility(8);
      a();
    }
    int j;
    while (true)
    {
      return;
      break label175;
      a(paramFeedStory.t());
      this.d = paramFeedStory.k();
      setVisibility(0);
      this.b.setCenter(paramFeedStory.explicitPlace.location.latitude, paramFeedStory.explicitPlace.location.longitude);
      List localList = paramFeedStory.r();
      if (localList == null)
        break;
      if (this.c.getChildCount() == 1)
        a();
      Iterator localIterator = localList.iterator();
      j = 0;
      label118: GraphQLProfile localGraphQLProfile;
      if (localIterator.hasNext())
      {
        localGraphQLProfile = (GraphQLProfile)localIterator.next();
        if ((j == -1 + this.i) && (localList.size() > this.i))
        {
          getStoryLocationViewMore().a(localList);
          j++;
        }
      }
      else
      {
        label175: 
        while (this.c.getChildCount() > localList.size())
        {
          StoryLocationView localStoryLocationView = (StoryLocationView)this.c.getChildAt(j);
          this.g.a(localStoryLocationView.getClass(), localStoryLocationView, this.c);
        }
        continue;
      }
      if (j >= this.i)
        continue;
      if (localGraphQLProfile.profilePicture == null)
        break label316;
      c(j).a(localGraphQLProfile);
    }
    label316: for (int k = j + 1; ; k = j)
    {
      j = k;
      break label118;
      if (this.c.getChildCount() > 1)
        a();
      HoneyClientEvent localHoneyClientEvent = this.e.a(paramFeedStory.explicitPlace.url, this.d);
      getStoryLocationViewPlace().a(paramFeedStory.explicitPlace, localHoneyClientEvent);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationSection
 * JD-Core Version:    0.6.0
 */