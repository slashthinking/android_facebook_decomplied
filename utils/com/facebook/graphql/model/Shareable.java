package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Shareable
  implements Parcelable
{
  public static final Parcelable.Creator<Shareable> CREATOR = new Shareable.1();
  public static Shareable a = new Shareable("0", GraphQLObjectType.ObjectType.Story);

  @JMAutogen.InferredType(jsonFieldName="id")
  @JsonProperty("id")
  public final String id;

  @JMAutogen.InferredType(jsonFieldName="__type__")
  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  protected Shareable()
  {
    this.id = null;
    this.type = null;
  }

  private Shareable(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.type = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.ObjectType.class.getClassLoader()));
  }

  public Shareable(String paramString, GraphQLObjectType.ObjectType paramObjectType)
  {
    if (paramObjectType != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.id = paramString;
      this.type = new GraphQLObjectType(paramObjectType);
      return;
    }
  }

  public Shareable(String paramString, GraphQLObjectType paramGraphQLObjectType)
  {
    this.id = paramString;
    this.type = paramGraphQLObjectType;
  }

  @JsonIgnore
  public boolean a()
  {
    if ((!StringUtil.a(this.id)) && (this.type != null) && (this.type.a() != null));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public GraphQLObjectType.ObjectType b()
  {
    if ((this.type == null) || (this.type.a() == null));
    for (GraphQLObjectType.ObjectType localObjectType = null; ; localObjectType = this.type.a())
      return localObjectType;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Shareable;
    boolean bool2 = false;
    if (bool1)
    {
      Shareable localShareable = (Shareable)paramObject;
      boolean bool3 = Objects.equal(this.id, localShareable.id);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(b(), localShareable.b());
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.id;
    arrayOfObject[1] = b();
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return "Shareable{id='" + this.id + '\'' + ", type=" + b() + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.type, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.Shareable
 * JD-Core Version:    0.6.2
 */