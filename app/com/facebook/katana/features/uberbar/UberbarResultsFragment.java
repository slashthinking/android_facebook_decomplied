package com.facebook.katana.features.uberbar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.friends.protocol.SendFriendRequestMethod.HowFound;
import com.facebook.friends.protocol.SendFriendRequestMethod.Params;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.activity.FbListFragment;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class UberbarResultsFragment extends FbListFragment
{
  private static final String Y;
  private static final List<UberbarResult> i = Collections.emptyList();
  private final UberbarResultFetcher.UberbarResultFetcherListener Z = new UberbarResultsFragment.1(this);
  private UberSearchResultsAdapter aa;
  private InputMethodManager ab;
  private UberbarResultFetcherFactory ac;
  private OrcaServiceOperationFactory ad;
  private FbErrorReporter ae;
  private UberbarResultsAnalyticHelper af;
  private String ag;
  private UberbarResultFetcher ah;

  static
  {
    Y = UberbarResultsFragment.class.getSimpleName();
  }

  private AbsListView.OnScrollListener K()
  {
    return new UberbarResultsFragment.3(this);
  }

  private UberbarResultView.AddFriendButtonListener L()
  {
    return new UberbarResultsFragment.4(this);
  }

  private UberbarResultView.CommunicationButtonListener M()
  {
    return new UberbarResultsFragment.5(this);
  }

  private ListenableFuture<OperationResult> a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sendFriendRequest", new SendFriendRequestMethod.Params(paramLong, SendFriendRequestMethod.HowFound.SEARCH, null));
    return this.ad.a("send_friend_request", localBundle).d();
  }

  private void a(List<UberbarResult> paramList, UberSearchResultsAdapter.FetchStatus paramFetchStatus)
  {
    this.aa.a(paramList, paramFetchStatus);
  }

  static void b(Context paramContext, String paramString)
  {
    b(paramContext, paramString, null);
  }

  static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (IntentUriHandler.a(paramContext, paramString) != null)
      IntentUriHandler.a(paramContext, paramString, paramBundle);
    while (true)
    {
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      try
      {
        paramContext.startActivity(localIntent);
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        ErrorReporting.a(Y, "Failed to launch activity.", localActivityNotFoundException);
      }
    }
  }

  private AdapterView.OnItemClickListener d()
  {
    return new UberbarResultsFragment.2(this);
  }

  public void D()
  {
    super.D();
    this.aa.a(null);
    this.aa.a(null);
    this.aa = null;
    if (this.ah != null)
    {
      this.ah.b();
      this.ah.a(null);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903611, paramViewGroup, false);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = FbInjector.a(n());
    this.aa = ((UberSearchResultsAdapter)localFbInjector.a(UberSearchResultsAdapter.class));
    this.aa.a(L());
    this.aa.a(M());
    this.ac = ((UberbarResultFetcherFactory)localFbInjector.a(UberbarResultFetcherFactory.class));
    this.ab = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.ad = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.ae = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.ah = null;
  }

  public void a(UberbarResultsAnalyticHelper paramUberbarResultsAnalyticHelper)
  {
    this.af = paramUberbarResultsAnalyticHelper;
  }

  public void a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.ag = paramString;
    if (StringUtil.a(paramString))
      this.aa.a(i, UberSearchResultsAdapter.FetchStatus.NO_QUERY);
    if (this.ah != null)
    {
      this.ah.b();
      this.ah.a(null);
    }
    this.ah = this.ac.a(500, paramString);
    this.ah.a(this.Z);
    this.ah.a();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    ListView localListView = a();
    localListView.setAdapter(this.aa);
    localListView.setOnItemClickListener(d());
    localListView.setOnScrollListener(K());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsFragment
 * JD-Core Version:    0.6.0
 */