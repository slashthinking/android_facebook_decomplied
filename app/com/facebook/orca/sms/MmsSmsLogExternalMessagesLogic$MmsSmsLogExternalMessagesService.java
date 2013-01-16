package com.facebook.orca.sms;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

public class MmsSmsLogExternalMessagesLogic$MmsSmsLogExternalMessagesService extends IntentService
{
  public MmsSmsLogExternalMessagesLogic$MmsSmsLogExternalMessagesService()
  {
    super("MmsSmsLogExternalMessagesService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    MmsSmsLogExternalMessagesLogic localMmsSmsLogExternalMessagesLogic = (MmsSmsLogExternalMessagesLogic)localFbInjector.a(MmsSmsLogExternalMessagesLogic.class);
    if (localMmsSmsLogExternalMessagesLogic.a())
    {
      MmsSmsLogger localMmsSmsLogger = (MmsSmsLogger)localFbInjector.a(MmsSmsLogger.class);
      MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalCounts localMmsSmsLogExternalCounts = localMmsSmsLogExternalMessagesLogic.b();
      localMmsSmsLogger.a(localMmsSmsLogExternalCounts.b);
      localMmsSmsLogger.b(localMmsSmsLogExternalCounts.a);
      localMmsSmsLogger.c(localMmsSmsLogExternalCounts.d);
      localMmsSmsLogger.d(localMmsSmsLogExternalCounts.c);
      localMmsSmsLogger.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalMessagesService
 * JD-Core Version:    0.6.0
 */