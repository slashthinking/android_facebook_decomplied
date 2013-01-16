package com.facebook.orca.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threadlist.ThreadChooserDialog;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.threadview.ThreadViewUtil;

public class ShareLauncherActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private ThreadChooserDialog n;
  private ThreadViewUtil o;

  private String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("android.intent.extra.TEXT");
  }

  private void a(String paramString)
  {
    Intent localIntent1 = getIntent();
    String str = a(localIntent1);
    Uri localUri = (Uri)localIntent1.getParcelableExtra("android.intent.extra.STREAM");
    Intent localIntent2;
    if (paramString == ThreadChooserDialog.a)
      localIntent2 = new Intent(this, CreateThreadActivity.class);
    while (true)
    {
      localIntent2.putExtra("show_composer", true);
      if (str != null)
        localIntent2.putExtra("composer_initial_text", str);
      if (localUri != null)
        localIntent2.putExtra("composer_photo_uri", localUri);
      startActivity(localIntent2);
      finish();
      return;
      if (paramString == null)
      {
        localIntent2 = new Intent(this, ThreadListActivity.class);
        continue;
      }
      localIntent2 = new Intent(this, ThreadViewActivity.class);
      localIntent2.putExtra("thread_id", paramString);
    }
  }

  public String a()
  {
    return "share_launcher";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903398);
    FbTitleBarUtil.a(this);
    FbInjector localFbInjector = C();
    this.n = ((ThreadChooserDialog)localFbInjector.a(ThreadChooserDialog.class));
    this.o = ((ThreadViewUtil)localFbInjector.a(ThreadViewUtil.class));
    this.n.a(getString(2131362690));
    this.n.b(getString(2131362691));
    this.n.a(new ShareLauncherActivity.1(this));
    this.n.show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.intents.ShareLauncherActivity
 * JD-Core Version:    0.6.0
 */