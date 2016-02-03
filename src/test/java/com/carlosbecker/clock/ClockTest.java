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

import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test cases for Clock.
 * @author Carlos Alexandro Becker (caarlos0@gmail.com)
 * @version $Id$
 * @since 0.1
 * @checkstyle MagicNumberCheck (200 lines)
 * @checkstyle MethodNameCheck (200 lines)
 */
@SuppressWarnings("PMD.TooManyMethods")
public final class ClockTest {
    /**
     * Clock should throw an exception if hour is not between 0 and 11.
     */
    @Test
    public void throwsExceptionWithIncorrectHour() {
        final String message = "Hour must be between";
        Assertions.assertThatThrownBy(() -> new Clock(-1, 0).angle())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
        Assertions.assertThatThrownBy(() -> new Clock(12, 0).angle())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }

    /**
     * Clock should throw an exception if minute is not between 0 and 59.
     */
    @Test
    public void throwsExceptionWithIncorrectMinute() {
        final String message = "Minute must be between";
        Assertions.assertThatThrownBy(() -> new Clock(1, -1).angle())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
        Assertions.assertThatThrownBy(() -> new Clock(1, 60).angle())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }

    /**
     * Clock should calculate the angle for 0:00.
     */
    @Test
    public void calculatesMidnight() {
        this.assertAngle(0, 0).isEqualTo(0);
    }

    /**
     * Clock should calculate the angle for 3:00.
     */
    @Test
    public void calculates3OClock() {
        this.assertAngle(3, 0).isEqualTo(90);
    }

    /**
     * Clock should calculate the angle for 6:00.
     */
    @Test
    public void calculates6OClock() {
        this.assertAngle(6, 0).isEqualTo(180);
    }

    /**
     * Clock should calculate the angle for 9:00.
     */
    @Test
    public void calculates9OClock() {
        this.assertAngle(9, 0).isEqualTo(90);
    }

    /**
     * Clock should calculate the angle for 2:20.
     */
    @Test
    public void calculates220() {
        this.assertAngle(2, 20).isEqualTo(50);
    }

    /**
     * Clock should calculate the angle for 5:24.
     */
    @Test
    public void calculates524() {
        this.assertAngle(5, 24).isEqualTo(18);
    }

    /**
     * Clock should calculate the angle for 9:45.
     */
    @Test
    public void calculates945() {
        this.assertAngle(9, 45).isEqualTo(23);
    }

    /**
     * Clock should calculate the angle for 11:20.
     */
    @Test
    public void calculates1120() {
        this.assertAngle(11, 20).isEqualTo(140);
    }

    /**
     * Clock should calculate the angle for 4:20.
     */
    @Test
    public void calculates420() {
        this.assertAngle(4, 20).isEqualTo(10);
    }

    /**
     * Helper method to assert an angle for a given hour and minute.
     * @param hour Hour.
     * @param minute Minute.
     * @return Assertion.
     */
    private AbstractIntegerAssert<?> assertAngle(
        final int hour, final int minute
    ) {
        return Assertions.assertThat(
            new Clock(hour, minute).angle().calculate()
        );
    }
}
