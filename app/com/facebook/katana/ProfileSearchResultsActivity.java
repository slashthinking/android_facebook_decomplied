package com.facebook.katana;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.ui.SectionedListView;

public abstract class ProfileSearchResultsActivity extends BaseFacebookListActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, UsersTabProgressSource
{
  protected AppSession n;
  protected AppSessionListener o;
  protected ProfileSearchResultsAdapter p;
  protected String q;
  protected String r;
  protected ProfileSearchResultsActivity.QueryHandler s;
  protected String t;
  protected int u;
  protected int v;
  private int y;
  private TabProgressListener z;

  protected abstract String a(String paramString, int paramInt1, int paramInt2);

  protected void a(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean)
    {
      this.y = (paramInt | this.y);
      if (this.y == 0)
        break label81;
      bool = true;
      label23: if (!bool)
        break label86;
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      if (this.z != null)
        this.z.a_(bool);
      return;
      this.y &= (paramInt ^ 0xFFFFFFFF);
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
    this.n = AppSession.a(this, true);
    this.p = h_();
    ((SectionedListView)m()).setSectionedListAdapter(this.p);
    k();
    this.s = new ProfileSearchResultsActivity.QueryHandler(this, this);
    this.o = j();
    m().setOnItemClickListener(this);
    m().setOnScrollListener(this);
  }

  public void a(TabProgressListener paramTabProgressListener)
  {
    this.z = paramTabProgressListener;
    TabProgressListener localTabProgressListener;
    if (this.z != null)
    {
      localTabProgressListener = this.z;
      if (this.y == 0)
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
    if (paramString.equals(this.q));
    while (true)
    {
      return;
      this.q = paramString;
      a(2, true);
      this.r = a(this.q, 0, 20);
    }
  }

  protected abstract ProfileSearchResultsAdapter h_();

  protected abstract ProfileSearchResultsActivity.ProfileSearchAppSessionListener j();

  protected abstract void k();

  protected void onPause()
  {
    super.onPause();
    if (this.n != null)
      this.n.b(this.o);
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    this.n.a(this.o);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = m().getLastVisiblePosition();
    if (this.p.e() != null)
    {
      int j = this.p.e().getCount();
      if ((i > 0) && (i == j - 1) && (this.q != null))
      {
        a(2, true);
        this.r = a(this.q, j, 20);
      }
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  public boolean onSearchRequested()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ProfileSearchResultsActivity
 * JD-Core Version:    0.6.0
 */