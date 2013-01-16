package com.facebook.orca.compose;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentHost;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.debug.Assert;
import com.facebook.location.GetDeviceLocationParams;
import com.facebook.location.GetDeviceLocationParamsBuilder;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.annotations.IsAudioRecorderEnabled;
import com.facebook.orca.annotations.IsEmojiAttachmentPopupEnabled;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.attachments.UnknownAttachmentTypeException;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.common.ui.widgets.AnchorableToast;
import com.facebook.orca.common.ui.widgets.AnchorableToast.ToastType;
import com.facebook.orca.common.util.IntentUtil;
import com.facebook.orca.common.util.OfflineThreadingIdGenerator;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.emoji.Emoji;
import com.facebook.orca.emoji.EmojiAttachmentPopup;
import com.facebook.orca.emoji.EmojiAttachmentPrefKeys;
import com.facebook.orca.emoji.EmojiSizingCalculator;
import com.facebook.orca.emoji.EmojiSizingCalculator.Sizes;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.emoji.IEmojiKeyboardWindowControl;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.photos.picking.PickMediaOperation;
import com.facebook.orca.photos.picking.PickMediaParams;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public class ComposeFragment extends OrcaFragment
{
  private static final Class<?> a = ComposeFragment.class;
  private static int b = 5000;
  private static final int[] ba;
  private static final int[] bb;
  private static int c = -50 + b;
  private static int d = -20 + b;
  private FragmentManager Y;
  private ThreadDisplayCache Z;
  private ComposeFragment.LocationState aA = ComposeFragment.LocationState.INIT;
  private Location aB;
  private Boolean aC;
  private ComposeFragment.OnSendClickedListener aD;
  private LocationNuxController aE;
  private ComposeMode aF;
  private OrcaAppType aG;
  private UserKey aH;
  private boolean aI;
  private int aJ;
  private long aK;
  private long aL;
  private boolean aM;
  private boolean aN;
  private Runnable aO;
  private EmojiAttachmentPopup aP;
  private IEmojiKeyboardWindowControl aQ;
  private boolean aR;
  private int aS;
  private boolean aT;
  private boolean aU;
  private boolean aV;
  private boolean aW;
  private boolean aX;
  private ComposeFragment.OnFullScreenKeyboardListener aY;
  private ComposeFragment.OnComposeModeChangeListener aZ;
  private OfflineThreadingIdGenerator aa;
  private PresenceManager ab;
  private UiCounters ac;
  private LocationManager ad;
  private LayoutInflater ae;
  private PushDeserialization af;
  private EmojiUtil ag;
  private Provider<Boolean> ah;
  private MediaAttachmentUtil ai;
  private KeyguardManager aj;
  private AnalyticsLogger ak;
  private Provider<Boolean> al;
  private View am;
  private EditText an;
  private ImageButton ao;
  private View ap;
  private Button aq;
  private TextView ar;
  private LinearLayout as;
  private HorizontalScrollView at;
  private AudioComposerView au;
  private RelativeLayout av;
  private OrcaServiceFragment aw;
  private String ax;
  private PickMediaOperation ay;
  private Map<MediaAttachment, View> az;
  private DataCache e;
  private InputMethodManager f;
  private MediaAttachmentFactory g;
  private OrcaSharedPreferences h;
  private AnchorableToast i;

  static
  {
    ba = new int[] { 16842919 };
    bb = new int[0];
  }

  private void R()
  {
    if (this.aP == null)
      return;
    if (this.aR)
    {
      if (this.aQ == null)
        break label39;
      this.aQ.a();
    }
    while (true)
    {
      j(false);
      break;
      break;
      label39: this.aP.a();
    }
  }

  private boolean S()
  {
    if ((this.aA != ComposeFragment.LocationState.NO_LOCATION) && (this.aF == ComposeMode.EXPANDED));
    for (int j = 1; ; j = 0)
      return j;
  }

  private Coordinates T()
  {
    Location localLocation1 = this.aB;
    Location localLocation2 = null;
    if (localLocation1 != null)
    {
      boolean bool = this.aU;
      localLocation2 = null;
      if (!bool)
        localLocation2 = this.aB;
    }
    return Coordinates.a(localLocation2);
  }

  private List<MediaResource> U()
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = this.az.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((MediaAttachment)localIterator.next()).a());
    return localArrayList;
  }

  private void V()
  {
    if ((!this.aI) && (this.ax != null))
    {
      this.aH = this.Z.a(this.ax);
      this.aI = true;
    }
  }

  private void W()
  {
    this.az.clear();
    this.as.removeAllViews();
    this.at.setVisibility(8);
    ak();
  }

  private void X()
  {
    boolean bool1 = ab();
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.aN;
      bool2 = false;
      if (!bool3)
        break label31;
    }
    while (true)
    {
      if (bool2)
        af();
      return;
      label31: if (this.ax == null)
      {
        bool2 = true;
        continue;
      }
      PrefKey localPrefKey = MessagesPrefKeys.b(this.ax);
      bool2 = this.h.a(localPrefKey, true);
    }
  }

  private void Y()
  {
    Assert.b(ae());
    c(false);
  }

  private void Z()
  {
    View localView = this.ae.inflate(2130903357, null);
    ((TextView)localView.findViewById(2131297315)).setText(2131362563);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(p());
    localBuilder.setTitle(2131362559);
    localBuilder.setPositiveButton(2131362340, new ComposeFragment.16(this));
    localBuilder.setNegativeButton(2131362341, null);
    AlertDialog localAlertDialog = localBuilder.create();
    localAlertDialog.setView(localView, 0, 0, 0, 0);
    localAlertDialog.show();
  }

  private Drawable a(Bitmap paramBitmap, Drawable paramDrawable)
  {
    paramDrawable.setBounds(new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()));
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    paramDrawable.draw(localCanvas);
    return new BitmapDrawable(p().getResources(), localBitmap);
  }

  private void a(int paramInt1, int paramInt2)
  {
    Editable localEditable = this.an.getText();
    int j = paramInt1;
    while (j < paramInt1 + paramInt2)
    {
      int k = Character.codePointAt(localEditable, j);
      int m = Character.charCount(k);
      this.ag.a(j, k, m, localEditable, (int)this.an.getTextSize());
      j += m;
    }
  }

  private void a(Location paramLocation)
  {
    if (this.aA != ComposeFragment.LocationState.NO_LOCATION)
      a(ComposeFragment.LocationState.HAS_LOCATION, paramLocation);
  }

  private void a(MediaAttachment paramMediaAttachment)
  {
    if (this.az.isEmpty());
    while (true)
    {
      return;
      View localView = (View)this.az.remove(paramMediaAttachment);
      if (localView != null)
        this.as.removeView(localView);
      if (this.as.getChildCount() == 0)
        this.at.setVisibility(8);
      ak();
    }
  }

  private void a(ComposeFragment.LocationState paramLocationState, Location paramLocation)
  {
    boolean bool1 = true;
    this.aA = paramLocationState;
    this.aB = paramLocation;
    LocationNuxController localLocationNuxController;
    boolean bool2;
    label52: boolean bool3;
    if (paramLocationState == ComposeFragment.LocationState.NO_LOCATION)
    {
      this.ao.setImageResource(2130838550);
      if (this.aE != null)
      {
        localLocationNuxController = this.aE;
        if (paramLocationState == ComposeFragment.LocationState.NO_LOCATION)
          break label147;
        bool2 = bool1;
        if (this.aC == null)
          break label153;
        bool3 = bool1;
        label62: if (this.aN)
          break label159;
      }
    }
    while (true)
    {
      localLocationNuxController.a(bool2, bool3, bool1);
      return;
      if (paramLocationState == ComposeFragment.LocationState.FINDING_LOCATION)
      {
        this.ao.setImageResource(2130838553);
        break;
      }
      if (paramLocationState == ComposeFragment.LocationState.HAS_LOCATION)
      {
        this.ao.setImageResource(2130838553);
        break;
      }
      if (paramLocationState != ComposeFragment.LocationState.LOCATION_ERROR)
        break;
      this.aA = ComposeFragment.LocationState.NO_LOCATION;
      this.ao.setImageResource(2130838553);
      break;
      label147: bool2 = false;
      break label52;
      label153: bool3 = false;
      break label62;
      label159: bool1 = false;
    }
  }

  private void a(Emoji paramEmoji)
  {
    this.ag.a(this.an, paramEmoji);
  }

  private void a(CharSequence paramCharSequence, AnchorableToast.ToastType paramToastType)
  {
    if (u())
      this.i.a(this.am, paramCharSequence, paramToastType);
  }

  private void a(Throwable paramThrowable)
  {
    if (this.aA != ComposeFragment.LocationState.NO_LOCATION)
      a(ComposeFragment.LocationState.LOCATION_ERROR, null);
  }

  private void a(List<MediaAttachment> paramList, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      b((MediaAttachment)localIterator.next());
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l;
    int j;
    while (true)
    {
      Editable localEditable;
      try
      {
        V();
        if ((this.aH == null) || (this.aH.a() != User.Type.FACEBOOK))
          return;
        l = System.currentTimeMillis();
        if (!paramBoolean1)
          continue;
        this.aL = l;
        localEditable = this.an.getText();
        j = 0;
        if (paramBoolean2)
          continue;
        boolean bool1 = u();
        j = 0;
        if (!bool1)
        {
          if (!this.ab.b())
            return;
          if (this.aJ != j)
            break;
          if (this.aJ != 1)
            return;
          if (l - this.aK >= 10000L)
            break;
          ai();
        }
      }
      catch (Throwable localThrowable)
      {
        BLog.d(a, "Exception sending typing notifications", localThrowable);
      }
      int k = localEditable.length();
      j = 0;
      if (k <= 0)
        continue;
      boolean bool2 = l - this.aL < 10000L;
      j = 0;
      if (!bool2)
        continue;
      j = 1;
    }
    this.aJ = j;
    this.aK = l;
    String str = this.aH.b();
    this.ab.a(str, j);
    if (this.aJ == 1)
      ai();
  }

  private void aa()
  {
    if (IntentUtil.a(p(), "android.settings.LOCATION_SOURCE_SETTINGS"))
      d("android.settings.LOCATION_SOURCE_SETTINGS");
    while (true)
    {
      return;
      if (IntentUtil.a(p(), "android.settings.SETTINGS"))
      {
        d("android.settings.SETTINGS");
        continue;
      }
      d(null);
    }
  }

  private boolean ab()
  {
    if ((ac()) && (ad()));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean ac()
  {
    return this.h.a(MessagesPrefKeys.r, true);
  }

  private boolean ad()
  {
    boolean bool = true;
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(2);
    if (this.ad.getBestProvider(localCriteria, bool) != null);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private boolean ae()
  {
    return p().getPackageManager().hasSystemFeature("android.hardware.location.gps");
  }

  private void af()
  {
    Location localLocation = this.e.e();
    if (localLocation != null)
      a(ComposeFragment.LocationState.HAS_LOCATION, localLocation);
    while (true)
    {
      if (this.aw.b() == OrcaServiceOperation.State.INIT)
      {
        GetDeviceLocationParams localGetDeviceLocationParams = GetDeviceLocationParams.newBuilder().a(100.0F).a(10000L).l();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("getDeviceLocationParams", localGetDeviceLocationParams);
        this.aw.a("get_device_location", localBundle);
      }
      return;
      a(ComposeFragment.LocationState.FINDING_LOCATION, null);
    }
  }

  private void ag()
  {
    this.aB = null;
    a(ComposeFragment.LocationState.NO_LOCATION, null);
  }

  private void ah()
  {
    al();
    aj();
    ak();
    a(true, false);
  }

  private void ai()
  {
    if (this.aM);
    while (true)
    {
      return;
      this.aO = new ComposeFragment.18(this);
      this.an.postDelayed(this.aO, 10000L);
      this.aM = true;
    }
  }

  private void aj()
  {
    if (this.an.getLayout() == null);
    while (true)
    {
      return;
      if (this.an.getLayout().getLineCount() > 1)
      {
        ((LinearLayout.LayoutParams)this.ao.getLayoutParams()).gravity = 80;
        continue;
      }
      ((LinearLayout.LayoutParams)this.ao.getLayoutParams()).gravity = 16;
    }
  }

  private void ak()
  {
    Button localButton = this.aq;
    boolean bool;
    if (!L())
    {
      bool = true;
      localButton.setEnabled(bool);
      if (!L())
        break label43;
      this.aq.setShadowLayer(1.0F, 0.0F, 1.0F, 0);
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label43: this.aq.setShadowLayer(1.0F, 0.0F, 1.0F, 2131165399);
    }
  }

  private void al()
  {
    int j = this.an.getText().length();
    if (j > c)
      if (j > d)
      {
        this.ar.setTextColor(q().getColor(2131165260));
        this.ar.setText(Integer.toString(b - j));
        this.ar.setVisibility(0);
      }
    while (true)
    {
      return;
      this.ar.setTextColor(q().getColor(2131165315));
      break;
      this.ar.setText("");
      this.ar.setVisibility(8);
    }
  }

  private void am()
  {
    if (this.an.getText().length() > b)
      return;
    if (this.aD != null)
    {
      if (!this.aN)
        break label104;
      this.ac.c("sms_send_clicked");
    }
    while (true)
    {
      if ((this.ax != null) && (this.aA == ComposeFragment.LocationState.HAS_LOCATION))
        this.e.a(this.ax, this.aB, System.currentTimeMillis());
      this.aD.a();
      if (this.aQ == null)
        break;
      this.aQ.a();
      break;
      break;
      label104: this.ac.c("send_clicked");
    }
  }

  private void an()
  {
    am();
  }

  private void ao()
  {
    PickMediaParams localPickMediaParams = new PickMediaParams(true);
    localPickMediaParams.a(p().getString(2131362542));
    this.ay.a(localPickMediaParams);
  }

  private void ap()
  {
    if (this.aP != null)
      R();
    j(false);
  }

  private void aq()
  {
    ar();
  }

  private void ar()
  {
    Tracer.b(3L);
    Tracer localTracer = Tracer.a("openEmojiAttachmentsKeyboard");
    this.an.requestFocus();
    WindowManager localWindowManager = (WindowManager)p().getSystemService("window");
    int j = localWindowManager.getDefaultDisplay().getHeight();
    int k = localWindowManager.getDefaultDisplay().getWidth();
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    int n;
    int i1;
    int i2;
    int i4;
    int i5;
    int i6;
    boolean bool;
    label214: int i8;
    label298: FragmentTransaction localFragmentTransaction;
    int i9;
    int i10;
    if (this.aQ != null)
    {
      this.aQ.a(localRect);
      k = this.aQ.b();
      this.am.getLocationInWindow(arrayOfInt);
      arrayOfInt[1] += localRect.top;
      int m = arrayOfInt[1];
      n = m + this.am.getHeight();
      i1 = j - n;
      i2 = m - localRect.top;
      int i3 = SizeUtil.a(q(), 100.0F);
      i4 = SizeUtil.a(q(), 8.0F);
      if ((i1 > i3) || (i2 <= i1))
        break label485;
      i5 = 268435539;
      i6 = j - (m + i4);
      bool = false;
      int i7 = q().getDimensionPixelSize(2131230898);
      i8 = i4 + (i7 + new EmojiSizingCalculator(q()).a(k, i2 - (i7 + i4), bool).m());
      if (q().getConfiguration().orientation == 2)
        i8 = SizeUtil.a(q(), 150.0F);
      if (!bool)
        break label516;
      i8 = i2;
      localFragmentTransaction = r().a();
      Fragment localFragment = r().a("emojiKeyboard");
      if (localFragment != null)
        localFragmentTransaction.a(localFragment);
      this.aP = EmojiAttachmentPopup.a(arrayOfInt[0], i6, i8, k, bool, i5, as());
      this.aP.a(new ComposeFragment.19(this));
      this.aP.a(2, 0);
      if (this.aQ == null)
        break label540;
      this.aP.c(false);
      i9 = this.am.getHeight();
      IEmojiKeyboardWindowControl localIEmojiKeyboardWindowControl = this.aQ;
      EmojiAttachmentPopup localEmojiAttachmentPopup = this.aP;
      i10 = 0;
      if (!bool)
        break label530;
      label425: localIEmojiKeyboardWindowControl.a(localEmojiAttachmentPopup, "emojiKeyboard", i10, i8);
    }
    while (true)
    {
      j(true);
      localTracer.a();
      Tracer.a(a);
      return;
      o().d().getDecorView().getWindowVisibleDisplayFrame(localRect);
      this.am.getLocationInWindow(arrayOfInt);
      break;
      label485: i5 = 268435507;
      i6 = n - (i4 + localRect.top);
      i2 = i1 + i4;
      bool = true;
      break label214;
      label516: if (i2 > i8)
        break label298;
      i8 = i2;
      break label298;
      label530: i10 = i9 - i4;
      break label425;
      label540: this.aP.a(localFragmentTransaction, "emojiKeyboard");
    }
  }

  private boolean as()
  {
    boolean bool2;
    if (this.ax == null)
    {
      boolean bool3 = this.aN;
      bool2 = false;
      if (!bool3);
    }
    while (true)
    {
      return bool2;
      bool2 = this.aW;
      continue;
      boolean bool1 = MessagingIdUtil.g(this.ax);
      bool2 = false;
      if (bool1)
        continue;
      bool2 = true;
    }
  }

  private void at()
  {
    if ((this.aU) || (!((Boolean)this.al.b()).booleanValue()));
    while (true)
    {
      return;
      this.aU = true;
      M();
      if (this.ax != null)
        this.h.b().a(EmojiAttachmentPrefKeys.a(this.ax), 1).a();
      if ((p() instanceof Activity))
        n().setRequestedOrientation(1);
      this.au.setVisibility(0);
      this.au.a();
      this.av.setVisibility(8);
      this.au.setClickable(true);
      R();
      ((InputMethodManager)p().getSystemService("input_method")).hideSoftInputFromWindow(this.an.getWindowToken(), 0);
    }
  }

  private void au()
  {
    if (!this.aU);
    while (true)
    {
      return;
      this.aU = false;
      if (this.ax != null)
        this.h.b().a(EmojiAttachmentPrefKeys.a(this.ax), 0).a();
      this.au.setVisibility(8);
      this.au.b();
      this.av.setVisibility(0);
      this.au.setClickable(false);
      if (!(p() instanceof Activity))
        continue;
      n().setRequestedOrientation(-1);
    }
  }

  private void av()
  {
    if ((this.aP == null) || (this.aP.L()))
      a();
  }

  private void aw()
  {
    boolean bool1 = this.an.isFocused();
    boolean bool2 = false;
    if (bool1)
    {
      Configuration localConfiguration = q().getConfiguration();
      int j = localConfiguration.orientation;
      bool2 = false;
      if (j == 2)
        if (localConfiguration.keyboard != 1)
        {
          int k = localConfiguration.hardKeyboardHidden;
          bool2 = false;
          if (k != 2);
        }
        else
        {
          bool2 = true;
        }
    }
    k(bool2);
  }

  private void b(Location paramLocation)
  {
    if (this.aA != ComposeFragment.LocationState.NO_LOCATION)
      a(ComposeFragment.LocationState.HAS_LOCATION, paramLocation);
  }

  private void b(MediaAttachment paramMediaAttachment)
  {
    if (paramMediaAttachment == null)
      ak();
    while (true)
    {
      return;
      Drawable localDrawable;
      switch (ComposeFragment.20.a[paramMediaAttachment.a().b().ordinal()])
      {
      default:
        localDrawable = null;
      case 1:
      case 2:
      }
      while (true)
      {
        if (localDrawable != null)
          break label112;
        BLog.d(a, "Failed to preview from attachment at " + paramMediaAttachment.a().c());
        ak();
        break;
        localDrawable = c(paramMediaAttachment);
        continue;
        localDrawable = q().getDrawable(17301679);
      }
      label112: FrameLayout localFrameLayout = (FrameLayout)this.ae.inflate(2130903319, this.as, false);
      ((ImageView)a(localFrameLayout, 2131296514)).setImageDrawable(localDrawable);
      a(localFrameLayout, 2131297196).setOnClickListener(new ComposeFragment.15(this, paramMediaAttachment));
      this.as.addView(localFrameLayout);
      this.at.setVisibility(0);
      this.az.put(paramMediaAttachment, localFrameLayout);
      ak();
    }
  }

  private Drawable c(MediaAttachment paramMediaAttachment)
  {
    int j = SizeUtil.a(p(), 67.0F);
    Bitmap localBitmap = this.ai.a(paramMediaAttachment, j);
    StateListDrawable localStateListDrawable;
    if (localBitmap == null)
      localStateListDrawable = null;
    while (true)
    {
      return localStateListDrawable;
      Resources localResources = q();
      Drawable localDrawable1 = localResources.getDrawable(2130838556);
      Drawable localDrawable2 = localResources.getDrawable(2130838557);
      Drawable localDrawable3 = a(localBitmap, localDrawable1);
      Drawable localDrawable4 = a(localBitmap, localDrawable2);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(ba, localDrawable4);
      localStateListDrawable.addState(bb, localDrawable3);
    }
  }

  private void c(boolean paramBoolean)
  {
    if (!ac())
      Z();
    while (true)
    {
      return;
      if (!ad())
      {
        aa();
        continue;
      }
      if ((paramBoolean) || (this.aA == ComposeFragment.LocationState.NO_LOCATION));
      for (boolean bool = true; ; bool = false)
      {
        if (this.ax != null)
        {
          OrcaSharedPreferences.Editor localEditor = this.h.b();
          localEditor.a(MessagesPrefKeys.b(this.ax), bool);
          localEditor.a();
        }
        if (!bool)
          break label113;
        this.aC = Boolean.TRUE;
        af();
        this.ac.c("enabled_shared_location_in_message");
        break;
      }
      label113: this.aC = Boolean.FALSE;
      ag();
      this.ac.c("disabled_shared_location_in_message");
    }
  }

  private void d(String paramString)
  {
    Context localContext = p();
    View localView = this.ae.inflate(2130903357, null);
    TextView localTextView = (TextView)localView.findViewById(2131297315);
    AlertDialog.Builder localBuilder;
    if (paramString != null)
    {
      localTextView.setText(2131362560);
      localBuilder = new AlertDialog.Builder(localContext);
      localBuilder.setTitle(2131362559);
      if (paramString == null)
        break label126;
      localBuilder.setPositiveButton(2131362561, new ComposeFragment.17(this, paramString));
      localBuilder.setNegativeButton(2131362168, null);
    }
    while (true)
    {
      AlertDialog localAlertDialog = localBuilder.create();
      localAlertDialog.setView(localView, 0, 0, 0, 0);
      localAlertDialog.show();
      return;
      localTextView.setText(2131362562);
      break;
      label126: localBuilder.setPositiveButton(2131362167, null);
    }
  }

  private SpannableString e(String paramString)
  {
    Resources localResources = q();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(q());
    localStyledStringBuilder.a(new ForegroundColorSpan(localResources.getColor(2131165383)), 33);
    localStyledStringBuilder.a(paramString);
    localStyledStringBuilder.a();
    return localStyledStringBuilder.b();
  }

  private void f(int paramInt)
  {
    String str = this.an.getText().toString();
    Intent localIntent = new Intent(p(), ThreadViewActivity.class);
    localIntent.putExtra("thread_id", c());
    localIntent.putExtra("show_composer", true);
    localIntent.putExtra("composer_initial_text", str);
    if (paramInt != -1)
      localIntent.putExtra("open_media_picker_source", paramInt);
    ThreadParticipantUtils localThreadParticipantUtils = (ThreadParticipantUtils)Q().a(ThreadParticipantUtils.class);
    ThreadSummary localThreadSummary = this.e.b(this.ax);
    if ((localThreadSummary != null) && (localThreadSummary.g()))
    {
      ThreadParticipant localThreadParticipant = localThreadParticipantUtils.a(localThreadSummary);
      if (localThreadParticipant != null)
      {
        User localUser = this.e.a(localThreadParticipant.d());
        if ((localUser != null) && (localUser.h() != null))
          localIntent.putExtra("to", new UserWithIdentifier(localUser, localUser.h()));
      }
    }
    a(localIntent);
  }

  private void f(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click");
    localHoneyClientEvent.e("emoji_attachment_popup");
    localHoneyClientEvent.b("action", paramString);
    this.ak.a(localHoneyClientEvent);
  }

  private void h(int paramInt)
  {
    if ((p() instanceof Activity))
    {
      if ((this.aP != null) && (this.aP.v()))
      {
        this.aP.a();
        j(false);
      }
      PickMediaParams localPickMediaParams = new PickMediaParams(true);
      this.ay.a(localPickMediaParams, paramInt);
    }
    while (true)
    {
      return;
      f(paramInt);
    }
  }

  private void i(boolean paramBoolean)
  {
    if ((paramBoolean) && (ae()))
      this.ao.setVisibility(0);
    while (true)
    {
      return;
      this.ao.setVisibility(8);
    }
  }

  private void j(boolean paramBoolean)
  {
    if (this.aT == paramBoolean);
    while (true)
    {
      return;
      this.aT = paramBoolean;
      if (paramBoolean)
      {
        this.ap.setBackgroundResource(2130838561);
        continue;
      }
      this.ap.setBackgroundResource(2130838560);
    }
  }

  private void k(boolean paramBoolean)
  {
    if (this.aX != paramBoolean)
    {
      this.aX = paramBoolean;
      if (this.aY != null)
        this.aY.a(this.aX);
    }
  }

  public void B()
  {
    super.B();
    this.aR = true;
    R();
    boolean bool = this.aj.inKeyguardRestrictedInputMode();
    if (S())
    {
      this.aV = false;
      if (!bool)
        break label43;
      this.aV = true;
    }
    while (true)
    {
      return;
      label43: X();
    }
  }

  public void C()
  {
    super.C();
    this.aR = false;
    this.i.a();
    P();
  }

  public void D()
  {
    super.D();
    this.an.clearFocus();
  }

  public boolean L()
  {
    if ((StringUtil.a(CharMatcher.WHITESPACE.trimFrom(this.an.getText().toString()))) && (this.az.isEmpty()));
    for (int j = 1; ; j = 0)
      return j;
  }

  public void M()
  {
    this.an.setText("");
    W();
    ak();
  }

  public void N()
  {
    a(ComposeFragment.LocationState.NO_LOCATION, null);
    X();
  }

  public void O()
  {
    this.ax = null;
    this.aB = null;
    this.ao.setImageResource(2130838550);
    this.aA = ComposeFragment.LocationState.INIT;
    this.aI = false;
    this.aH = null;
    this.an.setText("");
    W();
    au();
  }

  public void P()
  {
    a(false, true);
    this.an.removeCallbacks(this.aO);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.am = paramLayoutInflater.inflate(2130903320, paramViewGroup, false);
    this.am.setFocusable(true);
    this.am.setOnTouchListener(new ComposeFragment.3(this));
    this.az = Maps.a();
    this.an = ((EditText)a(this.am, 2131297205));
    this.ao = ((ImageButton)a(this.am, 2131297206));
    this.ap = a(this.am, 2131297201);
    this.aq = ((Button)a(this.am, 2131297204));
    this.ar = ((TextView)a(this.am, 2131297207));
    this.as = ((LinearLayout)a(this.am, 2131297200));
    this.at = ((HorizontalScrollView)a(this.am, 2131297199));
    this.au = ((AudioComposerView)a(this.am, 2131297208));
    this.av = ((RelativeLayout)a(this.am, 2131297198));
    a(ComposeMode.SHRUNK);
    this.ao.setOnClickListener(new ComposeFragment.4(this));
    i(true);
    this.ap.setOnClickListener(new ComposeFragment.5(this));
    this.aq.setOnClickListener(new ComposeFragment.6(this));
    this.an.addTextChangedListener(new ComposeFragment.7(this));
    this.an.setOnTouchListener(new ComposeFragment.8(this));
    this.an.setOnEditorActionListener(new ComposeFragment.9(this));
    this.an.setOnFocusChangeListener(new ComposeFragment.10(this));
    ((ComposeRootView)this.am).setPreImeKeyListener(new ComposeFragment.11(this));
    this.au.setListener(new ComposeFragment.12(this));
    this.aw = b("getLocationOperation");
    this.aw.a(new ComposeFragment.13(this));
    this.aw.a(new ComposeFragment.14(this));
    ak();
    return this.am;
  }

  public void a()
  {
    this.an.requestFocus();
    ((InputMethodManager)p().getSystemService("input_method")).showSoftInput(this.an, 1);
    aw();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.e = ((DataCache)localFbInjector.a(DataCache.class));
    this.az = Maps.a();
    this.f = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.g = ((MediaAttachmentFactory)localFbInjector.a(MediaAttachmentFactory.class));
    this.h = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.i = ((AnchorableToast)localFbInjector.a(AnchorableToast.class));
    this.Z = ((ThreadDisplayCache)localFbInjector.a(ThreadDisplayCache.class));
    this.aa = ((OfflineThreadingIdGenerator)localFbInjector.a(OfflineThreadingIdGenerator.class));
    this.ab = ((PresenceManager)localFbInjector.a(PresenceManager.class));
    this.ac = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.ad = ((LocationManager)localFbInjector.a(LocationManager.class));
    this.ae = ((LayoutInflater)localFbInjector.a(LayoutInflater.class));
    this.af = ((PushDeserialization)localFbInjector.a(PushDeserialization.class));
    this.aG = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.ag = ((EmojiUtil)localFbInjector.a(EmojiUtil.class));
    this.ah = localFbInjector.b(Boolean.class, IsEmojiAttachmentPopupEnabled.class);
    this.ai = ((MediaAttachmentUtil)localFbInjector.a(MediaAttachmentUtil.class));
    this.aj = ((KeyguardManager)localFbInjector.a(KeyguardManager.class));
    this.ak = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.al = localFbInjector.b(Boolean.class, IsAudioRecorderEnabled.class);
    this.Y = r();
    if ((p() instanceof Activity))
    {
      this.ay = ((PickMediaOperation)this.Y.a("pickPhotoOperation"));
      if (this.ay == null)
      {
        this.ay = new PickMediaOperation();
        a("pickPhotoOperation", this.ay);
      }
      this.ay.a(new ComposeFragment.1(this));
      this.i.a(true);
      this.aS = q().getConfiguration().orientation;
    }
  }

  public void a(Button paramButton, Drawable paramDrawable)
  {
    int j = paramButton.getPaddingBottom();
    int k = paramButton.getPaddingLeft();
    int m = paramButton.getPaddingRight();
    int n = paramButton.getPaddingTop();
    paramButton.setBackgroundDrawable(paramDrawable);
    paramButton.setPadding(k, n, m, j);
  }

  public void a(ComposeFragment.InitParams paramInitParams)
  {
    if (paramInitParams == null);
    while (true)
    {
      return;
      if (paramInitParams.a != null)
        this.an.setText(paramInitParams.a);
      try
      {
        if (paramInitParams.b != null)
        {
          MediaResource localMediaResource = MediaResource.a(paramInitParams.b);
          b(this.g.a(localMediaResource));
        }
        ak();
        if (paramInitParams.c == -1)
          continue;
        this.ay.a(new PickMediaParams(true), paramInitParams.c);
      }
      catch (UnknownAttachmentTypeException localUnknownAttachmentTypeException)
      {
        while (true)
          a(e(q().getString(2131362541)), AnchorableToast.ToastType.WARNING);
      }
    }
  }

  public void a(ComposeFragment.OnSendClickedListener paramOnSendClickedListener)
  {
    this.aD = paramOnSendClickedListener;
  }

  public void a(ComposeMode paramComposeMode)
  {
    if (paramComposeMode == ComposeMode.EXPANDED)
    {
      if (!this.aN)
        i(true);
      if (this.aA != ComposeFragment.LocationState.NO_LOCATION)
        X();
    }
    while (true)
    {
      if (this.aZ != null)
        this.aZ.a(paramComposeMode);
      this.aF = paramComposeMode;
      return;
      if (!L())
        continue;
      i(false);
      this.i.a();
    }
  }

  public void a(LocationNuxController paramLocationNuxController)
  {
    this.aE = paramLocationNuxController;
  }

  public void a(MessageDraft paramMessageDraft)
  {
    String str = paramMessageDraft.a();
    this.an.setText(str);
    if ((paramMessageDraft.b() != 0) && (paramMessageDraft.b() <= this.an.length()))
      this.an.setSelection(paramMessageDraft.b());
    ak();
    List localList = paramMessageDraft.c();
    if (!localList.isEmpty())
      try
      {
        W();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          MediaResource localMediaResource = (MediaResource)localIterator.next();
          b(this.g.a(localMediaResource));
        }
      }
      catch (UnknownAttachmentTypeException localUnknownAttachmentTypeException)
      {
        BLog.d(a, "cannot create attachment for draft: " + localUnknownAttachmentTypeException);
      }
    if ((!StringUtil.a(str)) || (!localList.isEmpty()))
      a();
  }

  public void a(String paramString)
  {
    this.ax = paramString;
    a(MessagingIdUtil.g(paramString));
    if (this.h.a(EmojiAttachmentPrefKeys.a(paramString), 0) == 1)
      at();
    while (true)
    {
      return;
      au();
    }
  }

  public void a(boolean paramBoolean)
  {
    this.aN = paramBoolean;
    Drawable localDrawable;
    if (paramBoolean)
    {
      i(false);
      localDrawable = q().getDrawable(2130838542);
    }
    for (int j = 2131362549; ; j = 2131362548)
    {
      a(this.aq, localDrawable);
      this.an.setHint(j);
      return;
      i(true);
      localDrawable = q().getDrawable(2130838536);
    }
  }

  public MessageDraft b()
  {
    String str = this.an.getText().toString();
    if ((StringUtil.a(str)) && (this.az.isEmpty()));
    for (MessageDraft localMessageDraft = null; ; localMessageDraft = new MessageDraft(str, this.an.getSelectionStart(), U()))
      return localMessageDraft;
  }

  public void b(boolean paramBoolean)
  {
    this.aW = paramBoolean;
  }

  public String c()
  {
    return this.ax;
  }

  public void c(String paramString)
  {
    if (this.aC != null)
    {
      OrcaSharedPreferences.Editor localEditor = this.h.b();
      localEditor.a(MessagesPrefKeys.b(paramString), this.aC.booleanValue());
      localEditor.a();
    }
  }

  public Message d()
  {
    return this.af.a(900, this.ax, Long.toString(this.aa.a()), this.an.getText().toString(), -1L, -1L, T(), U());
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.aP = ((EmojiAttachmentPopup)r().a("emojiKeyboard"));
    if (paramBundle != null)
    {
      W();
      this.az.clear();
      ArrayList localArrayList1 = paramBundle.getParcelableArrayList("mediaResources");
      ArrayList localArrayList2 = Lists.a();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator.next();
        localArrayList2.add(this.g.b(localMediaResource));
      }
      a(localArrayList2, false);
      ComposeFragment.LocationState localLocationState = ComposeFragment.LocationState.NO_LOCATION;
      if (ab())
        localLocationState = ComposeFragment.LocationState.valueOf(paramBundle.getString("locationState"));
      a(localLocationState, null);
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = this.az.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((MediaAttachment)localIterator.next()).a());
    paramBundle.putParcelableArrayList("mediaResources", localArrayList);
    paramBundle.putString("locationState", this.aA.name());
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.aS != paramConfiguration.orientation)
      R();
    this.aS = paramConfiguration.orientation;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment
 * JD-Core Version:    0.6.0
 */