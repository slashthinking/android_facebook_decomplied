package com.karmascience.gifts.content;

import android.content.Context;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Provider;

public class AsyncMethodRunner
{
  private static final String a = AsyncMethodRunner.class.getSimpleName();
  private final ExecutorService b = Executors.newCachedThreadPool();
  private final Provider<SingleMethodRunner> c;
  private final SingleMethodRunner d;

  public AsyncMethodRunner(Context paramContext)
  {
    this.c = FbInjector.a(paramContext).b(SingleMethodRunner.class);
    this.d = ((SingleMethodRunner)this.c.b());
  }

  public void a(GraphPOJOApiMethod paramGraphPOJOApiMethod, String paramString)
  {
    this.b.execute(new AsyncMethodRunner.1(this, paramGraphPOJOApiMethod, paramString));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.AsyncMethodRunner
 * JD-Core Version:    0.6.0
 */