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

package ryey.easer.commons.plugindef.conditionplugin;

import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;

import ryey.easer.commons.plugindef.PluginDef;
import ryey.easer.commons.plugindef.ValidData;

public interface ConditionPlugin<D extends ConditionData> extends PluginDef<D> {

    @NonNull
    ConditionDataFactory<D> dataFactory();

    @NonNull
    Tracker<D> tracker(@NonNull Context context, @ValidData @NonNull D data,
                       @NonNull PendingIntent event_positive,
                       @NonNull PendingIntent event_negative);

}
