package com.facebook.katana.provider;

import com.facebook.katana.annotations.KeyValueManagerBackend;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;

public class FbAndroidKeyValueModule extends AbstractModule
{
  protected void a()
  {
    a(KeyValueManager.class).a(new FbAndroidKeyValueModule.KeyValueManagerProvider(this, null));
    a(KeyValueStore.class).a(KeyValueManagerBackend.class).a(new FbAndroidKeyValueModule.DefaultKeyValueStoreProvider(this, null));
    a(LegacyKeyValueStore.class).a(KeyValueManagerBackend.class).a(new FbAndroidKeyValueModule.DefaultLegacyKeyValueStoreProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FbAndroidKeyValueModule
 * JD-Core Version:    0.6.0
 */