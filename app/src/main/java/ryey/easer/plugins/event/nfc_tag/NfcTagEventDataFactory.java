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

package ryey.easer.plugins.event.nfc_tag;

import androidx.annotation.NonNull;

import ryey.easer.commons.C;
import ryey.easer.commons.IllegalStorageDataException;
import ryey.easer.commons.plugindef.ValidData;
import ryey.easer.commons.plugindef.eventplugin.EventDataFactory;

class NfcTagEventDataFactory implements EventDataFactory<NfcTagEventData> {
    @NonNull
    @Override
    public Class<NfcTagEventData> dataClass() {
        return NfcTagEventData.class;
    }

    @ValidData
    @NonNull
    @Override
    public NfcTagEventData dummyData() {
        NfcTagEventData dummyData = new NfcTagEventData();
        dummyData.id = new byte[]{1, 47, 92, 63};
        return dummyData;
    }

    @ValidData
    @NonNull
    @Override
    public NfcTagEventData parse(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        return new NfcTagEventData(data, format, version);
    }
}
