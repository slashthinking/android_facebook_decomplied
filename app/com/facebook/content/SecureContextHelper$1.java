package com.facebook.content;

import android.app.Activity;
import android.content.Intent;

class SecureContextHelper$1 extends SecureContextHelper.ActivityWrapper
{
  Activity a()
  {
    return this.a;
  }

  void a(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.SecureContextHelper.1
 * JD-Core Version:    0.6.0
 */