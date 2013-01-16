package com.facebook.katana.util;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aUtilsModule$PhonebookUtilsProvider extends AbstractProvider<PhonebookUtils>
{
  private Fb4aUtilsModule$PhonebookUtilsProvider(Fb4aUtilsModule paramFb4aUtilsModule)
  {
  }

  public PhonebookUtils a()
  {
    return new PhonebookUtils(Fb4aUtilsModule.a(this.a).getContentResolver());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.Fb4aUtilsModule.PhonebookUtilsProvider
 * JD-Core Version:    0.6.0
 */