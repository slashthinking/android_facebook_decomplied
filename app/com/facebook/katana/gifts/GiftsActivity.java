package com.facebook.katana.gifts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.SingletonManager;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.ui.KSViewManager;
import com.karmascience.gifts.ui.ViewControllerFactory;
import com.karmascience.gifts.views.KSViewController;

public class GiftsActivity extends BaseFacebookActivity
{
  private static final String n = GiftsActivity.class.getSimpleName();
  private IViewManager o;
  private ProgressDialog p;
  private AnalyticsWrapper q;
  private boolean r = false;
  private ThreadingService s;
  private GiftsActivity.KarmaHandler t;
  private SingletonManager u;

  private void c(boolean paramBoolean)
  {
    if (this.p != null)
      if (!this.p.isShowing());
    while (true)
    {
      return;
      this.p.dismiss();
      this.p = null;
      this.p = new ProgressDialog(this);
      this.p.setCancelable(paramBoolean);
      this.p.setMessage(getString(2131362230));
      this.p.show();
    }
  }

  private void i()
  {
    if (this.p != null)
    {
      this.p.dismiss();
      this.p = null;
    }
  }

  protected void a(Bundle paramBundle)
  {
    setContentView(2130903240);
    this.u = new SingletonManager(this);
    this.q = ((AnalyticsWrapper)getSystemService("ks_metric_service"));
    this.s = ((ThreadingService)getSystemService("ks_threading_service"));
    OrderManager localOrderManager = (OrderManager)getSystemService("ks_order_manager");
    KSViewManager localKSViewManager = new KSViewManager(this, (ViewGroup)findViewById(2131296425), (ViewGroup)findViewById(2131297003), new ViewControllerFactory());
    this.t = new GiftsActivity.KarmaHandler(this, localKSViewManager);
    localKSViewManager.a(this.t);
    localKSViewManager.a(new GiftsActivity.1(this));
    this.o = localKSViewManager;
    String str1 = getIntent().getStringExtra("recipient_facebook_id");
    String str2 = getIntent().getStringExtra("entry_point");
    this.q.a(str1);
    localOrderManager.a(str1, null, null, null);
    this.q.c("App Launched").a("entry_point", str2).a();
    this.o.a(14, new Bundle());
  }

  public Object getSystemService(String paramString)
  {
    Object localObject;
    if (this.u != null)
    {
      localObject = this.u.a(paramString);
      if (localObject == null)
        break label27;
    }
    while (true)
    {
      return localObject;
      localObject = null;
      break;
      label27: localObject = super.getSystemService(paramString);
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    KSViewController localKSViewController = this.o.a();
    if (localKSViewController != null)
      localKSViewController.a(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    KSViewController localKSViewController = this.o.a();
    if (localKSViewController != null)
      if (!localKSViewController.v());
    while (true)
    {
      return;
      String str = localKSViewController.d();
      if (str != null)
        this.q.c("Clicked Back").a("page_identifier", str).a();
      if (this.o.a(null))
        continue;
      finish();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.o != null)
      this.o.e();
  }

  protected void onPause()
  {
    super.onPause();
    this.o.c();
    if (this.p != null);
    for (boolean bool = true; ; bool = false)
    {
      this.r = bool;
      this.q.c("App Paused").a();
      return;
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.q.c("App Resumed").a();
    if (this.r)
      c(true);
    this.o.d();
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (this.o.a() != null)
      this.o.a().c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.gifts.GiftsActivity
 * JD-Core Version:    0.6.0
 */