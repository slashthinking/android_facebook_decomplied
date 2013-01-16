package com.facebook.katana.activity.composer;

import android.os.Handler;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;

class ComposerActivity$33 extends ClickableSpan
{
  public void onClick(View paramView)
  {
    this.a.openTimeSelector(null);
    this.a.n.setEnabled(false);
    ComposerActivity.z(this.a).postDelayed(new ComposerActivity.33.1(this), 500L);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.33
 * JD-Core Version:    0.6.0
 */