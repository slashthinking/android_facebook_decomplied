package com.facebook.orca.inject;

import android.content.Context;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Provider;

public class ContextScope
  implements Scope
{
  private final ThreadLocal<List<Context>> a = new ContextScope.1(this);

  public <T> Provider<T> a(Provider<T> paramProvider)
  {
    return new ContextScopedProvider(this, paramProvider);
  }

  public void a()
  {
    List localList = (List)this.a.get();
    if (localList.isEmpty())
      throw new NoSuchElementException();
    localList.remove(-1 + localList.size());
  }

  public void a(Context paramContext)
  {
    ((List)this.a.get()).add(paramContext);
  }

  public Class<? extends Annotation> annotationType()
  {
    return ContextScoped.class;
  }

  public Context getContext()
  {
    List localList = (List)this.a.get();
    if (localList.isEmpty());
    for (Context localContext = null; ; localContext = (Context)localList.get(-1 + localList.size()))
      return localContext;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ContextScope
 * JD-Core Version:    0.6.0
 */