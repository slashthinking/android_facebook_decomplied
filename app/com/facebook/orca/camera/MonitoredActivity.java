package com.facebook.orca.camera;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends Activity
{
  private final ArrayList<MonitoredActivity.LifeCycleListener> a = new ArrayList();

  public void a(MonitoredActivity.LifeCycleListener paramLifeCycleListener)
  {
    if (this.a.contains(paramLifeCycleListener));
    while (true)
    {
      return;
      this.a.add(paramLifeCycleListener);
    }
  }

  public void b(MonitoredActivity.LifeCycleListener paramLifeCycleListener)
  {
    this.a.remove(paramLifeCycleListener);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).a(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).b(this);
  }

  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).c(this);
  }

  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).d(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.MonitoredActivity
 * JD-Core Version:    0.6.0
 */