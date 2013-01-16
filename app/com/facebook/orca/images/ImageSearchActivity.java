package com.facebook.orca.images;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.TitlebarProgressProgressIndicator;
import com.facebook.widget.listview.EmptyListViewItem;
import java.util.ArrayList;
import java.util.List;

public class ImageSearchActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private String A;
  private int B = -1;
  private Bundle C;
  private String D;
  private int E = -1;
  private int F;
  private ImageSearchListAdapter n;
  private InputMethodManager o;
  private ImageCache p;
  private FbTitleBar q;
  private EditText r;
  private Button s;
  private GridView t;
  private RelativeLayout u;
  private TextView v;
  private TextView w;
  private TextView x;
  private EmptyListViewItem y;
  private OrcaServiceFragment z;

  private void a(String paramString, int paramInt)
  {
    if (this.z.a());
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("AppId", "E71A777BBC850CF326C995ECDA7AFA3577A5749F");
      localBundle.putString("Query", paramString);
      localBundle.putString("Sources", "Image");
      localBundle.putString("Version", "2.0");
      localBundle.putString("Market", "en-us");
      localBundle.putString("Adult", "Strict");
      localBundle.putString("Image.Count", "8");
      localBundle.putString("Image.Offset", Integer.toString(paramInt * 8));
      this.E = paramInt;
      this.D = paramString;
      this.z.a("image_search", localBundle);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.y.setVisibility(0);
      this.y.a(true);
      this.y.setMessage(getString(2131362659));
    }
  }

  private void b(boolean paramBoolean)
  {
    if (this.A == null);
    while (true)
    {
      return;
      if ((paramBoolean) && (this.B > 0))
      {
        a(this.A, -1 + this.B);
        continue;
      }
      if ((paramBoolean) || (this.B >= -1 + this.F))
        continue;
      a(this.A, 1 + this.B);
    }
  }

  private void c(int paramInt)
  {
    FetchImageParams localFetchImageParams = new FetchImageParams(Uri.parse(((Bundle)this.n.a(paramInt).getParcelable("Thumbnail")).getString("Url")));
    Uri localUri = this.p.a(localFetchImageParams.d());
    if (localUri != null)
    {
      Intent localIntent = new Intent();
      localIntent.setData(localUri);
      setResult(-1, localIntent);
      finish();
    }
  }

  private void c(Bundle paramBundle)
  {
    if (!d(paramBundle))
      j();
    while (true)
    {
      return;
      Bundle localBundle = (Bundle)paramBundle.getParcelable("SearchResponse");
      this.F = Math.min(((Bundle)localBundle.getParcelable("Image")).getInt("Total") / 8, 8);
      this.B = this.E;
      this.A = this.D;
      this.C = localBundle;
      this.E = -1;
      this.D = null;
      k();
    }
  }

  private boolean d(Bundle paramBundle)
  {
    Bundle localBundle1 = (Bundle)paramBundle.getParcelable("SearchResponse");
    int i;
    if (localBundle1 == null)
      i = 0;
    while (true)
    {
      return i;
      Bundle localBundle2 = (Bundle)localBundle1.getParcelable("Image");
      if (localBundle2 == null)
      {
        i = 0;
        continue;
      }
      if (localBundle2.getParcelableArrayList("Results") == null)
      {
        i = 0;
        continue;
      }
      i = 1;
    }
  }

  private void i()
  {
    String str = this.r.getText().toString();
    if (StringUtil.a(str));
    while (true)
    {
      return;
      if (!this.z.a())
      {
        a(str, 0);
        continue;
      }
    }
  }

  private void j()
  {
    this.E = -1;
    this.D = null;
    this.B = -1;
    this.A = null;
    this.C = null;
    this.y.a(false);
    this.y.setMessage(getString(2131362660));
    this.y.setVisibility(0);
    this.t.setVisibility(8);
  }

  private void k()
  {
    this.y.a(false);
    ArrayList localArrayList = ((Bundle)this.C.getParcelable("Image")).getParcelableArrayList("Results");
    if (localArrayList.size() == 0)
    {
      this.y.setVisibility(0);
      this.y.setMessage(getString(2131362661));
      this.u.setVisibility(8);
      this.t.setVisibility(8);
    }
    while (true)
    {
      return;
      this.t.setVisibility(0);
      this.y.setVisibility(8);
      this.n.a(localArrayList);
      if ((this.B != -1) && (this.F >= 2))
        break;
      this.u.setVisibility(8);
    }
    this.u.setVisibility(0);
    TextView localTextView1 = this.v;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(1 + this.B);
    arrayOfObject[1] = Integer.valueOf(this.F);
    localTextView1.setText(getString(2131362656, arrayOfObject));
    TextView localTextView2 = this.w;
    int i;
    label197: TextView localTextView3;
    int m;
    if (this.B > 0)
    {
      i = 0;
      localTextView2.setVisibility(i);
      localTextView3 = this.x;
      int j = this.B;
      int k = -1 + this.F;
      m = 0;
      if (j >= k)
        break label250;
    }
    while (true)
    {
      localTextView3.setVisibility(m);
      break;
      i = 4;
      break label197;
      label250: m = 4;
    }
  }

  public String a()
  {
    return "image_search";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903348);
    FbInjector localFbInjector = C();
    this.n = ((ImageSearchListAdapter)localFbInjector.a(ImageSearchListAdapter.class));
    this.o = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.p = ((ImageCache)localFbInjector.a(ImageCache.class));
    FbTitleBarUtil.a(this);
    this.q = ((FbTitleBar)f(2131296299));
    this.r = ((EditText)f(2131297297));
    this.s = ((Button)f(2131297298));
    this.t = ((GridView)f(2131297299));
    this.u = ((RelativeLayout)f(2131297301));
    this.v = ((TextView)f(2131297302));
    this.w = ((TextView)f(2131297303));
    this.x = ((TextView)f(2131297304));
    this.y = ((EmptyListViewItem)f(2131297300));
    this.s.setOnClickListener(new ImageSearchActivity.1(this));
    this.r.setOnEditorActionListener(new ImageSearchActivity.2(this));
    this.z = OrcaServiceFragment.a(this, "imageSearchOperation");
    this.z.a(new ImageSearchActivity.3(this));
    this.z.a(new TitlebarProgressProgressIndicator(this.q));
    this.w.setClickable(true);
    this.w.setOnClickListener(new ImageSearchActivity.4(this));
    this.x.setClickable(true);
    this.x.setOnClickListener(new ImageSearchActivity.5(this));
    this.t.setAdapter(this.n);
    this.t.setOnItemClickListener(new ImageSearchActivity.6(this));
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.A = paramBundle.getString("currentQuery");
    this.B = paramBundle.getInt("currentPage");
    this.C = paramBundle.getBundle("currentResponse");
    this.D = paramBundle.getString("loadingQuery");
    this.E = paramBundle.getInt("loadingPage");
    this.F = paramBundle.getInt("numPages");
    if (this.B >= 0)
      k();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("currentQuery", this.A);
    paramBundle.putInt("currentPage", this.B);
    paramBundle.putBundle("currentResponse", this.C);
    paramBundle.putString("loadingQuery", this.D);
    paramBundle.putInt("loadingPage", this.E);
    paramBundle.putInt("numPages", this.F);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchActivity
 * JD-Core Version:    0.6.0
 */