/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Carlos Alexandro Becker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.carlosbecker.clock;

/**
 * Main Clock class.
 * @author Carlos Alexandro Becker (caarlos0@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Clock {
    /**
     * Angle for this particular clock.
     * @return Angle instance.
     */
    Angle angle();

    /**
     * Hours value.
     * @return Hours.
     */
    int hours();

    /**
     * Minutes value.
     * @return Minutes.
     */
    int minutes();

    /**
     * Valid Clock implementation.
     */
    final class Valid implements Clock {
        /**
         * Clock.
         */
        private final transient Clock clock;

        /**
         * Ctor.
         * @param clock Clock.
         */
        Valid(final Clock clock) {
            this.clock = Clock.Valid.validate(clock);
        }

        @Override
        public Angle angle() {
            return this.clock.angle();
        }

        @Override
        public int hours() {
            return this.clock.hours();
        }

        @Override
        public int minutes() {
            return this.clock.minutes();
        }

        /**
         * Validates the input.
         * @param clock Clock.
         * @return Valid clock.
         * @checkstyle MagicNumberCheck (10 lines)
         */
        private static Clock validate(final Clock clock) {
            if (clock.hours() > 11 || clock.hours() < 0) {
                throw new IllegalArgumentException(
                    "Hour must be between 0 and 11"
                );
            }
            if (clock.minutes() > 59 || clock.minutes() < 0) {
                throw new IllegalArgumentException(
                    "Minute must be between 0 and 59"
                );
            }
            return clock;
        }
    }

    /**
     * Smart implementation of Clock.
     */
    final class Smart implements Clock {
        /**
         * Hour.
         */
        private final transient int hour;
        /**
         * Minute.
         */
        private final transient int minute;

        /**
         * Ctor.
         * @param hour Hour.
         * @param minute Minute.
         */
        Smart(final int hour, final int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public Angle angle() {
            return new Angle.Smart(this);
        }

        @Override
        public int minutes() {
            return this.minute;
        }

        @Override
        public int hours() {
            return this.hour;
        }
    }
}
