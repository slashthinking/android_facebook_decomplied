package com.facebook.katana.orca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.katana.IntentUriHandler;

public class ThreadListLauncherActivity extends FragmentActivity
{
  private void i()
  {
    Intent localIntent = IntentUriHandler.a(getApplicationContext(), "fb://messaging");
    localIntent.setFlags(67108864);
    localIntent.putExtra("activity_launcher", "MessengerLauncher");
    startActivity(localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    i();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ThreadListLauncherActivity
 * JD-Core Version:    0.6.0
 */