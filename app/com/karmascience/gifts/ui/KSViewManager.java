package com.karmascience.gifts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.Utils;
import com.karmascience.gifts.views.CommonViewUtils;
import com.karmascience.gifts.views.KSViewController;
import com.karmascience.gifts.views.ViewController;
import java.util.Stack;

public class KSViewManager
  implements IViewManager
{
  private final ViewGroup a;
  private final ViewGroup b;
  private final Stack<KSViewManager.HistoryStackElement> c;
  private final ThreadingService d;
  private final AnalyticsWrapper e;
  private final LayoutInflater f;
  private final Activity g;
  private final ViewControllerFactory h;
  private Handler i;
  private IViewChangedListener j;
  private boolean k;
  private boolean l;

  public KSViewManager(Activity paramActivity, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewControllerFactory paramViewControllerFactory)
  {
    this.g = paramActivity;
    this.h = paramViewControllerFactory;
    this.a = paramViewGroup1;
    this.b = paramViewGroup2;
    this.c = new Stack();
    this.d = ((ThreadingService)this.g.getSystemService("ks_threading_service"));
    this.e = ((AnalyticsWrapper)this.g.getSystemService("ks_metric_service"));
    this.f = LayoutInflater.from(this.g);
    this.l = false;
  }

  private final void a(KSViewController paramKSViewController1, KSViewController paramKSViewController2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    CommonViewUtils.a(this.g, this.a.getApplicationWindowToken());
    if (paramKSViewController2 == null)
    {
      if (paramKSViewController1.f())
        this.b.addView(paramKSViewController1.e());
      while (true)
      {
        paramKSViewController1.k();
        paramKSViewController1.a(false);
        if (this.j != null)
          this.j.a(paramKSViewController1);
        return;
        this.a.addView(paramKSViewController1.e());
      }
    }
    int m;
    label85: int n;
    label93: ViewGroup localViewGroup1;
    if (paramBoolean3)
    {
      m = 0;
      n = 0;
      if (!paramBoolean3)
        break label149;
      localViewGroup1 = this.a;
      if (!paramKSViewController2.f())
        break label167;
    }
    label149: label167: for (ViewGroup localViewGroup2 = this.b; ; localViewGroup2 = this.a)
    {
      a(paramKSViewController1, paramKSViewController2, m, n, localViewGroup1, localViewGroup2, paramBoolean2);
      break;
      if (paramBoolean1)
      {
        m = 2130968617;
        break label85;
      }
      m = 2130968613;
      break label85;
      if (paramBoolean1)
      {
        n = 2130968619;
        break label93;
      }
      n = 2130968615;
      break label93;
    }
  }

  private void a(ViewController paramViewController1, ViewController paramViewController2, int paramInt1, int paramInt2, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, boolean paramBoolean)
  {
    this.l = true;
    View localView1 = paramViewController1.e();
    localView1.setVisibility(0);
    paramViewController1.a(false);
    paramViewGroup1.addView(localView1);
    View localView2;
    if (paramViewController2 != null)
    {
      localView2 = paramViewController2.e();
      localView2.bringToFront();
      paramViewController1.k();
      if (paramInt1 != 0)
        break label125;
      this.l = false;
      label65: if (localView2 != null)
      {
        if (paramInt2 != 0)
          break label158;
        localView2.setVisibility(8);
        paramViewController2.a(true);
        paramViewController2.j();
        this.d.a(new KSViewManager.2(this, paramViewGroup2, localView2, paramBoolean, paramViewController2));
      }
    }
    while (true)
    {
      return;
      localView2 = null;
      break;
      label125: Animation localAnimation1 = AnimationUtils.loadAnimation(this.g, paramInt1);
      localAnimation1.setAnimationListener(new KSViewManager.1(this));
      localView1.startAnimation(localAnimation1);
      break label65;
      label158: Animation localAnimation2 = AnimationUtils.loadAnimation(this.g, paramInt2);
      localAnimation2.setAnimationListener(new KSViewManager.3(this, localView2, paramViewController2, paramViewGroup2, paramBoolean));
      localView2.startAnimation(localAnimation2);
    }
  }

  private boolean c(int paramInt)
  {
    return false;
  }

  private String f()
  {
    KSViewManager.HistoryStackElement localHistoryStackElement;
    if (!this.c.isEmpty())
    {
      localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.get(0);
      if ((localHistoryStackElement == null) || (localHistoryStackElement.a == null));
    }
    for (String str = localHistoryStackElement.a.m(); ; str = null)
      return str;
  }

  public KSViewController a()
  {
    KSViewController localKSViewController;
    if (!this.c.isEmpty())
    {
      KSViewManager.HistoryStackElement localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.peek();
      if (localHistoryStackElement != null)
        localKSViewController = (KSViewController)localHistoryStackElement.a;
    }
    while (true)
    {
      return localKSViewController;
      localKSViewController = null;
      continue;
      localKSViewController = null;
    }
  }

  public String a(int paramInt)
  {
    int m = 0;
    KSViewManager.HistoryStackElement localHistoryStackElement;
    if (m < this.c.size())
    {
      localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.get(m);
      if ((localHistoryStackElement == null) || (localHistoryStackElement.b != paramInt));
    }
    for (String str = localHistoryStackElement.a.m(); ; str = null)
    {
      return str;
      m++;
      break;
    }
  }

  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.l);
    while (true)
    {
      return;
      if ((!c(paramInt)) || (this.c.isEmpty()))
        break;
      a(paramInt, paramBundle, false);
    }
    KSViewController localKSViewController = this.h.a(paramInt, this.g, this.i, this, paramBundle);
    LayoutInflater localLayoutInflater = this.f;
    ViewGroup localViewGroup;
    if (localKSViewController.f())
    {
      localViewGroup = this.b;
      label74: localKSViewController.b(localLayoutInflater, localViewGroup, null);
      this.e.c("View New Page").a("page_identifier", localKSViewController.d()).a(localKSViewController.B()).a();
      if (paramBundle == null)
        break label172;
    }
    label172: for (boolean bool = paramBundle.getBoolean("no_anims", false); ; bool = false)
    {
      a(localKSViewController, a(), false, false, bool);
      KSViewManager.HistoryStackElement localHistoryStackElement = new KSViewManager.HistoryStackElement(this, localKSViewController, paramInt);
      this.c.add(localHistoryStackElement);
      break;
      localViewGroup = this.a;
      break label74;
    }
  }

  public void a(int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.l)
      return;
    KSViewController localKSViewController1 = a();
    while (this.c.size() > 0)
    {
      KSViewManager.HistoryStackElement localHistoryStackElement2 = (KSViewManager.HistoryStackElement)this.c.remove(-1 + this.c.size());
      if ((localHistoryStackElement2 == null) || (localHistoryStackElement2.a == null) || (localKSViewController1 == localHistoryStackElement2.a))
        continue;
      localHistoryStackElement2.a.i();
    }
    KSViewController localKSViewController2 = this.h.a(paramInt, this.g, this.i, this, paramBundle);
    LayoutInflater localLayoutInflater = this.f;
    ViewGroup localViewGroup;
    if (localKSViewController2.f())
    {
      localViewGroup = this.b;
      label121: localKSViewController2.b(localLayoutInflater, localViewGroup, null);
      KSViewManager.HistoryStackElement localHistoryStackElement1 = new KSViewManager.HistoryStackElement(this, localKSViewController2, paramInt);
      this.c.add(localHistoryStackElement1);
      if (paramBundle == null)
        break label192;
    }
    label192: for (boolean bool = paramBundle.getBoolean("no_anims", false); ; bool = false)
    {
      a(localKSViewController2, localKSViewController1, paramBoolean, true, bool);
      break;
      localViewGroup = this.a;
      break label121;
    }
  }

  public void a(Bundle paramBundle)
  {
    a(f(), paramBundle);
  }

  public void a(IViewChangedListener paramIViewChangedListener)
  {
    this.j = paramIViewChangedListener;
  }

  public void a(ViewHandler paramViewHandler)
  {
    this.i = paramViewHandler;
  }

  public boolean a(String paramString)
  {
    return a(paramString, null);
  }

  public boolean a(String paramString, Bundle paramBundle)
  {
    int m = 1;
    if (this.c.size() <= m)
      m = 0;
    KSViewController localKSViewController1;
    do
    {
      do
        return m;
      while (this.l);
      localKSViewController1 = a();
    }
    while ((localKSViewController1 != null) && (Utils.a(paramString, localKSViewController1.m())));
    this.c.pop();
    while (true)
    {
      KSViewManager.HistoryStackElement localHistoryStackElement;
      if (this.c.size() > m)
      {
        localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.peek();
        if ((localHistoryStackElement == null) || (localHistoryStackElement.a == null) || ((paramString != null) && (!paramString.equals(localHistoryStackElement.a.m()))));
      }
      else
      {
        KSViewController localKSViewController2 = a();
        if ((paramBundle != null) && (paramBundle.getBoolean("apply_bundle")))
          localKSViewController2.a(paramBundle);
        boolean bool = false;
        if (paramBundle != null)
          bool = paramBundle.getBoolean("no_anims", false);
        a(localKSViewController2, localKSViewController1, m, m, bool);
        break;
      }
      if ((localHistoryStackElement != null) && (localHistoryStackElement.a != null))
        localHistoryStackElement.a.i();
      this.c.pop();
    }
  }

  public String b(int paramInt)
  {
    int m = -1 + this.c.size();
    KSViewManager.HistoryStackElement localHistoryStackElement;
    if (m >= 0)
    {
      localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.get(m);
      if ((localHistoryStackElement == null) || (localHistoryStackElement.b != paramInt));
    }
    for (String str = localHistoryStackElement.a.m(); ; str = null)
    {
      return str;
      m--;
      break;
    }
  }

  public boolean b()
  {
    return this.k;
  }

  public void c()
  {
    KSViewController localKSViewController = a();
    if (localKSViewController != null)
      localKSViewController.j();
  }

  public void d()
  {
    KSViewController localKSViewController = a();
    if (localKSViewController != null)
      localKSViewController.k();
  }

  public void e()
  {
    this.k = true;
    while (!this.c.isEmpty())
    {
      KSViewManager.HistoryStackElement localHistoryStackElement = (KSViewManager.HistoryStackElement)this.c.pop();
      if ((localHistoryStackElement == null) || (localHistoryStackElement.a == null))
        continue;
      localHistoryStackElement.a.i();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ui.KSViewManager
 * JD-Core Version:    0.6.0
 */