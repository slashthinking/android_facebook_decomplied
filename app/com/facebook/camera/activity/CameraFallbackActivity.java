package com.facebook.camera.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.activity.FbFragmentActivity;

public class CameraFallbackActivity extends FbFragmentActivity
  implements View.OnClickListener
{
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903082);
    findViewById(2131296438).setOnClickListener(this);
    findViewById(2131296439).setOnClickListener(this);
    findViewById(2131296440).setOnClickListener(this);
    findViewById(2131296441).setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    int i = -1;
    int j = paramView.getId();
    if (j == 2131296438)
      i = 4;
    while (true)
    {
      setResult(i);
      finish();
      return;
      if (j == 2131296440)
      {
        i = 2;
        continue;
      }
      if (j == 2131296441)
      {
        i = 1;
        continue;
      }
      if (j != 2131296439)
        continue;
      i = 3;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraFallbackActivity
 * JD-Core Version:    0.6.0
 */