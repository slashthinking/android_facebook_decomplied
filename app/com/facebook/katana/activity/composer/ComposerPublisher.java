package com.facebook.katana.activity.composer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.GraphFeedPublish;
import com.facebook.katana.service.method.GraphFeedPublish.ImplicitLocation;
import com.facebook.katana.service.method.GraphFeedPublishException;
import com.facebook.orca.inject.FbInjector;

public class ComposerPublisher
{
  public static ComposerPublisherResult a(Context paramContext, ComposerParameters paramComposerParameters, AppSession paramAppSession)
  {
    ComposerPublisherResult localComposerPublisherResult1 = new ComposerPublisherResult();
    if (paramComposerParameters.i());
    while (true)
    {
      ComposerPublisherResult localComposerPublisherResult2;
      try
      {
        localComposerPublisherResult1.a(paramAppSession.a(paramContext, paramComposerParameters.g(), paramComposerParameters.f(), paramComposerParameters.a(), paramComposerParameters.b(), paramComposerParameters.c()));
        localComposerPublisherResult2 = localComposerPublisherResult1;
        return localComposerPublisherResult2;
      }
      catch (Exception localException)
      {
        Toaster.a(paramContext, 2131363289);
        localComposerPublisherResult2 = null;
        continue;
      }
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("extra_composer_setting", 0).edit();
      localEditor.putString("extra_last_status_update", paramComposerParameters.a());
      localEditor.commit();
      try
      {
        GraphFeedPublish.ImplicitLocation localImplicitLocation = GraphFeedPublish.ImplicitLocation.UNKNOWN;
        if (paramComposerParameters.h());
        String str;
        for (localImplicitLocation = GraphFeedPublish.ImplicitLocation.DISABLED; ; localImplicitLocation = GraphFeedPublish.ImplicitLocation.ENABLED)
          do
          {
            str = GraphFeedPublish.a(paramContext, paramComposerParameters.e(), paramComposerParameters.a(), paramComposerParameters.d(), paramComposerParameters.b(), paramComposerParameters.c(), localImplicitLocation, paramComposerParameters.k());
            if (str != null)
              break label191;
            Toaster.a(paramContext, 2131363206);
            localComposerPublisherResult2 = null;
            break;
          }
          while ((paramComposerParameters.d() == null) || (paramComposerParameters.d().length() <= 0));
        label191: localComposerPublisherResult1.b(str);
        localComposerPublisherResult2 = localComposerPublisherResult1;
      }
      catch (GraphFeedPublishException localGraphFeedPublishException)
      {
        ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("ComposerPublisher", "Cannot publish post", localGraphFeedPublishException);
        Toaster.a(paramContext, 2131363206);
        if (BuildConstants.a())
          throw localGraphFeedPublishException;
        localComposerPublisherResult2 = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerPublisher
 * JD-Core Version:    0.6.0
 */