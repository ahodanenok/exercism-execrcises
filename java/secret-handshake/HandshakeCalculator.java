import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Secret Handshake
 * https://exercism.org/tracks/java/exercises/secret-handshake
 */
class HandshakeCalculator {

    enum Signal {
        WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP
    }
  
    private static final int CODE_MASK         = 0x1F;
    private static final int WINK_MASK         = 0x1;
    private static final int DOUBLE_BLINK_MASK = 0x2;
    private static final int CLOSE_EYES_MASK   = 0x4;
    private static final int JUMP_MASK         = 0x8;
    private static final int REVERSE_MASK      = 0x10;

    List<Signal> calculateHandshake(int number) {
        int code = number & CODE_MASK;
        List<Signal> signals = new ArrayList<>();

        if ((code & WINK_MASK) != 0) {
            signals.add(Signal.WINK);
        }

        if ((code & DOUBLE_BLINK_MASK) != 0) {
            signals.add(Signal.DOUBLE_BLINK);
        }

        if ((code & CLOSE_EYES_MASK) != 0) {
            signals.add(Signal.CLOSE_YOUR_EYES);
        }

        if ((code & JUMP_MASK) != 0) {
            signals.add(Signal.JUMP);
        }

        if ((code & REVERSE_MASK) != 0) {
            Collections.reverse(signals);
        }

        return signals;
    }
}
