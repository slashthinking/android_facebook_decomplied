package com.facebook.feed.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class ProfileListFragment extends FbFragment
{
  private GraphQLPageInfo Y;
  private AndroidThreadUtil a;
  private OrcaServiceOperationFactory b;
  private FeedLinkifyUtil c;
  private IFeedIntentBuilder d;
  private ListView e;
  private ProfileListAdapter f;
  private AppendOnlyGraphQLObjectCollection<GraphQLProfile> g;
  private boolean h;
  private String i;

  public static ProfileListFragment a(String paramString)
  {
    ProfileListFragment localProfileListFragment = new ProfileListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("feedback_id", paramString);
    localBundle.putBoolean("is_feedback", true);
    localProfileListFragment.f(localBundle);
    return localProfileListFragment;
  }

  public static ProfileListFragment a(List<GraphQLProfile> paramList)
  {
    ProfileListFragment localProfileListFragment = new ProfileListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("profile_list", Lists.a(paramList));
    localBundle.putBoolean("is_feedback", false);
    localProfileListFragment.f(localBundle);
    return localProfileListFragment;
  }

  private void a()
  {
    if ((this.h) || (this.i == null));
    while (true)
    {
      return;
      this.h = true;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchLikersFeedParams", new FetchNodeListParams(this.i, 25, null, this.g.a(), DataFreshnessParam.STALE_DATA_OKAY));
      ListenableFuture localListenableFuture = this.b.a("fetch_likers", localBundle).d();
      this.a.a(localListenableFuture, new ProfileListFragment.3(this));
    }
  }

  private void a(Feedback paramFeedback)
  {
    if ((paramFeedback == null) || (paramFeedback.likers == null) || (paramFeedback.likers.likers.isEmpty()))
      return;
    FeedStoryLikers localFeedStoryLikers = paramFeedback.likers;
    int j = this.e.getFirstVisiblePosition();
    View localView = this.e.getChildAt(0);
    int k = 0;
    if (localView == null);
    while (true)
    {
      this.g.a(localFeedStoryLikers.likers, localFeedStoryLikers.pageInfo);
      this.f.notifyDataSetChanged();
      this.e.setSelectionFromTop(j, k);
      break;
      k = localView.getTop();
    }
  }

  private void b(List<GraphQLProfile> paramList)
  {
    this.g.a(paramList, this.Y);
    this.f.notifyDataSetChanged();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903226, paramViewGroup, false);
    this.e = ((ListView)localView.findViewById(2131296965));
    return localView;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.g = new AppendOnlyGraphQLObjectCollection();
    FbInjector localFbInjector = R();
    FeedAdapterFactory localFeedAdapterFactory = (FeedAdapterFactory)localFbInjector.a(FeedAdapterFactory.class);
    this.a = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.b = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.c = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.d = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.f = localFeedAdapterFactory.b(this.g);
    this.e.setAdapter(this.f);
    this.Y = new GraphQLPageInfo(null, null, false, false);
    Bundle localBundle = m();
    if (!localBundle.getBoolean("is_feedback"))
      b(localBundle.getParcelableArrayList("profile_list"));
    while (true)
    {
      this.e.setOnScrollListener(new ProfileListFragment.1(this));
      this.e.setOnItemClickListener(new ProfileListFragment.2(this));
      return;
      this.i = localBundle.getString("feedback_id");
      a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ProfileListFragment
 * JD-Core Version:    0.6.0
 */