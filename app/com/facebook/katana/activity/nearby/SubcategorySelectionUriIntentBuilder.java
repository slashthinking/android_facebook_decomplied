package com.facebook.katana.activity.nearby;

import com.facebook.uri.UriIntentBuilder;

public class SubcategorySelectionUriIntentBuilder extends UriIntentBuilder
{
  public SubcategorySelectionUriIntentBuilder()
  {
    a("fb://nearby/subcategory", SubcategorySelectionActivity.class);
  }

  public boolean a()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.nearby.SubcategorySelectionUriIntentBuilder
 * JD-Core Version:    0.6.0
 */