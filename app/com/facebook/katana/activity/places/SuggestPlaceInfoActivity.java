package com.facebook.katana.activity.places;

import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.model.FacebookPageFull;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.service.method.FqlGetPages;
import com.facebook.katana.service.method.PageTopicsGet;
import com.facebook.katana.service.method.PlaceSuggestions;
import com.facebook.katana.util.StringUtils;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragmentFactory;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.MapImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SuggestPlaceInfoActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private static final Class<?> n = SuggestPlaceInfoActivity.class;
  private DialogFragment A;
  private String B;
  private String C;
  private AppSessionListener D = new SuggestPlaceInfoActivity.1(this);
  private AppSession o;
  private SuggestPlaceInfoActivity.CategoryListAdapter p;
  private FacebookPlace q;
  private Location r;
  private FacebookPageFull s;
  private MapFragment t;
  private MapImage u;
  private TextView v;
  private TextView x;
  private TextView y;
  private SuggestPlaceInfoActivity.State z;

  private void a(PageTopic paramPageTopic)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramPageTopic);
    a(localArrayList);
  }

  private void a(List<PageTopic> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PageTopic localPageTopic = (PageTopic)localIterator.next();
      if (localPageTopic.id == 0L)
        continue;
      this.p.a(localPageTopic);
    }
    this.p.notifyDataSetChanged();
  }

  private void c(int paramInt)
  {
    this.p.b((PageTopic)this.p.getItem(paramInt));
    this.p.notifyDataSetChanged();
  }

  private void j()
  {
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
    ListView localListView = (ListView)findViewById(2131297689);
    View localView1 = getLayoutInflater().inflate(2130903497, localListView, false);
    View localView2 = getLayoutInflater().inflate(2130903496, localListView, false);
    localListView.addHeaderView(localView1);
    localListView.addFooterView(localView2);
    localView2.setOnClickListener(new SuggestPlaceInfoActivity.2(this));
    this.v = ((TextView)findViewById(2131297116));
    this.x = ((TextView)findViewById(2131297679));
    this.y = ((TextView)findViewById(2131297690));
    this.p = new SuggestPlaceInfoActivity.CategoryListAdapter(this, this, 2130903492);
    localListView.setAdapter(this.p);
    this.u = ((MapImage)findViewById(2131297686));
    MapFragmentFactory localMapFragmentFactory = (MapFragmentFactory)C().a(MapFragmentFactory.class);
    if (localMapFragmentFactory.a())
    {
      FragmentTransaction localFragmentTransaction = g().a();
      this.t = localMapFragmentFactory.a(true);
      localFragmentTransaction.a(2131297687, this.t);
      localFragmentTransaction.a();
      this.r = new Location("");
      this.r.setLatitude(this.q.mLatitude);
      this.r.setLongitude(this.q.mLongitude);
      if (this.t == null)
        break label329;
      this.t.a(this.r);
      this.t.a(17.0D);
      this.t.a(new SuggestPlaceInfoActivity.3(this));
    }
    while (true)
    {
      return;
      findViewById(2131297687).setVisibility(8);
      findViewById(2131297677).setVisibility(8);
      this.u.setVisibility(0);
      break;
      label329: this.u.setCenter(this.r);
    }
  }

  private void k()
  {
    PlaceSuggestions localPlaceSuggestions = PlaceSuggestions.a(this, this.q);
    if (localPlaceSuggestions == null)
      finish();
    while (true)
    {
      return;
      CharSequence localCharSequence1 = this.v.getText();
      if (localCharSequence1 != null)
      {
        if (StringUtils.c(localCharSequence1.toString()))
          continue;
        localPlaceSuggestions.e(localCharSequence1.toString());
      }
      CharSequence localCharSequence2 = this.x.getText();
      if (localCharSequence2 != null)
        localPlaceSuggestions.f(localCharSequence2.toString());
      CharSequence localCharSequence3 = this.y.getText();
      if (localCharSequence3 != null)
        localPlaceSuggestions.g(localCharSequence3.toString());
      HashSet localHashSet = new HashSet(this.p.getCount());
      for (int i = 0; i < this.p.getCount(); i++)
        localHashSet.add(this.p.getItem(i));
      localPlaceSuggestions.a(localHashSet);
      if (this.t != null)
        localPlaceSuggestions.a(this.t.a());
      this.C = localPlaceSuggestions.i();
      if (this.C == null)
      {
        setResult(-1);
        finish();
        continue;
      }
      this.z = SuggestPlaceInfoActivity.State.SAVING;
      this.A = ProgressDialogFragment.a(2131362850, true, false);
      this.A.a(g(), null);
    }
  }

  private void l()
  {
    if (this.s != null)
    {
      a(this.s.mTopicList);
      this.v.setText(this.s.mDisplayName);
      Serializable localSerializable1 = (Serializable)this.s.mLocation.get("located_in");
      if ((localSerializable1 == null) || (localSerializable1.toString().trim().length() == 0))
      {
        Serializable localSerializable2 = (Serializable)this.s.mLocation.get("street");
        if (localSerializable2 != null)
          this.x.setText(localSerializable2.toString());
        this.y.setText(this.s.mPhone);
      }
    }
    while (true)
    {
      return;
      this.x.setVisibility(8);
      break;
      this.v.setText(this.q.mName);
    }
  }

  private void m()
  {
    if (this.p.getCount() >= 3)
      Toaster.a(this, 2131363354);
    while (true)
    {
      return;
      startActivityForResult(new Intent(this, SelectPageTopicActivity.class), 1);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903495);
    getWindow().setSoftInputMode(3);
    this.q = ((FacebookPlace)getIntent().getParcelableExtra("android.intent.extra.SUBJECT"));
    j();
    PageTopicsGet.c(this);
  }

  public String i()
  {
    return getString(2131363345);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        break;
      case 1:
        if ((paramInt2 != -1) || (!paramIntent.hasExtra("object")))
          continue;
        a((PageTopic)paramIntent.getParcelableExtra("object"));
      }
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.u != null)
      this.u.setCenter(this.r);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.o != null)
      this.o.b(this.D);
  }

  public void onResume()
  {
    super.onResume();
    this.o = AppSession.b(this, false);
    if (this.o == null)
    {
      Log.a(n, "Invalid session");
      finish();
    }
    while (true)
    {
      return;
      this.o.a(this.D);
      if (this.s != null)
        continue;
      this.B = FqlGetPages.a(this, "page_id = " + this.q.mPageId, FacebookPageFull.class);
      if (this.B == null)
        continue;
      this.A = ProgressDialogFragment.a(2131362038, true, false);
      this.A.a(g(), null);
      this.z = SuggestPlaceInfoActivity.State.FETCHING;
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SuggestPlaceInfoActivity
 * JD-Core Version:    0.6.0
 */