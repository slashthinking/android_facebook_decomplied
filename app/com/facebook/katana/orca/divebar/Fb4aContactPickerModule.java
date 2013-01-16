package com.facebook.katana.orca.divebar;

import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class Fb4aContactPickerModule extends AbstractModule
{
  protected void a()
  {
    a(ForceMessengerDivebarViewListener.class).a(new Fb4aContactPickerModule.ForceMessengerDivebarViewListenerProvider(this, null));
    c(DivebarViewListener.class).a(ForceMessengerDivebarViewListener.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.divebar.Fb4aContactPickerModule
 * JD-Core Version:    0.6.0
 */