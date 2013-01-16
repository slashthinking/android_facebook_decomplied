package com.facebook.orca.inject;

import android.os.Looper;
import android.os.MessageQueue;
import com.facebook.orca.app.INeedInit;
import com.google.inject.Key;
import java.util.Iterator;
import java.util.Set;

public class FbInjectorImpl$LessEagerUiThreadSingletonInitializer
  implements INeedInit
{
  public FbInjectorImpl$LessEagerUiThreadSingletonInitializer(FbInjectorImpl paramFbInjectorImpl)
  {
  }

  public void i_()
  {
    MessageQueue localMessageQueue = Looper.myQueue();
    if (localMessageQueue != null)
      localMessageQueue.addIdleHandler(new FbInjectorImpl.LessEagerUiThreadSingletonInitializer.1(this));
    while (true)
    {
      return;
      Iterator localIterator = FbInjectorImpl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        Key localKey = (Key)localIterator.next();
        this.a.a(localKey);
      }
      FbInjectorImpl.a(this.a).clear();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.FbInjectorImpl.LessEagerUiThreadSingletonInitializer
 * JD-Core Version:    0.6.0
 */