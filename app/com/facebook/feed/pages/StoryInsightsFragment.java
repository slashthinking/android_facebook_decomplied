package com.facebook.feed.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.ListenableFuture;

public class StoryInsightsFragment extends FbFragment
{
  private String a;
  private OrcaServiceOperationFactory b;
  private AndroidThreadUtil c;
  private boolean d = false;
  private ListView e;
  private View f;
  private StoryInsightsAdapter g;

  private void a()
  {
    if (this.d);
    while (true)
    {
      return;
      this.d = true;
      this.f.setVisibility(0);
      Bundle localBundle = new Bundle();
      localBundle.putString("fetchStoryInsightsParams", this.a);
      ListenableFuture localListenableFuture = this.b.a("fetch_story_insights", localBundle).d();
      this.c.a(localListenableFuture, new StoryInsightsFragment.1(this));
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903561, paramViewGroup, false);
    this.e = ((ListView)a(localView, 2131297848));
    this.f = a(localView, 16908292);
    this.g = new StoryInsightsAdapter(paramLayoutInflater);
    this.e.setAdapter(this.g);
    return localView;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.a = m().getString("arg_story_id");
    FbInjector localFbInjector = R();
    this.b = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.c = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.pages.StoryInsightsFragment
 * JD-Core Version:    0.6.0
 */