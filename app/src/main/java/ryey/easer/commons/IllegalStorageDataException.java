/*
 * Copyright (c) 2016 - 2018 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.commons;

public class IllegalStorageDataException extends Exception {

    public IllegalStorageDataException(String detailMessage) {
        super(detailMessage);
    }

    public IllegalStorageDataException(Exception e) {
        this(e.getMessage());
    }

    public IllegalStorageDataException(C.Format format) {
        super(String.format("Illegal %s data", format));
    }

    public IllegalStorageDataException(C.Format format, String field) {
        super(String.format("Illegal %s data: invalid field <%s>", format, field));
    }

    public IllegalStorageDataException(C.Format format, String field, String expected) {
        super(String.format("Illegal %s data: field <%s> doesn't have %s", format, field, expected));
    }
}
