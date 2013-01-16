package com.facebook.katana;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ipc.katana.model.FacebookUser;

class RequestsAdapter$FriendRequest
{
  RequestsAdapter.RequestState a = RequestsAdapter.RequestState.NOT_RESPONDED;
  FacebookUser b;
  int c = -1;
  Bitmap d;
  View e;

  RequestsAdapter$FriendRequest(RequestsAdapter paramRequestsAdapter, FacebookUser paramFacebookUser)
  {
    this.b = paramFacebookUser;
  }

  RequestsAdapter.RequestState a()
  {
    return this.a;
  }

  void a(int paramInt)
  {
    this.c = paramInt;
    b();
  }

  void a(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    b();
  }

  void a(RequestsAdapter.RequestState paramRequestState)
  {
    this.a = paramRequestState;
    b();
  }

  void b()
  {
    monitorenter;
    Button localButton1;
    Button localButton2;
    TextView localTextView;
    label179: ImageView localImageView;
    while (true)
    {
      try
      {
        View localView = this.e;
        if (localView == null)
          return;
        this.e.setOnClickListener(new RequestsAdapter.FriendRequest.1(this));
        ((TextView)this.e.findViewById(2131297806)).setText(this.b.a());
        localButton1 = (Button)this.e.findViewById(2131297808);
        localButton2 = (Button)this.e.findViewById(2131297809);
        localTextView = (TextView)this.e.findViewById(2131297807);
        if (this.a != RequestsAdapter.RequestState.NOT_RESPONDED)
          break;
        localButton1.setVisibility(0);
        localButton2.setVisibility(0);
        localButton1.setOnClickListener(new RequestsAdapter.OnClick(this.f, this, true));
        localButton2.setOnClickListener(new RequestsAdapter.OnClick(this.f, this, false));
        this.e.setBackgroundResource(17170445);
        localTextView.setTextColor(2131165446);
        if (this.c == -1)
        {
          localTextView.setText("");
          localImageView = (ImageView)this.e.findViewById(2131297805);
          if (this.d == null)
            break label373;
          localImageView.setImageBitmap(this.d);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Resources localResources = RequestsAdapter.c(this.f).getResources();
      int j = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.c);
      localTextView.setText(localResources.getQuantityString(2131427359, j, arrayOfObject));
    }
    localButton1.setVisibility(4);
    localButton2.setVisibility(4);
    switch (RequestsAdapter.2.a[this.a.ordinal()])
    {
    case 3:
    case 4:
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      localTextView.setText(i);
      localTextView.setTextColor(2131165254);
      break label179;
      this.e.setBackgroundResource(2131165445);
      int i = 2131363131;
      continue;
      this.e.setBackgroundResource(2131165445);
      i = 2131363138;
      continue;
      label373: localImageView.setImageResource(2130838447);
      break;
      i = -1;
      continue;
      i = 2131363134;
      continue;
      i = 2131363139;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter.FriendRequest
 * JD-Core Version:    0.6.0
 */