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

package ryey.easer.plugins.operation.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import ryey.easer.commons.C;
import ryey.easer.commons.IllegalStorageDataException;
import ryey.easer.plugins.operation.BooleanOperationData;

public class BluetoothOperationData extends BooleanOperationData {
    public BluetoothOperationData(Boolean state) {
        super(state);
    }

    BluetoothOperationData(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        super(data, format, version);
    }

    public static final Parcelable.Creator<BluetoothOperationData> CREATOR
            = new Parcelable.Creator<BluetoothOperationData>() {
        public BluetoothOperationData createFromParcel(Parcel in) {
            return new BluetoothOperationData(in);
        }

        public BluetoothOperationData[] newArray(int size) {
            return new BluetoothOperationData[size];
        }
    };

    private BluetoothOperationData(Parcel in) {
        super(in);
    }

}
