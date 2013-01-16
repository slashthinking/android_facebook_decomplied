package com.facebook.katana.activity.photos;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.katana.activity.media.AlbumsAdapter;
import com.facebook.katana.activity.media.PhotoSetActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.inject.FbInjector;

public class AlbumsFragment extends FbFragment
  implements AdapterView.OnItemClickListener
{
  private AlbumsAdapter a;
  private AppSession b;
  private String c;
  private ListView d;
  private PerformanceLogger e;
  private final String f = AlbumsFragment.class.getSimpleName();
  private View g;
  private final DataSetObserver h = new AlbumsFragment.1(this);
  private final AppSessionListener i = new AlbumsFragment.2(this);

  private void a()
  {
    if (this.a.getCount() > 0)
    {
      this.d.setVisibility(0);
      this.g.findViewById(2131296358).setVisibility(8);
    }
    while (true)
    {
      return;
      if (this.b.a(this.c))
      {
        this.g.findViewById(2131296644).setVisibility(8);
        this.g.findViewById(2131296645).setVisibility(0);
        continue;
      }
      this.g.findViewById(2131296644).setVisibility(0);
      this.g.findViewById(2131296645).setVisibility(8);
    }
  }

  public void B()
  {
    super.B();
    this.a.registerDataSetObserver(this.h);
    this.b.a(this.i);
    a();
  }

  public void C()
  {
    super.C();
    this.a.unregisterDataSetObserver(this.h);
    this.b.b(this.i);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = paramLayoutInflater.inflate(2130903045, paramViewGroup, false);
    this.d = ((ListView)this.g.findViewById(16908298));
    return this.g;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.e = ((PerformanceLogger)R().a(PerformanceLogger.class));
    this.b = AppSession.b(n(), true);
    this.b.a(this.i);
    Bundle localBundle = m();
    long l;
    if (localBundle != null)
      l = localBundle.getLong("extra_profile", -1L);
    while (true)
    {
      if (l == -1L)
        l = this.b.b().userId;
      this.c = this.b.a(n(), l, null);
      this.e.a(this.f);
      this.a = AlbumsAdapter.a(n(), this.b, l);
      this.d.setAdapter(this.a);
      this.d.setOnItemClickListener(this);
      return;
      l = -1L;
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Cursor localCursor = (Cursor)this.a.getItem(paramInt);
    a(PhotoSetActivity.a(n(), this.a.b(localCursor)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.AlbumsFragment
 * JD-Core Version:    0.6.0
 */