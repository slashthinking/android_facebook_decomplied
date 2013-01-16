package com.facebook.feed.flyout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.graphql.model.GraphQLProfile;

abstract class AbstractFeedFlyoutActorAdapter extends BaseAdapter
{
  protected View a(View paramView, GraphQLProfile paramGraphQLProfile, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    for (FeedFlyoutLikerView localFeedFlyoutLikerView = (FeedFlyoutLikerView)paramView; ; localFeedFlyoutLikerView = new FeedFlyoutLikerView(paramViewGroup.getContext()))
    {
      localFeedFlyoutLikerView.a(paramGraphQLProfile);
      return localFeedFlyoutLikerView;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramView, (GraphQLProfile)getItem(paramInt), paramViewGroup);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.AbstractFeedFlyoutActorAdapter
 * JD-Core Version:    0.6.0
 */