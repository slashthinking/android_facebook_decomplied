package com.facebook.katana.features;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchAppLoggedOutSettingsMethod$Result
  implements Parcelable
{

  @JsonProperty("registration_mode")
  public final String registrationMode = FetchAppLoggedOutSettingsMethod.Mode.MSITE.toString();

  @JsonProperty("registration_path")
  public final String registrationPath = "/r.php";

  public String a()
  {
    if (this.registrationPath.startsWith("/"));
    for (String str = this.registrationPath.substring(1); ; str = this.registrationPath)
      return str;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.FetchAppLoggedOutSettingsMethod.Result
 * JD-Core Version:    0.6.0
 */