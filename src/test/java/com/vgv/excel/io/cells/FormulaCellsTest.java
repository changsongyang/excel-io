/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Vedran Grgo Vatavuk
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
package com.vgv.excel.io.cells;

import com.jcabi.immutable.Array;
import com.vgv.excel.io.ECell;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link FormulaCells}.
 * @author Vedran Vatavuk (123vgv@gmail.com)
 * @version $Id$
 * @since 1.0
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class FormulaCellsTest {

    @Test
    public void createsMultipleNumberCells() {
        final int expected = 3;
        final String[] formulas = {"A+B", "A*B", "A-B"};
        final Array<ECell> cells = new FormulaCells(formulas).asArray();
        MatcherAssert.assertThat(
            cells.size(),
            Matchers.equalTo(expected)
        );
        MatcherAssert.assertThat(
            cells.get(0),
            Matchers.instanceOf(FormulaCell.class)
        );
    }

    @Test
    public void createsMultipleNumberCellsInPosition() {
        final int expected = 1;
        final Array<ECell> cells = new FormulaCells(2, "C+D").asArray();
        MatcherAssert.assertThat(
            cells.size(),
            Matchers.equalTo(expected)
        );
        MatcherAssert.assertThat(
            cells.get(0),
            Matchers.instanceOf(FormulaCell.class)
        );
    }
}
