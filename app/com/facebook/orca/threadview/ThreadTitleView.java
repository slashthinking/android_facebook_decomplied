package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.ThreadNameView;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.CustomViewGroup;

public class ThreadTitleView extends CustomViewGroup
{
  private final CanonicalThreadPresenceHelper a;
  private final ThreadParticipantUtils b;
  private final OrcaPhoneNumberUtil c;
  private final ThreadNameView d;
  private final TextView e;
  private final ProgressBar f;
  private PresenceState g = PresenceState.a;
  private ThreadSummary h;
  private CanonicalThreadPresenceHelper.Listener i;

  public ThreadTitleView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ThreadTitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.a = ((CanonicalThreadPresenceHelper)localFbInjector.a(CanonicalThreadPresenceHelper.class));
    this.b = ((ThreadParticipantUtils)localFbInjector.a(ThreadParticipantUtils.class));
    this.c = ((OrcaPhoneNumberUtil)localFbInjector.a(OrcaPhoneNumberUtil.class));
    setContentView(2130903413);
    this.d = ((ThreadNameView)getView(2131297479));
    this.e = ((TextView)getView(2131297481));
    this.f = ((ProgressBar)getView(2131297480));
    this.i = new ThreadTitleView.1(this);
    this.a.a(this.i);
  }

  private void a()
  {
    if (this.a.b())
    {
      b(true);
      b(this.a.c());
      b();
    }
    while (true)
    {
      return;
      if ((this.h != null) && (MessagingIdUtil.g(this.h.a())))
      {
        b(true);
        b();
        continue;
      }
      b(false);
    }
  }

  private void a(PresenceState paramPresenceState)
  {
    if (this.g == paramPresenceState);
    while (true)
    {
      return;
      b(paramPresenceState);
    }
  }

  private void b()
  {
    if (this.e != null)
      c();
  }

  private void b(PresenceState paramPresenceState)
  {
    this.g = paramPresenceState;
    b();
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
      this.d.setMaxLines(1);
    for (this.d.getLayoutParams().height = -2; ; this.d.getLayoutParams().height = -1)
    {
      if (this.e != null)
        this.e.setVisibility(8);
      return;
      this.d.setMaxLines(2);
    }
  }

  private void c()
  {
    String str;
    if ((this.h != null) && (MessagingIdUtil.g(this.h.a())))
    {
      ThreadParticipant localThreadParticipant = this.b.b(this.h);
      if (localThreadParticipant == null)
        break label115;
      str = this.c.c(localThreadParticipant.d().b());
      if (localThreadParticipant.f().equals(str))
        break label115;
    }
    while (true)
    {
      if (str != null)
      {
        this.e.setVisibility(0);
        this.e.setText(str);
      }
      while (true)
      {
        return;
        str = this.a.d();
        break;
        this.e.setVisibility(8);
        this.e.setText("");
      }
      label115: str = null;
    }
  }

  public void a(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this.f;
    if (paramBoolean);
    for (int j = 0; ; j = 8)
    {
      localProgressBar.setVisibility(j);
      return;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.a(true);
    a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.a(false);
    b(false);
  }

  public void setThreadSummary(ThreadSummary paramThreadSummary)
  {
    this.h = paramThreadSummary;
    this.d.setData(paramThreadSummary);
    this.a.a(paramThreadSummary);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadTitleView
 * JD-Core Version:    0.6.0
 */