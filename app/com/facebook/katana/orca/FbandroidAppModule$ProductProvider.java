package com.facebook.katana.orca;

import com.facebook.app.Product;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$ProductProvider extends AbstractProvider<Product>
{
  private FbandroidAppModule$ProductProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Product a()
  {
    return ((OrcaAppType)b(OrcaAppType.class)).i();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.ProductProvider
 * JD-Core Version:    0.6.0
 */