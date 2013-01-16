package com.facebook.orca.threadview;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentHost;
import android.support.v4.app.NestedFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;

public class ThreadViewMapFragmentTab extends NestedFragment
{
  private LocalActivityManager a;
  private ThreadViewMapActivityTab b;
  private FrameLayout c;
  private boolean d;
  private ThreadSummary e;
  private ImmutableList<Message> f;

  private void a()
  {
    if (this.d);
    while (true)
    {
      return;
      if (ThreadViewMapActivityTabShim.a())
      {
        Class localClass = ThreadViewMapActivityTabShim.b();
        Intent localIntent = new Intent().setClass(p(), localClass);
        Window localWindow = this.a.startActivity("map", localIntent);
        this.b = ((ThreadViewMapActivityTab)this.a.getActivity("map"));
        this.c.addView(localWindow.getDecorView());
        this.d = true;
        if ((this.e == null) || (this.f == null))
          continue;
        this.b.a(this.e, this.f);
        continue;
      }
    }
  }

  public void B()
  {
    super.B();
    if (!w())
    {
      a();
      this.a.dispatchResume();
    }
  }

  public void C()
  {
    super.C();
    if (!w())
      this.a.dispatchPause(o().c());
  }

  public void D()
  {
    super.D();
    this.a.dispatchDestroy(o().c());
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = new FrameLayout(p());
    return this.c;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a = new LocalActivityManager((Activity)p(), false);
    this.a.dispatchCreate(paramBundle);
  }

  void a(ThreadSummary paramThreadSummary, ImmutableList<Message> paramImmutableList)
  {
    this.e = paramThreadSummary;
    this.f = paramImmutableList;
    if (this.b != null)
      this.b.a(paramThreadSummary, paramImmutableList);
  }

  public void d(boolean paramBoolean)
  {
    if (u())
    {
      if (!paramBoolean)
        break label20;
      this.a.dispatchPause(false);
    }
    while (true)
    {
      return;
      label20: a();
      this.a.dispatchResume();
    }
  }

  public void g()
  {
    super.g();
    this.a.dispatchStop();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapFragmentTab
 * JD-Core Version:    0.6.0
 */