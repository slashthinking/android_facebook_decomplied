package com.facebook.feed.ui.footer;

import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;

class StoryFooterSection$1
  implements StoryInsightsFooterView.OnViewInsightsListener
{
  public void a(String paramString)
  {
    String str = StringUtil.a("fb://insights/story/%s", new Object[] { paramString });
    ((IFeedIntentBuilder)StoryFooterSection.b(this.a).a(IFeedIntentBuilder.class)).a(StoryFooterSection.a(this.a), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.StoryFooterSection.1
 * JD-Core Version:    0.6.0
 */