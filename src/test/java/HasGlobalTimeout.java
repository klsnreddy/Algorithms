import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class HasGlobalTimeout {
  @Rule
  public Timeout globalTimeout = new Timeout(4, TimeUnit.SECONDS);

  @Test
  public void testInfiniteLoop() {
    for (;;) {
    }
  }

  @Test
  public synchronized void testInterruptableLock() throws InterruptedException {
    wait();
  }

  @Test
  public void testInterruptableIO() throws IOException {
    for (;;) {
      FileChannel channel = new RandomAccessFile(new File(""), "rw").getChannel();

      // Interrupted thread closes channel and throws ClosedByInterruptException.
      channel.write(ByteBuffer.allocate(2));
      channel.close();
    }
  }
}
