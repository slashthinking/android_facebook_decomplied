package com.facebook.orca.common.ui.titlebar;

import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class QuickActionPopMenu
{
  private final View a;
  private final PopupWindow b;
  private final OnQuickActionListener c;
  private ImmutableList<TitleBarQuickActionItem> d;
  private AnalyticsLogger e;
  private View f;
  private ListView g;
  private int h = -2;
  private int i = -2;
  private Point j = new Point(0, 0);

  public QuickActionPopMenu(View paramView, OnQuickActionListener paramOnQuickActionListener)
  {
    this.a = paramView;
    this.b = new PopupWindow(this.a.getContext());
    this.c = paramOnQuickActionListener;
    this.e = ((AnalyticsLogger)FbInjector.a(this.a.getContext()).a(AnalyticsLogger.class));
    this.b.setTouchInterceptor(new QuickActionPopMenu.1(this));
    c();
  }

  private void a(View paramView)
  {
    this.f = paramView;
    this.b.setContentView(paramView);
  }

  private void a(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click").f(paramString).e("quick_action_item");
      this.e.a(localHoneyClientEvent);
    }
  }

  private void c()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a.getContext());
    this.b.setBackgroundDrawable(new BitmapDrawable());
    this.f = localLayoutInflater.inflate(2130903396, null);
    this.g = ((ListView)this.f.findViewById(2131297421));
    this.g.setOnItemClickListener(new QuickActionPopMenu.2(this));
    a(this.f);
  }

  private int d()
  {
    int k;
    if ((this.d == null) || (this.d.size() == 0))
    {
      k = 0;
      return k;
    }
    Object localObject1 = null;
    Iterator localIterator = this.d.iterator();
    label31: Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (TitleBarQuickActionItem)localIterator.next();
      if ((localObject1 != null) && (((TitleBarQuickActionItem)localObject2).a().length() <= localObject1.a().length()))
        break label167;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label31;
      ListAdapter localListAdapter = this.g.getAdapter();
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(localObject1);
      this.g.setAdapter(new QuickActionPopMenu.QuickActionAdapter(this, this.a.getContext(), localBuilder.b()));
      this.g.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(1000, -2147483648));
      k = this.g.getMeasuredWidth();
      this.g.setAdapter(localListAdapter);
      break;
      label167: localObject2 = localObject1;
    }
  }

  private void e()
  {
    if (this.c != null)
      this.c.a(this);
    if ((this.d == null) || (this.d.size() == 0))
      return;
    int k = this.h;
    if (this.h == -2)
    {
      k = d();
      label54: View localView = this.b.getContentView();
      int m = k + (localView.getPaddingLeft() + localView.getPaddingRight());
      this.b.setWidth(m);
      if (this.i != -2)
        break label147;
      this.b.setHeight(-2);
    }
    while (true)
    {
      this.b.setTouchable(true);
      this.b.setFocusable(true);
      this.b.setOutsideTouchable(true);
      break;
      if (this.h != -3)
        break label54;
      k = this.a.getMeasuredWidth();
      break label54;
      label147: if (this.i == -3)
        this.b.setHeight(this.a.getMeasuredHeight());
      else
        this.b.setHeight(this.i);
    }
  }

  public void a()
  {
    e();
    if (this.d == null);
    while (true)
    {
      return;
      this.b.setAnimationStyle(-1);
      this.b.showAsDropDown(this.a, this.j.x - this.b.getContentView().getPaddingLeft(), this.j.y - this.b.getContentView().getPaddingTop());
    }
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  public void b()
  {
    this.b.dismiss();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.QuickActionPopMenu
 * JD-Core Version:    0.6.2
 */