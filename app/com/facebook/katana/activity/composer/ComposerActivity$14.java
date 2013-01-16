package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.facebook.katana.features.composer.AudienceAdapter;
import com.facebook.katana.features.composer.AudienceOption;

class ComposerActivity$14
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ComposerActivity.b(this.a).b = true;
    int[] arrayOfInt1 = ComposerActivity.b(this.a).d(paramInt);
    int[] arrayOfInt2 = ComposerActivity.b(this.a).i();
    ComposerActivity.b(this.a).a(arrayOfInt1);
    if (arrayOfInt2 != null)
      ComposerActivity.b(this.a).j();
    paramView.findViewById(2131296490).setVisibility(0);
    this.a.r();
    ComposerActivity.v(this.a);
    if (!ComposerActivity.c(this.a, true))
      this.a.p();
    if ("friendlist".equals(this.a.getIntent().getStringExtra("publisher_type")))
      ((TextView)this.a.findViewById(2131296686)).setText(ComposerActivity.b(this.a).g().b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.14
 * JD-Core Version:    0.6.0
 */