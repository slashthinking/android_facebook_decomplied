package com.facebook.orca.inject;

import android.content.Context;
import com.google.inject.Key;
import javax.inject.Provider;

public class ContextAwareInjector extends AbstractInjector
{
  private final Context a;
  private final ContextScope b;
  private final FbInjector c;

  public ContextAwareInjector(FbInjector paramFbInjector, ContextScope paramContextScope, Context paramContext)
  {
    this.c = paramFbInjector;
    this.b = paramContextScope;
    this.a = paramContext;
  }

  public <T> Provider<T> b(Key<T> paramKey)
  {
    return new ContextAwareInjector.1(this, this.c.b(paramKey));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ContextAwareInjector
 * JD-Core Version:    0.6.0
 */