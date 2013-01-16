package com.facebook.bugreporter;

import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.util.FileSizeUtil;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.FbNestedFragment;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

public class BugReportFragment extends FbNestedFragment
  implements NavigableFragment
{
  private static final Class<?> a = BugReportFragment.class;
  private NavigableFragment.Listener Y;
  private FbTitleBar Z;
  private EditText aa;
  private View ab;
  private UrlImage ac;
  private View ad;
  private TextView ae;
  private TextView af;
  private boolean ag;
  private PackageInfo b;
  private AndroidThreadUtil c;
  private BugReportUploader d;
  private ListeningExecutorService e;
  private Executor f;
  private FileSizeUtil g;
  private InputMethodManager h;
  private BugReportBuilder i;

  private void b()
  {
    Uri localUri = this.i.d();
    Futures.a(this.e.a(new BugReportFragment.4(this, localUri)), new BugReportFragment.5(this), this.f);
    this.i.d();
  }

  private void c()
  {
    this.ag = true;
    this.ab.setVisibility(8);
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	com/facebook/bugreporter/BugReportFragment:aa	Landroid/widget/EditText;
    //   4: invokevirtual 110	android/widget/EditText:getText	()Landroid/text/Editable;
    //   7: invokevirtual 116	java/lang/Object:toString	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 122	java/lang/String:length	()I
    //   15: ifne +13 -> 28
    //   18: aload_0
    //   19: invokevirtual 126	com/facebook/bugreporter/BugReportFragment:p	()Landroid/content/Context;
    //   22: ldc 127
    //   24: invokestatic 132	com/facebook/common/util/Toaster:a	(Landroid/content/Context;I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 52	com/facebook/bugreporter/BugReportFragment:i	Lcom/facebook/bugreporter/BugReportBuilder;
    //   32: aload_1
    //   33: invokevirtual 135	com/facebook/bugreporter/BugReportBuilder:a	(Ljava/lang/String;)Lcom/facebook/bugreporter/BugReportBuilder;
    //   36: pop
    //   37: aload_0
    //   38: getfield 87	com/facebook/bugreporter/BugReportFragment:ag	Z
    //   41: ifeq +12 -> 53
    //   44: aload_0
    //   45: getfield 52	com/facebook/bugreporter/BugReportFragment:i	Lcom/facebook/bugreporter/BugReportBuilder;
    //   48: aconst_null
    //   49: invokevirtual 138	com/facebook/bugreporter/BugReportBuilder:c	(Landroid/net/Uri;)Lcom/facebook/bugreporter/BugReportBuilder;
    //   52: pop
    //   53: new 140	java/io/File
    //   56: dup
    //   57: new 142	java/net/URI
    //   60: dup
    //   61: aload_0
    //   62: getfield 52	com/facebook/bugreporter/BugReportFragment:i	Lcom/facebook/bugreporter/BugReportBuilder;
    //   65: invokevirtual 144	com/facebook/bugreporter/BugReportBuilder:a	()Landroid/net/Uri;
    //   68: invokevirtual 147	android/net/Uri:toString	()Ljava/lang/String;
    //   71: invokespecial 150	java/net/URI:<init>	(Ljava/lang/String;)V
    //   74: invokespecial 153	java/io/File:<init>	(Ljava/net/URI;)V
    //   77: astore_3
    //   78: aload_3
    //   79: invokevirtual 157	java/io/File:exists	()Z
    //   82: ifne +8 -> 90
    //   85: aload_3
    //   86: invokevirtual 160	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: new 140	java/io/File
    //   93: dup
    //   94: aload_3
    //   95: ldc 162
    //   97: invokespecial 165	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   100: astore 4
    //   102: aload_1
    //   103: invokevirtual 169	java/lang/String:getBytes	()[B
    //   106: aload 4
    //   108: invokestatic 174	com/facebook/common/util/FileUtils:a	([BLjava/io/File;)V
    //   111: aload_0
    //   112: invokevirtual 126	com/facebook/bugreporter/BugReportFragment:p	()Landroid/content/Context;
    //   115: invokestatic 179	com/facebook/common/util/GitHashUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   118: astore 6
    //   120: aload_0
    //   121: getfield 181	com/facebook/bugreporter/BugReportFragment:b	Landroid/content/pm/PackageInfo;
    //   124: getfield 187	android/content/pm/PackageInfo:versionCode	I
    //   127: i2l
    //   128: lstore 7
    //   130: lload 7
    //   132: lconst_0
    //   133: lcmp
    //   134: iflt +87 -> 221
    //   137: lload 7
    //   139: invokestatic 191	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   142: astore 9
    //   144: aload_0
    //   145: getfield 52	com/facebook/bugreporter/BugReportFragment:i	Lcom/facebook/bugreporter/BugReportBuilder;
    //   148: aload 6
    //   150: invokevirtual 193	com/facebook/bugreporter/BugReportBuilder:c	(Ljava/lang/String;)Lcom/facebook/bugreporter/BugReportBuilder;
    //   153: pop
    //   154: aload_0
    //   155: getfield 52	com/facebook/bugreporter/BugReportFragment:i	Lcom/facebook/bugreporter/BugReportBuilder;
    //   158: aload 9
    //   160: invokevirtual 195	com/facebook/bugreporter/BugReportBuilder:d	(Ljava/lang/String;)Lcom/facebook/bugreporter/BugReportBuilder;
    //   163: pop
    //   164: aload_0
    //   165: getfield 197	com/facebook/bugreporter/BugReportFragment:c	Lcom/facebook/orca/common/util/AndroidThreadUtil;
    //   168: new 199	com/facebook/bugreporter/BugReportFragment$6
    //   171: dup
    //   172: aload_0
    //   173: invokespecial 200	com/facebook/bugreporter/BugReportFragment$6:<init>	(Lcom/facebook/bugreporter/BugReportFragment;)V
    //   176: invokeinterface 205 2 0
    //   181: aload_0
    //   182: getfield 207	com/facebook/bugreporter/BugReportFragment:Y	Lcom/facebook/fragment/NavigableFragment$Listener;
    //   185: aload_0
    //   186: aconst_null
    //   187: invokeinterface 212 3 0
    //   192: goto -165 -> 27
    //   195: astore 13
    //   197: getstatic 44	com/facebook/bugreporter/BugReportFragment:a	Ljava/lang/Class;
    //   200: ldc 214
    //   202: invokestatic 219	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;)V
    //   205: goto -178 -> 27
    //   208: astore 5
    //   210: getstatic 44	com/facebook/bugreporter/BugReportFragment:a	Ljava/lang/Class;
    //   213: ldc 221
    //   215: invokestatic 223	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;)V
    //   218: goto -107 -> 111
    //   221: ldc 225
    //   223: astore 9
    //   225: goto -81 -> 144
    //
    // Exception table:
    //   from	to	target	type
    //   53	78	195	java/net/URISyntaxException
    //   90	111	208	java/io/IOException
  }

  public void B()
  {
    super.B();
    this.aa.requestFocus();
    this.h.showSoftInput(this.aa, 1);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903081, paramViewGroup, false);
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.Y = paramListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = FbInjector.a(p());
    this.b = ((PackageInfo)localFbInjector.a(PackageInfo.class));
    this.c = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.d = ((BugReportUploader)localFbInjector.a(BugReportUploader.class));
    this.e = ((ListeningExecutorService)localFbInjector.a(ListeningExecutorService.class, DefaultExecutorService.class));
    this.f = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.g = ((FileSizeUtil)localFbInjector.a(FileSizeUtil.class));
    this.h = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    if (paramBundle != null);
    for (BugReport localBugReport = (BugReport)paramBundle.getParcelable("bugReport"); localBugReport == null; localBugReport = (BugReport)m().getParcelable("report"))
    {
      BLog.d(a, "Missing bug report in intent");
      this.Y.a(this, null);
      return;
    }
    FbTitleBarUtil.a(A());
    this.Z = ((FbTitleBar)f(2131296299));
    this.Z.setTitle(2131361990);
    this.aa = ((EditText)f(2131296432));
    this.ab = f(2131296433);
    this.ac = ((UrlImage)f(2131296436));
    this.ad = f(2131296435);
    this.ae = ((TextView)f(2131296434));
    this.af = ((TextView)f(2131296437));
    this.ad.setOnClickListener(new BugReportFragment.1(this));
    TitleBarButtonSpec localTitleBarButtonSpec = TitleBarButtonSpec.newBuilder().a(1).b(e(2131362009)).i();
    this.Z.setButtonSpecs(ImmutableList.a(localTitleBarButtonSpec));
    this.Z.setOnToolbarButtonListener(new BugReportFragment.2(this));
    this.i = BugReport.newBuilder().a(localBugReport);
    if (this.i.b() != null)
      this.aa.setText(this.i.b());
    if (paramBundle != null)
      this.ag = paramBundle.getBoolean("screenShotRemoved");
    if ((this.i.d() == null) || (this.ag))
      this.ab.setVisibility(8);
    while (true)
    {
      CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
      localCustomUrlLikeSpan.a(new BugReportFragment.3(this));
      Resources localResources = q();
      StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(q());
      localStyledStringBuilder.a(localResources.getString(2131361992));
      localStyledStringBuilder.a("[[link]]", localResources.getString(2131361993), localCustomUrlLikeSpan, 33);
      this.af.setText(localStyledStringBuilder.b());
      this.af.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      this.ab.setVisibility(0);
      this.ac.setImageParams(this.i.d());
      b();
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("bugReport", this.i.i());
    paramBundle.putBoolean("screenShotRemoved", this.ag);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportFragment
 * JD-Core Version:    0.6.0
 */