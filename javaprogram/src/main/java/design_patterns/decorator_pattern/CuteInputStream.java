package design_patterns.decorator_pattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * created by huyanshi on 2019/1/12
 */
public class CuteInputStream extends FilterInputStream {

  /**
   * Creates a <code>FilterInputStream</code> by assigning the  argument <code>in</code> to the
   * field
   * <code>this.in</code> so as to remember it for later use.
   *
   * @param in the underlying input stream, or <code>null</code> if this instance is to be created
   * without an underlying stream.
   */
  protected CuteInputStream(InputStream in) {
    super(in);
  }

  @Override
  public int read() throws IOException {
    int i = super.read();
    return Character.toLowerCase((char) i);
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int i = super.read(b, off, len);
    return Character.toLowerCase((char) i);
  }
}
