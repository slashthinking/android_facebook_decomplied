package com.ooqqxx.stat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PopWindow extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    if (!getIntent().hasExtra("dialog_mode"))
    {
      if (!getIntent().hasExtra("fullscreen_mode"))
        break label47;
      super.setTheme(16973834);
    }
    while (true)
    {
      super.onCreate(paramBundle);
      if (!NativeCall.onActivityCreate(this))
        finish();
      return;
      label47: super.setTheme(16973833);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.stat.PopWindow
 * JD-Core Version:    0.6.0
 */