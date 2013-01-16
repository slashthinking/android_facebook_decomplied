package com.facebook.feed.ui.attachments;

import android.content.Context;
import com.facebook.orca.debug.BLog;

public class StoryAttachmentViewFactory
{
  private static final Class<?> a = StoryAttachmentViewFactory.class;

  public static Class<? extends StoryAttachmentView> a(StoryAttachmentView.StoryAttachmentViewType paramStoryAttachmentViewType)
  {
    Object localObject;
    switch (StoryAttachmentViewFactory.1.a[paramStoryAttachmentViewType.ordinal()])
    {
    default:
      localObject = StoryAttachmentViewBase.class;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return localObject;
      localObject = StoryAttachmentViewShare.class;
      continue;
      localObject = StoryAttachmentViewVideo.class;
      continue;
      localObject = StoryAttachmentViewPhoto.class;
      continue;
      localObject = StoryAttachmentViewAlbum.class;
      continue;
      localObject = StoryAttachmentViewList.class;
      continue;
      localObject = StoryAttachmentViewCoupon.class;
      continue;
      localObject = StorySubAttachmentViewBase.class;
      continue;
      localObject = StoryAttachmentViewAddFriend.class;
    }
  }

  public StoryAttachmentView a(Context paramContext, StoryAttachmentView.StoryAttachmentViewType paramStoryAttachmentViewType)
  {
    Object localObject;
    switch (StoryAttachmentViewFactory.1.a[paramStoryAttachmentViewType.ordinal()])
    {
    default:
      BLog.e(a, "Cannot construct the view type: " + paramStoryAttachmentViewType);
      localObject = null;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (true)
    {
      return localObject;
      localObject = new StoryAttachmentViewShare(paramContext);
      continue;
      localObject = new StoryAttachmentViewVideo(paramContext);
      continue;
      localObject = new StoryAttachmentViewPhoto(paramContext);
      continue;
      localObject = new StoryAttachmentViewAlbum(paramContext);
      continue;
      localObject = new StoryAttachmentViewList(paramContext);
      continue;
      localObject = new StoryAttachmentViewCoupon(paramContext);
      continue;
      localObject = new StorySubAttachmentViewBase(paramContext);
      continue;
      localObject = new StoryAttachmentViewAddFriend(paramContext);
      continue;
      localObject = new StoryAttachmentViewBase(paramContext);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewFactory
 * JD-Core Version:    0.6.0
 */