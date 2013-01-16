package com.facebook.katana.service.method;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.util.List;

public class PlacesCreateException$ErrorData
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="reason")
  String mInvalidNameReason;

  @JMAutogen.ListType(b={PlacesCreateException.SimilarPlace.class}, jsonFieldName="similar_places")
  List<PlacesCreateException.SimilarPlace> mSimilarPlaces;

  @JMAutogen.InferredType(jsonFieldName="suggestion")
  String mSuggestedName;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreateException.ErrorData
 * JD-Core Version:    0.6.0
 */