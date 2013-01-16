package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R.styleable;
import com.facebook.widget.CustomViewStub;
import com.google.common.base.Preconditions;

public class TwoLineFeedbackViewStub extends CustomViewStub
{
  private TwoLineFeedbackView.FeedbackBarType b;

  public TwoLineFeedbackViewStub(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public TwoLineFeedbackViewStub(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TwoLineFeedbackViewStub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TwoLineFeedbackViewStub);
    int i = localTypedArray.getInt(0, -1);
    if (i == -1);
    for (TwoLineFeedbackView.FeedbackBarType localFeedbackBarType = TwoLineFeedbackView.FeedbackBarType.DEFAULT_STORY; ; localFeedbackBarType = TwoLineFeedbackView.a[i])
    {
      this.b = localFeedbackBarType;
      localTypedArray.recycle();
      return;
    }
  }

  protected View getInflatedLayout()
  {
    Preconditions.checkNotNull(this.b);
    return new TwoLineFeedbackView(this.a, null, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackViewStub
 * JD-Core Version:    0.6.0
 */