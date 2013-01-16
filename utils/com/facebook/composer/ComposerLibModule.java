package com.facebook.composer;

import android.content.Context;
import com.facebook.composer.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.protocol.ComposerMethodsQueue;
import com.facebook.composer.protocol.LinksPreviewMethod;
import com.facebook.composer.protocol.PostRecommendationMethod;
import com.facebook.composer.protocol.PublishCheckinMethod;
import com.facebook.composer.protocol.PublishLocationMethod;
import com.facebook.composer.protocol.PublishPostMethod;
import com.facebook.composer.protocol.PublishShareMethod;
import com.facebook.composer.protocol.SimplePhotoUploadMethod;
import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.composer.server.ComposerServiceHandler;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerService;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class ComposerLibModule extends AbstractModule
{
  private final Context a;

  public ComposerLibModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<? extends OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(PublishPostMethod.class).a(new ComposerLibModule.PublishPostMethodProvider(this, null));
    a(PublishCheckinMethod.class).a(new ComposerLibModule.PublishCheckinMethodProvider(this, null));
    a(PublishLocationMethod.class).a(new ComposerLibModule.PublishLocationMethodProvider(this, null));
    a(PublishShareMethod.class).a(new ComposerLibModule.PublishShareMethodProvider(this, null));
    a(SimplePhotoUploadMethod.class).a(new ComposerLibModule.PagePhotoUploadMethodProvider(this, null));
    a(LinksPreviewMethod.class).a(new ComposerLibModule.LinksPreviewMethodProvider(this, null));
    a(PostRecommendationMethod.class).a(new ComposerLibModule.PostRecommendationMethodProvider(this, null));
    a(ComposerPublishService.class).a(new ComposerLibModule.ComposerPublishServiceProvider(this, null));
    a(ComposerActivityBroadcaster.class).a(new ComposerLibModule.ComposerActivityBroadcasterProvider(this, null)).a();
    a(ComposerPublishServiceHandler.class).a(new ComposerLibModule.ComposerPublishServiceHandlerProvider(this, null));
    a(ComposerServiceHandler.class).a(new ComposerLibModule.ComposerServiceHandlerProvider(this, null));
    a(ComposerMethodsQueue.class, new ComposerLibModule.ComposerServiceHandlerProvider(this, null));
  }

  public void a(FbInjector paramFbInjector)
  {
    super.a(paramFbInjector);
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(ComposerMethodsQueue.class, ComposerService.class);
    localOrcaServiceRegistry.a("links_preview", ComposerMethodsQueue.class);
    localOrcaServiceRegistry.a("post_recommendation", ComposerMethodsQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ComposerLibModule
 * JD-Core Version:    0.6.2
 */