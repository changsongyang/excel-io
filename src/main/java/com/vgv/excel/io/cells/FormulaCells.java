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
import java.util.stream.Collectors;

/**
 * Multiples cells that hold formula values.
 * @author Vedran Vatavuk (123vgv@gmail.com)
 * @version $Id$
 * @since 0.3
 */
public final class FormulaCells extends AbstractStyleableCells {

    /**
     * Position of cells.
     */
    private final int position;

    /**
     * Array of formula values.
     */
    private final Array<String> formulas;

    /**
     * Ctor.
     * @param values Values
     */
    public FormulaCells(final String... values) {
        this(new Array<>(values));
    }

    /**
     * Ctor.
     * @param column Column
     * @param values Values
     */
    public FormulaCells(final int column, final String... values) {
        this(column, new Array<>(values));
    }

    /**
     * Ctor.
     * @param values Values
     */
    public FormulaCells(final Iterable<String> values) {
        this(-1, new Array<>(values));
    }

    /**
     * Ctor.
     * @param column Column
     * @param values Values
     */
    public FormulaCells(final int column, final Iterable<String> values) {
        super();
        this.position = column;
        this.formulas = new Array<>(values);
    }

    @Override
    public Array<ECell> asArray() {
        return new Array<>(this.formulas.stream()
            .map(formula -> new FormulaCell(this.position, formula))
            .collect(Collectors.toList())
        );
    }
}
