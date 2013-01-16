package com.facebook.orca.images;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Builder;
import com.facebook.orca.media.MediaResource.Type;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.photos.picking.MediaChoiceDialog.ButtonOption;
import com.facebook.orca.photos.picking.PickMediaOperation;
import com.facebook.orca.photos.picking.PickMediaParams;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.ModifyThreadParamsBuilder;
import java.io.File;

public class ThreadIconPickerActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private FragmentManager n;
  private AnalyticsLogger o;
  private PickMediaOperation p;
  private OrcaServiceFragment q;
  private boolean r;
  private String s;
  private boolean t;

  private void a(File paramFile)
  {
    if (this.q.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      MediaResource localMediaResource = null;
      if (paramFile != null)
        localMediaResource = MediaResource.a().a(MediaResource.Type.PHOTO).a(Uri.fromFile(paramFile)).f();
      ModifyThreadParams localModifyThreadParams = new ModifyThreadParamsBuilder().a(this.s).b(true).a(localMediaResource).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("modifyThreadParams", localModifyThreadParams);
      this.q.a("modify_thread", localBundle);
      this.o.a(new HoneyClientEvent("set").d(a()).b("thread_id", this.s).e("thread_image"));
    }
  }

  private void i()
  {
    PickMediaParams localPickMediaParams = new PickMediaParams(false);
    localPickMediaParams.a(true).a(200).b(200).c(1).d(1).a(MediaChoiceDialog.ButtonOption.CAMERA).a(MediaChoiceDialog.ButtonOption.GALLERY).a(MediaChoiceDialog.ButtonOption.IMAGE_SEARCH);
    if (this.t)
      localPickMediaParams.a(MediaChoiceDialog.ButtonOption.REMOVE);
    this.p.a(localPickMediaParams);
  }

  public String a()
  {
    return "thread_icon";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = C();
    this.n = ((FragmentManager)localFbInjector.a(FragmentManager.class));
    this.o = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    Intent localIntent = getIntent();
    this.s = localIntent.getStringExtra("threadId");
    this.t = localIntent.getBooleanExtra("hasPictureHash", false);
    this.p = ((PickMediaOperation)this.n.a("pickMediaOperation"));
    if (this.p == null)
    {
      this.p = new PickMediaOperation();
      a("pickMediaOperation", this.p);
    }
    this.p.a(new ThreadIconPickerActivity.1(this));
    this.q = OrcaServiceFragment.a(this, "setPhotoOperation");
    this.q.a(new ThreadIconPickerActivity.2(this));
    this.q.a(new DialogBasedProgressIndicator(this, 2131362634));
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.r = paramBundle.getBoolean("showedDialog");
  }

  protected void onResume()
  {
    super.onResume();
    if (!this.r)
    {
      i();
      this.r = true;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("showedDialog", this.r);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ThreadIconPickerActivity
 * JD-Core Version:    0.6.0
 */