package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.orca.common.ui.widgets.text.ThreadNameView;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.presence.Availability;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.widget.CustomFrameLayout;

public class ThreadTitleHeader extends CustomFrameLayout
{
  private ImageView a;
  private ThreadNameView b;
  private CanonicalThreadPresenceHelper c;
  private PresenceState d = PresenceState.a;
  private CanonicalThreadPresenceHelper.Listener e;

  public ThreadTitleHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ThreadTitleHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ThreadTitleHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    if (this.d.a() == Availability.AVAILABLE)
    {
      this.a.setImageResource(2130838693);
      this.a.setVisibility(0);
    }
    while (true)
    {
      return;
      if (this.d.b())
      {
        this.a.setImageResource(2130838667);
        this.a.setVisibility(0);
        continue;
      }
      this.a.setVisibility(8);
    }
  }

  private void a(Context paramContext)
  {
    this.c = ((CanonicalThreadPresenceHelper)getInjector().a(CanonicalThreadPresenceHelper.class));
    setContentView(2130903414);
    this.b = ((ThreadNameView)b(2131297483));
    this.a = ((ImageView)b(2131297482));
    this.e = new ThreadTitleHeader.1(this);
    this.c.a(this.e);
  }

  private void a(PresenceState paramPresenceState)
  {
    if (this.d == paramPresenceState);
    while (true)
    {
      return;
      b(paramPresenceState);
    }
  }

  private void b(PresenceState paramPresenceState)
  {
    this.d = paramPresenceState;
    a();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c.a(true);
    b(this.c.c());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c.a(false);
  }

  public void setThreadSummary(ThreadSummary paramThreadSummary)
  {
    this.b.setData(paramThreadSummary);
    this.c.a(paramThreadSummary);
    b(this.c.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadTitleHeader
 * JD-Core Version:    0.6.0
 */