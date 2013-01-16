package com.facebook.ipc.model;

public enum PrivacySetting$Category
{
  static
  {
    places = new Category("places", 1);
    composer_sticky = new Category("composer_sticky", 2);
    Category[] arrayOfCategory = new Category[3];
    arrayOfCategory[0] = publisher;
    arrayOfCategory[1] = places;
    arrayOfCategory[2] = composer_sticky;
    $VALUES = arrayOfCategory;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.model.PrivacySetting.Category
 * JD-Core Version:    0.6.0
 */