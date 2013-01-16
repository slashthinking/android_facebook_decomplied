package com.facebook.feed.flyout;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.model.GraphQLProfile;
import java.util.List;

public class FeedAggregatedEntitiesAdapter extends AbstractFeedFlyoutActorAdapter
{
  private final List<GraphQLProfile> a;

  public FeedAggregatedEntitiesAdapter(List<GraphQLProfile> paramList)
  {
    this.a = paramList;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramView, (GraphQLProfile)getItem(paramInt), paramViewGroup);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedAggregatedEntitiesAdapter
 * JD-Core Version:    0.6.0
 */