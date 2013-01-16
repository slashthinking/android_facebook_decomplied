package com.facebook.katana.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReentrantCallback<CallbackClass>
{
  private final Set<CallbackClass> a = new HashSet();

  public Set<CallbackClass> a()
  {
    return Collections.unmodifiableSet(new HashSet(this.a));
  }

  public void a(CallbackClass paramCallbackClass)
  {
    this.a.add(paramCallbackClass);
  }

  public int b()
  {
    return this.a.size();
  }

  public void b(CallbackClass paramCallbackClass)
  {
    this.a.remove(paramCallbackClass);
  }

  public void c()
  {
    this.a.clear();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ReentrantCallback
 * JD-Core Version:    0.6.0
 */