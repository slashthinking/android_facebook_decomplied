package com.facebook.katana;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.pages.PagesContract;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.PagesSearch;
import com.facebook.katana.ui.SectionedListAdapter;
import com.facebook.katana.ui.SectionedListMultiAdapter;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;

public class PageSearchResultsActivity extends ProfileSearchResultsActivity
  implements AnalyticsActivity
{
  private static final String y = PageSearchResultsActivity.class.getSimpleName();
  private PageListAdapter A;
  private SectionedListMultiAdapter B;
  private PageSearchResultsActivity.UserPagesQueryHandler z;

  public String a()
  {
    return FB4A_AnalyticEntities.m;
  }

  protected String a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString.equals(this.t)) && (this.u == paramInt1) && (this.v == paramInt2));
    for (String str = this.r; ; str = PagesSearch.a(this, paramString, paramInt1, paramInt2))
    {
      return str;
      this.t = paramString;
      this.u = paramInt1;
      this.v = paramInt2;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.s.startDelete(1, null, PagesContract.c, null, null);
    this.z = new PageSearchResultsActivity.UserPagesQueryHandler(this, this);
    this.A = new PageListAdapter(this, this.n.j(), null);
    this.B = new SectionedListMultiAdapter();
    this.B.a(this.A);
    this.B.a(this.p);
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    ((SectionedListView)m()).setFastScrollEnabled(false);
  }

  public void a(String paramString)
  {
    this.A.a.filter(paramString);
    super.a(paramString);
  }

  protected ProfileSearchResultsAdapter h_()
  {
    return new PageSearchResultsAdapter(this, null, this.n.k());
  }

  protected ProfileSearchResultsActivity.ProfileSearchAppSessionListener j()
  {
    return new PageSearchResultsActivity.PagesAppSessionListener(this, null);
  }

  protected void k()
  {
    ((TextView)findViewById(2131296644)).setText(2131363023);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)((SectionedListView)m()).getSectionedListAdapter().e(paramInt);
    ApplicationUtils.b(this, localFacebookProfile.mId, localFacebookProfile);
  }

  public void onResume()
  {
    super.onResume();
    if (this.p.e() == null)
    {
      a(1, true);
      this.z.startQuery(1, null, ConnectionsContract.i, PageListAdapter.UserPagesQuery.a, null, null, "connection_type, display_name");
      this.s.startQuery(1, null, PagesContract.c, PageSearchResultsAdapter.SearchResultsQuery.a, null, null, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.PageSearchResultsActivity
 * JD-Core Version:    0.6.0
 */