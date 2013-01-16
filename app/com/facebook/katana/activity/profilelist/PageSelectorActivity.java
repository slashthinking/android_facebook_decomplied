package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.pages.PagesContract;
import com.facebook.katana.PageListAdapter;
import com.facebook.katana.PageListAdapter.UserPagesQuery;
import com.facebook.katana.PageSearchResultsAdapter;
import com.facebook.katana.PageSearchResultsAdapter.SearchResultsQuery;
import com.facebook.katana.ProfileSearchResultsActivity;
import com.facebook.katana.ProfileSearchResultsActivity.ProfileSearchAppSessionListener;
import com.facebook.katana.ProfileSearchResultsActivity.QueryHandler;
import com.facebook.katana.ProfileSearchResultsAdapter;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.PagesSearch;
import com.facebook.katana.ui.SectionedListAdapter;
import com.facebook.katana.ui.SectionedListMultiAdapter;
import com.facebook.katana.ui.SectionedListView;

public class PageSelectorActivity extends ProfileSearchResultsActivity
  implements AdapterView.OnItemClickListener, NotNewNavEnabled
{
  private PageListAdapter A;
  private SectionedListMultiAdapter B;
  private TextView C;
  private boolean D;
  protected ImageView y;
  private PageSelectorActivity.UserPagesQueryHandler z;

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
    setContentView(2130903542);
    k();
    m().setOnItemClickListener(this);
    this.s.startDelete(1, null, PagesContract.c, null, null);
    this.z = new PageSelectorActivity.UserPagesQueryHandler(this, this);
    this.A = new PageListAdapter(this, this.n.j(), null);
    this.B = new SectionedListMultiAdapter();
    this.B.a(this.A);
    this.B.a(this.p);
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    ((SectionedListView)m()).setFastScrollEnabled(false);
    this.C = ((TextView)findViewById(2131297813));
    this.C.addTextChangedListener(new PageSelectorActivity.1(this));
    this.y = ((ImageView)findViewById(2131297814));
    this.y.setOnClickListener(new PageSelectorActivity.2(this));
    this.C.requestFocus();
    View localView = findViewById(2131297812);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new PageSelectorActivity.3(this, localView));
  }

  public void a(String paramString)
  {
    this.A.a().filter(paramString);
    super.a(paramString);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    onItemClick(paramListView, paramView, paramInt, paramLong);
  }

  protected ProfileSearchResultsAdapter h_()
  {
    return new PageSearchResultsAdapter(this, null, this.n.k());
  }

  public String i()
  {
    return getString(2131363027);
  }

  protected ProfileSearchResultsActivity.ProfileSearchAppSessionListener j()
  {
    return new PageSelectorActivity.PagesAppSessionListener(this, null);
  }

  protected void k()
  {
    ((TextView)findViewById(2131296644)).setText(2131363023);
  }

  public void onBackPressed()
  {
    setResult(0);
    finish();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    FacebookProfile localFacebookProfile = (FacebookProfile)((SectionedListView)m()).getSectionedListAdapter().e(paramInt);
    localIntent.putExtra("extra_target_profile", localFacebookProfile.mId);
    localIntent.putExtra("extra_target_name", localFacebookProfile.mDisplayName);
    localIntent.putExtra("extra_keyboard_showing_target", this.D);
    setResult(-1, localIntent);
    finish();
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
 * Qualified Name:     com.facebook.katana.activity.profilelist.PageSelectorActivity
 * JD-Core Version:    0.6.0
 */