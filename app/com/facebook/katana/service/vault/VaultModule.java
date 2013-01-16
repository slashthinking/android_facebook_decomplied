package com.facebook.katana.service.vault;

import android.app.Application;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.katana.service.vault.methods.VaultDevicePostMethod;
import com.facebook.katana.service.vault.methods.VaultDeviceUpdateMethod;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusMethod;
import com.facebook.katana.service.vault.methods.VaultImageDeleteMethod;
import com.facebook.katana.service.vault.methods.VaultImageGetMethod;
import com.facebook.katana.service.vault.methods.VaultImageUploadMethod;
import com.facebook.katana.service.vault.methods.VaultQuotaGetMethod;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class VaultModule extends AbstractModule
{
  private final Application a;

  public VaultModule(Application paramApplication)
  {
    this.a = paramApplication;
  }

  protected void a()
  {
    a(VaultManager.class).a(new VaultModule.VaultManagerProvider(this, null)).a();
    a(VaultNewImageUploader.class).a(new VaultModule.VaultNewImageUploaderProvider(this, null));
    a(VaultLocalImageFetcher.class).a(new VaultModule.VaultLocalImageFetcherProvider(this, null));
    a(VaultDeviceSetup.class).a(new VaultModule.VaultDeviceSetupProvider(this, null));
    a(VaultTable.class).a(new VaultModule.VaultTableProvider(this, null)).a();
    a(VaultSyncJobGenerator.class).a(new VaultModule.VaultSyncJobGeneratorProvider(this, null));
    a(VaultNotificationManager.class).a(new VaultModule.VaultNotificationManagerProvider(this, null)).a();
    a(VaultQuotaGetMethod.class).a(new VaultModule.VaultQuotaGetMethodProvider(this, null));
    a(VaultConstants.class).a(new VaultModule.VaultConstantsProvider(this, null));
    a(VaultImageUploadMethod.class).a(new VaultModule.VaultImageUploadMethodProvider(this, null));
    a(VaultDevicePostMethod.class).a(new VaultModule.VaultDevicePostMethodProvider(this, null));
    a(VaultDeviceUpdateMethod.class).a(new VaultModule.VaultDeviceUpdateMethodProvider(this, null));
    a(VaultGetSyncedImageStatusMethod.class).a(new VaultModule.VaultGetSyncedImageStatusMethodProvider(this, null));
    a(VaultImageDeleteMethod.class).a(new VaultModule.VaultImageDeleteMethodProvider(this, null));
    a(VaultImageGetMethod.class).a(new VaultModule.VaultImageGetMethodProvider(this, null));
    a(VaultRowStatusUpdater.class).a(new VaultModule.VaultRowStatusUpdaterProvider(this, null));
    a(VaultImageStatusFetcher.class).a(new VaultModule.VaultImageStatusFetcherProvider(this, null));
    a(FbErrorReporter.class).a(new VaultModule.FbErrorReporterProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule
 * JD-Core Version:    0.6.0
 */