package com.facebook.orca.module;

import android.content.Context;
import com.facebook.analytics.AnalyticsModule;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.common.util.ExecutorWithProgressDialog;
import com.facebook.common.util.TimeFormatUtil;
import com.facebook.debug.UiThreadWatchdog;
import com.facebook.diagnostics.FPSController;
import com.facebook.diagnostics.FPSController.ActivityListener;
import com.facebook.diagnostics.FpsEnableFlag;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.images.ImageModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.widget.MapImage.MapUriBuilder;
import com.google.inject.Key;
import java.util.EnumSet;

public class UiModule extends AbstractModule
{
  private final Context a;

  public UiModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    e(AnalyticsModule.class);
    a(new ImageModule(this.a));
    a(GraphicSizerFactory.class).a(new UiModule.GraphicSizerFactoryProvider(this, null));
    a(TimeFormatUtil.class).a(new UiModule.TimeFormatUtilProvider(this, null)).a();
    a(MapImage.MapUriBuilder.class).a(new UiModule.MapUriBuilder(this, null));
    a(FPSController.class).a(new UiModule.FPSControllerProvider(this, null)).a();
    a(FPSController.ActivityListener.class).a(new UiModule.FPSControllerActivityListenerProvider(this, null));
    b(Key.a(new UiModule.1(this))).a(EnumSet.noneOf(FpsEnableFlag.class));
    a(ExecutorWithProgressDialog.class).a(new UiModule.ExecutorWithProgressDialogProvider(this, null));
    c(FbActivityListener.class).a(FPSController.ActivityListener.class);
    a(DiskUsageUtil.class).a(new UiModule.DiskUsageUtilProvider(this, null)).a();
    a(UiThreadWatchdog.class).a(new UiModule.UiThreadCheckerProvider(this, null)).a();
    c(FbActivityListener.class).a(FPSController.ActivityListener.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class).a(UiThreadWatchdog.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule
 * JD-Core Version:    0.6.2
 */