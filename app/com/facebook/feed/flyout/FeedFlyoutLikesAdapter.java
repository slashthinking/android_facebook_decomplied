package com.facebook.feed.flyout;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.graphql.model.GraphQLProfile;

public class FeedFlyoutLikesAdapter extends AbstractFeedFlyoutActorAdapter
{
  private final AppendOnlyGraphQLObjectCollection<GraphQLProfile> a;

  public FeedFlyoutLikesAdapter(AppendOnlyGraphQLObjectCollection<GraphQLProfile> paramAppendOnlyGraphQLObjectCollection)
  {
    this.a = paramAppendOnlyGraphQLObjectCollection;
  }

  public int getCount()
  {
    return this.a.c();
  }

  public Object getItem(int paramInt)
  {
    return this.a.a(paramInt);
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
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutLikesAdapter
 * JD-Core Version:    0.6.0
 */