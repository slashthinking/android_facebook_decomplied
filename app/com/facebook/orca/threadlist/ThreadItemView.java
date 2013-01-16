package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.orca.annotations.IsThreadlistOnlineAndMobilePresenceEnabled;
import com.facebook.orca.annotations.IsThreadlistOnlinePresenceEnabled;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadDisplayCache.ThreadSnippet;
import com.facebook.orca.common.ui.widgets.text.MultilineEllipsizeTextView;
import com.facebook.orca.common.ui.widgets.text.ThreadNameView;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.ThreadTileView;
import com.facebook.orca.presence.Availability;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Provider;

public class ThreadItemView extends CustomViewGroup
{
  private static final Class<?> a = ThreadItemView.class;
  private static final Pattern b = Pattern.compile("\\n+");
  private DataCache c;
  private ThreadDisplayCache d;
  private ThreadDateUtil e;
  private ThreadParticipantUtils f;
  private EmojiUtil g;
  private ThreadNameView h;
  private ImageView i;
  private ThreadTileView j;
  private MultilineEllipsizeTextView k;
  private TextView l;
  private ImageView m;
  private ThreadSummary n;
  private ThreadListAdapter.Mode o;
  private Provider<Boolean> p;
  private Provider<Boolean> q;
  private CanonicalThreadPresenceHelper r;
  private CanonicalThreadPresenceHelper.Listener s;
  private PresenceState t = PresenceState.a;

  public ThreadItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ThreadItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ThreadItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private static String a(ThreadSummary paramThreadSummary)
  {
    if (paramThreadSummary != null);
    for (String str = paramThreadSummary.a(); ; str = "<null>")
      return str;
  }

  private void a(Context paramContext)
  {
    FbInjector localFbInjector = getInjector();
    this.c = ((DataCache)localFbInjector.a(DataCache.class));
    this.d = ((ThreadDisplayCache)localFbInjector.a(ThreadDisplayCache.class));
    this.e = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.f = ((ThreadParticipantUtils)localFbInjector.a(ThreadParticipantUtils.class));
    this.g = ((EmojiUtil)localFbInjector.a(EmojiUtil.class));
    setContentView(2130903408);
    this.h = ((ThreadNameView)getView(2131297465));
    this.i = ((ImageView)getView(2131297466));
    this.j = ((ThreadTileView)getView(2131297462));
    this.k = ((MultilineEllipsizeTextView)getView(2131297467));
    this.l = ((TextView)getView(2131297464));
    this.m = ((ImageView)getView(2131297468));
    this.p = localFbInjector.b(Boolean.class, IsThreadlistOnlinePresenceEnabled.class);
    this.q = localFbInjector.b(Boolean.class, IsThreadlistOnlineAndMobilePresenceEnabled.class);
    this.r = ((CanonicalThreadPresenceHelper)localFbInjector.a(CanonicalThreadPresenceHelper.class));
    this.s = new ThreadItemView.1(this);
    this.r.a(this.s);
  }

  private void a(PresenceState paramPresenceState)
  {
    if (this.t == paramPresenceState);
    while (true)
    {
      return;
      b(paramPresenceState);
    }
  }

  private void a(PresenceState paramPresenceState, boolean paramBoolean)
  {
    if (paramPresenceState.a() == Availability.AVAILABLE)
    {
      this.i.setImageResource(2130838694);
      this.i.setVisibility(0);
    }
    while (true)
    {
      return;
      if ((paramPresenceState.b()) && (paramBoolean))
      {
        this.i.setImageResource(2130838668);
        this.i.setVisibility(0);
        continue;
      }
      this.i.setVisibility(8);
    }
  }

  private void a(boolean paramBoolean)
  {
    int i1 = 17170445;
    if (this.o == ThreadListAdapter.Mode.NORMAL)
    {
      if (paramBoolean)
        i1 = 2130838739;
      setBackgroundResource(i1);
    }
    while (true)
    {
      return;
      setBackgroundResource(i1);
    }
  }

  private void b()
  {
    this.h.setData(this.n);
    b(this.n);
    this.j.setThreadSummary(this.n);
    this.k.setText(c(this.n));
    this.l.setText(this.e.a(this.n.k()));
    boolean bool;
    if (this.c.a(this.n.a()) < this.n.b())
    {
      bool = true;
      a(bool);
      if (!this.n.w())
        break label122;
      this.m.setVisibility(0);
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label122: this.m.setVisibility(8);
    }
  }

  private void b(PresenceState paramPresenceState)
  {
    if ((!((Boolean)this.p.b()).booleanValue()) && (!((Boolean)this.q.b()).booleanValue()));
    while (true)
    {
      return;
      this.t = paramPresenceState;
      a(this.t, ((Boolean)this.q.b()).booleanValue());
    }
  }

  private void b(ThreadSummary paramThreadSummary)
  {
    this.r.a(paramThreadSummary);
    b(this.r.c());
  }

  private CharSequence c(ThreadSummary paramThreadSummary)
  {
    Object localObject = paramThreadSummary.n();
    if (!StringUtil.a((String)localObject))
      return localObject;
    String str1 = paramThreadSummary.m();
    ParticipantInfo localParticipantInfo1 = paramThreadSummary.o();
    ThreadDisplayCache.ThreadSnippet localThreadSnippet = this.d.b(paramThreadSummary.a());
    String str5;
    ParticipantInfo localParticipantInfo2;
    if ((localThreadSnippet != null) && (localThreadSnippet.c() >= paramThreadSummary.k()))
    {
      str5 = localThreadSnippet.a();
      localParticipantInfo2 = localThreadSnippet.b();
    }
    for (String str2 = str5; ; str2 = str1)
    {
      if ((str2 == null) || (localParticipantInfo2 == null))
      {
        localObject = "";
        break;
      }
      Matcher localMatcher = b.matcher(str2);
      if (localMatcher.find());
      for (String str3 = localMatcher.replaceAll(" "); ; str3 = str2)
      {
        Resources localResources = getContext().getResources();
        StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(getResources());
        Drawable localDrawable1;
        Drawable localDrawable2;
        if (Objects.equal(localParticipantInfo2.e(), this.c.b()))
        {
          localDrawable1 = localResources.getDrawable(2130838729);
          if (paramThreadSummary.g())
          {
            ThreadParticipant localThreadParticipant2 = this.f.b(paramThreadSummary);
            if ((localThreadParticipant2 == null) || (paramThreadSummary.k() >= localThreadParticipant2.i()))
              break label497;
            localDrawable2 = localResources.getDrawable(2130838633);
            localDrawable2.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
            localStyledStringBuilder.a(new ImageSpan(localDrawable2), 33);
            localStyledStringBuilder.a(" ");
            localStyledStringBuilder.a();
            localStyledStringBuilder.a(" ");
            localStyledStringBuilder.a(str3);
            label280: localObject = localStyledStringBuilder.b();
            int i1 = SizeUtil.b(getContext(), 12.0F);
            this.g.a((Spannable)localObject, i1);
            break;
          }
          Iterator localIterator = paramThreadSummary.i().iterator();
          ThreadParticipant localThreadParticipant1;
          do
          {
            if (!localIterator.hasNext())
              break;
            localThreadParticipant1 = (ThreadParticipant)localIterator.next();
          }
          while ((Objects.equal(this.c.b(), localThreadParticipant1.d())) || (paramThreadSummary.k() < localThreadParticipant1.i()));
        }
        for (int i2 = 0; ; i2 = 1)
        {
          if (i2 != 0)
          {
            localDrawable2 = localResources.getDrawable(2130838633);
            break;
            if (this.d.c(paramThreadSummary) == 2)
            {
              localStyledStringBuilder.a(str3);
              break label280;
            }
            if (paramThreadSummary.e())
            {
              String str4 = this.c.b(localParticipantInfo2);
              if (str4 != null)
              {
                localStyledStringBuilder.a(str4 + ": " + str3);
                break label280;
              }
              localStyledStringBuilder.a(str3);
              break label280;
            }
            localStyledStringBuilder.a(str3);
            break label280;
          }
          label497: localDrawable2 = localDrawable1;
          break;
        }
      }
      localParticipantInfo2 = localParticipantInfo1;
    }
  }

  void a()
  {
    if (this.o == ThreadListAdapter.Mode.NORMAL)
      if (this.c.a(this.n.a()) >= this.n.b())
        break label43;
    label43: for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  void a(ThreadSummary paramThreadSummary, ThreadListAdapter.Mode paramMode)
  {
    if ((paramThreadSummary != this.n) || (paramMode != this.o))
    {
      Class localClass = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = a(this.n);
      arrayOfObject[1] = a(paramThreadSummary);
      BLog.a(localClass, "addThreadToThreadList (%s to %s)", arrayOfObject);
      this.n = paramThreadSummary;
      this.o = paramMode;
      b();
    }
    while (true)
    {
      return;
      a();
    }
  }

  String getThreadId()
  {
    if (this.n != null);
    for (String str = this.n.a(); ; str = null)
      return str;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r.a(true);
    b(this.r.c());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r.a(false);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.n != null);
    for (String str = this.n.a(); ; str = "<none>")
    {
      Tracer localTracer = Tracer.a("ThreadItemView.onLayout (" + str + ")");
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      localTracer.a();
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.n != null);
    for (String str = this.n.a(); ; str = "<none>")
    {
      Tracer localTracer = Tracer.a("ThreadItemView.onMeasure (" + str + ")");
      super.onMeasure(paramInt1, paramInt2);
      localTracer.a();
      return;
    }
  }

  public void setThreadDivider(Drawable paramDrawable, int paramInt)
  {
    View localView = getView(2131297469);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localView.setLayoutParams(localLayoutParams);
    localView.setBackgroundDrawable(paramDrawable);
  }

  public void setThreadIconSize(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.j.setTileSizePx(paramInt);
    this.j.setLayoutParams(localLayoutParams);
  }

  public void setTimeTextColor(int paramInt)
  {
    this.l.setTextColor(paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadItemView
 * JD-Core Version:    0.6.0
 */