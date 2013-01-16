package com.facebook.camera.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public abstract interface CameraSupport
{
  public abstract Intent a(Activity paramActivity, Uri paramUri, Intent paramIntent, long paramLong);

  public abstract Intent a(Context paramContext, Uri paramUri, int paramInt, boolean paramBoolean, long paramLong, Bundle paramBundle);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.support.CameraSupport
 * JD-Core Version:    0.6.0
 */