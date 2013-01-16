package com.facebook.katana.activity.places;

import android.content.DialogInterface;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.service.method.PlacesCreate.HomePrivacyType;

class PlaceCreationActivity$PrivacyMenuOption extends AlertDialogs.MenuOption
{
  private PlacesCreate.HomePrivacyType b;

  public PlaceCreationActivity$PrivacyMenuOption(PlaceCreationActivity paramPlaceCreationActivity, PlacesCreate.HomePrivacyType paramHomePrivacyType)
  {
    this.b = paramHomePrivacyType;
  }

  public int a()
  {
    return this.b.nameResId;
  }

  public int b()
  {
    return this.b.iconResId;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PlaceCreationActivity.a(this.a, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity.PrivacyMenuOption
 * JD-Core Version:    0.6.0
 */