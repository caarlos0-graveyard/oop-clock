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
package com.carlosbecker.clock.rest;

import com.carlosbecker.clock.Clock;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource for Clock.
 * @author Carlos Alexandro Becker (caarlos0@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Path("clock")
public class ClockResource {
    /**
     * Calculate the angle and return it.
     * @param hour Hour.
     * @param minute Minute.
     * @return JSON containing the calculated angle.
     * @checkstyle NonStaticMethodCheck (7 lines)
     */
    @GET
    @Path("/{hour : \\d+}/{minute : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public AngleDTO angle(
        @PathParam("hour") final int hour,
        @PathParam("minute") final int minute
    ) {
        return new AngleDTO(
            new Clock.Valid(new Clock.Smart(hour, minute)).angle().calculate()
        );
    }
}
