package com.facebook.orca.nux;

import com.facebook.orca.annotations.IsPartialAccount;
import com.facebook.orca.inject.AbstractProvider;
import javax.inject.Inject;
import javax.inject.Provider;

public class ShouldSkipContactImportNuxProvider extends AbstractProvider<Boolean>
{
  private final Provider<Boolean> a;

  @Inject
  public ShouldSkipContactImportNuxProvider(@IsPartialAccount Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
  }

  public Boolean a()
  {
    return (Boolean)this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ShouldSkipContactImportNuxProvider
 * JD-Core Version:    0.6.0
 */