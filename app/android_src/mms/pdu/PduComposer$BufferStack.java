package android_src.mms.pdu;

import java.io.ByteArrayOutputStream;

class PduComposer$BufferStack
{
  int a = 0;
  private PduComposer.LengthRecordNode c = null;
  private PduComposer.LengthRecordNode d = null;

  private PduComposer$BufferStack(PduComposer paramPduComposer)
  {
  }

  void a()
  {
    if (this.d != null)
      throw new RuntimeException("BUG: Invalid newbuf() before copy()");
    PduComposer.LengthRecordNode localLengthRecordNode = new PduComposer.LengthRecordNode(null);
    localLengthRecordNode.a = this.b.a;
    localLengthRecordNode.b = this.b.b;
    localLengthRecordNode.c = this.c;
    this.c = localLengthRecordNode;
    this.a = (1 + this.a);
    this.b.a = new ByteArrayOutputStream();
    this.b.b = 0;
  }

  void b()
  {
    ByteArrayOutputStream localByteArrayOutputStream = this.b.a;
    int i = this.b.b;
    this.b.a = this.c.a;
    this.b.b = this.c.b;
    this.d = this.c;
    this.c = this.c.c;
    this.a = (-1 + this.a);
    this.d.a = localByteArrayOutputStream;
    this.d.b = i;
  }

  void c()
  {
    this.b.a(this.d.a.toByteArray(), 0, this.d.b);
    this.d = null;
  }

  PduComposer.PositionMarker d()
  {
    PduComposer.PositionMarker localPositionMarker = new PduComposer.PositionMarker(this.b, null);
    PduComposer.PositionMarker.a(localPositionMarker, this.b.b);
    PduComposer.PositionMarker.b(localPositionMarker, this.a);
    return localPositionMarker;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduComposer.BufferStack
 * JD-Core Version:    0.6.0
 */