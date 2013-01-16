package com.facebook.timeline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TimelineScrubberView extends RelativeLayout
{
  public TimelineScrubberView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TimelineScrubberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(int paramInt, CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(paramInt);
    if (localTextView != null)
    {
      if (paramCharSequence == null)
        break label28;
      localTextView.setVisibility(0);
      localTextView.setText(paramCharSequence);
    }
    while (true)
    {
      return;
      label28: localTextView.setVisibility(8);
    }
  }

  private void a(TimelineDataFetcher paramTimelineDataFetcher, String paramString, TimelineSectionData.Scrubber paramScrubber, TimelineAllSectionsData paramTimelineAllSectionsData)
  {
    View localView = findViewById(2131297911);
    if (paramScrubber.a);
    for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      a(2131297910, paramString);
      setOnClickListener(new TimelineScrubberView.1(this, paramScrubber, paramTimelineAllSectionsData, localView, paramTimelineDataFetcher));
      return;
    }
  }

  public void a(TimelineDataFetcher paramTimelineDataFetcher, TimelineSectionData.SeeMore paramSeeMore, TimelineAllSectionsData paramTimelineAllSectionsData)
  {
    a(paramTimelineDataFetcher, getContext().getString(2131361804), paramSeeMore, paramTimelineAllSectionsData);
  }

  public void a(TimelineDataFetcher paramTimelineDataFetcher, TimelineSectionData.TimelineSectionLabel paramTimelineSectionLabel, TimelineAllSectionsData paramTimelineAllSectionsData)
  {
    a(paramTimelineDataFetcher, paramTimelineSectionLabel.d, paramTimelineSectionLabel, paramTimelineAllSectionsData);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineScrubberView
 * JD-Core Version:    0.6.0
 */