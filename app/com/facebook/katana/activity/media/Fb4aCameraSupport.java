package com.facebook.katana.activity.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.camera.support.CameraSupport;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.inject.FbInjector;

public class Fb4aCameraSupport
  implements CameraSupport
{
  public Intent a(Activity paramActivity, Uri paramUri, Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("extra_video_request_code", 2);
    AppSession localAppSession = AppSession.b(paramActivity, false);
    if ((localAppSession == null) || (paramLong == localAppSession.b().userId))
      paramLong = -1L;
    Intent localIntent = ((IFeedIntentBuilder)FbInjector.a(paramActivity).a(IFeedIntentBuilder.class)).a(paramUri, paramIntent.getExtras(), paramLong);
    localIntent.setFlags(0);
    return localIntent;
  }

  public Intent a(Context paramContext, Uri paramUri, int paramInt, boolean paramBoolean, long paramLong, Bundle paramBundle)
  {
    Intent localIntent = CameraReviewActivity.a(paramContext, paramUri, paramInt, paramBoolean, paramLong);
    if (paramBundle != null)
      localIntent.putExtra("composer_extras", paramBundle);
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraSupport
 * JD-Core Version:    0.6.0
 */