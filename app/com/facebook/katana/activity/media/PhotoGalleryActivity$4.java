package com.facebook.katana.activity.media;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.katana.service.method.PhotosGetLikesAndComments;
import com.facebook.katana.service.method.PhotosGetTagsByFBID;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import java.util.HashMap;
import java.util.Map;

class PhotoGalleryActivity$4
  implements AdapterView.OnItemSelectedListener
{
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PhotoGalleryActivity.a(this.a, paramLong);
    PhotoGalleryActivity.q(this.a).a(Long.valueOf(PhotoGalleryActivity.i(this.a)));
    PhotoGalleryActivity.q(this.a).a((String)PhotoGalleryActivity.m(this.a).get(Long.valueOf(PhotoGalleryActivity.i(this.a))));
    PhotoGalleryActivity.q(this.a).a(PhotoGalleryActivity.f(this.a).a(Long.valueOf(PhotoGalleryActivity.i(this.a))));
    PhotoGalleryActivity.a(this.a, null);
    PhotoGalleryActivity.r(this.a);
    PhotoGalleryActivity.s(this.a);
    PhotoGalleryActivity.t(this.a);
    String str = (String)PhotoGalleryActivity.m(this.a).get(Long.valueOf(paramLong));
    if (str != null);
    for (FetchFeedbackResult localFetchFeedbackResult = PhotoGalleryActivity.n(this.a).d(str); ; localFetchFeedbackResult = null)
    {
      FacebookPhotoTagSet localFacebookPhotoTagSet;
      if ((localFetchFeedbackResult != null) && (localFetchFeedbackResult.a != null))
      {
        PhotoGalleryActivity.a(this.a, localFetchFeedbackResult.a);
        localFacebookPhotoTagSet = (FacebookPhotoTagSet)PhotoGalleryActivity.j(this.a).get(Long.valueOf(paramLong));
        if (localFacebookPhotoTagSet != null)
          break label447;
        PhotosGetTagsByFBID.a(this.a, paramLong);
        PhotoGalleryActivity.a(this.a, new FacebookPhotoTagSet());
      }
      while (true)
      {
        PhotoGalleryActivity.v(this.a).clear();
        ((FrameLayout)this.a.findViewById(2131296475)).removeAllViews();
        if (PhotoGalleryActivity.k(this.a) == PhotoGalleryActivity.ViewMode.CONTROLS)
          PhotoGalleryActivity.l(this.a);
        PhotoGalleryActivity.w(this.a);
        PhotoGalleryActivity.x(this.a).a(new HoneyClientEvent(FB4A_AnalyticEntities.Actions.b).f(Long.toString(paramLong)).e(FB4A_AnalyticEntities.UIElementsTypes.a).d(this.a.a()));
        PhotoGalleryActivity.f(this.a).a(paramInt);
        PhotoGalleryActivity.f(this.a).a(paramInt + 1);
        PhotoGalleryActivity.f(this.a).a(paramInt - 1);
        return;
        PhotoGalleryActivity.FeedbackData localFeedbackData = (PhotoGalleryActivity.FeedbackData)PhotoGalleryActivity.h(this.a).get(Long.valueOf(paramLong));
        if (localFeedbackData == null)
        {
          PhotosGetLikesAndComments.a(this.a, PhotoGalleryActivity.i(this.a));
          PhotoGalleryActivity.u(this.a);
          break;
        }
        PhotoGalleryActivity.a(this.a, localFeedbackData.a, localFeedbackData.b);
        break;
        label447: PhotoGalleryActivity.a(this.a, localFacebookPhotoTagSet);
      }
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.4
 * JD-Core Version:    0.6.0
 */