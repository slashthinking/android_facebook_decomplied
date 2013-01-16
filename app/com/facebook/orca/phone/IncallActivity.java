package com.facebook.orca.phone;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.IsIncallOutgoingEnabled;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import javax.inject.Provider;

public class IncallActivity extends FbFragmentActivity
{
  private static final Class<?> n = IncallActivity.class;
  private Button A;
  private Button B;
  private Button C;
  private ImageButton D;
  private ImageButton E;
  private Provider<Boolean> o;
  private AudioManager p;
  private TelephonyManager q;
  private TelephonyServiceBridge r;
  private BroadcastReceiver s;
  private IncallActivity.ContactLookupListener t;
  private View u;
  private View v;
  private UrlImage w;
  private ImageView x;
  private TextView y;
  private TextView z;

  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      this.w.setPlaceHolderDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }

  private void a(Uri paramUri)
  {
    this.w.setImageParams(paramUri);
  }

  private void a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
      this.y.setText(paramString2);
    while (true)
    {
      return;
      this.y.setText(paramString1);
    }
  }

  private void j()
  {
    if (this.q.getCallState() == 1)
    {
      this.v.setVisibility(8);
      this.u.setVisibility(0);
    }
    while (true)
    {
      return;
      this.u.setVisibility(8);
      this.v.setVisibility(0);
      k();
    }
  }

  private void k()
  {
    int i = 2130838705;
    int j;
    if (this.p.isSpeakerphoneOn())
    {
      j = i;
      this.D.setBackgroundResource(j);
      if (!this.p.isMicrophoneMute())
        break label48;
    }
    while (true)
    {
      this.E.setBackgroundResource(i);
      return;
      j = 17170445;
      break;
      label48: i = 17170445;
    }
  }

  private void l()
  {
    this.A.setEnabled(false);
    this.B.setEnabled(false);
  }

  private void m()
  {
    String str = getIntent().getStringExtra("android.intent.extra.PHONE_NUMBER");
    this.y.setText(str);
    if (str != null)
      new Thread(new ContactLookupTask(this, str, this.t)).start();
  }

  private void n()
  {
    try
    {
      this.r.a(this);
      l();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.e(n, "Error answering call", localException);
        finish();
      }
    }
  }

  private void o()
  {
    try
    {
      this.r.a();
      l();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.e(n, "Error ignoring call", localException);
        finish();
      }
    }
  }

  private void p()
  {
    try
    {
      this.r.a();
      l();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.e(n, "Error ending call", localException);
        finish();
      }
    }
  }

  private void q()
  {
    if (!this.p.isSpeakerphoneOn());
    for (boolean bool = true; ; bool = false)
    {
      this.p.setSpeakerphoneOn(bool);
      k();
      return;
    }
  }

  private void r()
  {
    if (!this.p.isMicrophoneMute());
    for (boolean bool = true; ; bool = false)
    {
      this.p.setMicrophoneMute(bool);
      k();
      return;
    }
  }

  public void a(Bundle paramBundle)
  {
    requestWindowFeature(1);
    getWindow().setType(2006);
    getWindow().addFlags(524288);
    this.o = FbInjector.a(this).b(Boolean.class, IsIncallOutgoingEnabled.class);
    this.p = ((AudioManager)getSystemService("audio"));
    this.q = ((TelephonyManager)getSystemService("phone"));
    this.s = new IncallActivity.IncallBroadcastReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    registerReceiver(this.s, localIntentFilter);
    try
    {
      this.r = new TelephonyServiceBridge(this.q);
      this.t = new IncallActivity.ContactLookupListener(this, null);
      setContentView(2130903388);
      this.u = f(2131297390);
      this.v = f(2131297393);
      this.w = ((UrlImage)f(2131297385));
      this.x = ((ImageView)f(2131297388));
      this.y = ((TextView)f(2131297387));
      this.z = ((TextView)f(2131297389));
      this.A = ((Button)f(2131297391));
      this.B = ((Button)f(2131297392));
      this.C = ((Button)f(2131297396));
      this.D = ((ImageButton)f(2131297394));
      this.E = ((ImageButton)f(2131297395));
      this.A.setOnClickListener(new IncallActivity.1(this));
      this.B.setOnClickListener(new IncallActivity.2(this));
      this.C.setOnClickListener(new IncallActivity.3(this));
      this.D.setOnClickListener(new IncallActivity.4(this));
      this.E.setOnClickListener(new IncallActivity.5(this));
      j();
      m();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.e(n, "Couldn't get reference to telephony service", localException);
        finish();
      }
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.s);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.IncallActivity
 * JD-Core Version:    0.6.0
 */