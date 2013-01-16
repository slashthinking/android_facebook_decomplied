package com.facebook.katana.activity.events;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.Log;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.Toaster;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.places.SelectAtTagActivity;
import com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.service.method.GraphEventCreate;
import com.facebook.katana.service.method.GraphEventCreate.PrivacyType;
import com.facebook.katana.service.method.GraphEventInvite;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.Calendar;

public class EventCreationActivity extends BaseFacebookActivity
{
  private static final Class<?> n = EventCreationActivity.class;
  private TextView A;
  private EventCreationActivity.State B = EventCreationActivity.State.NONE;
  private DialogFragment C;
  private String D;
  private String E;
  private boolean F = true;
  private FacebookPlace G = null;
  private String H = null;
  private Calendar I = null;
  private Calendar J = null;
  private GraphEventCreate.PrivacyType K = GraphEventCreate.PrivacyType.FRIENDS;
  private long[] L;
  private boolean M = false;
  private AppSession N;
  private AppSessionListener O = new EventCreationActivity.1(this);
  private DialogInterface.OnClickListener P = new EventCreationActivity.2(this);
  private DialogInterface.OnClickListener Q = new EventCreationActivity.3(this);
  private View.OnClickListener R = new EventCreationActivity.4(this);
  private View.OnClickListener S = new EventCreationActivity.5(this);
  private View.OnClickListener T = new EventCreationActivity.6(this);
  private TextView o;
  private TextView p;
  private TextView q;
  private EditText r;
  private EditText s;
  private EditText t;
  private LinearLayout u;
  private EditText v;
  private EditText x;
  private TextView y;
  private TextView z;

  private void a(int paramInt1, int paramInt2)
  {
    this.I.set(11, paramInt1);
    this.I.set(12, paramInt2);
    a(this.t, this.I, TimeFormatUtil.TimeFormatStyle.HOUR_MINUTE_STYLE);
  }

  private void a(long paramLong)
  {
    this.E = GraphEventInvite.a(this, paramLong, this.L);
    if (this.E == null)
    {
      o();
      Toaster.a(this, 2131362919);
    }
  }

  private void a(View paramView)
  {
    EventCreationActivity.DatePickerFragment localDatePickerFragment = new EventCreationActivity.DatePickerFragment(this, null);
    if (paramView.getId() == 2131296649)
      localDatePickerFragment.a(g(), "datepicker_start");
    while (true)
    {
      return;
      localDatePickerFragment.a(g(), "datepicker_end");
    }
  }

  private void a(View paramView, Calendar paramCalendar, TimeFormatUtil.TimeFormatStyle paramTimeFormatStyle)
  {
    this.M = true;
    String str = DefaultTimeFormatUtil.a(this, paramTimeFormatStyle, paramCalendar.getTimeInMillis());
    paramView.setVisibility(0);
    ((EditText)paramView).setText(str);
  }

  private void a(TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, paramInt2, 0);
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (this.J == null)
    {
      m();
      a(this.v, this.J, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE);
    }
    this.J.set(11, paramInt1);
    this.J.set(12, paramInt2);
    a(this.x, this.J, TimeFormatUtil.TimeFormatStyle.HOUR_MINUTE_STYLE);
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.I.set(paramInt1, paramInt2, paramInt3);
    a(this.s, this.I, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE);
  }

  private void b(long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    IntentUriHandler.b(this, StringLocaleUtil.a("fb://event/%s", arrayOfObject));
    finish();
  }

  private void b(View paramView)
  {
    EventCreationActivity.TimePickerFragment localTimePickerFragment = new EventCreationActivity.TimePickerFragment(this, null);
    if (paramView.getId() == 2131296650)
      localTimePickerFragment.a(g(), "timepicker_start");
    while (true)
    {
      return;
      localTimePickerFragment.a(g(), "timepicker_end");
    }
  }

  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.J == null)
    {
      m();
      a(this.x, this.J, TimeFormatUtil.TimeFormatStyle.HOUR_MINUTE_STYLE);
    }
    this.J.set(paramInt1, paramInt2, paramInt3);
    a(this.v, this.J, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE);
  }

  private void j()
  {
    this.r.setBackgroundResource(17301508);
    this.s.setBackgroundResource(17301508);
    this.t.setBackgroundResource(17301508);
    this.v.setBackgroundResource(17301508);
    this.x.setBackgroundResource(17301508);
    this.A.setBackgroundResource(17301508);
    this.z.setBackgroundResource(17301508);
  }

  private void k()
  {
    Intent localIntent = new Intent(this, SelectAtTagActivity.class);
    localIntent.putExtra("launched_for_place", true);
    if (this.G != null)
      localIntent.putExtra("extra_place", this.G);
    while (true)
    {
      localIntent.putExtra("search_type", SelectAtTagFetcher.SearchType.EVENT);
      startActivityForResult(localIntent, 1);
      return;
      if (this.H == null)
        continue;
      localIntent.putExtra("extra_location_text", this.H);
    }
  }

  private void l()
  {
    m();
    a(this.v, this.J, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE);
    a(this.x, this.J, TimeFormatUtil.TimeFormatStyle.HOUR_MINUTE_STYLE);
  }

  private void m()
  {
    this.J = ((Calendar)this.I.clone());
    this.J.setTimeInMillis(10800000L + this.J.getTimeInMillis());
  }

  private void n()
  {
    Intent localIntent = new Intent(this, FriendMultiSelectorActivity.class);
    if (this.L == null)
      localIntent.putExtra("profiles", new long[0]);
    while (true)
    {
      startActivityForResult(localIntent, 2);
      return;
      localIntent.putExtra("profiles", this.L);
    }
  }

  private void o()
  {
    Assert.a(EventCreationActivity.State.PROCESSING, this.B);
    this.B = EventCreationActivity.State.NONE;
    this.C.a();
  }

  private void p()
  {
    Assert.a(EventCreationActivity.State.NONE, this.B);
    this.B = EventCreationActivity.State.PROCESSING;
    this.C = ProgressDialogFragment.a(2131362850, true, false);
    this.C.a(g(), null);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903132);
    this.N = AppSession.b(this, true);
    this.o = ((TextView)findViewById(2131296686));
    this.p = ((TextView)findViewById(2131296646));
    this.q = ((TextView)findViewById(2131296647));
    this.z = ((TextView)findViewById(2131296655));
    this.z.setOnClickListener(new EventCreationActivity.7(this));
    this.r = ((EditText)findViewById(2131296648));
    this.r.setOnClickListener(this.T);
    this.s = ((EditText)findViewById(2131296649));
    this.s.setOnClickListener(this.R);
    this.t = ((EditText)findViewById(2131296650));
    this.t.setOnClickListener(this.S);
    this.v = ((EditText)findViewById(2131296652));
    this.v.setOnClickListener(this.R);
    this.x = ((EditText)findViewById(2131296653));
    this.x.setOnClickListener(this.S);
    this.u = ((LinearLayout)findViewById(2131296651));
    this.A = ((TextView)findViewById(2131296654));
    this.A.setOnClickListener(new EventCreationActivity.8(this));
    this.o.setText(2131363236);
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
    this.I = Calendar.getInstance();
    String str = DefaultTimeFormatUtil.a(this, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, this.I.getTimeInMillis());
    this.s.setText(str);
    a(this.z, 0, 2130838157, getString(2131363056));
    TextView localTextView = this.A;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    localTextView.setText(getString(2131362927, arrayOfObject));
    this.y = ((TextView)findViewById(2131296620));
    this.y.setText(getString(2131362931).toUpperCase());
    if (Build.VERSION.SDK_INT < 14)
      j();
  }

  public void i()
  {
    AlertDialogs.MenuOption[] arrayOfMenuOption = new AlertDialogs.MenuOption[3];
    arrayOfMenuOption[0] = new EventCreationActivity.EventPrivacyMenuOption(this, 2130838156, 2131363053, GraphEventCreate.PrivacyType.PUBLIC);
    arrayOfMenuOption[1] = new EventCreationActivity.EventPrivacyMenuOption(this, 2130838157, 2131363056, GraphEventCreate.PrivacyType.FRIENDS);
    arrayOfMenuOption[2] = new EventCreationActivity.EventPrivacyMenuOption(this, 2130838158, 2131363057, GraphEventCreate.PrivacyType.INVITE_ONLY);
    AlertDialog localAlertDialog = AlertDialogs.a(this, 2131362931, arrayOfMenuOption, false);
    localAlertDialog.setCanceledOnTouchOutside(true);
    localAlertDialog.show();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1);
    do
      while (true)
      {
        return;
        getWindow().setSoftInputMode(3);
        switch (paramInt1)
        {
        default:
          break;
        case 1:
          if (paramIntent.getBooleanExtra("extra_xed_location", false))
          {
            this.G = null;
            this.H = null;
            a(this.r, 0, 2130837715, "");
            continue;
          }
          if (paramIntent.hasExtra("extra_place"))
          {
            Assert.a(paramIntent.hasExtra("extra_location_text"));
            this.H = null;
            this.G = ((FacebookPlace)paramIntent.getParcelableExtra("extra_place"));
            a(this.r, 0, 2130838160, this.G.mName);
            continue;
          }
          if (!paramIntent.hasExtra("extra_location_text"))
            continue;
          Assert.a(paramIntent.hasExtra("extra_place"));
          this.G = null;
          this.H = paramIntent.getStringExtra("extra_location_text");
          a(this.r, 0, 2130837716, this.H);
        case 2:
        }
      }
    while (!paramIntent.hasExtra("profiles"));
    this.L = paramIntent.getLongArrayExtra("profiles");
    if ((this.L != null) && (this.L.length > 0));
    for (int i = this.L.length; ; i = 0)
    {
      TextView localTextView = this.A;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      a(localTextView, 0, 0, getString(2131362927, arrayOfObject));
      break;
    }
  }

  public void onBackPressed()
  {
    int i;
    if ((StringUtils.c(this.p.getText().toString())) && (StringUtils.c(this.q.getText().toString())) && ((this.L == null) || (this.L.length == 0)) && (!this.M))
    {
      i = 1;
      if (i == 0)
        break label70;
      super.onBackPressed();
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label70: EventCreationActivity.9 local9 = new EventCreationActivity.9(this);
      EventCreationActivity.10 local10 = new EventCreationActivity.10(this);
      AlertDialogs.a(this, getString(2131362920), 0, getString(2131362921), getString(2131362922), local10, getString(2131362923), local9, null, false).show();
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.N.b(this.O);
  }

  protected void onResume()
  {
    super.onResume();
    this.N = AppSession.b(this, true);
    if (this.N == null)
    {
      Log.a(n, "Invalid session");
      finish();
    }
    while (true)
    {
      return;
      this.N.a(this.O);
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (this.B == EventCreationActivity.State.PROCESSING);
    while (true)
    {
      return;
      String str1 = this.p.getText().toString();
      if (StringUtils.c(str1))
      {
        Toaster.a(this, 2131362930);
        continue;
      }
      String str2 = this.q.getText().toString();
      long l;
      if (this.G == null)
        l = -1L;
      while (true)
      {
        this.D = GraphEventCreate.a(this, str1, str2, l, this.H, this.F, this.I, this.J, this.K);
        if (this.D != null)
          break label122;
        Toaster.a(this, 2131362919);
        break;
        l = this.G.mPageId;
      }
      label122: p();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity
 * JD-Core Version:    0.6.0
 */