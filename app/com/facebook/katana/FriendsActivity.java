package com.facebook.katana;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.Log;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.FriendsQuery;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;

public class FriendsActivity extends BaseFacebookListActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AnalyticsActivity, UsersTabProgressSource
{
  private static final Class<?> o = FriendsActivity.class;
  private static final String p = o.getSimpleName();
  private int A;
  private int B;
  protected String n;
  private AppSession q;
  private AppSessionListener r;
  private FriendsActivity.FriendsAndUserSearchAdapter s;
  private FriendsActivity.FriendsQueryHandler t;
  private String u;
  private int v;
  private TabProgressListener y;
  private FriendsActivity.UserSearchQueryHandler z;

  public String a()
  {
    return FB4A_AnalyticEntities.l;
  }

  protected String a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString.equals(this.u)) && (this.A >= paramInt1) && (this.B == paramInt2));
    for (String str = this.n; ; str = this.q.a(this, paramString, paramInt1, paramInt2))
    {
      return str;
      this.u = paramString;
      this.A = paramInt1;
      this.B = paramInt2;
    }
  }

  protected void a(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean)
    {
      this.v = (paramInt | this.v);
      if (this.v == 0)
        break label81;
      bool = true;
      label23: if (!bool)
        break label86;
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      if (this.y != null)
        this.y.a_(bool);
      return;
      this.v &= (paramInt ^ 0xFFFFFFFF);
      break;
      label81: bool = false;
      break label23;
      label86: findViewById(2131296644).setVisibility(0);
      findViewById(2131296645).setVisibility(8);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903235);
    this.q = AppSession.a(this, true);
    if (paramBundle != null);
    for (this.u = paramBundle.getString("query"); ; this.u = "")
    {
      this.s = new FriendsActivity.FriendsAndUserSearchAdapter(this, this, this.q.j(), null);
      ((SectionedListView)m()).setSectionedListAdapter(this.s);
      i();
      this.t = new FriendsActivity.FriendsQueryHandler(this, this);
      this.z = new FriendsActivity.UserSearchQueryHandler(this, this);
      this.r = new FriendsActivity.FriendsAppSessionListener(this, null);
      m().setOnItemClickListener(this);
      m().setOnScrollListener(this);
      this.z.startDelete(1, null, ConnectionsContract.l, null, null);
      return;
    }
  }

  public void a(TabProgressListener paramTabProgressListener)
  {
    this.y = paramTabProgressListener;
    TabProgressListener localTabProgressListener;
    if (this.y != null)
    {
      localTabProgressListener = this.y;
      if (this.v == 0)
        break label34;
    }
    label34: for (boolean bool = true; ; bool = false)
    {
      localTabProgressListener.a_(bool);
      return;
    }
  }

  public void a(String paramString)
  {
    if (paramString.equals(this.u));
    while (true)
    {
      return;
      this.s.k.filter(paramString);
      this.s.a(false);
      if (paramString.length() == 0)
      {
        this.u = "";
        this.n = null;
        continue;
      }
      ((SectionedListView)m()).setFastScrollEnabled(false);
      a(8, true);
      this.n = a(paramString, 0, 20);
    }
  }

  protected void i()
  {
    ((TextView)findViewById(2131296644)).setText(2131362941);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)this.s.e(paramInt);
    ApplicationUtils.a(this, localFacebookProfile.mId, localFacebookProfile);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.q != null)
      this.q.b(this.r);
  }

  public void onResume()
  {
    super.onResume();
    this.q = AppSession.b(this, true);
    if (this.q == null)
    {
      Log.a(p, "Invalid session");
      finish();
    }
    label132: 
    while (true)
    {
      return;
      this.q.a(this.r);
      if (this.s.a == null)
      {
        a(1, true);
        this.t.startQuery(1, null, ConnectionsContract.d, ProfileListNaiveCursorAdapter.FriendsQuery.a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
      }
      while (true)
      {
        if (this.s.b != null)
          break label132;
        a(4, true);
        this.z.startQuery(1, null, ConnectionsContract.l, UserSearchResultsAdapter.SearchResultsQuery.a, null, null, null);
        break;
        this.s.b(this.s.a);
      }
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = m().getLastVisiblePosition();
    if (this.s.b != null)
    {
      int j = this.s.e().getCount();
      if ((i > 0) && (i == j - 1) && (this.u != null) && (this.u.length() > 0))
      {
        a(8, true);
        if (this.s.b == null)
          break label112;
      }
    }
    label112: for (int k = this.s.b.getCount(); ; k = 0)
    {
      this.n = a(this.u, k, 20);
      return;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsActivity
 * JD-Core Version:    0.6.0
 */