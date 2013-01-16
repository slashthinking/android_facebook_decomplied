package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadataCollection
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private List<Phonemetadata.PhoneMetadata> metadata_ = new ArrayList();

  public static Phonemetadata.PhoneMetadataCollection.Builder newBuilder()
  {
    return new Phonemetadata.PhoneMetadataCollection.Builder();
  }

  public int getMetadataCount()
  {
    return this.metadata_.size();
  }

  public List<Phonemetadata.PhoneMetadata> getMetadataList()
  {
    return this.metadata_;
  }

  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = paramObjectInput.readInt();
    for (int j = 0; j < i; j++)
    {
      Phonemetadata.PhoneMetadata localPhoneMetadata = new Phonemetadata.PhoneMetadata();
      localPhoneMetadata.readExternal(paramObjectInput);
      this.metadata_.add(localPhoneMetadata);
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    int i = getMetadataCount();
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      ((Phonemetadata.PhoneMetadata)this.metadata_.get(j)).writeExternal(paramObjectOutput);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection
 * JD-Core Version:    0.6.2
 */