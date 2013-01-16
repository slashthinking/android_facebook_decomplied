package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.NotificationBuilder;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.service.method.AudienceSettings;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;

public class FacewebFragment$FacewebAppSessionListener extends AppSessionListener
{
  private final String b = FacewebAppSessionListener.class.getSimpleName();

  protected FacewebFragment$FacewebAppSessionListener(FacewebFragment paramFacewebFragment)
  {
  }

  private void a()
  {
    Context localContext = this.a.n().getApplicationContext();
    Bundle localBundle = new Bundle();
    Intent localIntent = this.a.P().t().a(null, localBundle, FacewebFragment.i(this.a));
    NotificationBuilder localNotificationBuilder = new NotificationBuilder(localContext).a(System.currentTimeMillis()).a(localContext.getString(2131363196)).c(localContext.getString(2131363197)).b(localContext.getString(2131363198)).a(17301642);
    NotificationsLogger.NotificationLogObject localNotificationLogObject = new NotificationsLogger.NotificationLogObject();
    SystemTrayNotificationManager.a(localContext, localNotificationLogObject.c(), localNotificationBuilder, localIntent, localNotificationLogObject);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2, FacebookPhoto paramFacebookPhoto, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((FacewebFragment.b(this.a) != null) && (paramBoolean))
      FacewebFragment.b(this.a).c();
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, AudienceSettings paramAudienceSettings)
  {
    FacewebFragment.a(this.a, paramAudienceSettings);
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    FacewebFragment.b(this.a).b();
  }

  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramString1.equals(FacewebFragment.q(this.a)))
    {
      this.a.h(2);
      FacewebFragment.d(this.a, null);
      if (paramInt != 200)
        break label59;
      if (FacewebFragment.b(this.a) != null)
        FacewebFragment.b(this.a).c();
    }
    while (true)
    {
      return;
      label59: String str = StringUtils.a(this.a.n(), this.a.e(2131363289), paramInt, paramString2, paramException);
      Toaster.a(this.a.n(), str);
    }
  }

  public void e(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    this.a.h(2);
    if (paramInt == 200)
    {
      Log.d("StatusComposerListener", "Status successfully posted");
      if (FacewebFragment.d(this.a) != null)
        FacewebFragment.d(this.a).i(this.a.n());
      if (FacewebFragment.b(this.a) != null)
        FacewebFragment.b(this.a).c();
      return;
    }
    Object localObject1 = this.a.e(2131363206);
    Object localObject2;
    if (paramException != null)
    {
      if (!(paramException instanceof FacebookApiException))
        break label146;
      int i = ((FacebookApiException)paramException).a();
      localObject2 = FacewebFragment.r(this.a).a(i);
      if (localObject2 == null)
        break label228;
    }
    while (true)
    {
      localObject1 = localObject2;
      while (true)
      {
        Toaster.a(this.a.n(), (CharSequence)localObject1);
        a();
        break;
        label146: if (FacewebFragment.a(this.a, paramException))
          continue;
        ErrorReporting.a(this.b + "_stream_publish_failed", "Unknown error when publishing: " + paramException.getClass().getName() + ", Message: " + paramException.getMessage(), paramException, true);
      }
      label228: localObject2 = localObject1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.FacewebAppSessionListener
 * JD-Core Version:    0.6.0
 */