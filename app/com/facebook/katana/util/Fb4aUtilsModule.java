package com.facebook.katana.util;

import android.content.Context;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.FbBaseCommonUtilsModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class Fb4aUtilsModule extends AbstractModule
{
  private final Context a;

  public Fb4aUtilsModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    e(FbBaseCommonUtilsModule.class);
    a(PhonebookUtils.class).a(new Fb4aUtilsModule.PhonebookUtilsProvider(this, null));
    a(Storage.class).a(new Fb4aUtilsModule.StorageProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.Fb4aUtilsModule
 * JD-Core Version:    0.6.0
 */