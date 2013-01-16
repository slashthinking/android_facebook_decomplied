package com.facebook.katana.friendrequests;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestResponseRef;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.protocol.SendFriendRequestMethod.HowFound;
import com.facebook.friends.protocol.SendFriendRequestMethod.PeopleYouMayKnowLocation;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.orca.activity.FbListFragment;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.ErrorCode;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class FriendRequestsFragment extends FbListFragment
{
  private static final Class<?> i = FriendRequestsFragment.class;
  private RefreshableListViewContainer Y;
  private View Z;
  private FriendRequestsAdapter aa;
  private InteractionLogger ab;
  private final FriendRequestView.OnResponseListener ac = new FriendRequestsFragment.1(this);
  private final FriendRequestView.OnRequestListener ad = new FriendRequestsFragment.2(this);
  private final FriendRequestView.OnIgnoreListener ae = new FriendRequestsFragment.3(this);
  private final PersonYouMayKnowView.OnResponseListener af = new FriendRequestsFragment.4(this);
  private IFeedIntentBuilder ag;
  private FbErrorReporter ah;
  private FriendingClient ai;
  private AndroidThreadUtil aj;
  private boolean ak = false;
  private ListenableFuture<?> al;
  private FutureCallback<? super List<?>> am = new FriendRequestsFragment.5(this);

  private AbsListView.OnScrollListener K()
  {
    FrameLayout localFrameLayout = (FrameLayout)A();
    View localView = this.aa.a(localFrameLayout, true);
    localView.setVisibility(8);
    localFrameLayout.addView(localView, 0);
    return new FriendRequestsFragment.8(this, localView);
  }

  private void L()
  {
    if ((!this.ak) || (this.al != null));
    while (true)
    {
      return;
      if (this.ai.a())
      {
        a(false, false);
        continue;
      }
      if (!this.ai.b())
        continue;
      M();
    }
  }

  private void M()
  {
    if (this.al != null);
    while (true)
    {
      return;
      ListenableFuture localListenableFuture = this.ai.b(10);
      this.al = localListenableFuture;
      this.aj.a(localListenableFuture, this.am);
      this.aj.a(localListenableFuture, new FriendRequestsFragment.10(this));
      this.aj.a(localListenableFuture, new FriendRequestsFragment.11(this));
    }
  }

  private void a(long paramLong)
  {
    ListenableFuture localListenableFuture = this.ai.a(paramLong, SendFriendRequestMethod.HowFound.PYMK, SendFriendRequestMethod.PeopleYouMayKnowLocation.PYMK_MOBILE_JEWEL);
    this.aj.a(localListenableFuture, new FriendRequestsFragment.15(this, paramLong));
  }

  private void a(FriendRequest paramFriendRequest)
  {
    ListenableFuture localListenableFuture = this.ai.a(Long.valueOf(paramFriendRequest.profile.id).longValue(), SendFriendRequestMethod.HowFound.SUGGESTION, null);
    this.aj.a(localListenableFuture, new FriendRequestsFragment.13(this, paramFriendRequest));
  }

  private void a(FriendRequest paramFriendRequest, FriendRequestResponse paramFriendRequestResponse)
  {
    ListenableFuture localListenableFuture = this.ai.a(Long.valueOf(paramFriendRequest.profile.id).longValue(), paramFriendRequestResponse, FriendRequestResponseRef.MOBILE_JEWEL);
    switch (FriendRequestsFragment.17.a[paramFriendRequestResponse.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.aj.a(localListenableFuture, new FriendRequestsFragment.12(this, paramFriendRequestResponse, paramFriendRequest));
      return;
      this.ab.a(FB4A_AnalyticEntities.UIElements.u, null);
      continue;
      this.ab.a(FB4A_AnalyticEntities.UIElements.v, null);
      continue;
      this.ab.a(FB4A_AnalyticEntities.UIElements.w, null);
    }
  }

  private void a(String paramString, Throwable paramThrowable)
  {
    Log.a(i, paramString, paramThrowable);
    if (((paramThrowable instanceof ServiceException)) && (((ServiceException)paramThrowable).a() == ErrorCode.API_ERROR))
      a(false);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.al != null);
    while (true)
    {
      return;
      ListenableFuture localListenableFuture = this.ai.a(10);
      this.al = localListenableFuture;
      if (paramBoolean1)
        this.Y.b();
      b(this.aa.isEmpty(), true);
      this.aj.a(localListenableFuture, this.am);
      this.aj.a(localListenableFuture, new FriendRequestsFragment.9(this, paramBoolean2));
    }
  }

  private void b(long paramLong)
  {
    ListenableFuture localListenableFuture = this.ai.a(paramLong);
    this.aj.a(localListenableFuture, new FriendRequestsFragment.16(this, paramLong));
  }

  private void b(FriendRequest paramFriendRequest)
  {
    ListenableFuture localListenableFuture = this.ai.b(Long.valueOf(paramFriendRequest.profile.id).longValue());
    this.aj.a(localListenableFuture, new FriendRequestsFragment.14(this, paramFriendRequest));
  }

  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView1 = (View)Preconditions.checkNotNull(A());
    View localView2 = this.Z;
    int j;
    int k;
    label48: View localView4;
    int m;
    if (paramBoolean1)
    {
      j = 0;
      localView2.setVisibility(j);
      View localView3 = localView1.findViewById(2131296644);
      if (!paramBoolean2)
        break label86;
      k = 8;
      localView3.setVisibility(k);
      localView4 = localView1.findViewById(2131296645);
      m = 0;
      if (!paramBoolean2)
        break label92;
    }
    while (true)
    {
      localView4.setVisibility(m);
      return;
      j = 8;
      break;
      label86: k = 0;
      break label48;
      label92: m = 8;
    }
  }

  private void c(long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    String str = StringLocaleUtil.a("fb://profile/%s", arrayOfObject);
    Intent localIntent = this.ag.b(n(), str);
    if (localIntent == null)
      this.ah.a(i.toString(), "Unexpected null intent returned from getIntentForUri", true);
    while (true)
    {
      return;
      a(localIntent);
    }
  }

  private AdapterView.OnItemClickListener d()
  {
    return new FriendRequestsFragment.7(this);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903233, paramViewGroup, false);
    this.Y = ((RefreshableListViewContainer)localView.findViewById(2131296990));
    this.Z = localView.findViewById(16908292);
    this.Y.setOnRefreshListener(new FriendRequestsFragment.6(this));
    ((TextView)localView.findViewById(2131296644)).setText(2131363022);
    return localView;
  }

  public void a(boolean paramBoolean)
  {
    if (this.al != null);
    while (true)
    {
      return;
      this.ai.c();
      a(paramBoolean, true);
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = c();
    this.ab = new InteractionLogger((Context)localFbInjector.a(Context.class));
    this.ag = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.ah = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.aj = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.ai = ((FriendingClient)localFbInjector.a(FriendingClient.class));
    boolean bool = ((Boolean)localFbInjector.a(Boolean.class, IsFullscreenJewelsEnabled.class)).booleanValue();
    this.aa = new FriendRequestsAdapter(localFbInjector.b(FriendRequestView.class), localFbInjector.b(PersonYouMayKnowView.class), bool, this.ac, this.ad, this.ae, this.af);
    ListView localListView = a();
    localListView.setAdapter(this.aa);
    localListView.setOnItemClickListener(d());
    localListView.setOnScrollListener(K());
    if (bool)
    {
      localListView.setDivider(null);
      localListView.setDividerHeight(0);
    }
    a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment
 * JD-Core Version:    0.6.0
 */