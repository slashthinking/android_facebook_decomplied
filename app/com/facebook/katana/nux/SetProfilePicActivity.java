package com.facebook.katana.nux;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.orca.inject.FbInjector;

public class SetProfilePicActivity extends BaseFacebookActivity
{
  private static final String n = SetProfilePicActivity.class.getSimpleName();
  private String o;
  private ImageView p;
  private Button q;
  private AppSession r;
  private FbErrorReporter s;

  private void j()
  {
    this.q.setText(getString(2131363126));
    this.q.setOnClickListener(new SetProfilePicActivity.1(this));
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    String str = getIntent().getStringExtra("image_uri");
    if (str == null)
    {
      setResult(1001);
      finish();
    }
    while (true)
    {
      return;
      setContentView(2130903547);
      this.s = ((FbErrorReporter)FbInjector.a(this).a(FbErrorReporter.class));
      this.r = AppSession.a(this, true);
      this.p = ((ImageView)findViewById(2131297829));
      this.q = ((Button)findViewById(2131297830));
      j();
      new SetProfilePicActivity.LoadProfilePicture(this, null).execute(new String[] { str });
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.r = AppSession.b(this, true);
    if (this.r == null)
    {
      this.s.a(n, "invalid session info");
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.SetProfilePicActivity
 * JD-Core Version:    0.6.0
 */