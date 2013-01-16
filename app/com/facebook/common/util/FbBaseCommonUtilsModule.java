package com.facebook.common.util;

import android.content.Context;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class FbBaseCommonUtilsModule extends AbstractModule
{
  private final Context a;

  public FbBaseCommonUtilsModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(FileUtil.class).a(new FileUtil());
    a(StatFsHelper.class).a(new FbBaseCommonUtilsModule.StatFsHelperProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbBaseCommonUtilsModule
 * JD-Core Version:    0.6.0
 */