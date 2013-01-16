package com.facebook.feed.ui.footer;

import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;

public class UFIParams
{
  private int a;
  private int b;
  private int c;
  private int d;
  private float[] e;
  private float[] f;

  public UFIParams(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 3);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.e = new float[paramArrayOfInt.length];
      this.f = new float[paramArrayOfInt.length];
      int j = Ints.a(paramArrayOfInt);
      int k = paramArrayOfInt.length;
      for (int m = 0; m < k; m++)
      {
        int i3 = paramArrayOfInt[m];
        if (i3 <= 0)
          continue;
        this.a += paramInt1 + (j + (paramInt1 + (paramInt1 + paramInt2)));
        this.b += paramInt1 + (i3 + (paramInt1 + (paramInt1 + paramInt2)));
        this.c += paramInt1 + (paramInt1 + j);
        this.d += paramInt1 + (i3 + paramInt1);
      }
    }
    this.b = Math.max(1, this.b);
    this.d = Math.max(1, this.d);
    if (i < paramArrayOfInt.length)
    {
      int n = paramArrayOfInt[i];
      if (n > 0)
      {
        int i1 = paramInt1 + paramInt2;
        int i2 = paramInt1 + (n + paramInt1);
        this.e[i] = ((i1 + i2) / this.b);
        this.f[i] = (i2 / this.d);
      }
      while (true)
      {
        i++;
        break;
        this.e[i] = 1.0F;
        this.f[i] = 1.0F;
      }
    }
  }

  public void a(int paramInt, FeedbackCustomPressStateButton paramFeedbackCustomPressStateButton1, FeedbackCustomPressStateButton paramFeedbackCustomPressStateButton2, FeedbackCustomPressStateButton paramFeedbackCustomPressStateButton3)
  {
    int i;
    int j;
    if (this.a < paramInt)
    {
      i = 1;
      j = 1;
    }
    while (true)
    {
      if (j != 0)
      {
        paramFeedbackCustomPressStateButton1.getIcon().setVisibility(0);
        paramFeedbackCustomPressStateButton2.getIcon().setVisibility(0);
        paramFeedbackCustomPressStateButton3.getIcon().setVisibility(0);
        label44: if (i == 0)
          break label149;
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton1.getLayoutParams()).weight = 1.0F;
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton2.getLayoutParams()).weight = 1.0F;
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton3.getLayoutParams()).weight = 1.0F;
      }
      while (true)
      {
        return;
        if (this.b < paramInt)
        {
          j = 1;
          i = 0;
          break;
        }
        if (this.c >= paramInt)
          break label258;
        i = 1;
        j = 0;
        break;
        paramFeedbackCustomPressStateButton1.getIcon().setVisibility(8);
        paramFeedbackCustomPressStateButton2.getIcon().setVisibility(8);
        paramFeedbackCustomPressStateButton3.getIcon().setVisibility(8);
        break label44;
        label149: if (j != 0)
        {
          ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton1.getLayoutParams()).weight = this.e[0];
          ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton2.getLayoutParams()).weight = this.e[1];
          ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton3.getLayoutParams()).weight = this.e[2];
          continue;
        }
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton1.getLayoutParams()).weight = this.f[0];
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton2.getLayoutParams()).weight = this.f[1];
        ((LinearLayout.LayoutParams)paramFeedbackCustomPressStateButton3.getLayoutParams()).weight = this.f[2];
      }
      label258: i = 0;
      j = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.UFIParams
 * JD-Core Version:    0.6.0
 */