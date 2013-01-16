package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.friendrequests.FriendRequestsFragment;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import java.util.Map;

public class WindowPopupViewDelegate extends AbstractPopupViewDelegate
{
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final OrcaSharedPreferences i;

  public WindowPopupViewDelegate(Context paramContext, ViewGroup paramViewGroup, Handler paramHandler, Map<PopupViewDelegate.PopupState, Point> paramMap)
  {
    super(paramContext, paramViewGroup, paramHandler, paramMap);
    this.i = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
    Resources localResources = paramContext.getResources();
    this.d = localResources.getDimensionPixelSize(2131230913);
    this.e = localResources.getDimensionPixelSize(2131230914);
    this.f = localResources.getDimensionPixelSize(2131230915);
    this.g = localResources.getDimensionPixelSize(2131230916);
    this.h = localResources.getDimensionPixelSize(2131230917);
    if (!a(paramContext))
      this.a.findViewById(2131297697).setVisibility(8);
    while (true)
    {
      this.a.findViewById(2131297694).setOnClickListener(new WindowPopupViewDelegate.1(this, paramContext));
      do
        return;
      while (paramContext == null);
      FragmentTransaction localFragmentTransaction = ((FragmentActivity)paramContext).g().a();
      localFragmentTransaction.a(2131297697, new FriendRequestsFragment());
      localFragmentTransaction.a();
    }
  }

  private Point a(Point paramPoint, int paramInt1, int paramInt2)
  {
    int j = paramInt2 - paramInt1;
    int k = paramPoint.y - j - this.b;
    return new Point(paramPoint.x, k);
  }

  private Point b(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    return new Point(localDisplay.getWidth(), localDisplay.getHeight());
  }

  protected Point a(Point paramPoint)
  {
    int j;
    int k;
    label22: int m;
    if (paramPoint.x <= paramPoint.y)
    {
      j = 1;
      if (j == 0)
        break label69;
      k = this.e;
      m = k + 2 * this.g;
      if (j == 0)
        break label77;
    }
    label69: label77: for (int n = this.d; ; n = this.e)
    {
      return new Point(m, n + this.f + this.g);
      j = 0;
      break;
      k = this.d;
      break label22;
    }
  }

  protected ListenableRelativeLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return (ListenableRelativeLayout)paramLayoutInflater.inflate(2130903499, paramViewGroup, false);
  }

  protected void a()
  {
    if (this.a == null)
      return;
    Context localContext = this.a.getContext();
    Resources localResources = localContext.getResources();
    int j = localResources.getDimensionPixelSize(2131230969);
    int k = localResources.getDimensionPixelSize(2131230821);
    int m = localResources.getDimensionPixelSize(2131230965);
    Point localPoint1 = b(localContext);
    Point localPoint2 = a(localPoint1, j, k);
    Point localPoint3 = a(localPoint1);
    int n = localPoint2.y - localPoint3.y;
    int i1 = localPoint2.x - localPoint3.x;
    int i2;
    label115: int i3;
    if (localPoint1.x < localPoint1.y)
    {
      i2 = this.b;
      if (n <= 0)
        break label304;
      i3 = n;
      label124: if (i1 <= 0)
        break label323;
    }
    label304: label323: for (int i4 = i1 / 2; ; i4 = -Math.min(this.h, -i1 / 2))
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      View localView1 = this.a.findViewById(2131297693);
      localLayoutParams1.addRule(10, -1);
      localLayoutParams1.addRule(14, -1);
      localLayoutParams1.setMargins(i4, j, i4, i3);
      localView1.setLayoutParams(localLayoutParams1);
      localView1.requestLayout();
      localView1.invalidate();
      this.a.findViewById(2131297695).setPadding(m + (i4 + this.g), m + (j + this.f) - k, m + (i4 + this.g), m + (i3 + this.g));
      View localView2 = this.a.findViewById(2131297694);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams2.setMargins(0, k, 0, 0);
      localView2.setLayoutParams(localLayoutParams2);
      break;
      i2 = 0;
      break label115;
      i3 = i2 + -Math.min(-n, this.h);
      break label124;
    }
  }

  protected boolean a(Context paramContext)
  {
    boolean bool = true;
    if ((this.i.a(FbandroidPrefKeys.b, bool)) && (Boolean.TRUE.equals(Gatekeeper.a(paramContext, "facebook_for_android_native_friends_jewel"))));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public boolean l()
  {
    return true;
  }

  public int m()
  {
    return 2130903249;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.WindowPopupViewDelegate
 * JD-Core Version:    0.6.0
 */