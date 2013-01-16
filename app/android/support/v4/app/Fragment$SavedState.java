package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fragment$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Fragment.SavedState.1();
  final Bundle a;

  Fragment$SavedState(Bundle paramBundle)
  {
    this.a = paramBundle;
  }

  Fragment$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.a = paramParcel.readBundle();
    if ((paramClassLoader != null) && (this.a != null))
      this.a.setClassLoader(paramClassLoader);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment.SavedState
 * JD-Core Version:    0.6.0
 */