package com.facebook.katana.activity.places;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.katana.util.StringUtils;

class SelectAtTagActivity$8
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)this.a.findViewById(2131297811);
    Intent localIntent = new Intent(this.a, PlaceCreationActivity.class);
    localIntent.putExtra("android.intent.extra.SUBJECT", StringUtils.e(localTextView.getText().toString().trim().toLowerCase()));
    if (SelectAtTagActivity.r(this.a) != null)
      localIntent.putExtra("preset_search_location", SelectAtTagActivity.r(this.a));
    this.a.startActivityForResult(localIntent, 1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.8
 * JD-Core Version:    0.6.0
 */