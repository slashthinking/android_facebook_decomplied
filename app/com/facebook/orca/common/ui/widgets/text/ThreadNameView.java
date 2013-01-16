package com.facebook.orca.common.ui.widgets.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R.styleable;
import com.facebook.orca.annotations.DefaultThreadNameViewComputer;
import com.facebook.orca.annotations.NamesOnlyThreadNameViewComputer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.widget.VariableTextLayoutComputer;
import com.facebook.widget.VariableTextLayoutView;

public class ThreadNameView extends VariableTextLayoutView<ThreadSummary>
{
  private ThreadNameViewComputer a;

  public ThreadNameView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ThreadNameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ThreadNameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ThreadNameView);
    int i = localTypedArray.getInteger(7, ThreadNameView.TextOptions.access$000(ThreadNameView.TextOptions.USE_THREAD_NAME_IF_AVAILABLE));
    localTypedArray.recycle();
    FbInjector localFbInjector = FbInjector.a(getContext());
    if (i == ThreadNameView.TextOptions.access$000(ThreadNameView.TextOptions.USE_THREAD_NAME_IF_AVAILABLE))
      this.a = ((ThreadNameViewComputer)localFbInjector.a(ThreadNameViewComputer.class, DefaultThreadNameViewComputer.class));
    while (true)
    {
      return;
      if (i == ThreadNameView.TextOptions.access$000(ThreadNameView.TextOptions.USE_PARTICIPANTS_NAMES_ONLY))
      {
        this.a = ((ThreadNameViewComputer)localFbInjector.a(ThreadNameViewComputer.class, NamesOnlyThreadNameViewComputer.class));
        continue;
      }
      this.a = ((ThreadNameViewComputer)localFbInjector.a(ThreadNameViewComputer.class, DefaultThreadNameViewComputer.class));
    }
  }

  protected VariableTextLayoutComputer<ThreadSummary> getVariableTextLayoutComputer()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.ThreadNameView
 * JD-Core Version:    0.6.0
 */