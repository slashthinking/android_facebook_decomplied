package com.facebook.orca.activity;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.facebook.base.PropertyBag;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FbPreferenceActivity extends PreferenceActivity
  implements PropertyBag, FbActivityish
{
  private Set<FbActivityListener> a;
  private String b;
  private Map<Object, Object> c;

  protected <T extends View> T a(int paramInt)
  {
    return findViewById(paramInt);
  }

  public Object a(Object paramObject)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramObject);
      if (this.c != null)
      {
        Object localObject3 = this.c.get(paramObject);
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

  public void a(Object paramObject1, Object paramObject2)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramObject1);
      Preconditions.checkNotNull(paramObject2);
      if (this.c == null)
        this.c = Maps.a();
      this.c.put(paramObject1, paramObject2);
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

  public boolean a(Exception paramException)
  {
    Iterator localIterator = this.a.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((FbActivityListener)localIterator.next()).a(this, paramException));
    for (int i = 1; ; i = 0)
      return i;
  }

  public FbInjector b()
  {
    return FbInjector.a(this);
  }

  protected void b(Bundle paramBundle)
  {
  }

  public String e()
  {
    return this.b;
  }

  public void finish()
  {
    super.finish();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).j(this);
  }

  public void onBackPressed()
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramConfiguration);
  }

  public void onContentChanged()
  {
    super.onContentChanged();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).k(this);
  }

  protected final void onCreate(Bundle paramBundle)
  {
    this.a = b().c(FbActivityListener.class);
    super.onCreate(paramBundle);
    b(paramBundle);
    Iterator localIterator1 = this.a.iterator();
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
      Iterator localIterator2 = this.a.iterator();
      while (localIterator2.hasNext())
        ((FbActivityListener)localIterator2.next()).g(this);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
        ((FbActivityListener)localIterator.next()).h(this);
    }
    finally
    {
      super.onDestroy();
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
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

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).c(this);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this, paramBundle);
  }

  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).b(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onResume()
  {
    super.onResume();
    this.b = FbActivityUtils.a();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).b(this);
  }

  public Object onRetainNonConfigurationInstance()
  {
    return null;
  }

  public boolean onSearchRequested()
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).a(this);
  }

  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).d(this);
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((FbActivityListener)localIterator.next()).e(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbPreferenceActivity
 * JD-Core Version:    0.6.0
 */