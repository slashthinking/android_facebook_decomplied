package com.facebook.orca.threadview;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannableStringBuilder;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.maps.FixedMyLocationOverlay;
import com.facebook.orca.activity.FbMapActivity;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserKey;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadViewMapActivityTabImpl extends FbMapActivity
  implements AnalyticsActivity, ThreadViewMapActivityTab
{
  private DataCache a;
  private OrcaAppType b;
  private ThreadDateUtil c;
  private OrcaSharedPreferences d;
  private ThreadSnippetUtil e;
  private EmojiUtil f;
  private AnalyticsLogger g;
  private FrameLayout h;
  private RelativeLayout i;
  private UserTileView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private MapView n;
  private ThreadViewFragment o;
  private ThreadViewMapActivityTabImpl.MemberItemizedOverlay p;
  private ThreadViewMapActivityTabImpl.MemberOverlayForRadius q;
  private MyLocationOverlay r;

  private ThreadViewMapActivityTabImpl.MapCenter a(List<GeoPoint> paramList)
  {
    int i1 = 2147483647;
    int i2 = -2147483648;
    Iterator localIterator = paramList.iterator();
    int i3 = i1;
    int i4 = i2;
    while (localIterator.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)localIterator.next();
      if (localGeoPoint.getLatitudeE6() < i3)
        i3 = localGeoPoint.getLatitudeE6();
      if (localGeoPoint.getLatitudeE6() > i4)
        i4 = localGeoPoint.getLatitudeE6();
      if (localGeoPoint.getLongitudeE6() < i1)
        i1 = localGeoPoint.getLongitudeE6();
      if (localGeoPoint.getLongitudeE6() <= i2)
        continue;
      i2 = localGeoPoint.getLongitudeE6();
    }
    return new ThreadViewMapActivityTabImpl.MapCenter(new GeoPoint((i3 + i4) / 2, (i1 + i2) / 2), i4, i3, i2, i1);
  }

  private void a(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null)
      this.i.setVisibility(8);
    while (true)
    {
      return;
      ThreadViewMapActivityTabImpl.MemberOverlayItem localMemberOverlayItem = (ThreadViewMapActivityTabImpl.MemberOverlayItem)paramOverlayItem;
      UserKey localUserKey = localMemberOverlayItem.a();
      this.i.setVisibility(0);
      this.j.setParams(UserTileViewParams.a(localUserKey));
      this.k.setText(paramOverlayItem.getTitle());
      Message localMessage = localMemberOverlayItem.b();
      if (localMessage != null)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.e.a(localMessage));
        this.f.a(localSpannableStringBuilder, (int)this.l.getTextSize());
        this.l.setText(localSpannableStringBuilder);
        this.l.setVisibility(0);
        this.m.setText(this.c.a(localMessage.c()));
        this.m.setVisibility(0);
        this.g.a(new HoneyClientEvent("click").e("map_marker").d(a()).b("thread_id", localMessage.b()).f(localMemberOverlayItem.a().b()));
        continue;
      }
      this.l.setVisibility(8);
      this.m.setVisibility(8);
    }
  }

  public String a()
  {
    return "thread_view_map";
  }

  public void a(ThreadSummary paramThreadSummary, ImmutableList<Message> paramImmutableList)
  {
    if ((this.i != null) && (this.i.getVisibility() == 0))
      this.i.setVisibility(8);
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramImmutableList.iterator();
    while (localIterator1.hasNext())
    {
      Message localMessage2 = (Message)localIterator1.next();
      UserKey localUserKey2 = localMessage2.f().e();
      if ((localHashMap.containsKey(localUserKey2)) || (localMessage2.k() == null))
        continue;
      localHashMap.put(localUserKey2, localMessage2);
    }
    ArrayList localArrayList1 = Lists.c(paramThreadSummary.i().size());
    ArrayList localArrayList2 = Lists.a();
    Iterator localIterator2 = localHashMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      UserKey localUserKey1 = (UserKey)localEntry.getKey();
      Message localMessage1 = (Message)localEntry.getValue();
      Coordinates localCoordinates = localMessage1.k();
      GeoPoint localGeoPoint = new GeoPoint((int)(1000000.0D * localCoordinates.b()), (int)(1000000.0D * localCoordinates.c()));
      float f1 = localCoordinates.f().floatValue();
      localArrayList1.add(localGeoPoint);
      localArrayList2.add(new ThreadViewMapActivityTabImpl.MemberOverlayItem(this, localGeoPoint, f1, StringUtil.b(this.a.b(localMessage1.f())), this.e.a(localMessage1), localUserKey1, localMessage1));
    }
    this.p.a();
    this.p.a(localArrayList2);
    this.q.a();
    this.q.a(localArrayList2);
    if (localArrayList1.size() > 0)
    {
      ThreadViewMapActivityTabImpl.MapCenter localMapCenter = a(localArrayList1);
      MapController localMapController = this.n.getController();
      localMapController.animateTo(localMapCenter.a);
      localMapController.zoomToSpan(Math.max(Math.abs(localMapCenter.b - localMapCenter.c), 10000), Math.abs(localMapCenter.d - localMapCenter.e));
    }
    List localList = this.n.getOverlays();
    localList.clear();
    localList.add(this.r);
    localList.add(this.q);
    localList.add(this.p);
    localList.add(new ZoomOverlay(this, this.n));
    this.n.invalidate();
    this.n.setBuiltInZoomControls(true);
  }

  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    setContentView(2130903419);
    this.o = ((ThreadViewFragment)((FragmentActivity)getParent()).g().a("threadViewFragment"));
    FbInjector localFbInjector = b();
    this.a = ((DataCache)localFbInjector.a(DataCache.class));
    this.b = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.c = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.d = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.e = ((ThreadSnippetUtil)localFbInjector.a(ThreadSnippetUtil.class));
    this.f = ((EmojiUtil)localFbInjector.a(EmojiUtil.class));
    this.g = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.h = ((FrameLayout)a(2131297495));
    this.i = ((RelativeLayout)a(2131297496));
    this.j = ((UserTileView)a(2131297497));
    this.k = ((TextView)a(2131297498));
    this.l = ((TextView)a(2131297499));
    this.m = ((TextView)a(2131297500));
    this.p = new ThreadViewMapActivityTabImpl.MemberItemizedOverlay(this, getResources().getDrawable(2130838658));
    this.p.setOnFocusChangeListener(new ThreadViewMapActivityTabImpl.1(this));
    this.q = new ThreadViewMapActivityTabImpl.MemberOverlayForRadius(this);
    this.n = new MapView(this, this.b.e());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.n.setClickable(true);
    this.n.setLayoutParams(localLayoutParams);
    this.r = new FixedMyLocationOverlay(this, this.n);
    this.h.addView(this.n, 0);
    ((FrameLayout)findViewById(16908290)).setForeground(null);
  }

  protected boolean isRouteDisplayed()
  {
    return false;
  }

  public void onBackPressed()
  {
    this.o.N();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.o = null;
  }

  protected void onPause()
  {
    super.onPause();
    this.r.disableMyLocation();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.d.a(MessagesPrefKeys.r, true))
      this.r.enableMyLocation();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapActivityTabImpl
 * JD-Core Version:    0.6.0
 */