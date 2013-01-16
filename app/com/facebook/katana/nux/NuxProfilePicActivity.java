package com.facebook.katana.nux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.common.util.Toaster;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.nux.model.NuxStepResult;
import com.facebook.katana.ui.TitleBar;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;

public class NuxProfilePicActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private SecureContextHelper n;
  private Button o;
  private Button p;

  private void j()
  {
    this.o.setOnClickListener(new NuxProfilePicActivity.1(this));
    this.p.setOnClickListener(new NuxProfilePicActivity.2(this));
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903308);
    this.n = ((SecureContextHelper)FbInjector.a(this).a(SecureContextHelper.class));
    this.o = ((Button)findViewById(2131297171));
    this.p = ((Button)findViewById(2131297172));
    ((TitleBar)findViewById(2131296299)).setPrimaryActionButton(TitleBarButtonSpec.newBuilder().b(getString(2131363188)).i());
    j();
  }

  public String i()
  {
    return getString(2131363120);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
    while (true)
    {
      return;
      if (paramInt2 == 1001)
      {
        Toaster.a(getApplicationContext(), getString(2131363127));
        continue;
      }
      String str = null;
      switch (paramInt1)
      {
      default:
      case 124:
      case 123:
        while (true)
        {
          if (str != null)
            break label160;
          Toaster.a(getApplicationContext(), getString(2131363127));
          break;
          ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("extra_media_items");
          if (localArrayList.isEmpty())
            break;
          str = ((MediaItem)localArrayList.get(0)).b();
          continue;
          Uri localUri = CameraActivity.j();
          str = null;
          if (localUri == null)
            continue;
          str = localUri.getPath();
        }
      case 125:
      }
      NuxStepsManager.a("upload_profile_pic", NuxStepResult.COMPLETE, getApplicationContext());
      finish();
      continue;
      label160: Intent localIntent = new Intent(getApplicationContext(), SetProfilePicActivity.class);
      localIntent.putExtra("image_uri", str);
      this.n.a(localIntent, 125, this);
    }
  }

  public void onBackPressed()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    this.n.b(localIntent, this);
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    NuxStepsManager.a("upload_profile_pic", NuxStepResult.SKIPPED, getApplicationContext());
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.NuxProfilePicActivity
 * JD-Core Version:    0.6.0
 */