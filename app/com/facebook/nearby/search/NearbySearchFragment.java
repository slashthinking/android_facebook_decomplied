package com.facebook.nearby.search;

import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.data.CategorySearchHistoryManager;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.nearby.protocol.SearchNearbyPlacesParams;
import com.facebook.nearby.protocol.SearchNearbyPlacesResult;
import com.facebook.nearby.ui.TypeaheadStatusView;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.data.PageIdentityDataBuilder;
import com.facebook.uri.FbUriIntentHandler;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class NearbySearchFragment extends OrcaFragment
{
  private static final Class<?> a = NearbySearchFragment.class;
  private TypeaheadStatusView Y;
  private NearbySearchCategoriesView Z;
  private Location aa;
  private String ab = null;
  private SearchArea ac;
  private List<NearbyTopic> ad;
  private OrcaServiceOperationFactory b;
  private FbUriIntentHandler c;
  private NearbyAnalytics d;
  private NearbySearchAdapter e;
  private CategorySearchHistoryManager f;
  private AndroidThreadUtil g;
  private ListView h;
  private EditText i;

  private void L()
  {
    if (this.h.getHeaderViewsCount() == 0)
    {
      this.h.setAdapter(null);
      this.h.addHeaderView(this.Z, null, false);
      this.h.setAdapter(this.e);
    }
    this.e.a(this.ad);
  }

  private void M()
  {
    this.Y = ((TypeaheadStatusView)g(2131297152));
    this.h = ((ListView)g(2131297151));
    this.h.setOnItemClickListener(new NearbySearchFragment.3(this));
    this.Z = N();
    this.h.addHeaderView(this.Z, null, false);
    this.e = new NearbySearchAdapter(p());
    this.e.a(this.ad);
    this.h.setAdapter(this.e);
  }

  private NearbySearchCategoriesView N()
  {
    NearbySearchCategoriesView localNearbySearchCategoriesView = new NearbySearchCategoriesView(p());
    localNearbySearchCategoriesView.setOnCategoryClickedListener(new NearbySearchFragment.4(this));
    return localNearbySearchCategoriesView;
  }

  private List<TypeaheadPlace> a(List<TypeaheadPlace> paramList)
  {
    return Lists.a(Iterables.a(paramList, new NearbySearchFragment.6(this)));
  }

  private void a(NearbyTopic paramNearbyTopic)
  {
    Intent localIntent = this.c.a(p(), "fb://nearby/subcategory");
    if (localIntent == null)
    {
      BLog.e(a, "Failed resolved nearby subcategory uri");
      throw new RuntimeException("Missing binding for nearby subcategory URI");
    }
    localIntent.putExtra("extra_search_topic_name", paramNearbyTopic.a);
    a(localIntent, 2);
  }

  private void a(TypeaheadPlace paramTypeaheadPlace)
  {
    PageIdentityData localPageIdentityData = b(paramTypeaheadPlace);
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramTypeaheadPlace.a;
    String str = StringLocaleUtil.a("fb://localpage/%s", arrayOfObject1);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("current_location", this.aa);
    localBundle.putParcelable("page_data", localPageIdentityData);
    if (!this.c.a(p(), str, localBundle))
    {
      Class localClass = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramTypeaheadPlace.a;
      BLog.e(localClass, "Failed navigating to page id = %s ", arrayOfObject2);
    }
  }

  private void a(SearchNearbyPlacesResult paramSearchNearbyPlacesResult)
  {
    this.ab = paramSearchNearbyPlacesResult.a;
    List localList = a(paramSearchNearbyPlacesResult.d);
    if (!this.i.getText().toString().equals(paramSearchNearbyPlacesResult.b));
    while (true)
    {
      return;
      this.e.a(paramSearchNearbyPlacesResult.c, localList, this.aa);
      if ((paramSearchNearbyPlacesResult.c.isEmpty()) && (localList.isEmpty()))
      {
        this.Y.setVisibility(0);
        this.Y.a(q().getString(2131361898));
        continue;
      }
      this.Y.setVisibility(8);
    }
  }

  private void a(String paramString)
  {
    SearchNearbyPlacesParams localSearchNearbyPlacesParams = new SearchNearbyPlacesParams(this.ac, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("searchNearbyPlacesParams", localSearchNearbyPlacesParams);
    ListenableFuture localListenableFuture = this.b.a("search_nearby_places", localBundle).d();
    this.e.a(Collections.emptyList(), Collections.emptyList(), this.aa);
    this.Y.setVisibility(0);
    this.Y.a();
    this.g.a(localListenableFuture, new NearbySearchFragment.5(this, paramString));
  }

  private PageIdentityData b(TypeaheadPlace paramTypeaheadPlace)
  {
    return new PageIdentityDataBuilder().a(Long.parseLong(paramTypeaheadPlace.a)).a(paramTypeaheadPlace.b).a(paramTypeaheadPlace.e).a(paramTypeaheadPlace.g).a(paramTypeaheadPlace.c).a(paramTypeaheadPlace.f).b(true).z();
  }

  private void b()
  {
    this.i = ((EditText)g(2131297150));
    this.i.addTextChangedListener(new NearbySearchFragment.1(this));
  }

  private void b(NearbyTopic paramNearbyTopic)
  {
    this.f.a(paramNearbyTopic);
    this.ad = this.f.a();
    Intent localIntent = new Intent();
    localIntent.putExtra("place_category_info", paramNearbyTopic);
    n().setResult(-1, localIntent);
    n().finish();
  }

  private void c()
  {
    int j = this.i.getText().length();
    String str = this.i.getText().toString();
    if (j > 0)
      this.g.b(new NearbySearchFragment.2(this, str), 300L);
    if (j > 0)
      d();
    while (true)
    {
      return;
      this.Y.setVisibility(8);
      L();
    }
  }

  private void d()
  {
    if (this.h.getHeaderViewsCount() > 0)
      this.h.removeHeaderView(this.Z);
    this.e.a(Collections.emptyList());
  }

  private void f(int paramInt)
  {
    Object localObject = this.e.getItem(paramInt);
    if ((localObject instanceof NearbyTopic))
    {
      this.d.a(this.i.getText().toString(), "category", ((Long)((NearbyTopic)localObject).b.h().get(0)).longValue(), paramInt, this.ab);
      b((NearbyTopic)localObject);
    }
    while (true)
    {
      return;
      if (!(localObject instanceof TypeaheadPlace))
        break;
      this.d.a(this.i.getText().toString(), "page", Long.parseLong(((TypeaheadPlace)localObject).a), paramInt, this.ab);
      a((TypeaheadPlace)localObject);
    }
    throw new RuntimeException("unexpected object type " + localObject);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903290, paramViewGroup, false);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2))
      b((NearbyTopic)paramIntent.getParcelableExtra("result_topic"));
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    Preconditions.checkArgument(n().getIntent().hasExtra("search_area"), "Missing search area info in intent");
    Preconditions.checkArgument(n().getIntent().hasExtra("user_location"), "Missing user location info in intent");
    this.b = ((OrcaServiceOperationFactory)Q().a(OrcaServiceOperationFactory.class));
    this.c = ((FbUriIntentHandler)Q().a(FbUriIntentHandler.class));
    this.d = ((NearbyAnalytics)Q().a(NearbyAnalytics.class));
    this.g = ((AndroidThreadUtil)Q().a(AndroidThreadUtil.class));
    this.ac = ((SearchArea)n().getIntent().getParcelableExtra("search_area"));
    this.aa = ((Location)n().getIntent().getParcelableExtra("user_location"));
    this.f = ((CategorySearchHistoryManager)Q().a(CategorySearchHistoryManager.class));
    this.ad = this.f.a();
    b();
    M();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchFragment
 * JD-Core Version:    0.6.0
 */