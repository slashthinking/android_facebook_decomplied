package com.facebook.katana.features.faceweb;

import android.util.Base64;
import com.facebook.common.json.jsonmirror.JMAutogen.EscapedObjectType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.ErrorReporting;
import com.facebook.debug.Assert;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FacewebComponentsStore
  implements JMStaticKeysDictDestination, Serializable
{
  private static final Class<?> CLSTAG = FacewebComponentsStore.class;
  private static final String COMPONENTS = "components";
  private static final String COMPONENTS_ID = "componentsId";
  private static final String CONTINUE_SEARCH = "continueSearch";
  private static final String METHOD = "method";
  private static final String PARAMETERS = "parameters";
  private static final String PARAMS = "params";
  private static final String PATH = "path";
  private static final String RULES = "rules";
  private static final String TAG = CLSTAG.getSimpleName();
  private static final String VERSION = "version";
  private static final JsonFactory sJsonFactory = new JsonFactory();
  private static final long serialVersionUID = 6103150430480349539L;

  @JMAutogen.EscapedObjectType(jsonFieldName="components")
  FacewebComponentsStore.Skeleton mSkeleton;

  @JMAutogen.InferredType(jsonFieldName="version")
  String mVersion;

  public static FacewebComponentsStore a(JsonParser paramJsonParser)
  {
    return (FacewebComponentsStore)JMParser.a(paramJsonParser, FacewebComponentsStore.class);
  }

  public static FacewebComponentsStore b(String paramString)
  {
    if (paramString == null)
      throw new IOException("Cannot deserialize FacewebComponentStore from a null String");
    try
    {
      FacewebComponentsStore localFacewebComponentsStore = (FacewebComponentsStore)new FacewebComponentsStore.LiberalDeserializer(new GZIPInputStream(new ByteArrayInputStream(Base64.decode(paramString, 0)))).readObject();
      return localFacewebComponentsStore;
    }
    catch (IOException localIOException)
    {
      ErrorReporting.a("FacewebComponentStore", "Failed to deserialize", localIOException);
      throw localIOException;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ErrorReporting.a("FacewebComponentsStore", "Failed to deserialize", localClassNotFoundException);
    }
    throw new IOException("Could not deserialize FacewebComponentStore, class not found", localClassNotFoundException);
  }

  public static FacewebComponentsStore parse(String paramString)
  {
    return a(sJsonFactory.createJsonParser(paramString));
  }

  public String a()
  {
    return this.mVersion;
  }

  public List<FacewebComponentsStore.FacewebSkeletonPalCall> a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.mSkeleton == null);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      Assert.a(FacewebComponentsStore.Skeleton.a(this.mSkeleton));
      Iterator localIterator = FacewebComponentsStore.Skeleton.a(this.mSkeleton).iterator();
      FacewebComponentsStore.FacewebComponentsRule localFacewebComponentsRule;
      do
      {
        do
        {
          if (!localIterator.hasNext())
            break;
          localFacewebComponentsRule = (FacewebComponentsStore.FacewebComponentsRule)localIterator.next();
        }
        while (!localFacewebComponentsRule.a(paramString));
        localArrayList1.addAll((List)FacewebComponentsStore.Skeleton.b(this.mSkeleton).get(FacewebComponentsStore.FacewebComponentsRule.a(localFacewebComponentsRule)));
      }
      while (FacewebComponentsStore.FacewebComponentsRule.b(localFacewebComponentsRule));
    }
  }

  public String b()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new GZIPOutputStream(localByteArrayOutputStream));
      localObjectOutputStream.writeObject(this);
      localObjectOutputStream.close();
      String str = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
      return str;
    }
    catch (IOException localIOException)
    {
      ErrorReporting.a("FacewebComponentStore", "Failed to serialize", localIOException);
    }
    throw localIOException;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebComponentsStore
 * JD-Core Version:    0.6.0
 */