package com.facebook.katana.activity.places;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.Toaster;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.places.SelectAtTagFetcher;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.features.places.SelectAtTagFetcher.SelectAtTagArgType;
import com.facebook.katana.model.GeoRegion;
import com.facebook.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.katana.service.MediaUploadService;
import com.facebook.katana.service.method.FqlGetAtTags;
import com.facebook.katana.ui.ExpandableHeaderListView;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.katana.util.LocationSources;
import com.facebook.katana.util.LocationSources.LocationSourcesDialogFragment;
import com.facebook.katana.util.LocationSources.MessageType;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.Utils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragmentFactory;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.MapImage;
import java.util.ArrayList;
import java.util.List;

public class SelectAtTagActivity extends BaseFacebookListActivity
  implements TextWatcher, AnalyticsSubModuleActivity, NotNewNavEnabled
{
  private static FacebookPlace Y = null;
  private MapFragment A = null;
  private MapImage B;
  private View C;
  private View D;
  private View E;
  private TextView F;
  private View G;
  private TextView H;
  private Button I;
  private DialogFragment J;
  private Location K;
  private String L = "";
  private Location M;
  private Location N;
  private String O;
  private int P;
  private final Handler Q = new Handler();
  private Runnable R;
  private Runnable S;
  private boolean T = false;
  private boolean U = false;
  private DialogFragment V;
  private String W = null;
  private String X = null;
  private Storage Z;
  private AppSessionListener aa = new SelectAtTagActivity.1(this);
  private FBLocationManager.FBLocationListener ab = new SelectAtTagActivity.2(this);
  private AppSession n;
  private SelectAtTagAdapter o;
  private boolean p;
  private SelectAtTagFetcher.SearchType q;
  private Location r;
  private long s;
  private GeoRegion.ImplicitLocation t;
  private FacebookPlace u;
  private String v;
  private String y = "";
  private View z;

  private EditText A()
  {
    return (EditText)findViewById(2131297811);
  }

  private void B()
  {
    this.o = new SelectAtTagAdapter(this, new ArrayList());
    a(this.o);
  }

  private void E()
  {
    a(TitleBarButtonSpec.newBuilder().b(2130837740).i());
    Button localButton = (Button)findViewById(2131297825);
    localButton.setText(2131363345);
    localButton.setOnClickListener(new SelectAtTagActivity.10(this));
  }

  private void F()
  {
    if (this.J != null)
    {
      this.J.a();
      this.J = null;
    }
  }

  private void G()
  {
    if (this.R != null)
    {
      this.Q.removeCallbacks(this.R);
      this.R = null;
    }
  }

  private void H()
  {
    ListView localListView = m();
    if (localListView.getFirstVisiblePosition() < localListView.getHeaderViewsCount())
      this.Q.post(new SelectAtTagActivity.12(this, localListView));
  }

  private void I()
  {
    this.F.setVisibility(0);
    this.F.setText(2131363298);
    LocationSources.MessageType localMessageType = LocationSources.a(this, false);
    if (localMessageType == null)
      this.G.setVisibility(8);
    while (true)
    {
      this.E.setVisibility(8);
      return;
      this.G.setVisibility(0);
      this.H.setText(localMessageType.messageResId);
    }
  }

  private void J()
  {
    this.F.setVisibility(0);
    if (StringUtils.c(this.y))
      this.F.setText(2131363321);
    while (true)
    {
      this.G.setVisibility(8);
      this.E.setVisibility(8);
      return;
      this.F.setText(2131363320);
    }
  }

  private void K()
  {
    this.F.setVisibility(8);
    this.G.setVisibility(8);
    this.E.setVisibility(0);
  }

  private void L()
  {
    EditText localEditText = (EditText)findViewById(2131297811);
    if ((localEditText != null) && (localEditText.getText().length() > 0))
      localEditText.setText("");
  }

  private Location M()
  {
    if (this.r != null);
    for (Location localLocation = this.r; ; localLocation = this.M)
      return localLocation;
  }

  private boolean N()
  {
    if (this.r == null);
    for (int i = 1; ; i = 0)
      return i;
  }

  private static Drawable a(Drawable paramDrawable)
  {
    paramDrawable.setBounds(-paramDrawable.getIntrinsicWidth() / 2, -paramDrawable.getIntrinsicHeight(), paramDrawable.getIntrinsicWidth() / 2, 0);
    return paramDrawable;
  }

  private void a(Location paramLocation, String paramString)
  {
    if (this.T);
    while (true)
    {
      return;
      if ((paramLocation == null) && (StringUtils.c(paramString)))
      {
        b(null);
        continue;
      }
      if ((SelectAtTagFetcher.a(paramLocation, this.K)) && (StringUtils.a(paramString, this.L)) && ((this.o.getCount() != 0) || (this.O != null)))
        continue;
      q();
      this.K = paramLocation;
      this.L = paramString;
      if (StringUtils.c(paramString))
      {
        FqlGetAtTags localFqlGetAtTags = SelectAtTagFetcher.a(this, new SelectAtTagFetcher.SelectAtTagArgType(paramLocation, paramString, this.q, this.s));
        if (localFqlGetAtTags != null)
        {
          if (this.p)
            c(localFqlGetAtTags.h());
          b(localFqlGetAtTags.g());
          this.N = paramLocation;
          this.O = null;
          c(false);
          continue;
        }
        this.O = "MDS_PENDING_REQUEST_ID";
        c(true);
        continue;
      }
      p();
      c(true);
    }
  }

  private void a(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }

  private static void a(View paramView, float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }

  private void a(FacebookPlace paramFacebookPlace)
  {
    if (this.p)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_place", paramFacebookPlace);
      if (this.N != null)
        localIntent.putExtra("extra_nearby_location", this.N);
      if (this.t != null)
        localIntent.putExtra("extra_implicit_location", this.t);
      setResult(-1, localIntent);
      L();
      finish();
    }
    while (true)
    {
      return;
      if (paramFacebookPlace != null)
      {
        ApplicationUtils.a(this, paramFacebookPlace);
        continue;
      }
    }
  }

  private void a(FacebookPlace paramFacebookPlace, View paramView, boolean paramBoolean)
  {
    this.o.a(paramFacebookPlace, paramBoolean);
    ((CheckBox)paramView.findViewById(2131297821)).setChecked(paramBoolean);
    if (paramBoolean);
    for (int i = 0; ; i = 2131165496)
    {
      paramView.setBackgroundResource(i);
      return;
    }
  }

  private void a(String paramString)
  {
    ((TextView)this.z.findViewById(2131296346)).setText(paramString);
  }

  private boolean a(Location paramLocation)
  {
    if ((paramLocation != null) && (paramLocation.hasAccuracy()) && (paramLocation.getAccuracy() < 250.0F));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(List<FacebookPlace> paramList)
  {
    boolean bool = paramList.isEmpty();
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      int j = m().getFooterViewsCount();
      i = 0;
      if (j != 0)
        continue;
      i = 1;
    }
  }

  private void b(String paramString)
  {
    ((TextView)this.C.findViewById(2131297045)).setText(paramString);
  }

  private void b(List<FacebookPlace> paramList)
  {
    View localView;
    if (paramList == null)
    {
      paramList = new ArrayList();
      I();
      localView = getWindow().getCurrentFocus();
      this.o.a(paramList);
      if (!a(paramList))
        break label101;
      if (m().getFooterViewsCount() == 0)
        m().addFooterView(this.D, null, false);
    }
    while (true)
    {
      c(false);
      this.o.notifyDataSetChanged();
      if (localView != null)
        localView.requestFocus();
      return;
      if (!paramList.isEmpty())
        break;
      J();
      break;
      label101: if (m().getFooterViewsCount() <= 0)
        continue;
      m().removeFooterView(this.D);
    }
  }

  private void c(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      this.y = paramBundle.getString("search_text");
      A().setText(this.y);
      afterTextChanged(A().getEditableText());
    }
  }

  private void c(List<GeoRegion> paramList)
  {
    if ((paramList != null) && (SelectAtTagFetcher.SearchType.EVENT != this.q))
    {
      this.t = GeoRegion.a(paramList);
      if (this.t != null)
      {
        EditText localEditText = A();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.t.a;
        localEditText.setHint(getString(2131363330, arrayOfObject2));
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = StringUtils.e(this.y.trim().toLowerCase());
        arrayOfObject3[1] = this.t.a;
        a(getString(2131363282, arrayOfObject3));
      }
    }
    else
    {
      if (this.q != SelectAtTagFetcher.SearchType.CHECKIN)
        break label168;
    }
    while (true)
    {
      return;
      A().setHint(2131363329);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = StringUtils.e(this.y.trim().toLowerCase());
      a(getString(2131363281, arrayOfObject1));
      break;
      label168: if (this.T)
        continue;
      e(false);
    }
  }

  private Bundle d(Bundle paramBundle)
  {
    paramBundle.putString("search_text", this.y);
    return paramBundle;
  }

  private void d(boolean paramBoolean)
  {
    if (SelectAtTagFetcher.SearchType.EVENT == this.q);
    while (true)
    {
      return;
      if ((paramBoolean) || (StringUtils.c(this.y)) || ((this.r == null) && (!a(this.M))))
      {
        if (m().getFooterViewsCount() <= 0)
          continue;
        m().removeFooterView(this.z);
        continue;
      }
      if (m().getFooterViewsCount() == 0)
        m().addFooterView(this.z, null, false);
      if (this.t == null)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = StringUtils.e(this.y.trim().toLowerCase());
        a(getString(2131363281, arrayOfObject2));
        continue;
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = StringUtils.e(this.y.trim().toLowerCase());
      arrayOfObject1[1] = this.t.a;
      a(getString(2131363282, arrayOfObject1));
    }
  }

  private void e(boolean paramBoolean)
  {
    String str;
    if (this.u != null)
    {
      Assert.b(this.v);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.u.mName;
      str = getString(2131362972, arrayOfObject);
    }
    while (true)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131297824);
      if ((paramBoolean) || (str == null))
        localLinearLayout.setVisibility(8);
      while (true)
      {
        return;
        if (this.v != null)
        {
          Assert.b(this.u);
          str = this.v;
          break;
        }
        if ((this.t == null) || (this.q == SelectAtTagFetcher.SearchType.CHECKIN) || (this.q == SelectAtTagFetcher.SearchType.EVENT))
          break label153;
        str = this.t.a;
        break;
        ((TextView)findViewById(2131297826)).setText(str);
        localLinearLayout.setVisibility(0);
        localLinearLayout.bringToFront();
      }
      label153: str = null;
    }
  }

  private void o()
  {
    if (SelectAtTagFetcher.SearchType.EVENT != this.q);
    while (true)
    {
      return;
      if (StringUtils.c(this.y))
      {
        if (m().getFooterViewsCount() <= 1)
          continue;
        m().removeFooterView(this.C);
        continue;
      }
      if (m().getFooterViewsCount() == 0)
        m().addFooterView(this.C, null, false);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = StringUtils.e(this.y.trim().toLowerCase());
      b(getString(2131363360, arrayOfObject));
    }
  }

  private void p()
  {
    this.O = this.n.a(this, this.K, this.L, this.q, this.s, null);
  }

  private void q()
  {
    if ((this.O != null) && (!"MDS_PENDING_REQUEST_ID".equals(this.O)))
    {
      this.n.d(this, this.O);
      this.O = null;
      c(false);
    }
  }

  private void r()
  {
    this.T = true;
    d(true);
    this.o.a(true);
    ((ImageButton)findViewById(2131296342)).setSelected(true);
    EditText localEditText = (EditText)findViewById(2131297811);
    localEditText.setFocusable(false);
    localEditText.setFocusableInTouchMode(false);
    a(localEditText, 0.5F);
    ((Button)findViewById(2131297825)).setVisibility(0);
    e(true);
    Utils.b(this);
  }

  private void s()
  {
    this.T = false;
    d(false);
    this.o.a(false);
    a(M(), this.y);
    ((ImageButton)findViewById(2131296342)).setSelected(false);
    EditText localEditText = (EditText)findViewById(2131297811);
    localEditText.setFocusable(true);
    localEditText.setFocusableInTouchMode(true);
    a(localEditText, 1.0F);
    ((Button)findViewById(2131297825)).setVisibility(8);
    e(false);
  }

  private void z()
  {
    setContentView(2130903546);
    ExpandableHeaderListView localExpandableHeaderListView = (ExpandableHeaderListView)m();
    View localView1 = getLayoutInflater().inflate(2130903493, localExpandableHeaderListView, false);
    localExpandableHeaderListView.addHeaderView(localView1, null, false);
    View localView2 = localView1.findViewById(2131297687);
    MapFragmentFactory localMapFragmentFactory = (MapFragmentFactory)FbInjector.a(this).a(MapFragmentFactory.class);
    if (localMapFragmentFactory.a())
    {
      FragmentTransaction localFragmentTransaction = g().a();
      this.A = localMapFragmentFactory.a(true);
      if (this.r == null)
      {
        this.A.a(17.0D);
        this.A.b(true);
        this.A.a(false);
        localFragmentTransaction.a(2131297687, this.A);
        localFragmentTransaction.a();
        label137: localExpandableHeaderListView.addHeaderView(getLayoutInflater().inflate(2130903544, localExpandableHeaderListView, false), null, false);
        findViewById(2131297827).setOnClickListener(new SelectAtTagActivity.4(this));
        EditText localEditText = A();
        localEditText.setHint(2131363329);
        localEditText.setText(this.L);
        localEditText.setOnFocusChangeListener(new SelectAtTagActivity.5(this));
        localExpandableHeaderListView.setOnScrollListener(new SelectAtTagActivity.6(this));
        if (SelectAtTagFetcher.SearchType.EVENT != this.q)
          break label508;
        this.C = getLayoutInflater().inflate(2130903262, localExpandableHeaderListView, false);
        this.C.setOnClickListener(new SelectAtTagActivity.7(this));
      }
    }
    while (true)
    {
      this.D = getLayoutInflater().inflate(2130903543, localExpandableHeaderListView, false);
      this.E = this.D.findViewById(2131297817);
      this.F = ((TextView)this.D.findViewById(2131297816));
      this.G = this.D.findViewById(2131297818);
      this.H = ((TextView)this.G.findViewById(2131297819));
      this.I = ((Button)this.G.findViewById(2131297820));
      this.I.setOnClickListener(new SelectAtTagActivity.9(this));
      localExpandableHeaderListView.setEmptyView(null);
      return;
      this.A.a(this.r.getLatitude(), this.r.getLongitude(), (BitmapDrawable)a(getResources().getDrawable(2130838660)));
      this.A.a(this.r);
      this.A.a(17.0D);
      this.A.a(false);
      break;
      localView2.setVisibility(8);
      this.B = ((MapImage)localView1.findViewById(2131297686));
      this.B.setVisibility(0);
      if (this.r == null)
        break label137;
      this.B.setCenter(this.r);
      this.B.a(this.r);
      break label137;
      label508: this.z = getLayoutInflater().inflate(2130903041, localExpandableHeaderListView, false);
      this.z.setOnClickListener(new SelectAtTagActivity.8(this));
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.q;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.Z = ((Storage)C().a(Storage.class));
    this.n = AppSession.a(this, true);
    this.p = getIntent().getBooleanExtra("launched_for_place", false);
    if (getIntent().hasExtra("search_type"))
      this.q = ((SelectAtTagFetcher.SearchType)getIntent().getSerializableExtra("search_type"));
    if (getIntent().hasExtra("preset_search_location"))
      this.r = ((Location)getIntent().getParcelableExtra("preset_search_location"));
    if (getIntent().hasExtra("preset_search_time"))
      this.s = getIntent().getLongExtra("preset_search_time", 0L);
    z();
    if ((this.p) && (this.q != SelectAtTagFetcher.SearchType.CHECKIN))
    {
      a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
      this.u = ((FacebookPlace)getIntent().getParcelableExtra("extra_place"));
      this.v = getIntent().getStringExtra("extra_location_text");
      if (this.v != null)
      {
        this.y = this.v;
        A().setText(this.v);
        getWindow().setSoftInputMode(2);
      }
    }
    while (true)
    {
      B();
      E();
      c(paramBundle);
      return;
      A().setText(this.L);
      break;
      getWindow().setSoftInputMode(4);
    }
  }

  protected boolean a(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if ((this.T) || (this.o.a(paramListView, paramInt)))
      i = 0;
    while (true)
    {
      return i;
      ListView localListView = m();
      int j = this.o.b(localListView, paramInt);
      FacebookPlace localFacebookPlace = (FacebookPlace)this.o.getItem(j);
      if (localFacebookPlace.c() != null)
      {
        i = 0;
        continue;
      }
      localListView.performHapticFeedback(0, 2);
      r();
      a(localFacebookPlace, paramView, true);
      i = 1;
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
    String str;
    if (paramEditable == null)
    {
      str = "";
      this.y = str;
      if (this.o != null)
        break label28;
    }
    while (true)
    {
      return;
      str = paramEditable.toString();
      break;
      label28: o();
      d(false);
      if (this.S != null)
        this.Q.removeCallbacks(this.S);
      this.S = new SelectAtTagActivity.3(this);
      this.Q.postDelayed(this.S, 300L);
    }
  }

  protected void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    int i = this.o.b(m(), paramInt);
    FacebookPlace localFacebookPlace = (FacebookPlace)this.o.getItem(i);
    boolean bool;
    if (this.T)
      if (localFacebookPlace.c() == null)
      {
        if (this.o.a(localFacebookPlace))
          break label68;
        bool = true;
        a(localFacebookPlace, paramView, bool);
      }
    while (true)
    {
      return;
      label68: bool = false;
      break;
      a(localFacebookPlace);
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  protected void c(boolean paramBoolean)
  {
    if (this.o.getCount() > 0)
      t().a(paramBoolean);
    while (true)
    {
      return;
      if (paramBoolean)
      {
        K();
        continue;
      }
    }
  }

  public String i()
  {
    return getString(2131363301);
  }

  public void j()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_xed_location", true);
    setResult(-1, localIntent);
    finish();
  }

  public void k()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_location_text", StringUtils.e(this.y.trim().toLowerCase()));
    setResult(-1, localIntent);
    finish();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
      a((FacebookPlace)paramIntent.getParcelableExtra("extra_place"));
    while (true)
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 2))
      {
        Toaster.a(this, 2131363353);
        s();
        continue;
      }
      if (paramInt1 != 3)
        continue;
      if (paramInt2 != 1)
      {
        if (paramInt2 == 0)
          continue;
        Toaster.a(this, 2131363359);
        continue;
      }
      this.U = true;
      Uri localUri = paramIntent.getData();
      String str = this.Z.a(localUri, getContentResolver());
      if (str == null)
      {
        Toaster.a(this, 2131363359);
        continue;
      }
      Toaster.a(this, 2131363361);
      MediaUploadService.a(this, str, Y);
      Y = null;
    }
  }

  public void onBackPressed()
  {
    if (this.T)
      s();
    while (true)
    {
      return;
      super.onBackPressed();
    }
  }

  protected void onPause()
  {
    F();
    G();
    super.onPause();
    this.n.b(this.aa);
    A().removeTextChangedListener(this);
    FBLocationManager.a(this.ab);
  }

  protected void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    getWindow().setSoftInputMode(3);
    this.n.a(this.aa);
    A().addTextChangedListener(this);
    if (N())
      if (LocationSources.a(this))
      {
        if (this.R == null)
          this.R = new SelectAtTagActivity.11(this);
        this.Q.postDelayed(this.R, 15000L);
        FBLocationManager.a(this, this.ab);
        K();
      }
    while (true)
    {
      c(null);
      return;
      a(null, this.L);
      this.J = LocationSources.LocationSourcesDialogFragment.b(this);
      if (this.J == null)
        continue;
      this.J.a(g(), "location_sources_fragment");
      continue;
      a(M(), this.L);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    F();
    G();
    super.onSaveInstanceState(paramBundle);
    d(paramBundle);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (this.T)
      s();
    while (true)
    {
      return;
      r();
      H();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity
 * JD-Core Version:    0.6.0
 */