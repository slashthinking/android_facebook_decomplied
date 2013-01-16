package com.facebook.content;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class ContentModule extends AbstractModule
{
  protected void a()
  {
    a(SecureContextHelper.class).a(new ContentModule.SecureContextHelperProvider(this, null));
    a(SecureContextHelperUtil.class).a(new ContentModule.SecureContextHelperUtilProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.ContentModule
 * JD-Core Version:    0.6.0
 */