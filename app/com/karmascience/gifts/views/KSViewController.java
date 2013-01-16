package com.karmascience.gifts.views;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.common.util.Toaster;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.controllers.CardManager;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.ui.IViewManager;
import java.util.Map;

public abstract class KSViewController
  implements ViewController
{
  private final Handler a;
  private final Activity b;
  private final Bundle c;
  private final String d;
  private final IViewManager e;
  private Button f;
  private boolean g;
  private boolean h;
  private View i;

  public KSViewController(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    this.b = paramActivity;
    this.c = paramBundle;
    this.a = paramHandler;
    this.e = paramIViewManager;
    this.d = paramString;
  }

  public void A()
  {
  }

  public Map<String, String> B()
  {
    return null;
  }

  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);

  public void a()
  {
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public final void a(int paramInt, Object paramObject)
  {
    String str1 = this.b.getResources().getString(2131362235);
    String str2;
    if (!w())
      str2 = this.b.getResources().getString(2131362237);
    while (true)
    {
      if (str2 != null)
        Toaster.a(g(), str2);
      u();
      return;
      if (paramInt == 1001)
      {
        str2 = this.b.getResources().getString(2131362235);
        continue;
      }
      if (paramInt == 1003)
      {
        if (paramObject != null);
        str2 = this.b.getResources().getString(2131362235);
        continue;
      }
      if (paramInt == 1002)
      {
        str2 = this.b.getResources().getString(2131362234);
        continue;
      }
      if (paramInt == 1005)
      {
        str2 = this.b.getResources().getString(2131362236);
        continue;
      }
      if (paramInt == 426)
      {
        String str3 = (String)paramObject;
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.b);
        localBuilder.setTitle(2131362239);
        localBuilder.setMessage(2131362240);
        localBuilder.setCancelable(false);
        localBuilder.setPositiveButton(2131362241, new KSViewController.1(this, str3));
        localBuilder.show();
        str2 = null;
        continue;
      }
      if ((paramObject instanceof String))
      {
        str2 = (String)paramObject;
        continue;
      }
      str2 = str1;
    }
  }

  public void a(Bundle paramBundle)
  {
  }

  public void a(View paramView, Bundle paramBundle)
  {
  }

  public void a(Button paramButton)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.h = bool;
      c(paramBoolean);
      return;
    }
  }

  public final View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.i != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.i.getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(this.i);
    }
    for (View localView = this.i; ; localView = this.i)
    {
      return localView;
      this.i = a(paramLayoutInflater, paramViewGroup, paramBundle);
      a(this.i, paramBundle);
    }
  }

  public String b()
  {
    return null;
  }

  public void b(Bundle paramBundle)
  {
    Message localMessage = this.a.obtainMessage(paramBundle.getInt("command"), paramBundle);
    this.a.sendMessage(localMessage);
  }

  public void b(boolean paramBoolean)
  {
    Bundle localBundle = CommonViewUtils.a();
    localBundle.putBoolean("dismissable", paramBoolean);
    b(localBundle);
  }

  public void c()
  {
  }

  public void c(boolean paramBoolean)
  {
  }

  public abstract String d();

  public final View e()
  {
    return this.i;
  }

  public boolean f()
  {
    return false;
  }

  public final Activity g()
  {
    return this.b;
  }

  public final FragmentActivity h()
  {
    if ((this.b instanceof FragmentActivity));
    for (FragmentActivity localFragmentActivity = (FragmentActivity)this.b; ; localFragmentActivity = null)
      return localFragmentActivity;
  }

  public void i()
  {
    z();
  }

  public void j()
  {
    this.g = false;
    A();
  }

  public void k()
  {
    this.g = true;
    a();
  }

  public boolean l()
  {
    return this.h;
  }

  public String m()
  {
    return this.d;
  }

  public AnalyticsWrapper n()
  {
    return (AnalyticsWrapper)this.b.getSystemService("ks_metric_service");
  }

  public ThreadingService o()
  {
    return (ThreadingService)this.b.getSystemService("ks_threading_service");
  }

  public OrderManager p()
  {
    return (OrderManager)this.b.getSystemService("ks_order_manager");
  }

  public CardManager q()
  {
    return (CardManager)this.b.getSystemService("ks_card_manager");
  }

  public ProductsManager r()
  {
    return (ProductsManager)this.b.getSystemService("ks_products_manager");
  }

  public Bundle s()
  {
    return this.c;
  }

  public void t()
  {
    b(true);
  }

  public void u()
  {
    b(CommonViewUtils.b());
  }

  public boolean v()
  {
    return false;
  }

  public boolean w()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.b.getSystemService("connectivity");
    if ((localConnectivityManager != null) && (localConnectivityManager.getActiveNetworkInfo() != null));
    for (boolean bool = localConnectivityManager.getActiveNetworkInfo().isConnectedOrConnecting(); ; bool = false)
      return bool;
  }

  protected int x()
  {
    return 2130903297;
  }

  public final Button y()
  {
    if (this.f == null)
    {
      this.f = ((Button)View.inflate(this.b, x(), null));
      this.f.setGravity(17);
      this.f.setTextSize(0, this.b.getResources().getDimensionPixelSize(2131230839));
      a(this.f);
    }
    return this.f;
  }

  public void z()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.KSViewController
 * JD-Core Version:    0.6.0
 */