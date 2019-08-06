/*
 * MIT License
 *
 * Copyright (c) 2019 xubin zhao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package jcmd.converters;

import jcmd.IStringConverter;
import jcmd.internal.Lists;

import java.util.List;

/**
 * A converter to obtain a list of elements.
 * @param <T> the element type
 * @author simon04
 */
public class DefaultListConverter<T> implements IStringConverter<List<T>> {

  private final IParameterSplitter splitter;
  private final IStringConverter<T> converter;

  /**
   * Constructs a new converter.
   * @param splitter to split value into list of arguments
   * @param converter to convert list of arguments to target element type
   */
  public DefaultListConverter(IParameterSplitter splitter, IStringConverter<T> converter) {
    this.splitter = splitter;
    this.converter = converter;
  }

  @Override
  public List<T> convert(String value) {
    List<T> result = Lists.newArrayList();
    for (String param : splitter.split(value)) {
      result.add(converter.convert(param));
    }
    return result;
  }
}