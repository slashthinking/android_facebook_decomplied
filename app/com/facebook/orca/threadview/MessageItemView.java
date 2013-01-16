package com.facebook.orca.threadview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.Spanned;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.orca.annotations.IsAudioPlayerEnabled;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.AudioAttachmentData;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.common.ui.widgets.text.UrlSpanLinkHook;
import com.facebook.orca.common.util.RectUtil;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.mutators.ResendMessageActivity;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.share.Share;
import com.facebook.orca.share.ShareRenderingLogic;
import com.facebook.orca.share.ShareView;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.widget.BetterTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Objects;
import javax.inject.Provider;

public class MessageItemView extends CustomLinearLayout
{
  private MessageListAdapter A;
  private boolean B;
  private DataCache a;
  private MessageRenderingUtil b;
  private ThreadDateUtil c;
  private ShareRenderingLogic d;
  private AttachmentDataFactory e;
  private Provider<Boolean> f;
  private FrameLayout g;
  private LinearLayout h;
  private BetterTextView i;
  private TextView j;
  private UserTileView k;
  private ShareView l;
  private ViewStub m;
  private ViewStub n;
  private ViewStub o;
  private ViewStub p;
  private ThreadViewImageAttachmentView q;
  private ThreadViewAudioAttachmentView r;
  private ThreadViewOtherAttachmentsView s;
  private ImageButton t;
  private ReceiptItemView u;
  private LinearLayout v;
  private TextView w;
  private View x;
  private RowMessageItem y;
  private Message z;

  public MessageItemView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.B = paramBoolean;
    setOrientation(1);
    FbInjector localFbInjector = getInjector();
    this.a = ((DataCache)localFbInjector.a(DataCache.class));
    this.b = ((MessageRenderingUtil)localFbInjector.a(MessageRenderingUtil.class));
    this.c = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.d = ((ShareRenderingLogic)localFbInjector.a(ShareRenderingLogic.class));
    this.e = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    this.f = localFbInjector.b(Boolean.class, IsAudioPlayerEnabled.class);
    if (this.B);
    for (int i1 = 2130903374; ; i1 = 2130903366)
    {
      setContentView(i1);
      this.g = ((FrameLayout)b(2131297179));
      this.h = ((LinearLayout)b(2131297344));
      this.i = ((BetterTextView)b(2131297345));
      this.k = ((UserTileView)b(2131297343));
      this.r = ((ThreadViewAudioAttachmentView)b(2131297346));
      this.j = ((TextView)b(2131297342));
      this.i.a(new UrlSpanLinkHook(this.i));
      int i2 = SizeUtil.a(getContext(), 6.0F);
      setPadding(0, i2, 0, i2);
      setClickable(true);
      return;
    }
  }

  public MessageItemView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }

  private void a()
  {
    int i1;
    label94: label110: label243: boolean bool;
    label317: label347: label494: FrameLayout.LayoutParams localLayoutParams;
    if (m())
    {
      this.i.setVisibility(0);
      Spanned localSpanned = this.b.a(this.z);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(localSpanned);
      Linkify.addLinks(localSpannable, 15);
      this.i.setText(localSpannable);
      this.h.setOnClickListener(new MessageItemView.1(this));
      if (!this.B)
        break label683;
      if (!MessagingIdUtil.g(this.z.b()))
        break label675;
      i1 = 2130838580;
      this.h.setBackgroundDrawable(getResources().getDrawable(i1));
      if (this.x != null)
        this.x.setVisibility(8);
      if (!((Boolean)this.f.b()).booleanValue())
        break label800;
      if ((!this.e.c(this.z)) && (!this.e.d(this.z)))
        break label781;
      AudioAttachmentData localAudioAttachmentData = this.e.e(this.z);
      c();
      if (this.o != null)
      {
        this.r = ((ThreadViewAudioAttachmentView)this.o.inflate());
        this.r.setForMeUser(this.B);
        this.o = null;
      }
      this.r.setVisibility(0);
      this.r.setAudioAttachmentData(localAudioAttachmentData);
      Share localShare = this.d.a(this.z);
      if (localShare == null)
        break label819;
      d();
      if (this.m != null)
      {
        this.l = ((ShareView)this.m.inflate());
        this.m = null;
      }
      this.l.getLayoutParams().width = -2;
      this.l.setVisibility(0);
      this.l.setShare(localShare);
      if (!((Boolean)this.f.b()).booleanValue())
        break label838;
      bool = this.e.h(this.z);
      if (!Boolean.valueOf(bool).booleanValue())
        break label853;
      e();
      if (this.p != null)
      {
        this.s = ((ThreadViewOtherAttachmentsView)this.p.inflate());
        this.p = null;
      }
      this.s.setVisibility(0);
      this.s.setMessage(this.z);
      label406: if (!this.e.a(this.z))
        break label872;
      f();
      if (this.n != null)
      {
        this.q = ((ThreadViewImageAttachmentView)this.n.inflate());
        this.n = null;
      }
      this.q.setVisibility(0);
      this.q.setMessage(this.z);
      label469: if (this.z.r() != 901)
        break label891;
      g();
      this.t.setVisibility(0);
      if (this.y.d() == null)
        break label940;
      h();
      this.u.setRowReceiptItem(this.y.d());
      this.u.setVisibility(0);
      localLayoutParams = (FrameLayout.LayoutParams)this.u.getLayoutParams();
      if (!Objects.equal(this.a.b(), this.z.f().e()))
        break label910;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = SizeUtil.a(getContext(), 6.0F);
      localLayoutParams.gravity = 5;
      label591: if (!this.y.c())
        break label983;
      i();
      if ((!this.z.d()) || (this.z.e() >= this.z.c()))
        break label959;
      this.w.setText(this.c.c(this.z.e()));
      label654: this.v.setVisibility(0);
    }
    while (true)
    {
      return;
      this.i.setVisibility(8);
      break;
      label675: i1 = 2130838577;
      break label94;
      label683: this.k.setParams(UserTileViewParams.a(this.z.f().e()));
      this.k.setVisibility(0);
      ThreadSummary localThreadSummary = this.a.b(this.z.b());
      if ((localThreadSummary == null) || (localThreadSummary.g()))
      {
        this.j.setVisibility(8);
        break label110;
      }
      this.j.setVisibility(0);
      this.j.setText(this.a.a(this.z.f()));
      break label110;
      label781: if (this.r == null)
        break label243;
      this.r.setVisibility(8);
      break label243;
      label800: if (this.r == null)
        break label243;
      this.r.setVisibility(8);
      break label243;
      label819: if (this.l == null)
        break label317;
      this.l.setVisibility(8);
      break label317;
      label838: bool = this.e.f(this.z);
      break label347;
      label853: if (this.s == null)
        break label406;
      this.s.setVisibility(8);
      break label406;
      label872: if (this.q == null)
        break label469;
      this.q.setVisibility(8);
      break label469;
      label891: if (this.t == null)
        break label494;
      this.t.setVisibility(8);
      break label494;
      label910: localLayoutParams.leftMargin = SizeUtil.a(getContext(), 50.5F);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.gravity = 3;
      break label591;
      label940: if (this.u == null)
        break label591;
      this.u.setVisibility(8);
      break label591;
      label959: this.w.setText(this.c.c(this.z.c()));
      break label654;
      label983: if (this.v == null)
        continue;
      this.v.setVisibility(8);
    }
  }

  private void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramInt == 0)
      if ((!a(paramViewStub, this.p, this.s)) && (!a(paramViewStub, this.n, this.q)))
        this.h.addView(paramViewStub);
    while (true)
    {
      return;
      if (paramInt == 1)
      {
        if (a(paramViewStub, this.n, this.q))
          continue;
        this.h.addView(paramViewStub);
        continue;
      }
      if (paramInt != 2)
        continue;
      this.h.addView(paramViewStub);
    }
  }

  private boolean a(ViewStub paramViewStub1, ViewStub paramViewStub2, View paramView)
  {
    if ((paramViewStub2 != null) || (paramView != null))
    {
      LinearLayout localLinearLayout = this.h;
      if (paramViewStub2 != null)
      {
        int i1 = localLinearLayout.indexOfChild(paramViewStub2);
        this.h.addView(paramViewStub1, i1);
      }
    }
    for (int i2 = 1; ; i2 = 0)
    {
      return i2;
      paramViewStub2 = paramView;
      break;
    }
  }

  private void b()
  {
    Intent localIntent = new Intent(getContext(), ResendMessageActivity.class);
    localIntent.putExtra("message", this.z);
    getContext().startActivity(localIntent);
  }

  private void c()
  {
    j();
    if ((this.o != null) || (this.r != null))
      return;
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    if (this.B);
    for (int i1 = 2130903368; ; i1 = 2130903367)
    {
      this.o = ((ViewStub)localLayoutInflater.inflate(i1, this.g, false));
      this.g.addView(this.o);
      this.h.setVisibility(8);
      break;
    }
  }

  private void d()
  {
    j();
    if ((this.m != null) || (this.l != null));
    while (true)
    {
      return;
      this.m = ((ViewStub)LayoutInflater.from(getContext()).inflate(2130903371, this.g, false));
      a(this.m, 0);
    }
  }

  private void e()
  {
    j();
    if ((this.p != null) || (this.s != null));
    while (true)
    {
      return;
      this.p = ((ViewStub)LayoutInflater.from(getContext()).inflate(2130903370, this.g, false));
      a(this.p, 1);
    }
  }

  private void f()
  {
    j();
    if ((this.n != null) || (this.q != null));
    while (true)
    {
      return;
      this.n = ((ViewStub)LayoutInflater.from(getContext()).inflate(2130903369, this.g, false));
      a(this.n, 2);
    }
  }

  private void g()
  {
    if (this.t != null);
    while (true)
    {
      return;
      this.t = ((ImageButton)LayoutInflater.from(getContext()).inflate(2130903373, this.g, false));
      this.g.addView(this.t, 0);
      this.t.setFocusable(false);
      this.t.setOnClickListener(new MessageItemView.2(this));
    }
  }

  private void h()
  {
    if (this.u != null);
    while (true)
    {
      return;
      View localView = LayoutInflater.from(getContext()).inflate(2130903372, this, false);
      addView(localView);
      this.u = ((ReceiptItemView)localView.findViewById(2131297351));
    }
  }

  private void i()
  {
    if (this.v != null);
    while (true)
    {
      return;
      this.v = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130903365, this, false));
      this.w = ((TextView)this.v.findViewById(2131297341));
      addView(this.v, 0);
    }
  }

  private void j()
  {
    if (!m());
    while (true)
    {
      return;
      if (this.x != null)
      {
        this.x.setVisibility(0);
        continue;
      }
      this.x = new View(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131230820));
      int i1 = SizeUtil.a(getContext(), 5.0F);
      localLayoutParams.setMargins(0, i1, 0, i1);
      this.x.setLayoutParams(localLayoutParams);
      this.x.setBackgroundDrawable(getResources().getDrawable(2130839053));
      int i2 = this.h.indexOfChild(this.i);
      if ((i2 >= 0) && (getChildCount() > i2 + 1))
      {
        this.h.addView(this.x, i2 + 1);
        continue;
      }
      this.h.addView(this.x);
    }
  }

  private boolean m()
  {
    if (!StringUtil.f(this.z.h()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
  }

  public RowMessageItem getRowMessageItem()
  {
    return this.y;
  }

  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.t != null) && (this.z.r() == 901))
    {
      Rect localRect = new Rect();
      RectUtil.a(this.t, this, localRect);
      int i1 = SizeUtil.a(getContext(), 15.0F);
      localRect.left -= i1;
      localRect.top -= i1;
      localRect.right = (i1 + localRect.right);
      localRect.bottom = (i1 + localRect.bottom);
      setTouchDelegate(new TouchDelegate(localRect, this.t));
    }
  }

  public void setRowMessageItem(RowMessageItem paramRowMessageItem, MessageListAdapter paramMessageListAdapter)
  {
    this.y = paramRowMessageItem;
    this.A = paramMessageListAdapter;
    this.z = this.y.b();
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.MessageItemView
 * JD-Core Version:    0.6.0
 */