package com.facebook.katana.activity.places;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.places.Geolocations;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.method.PageTopicsGet;
import com.facebook.katana.service.method.PlacesCreate;
import com.facebook.katana.service.method.PlacesCreate.HomePrivacyType;
import com.facebook.katana.service.method.PlacesCreate.PlaceTagType;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragmentFactory;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.MapImage;
import java.util.ArrayList;
import java.util.List;

public class PlaceCreationActivity extends BaseFacebookActivity
  implements AnalyticsActivity, NotNewNavEnabled
{
  private static final Class<?> n = PlaceCreationActivity.class;
  private static String o;
  private static String p;
  private static final Boolean q = Boolean.valueOf(false);
  private MapFragment A = null;
  private ImageView B;
  private MapImage C;
  private TextView D;
  private boolean E = false;
  private String F = null;
  private EditText G;
  private EditText H;
  private EditText I;
  private EditText J;
  private PlacesCreate.HomePrivacyType K;
  private PlacesCreate.HomePrivacyType L = PlacesCreate.HomePrivacyType.FRIENDS;
  private String M;
  private Location N;
  private String O = "";
  private String P = "";
  private AppSessionListener Q = new PlaceCreationActivity.1(this);
  private FBLocationManager.FBLocationListener R = new PlaceCreationActivity.2(this);
  private AppSession r;
  private Location s;
  private Location t;
  private PlaceCreationActivity.State u;
  private PlacesCreate.PlaceTagType v;
  private DialogFragment x;
  private List<Long> y;
  private List<Long> z;

  private void a(long paramLong, String paramString)
  {
    FacebookPlace localFacebookPlace = new FacebookPlace(paramLong, paramString, null, 0.0D, 0.0D, 0, null);
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_place", localFacebookPlace);
    setResult(-1, localIntent);
    finish();
  }

  private void a(Location paramLocation)
  {
    if ((this.O.equals(p())) && (this.P.equals(o())))
      this.M = Geolocations.a(this, paramLocation);
  }

  private void a(PlacesCreate.HomePrivacyType paramHomePrivacyType)
  {
    this.K = paramHomePrivacyType;
    this.J.setText(getString(this.K.nameResId));
    this.J.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.K.iconResId, 0);
  }

  private void k()
  {
    AlertDialogs.MenuOption[] arrayOfMenuOption = new AlertDialogs.MenuOption[3];
    arrayOfMenuOption[0] = new PlaceCreationActivity.PrivacyMenuOption(this, PlacesCreate.HomePrivacyType.PUBLIC);
    arrayOfMenuOption[1] = new PlaceCreationActivity.PrivacyMenuOption(this, PlacesCreate.HomePrivacyType.FRIENDS);
    arrayOfMenuOption[2] = new PlaceCreationActivity.PrivacyMenuOption(this, PlacesCreate.HomePrivacyType.ONLY_ME);
    AlertDialog localAlertDialog = AlertDialogs.a(this, 2131363303, arrayOfMenuOption, false);
    localAlertDialog.setCanceledOnTouchOutside(true);
    localAlertDialog.show();
  }

  private void l()
  {
    startActivityForResult(new Intent(this, SelectPageTopicActivity.class), 1);
  }

  private void m()
  {
    if ((this.N == null) && ((!FBLocationManager.b(this)) || (this.s == null)))
      Toaster.a(this, 2131363308);
    while (true)
    {
      return;
      if (this.u != PlaceCreationActivity.State.PROCESSING)
      {
        if (this.y.isEmpty())
        {
          Toaster.a(this, 2131363309, 17);
          continue;
        }
        String str = n();
        if (str.length() == 0)
          continue;
        this.x = ProgressDialogFragment.a(2131362850, true, false);
        this.x.a(g(), null);
        this.u = PlaceCreationActivity.State.PROCESSING;
        if (this.E)
          this.s = this.A.a();
        if (this.v == PlacesCreate.PlaceTagType.PLACE)
        {
          this.F = PlacesCreate.a(this, str, this.s, this.y, p(), o(), this.z);
          continue;
        }
        if (this.v != PlacesCreate.PlaceTagType.RESIDENCE)
          continue;
        this.F = PlacesCreate.a(this, str, this.s, this.y, p(), o(), this.K, this.z);
        continue;
      }
    }
  }

  private String n()
  {
    return this.G.getText().toString();
  }

  private String o()
  {
    return this.H.getText().toString();
  }

  private String p()
  {
    return this.I.getText().toString();
  }

  private void q()
  {
    MapFragmentFactory localMapFragmentFactory = (MapFragmentFactory)FbInjector.a(this).a(MapFragmentFactory.class);
    if (localMapFragmentFactory.a())
    {
      this.A = localMapFragmentFactory.a(true);
      this.A.b(true);
      FragmentTransaction localFragmentTransaction = g().a();
      localFragmentTransaction.a(2131297687, this.A);
      localFragmentTransaction.a();
      if (this.N != null)
      {
        this.A.a(this.N);
        this.B.setVisibility(0);
        this.A.a(new PlaceCreationActivity.5(this));
      }
    }
    while (true)
    {
      return;
      this.A.b(true);
      break;
      this.C = ((MapImage)findViewById(2131297686));
      findViewById(2131297687).setVisibility(8);
      this.C.setVisibility(0);
      if (this.N == null)
        continue;
      this.C.setCenter(this.N);
      this.C.a(this.N);
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.r;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903491);
    p = getString(2131363283);
    o = getString(2131363284);
    this.v = PlacesCreate.PlaceTagType.PLACE;
    this.I = ((EditText)findViewById(2131297680));
    this.H = ((EditText)findViewById(2131297679));
    this.G = ((EditText)findViewById(2131297116));
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("android.intent.extra.SUBJECT"))
    {
      CharSequence localCharSequence = localIntent.getCharSequenceExtra("android.intent.extra.SUBJECT");
      this.G.setText(localCharSequence);
    }
    if (getIntent().hasExtra("preset_search_location"))
    {
      this.N = ((Location)getIntent().getParcelableExtra("preset_search_location"));
      this.s = this.N;
    }
    this.B = ((ImageView)findViewById(2131297677));
    q();
    this.z = new ArrayList();
    this.y = new ArrayList();
    this.D = ((TextView)findViewById(2131297678));
    this.D.setOnClickListener(new PlaceCreationActivity.3(this));
    this.J = ((EditText)findViewById(2131297682));
    this.J.setOnClickListener(new PlaceCreationActivity.4(this));
    a(this.L);
    if (Build.VERSION.SDK_INT < 14)
    {
      this.D.setBackgroundResource(17301508);
      this.J.setBackgroundResource(17301508);
    }
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362847)).i());
    if (!UserValuesManager.a(this, "places:has_created_place_before"))
    {
      UserValuesManager.a(this, "places:has_created_place_before", "true");
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setMessage(getString(2131363305));
      localBuilder.setPositiveButton(2131361888, null);
      localBuilder.show();
    }
    PageTopicsGet.c(this);
  }

  public String i()
  {
    return getString(2131363283);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        break;
      case 1:
        if ((paramInt2 != -1) || (!paramIntent.hasExtra("object")))
          continue;
        this.y.clear();
        PageTopic localPageTopic = (PageTopic)paramIntent.getParcelableExtra("object");
        this.y.add(Long.valueOf(localPageTopic.id));
        this.D.setText(localPageTopic.displayName);
        if ((localPageTopic.id != 197289820310880L) || (!q.booleanValue()))
        {
          this.v = PlacesCreate.PlaceTagType.PLACE;
          continue;
        }
        this.v = PlacesCreate.PlaceTagType.RESIDENCE;
        if (UserValuesManager.a(this, "places:has_created_home_before"))
          continue;
        UserValuesManager.a(this, "places:has_created_home_before", "true");
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setMessage(getString(2131363304));
        localBuilder.setPositiveButton(2131361888, null);
        localBuilder.show();
      }
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.A == null)
      this.C.setCenter(this.s);
  }

  protected void onPause()
  {
    super.onPause();
    this.r.b(this.Q);
    FBLocationManager.a(this.R);
  }

  public void onResume()
  {
    super.onResume();
    this.r = AppSession.b(this, true);
    if (this.r == null)
    {
      Log.a(n, "Invalid session");
      finish();
      return;
    }
    this.r.a(this.Q);
    if ((!this.E) && (this.N == null))
      FBLocationManager.a(this, this.R);
    TextView localTextView = (TextView)findViewById(2131296686);
    switch (PlaceCreationActivity.6.a[this.v.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      a(this.s);
      break;
      localTextView.setText(p);
      findViewById(2131297681).setVisibility(8);
      continue;
      localTextView.setText(o);
      findViewById(2131297681).setVisibility(0);
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    m();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity
 * JD-Core Version:    0.6.0
 */