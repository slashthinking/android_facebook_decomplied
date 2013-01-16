package com.facebook.orca.nux;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.widget.HorizontalOrVerticalViewGroup;
import com.facebook.widget.HorizontalOrVerticalViewGroup.Mode;

public class NuxFindingContactsIntroView extends NuxPopover
{
  private TextView d;
  private HorizontalOrVerticalViewGroup e;
  private Button f;
  private Button g;
  private TextView h;

  public NuxFindingContactsIntroView(Context paramContext)
  {
    super(paramContext);
  }

  public NuxFindingContactsIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NuxFindingContactsIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a()
  {
    setContentView(2130903381);
    this.d = ((TextView)getView(2131297369));
    this.e = ((HorizontalOrVerticalViewGroup)getView(2131297373));
    this.f = ((Button)getView(2131297375));
    this.g = ((Button)getView(2131297374));
    this.h = ((TextView)getView(2131297372));
  }

  public void b()
  {
    d();
    this.h.setMovementMethod(LinkMovementMethod.getInstance());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.e.getMode() == HorizontalOrVerticalViewGroup.Mode.HORIZONTAL);
    for (int i = 2131492922; ; i = 2131492933)
    {
      this.d.setTextAppearance(getContext(), i);
      return;
    }
  }

  public void setBodyText(CharSequence paramCharSequence)
  {
    d();
    this.h.setText(paramCharSequence);
  }

  public void setLearnMoreLinkSpan(CustomUrlLikeSpan paramCustomUrlLikeSpan)
  {
    Resources localResources = getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(localResources.getString(2131362397));
    localStyledStringBuilder.a("[[learn_more_link]]", localResources.getString(2131362399), paramCustomUrlLikeSpan, 33);
    b();
    setBodyText(localStyledStringBuilder.b());
  }

  public void setOnFindContactsClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.f.setOnClickListener(paramOnClickListener);
  }

  public void setOnSkipClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.g.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxFindingContactsIntroView
 * JD-Core Version:    0.6.0
 */