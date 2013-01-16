package com.facebook.orca.threadview;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.widget.CustomViewGroup;
import java.util.Date;

public class GlobalAlertMessageView extends CustomViewGroup
{
  private NotificationSettingsUtil a;
  private MessagingIntentUris b;
  private NotificationSetting c;
  private TextView d;
  private View e;

  public GlobalAlertMessageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public GlobalAlertMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public GlobalAlertMessageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.a = ((NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class));
    this.b = ((MessagingIntentUris)localFbInjector.a(MessagingIntentUris.class));
    setContentView(2130903347);
    this.d = ((TextView)getView(2131297296));
    this.d.setOnClickListener(new GlobalAlertMessageView.1(this));
  }

  private void b()
  {
    Context localContext = getContext();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
    localBuilder.setTitle(localContext.getString(2131362493));
    if (this.a.b(this.c))
      localBuilder.setMessage(localContext.getString(2131362495));
    while (true)
    {
      localBuilder.setNeutralButton(localContext.getString(2131362497), new GlobalAlertMessageView.2(this, localContext));
      localBuilder.setNegativeButton(2131362168, null);
      localBuilder.create().show();
      return;
      localBuilder.setMessage(localContext.getString(2131362496));
    }
  }

  public void a()
  {
    int i = 1;
    this.c = this.a.a();
    Context localContext = getContext();
    if (!this.c.a())
      this.d.setText(localContext.getString(2131362491));
    while (true)
    {
      if (this.e != null)
      {
        if (i == 0)
          break label144;
        setVisibility(0);
        this.e.setVisibility(8);
      }
      while (true)
      {
        return;
        if (!this.a.b(this.c))
          break label161;
        Date localDate = new Date(1000L * this.c.b());
        String str1 = android.text.format.DateFormat.getTimeFormat(localContext).format(localDate);
        Object[] arrayOfObject = new Object[i];
        arrayOfObject[0] = str1;
        String str2 = localContext.getString(2131362492, arrayOfObject);
        this.d.setText(str2);
        break;
        label144: setVisibility(8);
        this.e.setVisibility(0);
      }
      label161: i = 0;
    }
  }

  public void setHideableView(View paramView)
  {
    this.e = paramView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.GlobalAlertMessageView
 * JD-Core Version:    0.6.0
 */