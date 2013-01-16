package com.facebook.feed.flyout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.flyout.FlyoutFragment;
import java.util.List;

public class FeedAggregatedEntitiesFlyoutFragment extends FlyoutFragment
{
  private FeedAggregatedEntitiesAdapter b;
  private ListView c;
  private List<GraphQLProfile> d;

  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    View localView = paramLayoutInflater.inflate(2130903214, paramViewGroup, true);
    localView.setOnClickListener(new FeedAggregatedEntitiesFlyoutFragment.1(this));
    this.c = ((ListView)localView.findViewById(2131296925));
    this.c.setEmptyView(localView.findViewById(16908292));
    this.b = ((FeedAdapterFactory)R().a(FeedAdapterFactory.class)).a(this.d);
    this.c.setAdapter(this.b);
  }

  public void a(FlyoutAggrEntParams paramFlyoutAggrEntParams)
  {
    if (paramFlyoutAggrEntParams == null);
    while (true)
    {
      return;
      this.d = paramFlyoutAggrEntParams.a;
    }
  }

  public void h()
  {
    super.h();
    this.c = null;
    this.b = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedAggregatedEntitiesFlyoutFragment
 * JD-Core Version:    0.6.0
 */