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

package ryey.easer.plugins.condition.connectivity;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;

import java.util.Set;

import ryey.easer.commons.C;
import ryey.easer.commons.IllegalStorageDataException;
import ryey.easer.commons.plugindef.ValidData;
import ryey.easer.commons.plugindef.conditionplugin.ConditionDataFactory;

class ConnectivityConditionDataFactory implements ConditionDataFactory<ConnectivityConditionData> {
    @NonNull
    @Override
    public Class<ConnectivityConditionData> dataClass() {
        return ConnectivityConditionData.class;
    }

    @ValidData
    @NonNull
    @Override
    public ConnectivityConditionData dummyData() {
        Set<Integer> data = new ArraySet<>();
        data.add(1);
        data.add(2);
        return new ConnectivityConditionData(data);
    }

    @ValidData
    @NonNull
    @Override
    public ConnectivityConditionData parse(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        return new ConnectivityConditionData(data, format, version);
    }
}
