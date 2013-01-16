package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomMenu
{
  private ArrayList<CustomMenuItem> a;
  private List<CustomMenuActivity> b = new ArrayList();
  private List<ExportMenuToFbHostActivity> c = new ArrayList();
  private Context d = null;
  private LayoutInflater e = null;
  private PopupWindow f = null;
  private boolean g = false;
  private boolean h = false;
  private int i = 0;
  private View j;
  private View k;
  private final InteractionLogger l;

  public CustomMenu(Context paramContext, CustomMenuActivity paramCustomMenuActivity, LayoutInflater paramLayoutInflater)
  {
    a(paramCustomMenuActivity);
    this.a = new ArrayList();
    this.d = paramContext;
    this.e = paramLayoutInflater;
    this.l = new InteractionLogger(paramContext);
  }

  private void a(CustomMenuItem paramCustomMenuItem)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(FB4A_AnalyticEntities.Actions.a).d(FB4A_AnalyticEntities.Modules.i).f(paramCustomMenuItem.a()).e(FB4A_AnalyticEntities.UIElementsTypes.b);
    this.l.b(localHoneyClientEvent);
  }

  private void d()
  {
    Iterator localIterator = this.b.iterator();
    FacebookActivityDelegate localFacebookActivityDelegate = null;
    while (localIterator.hasNext())
    {
      CustomMenuActivity localCustomMenuActivity = (CustomMenuActivity)localIterator.next();
      if ((localCustomMenuActivity instanceof FacebookActivityDelegate))
      {
        localFacebookActivityDelegate = (FacebookActivityDelegate)localCustomMenuActivity;
        continue;
      }
      localCustomMenuActivity.K();
    }
    if (localFacebookActivityDelegate != null)
      localFacebookActivityDelegate.K();
  }

  public void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    monitorenter;
    while (true)
    {
      int m;
      int n;
      int i1;
      label245: int i6;
      int i7;
      try
      {
        d();
        this.g = true;
        this.h = paramBoolean1;
        m = this.a.size();
        if (m < 1)
          continue;
        PopupWindow localPopupWindow = this.f;
        if (localPopupWindow != null)
          return;
        Display localDisplay = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay();
        if (localDisplay.getWidth() <= localDisplay.getHeight())
          break label649;
        n = 1;
        if (this.k != null)
          continue;
        this.k = new View(this.d);
        this.k.setBackgroundColor(this.d.getResources().getColor(17170445));
        this.k.setOnTouchListener(new CustomMenu.1(this));
        ((ViewGroup)paramView).addView(this.k, new WindowManager.LayoutParams(-1, -1));
        this.k.bringToFront();
        this.j = this.e.inflate(2130903278, null);
        this.f = new PopupWindow(this.j, -1, -2, false);
        if (!paramBoolean2)
          continue;
        this.f.setAnimationStyle(16973910);
        this.f.setWidth(localDisplay.getWidth());
        this.f.showAtLocation(paramView, 80, 0, 0);
        if (n == 0)
          break label655;
        i1 = 6;
        break label615;
        int i3 = m / i1;
        if (m % i1 != 0)
          break label667;
        i4 = 0;
        this.i = (i4 + i3);
        if (!paramBoolean1)
          break label608;
        i5 = this.i;
        TableLayout localTableLayout = (TableLayout)this.j.findViewById(2131297095);
        localTableLayout.removeAllViews();
        i6 = 0;
        if (i6 < i5)
        {
          TableRow localTableRow = new TableRow(this.d);
          localTableRow.setLayoutParams(new WindowManager.LayoutParams(-1, -2));
          i7 = 0;
          break label626;
          label345: localTableLayout.addView(localTableRow);
          i6++;
          continue;
          label358: if ((i6 != i5 - 1) || (i7 != i1 - 1) || (m <= i5 * i1) || (paramBoolean1))
            continue;
          CustomMenuItem localCustomMenuItem2 = new CustomMenuItem();
          localCustomMenuItem2.a(this.d.getResources().getString(2131363450));
          localCustomMenuItem2.b(1006);
          localCustomMenuItem2.a(2130838827);
          CustomMenuItem localCustomMenuItem1 = localCustomMenuItem2;
          View localView = this.e.inflate(2130903279, null);
          TextView localTextView = (TextView)localView.findViewById(2131297097);
          localTextView.setText(localCustomMenuItem1.a());
          ImageView localImageView = (ImageView)localView.findViewById(2131297096);
          localImageView.setImageResource(localCustomMenuItem1.b());
          if (localCustomMenuItem1.d())
            continue;
          localImageView.setAlpha(75);
          localTextView.setTextColor(this.d.getResources().getColor(2131165471));
          localView.setClickable(false);
          localTableRow.addView(localView);
          i7++;
          break label626;
          localCustomMenuItem1 = (CustomMenuItem)this.a.get(i7 + i6 * i1);
          continue;
          localView.setOnClickListener(new CustomMenu.2(this, localCustomMenuItem1));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.l.b(FB4A_AnalyticEntities.Modules.i, false);
      continue;
      label608: int i5 = i2;
      continue;
      while (true)
      {
        label615: if (n == 0)
          break label661;
        i2 = 1;
        break label245;
        label626: if (i7 >= i1)
          break label345;
        if (i7 + i6 * i1 < m)
          break label358;
        break label345;
        label649: n = 0;
        break;
        label655: i1 = 3;
      }
      label661: int i2 = 2;
      continue;
      label667: int i4 = 1;
    }
  }

  public void a(ExportMenuToFbHostActivity paramExportMenuToFbHostActivity)
  {
    if (!this.c.contains(paramExportMenuToFbHostActivity))
      this.c.add(paramExportMenuToFbHostActivity);
  }

  public void a(CustomMenuActivity paramCustomMenuActivity)
  {
    if (!this.b.contains(paramCustomMenuActivity))
      this.b.add(paramCustomMenuActivity);
  }

  public void a(ArrayList<CustomMenuItem> paramArrayList)
  {
    monitorenter;
    try
    {
      boolean bool = this.g;
      if (bool);
      while (true)
      {
        return;
        this.a = paramArrayList;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean a()
  {
    return this.g;
  }

  public boolean b()
  {
    return this.h;
  }

  public void c()
  {
    monitorenter;
    try
    {
      this.g = false;
      this.h = false;
      if (this.f != null)
      {
        this.f.dismiss();
        this.f = null;
        this.l.b(FB4A_AnalyticEntities.Modules.i);
      }
      if (this.k != null)
      {
        ((ViewGroup)this.k.getParent()).removeView(this.k);
        this.k = null;
      }
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.CustomMenu
 * JD-Core Version:    0.6.0
 */