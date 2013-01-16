package com.facebook.orca.common.ui.widgets.refreshablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RefreshableListViewItem extends FrameLayout
{
  private View a;
  private View b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private List<TextView> h;
  private RotateAnimation i;
  private RotateAnimation j;
  private RefreshableListViewState k;
  private int l = -1;

  public RefreshableListViewItem(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public RefreshableListViewItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public RefreshableListViewItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2130903394, this);
    this.a = findViewById(2131297408);
    this.b = findViewById(2131297416);
    this.d = ((TextView)findViewById(2131297412));
    this.e = ((TextView)findViewById(2131297414));
    this.f = ((TextView)findViewById(2131297413));
    TextView[] arrayOfTextView = new TextView[3];
    arrayOfTextView[0] = this.d;
    arrayOfTextView[1] = this.e;
    arrayOfTextView[2] = this.f;
    this.h = Arrays.asList(arrayOfTextView);
    this.g = ((TextView)findViewById(2131297415));
    this.c = ((ImageView)findViewById(2131297409));
    this.c.setMinimumHeight(50);
    this.i = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.i.setInterpolator(new LinearInterpolator());
    this.i.setDuration(250L);
    this.i.setFillAfter(true);
    this.j = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.j.setInterpolator(new LinearInterpolator());
    this.j.setDuration(250L);
    this.j.setFillAfter(true);
  }

  private void a(TextView paramTextView)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      TextView localTextView = (TextView)localIterator.next();
      if (localTextView == paramTextView)
        localTextView.setVisibility(0);
      else
        localTextView.setVisibility(4);
    }
  }

  public void setDirection(int paramInt)
  {
    if (paramInt == this.l);
    while (true)
    {
      return;
      this.l = paramInt;
    }
  }

  public void setLastLoadedTime(long paramLong)
  {
    if (paramLong >= 0L)
    {
      Context localContext = getContext();
      Date localDate = new Date(paramLong);
      String str = localContext.getString(2131362195, new Object[] { android.text.format.DateFormat.getDateFormat(localContext).format(localDate), android.text.format.DateFormat.getTimeFormat(localContext).format(localDate) });
      this.g.setText(str);
      this.g.setVisibility(0);
    }
    while (true)
    {
      return;
      this.g.setVisibility(8);
    }
  }

  public void setState(RefreshableListViewState paramRefreshableListViewState)
  {
    RefreshableListViewState localRefreshableListViewState = this.k;
    if ((localRefreshableListViewState == RefreshableListViewState.PULL_TO_REFRESH) && (paramRefreshableListViewState == RefreshableListViewState.RELEASE_TO_REFRESH))
    {
      a(this.e);
      this.c.setImageResource(2130838710);
      this.c.clearAnimation();
      this.c.startAnimation(this.i);
      if (paramRefreshableListViewState != RefreshableListViewState.LOADING)
        break label308;
      this.a.setVisibility(8);
      this.b.setVisibility(0);
    }
    while (true)
    {
      this.k = paramRefreshableListViewState;
      return;
      if ((localRefreshableListViewState == RefreshableListViewState.PUSH_TO_REFRESH) && (paramRefreshableListViewState == RefreshableListViewState.RELEASE_TO_REFRESH))
      {
        a(this.e);
        this.c.setImageResource(2130838710);
        this.c.clearAnimation();
        this.c.startAnimation(this.i);
        break;
      }
      if ((localRefreshableListViewState == RefreshableListViewState.RELEASE_TO_REFRESH) && (paramRefreshableListViewState == RefreshableListViewState.PULL_TO_REFRESH))
      {
        a(this.d);
        this.c.setImageResource(2130838710);
        this.c.clearAnimation();
        this.c.startAnimation(this.j);
        break;
      }
      if ((localRefreshableListViewState == RefreshableListViewState.RELEASE_TO_REFRESH) && (paramRefreshableListViewState == RefreshableListViewState.PUSH_TO_REFRESH))
      {
        a(this.f);
        this.c.setImageResource(2130838710);
        this.c.clearAnimation();
        this.c.startAnimation(this.j);
        break;
      }
      if (paramRefreshableListViewState == RefreshableListViewState.PULL_TO_REFRESH)
      {
        this.c.setImageResource(2130838710);
        a(this.d);
        this.c.clearAnimation();
        break;
      }
      if (paramRefreshableListViewState != RefreshableListViewState.PUSH_TO_REFRESH)
        break;
      this.c.setImageResource(2130838710);
      a(this.f);
      this.c.clearAnimation();
      break;
      label308: this.a.setVisibility(0);
      this.b.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewItem
 * JD-Core Version:    0.6.2
 */