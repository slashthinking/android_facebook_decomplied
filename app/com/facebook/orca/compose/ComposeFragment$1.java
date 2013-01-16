package com.facebook.orca.compose;

import android.content.res.Resources;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.common.ui.widgets.AnchorableToast.ToastType;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.photos.picking.PickMediaOperation.OnMediaPickedListener;

class ComposeFragment$1 extends PickMediaOperation.OnMediaPickedListener
{
  public void a()
  {
    ComposeFragment.a(this.a, ComposeFragment.a(this.a, this.a.q().getString(2131362540)), AnchorableToast.ToastType.WARNING);
  }

  public void a(MediaResource paramMediaResource)
  {
    MediaAttachment localMediaAttachment = ComposeFragment.a(this.a).b(paramMediaResource);
    if (paramMediaResource != null)
      ComposeFragment.a(this.a, localMediaAttachment);
  }

  public void b()
  {
  }

  public void c()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.1
 * JD-Core Version:    0.6.0
 */