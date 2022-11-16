import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class StreamsEquality {
    public static boolean contentEquals(InputStream input1, InputStream input2) throws IOException
    {
        if (!(input1 instanceof BufferedInputStream))
        {
            input1 = new BufferedInputStream(input1);
        }
        if (!(input2 instanceof BufferedInputStream))
        {
            input2 = new BufferedInputStream(input2);
        }

        int ch = input1.read();
        while (-1 != ch)
        {
            int ch2 = input2.read();
            if (ch != ch2)
            {
                return false;
            }
            ch = input1.read();
        }

        int ch2 = input2.read();
        return (ch2 == -1);
    }

    public static void main(String[] args) throws IOException {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        boolean b = StreamsEquality.contentEquals((InputStream) stream1, (InputStream) stream2);
        System.out.println(b);

    }
}
