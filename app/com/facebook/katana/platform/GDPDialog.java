package com.facebook.katana.platform;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.katana.prefs.NativeGdpPrefsKeys;
import com.facebook.katana.server.handler.PlatformOperationHandler.GetAuthorizationStringParams;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Params;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Params.Builder;
import com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod.Params;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.UUID;

public class GDPDialog extends DialogFragment
  implements DialogInterface.OnKeyListener
{
  private static final Class<?> Y = GDPDialog.class;
  private View Z;
  private View aa;
  private View ab;
  private View ac;
  private GDPState ad;
  private View ae;
  private View af;
  private TextView ag;
  private LinearLayout ah;
  private View.OnClickListener ai;
  private String aj;
  private OrcaServiceFragment ak;
  private OrcaServiceFragment al;
  private GDPDialog.GDPStatusCallback am;
  private Bundle an;
  private String ao;
  private String ap;
  private String aq;
  private List<String> ar;
  private Boolean as;
  private String at;
  private String au;
  private FbInjector av;
  private OrcaServiceOperationFactory aw;
  private OrcaSharedPreferences ax;
  private AnalyticsLogger ay;

  public GDPDialog()
  {
    BLog.b(Y, "New GDPDialog");
  }

  private void M()
  {
    switch (GDPDialog.5.a[this.ad.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return;
      a(GDPState.LOADING_PERMISSIONS);
      continue;
      S();
      continue;
      T();
      continue;
      R();
      continue;
      U();
      continue;
      R();
      continue;
      if (this.am == null)
        continue;
      this.am.g(this.an);
      continue;
      if (this.am == null)
        continue;
      this.am.c(this.an);
    }
  }

  private void N()
  {
    this.Z.setVisibility(0);
    this.ab.setVisibility(0);
    this.aa.setVisibility(0);
    this.ac.setVisibility(8);
  }

  private void O()
  {
    this.Z.setVisibility(0);
    this.ab.setVisibility(8);
    this.aa.setVisibility(8);
    this.ac.setVisibility(8);
  }

  private void P()
  {
    this.ac.setVisibility(0);
    this.ab.setVisibility(0);
    this.Z.setVisibility(0);
    this.aa.setVisibility(8);
  }

  private void Q()
  {
    this.af.setVisibility(0);
    this.ae.setVisibility(8);
  }

  private void R()
  {
    Q();
    O();
  }

  private void S()
  {
    a(this.aj);
    int i = this.ax.a(NativeGdpPrefsKeys.b, 0);
    if ((this.as.booleanValue()) && (i < 2))
      this.ah.setVisibility(0);
    N();
  }

  private void T()
  {
    f(2131362201);
    P();
  }

  private void U()
  {
    T();
  }

  private void V()
  {
    if (!this.as.booleanValue());
    while (true)
    {
      return;
      if (this.ax.a(NativeGdpPrefsKeys.b, 0) < 2)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("app_info", new UpdateNativeGdpNuxStatusMethod.Params(this.ao));
        Futures.a(this.aw.a("platform_update_native_gdp_nux_status", localBundle).d(), new GDPDialog.4(this));
        continue;
      }
    }
  }

  private void W()
  {
    if (this.ad == GDPState.DISPLAYING_PERMISSIONS)
      V();
    a(GDPState.CANCELED);
  }

  private void X()
  {
    switch (GDPDialog.5.a[this.ad.ordinal()])
    {
    case 4:
    default:
    case 3:
    case 5:
    }
    while (true)
    {
      return;
      a(GDPState.LOADING_PERMISSIONS);
      continue;
      a(GDPState.SENDING_APPROVAL);
    }
  }

  private void Y()
  {
    switch (GDPDialog.5.a[this.ad.ordinal()])
    {
    default:
    case 2:
    }
    while (true)
    {
      return;
      V();
      a(GDPState.SENDING_APPROVAL);
    }
  }

  private void Z()
  {
    PlatformOperationHandler.GetAuthorizationStringParams localGetAuthorizationStringParams = new PlatformOperationHandler.GetAuthorizationStringParams(this.ap, this.ar, this.at);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_permissions", localGetAuthorizationStringParams);
    this.ak.a("platform_get_authorization_string", localBundle);
  }

  public static GDPDialog a(List<String> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    GDPDialog localGDPDialog = new GDPDialog();
    localGDPDialog.ad = GDPState.CREATED;
    localGDPDialog.au = UUID.randomUUID().toString();
    localGDPDialog.ao = paramString2;
    localGDPDialog.aq = paramString3;
    localGDPDialog.ar = paramList;
    localGDPDialog.at = paramString1;
    localGDPDialog.ap = paramString4;
    localGDPDialog.as = Boolean.valueOf(paramList.contains("basic_info"));
    return localGDPDialog;
  }

  private void a(String paramString)
  {
    this.af.setVisibility(8);
    this.ae.setVisibility(0);
    this.ag.setText(paramString);
  }

  private void aa()
  {
    BLog.b(Y, "asyncSendPermissionsRequest");
    AuthorizeAppMethod.Params localParams = new AuthorizeAppMethod.Params.Builder(this.ao, this.aq).a(this.ar).a(this.at).a();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_info", localParams);
    this.al.a("platform_authorize_app", localBundle);
  }

  private void f(int paramInt)
  {
    this.af.setVisibility(8);
    this.ae.setVisibility(0);
    this.ag.setText(paramInt);
  }

  private void g(Bundle paramBundle)
  {
    if (this.am != null)
      this.am.g(paramBundle);
    this.an = paramBundle;
  }

  private void h(Bundle paramBundle)
  {
    if (this.am != null)
      this.am.c(paramBundle);
    this.an = paramBundle;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    BLog.b(Y, "onCreateView " + paramBundle);
    c().setTitle(2131362037);
    c().setCanceledOnTouchOutside(false);
    c().setOnKeyListener(this);
    return paramLayoutInflater.inflate(2130903281, paramViewGroup, false);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    BLog.b(Y, "onCreate dialog");
    e(true);
    b(false);
    this.av = FbInjector.a(p().getApplicationContext());
    this.aw = ((OrcaServiceOperationFactory)this.av.a(OrcaServiceOperationFactory.class));
    this.ax = ((OrcaSharedPreferences)this.av.a(OrcaSharedPreferences.class));
    this.ay = ((AnalyticsLogger)this.av.a(AnalyticsLogger.class));
    this.ak = OrcaServiceFragment.a(this, "permissionStringOperation");
    this.ak.a(new GDPDialog.1(this));
    this.al = OrcaServiceFragment.a(this, "sendAuthorizationOperation");
    this.al.a(new GDPDialog.2(this));
  }

  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.ai = new GDPDialog.3(this);
    this.af = paramView.findViewById(2131297102);
    this.ae = paramView.findViewById(2131297104);
    this.ag = ((TextView)this.ae.findViewById(2131297105));
    this.ah = ((LinearLayout)this.ae.findViewById(2131297106));
    Button localButton1 = (Button)paramView.findViewById(2131297109);
    localButton1.setOnClickListener(this.ai);
    this.Z = localButton1;
    this.ab = paramView.findViewById(2131297108);
    Button localButton2 = (Button)paramView.findViewById(2131297110);
    localButton2.setOnClickListener(this.ai);
    this.aa = localButton2;
    Button localButton3 = (Button)paramView.findViewById(2131297111);
    localButton3.setOnClickListener(this.ai);
    this.ac = localButton3;
  }

  public void a(GDPDialog.GDPStatusCallback paramGDPStatusCallback)
  {
    this.am = paramGDPStatusCallback;
  }

  public void a(GDPState paramGDPState)
  {
    a(paramGDPState, null);
  }

  public void a(GDPState paramGDPState, Object paramObject)
  {
    BLog.b(Y, "Attempting to transition from " + this.ad + " to " + paramGDPState);
    switch (GDPDialog.5.a[this.ad.ordinal()])
    {
    default:
    case 1:
    case 6:
    case 3:
    case 2:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      switch (GDPDialog.5.a[paramGDPState.ordinal()])
      {
      default:
        break;
      case 6:
        this.ad = paramGDPState;
        Z();
        R();
        continue;
        switch (GDPDialog.5.a[paramGDPState.ordinal()])
        {
        case 4:
        case 5:
        case 6:
        default:
          break;
        case 2:
          this.ad = paramGDPState;
          this.aj = ((String)paramObject);
          S();
          this.ay.a(GDPDialog.AnalyticsEventBuilder.a(this.ao, this.ar, Optional.fromNullable(this.at), this.au));
          break;
        case 3:
          this.an = ((Bundle)paramObject);
          this.ad = paramGDPState;
          T();
          break;
        case 7:
          this.ad = paramGDPState;
          if (paramObject == null)
          {
            g(AuthorizeAppResults.a("The user canceled the dialog before the permissions could be shown"));
            continue;
          }
          g((Bundle)paramObject);
          continue;
          switch (GDPDialog.5.a[paramGDPState.ordinal()])
          {
          default:
            break;
          case 6:
            this.ad = paramGDPState;
            Z();
            R();
            break;
          case 7:
            this.ad = paramGDPState;
            g(this.an);
            continue;
            switch (GDPDialog.5.a[paramGDPState.ordinal()])
            {
            case 5:
            case 6:
            default:
              break;
            case 4:
              this.ad = paramGDPState;
              aa();
              R();
              this.ay.a(GDPDialog.AnalyticsEventBuilder.a(true, this.au));
              break;
            case 7:
              this.ad = paramGDPState;
              g(AuthorizeAppResults.a());
              this.ay.a(GDPDialog.AnalyticsEventBuilder.a(false, this.au));
              continue;
              switch (GDPDialog.5.a[paramGDPState.ordinal()])
              {
              case 6:
              default:
                break;
              case 5:
                this.an = ((Bundle)paramObject);
                this.ad = paramGDPState;
                U();
                if (this.an != null);
                for (String str2 = this.an.getString("com.facebook.platform.status.ERROR_TYPE"); ; str2 = null)
                {
                  this.ay.a(GDPDialog.AnalyticsEventBuilder.a(false, Optional.fromNullable(str2), this.au));
                  break;
                }
              case 8:
                this.ad = paramGDPState;
                h((Bundle)paramObject);
                this.ay.a(GDPDialog.AnalyticsEventBuilder.a(true, Optional.absent(), this.au));
                break;
              case 7:
                this.ad = paramGDPState;
                if (paramObject == null);
                for (Bundle localBundle = AuthorizeAppResults.a("The user canceled the dialog before the app could be authorized"); ; localBundle = (Bundle)paramObject)
                {
                  g(localBundle);
                  String str1 = localBundle.getString("com.facebook.platform.status.ERROR_TYPE");
                  this.ay.a(GDPDialog.AnalyticsEventBuilder.a(false, Optional.fromNullable(str1), this.au));
                  break;
                }
                switch (GDPDialog.5.a[paramGDPState.ordinal()])
                {
                case 5:
                case 6:
                default:
                  break;
                case 4:
                  this.ad = paramGDPState;
                  aa();
                  R();
                  break;
                case 7:
                  this.ad = paramGDPState;
                  g(this.an);
                }
              }
            }
          }
        }
      }
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    M();
  }

  public void h()
  {
    BLog.b(Y, "onDestroyView");
    if ((c() != null) && (x()))
      c().setDismissMessage(null);
    super.h();
  }

  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
      W();
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPDialog
 * JD-Core Version:    0.6.0
 */