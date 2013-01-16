package com.facebook.maps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class GoogleEmbeddableMapActivity extends MapActivity
{
  public static String a = "API_KEY";
  private FrameLayout b;
  private MapView c;
  private Activity d;

  public MapView a()
  {
    return this.c;
  }

  public boolean isRouteDisplayed()
  {
    return false;
  }

  public void onBackPressed()
  {
    this.d.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getParent();
    String str = getIntent().getExtras().getString(a);
    setContentView(2130903130);
    this.b = ((FrameLayout)findViewById(2131296643));
    this.c = new MapView(this, str);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.c.setLayoutParams(localLayoutParams);
    this.b.addView(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleEmbeddableMapActivity
 * JD-Core Version:    0.6.0
 */