package com.facebook.katana.orca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.intents.CanonicalThreadHandler;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;

public class CanonicalThreadLauncherActivity extends Activity
{
  private void a()
  {
    String str = getIntent().getStringExtra("user_id");
    Intent localIntent = new Intent(this, CanonicalThreadHandler.class);
    if (str != null)
      localIntent.putExtra("user_key", new UserKey(User.Type.FACEBOOK, str).toString());
    startActivity(localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.CanonicalThreadLauncherActivity
 * JD-Core Version:    0.6.0
 */