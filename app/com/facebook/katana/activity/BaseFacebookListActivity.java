package com.facebook.katana.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseFacebookListActivity extends BaseFacebookActivity
{
  private AdapterView.OnItemLongClickListener n = new BaseFacebookListActivity.1(this);
  private ListAdapter o;
  private ListView p;
  private Handler q = new Handler();
  private boolean r = false;
  private Runnable s = new BaseFacebookListActivity.2(this);
  private AdapterView.OnItemClickListener t = new BaseFacebookListActivity.3(this);
  protected List<Integer> x = new ArrayList();

  private void i()
  {
    if (this.p != null);
    while (true)
    {
      return;
      setContentView(2130903268);
    }
  }

  public void a(ListAdapter paramListAdapter)
  {
    monitorenter;
    try
    {
      i();
      this.o = paramListAdapter;
      this.p.setAdapter(paramListAdapter);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  protected boolean a(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }

  protected void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
  }

  public void c(int paramInt)
  {
    ((TextView)findViewById(2131296644)).setText(paramInt);
  }

  protected void c(boolean paramBoolean)
  {
    int i = 8;
    int j;
    if (paramBoolean)
    {
      j = 0;
      if (!paramBoolean)
        break label39;
    }
    while (true)
    {
      findViewById(2131296645).setVisibility(j);
      findViewById(2131296644).setVisibility(i);
      return;
      j = i;
      break;
      label39: i = 0;
    }
  }

  protected int e(int paramInt)
  {
    return paramInt - m().getHeaderViewsCount();
  }

  protected void l()
  {
    if (!this.x.isEmpty())
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        m().addHeaderView(localLayoutInflater.inflate(localInteger.intValue(), null), null, false);
      }
    }
  }

  public ListView m()
  {
    i();
    return this.p;
  }

  public ListAdapter n()
  {
    return this.o;
  }

  public void onContentChanged()
  {
    super.onContentChanged();
    View localView = findViewById(16908292);
    this.p = ((ListView)findViewById(16908298));
    if (this.p == null)
      throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    if (localView != null)
      this.p.setEmptyView(localView);
    this.p.setOnItemClickListener(this.t);
    this.p.setOnItemLongClickListener(this.n);
    if (this.r)
      a(this.o);
    this.q.post(this.s);
    this.r = true;
  }

  protected void onDestroy()
  {
    this.q.removeCallbacks(this.s);
    super.onDestroy();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    i();
    super.onRestoreInstanceState(paramBundle);
  }

  protected void w()
  {
    super.w();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.BaseFacebookListActivity
 * JD-Core Version:    0.6.0
 */