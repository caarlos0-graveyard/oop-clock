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
public final class Clock {
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
    public Clock(final int hour, final int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Angle for this particular clock.
     * @return Angle instance.
     */
    public Angle angle() {
        this.validate();
        return new Angle(this);
    }

    /**
     * Minutes value.
     * @return Minutes.
     */
    public int minutes() {
        return this.minute;
    }

    /**
     * Hours value.
     * @return Hours.
     */
    public int hours() {
        return this.hour;
    }

    /**
     * Validates the input.
     * @checkstyle MagicNumberCheck (10 lines)
     */
    private void validate() {
        if (this.hour > 11 || this.hour < 0) {
            throw new IllegalArgumentException(
                "Hour must be between 0 and 11"
            );
        }
        if (this.minute > 59 || this.minute < 0) {
            throw new IllegalArgumentException(
                "Minute must be between 0 and 59"
            );
        }
    }
}
