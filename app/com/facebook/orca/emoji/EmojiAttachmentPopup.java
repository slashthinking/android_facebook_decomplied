package com.facebook.orca.emoji;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.annotations.IsAudioRecorderEnabled;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.SimpleVariableTextLayoutView;
import com.facebook.widget.viewpagerindicator.CirclePageIndicator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

public class EmojiAttachmentPopup extends DialogFragment
{
  private static final Class<?> Y = EmojiAttachmentPopup.class;
  private View Z;
  private int aA;
  private int aB;
  private EmojiSizingCalculator.Sizes aC;
  private boolean aD;
  private Handler aE;
  private LinearLayout aa;
  private EmojiAttachmentPopup.EmojiAttachmentPopupListener ab;
  private View ac;
  private Button ad;
  private FrameLayout ae;
  private FrameLayout af;
  private FrameLayout ag;
  private Button ah;
  private FrameLayout ai;
  private ViewStub aj;
  private ViewPager ak;
  private CirclePageIndicator al;
  private LinearLayout am;
  private LinearLayout an;
  private Map<FrameLayout, List<LinearLayout>> ao = Maps.a();
  private FrameLayout ap;
  private Vibrator aq;
  private Provider<Boolean> ar;
  private AnalyticsLogger as;
  private int at;
  private int au;
  private int av;
  private int aw;
  private boolean ax;
  private int ay;
  private boolean az;

  private void M()
  {
    Tracer localTracer = Tracer.a("setupDialogWindow");
    Dialog localDialog = c();
    Window localWindow = localDialog.getWindow();
    localWindow.setSoftInputMode(1);
    localWindow.addFlags(131072);
    WindowManager.LayoutParams localLayoutParams = localDialog.getWindow().getAttributes();
    localLayoutParams.x = this.at;
    localLayoutParams.y = this.au;
    localLayoutParams.width = 2147483647;
    localLayoutParams.gravity = this.ay;
    localDialog.getWindow().setAttributes(localLayoutParams);
    localDialog.requestWindowFeature(1);
    localWindow.addFlags(32);
    localWindow.addFlags(262144);
    localTracer.a();
  }

  private void N()
  {
    if (this.aj != null);
    while (true)
    {
      return;
      this.aj = ((ViewStub)a(this.Z, 2131297278));
      this.aj.inflate();
      this.ag = ((FrameLayout)a(this.Z, 2131297287));
      this.ai = ((FrameLayout)a(this.Z, 2131297285));
      this.ah = ((Button)a(this.Z, 2131297286));
      this.am = ((LinearLayout)a(this.Z, 2131297284));
      this.am.removeAllViews();
      this.am.addView(this.ag);
      this.am.addView(S());
      a(this.am, LayoutInflater.from(p()));
      this.am.addView(this.ai);
      this.ag.setOnClickListener(new EmojiAttachmentPopup.2(this));
      this.ah.setOnTouchListener(new EmojiAttachmentPopup.3(this));
    }
  }

  private View O()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.aB, -1);
    View localView = new View(p());
    localView.setLayoutParams(localLayoutParams);
    localView.setBackgroundResource(2130838549);
    return localView;
  }

  private void P()
  {
    Tracer localTracer = Tracer.a("loadAndSetEmojiAndButtonOnFront");
    if (q().getConfiguration().orientation == 2)
      Q();
    while (true)
    {
      localTracer.a();
      return;
      R();
    }
  }

  private void Q()
  {
    LinearLayout localLinearLayout = a(Emojis.b, 0, -1 + this.aC.a(), true);
    localLinearLayout.addView(this.ae);
    this.an.addView(localLinearLayout);
  }

  private void R()
  {
    int i = this.aC.a();
    LinearLayout localLinearLayout1 = a(Emojis.b, 0, i, true);
    LinearLayout localLinearLayout2 = a(Emojis.b, i, i - 2, true);
    localLinearLayout2.addView(this.af, 0);
    localLinearLayout2.addView(this.ae);
    b(this.ac);
    this.an.addView(localLinearLayout1);
    this.an.addView(localLinearLayout2);
  }

  private View S()
  {
    View localView = new View(p());
    localView.setLayoutParams(new LinearLayout.LayoutParams(q().getDimensionPixelSize(2131230820), -1));
    localView.setBackgroundDrawable(q().getDrawable(2131165403));
    return localView;
  }

  private HoneyClientEvent T()
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click");
    localHoneyClientEvent.e("emoji_attachment_popup");
    return localHoneyClientEvent;
  }

  private int a(EmojiSet paramEmojiSet)
  {
    return (int)Math.ceil(paramEmojiSet.b().size() / this.aC.c());
  }

  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramLayoutInflater, paramViewGroup, paramInt1, paramInt2, paramInt3, 0);
  }

  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Tracer localTracer = Tracer.a("generateAttachmentButton");
    View localView = paramLayoutInflater.inflate(2130903340, paramViewGroup, false);
    ((SimpleVariableTextLayoutView)a(localView, 2131297268)).setText(e(paramInt1));
    ImageButton localImageButton = (ImageButton)a(localView, 2131297267);
    localImageButton.setImageDrawable(q().getDrawable(paramInt2));
    switch (paramInt3)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      localTracer.a();
      return localView;
      localImageButton.setOnClickListener(new EmojiAttachmentPopup.7(this, paramInt4));
      continue;
      localImageButton.setOnClickListener(new EmojiAttachmentPopup.8(this));
    }
  }

  private <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }

  private FrameLayout a(EmojiSet paramEmojiSet, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    FrameLayout localFrameLayout = (FrameLayout)paramLayoutInflater.inflate(2130903343, paramViewGroup, false);
    a(localFrameLayout, 2131297290).setBackgroundResource(paramEmojiSet.a());
    return localFrameLayout;
  }

  private LinearLayout a(EmojiSet paramEmojiSet, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(p());
    localLinearLayout.setOrientation(1);
    int i = paramEmojiSet.b().size();
    int j = this.aC.a();
    int k = this.aC.b();
    int m = 0;
    int n = paramInt;
    while ((m < k) && (n < i))
    {
      localLinearLayout.addView(a(paramEmojiSet, paramInt + m * j, j, false));
      n = paramInt + j * (m + 1);
      m++;
    }
    return localLinearLayout;
  }

  private LinearLayout a(EmojiSet paramEmojiSet, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LinearLayout localLinearLayout = new LinearLayout(p());
    List localList = paramEmojiSet.b();
    int i = Math.min(localList.size(), paramInt1 + paramInt2);
    int j = this.aC.d();
    int k;
    int m;
    int n;
    label80: int i1;
    int i2;
    if (paramBoolean)
    {
      k = this.aC.f();
      m = this.aC.g();
      if (!paramBoolean)
        break label239;
      n = this.aC.k();
      i1 = this.aC.h();
      if (!paramBoolean)
        break label251;
      i2 = this.aC.l();
    }
    while (true)
    {
      if (paramInt1 >= i)
        break label263;
      ImageView localImageView = new ImageView(p());
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(j, k));
      localImageView.setPadding(m, n, i1, i2);
      localImageView.setScaleType(ImageView.ScaleType.CENTER);
      Emoji localEmoji = (Emoji)localList.get(paramInt1);
      localImageView.setImageResource(localEmoji.b());
      localImageView.setBackgroundDrawable(q().getDrawable(2130838597));
      localImageView.setOnClickListener(new EmojiAttachmentPopup.10(this, localEmoji, paramBoolean));
      localLinearLayout.addView(localImageView);
      paramInt1++;
      continue;
      k = this.aC.e();
      break;
      label239: n = this.aC.i();
      break label80;
      label251: i2 = this.aC.j();
    }
    label263: return localLinearLayout;
  }

  public static EmojiAttachmentPopup a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    EmojiAttachmentPopup localEmojiAttachmentPopup = new EmojiAttachmentPopup();
    Bundle localBundle = new Bundle();
    localBundle.putInt("x", paramInt1);
    localBundle.putInt("y", paramInt2);
    localBundle.putInt("gravity", paramInt5);
    localBundle.putInt("height", paramInt3);
    localBundle.putInt("width", paramInt4);
    localBundle.putBoolean("showArrowAbove", paramBoolean1);
    localBundle.putBoolean("canComposeAudio", paramBoolean2);
    localEmojiAttachmentPopup.f(localBundle);
    return localEmojiAttachmentPopup;
  }

  private void a(LayoutInflater paramLayoutInflater)
  {
    Tracer localTracer = Tracer.a("addAttachmentOperationItems");
    View localView1 = a(paramLayoutInflater, this.aa, 2131362483, 2130838532, 0, 1);
    View localView2 = a(paramLayoutInflater, this.aa, 2131362482, 2130838531, 0, 2);
    View localView3 = a(paramLayoutInflater, this.aa, 2131362484, 2130838534, 0, 4);
    View localView4 = O();
    View localView5 = O();
    this.aa.addView(localView1);
    this.aa.addView(localView4);
    this.aa.addView(localView2);
    this.aa.addView(localView5);
    this.aa.addView(localView3);
    if ((((Boolean)this.ar.b()).booleanValue()) && (this.az))
    {
      View localView6 = a(paramLayoutInflater, this.aa, 2131362486, 2130838533, 1);
      View localView7 = O();
      this.aa.addView(localView7);
      this.aa.addView(localView6);
    }
    localTracer.a();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.aE.removeMessages(1);
      this.aD = false;
    }
    while (true)
    {
      return;
      if (paramMotionEvent.getAction() == 0)
      {
        this.aD = true;
        Message localMessage = this.aE.obtainMessage(1);
        this.aE.sendMessageDelayed(localMessage, 400L);
        i(true);
        continue;
      }
    }
  }

  private void a(FrameLayout paramFrameLayout, EmojiSet paramEmojiSet)
  {
    List localList = b(paramEmojiSet);
    this.ao.put(paramFrameLayout, localList);
  }

  private void a(LinearLayout paramLinearLayout, LayoutInflater paramLayoutInflater)
  {
    Tracer localTracer = Tracer.a("loadAndSetEmojisForBackside");
    this.ak = ((ViewPager)a(this.Z, 2131297282));
    this.ak.setAdapter(new EmojiAttachmentPopup.EmojiPagerAdapter(this));
    this.al = ((CirclePageIndicator)a(this.Z, 2131297283));
    this.al.setViewPager(this.ak);
    ArrayList localArrayList = Lists.a();
    int i = Emojis.a.size();
    for (int j = 0; j < i; j++)
    {
      EmojiSet localEmojiSet = (EmojiSet)Emojis.a.get(j);
      FrameLayout localFrameLayout = a(localEmojiSet, paramLinearLayout, paramLayoutInflater);
      localFrameLayout.setOnClickListener(new EmojiAttachmentPopup.9(this, localFrameLayout, localArrayList, localEmojiSet, j));
      paramLinearLayout.addView(localFrameLayout);
      paramLinearLayout.addView(S());
      if (j == 0)
      {
        localFrameLayout.setSelected(true);
        this.ap = localFrameLayout;
      }
      localArrayList.add(localFrameLayout);
    }
    localTracer.a();
  }

  private void a(Emoji paramEmoji, boolean paramBoolean)
  {
    if (this.ab != null)
    {
      a(Integer.toHexString(paramEmoji.c()), paramBoolean);
      this.aq.vibrate(50L);
      this.ab.a(paramEmoji);
    }
  }

  private void a(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = T();
    localHoneyClientEvent.b("action", paramString);
    this.as.a(localHoneyClientEvent);
  }

  private void a(String paramString, boolean paramBoolean)
  {
    HoneyClientEvent localHoneyClientEvent = T();
    localHoneyClientEvent.b("action", "emoji_selected");
    localHoneyClientEvent.b("emoji", paramString);
    localHoneyClientEvent.a("front_side", paramBoolean);
    this.as.a(localHoneyClientEvent);
  }

  private void a(List<LinearLayout> paramList, EmojiSet paramEmojiSet)
  {
    List localList = ((EmojiAttachmentPopup.EmojiPagerAdapter)this.ak.getAdapter()).d();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((FrameLayout)localIterator.next()).removeAllViews();
    this.ak.removeAllViews();
    localList.clear();
    int i = a(paramEmojiSet);
    for (int j = 0; j < i; j++)
      localList.add(new FrameLayout(p()));
    for (int k = 0; k < paramList.size(); k++)
      ((FrameLayout)localList.get(k)).addView((View)paramList.get(k));
    EmojiAttachmentPopup.EmojiPagerAdapter localEmojiPagerAdapter = new EmojiAttachmentPopup.EmojiPagerAdapter(this, localList, paramEmojiSet);
    this.ak.setAdapter(localEmojiPagerAdapter);
    this.ak.setCurrentItem(0);
    this.al.a();
  }

  private List<LinearLayout> b(EmojiSet paramEmojiSet)
  {
    ArrayList localArrayList = Lists.a();
    int i = Math.min(a(paramEmojiSet), 2);
    for (int j = 0; j < i; j++)
      localArrayList.add(a(paramEmojiSet, f(j)));
    return localArrayList;
  }

  private void b(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.width + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    if (this.aC.d() > i)
      localLayoutParams.rightMargin = (this.aC.d() - i + localLayoutParams.rightMargin);
  }

  private int f(int paramInt)
  {
    return paramInt * this.aC.c();
  }

  private void g(int paramInt)
  {
    if (this.ab != null)
      this.ab.a(paramInt);
  }

  private boolean i(boolean paramBoolean)
  {
    j(paramBoolean);
    return this.aD;
  }

  private void j(boolean paramBoolean)
  {
    if (this.ab != null)
    {
      if (paramBoolean)
        this.aq.vibrate(50L);
      this.ab.b();
    }
  }

  public boolean L()
  {
    return this.ax;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Tracer.b(3L);
    Tracer localTracer1 = Tracer.a("EmojiAttachmentPopup onCreateView");
    this.aq = ((Vibrator)p().getSystemService("vibrator"));
    if ((p() instanceof Activity))
      M();
    Tracer localTracer2 = Tracer.a("layoutInflation");
    this.Z = paramLayoutInflater.inflate(2130903341, paramViewGroup, false);
    localTracer2.a();
    this.ac = a(this.Z, 2131297277);
    this.af = ((FrameLayout)a(this.Z, 2131297276));
    this.ad = ((Button)a(this.Z, 2131297275));
    this.ae = ((FrameLayout)a(this.Z, 2131297274));
    this.an = ((LinearLayout)a(this.Z, 2131297273));
    this.aa = ((LinearLayout)a(this.Z, 2131297272));
    FrameLayout localFrameLayout = (FrameLayout)a(this.Z, 2131297270);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.width = this.aw;
    localLayoutParams.height = (this.av - this.aA);
    localFrameLayout.setLayoutParams(localLayoutParams);
    if (this.ax)
      this.Z.findViewById(2131297269).setVisibility(0);
    while (true)
    {
      a(paramLayoutInflater);
      this.ac.setOnClickListener(new EmojiAttachmentPopup.4(this));
      this.ad.setOnTouchListener(new EmojiAttachmentPopup.5(this));
      this.an.removeAllViews();
      P();
      localTracer1.a();
      Tracer.a(Y);
      return this.Z;
      this.Z.findViewById(2131297280).setVisibility(0);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.at = m().getInt("x");
    this.au = m().getInt("y");
    this.ay = m().getInt("gravity");
    this.av = m().getInt("height");
    this.aw = m().getInt("width");
    this.ax = m().getBoolean("showArrowAbove");
    this.az = m().getBoolean("canComposeAudio");
    Resources localResources = q();
    this.aA = SizeUtil.a(localResources, 8.0F);
    this.aB = SizeUtil.a(localResources, 2.0F);
    this.aC = new EmojiSizingCalculator(localResources).a(this.aw, this.av - localResources.getDimensionPixelSize(2131230898) - this.aA, this.ax);
    FbInjector localFbInjector = FbInjector.a(p());
    this.ar = localFbInjector.b(Boolean.class, IsAudioRecorderEnabled.class);
    this.as = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.aE = new EmojiAttachmentPopup.1(this);
  }

  public void a(EmojiAttachmentPopup.EmojiAttachmentPopupListener paramEmojiAttachmentPopupListener)
  {
    this.ab = paramEmojiAttachmentPopupListener;
  }

  public Dialog c(Bundle paramBundle)
  {
    return new EmojiAttachmentPopup.6(this, p(), d());
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.ab != null)
      this.ab.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup
 * JD-Core Version:    0.6.0
 */