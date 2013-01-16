package com.facebook.katana.activity.places;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.service.method.PlacesCreateException.SimilarPlace;
import java.util.List;

class PlaceCreationActivity$1$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PlaceCreationActivity.l(this.b.a).add(Long.valueOf(this.a.mId));
    PlaceCreationActivity.m(this.b.a);
    paramDialogInterface.dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity.1.2
 * JD-Core Version:    0.6.0
 */