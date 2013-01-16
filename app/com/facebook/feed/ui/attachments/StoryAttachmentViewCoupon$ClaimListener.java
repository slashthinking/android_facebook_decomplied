package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.feed.protocol.coupons.ClaimCouponParams;
import com.facebook.graphql.model.GraphQLCoupon;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.ListenableFuture;

class StoryAttachmentViewCoupon$ClaimListener
  implements View.OnTouchListener
{
  private GraphQLCoupon b;
  private String c;
  private String d;

  StoryAttachmentViewCoupon$ClaimListener(StoryAttachmentViewCoupon paramStoryAttachmentViewCoupon, GraphQLCoupon paramGraphQLCoupon, String paramString)
  {
    this.b = paramGraphQLCoupon;
    this.c = paramString;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (StoryAttachmentViewCoupon.a(this.a));
    while (true)
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      case 2:
      default:
        break;
      case 0:
        StoryAttachmentViewCoupon.b(this.a).setBackgroundDrawable(this.a.c.getResources().getDrawable(2130838189));
        break;
      case 1:
        StoryAttachmentViewCoupon.a(this.a, true);
        StoryAttachmentViewCoupon.b(this.a).setBackgroundDrawable(null);
        this.d = StoryAttachmentViewCoupon.c(this.a).getText().toString();
        StoryAttachmentViewCoupon.c(this.a).setText(2131362038);
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("claimCouponParams", new ClaimCouponParams(this.b.id, this.c));
        ListenableFuture localListenableFuture = ((OrcaServiceOperationFactory)StoryAttachmentViewCoupon.d(this.a).a(OrcaServiceOperationFactory.class)).a("claim_coupon", localBundle).d();
        ((AndroidThreadUtil)StoryAttachmentViewCoupon.g(this.a).a(AndroidThreadUtil.class)).a(localListenableFuture, new StoryAttachmentViewCoupon.ClaimListener.1(this));
        break;
      case 3:
        StoryAttachmentViewCoupon.b(this.a).setBackgroundDrawable(this.a.c.getResources().getDrawable(2130838188));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewCoupon.ClaimListener
 * JD-Core Version:    0.6.0
 */