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
package com.carlosbecker;

/**
 * @author Carlos Alexandro Becker (caarlos0@gmail.com)
 */
public final class Angle {
    /**
     * The clock to use.
     */
    private final transient Clock clock;

    /**
     * Ctor.
     * @param clock Clock.
     */
    public Angle(final Clock clock) {
        this.clock = clock;
    }

    /**
     * Calculates the angle between the hour and minute pointers.
     * @return The angle between hour and minute pointers.
     */
    public int calculate() {
        int result = this.diff();
        if (result > 180) {
            result = 360 - result;
        }
        return result;
    }

    /**
     * Difference between the angles of the minute pointer and hour pointer to
     *  0.
     * @return Degrees difference.
     */
    private int diff() {
        return Math.abs(
            Math.subtractExact(
                new Degree.Minute(this.clock.minutes()).get(),
                new Degree.Hour(this.clock.hours(), this.clock.minutes()).get()
            )
        );
    }
}
