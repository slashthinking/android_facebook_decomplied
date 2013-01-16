package com.facebook.feed.ui.location;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import java.util.List;

public class StoryLocationViewMore extends StoryLocationView
{
  private final Context b;
  private final TextView c;
  private FlyoutAnimationHandler d;

  public StoryLocationViewMore(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryLocationViewMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903178);
    this.b = paramContext;
    this.d = ((FlyoutAnimationHandler)getInjector().a(FlyoutAnimationHandler.class));
    this.c = ((TextView)b(2131296808));
  }

  public void a(List<GraphQLProfile> paramList)
  {
    int i = paramList.size() - (-1 + FeedUtils.a(this.b));
    TextView localTextView = this.c;
    Context localContext = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    localTextView.setText(localContext.getString(2131362124, arrayOfObject));
    if (paramList.size() > 9)
      this.c.setTextSize(0, this.b.getResources().getDimensionPixelSize(2131230773));
    while (true)
    {
      setOnClickListener(new StoryLocationViewMore.1(this, paramList));
      return;
      this.c.setTextSize(0, this.b.getResources().getDimensionPixelSize(2131230774));
    }
  }

  public int getRecyclableViewType()
  {
    return StoryLocationView.StoryLocationViewType.MORE.ordinal();
  }

  public StoryLocationView.StoryLocationViewType getViewType()
  {
    return StoryLocationView.StoryLocationViewType.MORE;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationViewMore
 * JD-Core Version:    0.6.0
 */