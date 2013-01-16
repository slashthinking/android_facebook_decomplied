package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;

public class FeedbackLoggingParams
  implements Parcelable
{
  public static final Parcelable.Creator<FeedbackLoggingParams> CREATOR = new FeedbackLoggingParams.1();
  public final ArrayNode a;
  public final String b;

  public FeedbackLoggingParams(Parcel paramParcel)
  {
    try
    {
      JsonNode localJsonNode = new ObjectMapper().readTree(paramParcel.readString());
      this.a = ((ArrayNode)localJsonNode);
      this.b = paramParcel.readString();
      return;
    }
    catch (JsonProcessingException localJsonProcessingException)
    {
      throw new ParcelFormatException("Could not parse parcel " + localJsonProcessingException.toString());
    }
    catch (IOException localIOException)
    {
    }
    throw new ParcelFormatException("Could not parse parcel " + localIOException.toString());
  }

  public FeedbackLoggingParams(ArrayNode paramArrayNode, String paramString)
  {
    this.a = paramArrayNode;
    this.b = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      FeedbackLoggingParams localFeedbackLoggingParams = (FeedbackLoggingParams)paramObject;
      if (localFeedbackLoggingParams.a != this.a)
      {
        i = 0;
        continue;
      }
      if (localFeedbackLoggingParams.b == this.b)
        continue;
      i = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FeedbackLoggingParams
 * JD-Core Version:    0.6.0
 */