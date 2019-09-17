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

package ryey.easer.plugins.operation.media_control;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Set;

import ryey.easer.commons.C;
import ryey.easer.commons.IllegalStorageDataException;
import ryey.easer.commons.plugindef.operationplugin.OperationData;

public class MediaControlOperationData implements OperationData {

    @Nullable
    @Override
    public Set<String> placeholders() {
        return null;
    }

    enum ControlChoice {
        play_pause,
        play,
        pause,
        previous,
        next,
    }

    ControlChoice choice = null;

    MediaControlOperationData(ControlChoice choice) {
        this.choice = choice;
    }

    MediaControlOperationData(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        parse(data, format, version);
    }

    public void parse(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        switch (format) {
            default:
                try {
                    this.choice = ControlChoice.valueOf(data);
                } catch (Exception e) {
                    throw new IllegalStorageDataException(e);
                }
        }
    }

    @NonNull
    @Override
    public String serialize(@NonNull C.Format format) {
        String res;
        switch (format) {
            default:
                res = choice.toString();
        }
        return res;
    }

    @SuppressWarnings({"SimplifiableIfStatement", "RedundantIfStatement"})
    @Override
    public boolean isValid() {
        if (choice == null)
            return false;
        return true;
    }

    @SuppressWarnings({"SimplifiableIfStatement", "RedundantIfStatement"})
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof MediaControlOperationData))
            return false;
        return choice == ((MediaControlOperationData) obj).choice;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(choice);
    }

    public static final Parcelable.Creator<MediaControlOperationData> CREATOR
            = new Parcelable.Creator<MediaControlOperationData>() {
        public MediaControlOperationData createFromParcel(Parcel in) {
            return new MediaControlOperationData(in);
        }

        public MediaControlOperationData[] newArray(int size) {
            return new MediaControlOperationData[size];
        }
    };

    private MediaControlOperationData(Parcel in) {
        choice = (ControlChoice) in.readSerializable();
    }
}
