package com.facebook.device_id;

import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.login.AuthComponent;

public class DeviceIdModule extends AbstractModule
{
  protected void a()
  {
    a(UniqueIdForDeviceHolder.class).a(new DeviceIdModule.UniqueIdForDeviceInitializerProvider(this, null)).a();
    a(DeviceIdReceiver.class).a(new DeviceIdModule.DeviceIdReceiverProvider(this, null));
    a(UniqueDeviceIdBroadcastSender.class).a(new DeviceIdModule.UniqueDeviceIdBroadcastSenderProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(UniqueIdForDeviceHolder.class);
    c(AuthComponent.class).a(UniqueDeviceIdBroadcastSender.class);
    c(DeviceIdChangedCallback.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.DeviceIdModule
 * JD-Core Version:    0.6.0
 */