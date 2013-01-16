package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.ErrorReporting;
import java.util.Iterator;
import java.util.List;

public class GeoRegion
  implements JMStaticKeysDictDestination
{
  public static final long INVALID_ID = -1L;
  private static final String TAG = GeoRegion.class.getSimpleName();

  @JMAutogen.InferredType(jsonFieldName="abbr_name")
  public final String abbrName = null;

  @JMAutogen.InferredType(jsonFieldName="page_fbid")
  public final long id = -1L;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String type = null;

  public static GeoRegion.ImplicitLocation a(List<GeoRegion> paramList)
  {
    GeoRegion.ImplicitLocation localImplicitLocation = null;
    if (paramList == null)
      return localImplicitLocation;
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    String str1 = null;
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      GeoRegion localGeoRegion = (GeoRegion)localIterator.next();
      if (localGeoRegion.type == null)
      {
        ErrorReporting.a(TAG, "Unexpected GeoRegion value: abbrName=" + localGeoRegion.abbrName + ", id=" + localGeoRegion.id);
        continue;
      }
      if (localGeoRegion.type.equals(GeoRegion.Type.city.toString()))
      {
        String str2 = localGeoRegion.abbrName;
        Long localLong = Long.valueOf(localGeoRegion.id);
        localObject2 = str2;
        localObject1 = localLong;
        continue;
      }
      if (!localGeoRegion.type.equals(GeoRegion.Type.state.toString()))
        continue;
      str1 = localGeoRegion.abbrName;
    }
    if (localObject2 != null);
    while (true)
    {
      localImplicitLocation = null;
      if (localObject2 == null)
        break;
      localImplicitLocation = new GeoRegion.ImplicitLocation((String)localObject2, localObject1);
      break;
      if (str1 != null)
      {
        localObject2 = str1;
        continue;
      }
      localObject2 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.GeoRegion
 * JD-Core Version:    0.6.0
 */