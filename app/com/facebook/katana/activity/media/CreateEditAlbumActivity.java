package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.facebook.common.util.Toaster;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import java.util.List;

public class CreateEditAlbumActivity extends BaseFacebookActivity
{
  private AppSession n;
  private AppSessionListener o;
  private FacebookAlbum p;
  private String q;
  private String r;

  private static int a(String paramString)
  {
    int i;
    if (paramString.equals("everyone"))
      i = 0;
    while (true)
    {
      return i;
      if (paramString.equals("networks"))
      {
        i = 1;
        continue;
      }
      if (paramString.equals("friends-of-friends"))
      {
        i = 2;
        continue;
      }
      if (paramString.equals("friends"))
      {
        i = 3;
        continue;
      }
      if (!paramString.equals("custom"))
        break;
      i = 4;
    }
    throw new IllegalArgumentException("Invalid visibility: " + paramString);
  }

  private static String c(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Invalid position: " + paramInt);
    case 0:
      str = "everyone";
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return str;
      str = "networks";
      continue;
      str = "friends-of-friends";
      continue;
      str = "friends";
      continue;
      str = "custom";
    }
  }

  private void i()
  {
    String str1 = ((TextView)findViewById(2131296357)).getText().toString().trim();
    if (str1.length() == 0)
      Toaster.a(this, 2131362903);
    while (true)
    {
      return;
      String str2 = ((TextView)findViewById(2131296619)).getText().toString().trim();
      if (str2.length() == 0)
        str2 = null;
      String str3 = ((TextView)findViewById(2131296618)).getText().toString().trim();
      if (str3.length() == 0)
        str3 = null;
      String str4 = c(((Spinner)findViewById(2131296621)).getSelectedItemPosition());
      this.q = this.n.a(this, str1, str2, str3, str4);
      showDialog(1);
    }
  }

  private void j()
  {
    if (!m())
      Toaster.a(this, 2131362905);
    while (true)
    {
      return;
      String str1 = ((TextView)findViewById(2131296357)).getText().toString().trim();
      if (str1.length() == 0)
      {
        Toaster.a(this, 2131362903);
        continue;
      }
      String str2 = ((TextView)findViewById(2131296619)).getText().toString().trim();
      String str3 = ((TextView)findViewById(2131296618)).getText().toString().trim();
      if (str2.length() == 0)
        str2 = " ";
      if (str3.length() == 0)
        str3 = " ";
      String str4 = c(((Spinner)findViewById(2131296621)).getSelectedItemPosition());
      this.r = this.n.a(this, this.p.a(), str1, str2, str3, str4);
      showDialog(2);
    }
  }

  private boolean k()
  {
    if (getIntent().getAction().equals("android.intent.action.EDIT"));
    for (boolean bool = m(); ; bool = l())
      return bool;
  }

  private boolean l()
  {
    int i;
    if (((TextView)findViewById(2131296357)).getText().length() > 0)
      i = 1;
    while (true)
    {
      return i;
      if (((TextView)findViewById(2131296618)).getText().length() > 0)
      {
        i = 1;
        continue;
      }
      if (((TextView)findViewById(2131296619)).getText().length() > 0)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  private boolean m()
  {
    String str1 = ((TextView)findViewById(2131296357)).getText().toString();
    String str2;
    int i;
    if (this.p.d() != null)
    {
      str2 = this.p.d();
      if (str1.equals(str2))
        break label54;
      i = 1;
    }
    while (true)
    {
      return i;
      str2 = "";
      break;
      label54: String str3 = ((TextView)findViewById(2131296619)).getText().toString();
      if (this.p.h() != null);
      for (String str4 = this.p.h(); ; str4 = "")
      {
        if (str3.equals(str4))
          break label111;
        i = 1;
        break;
      }
      label111: String str5 = ((TextView)findViewById(2131296618)).getText().toString();
      if (this.p.g() != null);
      for (String str6 = this.p.g(); ; str6 = "")
      {
        if (str5.equals(str6))
          break label170;
        i = 1;
        break;
      }
      label170: if (!c(((Spinner)findViewById(2131296621)).getSelectedItemPosition()).equals(this.p.j()))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public void a(Bundle paramBundle)
  {
    int i = 1;
    super.a(paramBundle);
    setContentView(2130903125);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    localArrayAdapter.add(getString(2131363053));
    localArrayAdapter.add(getString(2131363055));
    localArrayAdapter.add(getString(2131363054));
    localArrayAdapter.add(getString(2131363056));
    label255: Spinner localSpinner;
    if (getIntent().getAction().equals("android.intent.action.EDIT"))
    {
      ((TextView)findViewById(2131296663)).setText(2131362900);
      ((TextView)findViewById(2131296664)).setText(2131362898);
      if (((String)getIntent().getData().getPathSegments().get(i)).equals("fbid"))
      {
        this.p = FacebookAlbum.a(this, FacebookPhotoSet.b((String)getIntent().getData().getPathSegments().get(2)).longValue());
        ((TextView)findViewById(2131296357)).setText(this.p.d());
        ((TextView)findViewById(2131296619)).setText(this.p.h());
        ((TextView)findViewById(2131296618)).setText(this.p.g());
        if (this.p.j().equals("custom"))
          localArrayAdapter.add(getString(2131363059));
        localSpinner = (Spinner)findViewById(2131296621);
        localSpinner.setAdapter(localArrayAdapter);
        localSpinner.setPrompt(getString(2131362906));
        if (i == 0)
          break label400;
        localSpinner.setSelection(a(this.p.j()));
      }
    }
    while (true)
    {
      a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
      this.o = new CreateEditAlbumActivity.CreateEditAlbumAppSessionListener(this, null);
      return;
      this.p = FacebookAlbum.a(this, (String)getIntent().getData().getPathSegments().get(2));
      break;
      ((TextView)findViewById(2131296663)).setText(2131362893);
      ((TextView)findViewById(2131296664)).setText(2131362891);
      i = 0;
      break label255;
      label400: localSpinner.setSelection(a("friends"));
    }
  }

  public void onBackPressed()
  {
    if (k())
      showDialog(3);
    while (true)
    {
      return;
      super.onBackPressed();
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
      while (true)
      {
        return localObject;
        localObject = new ProgressDialog(this);
        ((ProgressDialog)localObject).setProgressStyle(0);
        ((ProgressDialog)localObject).setMessage(getText(2131362894));
        ((ProgressDialog)localObject).setIndeterminate(true);
        ((ProgressDialog)localObject).setCancelable(false);
        continue;
        localObject = new ProgressDialog(this);
        ((ProgressDialog)localObject).setProgressStyle(0);
        ((ProgressDialog)localObject).setMessage(getText(2131362901));
        ((ProgressDialog)localObject).setIndeterminate(true);
        ((ProgressDialog)localObject).setCancelable(false);
      }
    case 3:
    }
    CreateEditAlbumActivity.1 local1 = new CreateEditAlbumActivity.1(this);
    if (getIntent().getAction().equals("android.intent.action.EDIT"));
    for (int i = 2131362820; ; i = 2131362815)
    {
      localObject = AlertDialogs.a(this, getString(i), 17301543, getString(2131362907), getString(2131363280), local1, getString(2131363016), null, null, true);
      break;
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.n != null)
      this.n.b(this.o);
  }

  protected void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    if ((this.q != null) && (!this.n.a(this.q)))
    {
      removeDialog(1);
      this.q = null;
    }
    if ((this.r != null) && (!this.n.a(this.r)))
    {
      removeDialog(2);
      this.r = null;
    }
    this.n.a(this.o);
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (k())
      if ("android.intent.action.EDIT".equals(getIntent().getAction()))
        j();
    while (true)
    {
      return;
      i();
      continue;
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CreateEditAlbumActivity
 * JD-Core Version:    0.6.0
 */