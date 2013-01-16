package com.facebook.orca.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.base.PropertyBag;
import com.facebook.dispose.Disposable;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FbFragmentActivity extends FragmentActivity
  implements PropertyBag, DisposableContext, FbActivityish
{
  private AndroidThreadUtil n;
  private Set<FbActivityListener> o;
  private String p;
  private Map<Object, Object> q;
  private boolean r;
  private Set<Disposable> s;

  private void b(Disposable paramDisposable)
  {
    monitorenter;
    try
    {
      if (!this.r)
        this.s.remove(paramDisposable);
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

  public FbInjector C()
  {
    return FbInjector.a(this);
  }

  protected Set<FbActivityListener> D()
  {
    return Collections.unmodifiableSet(this.o);
  }

  public Object a(Object paramObject)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramObject);
      if (this.q != null)
      {
        Object localObject3 = this.q.get(paramObject);
        localObject2 = localObject3;
        return localObject2;
      }
      Object localObject2 = null;
    }
    finally
    {
      monitorexit;
    }
  }

  protected void a(Bundle paramBundle)
  {
  }

  public void a(Disposable paramDisposable)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramDisposable);
      if (this.r)
        this.n.d(new FbFragmentActivity.1(this, paramDisposable));
      while (true)
      {
        return;
        if (this.s == null)
          this.s = Sets.a();
        this.s.add(paramDisposable);
        paramDisposable.a(new FbFragmentActivity.2(this));
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(Object paramObject1, Object paramObject2)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramObject1);
      Preconditions.checkNotNull(paramObject2);
      if (this.q == null)
        this.q = Maps.a();
      this.q.put(paramObject1, paramObject2);
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

  public void a(String paramString, Fragment paramFragment)
  {
    FragmentTransaction localFragmentTransaction = g().a();
    localFragmentTransaction.a(paramFragment, paramString);
    localFragmentTransaction.a();
  }

  public boolean a(Exception paramException)
  {
    Iterator localIterator = this.o.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((FbActivityListener)localIterator.next()).a(this, paramException));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected void a_(Bundle paramBundle)
  {
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public String e()
  {
    return this.p;
  }

  protected <T extends View> T f(int paramInt)
  {
    return findViewById(paramInt);
  }

  public void finish()
  {
    super.finish();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).j(this);
  }

  public void onBackPressed()
  {
    Iterator localIterator = this.o.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((FbActivityListener)localIterator.next()).m(this));
    while (true)
    {
      return;
      super.onBackPressed();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramConfiguration);
  }

  public void onContentChanged()
  {
    super.onContentChanged();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).k(this);
  }

  protected final void onCreate(Bundle paramBundle)
  {
    FbInjector localFbInjector = C();
    this.n = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.o = localFbInjector.c(FbActivityListener.class);
    super.onCreate(paramBundle);
    a_(paramBundle);
    Iterator localIterator1 = this.o.iterator();
    do
    {
      if (!localIterator1.hasNext())
        break;
      ((FbActivityListener)localIterator1.next()).f(this);
    }
    while (!isFinishing());
    while (true)
    {
      return;
      a(paramBundle);
      Iterator localIterator2 = this.o.iterator();
      while (localIterator2.hasNext())
        ((FbActivityListener)localIterator2.next()).g(this);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Iterator localIterator = this.o.iterator();
    Dialog localDialog;
    do
    {
      if (!localIterator.hasNext())
        break;
      localDialog = ((FbActivityListener)localIterator.next()).a(this, paramInt);
    }
    while (localDialog == null);
    while (true)
    {
      return localDialog;
      localDialog = super.onCreateDialog(paramInt);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    monitorenter;
    try
    {
      this.r = true;
      monitorexit;
      try
      {
        if (this.s == null)
          break label76;
        Iterator localIterator2 = this.s.iterator();
        while (localIterator2.hasNext())
          ((Disposable)localIterator2.next()).a();
      }
      finally
      {
        super.onDestroy();
      }
    }
    finally
    {
      monitorexit;
    }
    this.s.clear();
    label76: Iterator localIterator1 = this.o.iterator();
    while (localIterator1.hasNext())
      ((FbActivityListener)localIterator1.next()).h(this);
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.o.iterator();
    Boolean localBoolean;
    do
    {
      if (!localIterator.hasNext())
        break;
      localBoolean = ((FbActivityListener)localIterator.next()).a(this, paramInt, paramKeyEvent);
    }
    while (localBoolean == null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.o.iterator();
    Boolean localBoolean;
    do
    {
      if (!localIterator.hasNext())
        break;
      localBoolean = ((FbActivityListener)localIterator.next()).b(this, paramInt, paramKeyEvent);
    }
    while (localBoolean == null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = super.onKeyUp(paramInt, paramKeyEvent))
      return bool;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Iterator localIterator = this.o.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((FbActivityListener)localIterator.next()).a(paramMenuItem));
    for (boolean bool = true; ; bool = super.onOptionsItemSelected(paramMenuItem))
      return bool;
  }

  protected void onPause()
  {
    super.onPause();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).c(this);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramBundle);
  }

  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.o.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((FbActivityListener)localIterator.next()).a(this, paramInt, paramDialog));
    while (true)
    {
      return;
      super.onPrepareDialog(paramInt, paramDialog);
    }
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).b(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onResume()
  {
    super.onResume();
    this.p = FbActivityUtils.a();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).b(this);
  }

  public boolean onSearchRequested()
  {
    Iterator localIterator = this.o.iterator();
    Boolean localBoolean;
    do
    {
      if (!localIterator.hasNext())
        break;
      localBoolean = ((FbActivityListener)localIterator.next()).l(this);
    }
    while (localBoolean == null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = super.onSearchRequested())
      return bool;
  }

  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this);
  }

  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).d(this);
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).e(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbFragmentActivity
 * JD-Core Version:    0.6.0
 */