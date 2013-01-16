package com.karmascience.gifts.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.views.CommonViewUtils;

public class BubblePopup
{
  private final Context a;
  private final PopupWindow b;
  private final View c;
  private final FrameLayout d;
  private final View e;
  private final View f;

  public BubblePopup(Context paramContext)
  {
    this.a = paramContext;
    this.b = new PopupWindow(this.a);
    this.c = View.inflate(this.a, 2130903077, null);
    this.d = ((FrameLayout)this.c.findViewById(2131296425));
    this.f = this.c.findViewById(2131296426);
    this.e = this.c.findViewById(2131296424);
    this.f.bringToFront();
    this.e.bringToFront();
    this.b.setTouchable(true);
    this.b.setFocusable(true);
    this.b.setOutsideTouchable(true);
    this.b.setBackgroundDrawable(new BitmapDrawable());
    this.b.setContentView(this.c);
  }

  public void a()
  {
    this.b.dismiss();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    View localView = ((Activity)this.a).getWindow().getDecorView();
    int i = localView.getWidth();
    int j = localView.getHeight();
    int k = (int)(paramFloat1 * i);
    int m = (int)(paramFloat2 * j);
    if (this.b.isShowing())
      this.b.update(k, m);
    while (true)
    {
      return;
      this.b.setWidth(k);
      this.b.setHeight(m);
    }
  }

  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    int n = m + j / 2;
    int i1 = k + i / 2;
    View localView = ((Activity)this.a).getWindow().getDecorView();
    int i2 = localView.getWidth();
    int i3 = localView.getHeight();
    int i4 = this.a.getResources().getDimensionPixelSize(2131230869);
    int i5;
    int i6;
    label120: int i7;
    label129: int i8;
    int i14;
    int i10;
    int i11;
    int i12;
    if (n > i3 / 2)
    {
      i5 = 1;
      if (i1 <= i2 / 2)
        break label281;
      i6 = 1;
      if (i5 == 0)
        break label287;
      i7 = m;
      i8 = this.a.getResources().getDimensionPixelOffset(2131230832);
      if (i5 == 0)
        break label326;
      this.e.setVisibility(8);
      if ((i6 == 0) && (paramBoolean))
        break label300;
      i14 = paramInt * i8;
      i10 = i3 - m;
      i11 = 83;
      i12 = i14;
    }
    while (true)
    {
      int i15 = k + i / 2 - i14 - i4 / 2;
      this.f.setPadding(i15, 0, 0, 0);
      this.b.showAtLocation(paramView, i11, i12, i10);
      this.b.update(i2, i7);
      ThreadingService localThreadingService = (ThreadingService)this.a.getSystemService("ks_threading_service");
      localThreadingService.a(new BubblePopup.3(this, paramBoolean, i2, localThreadingService));
      return;
      i5 = 0;
      break;
      label281: i6 = 0;
      break label120;
      label287: i7 = i3 - (m + j);
      break label129;
      label300: i12 = i2 - paramInt * i8;
      i10 = i3 - m;
      i11 = 85;
      i14 = 0;
    }
    label326: this.f.setVisibility(8);
    int i9;
    if ((i6 != 0) || (!paramBoolean))
    {
      i9 = paramInt * i8;
      i10 = m + j;
      i11 = 51;
      i12 = i9;
    }
    while (true)
    {
      int i13 = k + i / 2 - i9 - i4 / 2;
      this.e.setPadding(i13, 0, 0, 0);
      break;
      i12 = i2 - paramInt * i8;
      i10 = m + j;
      i11 = 53;
      i9 = 0;
    }
  }

  public void a(View paramView, boolean paramBoolean)
  {
    a(paramView, 1, paramBoolean);
  }

  public void a(String[] paramArrayOfString, int paramInt, BubblePopup.OnOptionClickedListener paramOnOptionClickedListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a);
    View localView1 = localLayoutInflater.inflate(2130903079, this.d, false);
    this.d.removeAllViews();
    this.d.addView(localView1);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131296430);
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      View localView2 = localLayoutInflater.inflate(2130903078, localLinearLayout, false);
      ((TextView)localView2.findViewById(2131296428)).setText(paramArrayOfString[i]);
      localView2.setOnClickListener(new BubblePopup.1(this, paramOnOptionClickedListener, i));
      if (i == paramInt)
        localView2.findViewById(2131296427).setVisibility(0);
      localLinearLayout.addView(localView2);
      if (i + 1 >= paramArrayOfString.length)
        continue;
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(2131230828));
      localLinearLayout.addView(CommonViewUtils.a(this.a, 2131165351, localLayoutParams1));
    }
    if (paramArrayOfString.length > 3)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, this.a.getResources().getDimensionPixelSize(2131230868));
      localView1.findViewById(2131296429).setLayoutParams(localLayoutParams);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.BubblePopup
 * JD-Core Version:    0.6.0
 */