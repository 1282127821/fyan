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

import jcmd.ParameterException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Convert a string into a URI.
 * 
 * @author samvv
 */
public class URLConverter extends BaseConverter<URL> {

	public URLConverter(String optionName) {
		super(optionName);
	}

	public URL convert(String value) {
		try {
			return new URL(value);
		} catch (MalformedURLException e) {
			throw new ParameterException(
					getErrorString(value, "a RFC 2396 and RFC 2732 compliant URL"));
			
		}
	}
}