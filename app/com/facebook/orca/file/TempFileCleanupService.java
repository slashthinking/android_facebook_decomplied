package com.facebook.orca.file;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.orca.inject.FbInjector;

public class TempFileCleanupService extends IntentService
{
  public TempFileCleanupService()
  {
    super("Orca:TempFileCleanupService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    ((TempFileManager)FbInjector.a(this).a(TempFileManager.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.file.TempFileCleanupService
 * JD-Core Version:    0.6.0
 */