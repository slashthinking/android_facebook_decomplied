package com.facebook.composer.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import com.facebook.composer.protocol.PublishPostParams.PublishType;
import com.facebook.composer.protocol.PublishPostParamsBuilder;
import com.facebook.composer.protocol.SimplePhotoUploadParams;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.media.MediaResource;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;

public class ComposerSimpleActivity extends FbFragmentActivity
{
  private FbTitleBar n;
  private EditText o;
  private MediaResource p;
  private MediaAttachmentFactory q;
  private MediaAttachmentUtil r;

  private void i()
  {
    FbTitleBarUtil.a(this);
    this.n = ((FbTitleBar)f(2131296299));
    TitleBarButtonSpec localTitleBarButtonSpec = TitleBarButtonSpec.newBuilder().a(1).b(getResources().getString(2131361964)).i();
    this.n.setButtonSpecs(ImmutableList.a(localTitleBarButtonSpec));
    this.n.setOnToolbarButtonListener(new ComposerSimpleActivity.1(this));
  }

  private void j()
  {
    String str = getIntent().getStringExtra("extra_actor_profile_pic_uri");
    if (str != null)
      ((UrlImage)findViewById(2131296511)).setImageParams(Uri.parse(str));
  }

  private void k()
  {
    this.p = ((MediaResource)getIntent().getParcelableExtra("extra_photo_resource"));
    if (this.p == null);
    while (true)
    {
      return;
      this.q = ((MediaAttachmentFactory)C().a(MediaAttachmentFactory.class));
      this.r = ((MediaAttachmentUtil)C().a(MediaAttachmentUtil.class));
      MediaAttachment localMediaAttachment = this.q.b(this.p);
      int i = SizeUtil.a(this, 76.0F);
      Bitmap localBitmap = this.r.a(localMediaAttachment, i);
      if (localBitmap != null)
      {
        ImageView localImageView = (ImageView)f(2131296514);
        localImageView.setImageBitmap(localBitmap);
        localImageView.setVisibility(0);
      }
    }
  }

  private void l()
  {
    String str1 = this.o.getText().toString();
    if ((str1.length() == 0) && (this.p == null));
    while (true)
    {
      return;
      Intent localIntent1 = getIntent();
      long l1 = localIntent1.getLongExtra(ComposerConstants.e, ComposerConstants.g);
      long l2 = localIntent1.getLongExtra(ComposerConstants.f, ComposerConstants.g);
      String str2 = localIntent1.getStringExtra(ComposerConstants.d);
      PublishPostParamsBuilder localPublishPostParamsBuilder = new PublishPostParamsBuilder().d(str2).b(str1).a(l1).b(l2);
      Intent localIntent2 = new Intent();
      if (this.p != null)
      {
        localPublishPostParamsBuilder.a(PublishPostParams.PublishType.PHOTO);
        localIntent2.putExtra("simplePhotoUploadParams", new SimplePhotoUploadParams(l1, this.p.c().getPath(), str1));
        localIntent2.putExtra("is_uploading_media", true);
      }
      localIntent2.putExtra("publishPostParams", localPublishPostParamsBuilder.a());
      setResult(-1, localIntent2);
      finish();
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903104);
    i();
    j();
    k();
    this.o = ((EditText)findViewById(2131296513));
    this.o.requestFocus();
    getWindow().setSoftInputMode(4);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ui.ComposerSimpleActivity
 * JD-Core Version:    0.6.2
 */