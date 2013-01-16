package com.facebook.orca.fbwebrtc;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.server.FetchContactParams;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.content.SecureBroadcastReceiver;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.widget.UrlImage;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class WebrtcIncallActivity extends FbFragmentActivity
{
  private static final Class<?> n = WebrtcIncallActivity.class;
  private ImageView A;
  private TextView B;
  private TextView C;
  private Button D;
  private Button E;
  private Button F;
  private ImageButton G;
  private ImageButton H;
  private long o;
  private AudioManager p;
  private LocalBroadcastManager q;
  private BroadcastReceiver r;
  private Executor s;
  private WebrtcManager t;
  private WebrtcNotificationManager u;
  private OrcaServiceOperationFactory v;
  private ListenableFuture<OperationResult> w;
  private View x;
  private View y;
  private UrlImage z;

  private void a(FetchContactResult paramFetchContactResult)
  {
    ContactSummary localContactSummary = paramFetchContactResult.a();
    if (localContactSummary == ContactSummary.a);
    while (true)
    {
      return;
      if (localContactSummary.getName() != null)
        this.B.setText(localContactSummary.getName().getDisplayName());
      if (localContactSummary.getBigPictureUrl() != null)
      {
        this.z.setImageParams(Uri.parse(localContactSummary.getBigPictureUrl()));
        continue;
      }
      if (localContactSummary.getSmallPictureUrl() == null)
        continue;
      this.z.setImageParams(Uri.parse(localContactSummary.getSmallPictureUrl()));
    }
  }

  private void a(DataFreshnessParam paramDataFreshnessParam)
  {
    if (this.w != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchContactParams", new FetchContactParams(paramDataFreshnessParam, new UserKey(User.Type.FACEBOOK, Long.toString(this.o))));
      this.w = this.v.a("fetch_contact", localBundle).d();
      Futures.a(this.w, new WebrtcIncallActivity.6(this), this.s);
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    FetchContactResult localFetchContactResult = (FetchContactResult)paramOperationResult.h();
    BLog.b(n, "Fetched contact successfully, result: %s", new Object[] { localFetchContactResult });
    a(localFetchContactResult);
    if ((localFetchContactResult.e() == DataFreshnessResult.FROM_SERVER) || (localFetchContactResult.e() == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) || (localFetchContactResult.e() == DataFreshnessResult.FROM_CACHE_INCOMPLETE))
      BLog.b(n, "Contact fetched from server or cache, done.");
    while (true)
    {
      return;
      BLog.c(n, "Checking server for contact data...");
      a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
    }
  }

  private void j()
  {
    if (this.t.a() == 1)
    {
      this.y.setVisibility(8);
      this.x.setVisibility(0);
    }
    while (true)
    {
      return;
      this.x.setVisibility(8);
      this.y.setVisibility(0);
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
      this.G.setBackgroundResource(j);
      if (!this.p.isMicrophoneMute())
        break label50;
    }
    while (true)
    {
      this.H.setBackgroundResource(i);
      return;
      j = 17170445;
      break;
      label50: i = 17170445;
    }
  }

  private void l()
  {
    this.D.setEnabled(false);
    this.E.setEnabled(false);
  }

  private void m()
  {
    this.t.c();
    l();
  }

  private void n()
  {
    this.t.a(IWebrtcUiInterface.EndCallReason.CallEndIgnoreCall);
    l();
    finish();
  }

  private void o()
  {
    this.t.a(IWebrtcUiInterface.EndCallReason.CallEndHangupCall);
    l();
    finish();
  }

  private void p()
  {
    if (!this.p.isSpeakerphoneOn());
    for (boolean bool = true; ; bool = false)
    {
      Class localClass = n;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(bool);
      BLog.b(localClass, "toggle speaker state to %b", arrayOfObject);
      this.p.setSpeakerphoneOn(bool);
      k();
      return;
    }
  }

  private void q()
  {
    if (!this.p.isMicrophoneMute());
    for (boolean bool = true; ; bool = false)
    {
      Class localClass = n;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(bool);
      BLog.b(localClass, "toggle microphone mute state %b", arrayOfObject);
      this.p.setMicrophoneMute(bool);
      k();
      this.t.a(bool);
      return;
    }
  }

  public void a(Bundle paramBundle)
  {
    requestWindowFeature(1);
    getWindow().setType(2006);
    getWindow().addFlags(2621440);
    FbInjector localFbInjector = FbInjector.a(this);
    this.t = ((WebrtcManager)localFbInjector.a(WebrtcManager.class));
    this.u = ((WebrtcNotificationManager)localFbInjector.a(WebrtcNotificationManager.class));
    this.v = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.p = ((AudioManager)localFbInjector.a(AudioManager.class));
    this.s = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.q = ((LocalBroadcastManager)localFbInjector.a(LocalBroadcastManager.class));
    this.r = new SecureBroadcastReceiver("com.facebook.orca.fbwebrtc.intent.action.PHONE_STATE", new WebrtcIncallActivity.PhoneStateChangedAction(this, null));
    setContentView(2130903436);
    this.x = f(2131297390);
    this.y = f(2131297393);
    this.z = ((UrlImage)f(2131297385));
    this.A = ((ImageView)f(2131297388));
    this.B = ((TextView)f(2131297387));
    this.C = ((TextView)f(2131297389));
    this.D = ((Button)f(2131297391));
    this.E = ((Button)f(2131297392));
    this.F = ((Button)f(2131297396));
    this.G = ((ImageButton)f(2131297394));
    this.H = ((ImageButton)f(2131297395));
    this.D.setOnClickListener(new WebrtcIncallActivity.1(this));
    this.E.setOnClickListener(new WebrtcIncallActivity.2(this));
    this.F.setOnClickListener(new WebrtcIncallActivity.3(this));
    this.G.setOnClickListener(new WebrtcIncallActivity.4(this));
    this.H.setOnClickListener(new WebrtcIncallActivity.5(this));
    this.t.d();
    j();
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("CONTACT_ID"))
    {
      this.o = localIntent.getLongExtra("CONTACT_ID", 0L);
      if (this.o == 0L)
      {
        Class localClass = n;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localIntent.getAction();
        BLog.d(localClass, "Invalid CONTACT_ID in intent %s", arrayOfObject);
        finish();
      }
    }
    while (true)
    {
      return;
      a(DataFreshnessParam.DO_NOT_CHECK_SERVER);
      if (!"com.facebook.orca.fbwebrtc.intent.action.CALL".equals(localIntent.getAction()))
        continue;
      if (this.o == 0L)
      {
        BLog.d(n, "Can't start call without valid contact id");
        finish();
        continue;
      }
      this.t.a(this.o);
    }
  }

  public void onStart()
  {
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.fbwebrtc.intent.action.PHONE_STATE");
    this.u.a();
    this.q.a(this.r, localIntentFilter);
  }

  public void onStop()
  {
    super.onStop();
    this.q.a(this.r);
    if ((this.t.a() == 1) || (this.t.a() == 2))
      this.u.a(this.o, this.B.getText().toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcIncallActivity
 * JD-Core Version:    0.6.0
 */