package com.facebook.katana.activity.composer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.common.collect.Lists;
import java.util.ArrayList;

class ComposerActivity$26
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArrayList localArrayList = Lists.a();
    this.a.setResult(0, new Intent().putParcelableArrayListExtra("extra_media_items", localArrayList));
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.26
 * JD-Core Version:    0.6.0
 */