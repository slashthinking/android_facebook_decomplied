package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLCoupon;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

class StoryAttachmentViewCoupon$ClaimListener$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    String str1 = this.a.a.getContext().getString(2131362093);
    StoryAttachmentViewCoupon.c(this.a.a).setText(str1);
    StoryAttachmentViewCoupon.c(this.a.a).setGravity(3);
    StoryAttachmentViewCoupon.c(this.a.a).setTextColor(this.a.a.getResources().getColor(2131165254));
    if (StoryAttachmentViewCoupon.ClaimListener.a(this.a).mobilePostClaimMessage != "");
    String str2;
    String str3;
    for (String str4 = StoryAttachmentViewCoupon.ClaimListener.a(this.a).mobilePostClaimMessage; ; str4 = this.a.a.getContext().getString(2131362094, new Object[] { str2, str3 }))
    {
      StoryAttachmentViewCoupon.e(this.a.a).setText(str4);
      StoryAttachmentViewCoupon.e(this.a.a).setVisibility(0);
      String str5 = this.a.a.getContext().getString(2131362095);
      StoryAttachmentViewCoupon.f(this.a.a).setText(str5);
      StoryAttachmentViewCoupon.f(this.a.a).setVisibility(0);
      StoryAttachmentViewCoupon.b(this.a.a).setBackgroundDrawable(new ColorDrawable(this.a.a.getResources().getColor(2131165288)));
      StoryAttachmentViewCoupon.ClaimListener.a(this.a).hasViewerClaimed = true;
      return;
      str2 = StoryAttachmentViewCoupon.ClaimListener.a(this.a).owningPage.name;
      str3 = new SimpleDateFormat("MM/dd/yyyy").format(new Date(1000L * StoryAttachmentViewCoupon.ClaimListener.a(this.a).expirationDate));
    }
  }

  public void a(Throwable paramThrowable)
  {
    StoryAttachmentViewCoupon.c(this.a.a).setText(StoryAttachmentViewCoupon.ClaimListener.b(this.a));
    StoryAttachmentViewCoupon.c(this.a.a).setTextColor(this.a.a.getResources().getColor(2131165265));
    StoryAttachmentViewCoupon.a(this.a.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewCoupon.ClaimListener.1
 * JD-Core Version:    0.6.0
 */