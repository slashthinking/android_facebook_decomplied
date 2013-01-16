package com.facebook.login;

import com.google.common.base.Supplier;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Provider;

public class ContextAwareAuthTokenStringSupplier
  implements Supplier<String>
{
  private final Provider<String> a;
  private ThreadLocal<List<String>> b = new ContextAwareAuthTokenStringSupplier.1(this);

  public ContextAwareAuthTokenStringSupplier(Provider<String> paramProvider)
  {
    this.a = paramProvider;
  }

  public void a()
  {
    List localList = (List)this.b.get();
    if (localList.isEmpty())
      throw new NoSuchElementException();
    localList.remove(-1 + localList.size());
  }

  public void a(String paramString)
  {
    ((List)this.b.get()).add(paramString);
  }

  public String b()
  {
    List localList = (List)this.b.get();
    if (!localList.isEmpty());
    for (String str = (String)localList.get(-1 + localList.size()); ; str = (String)this.a.b())
      return str;
  }

  public String c()
  {
    List localList = (List)this.b.get();
    if (!localList.isEmpty());
    for (String str = (String)localList.get(-1 + localList.size()); ; str = null)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.login.ContextAwareAuthTokenStringSupplier
 * JD-Core Version:    0.6.0
 */