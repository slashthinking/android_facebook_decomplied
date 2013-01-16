package com.facebook.photos.photogallery.tags;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

class TaggedPhotoFragment$1
  implements TagsView.TagsViewListenerAdapter
{
  public void a(Tag paramTag)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.a.p()).create();
    localAlertDialog.setMessage("Tag clicked! User ID: " + paramTag.c());
    localAlertDialog.show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggedPhotoFragment.1
 * JD-Core Version:    0.6.0
 */