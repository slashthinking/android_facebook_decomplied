package com.facebook.pages.identity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.pages.identity.data.PageRecommendationData;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

public class PageRecommendationListFragment extends OrcaFragment
{
  private AndroidThreadUtil a;
  private PageIdentityDataFetcher b;
  private FbErrorReporter c;
  private OperationResultFutureCallback d;
  private OperationResultFutureCallback e;
  private ListView f;
  private PageRecommendationListAdapter g;

  private OperationResultFutureCallback a(boolean paramBoolean)
  {
    return new PageRecommendationListFragment.1(this, paramBoolean);
  }

  private void a()
  {
    long l = n().getIntent().getLongExtra("com.facebook.katana.profile.id", -1L);
    if (l > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid page id: " + l);
      this.f = ((ListView)g(2131296963));
      this.g = new PageRecommendationListAdapter(p());
      this.f.setAdapter(this.g);
      a(l);
      return;
    }
  }

  private void a(long paramLong)
  {
    ListenableFuture localListenableFuture1 = this.b.a(paramLong, true);
    ListenableFuture localListenableFuture2 = this.b.a(paramLong, false);
    this.a.a(localListenableFuture1, this.d);
    this.a.a(localListenableFuture2, this.e);
  }

  private void a(PageRecommendationData paramPageRecommendationData, boolean paramBoolean)
  {
    this.g.a(paramPageRecommendationData.b, paramBoolean);
    this.g.a(paramPageRecommendationData.c);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903224, paramViewGroup, false);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.a = ((AndroidThreadUtil)Q().a(AndroidThreadUtil.class));
    this.b = ((PageIdentityDataFetcher)Q().a(PageIdentityDataFetcher.class));
    this.c = ((FbErrorReporter)Q().a(FbErrorReporter.class));
    this.d = a(true);
    this.e = a(false);
    a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationListFragment
 * JD-Core Version:    0.6.2
 */