public class PlayThatTune {

    public static void main(String[] args) {

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();

            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[n+1];
            for (int i = 0; i <= n; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }

            // play it using standard audio
            StdAudio.play(a);
        }
    }
}