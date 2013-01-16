package com.facebook.katana.features.uberbar;

import android.os.Bundle;
import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.facebook.uberbar.UberbarResults;
import com.facebook.uberbar.api.FetchUberbarResultParams;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collections;
import java.util.List;

class UberbarResultFetcher
{
  private static final String a = UberbarResultFetcher.class.getSimpleName();
  private static final List<UberbarResult> b = Collections.emptyList();
  private static final ImmutableList<UberbarResult.Type> c = ImmutableList.a(UberbarResult.Type.APP, UberbarResult.Type.USER, UberbarResult.Type.PAGE, UberbarResult.Type.GROUP);
  private final LocalUberbarResultResolver d;
  private final LocalUberbarResultResolver e;
  private final AndroidThreadUtil f;
  private final OrcaServiceOperationFactory g;
  private final String h;
  private final long i;
  private boolean j = false;
  private UberbarResultFetcher.UberbarResultFetcherListener k;
  private List<UberbarResult> l;
  private List<UberbarResult> m;
  private List<UberbarResult> n;

  UberbarResultFetcher(LocalUberbarResultResolver paramLocalUberbarResultResolver1, LocalUberbarResultResolver paramLocalUberbarResultResolver2, AndroidThreadUtil paramAndroidThreadUtil, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, int paramInt, String paramString)
  {
    this.d = ((LocalUberbarResultResolver)Preconditions.checkNotNull(paramLocalUberbarResultResolver1));
    this.e = ((LocalUberbarResultResolver)Preconditions.checkNotNull(paramLocalUberbarResultResolver2));
    this.f = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
    this.g = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "mRemoteFetchDelayIntervalMillis must be >= 0");
      this.i = paramInt;
      this.h = ((String)Preconditions.checkNotNull(paramString));
      return;
    }
  }

  private FutureCallback<List<UberbarResult>> a(UberbarResult.Type paramType)
  {
    return new UberbarResultFetcher.4(this, paramType);
  }

  private void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchQueryResultParams", new FetchUberbarResultParams(this.h, 100, c));
    Futures.a(this.g.a("fetch_uberbar_result", localBundle).d(), h());
  }

  private boolean f()
  {
    if ((this.n != null) && (this.l != null) && (this.m != null));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void g()
  {
    List localList1;
    List localList2;
    if (this.k != null)
    {
      if (this.n != null)
        break label64;
      localList1 = b;
      if (this.l != null)
        break label72;
      localList2 = b;
      label29: if (this.m != null)
        break label80;
    }
    label64: label72: label80: for (List localList3 = b; ; localList3 = this.m)
    {
      List localList4 = UberbarResults.a(localList1, localList2, localList3);
      this.k.a(localList4, f());
      return;
      localList1 = this.n;
      break;
      localList2 = this.l;
      break label29;
    }
  }

  private FutureCallback<OperationResult> h()
  {
    return new UberbarResultFetcher.3(this);
  }

  public void a()
  {
    if (this.j)
      ErrorReporting.a(a, "Fetch called when in aborted state");
    while (true)
    {
      return;
      if (StringUtil.a(this.h))
      {
        this.f.e(new UberbarResultFetcher.1(this));
        continue;
      }
      Futures.a(this.d.a(this.h), a(UberbarResult.Type.USER));
      Futures.a(this.e.a(this.h), a(UberbarResult.Type.PAGE));
      this.f.b(new UberbarResultFetcher.2(this), this.i);
    }
  }

  public void a(UberbarResultFetcher.UberbarResultFetcherListener paramUberbarResultFetcherListener)
  {
    this.k = paramUberbarResultFetcherListener;
  }

  public void b()
  {
    this.j = true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultFetcher
 * JD-Core Version:    0.6.0
 */