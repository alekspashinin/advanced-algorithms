/**
 *
 *            L'Université Jean Monnet
 *
 *         Dimitrios Soupilas * Riad Lazli
 *         Erwan Le Cornec * Aleksei Pashinin
 *
 *           Projet Développement Web II
 *
 */
package advancedalgorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author alekspashinin
 */
public class AnimationController {

    private final List<AlphaRange> animationRanges;
    private Timer timer;
    private Long startTime;
    private final long runTime;

    public AnimationController(int runTime) {
        this.runTime = runTime;
        animationRanges = new ArrayList<>(100);
    }

    public void add(AlphaRange range) {
        animationRanges.add(range);
    }

    public void start() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime == null) {
                        startTime = System.currentTimeMillis();
                    }
                    long duration = System.currentTimeMillis() - startTime;
                    float progress = (float) duration / (float) runTime;
                    if (progress > 1f) {
                        progress = 1f;
                        stop();
                    }
                    for (AlphaRange range : animationRanges) {
                        range.update(progress);
                    }
                }
            });
            timer.start();

        } else {
            System.out.println("Erreur");
        }
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }

    public class AlphaRange {

        private final float from;
        private final float to;

        private final AlphaPane alphaPane;

        public AlphaRange(AlphaPane alphaPane, boolean fadeIn) {
            this.from = alphaPane.getAlpha();
            this.to = fadeIn ? 1f : 0f;
            this.alphaPane = alphaPane;
        }

        public float getFrom() {
            return from;
        }

        public float getTo() {
            return to;
        }

        public float getValueBasedOnProgress(float progress) {

            float value = 0;
            float distance = to - from;
            value = (distance * progress);
            value += from;

            return value;

        }

        public void update(float progress) {
            float alpha = getValueBasedOnProgress(progress);
            alphaPane.setAlpha(alpha);
        }

    }

}
