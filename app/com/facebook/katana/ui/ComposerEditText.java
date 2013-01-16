package com.facebook.katana.ui;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.composer.ComposerActivity;
import com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView;

public class ComposerEditText extends MentionsAutoCompleteTextView
{
  protected static final Class<?> a = ComposerEditText.class;
  protected SurfaceView b;

  public ComposerEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new SurfaceView(paramContext);
    this.b.setId(2131296338);
    this.b.setVisibility(4);
    this.b.setZOrderOnTop(true);
    setDropDownAnchor(this.b.getId());
  }

  protected void a()
  {
    int i;
    Layout localLayout;
    if ((isShown()) && (!isPopupShowing()))
    {
      i = getSelectionStart();
      localLayout = getLayout();
      if (localLayout != null)
        break label29;
    }
    while (true)
    {
      return;
      label29: int j = localLayout.getLineForOffset(i);
      int k = localLayout.getLineBaseline(j) + localLayout.getLineAscent(j);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getLineHeight());
      localLayoutParams.topMargin = k;
      this.b.setLayoutParams(localLayoutParams);
      this.b.requestLayout();
    }
  }

  public void b(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    Assert.b("The wrapper of ComposerTextEdit must be put in a ScrollView", localViewGroup.getParent() instanceof ScrollView);
    localViewGroup.addView(this.b);
    super.b(paramActivity);
  }

  public void extendSelection(int paramInt)
  {
    super.extendSelection(Math.min(paramInt, ComposerActivity.a(getText())));
  }

  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int i = ComposerActivity.a(getText());
    if ((paramInt2 > i) || (paramInt1 > i))
      setSelection(paramInt1, paramInt2);
    while (true)
    {
      return;
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        setSelection(0, 0);
        continue;
      }
    }
  }

  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    a();
    super.performFiltering(paramCharSequence, paramInt);
  }

  public void setSelection(int paramInt)
  {
    super.setSelection(Math.min(paramInt, ComposerActivity.a(getText())));
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    int i = ComposerActivity.a(getText());
    super.setSelection(Math.min(paramInt1, i), Math.min(paramInt2, i));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ComposerEditText
 * JD-Core Version:    0.6.0
 */